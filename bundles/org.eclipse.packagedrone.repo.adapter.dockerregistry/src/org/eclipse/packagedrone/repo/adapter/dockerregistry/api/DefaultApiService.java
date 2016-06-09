package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public abstract class DefaultApiService
{
    public abstract Response rootGet ( SecurityContext securityContext ) throws NotFoundException;
}
