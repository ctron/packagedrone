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

public class LayersFsLayers
{

    private String blobSum = null;

    /**
     **/
    public LayersFsLayers blobSum ( final String blobSum )
    {
        this.blobSum = blobSum;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "blobSum" )
    public String getBlobSum ()
    {
        return this.blobSum;
    }

    public void setBlobSum ( final String blobSum )
    {
        this.blobSum = blobSum;
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
        final LayersFsLayers layersFsLayers = (LayersFsLayers)o;
        return Objects.equals ( this.blobSum, layersFsLayers.blobSum );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.blobSum );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class LayersFsLayers {\n" );

        sb.append ( "    blobSum: " ).append ( toIndentedString ( this.blobSum ) ).append ( "\n" );
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
