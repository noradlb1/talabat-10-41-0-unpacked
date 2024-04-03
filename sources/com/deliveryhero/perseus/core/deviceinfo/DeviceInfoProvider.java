package com.deliveryhero.perseus.core.deviceinfo;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;", "", "deviceBrand", "", "getDeviceBrand", "()Ljava/lang/String;", "deviceInfo", "getDeviceInfo", "deviceModel", "getDeviceModel", "marketingName", "getMarketingName", "operatingSystemVersion", "getOperatingSystemVersion", "screenResolution", "getScreenResolution", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DeviceInfoProvider {
    @NotNull
    String getDeviceBrand();

    @NotNull
    String getDeviceInfo();

    @NotNull
    String getDeviceModel();

    @NotNull
    String getMarketingName();

    @NotNull
    String getOperatingSystemVersion();

    @NotNull
    String getScreenResolution();
}
