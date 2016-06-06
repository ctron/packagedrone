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
package org.eclipse.dockerregistry.utils;

public class ErrorCodes
{
    public static final String UNKNOWN = "UNKNOWN";

    public static final String UNSUPPORTED = "UNSUPPORTED";

    public static final String UNAUTHORIZED = "UNAUTHORIZED";

    public static final String DIGEST_INVALID = "DIGEST_INVALID";

    public static final String SIZE_INVALID = "SIZE_INVALID";

    public static final String TAG_INVALID = "TAG_INVALID";

    public static final String NAME_UNKNOWN = "NAME_UNKNOWN";

    public static final String MANIFEST_UNKNOWN = "MANIFEST_UNKNOWN";

    public static final String MANIFEST_INVALID = "MANIFEST_INVALID";

    public static final String MANIFEST_UNVERIFIED = "MANIFEST_UNVERIFIED";

    public static final String BLOB_UNKNOWN = "BLOB_UNKNOWN";

    public static final String BLOB_UPLOAD_UNKNOWN = "BLOB_UPLOAD_UNKNOWN";

    public static final String BLOB_UPLOAD_INVALID = "BLOB_UPLOAD_INVALID";

    public static final String NAME_INVALID = "NAME_INVALID";

    private ErrorCodes ()
    {
    }
}
