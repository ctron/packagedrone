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
package org.eclipse.packagedrone.repo.adapter.dockerregistry.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class InlineResponse200
{

    private Layers data = null;

    /**
     **/
    public InlineResponse200 data ( final Layers data )
    {
        this.data = data;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "data" )
    public Layers getData ()
    {
        return this.data;
    }

    public void setData ( final Layers data )
    {
        this.data = data;
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
        final InlineResponse200 inlineResponse200 = (InlineResponse200)o;
        return Objects.equals ( this.data, inlineResponse200.data );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.data );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class InlineResponse200 {\n" );

        sb.append ( "    data: " ).append ( toIndentedString ( this.data ) ).append ( "\n" );
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