package com.deliveryhero.customerchat.eventTracking.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;", "", "getDeviceManufacturer", "", "getDeviceName", "getDeviceOSVersion", "getHostAppIdentifier", "getHostAppVersion", "getSDKVersion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DeviceUtils {
    @NotNull
    String getDeviceManufacturer();

    @NotNull
    String getDeviceName();

    @NotNull
    String getDeviceOSVersion();

    @NotNull
    String getHostAppIdentifier();

    @NotNull
    String getHostAppVersion();

    @NotNull
    String getSDKVersion();
}
