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

public class ErrorErrors
{

    private String code = null;

    private String message = null;

    private String detail = null;

    /**
     **/
    public ErrorErrors code ( final String code )
    {
        this.code = code;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "code" )
    public String getCode ()
    {
        return this.code;
    }

    public void setCode ( final String code )
    {
        this.code = code;
    }

    /**
     **/
    public ErrorErrors message ( final String message )
    {
        this.message = message;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "message" )
    public String getMessage ()
    {
        return this.message;
    }

    public void setMessage ( final String message )
    {
        this.message = message;
    }

    /**
     **/
    public ErrorErrors detail ( final String detail )
    {
        this.detail = detail;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "detail" )
    public String getDetail ()
    {
        return this.detail;
    }

    public void setDetail ( final String detail )
    {
        this.detail = detail;
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
        final ErrorErrors errorErrors = (ErrorErrors)o;
        return Objects.equals ( this.code, errorErrors.code ) && Objects.equals ( this.message, errorErrors.message ) && Objects.equals ( this.detail, errorErrors.detail );
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash ( this.code, this.message, this.detail );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "class ErrorErrors {\n" );

        sb.append ( "    code: " ).append ( toIndentedString ( this.code ) ).append ( "\n" );
        sb.append ( "    message: " ).append ( toIndentedString ( this.message ) ).append ( "\n" );
        sb.append ( "    detail: " ).append ( toIndentedString ( this.detail ) ).append ( "\n" );
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
