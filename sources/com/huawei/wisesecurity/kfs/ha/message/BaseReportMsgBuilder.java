package com.huawei.wisesecurity.kfs.ha.message;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.LinkedHashMap;

public abstract class BaseReportMsgBuilder implements ReportMsgBuilder {
    public LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
    public long nanoCallTime;
    public int segCount = 6;
    public long segmentationStartTime;

    public LinkedHashMap<String, String> build() {
        return this.linkedHashMap;
    }

    public BaseReportMsgBuilder setApiName(String str) {
        this.linkedHashMap.put("apiName", str);
        return this;
    }

    public BaseReportMsgBuilder setAppId(String str) {
        this.linkedHashMap.put("appId", str);
        return this;
    }

    public BaseReportMsgBuilder setCallTime() {
        long nanoTime = System.nanoTime();
        this.nanoCallTime = nanoTime;
        this.segmentationStartTime = nanoTime;
        this.linkedHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
        return this;
    }

    public BaseReportMsgBuilder setCostTime() {
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf((System.nanoTime() - this.nanoCallTime) / 1000000));
        return this;
    }

    public BaseReportMsgBuilder setErrorMsg(String str) {
        this.linkedHashMap.put("errorMsg", str);
        return this;
    }

    public BaseReportMsgBuilder setInnerErrorCode(int i11) {
        this.linkedHashMap.put("innerErrorCode", String.valueOf(i11));
        return this;
    }

    public BaseReportMsgBuilder setInnerErrorMsg(String str) {
        this.linkedHashMap.put("innerErrorMsg", str);
        return this;
    }

    public BaseReportMsgBuilder setPackageName(String str) {
        this.linkedHashMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, str);
        return this;
    }

    public BaseReportMsgBuilder setSegT1CostTime() {
        this.linkedHashMap.put("t1", String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setSegT2CostTime() {
        this.linkedHashMap.put("t2", String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setSegT3CostTime() {
        this.linkedHashMap.put("t3", String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setSegT4CostTime() {
        this.linkedHashMap.put("t4", String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setSegT5CostTime() {
        this.linkedHashMap.put("t5", String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setSegTnCostTime() {
        LinkedHashMap<String, String> linkedHashMap2 = this.linkedHashMap;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("t");
        int i11 = this.segCount;
        this.segCount = i11 + 1;
        sb2.append(i11);
        linkedHashMap2.put(sb2.toString(), String.valueOf((System.nanoTime() - this.segmentationStartTime) / 1000000));
        this.segmentationStartTime = System.nanoTime();
        return this;
    }

    public BaseReportMsgBuilder setStatusCode(int i11) {
        this.linkedHashMap.put("statusCode", String.valueOf(i11));
        return this;
    }

    public BaseReportMsgBuilder setTransId(String str) {
        this.linkedHashMap.put("transId", str);
        return this;
    }

    public BaseReportMsgBuilder setVersion(String str) {
        this.linkedHashMap.put("version", str);
        return this;
    }
}
