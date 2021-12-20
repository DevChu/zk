/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zkoss.zel;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.zkoss.zel.impl.util.ClassUtil;

/**
 *
 * @since 2.1
 */
public abstract class ExpressionFactory {
    private static final CacheValue nullTcclFactory = new CacheValue();
    private static final ConcurrentMap<CacheKey, CacheValue> factoryCache =
            new ConcurrentHashMap<CacheKey, CacheValue>();
    private static final String FACTORY_IMPL_CLASSNAME =
            "org.zkoss.zel.impl.ExpressionFactoryImpl";

    /**
     * Create a new {@link ExpressionFactory}. The class to use is
     * org.zkoss.zel.impl.ExpressionFactoryImpl.
     *
     * @return the new ExpressionFactory
     */
    public static ExpressionFactory newInstance() {
        return newInstance(null);
    }

    /**
     * Create a new {@link ExpressionFactory} passing in the provided
     * {@link Properties}. Search order is the same as {@link #newInstance()}.
     *
     * @param properties the properties to be passed to the new instance (may be null)
     * @return the new ExpressionFactory
     */
    public static ExpressionFactory newInstance(Properties properties) {
        ExpressionFactory result = null;

        ClassLoader tccl = ClassUtil.getContextClassLoader(ExpressionFactory.class);

        CacheValue cacheValue;
        Class<?> clazz;

        if (tccl == null) {
            cacheValue = nullTcclFactory;
        } else {
            CacheKey key = new CacheKey(tccl);
            cacheValue = factoryCache.get(key);
            if (cacheValue == null) {
                CacheValue newCacheValue = new CacheValue();
                cacheValue = factoryCache.putIfAbsent(key, newCacheValue);
                if (cacheValue == null) {
                    cacheValue = newCacheValue;
                }
            }
        }

        final Lock readLock = cacheValue.getLock().readLock();
        readLock.lock();
        try {
            clazz = cacheValue.getFactoryClass();
        } finally {
            readLock.unlock();
        }

        if (clazz == null) {
            String className = null;
            try {
                final Lock writeLock = cacheValue.getLock().writeLock();
                writeLock.lock();
                try {
                    className = cacheValue.getFactoryClassName();
                    if (className == null) {
                        className = FACTORY_IMPL_CLASSNAME;
                        cacheValue.setFactoryClassName(className);
                    }
                    if (tccl == null) {
                        clazz = Class.forName(className);
                    } else {
                        clazz = tccl.loadClass(className);
                    }
                    cacheValue.setFactoryClass(clazz);
                } finally {
                    writeLock.unlock();
                }
            } catch (ClassNotFoundException e) {
                throw new ELException(
                    "Unable to find ExpressionFactory of type: " + className,
                    e);
            }
        }

        try {
            Constructor<?> constructor = null;
            // Do we need to look for a constructor that will take properties?
            if (properties != null) {
                try {
                    constructor = clazz.getConstructor(Properties.class);
                } catch (SecurityException se) {
                    throw new ELException(se);
                } catch (NoSuchMethodException nsme) {
                    // This can be ignored
                    // This is OK for this constructor not to exist
                }
            }
            if (constructor == null) {
                result = (ExpressionFactory) clazz.newInstance();
            } else {
                result =
                    (ExpressionFactory) constructor.newInstance(properties);
            }

        } catch (InstantiationException e) {
            throw new ELException(
                    "Unable to create ExpressionFactory of type: " + clazz.getName(),
                    e);
        } catch (IllegalAccessException e) {
            throw new ELException(
                    "Unable to create ExpressionFactory of type: " + clazz.getName(),
                    e);
        } catch (IllegalArgumentException e) {
            throw new ELException(
                    "Unable to create ExpressionFactory of type: " + clazz.getName(),
                    e);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            Util.handleThrowable(cause);
            throw new ELException(
                    "Unable to create ExpressionFactory of type: " + clazz.getName(),
                    e);
        }

        return result;
    }

    /**
     * Create a new value expression.
     *
     * @param context      The EL context for this evaluation
     * @param expression   The String representation of the value expression
     * @param expectedType The expected type of the result of evaluating the
     *                     expression
     *
     * @return A new value expression formed from the input parameters
     *
     * @throws NullPointerException
     *              If the expected type is <code>null</code>
     * @throws ELException
     *              If there are syntax errors in the provided expression
     */
    public abstract ValueExpression createValueExpression(ELContext context,
            String expression, Class<?> expectedType);

    public abstract ValueExpression createValueExpression(Object instance,
            Class<?> expectedType);

    /**
     * Create a new method expression instance.
     *
     * @param context            The EL context for this evaluation
     * @param expression         The String representation of the method
     *                           expression
     * @param expectedReturnType The expected type of the result of invoking the
     *                           method
     * @param expectedParamTypes The expected types of the input parameters
     *
     * @return A new method expression formed from the input parameters.
     *
     * @throws NullPointerException
     *              If the expected parameters types are <code>null</code>
     * @throws ELException
     *              If there are syntax errors in the provided expression
     */
    public abstract MethodExpression createMethodExpression(ELContext context,
            String expression, Class<?> expectedReturnType,
            Class<?>[] expectedParamTypes);

    /**
     * Coerce the supplied object to the requested type.
     *
     * @param obj          The object to be coerced
     * @param expectedType The type to which the object should be coerced
     *
     * @return An instance of the requested type.
     *
     * @throws ELException
     *              If the conversion fails
     */
    public abstract Object coerceToType(Object obj, Class<?> expectedType);

    /**
     * @return This default implementation returns null
     *
     * @since EL 3.0
     */
    public ELResolver getStreamELResolver() {
        return null;
    }

    /**
     * @return This default implementation returns null
     *
     * @since EL 3.0
     */
    public Map<String, Method> getInitFunctionMap() {
        return null;
    }

    /**
     * Key used to cache ExpressionFactory discovery information per class
     * loader. The class loader reference is never {@code null}, because
     * {@code null} tccl is handled separately.
     */
    private static class CacheKey {
        private final int hash;
        private final WeakReference<ClassLoader> ref;

        public CacheKey(ClassLoader cl) {
            hash = cl.hashCode();
            ref = new WeakReference<ClassLoader>(cl);
        }

        
        public int hashCode() {
            return hash;
        }

        
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            ClassLoader thisCl = ref.get();
            if (thisCl == null) {
                return false;
            }
            return thisCl == ((CacheKey) obj).ref.get();
        }
    }

    private static class CacheValue {
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private String className;
        private WeakReference<Class<?>> ref;

        public CacheValue() {
        }

        public ReadWriteLock getLock() {
            return lock;
        }

        public String getFactoryClassName() {
            return className;
        }

        public void setFactoryClassName(String className) {
            this.className = className;
        }

        public Class<?> getFactoryClass() {
            return ref != null ? ref.get() : null;
        }

        public void setFactoryClass(Class<?> clazz) {
            ref = new WeakReference<Class<?>>(clazz);
        }
    }
}
