/* JsMapContentTypeFilter.java

    Purpose:
                
    Description:
            
    History:
       Mon May 19 11:38:11 CST 2025, Created by jameschu

Copyright (C) 2025 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.http;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "*.js.map")
public class ZK5889JsMapContentTypeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// Set the correct Content-Type for .js.map files
		System.out.printf("%s , response content type: %s\n", httpRequest.getRequestURI(), httpResponse.getContentType());
		chain.doFilter(request, response); // Continue the filter chain
	}

	@Override
	public void destroy() {
	}
}