package org.junit.platform.engine.discovery;

import j$.util.Optional;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class ClasspathResourceSelector implements DiscoverySelector {
    private final String classpathResourceName;
    private final FilePosition position;

    public ClasspathResourceSelector(String str, FilePosition filePosition) {
        this.classpathResourceName = str.startsWith("/") ? str.substring(1) : str;
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
        ClasspathResourceSelector classpathResourceSelector = (ClasspathResourceSelector) obj;
        if (!Objects.equals(this.classpathResourceName, classpathResourceSelector.classpathResourceName) || !Objects.equals(this.position, classpathResourceSelector.position)) {
            return false;
        }
        return true;
    }

    public String getClasspathResourceName() {
        return this.classpathResourceName;
    }

    public Optional<FilePosition> getPosition() {
        return Optional.ofNullable(this.position);
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return Objects.hash(new Object[]{this.classpathResourceName, this.position});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("classpathResourceName", this.classpathResourceName).append("position", this.position).toString();
    }
}
