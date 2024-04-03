package com.deliveryhero.customerchat.eventTracking.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.deliveryhero.customerchat.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtilsImpl;", "Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDeviceManufacturer", "", "getDeviceName", "getDeviceOSVersion", "getHostAppIdentifier", "getHostAppVersion", "getSDKVersion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceUtilsImpl implements DeviceUtils {
    @NotNull
    private final Context context;

    public DeviceUtilsImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public String getDeviceManufacturer() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return str;
    }

    @NotNull
    public String getDeviceName() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    @NotNull
    public String getDeviceOSVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    @NotNull
    public String getHostAppIdentifier() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return packageName;
    }

    @NotNull
    public String getHostAppVersion() {
        String str;
        try {
            str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "appVersion");
        return str;
    }

    @NotNull
    public String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
