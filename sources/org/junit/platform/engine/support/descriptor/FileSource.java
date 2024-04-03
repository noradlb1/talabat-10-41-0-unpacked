package org.junit.platform.engine.support.descriptor;

import j$.util.Optional;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class FileSource implements FileSystemSource {
    private static final long serialVersionUID = 1;
    private final File file;
    private final FilePosition filePosition;

    private FileSource(File file2) {
        this(file2, (FilePosition) null);
    }

    public static FileSource from(File file2) {
        return new FileSource(file2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileSource fileSource = (FileSource) obj;
        if (!Objects.equals(this.file, fileSource.file) || !Objects.equals(this.filePosition, fileSource.filePosition)) {
            return false;
        }
        return true;
    }

    public final File getFile() {
        return this.file;
    }

    public final Optional<FilePosition> getPosition() {
        return Optional.ofNullable(this.filePosition);
    }

    public final URI getUri() {
        return getFile().toURI();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.file, this.filePosition});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("file", this.file).append("filePosition", this.filePosition).toString();
    }

    private FileSource(File file2, FilePosition filePosition2) {
        Preconditions.notNull(file2, "file must not be null");
        try {
            this.file = file2.getCanonicalFile();
            this.filePosition = filePosition2;
        } catch (IOException e11) {
            throw new JUnitException("Failed to retrieve canonical path for file: " + file2, e11);
        }
    }

    public static FileSource from(File file2, FilePosition filePosition2) {
        return new FileSource(file2, filePosition2);
    }
}
