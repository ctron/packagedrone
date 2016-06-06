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

public class Tags
{

    private String name = null;

    private List<String> tags = new ArrayList<String> ();

    /**
     **/
    public Tags name ( final String name )
    {
        this.name = name;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "name" )
    public String getName ()
    {
        return this.name;
    }

    public void setName ( final String name )
    {
        this.name = name;
    }

    /**
     **/
    public Tags tags ( final List<String> tags )
    {
        this.tags = tags;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "tags" )
    public List<String> getTags ()
    {
        return this.tags;
    }

    public void setTags ( final List<String> tags )
    {
        this.tags = tags;
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
        final Tags tags = (Tags)o;
        return Objects.equals ( this.name, tags.name ) && Objects.equals ( this.tags, tags.tags );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.name, this.tags );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class Tags {\n" );

        sb.append ( "    name: " ).append ( toIndentedString ( this.name ) ).append ( "\n" );
        sb.append ( "    tags: " ).append ( toIndentedString ( this.tags ) ).append ( "\n" );
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
