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

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;

public class Bootstrap extends HttpServlet
{
    @Override
    public void init ( final ServletConfig config ) throws ServletException
    {
        final Info info = new Info ().title ( "Docker Registry HTTP API v2" ).description ( "" ).termsOfService ( "" ).contact ( new Contact ().email ( "" ) ).license ( new License ().name ( "" ).url ( "" ) );

        final ServletContext context = config.getServletContext ();
        final Swagger swagger = new Swagger ().info ( info );

        new SwaggerContextService ().withServletConfig ( config ).updateSwagger ( swagger );
    }
}
