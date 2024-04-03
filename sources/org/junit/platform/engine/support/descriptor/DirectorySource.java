package org.junit.platform.engine.support.descriptor;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class DirectorySource implements FileSystemSource {
    private static final long serialVersionUID = 1;
    private final File directory;

    private DirectorySource(File file) {
        Preconditions.notNull(file, "directory must not be null");
        try {
            this.directory = file.getCanonicalFile();
        } catch (IOException e11) {
            throw new JUnitException("Failed to retrieve canonical path for directory: " + file, e11);
        }
    }

    public static DirectorySource from(File file) {
        return new DirectorySource(file);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.directory.equals(((DirectorySource) obj).directory);
    }

    public final File getFile() {
        return this.directory;
    }

    public final URI getUri() {
        return getFile().toURI();
    }

    public int hashCode() {
        return this.directory.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("directory", this.directory).toString();
    }
}
