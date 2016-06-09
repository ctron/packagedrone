package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

public class ApiException extends Exception
{
    private final int code;

    public ApiException ( final int code, final String msg )
    {
        super ( msg );
        this.code = code;
    }
}
