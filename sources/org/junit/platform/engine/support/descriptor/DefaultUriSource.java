package org.junit.platform.engine.support.descriptor;

import java.net.URI;
import java.util.Objects;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

class DefaultUriSource implements UriSource {
    private static final long serialVersionUID = 1;
    private final URI uri;

    public DefaultUriSource(URI uri2) {
        this.uri = (URI) Preconditions.notNull(uri2, "URI must not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.uri, ((DefaultUriSource) obj).uri);
    }

    public URI getUri() {
        return this.uri;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("uri", this.uri).toString();
    }
}
