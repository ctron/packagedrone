package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ApiOriginFilter implements javax.servlet.Filter
{
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

    public void init ( final FilterConfig filterConfig ) throws ServletException
    {
    }
}
