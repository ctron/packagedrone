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
