package org.eclipse.packagedrone.repo.adapter.dockerregistry.api;

public class NotFoundException extends ApiException
{
    private final int code;

    public NotFoundException ( final int code, final String msg )
    {
        super ( code, msg );
        this.code = code;
    }
}
