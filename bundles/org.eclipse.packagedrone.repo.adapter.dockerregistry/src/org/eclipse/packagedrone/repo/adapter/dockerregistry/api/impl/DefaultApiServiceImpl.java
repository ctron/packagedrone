package org.eclipse.packagedrone.repo.adapter.dockerregistry.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.DefaultApiService;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.NotFoundException;

public class DefaultApiServiceImpl extends DefaultApiService
{
    @Override
    public Response rootGet ( final SecurityContext securityContext ) throws NotFoundException
    {
        return Response.ok ().header ( "Docker-Distribution-API-Version", "registry/2.0" ).build ();
    }
}
