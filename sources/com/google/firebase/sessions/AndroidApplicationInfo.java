package com.google.firebase.sessions;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/AndroidApplicationInfo;", "", "packageName", "", "versionName", "appBuildVersion", "deviceManufacturer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppBuildVersion", "()Ljava/lang/String;", "getDeviceManufacturer", "getPackageName", "getVersionName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidApplicationInfo {
    @NotNull
    private final String appBuildVersion;
    @NotNull
    private final String deviceManufacturer;
    @NotNull
    private final String packageName;
    @NotNull
    private final String versionName;

    public AndroidApplicationInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "versionName");
        Intrinsics.checkNotNullParameter(str3, "appBuildVersion");
        Intrinsics.checkNotNullParameter(str4, AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE);
        this.packageName = str;
        this.versionName = str2;
        this.appBuildVersion = str3;
        this.deviceManufacturer = str4;
    }

    public static /* synthetic */ AndroidApplicationInfo copy$default(AndroidApplicationInfo androidApplicationInfo, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = androidApplicationInfo.packageName;
        }
        if ((i11 & 2) != 0) {
            str2 = androidApplicationInfo.versionName;
        }
        if ((i11 & 4) != 0) {
            str3 = androidApplicationInfo.appBuildVersion;
        }
        if ((i11 & 8) != 0) {
            str4 = androidApplicationInfo.deviceManufacturer;
        }
        return androidApplicationInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final String component2() {
        return this.versionName;
    }

    @NotNull
    public final String component3() {
        return this.appBuildVersion;
    }

    @NotNull
    public final String component4() {
        return this.deviceManufacturer;
    }

    @NotNull
    public final AndroidApplicationInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "versionName");
        Intrinsics.checkNotNullParameter(str3, "appBuildVersion");
        Intrinsics.checkNotNullParameter(str4, AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE);
        return new AndroidApplicationInfo(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        return Intrinsics.areEqual((Object) this.packageName, (Object) androidApplicationInfo.packageName) && Intrinsics.areEqual((Object) this.versionName, (Object) androidApplicationInfo.versionName) && Intrinsics.areEqual((Object) this.appBuildVersion, (Object) androidApplicationInfo.appBuildVersion) && Intrinsics.areEqual((Object) this.deviceManufacturer, (Object) androidApplicationInfo.deviceManufacturer);
    }

    @NotNull
    public final String getAppBuildVersion() {
        return this.appBuildVersion;
    }

    @NotNull
    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return (((((this.packageName.hashCode() * 31) + this.versionName.hashCode()) * 31) + this.appBuildVersion.hashCode()) * 31) + this.deviceManufacturer.hashCode();
    }

    @NotNull
    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.packageName + ", versionName=" + this.versionName + ", appBuildVersion=" + this.appBuildVersion + ", deviceManufacturer=" + this.deviceManufacturer + ')';
    }
}
