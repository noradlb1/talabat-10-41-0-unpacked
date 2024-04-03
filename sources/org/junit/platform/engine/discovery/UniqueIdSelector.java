package org.junit.platform.engine.discovery;

import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.UniqueId;

@API(since = "1.0", status = API.Status.STABLE)
public class UniqueIdSelector implements DiscoverySelector {
    private final UniqueId uniqueId;

    public UniqueIdSelector(UniqueId uniqueId2) {
        this.uniqueId = uniqueId2;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.uniqueId, ((UniqueIdSelector) obj).uniqueId);
    }

    public UniqueId getUniqueId() {
        return this.uniqueId;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.uniqueId.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("uniqueId", this.uniqueId).toString();
    }
}
