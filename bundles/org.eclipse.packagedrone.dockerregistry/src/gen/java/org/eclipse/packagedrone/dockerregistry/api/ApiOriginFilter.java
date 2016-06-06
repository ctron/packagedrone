/*******************************************************************************
 * Copyright (c) 2016 Pubudu Fernando and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pubudu Fernando - initial API and implementation
 *******************************************************************************/
package org.eclipse.packagedrone.dockerregistry.api;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ApiOriginFilter implements javax.servlet.Filter
{
    @Override
    public void doFilter ( final ServletRequest request, final ServletResponse response, final FilterChain chain ) throws IOException, ServletException
    {
        final HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader ( "Access-Control-Allow-Origin", "*" );
        res.addHeader ( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        res.addHeader ( "Access-Control-Allow-Headers", "Content-Type" );
        chain.doFilter ( request, response );
    }

    @Override
    public void destroy ()
    {
    }

    @Override
    public void init ( final FilterConfig filterConfig ) throws ServletException
    {
    }
}
