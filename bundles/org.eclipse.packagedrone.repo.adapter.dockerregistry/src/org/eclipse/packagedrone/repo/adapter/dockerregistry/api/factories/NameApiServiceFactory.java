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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.api.factories;

import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.NameApiService;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.api.impl.NameApiServiceImpl;

public class NameApiServiceFactory
{
    private final static NameApiService service = new NameApiServiceImpl ();

    public static NameApiService getNameApi ()
    {
        return service;
    }
}
