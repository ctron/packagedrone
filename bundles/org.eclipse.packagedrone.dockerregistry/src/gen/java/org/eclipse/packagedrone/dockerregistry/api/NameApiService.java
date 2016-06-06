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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public abstract class NameApiService
{
    public abstract Response nameBlobsDigestGet ( String name, String digest, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsDigestHead ( String name, String digest, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsUploadsPost ( String name, String digest, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsUploadsUuidDelete ( String name, String uuid, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsUploadsUuidGet ( String name, String uuid, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsUploadsUuidPatch ( String name, String uuid, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameBlobsUploadsUuidPut ( String name, String uuid, String digest, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameManifestsReferenceDelete ( String name, String reference, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameManifestsReferenceGet ( String name, String reference, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameManifestsReferencePut ( String name, String reference, SecurityContext securityContext ) throws NotFoundException;

    public abstract Response nameTagsListGet ( String name, SecurityContext securityContext ) throws NotFoundException;
}
