package org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.drivers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.FileInfo;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.storage.StorageDriver;
import org.eclipse.packagedrone.repo.channel.ChannelService;
import org.eclipse.packagedrone.repo.channel.ChannelService.By;
import org.eclipse.packagedrone.repo.channel.ModifiableChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageDroneStorageDriver implements StorageDriver
{

    private static final PackageDroneStorageDriver driver = new PackageDroneStorageDriver ();

    private final static Logger logger = LoggerFactory.getLogger ( PackageDroneStorageDriver.class );

    private final String name = "Package Drone Storage Driver";

    private final ServiceTracker<ChannelService, ChannelService> tracker;

    private PackageDroneStorageDriver ()
    {
        final BundleContext context = FrameworkUtil.getBundle ( getClass () ).getBundleContext ();
        this.tracker = new ServiceTracker<> ( context, ChannelService.class, null );
        this.tracker.open ();
    }

    public static PackageDroneStorageDriver getInstance ()
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
        final ChannelService service = this.tracker.getService ();
        logger.info ( "Channel Service info: " + service.toString () );
        service.accessRun ( By.name ( name ), ModifiableChannel.class, channel -> {
            logger.info ( "Channel accessed" + service.toString () );
        } );
        return null;
    }

    @Override
    public InputStream getInputStreamForBlob ( final String name, final String digest ) throws IOException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStreamForBlobUpload ( final String name, final String uuid ) throws IOException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Writer getWriterForManifests ( final String name, final String reference )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutputStream getOutputStreamForBlobPostUpload ( final String name, final String digest ) throws IOException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Writer getWriterForBlobUploadUuid ( final String name, final String uuid )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FileInfo getManifestStats ( final Path path )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getTags ( final String name )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean move ( final Path sourcePath, final Path destinationPath )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete ( final Path path )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean repositoryExists ( final String name )
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public URL urlFor ( final Path path, final Map<String, String> options )
    {
        // TODO Auto-generated method stub
        return null;
    }

}
