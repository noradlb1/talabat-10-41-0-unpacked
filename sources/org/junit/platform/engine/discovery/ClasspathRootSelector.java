package org.junit.platform.engine.discovery;

import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class ClasspathRootSelector implements DiscoverySelector {
    private final URI classpathRoot;

    public ClasspathRootSelector(URI uri) {
        this.classpathRoot = uri;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.classpathRoot, ((ClasspathRootSelector) obj).classpathRoot);
    }

    public URI getClasspathRoot() {
        return this.classpathRoot;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.classpathRoot.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("classpathRoot", this.classpathRoot).toString();
    }
}
