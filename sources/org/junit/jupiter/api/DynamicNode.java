package org.junit.jupiter.api;

import com.visa.checkout.Profile;
import j$.util.Optional;
import java.net.URI;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "5.3", status = API.Status.MAINTAINED)
public abstract class DynamicNode {
    private final String displayName;
    private final URI testSourceUri;

    public DynamicNode(String str, URI uri) {
        this.displayName = Preconditions.notBlank(str, "displayName must not be null or blank");
        this.testSourceUri = uri;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Optional<URI> getTestSourceUri() {
        return Optional.ofNullable(this.testSourceUri);
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(Profile.DISPLAY_NAME, this.displayName).append("testSourceUri", this.testSourceUri).toString();
    }
}
