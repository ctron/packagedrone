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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Digest
{

    private Digest ()
    {
    }

    public static String getDigest ( final String msg, final String algorithm ) throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance ( algorithm );
        final Formatter formatter = new Formatter ();
        byte buf[];

        md.update ( msg.getBytes () );
        buf = md.digest ();

        for ( final byte b : buf )
        {
            formatter.format ( "%02x", b );
        }

        return formatter.toString ();
    }
}
