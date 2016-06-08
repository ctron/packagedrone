package org.eclipse.packagedrone.dockerregistry.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class Activator implements BundleActivator
{
    private final List<ServiceRegistration> registrations = new ArrayList<> ();

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        configureSwagger ( context );
        this.registrations.add ( context.registerService ( DefaultApi.class.getName (), new DefaultApi (), null ) );
        this.registrations.add ( context.registerService ( NameApi.class.getName (), new NameApi (), null ) );
    }

    private void configureSwagger ( final BundleContext context ) throws IOException
    {
        final ServiceReference reference = context.getServiceReference ( ConfigurationAdmin.class.getName () );
        final ConfigurationAdmin configAdmin = (ConfigurationAdmin)context.getService ( reference );
        final Configuration configuration = configAdmin.getConfiguration ( "com.eclipsesource.jaxrs.swagger.config", null );

        final Dictionary<String, Object> properties = new Hashtable<> ();

        properties.put ( "swagger.basePath", "/v2" );
        properties.put ( "swagger.host", "localhost:9090" );

        configuration.update ( properties );
        context.ungetService ( reference );
    }

    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        for ( final ServiceRegistration serviceRegistration : this.registrations )
        {
            serviceRegistration.unregister ();
        }
    }
}
