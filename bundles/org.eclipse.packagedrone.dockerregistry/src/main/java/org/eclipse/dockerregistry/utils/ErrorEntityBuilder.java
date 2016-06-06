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
package org.eclipse.dockerregistry.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.packagedrone.dockerregistry.models.Error;
import org.eclipse.packagedrone.dockerregistry.models.ErrorErrors;

public class ErrorEntityBuilder
{
    public static Error buildError ( final String errorCode, final String message, final String details )
    {
        final ErrorErrors errorDetails = new ErrorErrors ().code ( errorCode ).message ( message ).detail ( details );

        final List<ErrorErrors> errorsList = new ArrayList<> ();

        errorsList.add ( errorDetails );

        return new Error ().errors ( errorsList );
    }
}
