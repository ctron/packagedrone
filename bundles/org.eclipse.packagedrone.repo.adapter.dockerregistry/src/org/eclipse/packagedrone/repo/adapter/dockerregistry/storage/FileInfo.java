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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.storage;

public class FileInfo
{
    private final String filename;

    private final String path;

    private final long size;

    private final String createdDate;

    public FileInfo ( final String filename, final String path, final long size, final String createdDate )
    {
        this.filename = filename;
        this.path = path;
        this.size = size;
        this.createdDate = createdDate;
    }

    public String getFilename ()
    {
        return this.filename;
    }

    public String getPath ()
    {
        return this.path;
    }

    public long getSize ()
    {
        return this.size;
    }

    public String getCreatedDate ()
    {
        return this.createdDate;
    }
}
