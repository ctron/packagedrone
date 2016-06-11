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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.utils;

import java.io.IOException;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class RootConfigurator
{
    public void bindConfigurationAdmin ( final ConfigurationAdmin config ) throws IOException
    {
        final Configuration cfg = config.getConfiguration ( "com.eclipsesource.jaxrs.connector", "?" );

        final Hashtable<String, Object> data = new Hashtable<> ();
        data.put ( "root", "/v2" );

        cfg.update ( data );
    }
}
