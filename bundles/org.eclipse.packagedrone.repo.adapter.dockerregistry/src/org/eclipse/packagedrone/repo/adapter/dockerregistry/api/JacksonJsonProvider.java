package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import io.swagger.util.Json;

@Provider
@Produces ( { MediaType.APPLICATION_JSON } )
public class JacksonJsonProvider extends JacksonJaxbJsonProvider
{
    private static ObjectMapper commonMapper = Json.mapper ();

    public JacksonJsonProvider ()
    {
        super.setMapper ( commonMapper );
    }
}
