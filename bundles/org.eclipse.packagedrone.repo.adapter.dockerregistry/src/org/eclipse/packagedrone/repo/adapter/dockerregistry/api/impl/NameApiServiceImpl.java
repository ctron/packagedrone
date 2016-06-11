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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.ApiResponseMessage;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.NameApiService;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.NotFoundException;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.models.Error;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.models.Tags;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.StorageDriver;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.drivers.FileSystemStorageDriver;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.utils.Digest;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.utils.DockerMediaTypes;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.utils.ErrorCodes;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.utils.ErrorEntityBuilder;

public class NameApiServiceImpl extends NameApiService
{
    //    private static final Logger logger = LoggerFactory.getLogger ( NameApiServiceImpl.class );

    @Override
    public Response nameBlobsDigestGet ( final String name, final String digest, final SecurityContext securityContext ) throws NotFoundException
    {

        if ( !isValidNamespace ( name ) )
        {
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.NAME_INVALID, "invalid repository name", "" );
            return Response.status ( Response.Status.BAD_REQUEST ).entity ( error ).build ();
        }

        final StorageDriver driver = FileSystemStorageDriver.getInstance ();

        if ( !driver.repositoryExists ( name ) )
        {
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.NAME_UNKNOWN, "Repository name not known to registry", "" );

            return Response.status ( Response.Status.NOT_FOUND ).entity ( error ).build ();
        }

        try
        {
            final InputStream input = driver.getInputStreamForBlob ( name, digest );
            return Response.ok ( input, MediaType.APPLICATION_OCTET_STREAM ).header ( "Docker-Content-Digest", digest ).build ();
        }
        catch ( final IOException e )
        {
            e.printStackTrace ();
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.BLOB_UNKNOWN, "blob unknown to registry", "" );

            return Response.status ( Response.Status.NOT_FOUND ).entity ( error ).build ();
        }
    }

    @Override
    public Response nameBlobsDigestHead ( final String name, final String digest, final SecurityContext securityContext ) throws NotFoundException
    {
        return null;
    }

    /*    if (!isValidNamespace(name))
            return Response.status(Response.Status.BAD_REQUEST).build();

        StorageDriver driver = FileSystemStorageDriver.getInstance();

        if (!driver.repositoryExists(name))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            InputStream input = driver.getInputStreamForBlob(name, digest);
            long contentLength = 0;

            while (input.read() != -1)
                contentLength++;

            Logger log = LoggerFactory.getLogger(this.getClass());
            log.info("Content Length: " + contentLength);
            return Response.ok(MediaType.APPLICATION_OCTET_STREAM)
                    .header("Docker-Content-Digest", digest)
                    .header("Content-Length", contentLength).build();

        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }*/

    @Override
    public Response nameBlobsUploadsPost ( final String name, final String digest, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameBlobsUploadsUuidDelete ( final String name, final String uuid, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameBlobsUploadsUuidGet ( final String name, final String uuid, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameBlobsUploadsUuidPatch ( final String name, final String uuid, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameBlobsUploadsUuidPut ( final String name, final String uuid, final String digest, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameManifestsReferenceDelete ( final String name, final String reference, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameManifestsReferenceGet ( final String name, final String reference, final SecurityContext securityContext ) throws NotFoundException
    {

        if ( !isValidNamespace ( name ) )
        {
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.NAME_INVALID, "invalid repository name", "" );
            //            logger.error ( ErrorCodes.NAME_INVALID );
            return Response.status ( Response.Status.BAD_REQUEST ).entity ( error ).build ();
        }

        final StorageDriver driver = FileSystemStorageDriver.getInstance ();

        if ( !driver.repositoryExists ( name ) )
        {
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.NAME_UNKNOWN, "Repository name not known to registry", "" );
            //            logger.error ( ErrorCodes.NAME_UNKNOWN );

            return Response.status ( Response.Status.NOT_FOUND ).entity ( error ).build ();
        }

        try
        {
            final InputStream input = driver.getInputStreamForManifest ( name, reference );
            String manifest = readStream ( input );

            manifest = cleanupString ( manifest );
            final String digest = "sha256:" + Digest.getDigest ( manifest, "SHA-256" );

            //            logger.info ( "Manifest found for reference: " + reference );
            //            logger.info ( "Digest for the manifest: " + "sha256:" + digest );

            return Response.ok ( manifest, DockerMediaTypes.SCHEMA2 ).header ( "Docker-Content-Digest", digest ).build ();
        }
        catch ( final IOException e )
        {
            e.printStackTrace ();
            final Error error = ErrorEntityBuilder.buildError ( ErrorCodes.BLOB_UNKNOWN, "blob unknown to registry", "" );
            //            logger.error ( ErrorCodes.BLOB_UNKNOWN );

            return Response.status ( Response.Status.NOT_FOUND ).entity ( error ).build ();
        }
        catch ( final NoSuchAlgorithmException e )
        {
            e.printStackTrace ();
            return Response.status ( Response.Status.NOT_FOUND ).build ();
        }
    }

    @Override
    public Response nameManifestsReferencePut ( final String name, final String reference, final SecurityContext securityContext ) throws NotFoundException
    {
        // do some magic!
        return Response.ok ().entity ( new ApiResponseMessage ( ApiResponseMessage.OK, "magic!" ) ).build ();
    }

    @Override
    public Response nameTagsListGet ( final String name, final SecurityContext securityContext ) throws NotFoundException
    {
        final StorageDriver driver = FileSystemStorageDriver.getInstance (); // TODO: Set this to be taken from a config file
        final List<String> tags = driver.getTags ( name );

        final Tags entity = new Tags ().name ( name ).tags ( tags );

        return Response.ok ().entity ( entity ).build ();
    }

    private boolean isValidNamespace ( final String path )
    {
        final Pattern pattern = Pattern.compile ( "^([A-Za-z0-9._s-]+)+$" );
        return pattern.matcher ( path ).matches ();
    }

    private String readStream ( final InputStream input ) throws IOException
    {
        final ByteArrayOutputStream output = new ByteArrayOutputStream ();
        final byte buffer[] = new byte[1024];
        int bytesRead;

        while ( ( bytesRead = input.read ( buffer ) ) != -1 )
        {
            output.write ( buffer, 0, bytesRead );
        }

        return output.toString ();
    }

    private String cleanupString ( final String str )
    {
        String cleaned = str.trim ();

        for ( int i = cleaned.length () - 1; cleaned.charAt ( i ) == '\n'; i-- )
        {
            cleaned = cleaned.substring ( 0, cleaned.length () - 1 );
        }

        return cleaned;
    }
}
