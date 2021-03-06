/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.packagedrone;

import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;

public final class VersionInformation
{
    /**
     * The product version as string
     */
    public static final String VERSION;

    /**
     * The product version as unqualified string
     * <p>
     * This is the same version string as {@link #VERSION} but without the build
     * qualifier (4th component).
     * </p>
     */
    public static final String VERSION_UNQUALIFIED;

    /**
     * The name of the product.
     * <p>
     * This is "Eclipse Package Drone".
     * </p>
     */
    public static final String PRODUCT = "Eclipse Package Drone";

    /**
     * The product name in combination with the version
     * <p>
     * This is {@code PRODUCT + " " + VERSION}
     * </p>
     */
    public static final String VERSIONED_PRODUCT;

    /**
     * A string which can be used as HTTP user agent
     * <p>
     * It contains the product name in a suitable format, the URL and the
     * unqualified version.
     * </p>
     */
    public static final String USER_AGENT;

    private VersionInformation ()
    {
    }

    static
    {
        final Version version = FrameworkUtil.getBundle ( VersionInformation.class ).getVersion ();
        VERSION = version.toString ();
        VERSION_UNQUALIFIED = new Version ( version.getMajor (), version.getMinor (), version.getMicro () ).toString ();

        VERSIONED_PRODUCT = PRODUCT + " " + VERSION;

        USER_AGENT = String.format ( "PackageDrone/%s (+http://packagedrone.org)", VersionInformation.VERSION_UNQUALIFIED );
    }
}
