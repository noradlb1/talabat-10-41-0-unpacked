package org.junit.platform.engine.discovery;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class DirectorySelector implements DiscoverySelector {
    private final String path;

    public DirectorySelector(String str) {
        this.path = str;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.path, ((DirectorySelector) obj).path);
    }

    public File getDirectory() {
        return new File(this.path);
    }

    public Path getPath() {
        return Paths.get(this.path, new String[0]);
    }

    public String getRawPath() {
        return this.path;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.path.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("path", this.path).toString();
    }
}
