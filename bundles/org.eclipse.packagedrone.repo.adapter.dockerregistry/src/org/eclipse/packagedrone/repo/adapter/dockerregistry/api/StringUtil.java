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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

public class StringUtil
{
    /**
     * Check if the given array contains the given value (with case-insensitive
     * comparison).
     *
     * @param array
     *            The array
     * @param value
     *            The value to search
     * @return true if the array contains the value
     */
    public static boolean containsIgnoreCase ( final String[] array, final String value )
    {
        for ( final String str : array )
        {
            if ( value == null && str == null )
            {
                return true;
            }
            if ( value != null && value.equalsIgnoreCase ( str ) )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Join an array of strings with the given separator.
     * <p>
     * Note: This might be replaced by utility method from commons-lang or guava
     * someday
     * if one of those libraries is added as dependency.
     * </p>
     *
     * @param array
     *            The array of strings
     * @param separator
     *            The separator
     * @return the resulting string
     */
    public static String join ( final String[] array, final String separator )
    {
        final int len = array.length;
        if ( len == 0 )
        {
            return "";
        }

        final StringBuilder out = new StringBuilder ();
        out.append ( array[0] );
        for ( int i = 1; i < len; i++ )
        {
            out.append ( separator ).append ( array[i] );
        }
        return out.toString ();
    }
}
