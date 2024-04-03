package org.junit.platform.engine.discovery;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class PackageSelector implements DiscoverySelector {
    private final String packageName;

    public PackageSelector(String str) {
        this.packageName = str;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.packageName, ((PackageSelector) obj).packageName);
    }

    public String getPackageName() {
        return this.packageName;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.packageName.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, this.packageName).toString();
    }
}
