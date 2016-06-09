package org.eclipse.packagedrone.repo.adapter.dockerregistry.storage;

public class FileInfo
{
    private final String filename;

    private final String path;

    private final long size;

    private final String createdDate;

    public FileInfo ( final String filename, final String path, final long size, final String createdDate )
    {
        this.filename = filename;
        this.path = path;
        this.size = size;
        this.createdDate = createdDate;
    }

    public String getFilename ()
    {
        return this.filename;
    }

    public String getPath ()
    {
        return this.path;
    }

    public long getSize ()
    {
        return this.size;
    }

    public String getCreatedDate ()
    {
        return this.createdDate;
    }
}
