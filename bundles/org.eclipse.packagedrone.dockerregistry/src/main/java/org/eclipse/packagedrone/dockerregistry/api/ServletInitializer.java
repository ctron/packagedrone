package org.eclipse.packagedrone.dockerregistry.api;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;

//import org.eclipse.packagedrone.repo.adapter.docker.internal.Bootstrap;
import org.eclipse.packagedrone.web.util.Servlets;
import org.ops4j.pax.web.service.WebContainer;

public class ServletInitializer
{
    private WebContainer webContainer;

    private Bootstrap servlet;

    public void setWebContainer ( final WebContainer webContainer )
    {
        this.webContainer = webContainer;
    }

    public void start () throws ServletException
    {
        this.servlet = new Bootstrap ();

        final MultipartConfigElement mp = Servlets.createMultiPartConfiguration ( "drone.docker.servlet" );
        this.webContainer.registerServlet ( this.servlet, "docker", new String[] { "/v2/*" }, null, 1, false, mp, null );
    }

    public void stop ()
    {
        this.webContainer.unregisterServlet ( this.servlet );
        this.servlet = null;
    }
}
