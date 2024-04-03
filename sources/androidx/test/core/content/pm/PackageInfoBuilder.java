package androidx.test.core.content.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;

public final class PackageInfoBuilder {
    @Nullable
    private ApplicationInfo applicationInfo;
    @Nullable
    private String packageName;

    private PackageInfoBuilder() {
    }

    public static PackageInfoBuilder newBuilder() {
        return new PackageInfoBuilder();
    }

    public PackageInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = this.packageName;
        if (this.applicationInfo == null) {
            this.applicationInfo = ApplicationInfoBuilder.newBuilder().setPackageName(this.packageName).build();
        }
        ApplicationInfo applicationInfo2 = this.applicationInfo;
        packageInfo.applicationInfo = applicationInfo2;
        Checks.checkState(packageInfo.packageName.equals(applicationInfo2.packageName), "Field 'packageName' must match field 'applicationInfo.packageName'");
        return packageInfo;
    }

    public PackageInfoBuilder setApplicationInfo(ApplicationInfo applicationInfo2) {
        this.applicationInfo = applicationInfo2;
        return this;
    }

    public PackageInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }
}
