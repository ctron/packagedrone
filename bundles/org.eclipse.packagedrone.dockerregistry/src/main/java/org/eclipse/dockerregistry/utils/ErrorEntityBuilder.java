package org.eclipse.dockerregistry.utils;


import org.eclipse.packagedrone.dockerregistry.models.Error;
import org.eclipse.packagedrone.dockerregistry.models.ErrorErrors;

import java.util.ArrayList;
import java.util.List;

public class ErrorEntityBuilder {
    public static Error buildError(String errorCode, String message, String details) {
        ErrorErrors errorDetails = new ErrorErrors()
                                        .code(errorCode)
                                        .message(message)
                                        .detail(details);

        List<ErrorErrors> errorsList = new ArrayList<>();

        errorsList.add(errorDetails);

        return new Error().errors(errorsList);
    }
}
