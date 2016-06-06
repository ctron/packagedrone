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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.packagedrone.dockerregistry.api.factories.DefaultApiServiceFactory;

@Path ( "/" )

@io.swagger.annotations.Api ( description = "the  API" )

public class DefaultApi
{
    private final DefaultApiService delegate = DefaultApiServiceFactory.getDefaultApi ();

    @GET

    @io.swagger.annotations.ApiOperation ( value = "",
            notes = "Tells whether this Docker Registry instance supports Docker Registry HTTP API v2",
            response = void.class,
            tags = {} )
    @io.swagger.annotations.ApiResponses ( value = { @io.swagger.annotations.ApiResponse ( code = 200,
            message = "Successful response. API v2 supported",
            response = void.class ),

            @io.swagger.annotations.ApiResponse ( code = 401, message = "Unauthorized access", response = void.class ),

            @io.swagger.annotations.ApiResponse ( code = 404,
                    message = "Registry does not implement v2 of the API",
                    response = void.class ) } )
    public Response rootGet ( @Context final SecurityContext securityContext ) throws NotFoundException
    {
        return this.delegate.rootGet ( securityContext );
    }
}
