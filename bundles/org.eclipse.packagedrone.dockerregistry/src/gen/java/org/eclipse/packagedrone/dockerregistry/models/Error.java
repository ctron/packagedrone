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
package org.eclipse.packagedrone.dockerregistry.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Error
{

    private List<ErrorErrors> errors = new ArrayList<ErrorErrors> ();

    /**
     **/
    public Error errors ( final List<ErrorErrors> errors )
    {
        this.errors = errors;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "errors" )
    public List<ErrorErrors> getErrors ()
    {
        return this.errors;
    }

    public void setErrors ( final List<ErrorErrors> errors )
    {
        this.errors = errors;
    }

    @Override
    public boolean equals ( final Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass () != o.getClass () )
        {
            return false;
        }
        final Error error = (Error)o;
        return Objects.equals ( this.errors, error.errors );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.errors );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class Error {\n" );

        sb.append ( "    errors: " ).append ( toIndentedString ( this.errors ) ).append ( "\n" );
        sb.append ( "}" );
        return sb.toString ();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString ( final Object o )
    {
        if ( o == null )
        {
            return "null";
        }
        return o.toString ().replace ( "\n", "\n    " );
    }
}
