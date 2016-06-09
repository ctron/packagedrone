package org.eclipse.packagedrone.repo.adapter.dockerregistry.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.packagedrone.repo.adapter.dockerregistry.models.Error;
import org.eclipse.packagedrone.repo.adapter.dockerregistry.models.ErrorErrors;

public class ErrorEntityBuilder
{
    public static Error buildError ( final String errorCode, final String message, final String details )
    {
        final ErrorErrors errorDetails = new ErrorErrors ().code ( errorCode ).message ( message ).detail ( details );

        final List<ErrorErrors> errorsList = new ArrayList<> ();

        errorsList.add ( errorDetails );

        return new Error ().errors ( errorsList );
    }
}
