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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.drivers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemPathBuilder
{
    private final String rootPath;

    private final Path registryRoot; // Represents the root directory of the Registry storage

    private final Path blobs; // Represents the <registryRoot>/blobs directory

    private final Path repositories; // Represents the <registryRoot>/repositories directory

    public FileSystemPathBuilder ( final Path registryRoot, final Path blobs, final Path repositories )
    {
        //        registryRoot = Paths.get(rootPath);
        //        blobs = Paths.get(rootPath, "blobs");
        //        repositories = Paths.get(rootPath, "repositories");
        this.registryRoot = registryRoot;
        this.blobs = blobs;
        this.repositories = repositories;
        this.rootPath = registryRoot.toString ();
    }

    public Path getPathForManifest ( final String name, final String digest )
    {
        return Paths.get ( this.repositories.toString (), name, "manifests/revisions/sha256", digest );
    }

    public Path getPathForManifestByTag ( final String name, final String tag )
    {
        return Paths.get ( this.repositories.toString (), name, "manifests/tags", tag, "current/link" );
    }

    public Path getPathForLayer ( final String name, final String digest )
    {
        return Paths.get ( this.repositories.toString (), name, "layers/sha256", digest );
    }

    public Path createPathForBlob ( final String name, final String digest ) throws IOException
    {
        final Path path = Paths.get ( this.blobs.toString (), "sha256", digest.substring ( 0, 2 ), digest );

        if ( Files.exists ( path ) )
        {
            return Paths.get ( path.toString (), "data" );
        }
        else
        {
            return Paths.get ( Files.createDirectories ( path ).toString (), "data" );
        }
    }

    public Path getPathForBlob ( final String name, final String digest )
    {
        return Paths.get ( this.blobs.toString (), "sha256", digest.substring ( 0, 2 ), digest, "data" );
    }

    public Path getPathForTagsList ( final String name )
    {
        return Paths.get ( this.repositories.toString (), name, "manifests/tags" );
    }
}
