package org.junit.platform.engine.discovery;

import j$.util.Optional;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class FileSelector implements DiscoverySelector {
    private final String path;
    private final FilePosition position;

    public FileSelector(String str, FilePosition filePosition) {
        this.path = str;
        this.position = filePosition;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileSelector fileSelector = (FileSelector) obj;
        if (!Objects.equals(this.path, fileSelector.path) || !Objects.equals(this.position, fileSelector.position)) {
            return false;
        }
        return true;
    }

    public File getFile() {
        return new File(this.path);
    }

    public Path getPath() {
        return Paths.get(this.path, new String[0]);
    }

    public Optional<FilePosition> getPosition() {
        return Optional.ofNullable(this.position);
    }

    public String getRawPath() {
        return this.path;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return Objects.hash(new Object[]{this.path, this.position});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("path", this.path).append("position", this.position).toString();
    }
}
