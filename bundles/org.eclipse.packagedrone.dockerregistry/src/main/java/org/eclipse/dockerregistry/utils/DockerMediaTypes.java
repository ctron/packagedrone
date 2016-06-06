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
package org.eclipse.dockerregistry.utils;

public class DockerMediaTypes
{
    public static final String SCHEMA1 = "application/vnd.docker.distribution.manifest.v1+json";

    public static final String SCHEMA2 = "application/vnd.docker.distribution.manifest.v2+json";

    public static final String MANIFEST_LIST = "application/vnd.docker.distribution.manifest.list.v2+json";

    public static final String LAYER = "application/vnd.docker.image.rootfs.diff.tar.gzip";

    public static final String CONTAINER_CONFIG = "application/vnd.docker.container.image.v1+json";

    private DockerMediaTypes ()
    {
    }
}
