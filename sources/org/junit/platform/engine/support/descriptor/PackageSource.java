package org.junit.platform.engine.support.descriptor;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;

@API(since = "1.0", status = API.Status.STABLE)
public class PackageSource implements TestSource {
    private static final long serialVersionUID = 1;
    private final String packageName;

    private PackageSource(Package packageR) {
        this(((Package) Preconditions.notNull(packageR, "package must not be null")).getName());
    }

    public static PackageSource from(Package packageR) {
        return new PackageSource(packageR);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.packageName, ((PackageSource) obj).packageName);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, this.packageName).toString();
    }

    private PackageSource(String str) {
        this.packageName = Preconditions.notBlank(str, "package name must not be null or blank");
    }

    public static PackageSource from(String str) {
        return new PackageSource(str);
    }
}
