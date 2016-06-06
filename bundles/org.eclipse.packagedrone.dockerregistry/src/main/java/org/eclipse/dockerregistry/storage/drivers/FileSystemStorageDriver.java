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
package org.eclipse.dockerregistry.storage.drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.dockerregistry.storage.FileInfo;
import org.eclipse.dockerregistry.storage.StorageDriver;

/**
 * An implementation of the Storage Driver interface to provide support for file
 * system storage
 * for the Docker Registry.
 */
public class FileSystemStorageDriver implements StorageDriver
{
    private static final org.eclipse.dockerregistry.storage.drivers.FileSystemStorageDriver driver = new org.eclipse.dockerregistry.storage.drivers.FileSystemStorageDriver ();

    private final String name = "File System Storage Driver";

    private final String rootPath = "/home/pubudu/gsoc/docker/registry/v2/"; //TODO: Make this configurable through the yaml file

    private final Path registryRoot; // Represents the root directory of the Registry storage

    private final Path blobs; // Represents the <registryRoot>/blobs directory

    private final Path repositories; // Represents the <registryRoot>/repositories directory

    private final FileSystemPathBuilder pathBuilder;

    private FileSystemStorageDriver ()
    {
        this.registryRoot = Paths.get ( this.rootPath );
        this.blobs = Paths.get ( this.rootPath, "blobs" );
        this.repositories = Paths.get ( this.rootPath, "repositories" );
        this.pathBuilder = new FileSystemPathBuilder ( this.registryRoot, this.blobs, this.repositories );
        //TODO: Create the storage layout on disk
    }

    public static org.eclipse.dockerregistry.storage.drivers.FileSystemStorageDriver getInstance ()
    {
        return driver;
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

    @Override
    public InputStream getInputStreamForManifest ( final String name, final String reference ) throws IOException
    {
        Path manifestPath = this.pathBuilder.getPathForManifest ( name, reference );
        File manifestFile = manifestPath.toFile ();

        if ( manifestFile.exists () && reference.length () == 64 )
        {
            final Path manifestBlobPath = this.pathBuilder.getPathForBlob ( name, reference );
            final File manifestBlob = manifestBlobPath.toFile ();
            return new FileInputStream ( manifestBlob );
        }

        manifestPath = this.pathBuilder.getPathForManifestByTag ( name, reference );
        manifestFile = manifestPath.toFile ();

        if ( manifestFile.exists () )
        {
            final BufferedReader fileStream = new BufferedReader ( new FileReader ( manifestFile ) );
            final String digest = fileStream.readLine ().split ( ":" )[1];

            final Path manifestBlobPath = this.pathBuilder.getPathForBlob ( name, digest );
            final File manifestBlob = manifestBlobPath.toFile ();
            return new FileInputStream ( manifestBlob );
        }
        else
        {
            throw new FileNotFoundException ( "Requested repository path not found: " + manifestFile );
        }
    }

    @Override
    public InputStream getInputStreamForBlob ( final String name, final String digest ) throws IOException
    {
        final Path repoPath = this.pathBuilder.getPathForLayer ( name, digest );
        final File file = repoPath.toFile ();

        if ( file.exists () )
        {
            final Path blobPath = this.pathBuilder.getPathForBlob ( name, digest );
            final File blob = blobPath.toFile ();

            return new FileInputStream ( blob );
        }
        else
        {
            throw new FileNotFoundException ( "Requested repository path not found: " + file );
        }
    }

    @Override
    public InputStream getInputStreamForBlobUpload ( final String name, final String uuid ) throws IOException
    {
        return null;
    }

    @Override
    public Writer getWriterForManifests ( final String name, final String reference )
    {
        return null;
    }

    @Override
    public Writer getWriterForBlobPostUpload ( final String name, final String digest )
    {
        return null;
    }

    @Override
    public Writer getWriterForBlobUploadUuid ( final String name, final String uuid )
    {
        return null;
    }

    @Override
    public FileInfo getManifestStats ( final Path path )
    {
        return null;
    }

    public FileWriter getWriter ( final Path path, final boolean append )
    {
        return null;
    }

    public FileInfo getStats ( final Path path )
    {
        return null;
    }

    @Override
    public List<String> getTags ( final String name )
    {
        final Path path = this.pathBuilder.getPathForTagsList ( name );
        final File[] tagFiles = path.toFile ().listFiles ( File::isDirectory );
        final List<String> tags = new ArrayList<> ();

        for ( final File tagFile : tagFiles )
        {
            tags.add ( tagFile.getName () );
        }
        return tags;
    }

    @Override
    public boolean move ( final Path sourcePath, final Path destinationPath )
    {
        return false;
    }

    @Override
    public boolean delete ( final Path path )
    {
        return false;
    }

    @Override
    public boolean repositoryExists ( final String name )
    {
        final Path path = Paths.get ( this.repositories.toString (), name );
        return path.toFile ().exists ();
    }

    @Override
    public URL urlFor ( final Path path, final Map<String, String> options )
    {
        throw new UnsupportedOperationException ();
    }
}
