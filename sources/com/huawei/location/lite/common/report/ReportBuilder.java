package com.huawei.location.lite.common.report;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.TelephonyUtil;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.LinkedHashMap;
import tracking.ScreenNames;

public class ReportBuilder {
    protected static final String CLOUD_FENCE_TYPE = "3";
    protected static final String CP_SDK_TYPE = "1";
    protected static final String FULL_SDK_TYPE = "4";
    protected static final String OPEN_SDK_TYPE = "2";
    private static final String ROM_CN_HW = "1003";
    private static final String ROM_G_ABROAD = "1002";
    private static final String ROM_HW_PAD = "1100";
    private static final String ROM_HW_WATCH = "1200";
    private static final String ROM_NOG_ABROAD = "1001";
    private static final String ROM_NO_HW = "2001";
    private long callTime;
    private String eventId;
    protected LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

    public ReportBuilder() {
        setBrand();
        setManufacturer();
        setCallTime();
        setWifiEnable();
        setService("hwLocation");
        setNetworkType(NetworkUtil.getNetworkState());
        setMCC(TelephonyUtil.getMcc());
        setLocationSdkType("4");
        setLBSVersionCode(APKUtil.getLBSVersionCode());
        setRomType(getRomType());
        setPackage(ContextUtil.getContext().getPackageName());
        setVersion(String.valueOf(20700300));
    }

    public LinkedHashMap<String, String> build() {
        return this.linkedHashMap;
    }

    public String getEventId() {
        return this.eventId;
    }

    public final String getRomType() {
        return ROMUtil.isHuaweiPlatformDevice() ? DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) == 1 ? ROM_HW_PAD : DeviceInfoUtil.isHuaweiWatch() ? ROM_HW_WATCH : ROMUtil.isChineseRom() ? ROM_CN_HW : ROMUtil.isGmsRom() ? ROM_G_ABROAD : ROM_NOG_ABROAD : ROM_NO_HW;
    }

    public final ReportBuilder setApiName(String str) {
        this.linkedHashMap.put("apiName", str);
        this.eventId = str;
        return this;
    }

    public final ReportBuilder setAppID(String str) {
        this.linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str);
        return this;
    }

    public final ReportBuilder setBrand() {
        this.linkedHashMap.put(ScreenNames.SCREEN_TYPE_BRAND, DeviceInfoUtil.getBrand());
        return this;
    }

    public final ReportBuilder setCallTime() {
        long currentTimeMillis = System.currentTimeMillis();
        this.linkedHashMap.put("callTime", String.valueOf(currentTimeMillis));
        this.callTime = currentTimeMillis;
        return this;
    }

    public final ReportBuilder setCostTime() {
        long currentTimeMillis = System.currentTimeMillis() - this.callTime;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(currentTimeMillis));
        return this;
    }

    public final ReportBuilder setCpAppVersion(String str) {
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_APP_VERSION, str);
        return this;
    }

    public final ReportBuilder setErrorCode(String str) {
        this.linkedHashMap.put("errorCode", str);
        return this;
    }

    public final ReportBuilder setErrorMessage(String str) {
        this.linkedHashMap.put("errorMessage", str);
        return this;
    }

    public final ReportBuilder setExt(String str) {
        this.linkedHashMap.put("ext", str);
        return this;
    }

    public final ReportBuilder setLBSVersionCode(long j11) {
        LinkedHashMap<String, String> linkedHashMap2 = this.linkedHashMap;
        linkedHashMap2.put("lbs_version", j11 + "");
        return this;
    }

    public final ReportBuilder setLocationEnable(boolean z11) {
        if (!z11) {
            this.linkedHashMap.put("locEnable", "false");
        }
        return this;
    }

    public final ReportBuilder setLocationSdkType(String str) {
        this.linkedHashMap.put("lcSdkType", str);
        return this;
    }

    public final ReportBuilder setMCC(String str) {
        this.linkedHashMap.put("MCC", str);
        return this;
    }

    public final ReportBuilder setManufacturer() {
        this.linkedHashMap.put("pub_mfc", DeviceInfoUtil.getManufacturer());
        return this;
    }

    public final ReportBuilder setModuleName(String str) {
        this.linkedHashMap.put("module", str);
        return this;
    }

    public final ReportBuilder setNetworkType(String str) {
        this.linkedHashMap.put("networkType", str);
        return this;
    }

    public final ReportBuilder setOperator(String str) {
        this.linkedHashMap.put("operator", str);
        return this;
    }

    public final ReportBuilder setPackage(String str) {
        this.linkedHashMap.put("package", str);
        return this;
    }

    public final ReportBuilder setRequestUrl(String str) {
        this.linkedHashMap.put(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, str);
        return this;
    }

    public final ReportBuilder setResult(String str) {
        this.linkedHashMap.put("result", str);
        return this;
    }

    public final ReportBuilder setRomType(String str) {
        this.linkedHashMap.put("rom_type", str);
        return this;
    }

    public final ReportBuilder setService(String str) {
        this.linkedHashMap.put("service", str);
        return this;
    }

    public final ReportBuilder setSrc(String str) {
        this.linkedHashMap.put("src", str);
        return this;
    }

    public final ReportBuilder setTag(String str) {
        this.linkedHashMap.put("tag", str);
        return this;
    }

    public final ReportBuilder setTransactionID(String str) {
        this.linkedHashMap.put("transId", str);
        return this;
    }

    public final ReportBuilder setVersion(String str) {
        this.linkedHashMap.put("version", str);
        return this;
    }

    public final ReportBuilder setWLANScan() {
        if (!TelephonyUtil.checkWLANScan(ContextUtil.getContext())) {
            this.linkedHashMap.put("WLANScan", "false");
        }
        return this;
    }

    public final ReportBuilder setWifiEnable() {
        if (!TelephonyUtil.checkWifiIsEnable(ContextUtil.getContext())) {
            this.linkedHashMap.put("wifiEnable", "false");
        }
        return this;
    }
}
