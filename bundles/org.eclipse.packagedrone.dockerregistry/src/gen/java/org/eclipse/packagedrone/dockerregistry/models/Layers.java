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

public class Layers
{

    private String name = null;

    private String tag = null;

    private List<LayersFsLayers> fsLayers = new ArrayList<LayersFsLayers> ();

    private String history = null;

    private String signature = null;

    /**
     **/
    public Layers name ( final String name )
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
    public Layers tag ( final String tag )
    {
        this.tag = tag;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "tag" )
    public String getTag ()
    {
        return this.tag;
    }

    public void setTag ( final String tag )
    {
        this.tag = tag;
    }

    /**
     **/
    public Layers fsLayers ( final List<LayersFsLayers> fsLayers )
    {
        this.fsLayers = fsLayers;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "fsLayers" )
    public List<LayersFsLayers> getFsLayers ()
    {
        return this.fsLayers;
    }

    public void setFsLayers ( final List<LayersFsLayers> fsLayers )
    {
        this.fsLayers = fsLayers;
    }

    /**
     **/
    public Layers history ( final String history )
    {
        this.history = history;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "history" )
    public String getHistory ()
    {
        return this.history;
    }

    public void setHistory ( final String history )
    {
        this.history = history;
    }

    /**
     **/
    public Layers signature ( final String signature )
    {
        this.signature = signature;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "signature" )
    public String getSignature ()
    {
        return this.signature;
    }

    public void setSignature ( final String signature )
    {
        this.signature = signature;
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
        final Layers layers = (Layers)o;
        return Objects.equals ( this.name, layers.name ) && Objects.equals ( this.tag, layers.tag ) && Objects.equals ( this.fsLayers, layers.fsLayers ) && Objects.equals ( this.history, layers.history ) && Objects.equals ( this.signature, layers.signature );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.name, this.tag, this.fsLayers, this.history, this.signature );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class Layers {\n" );

        sb.append ( "    name: " ).append ( toIndentedString ( this.name ) ).append ( "\n" );
        sb.append ( "    tag: " ).append ( toIndentedString ( this.tag ) ).append ( "\n" );
        sb.append ( "    fsLayers: " ).append ( toIndentedString ( this.fsLayers ) ).append ( "\n" );
        sb.append ( "    history: " ).append ( toIndentedString ( this.history ) ).append ( "\n" );
        sb.append ( "    signature: " ).append ( toIndentedString ( this.signature ) ).append ( "\n" );
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
