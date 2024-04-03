package com.deliveryhero.perseus.core.deviceinfo;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProviderImpl;", "Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;", "()V", "deviceBrand", "", "getDeviceBrand", "()Ljava/lang/String;", "deviceInfo", "getDeviceInfo", "deviceModel", "getDeviceModel", "marketingName", "getMarketingName", "operatingSystemVersion", "getOperatingSystemVersion", "screenResolution", "getScreenResolution", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceInfoProviderImpl implements DeviceInfoProvider {
    @NotNull
    public String getDeviceBrand() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return str;
    }

    @NotNull
    public String getDeviceInfo() {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf(Build.BRAND, Build.DEVICE, Build.MODEL), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @NotNull
    public String getDeviceModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    @NotNull
    public String getMarketingName() {
        String str = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
        return str;
    }

    @NotNull
    public String getOperatingSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    @NotNull
    public String getScreenResolution() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(displayMetrics.heightPixels);
        sb2.append('x');
        sb2.append(displayMetrics.widthPixels);
        return sb2.toString();
    }
}
