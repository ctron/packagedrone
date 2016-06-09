package org.eclipse.packagedrone.repo.adapter.dockerregistry.utils;

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
