package androidx.test.core.content.pm;

import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;

public final class ApplicationInfoBuilder {
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f37685name;
    @Nullable
    private String packageName;

    private ApplicationInfoBuilder() {
    }

    public static ApplicationInfoBuilder newBuilder() {
        return new ApplicationInfoBuilder();
    }

    public ApplicationInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.name = this.f37685name;
        applicationInfo.packageName = this.packageName;
        return applicationInfo;
    }

    public ApplicationInfoBuilder setName(@Nullable String str) {
        this.f37685name = str;
        return this;
    }

    public ApplicationInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }
}
