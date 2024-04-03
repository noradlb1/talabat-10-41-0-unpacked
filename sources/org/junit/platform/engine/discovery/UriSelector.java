package org.junit.platform.engine.discovery;

import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class UriSelector implements DiscoverySelector {
    private final URI uri;

    public UriSelector(URI uri2) {
        this.uri = uri2;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.uri, ((UriSelector) obj).uri);
    }

    public URI getUri() {
        return this.uri;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("uri", this.uri).toString();
    }
}
