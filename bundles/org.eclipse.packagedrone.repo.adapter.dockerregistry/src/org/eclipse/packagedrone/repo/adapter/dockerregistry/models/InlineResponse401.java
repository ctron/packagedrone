package org.eclipse.packagedrone.repo.adapter.dockerregistry.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class InlineResponse401
{

    private Error data = null;

    /**
     **/
    public InlineResponse401 data ( final Error data )
    {
        this.data = data;
        return this;
    }

    @ApiModelProperty ( value = "" )
    @JsonProperty ( "data" )
    public Error getData ()
    {
        return this.data;
    }

    public void setData ( final Error data )
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
        final InlineResponse401 inlineResponse401 = (InlineResponse401)o;
        return Objects.equals ( this.data, inlineResponse401.data );
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
        sb.append ( "class InlineResponse401 {\n" );

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
