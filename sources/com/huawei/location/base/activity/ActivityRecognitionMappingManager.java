package com.huawei.location.base.activity;

import android.os.SystemClock;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityRecognitionMappingManager {
    private static final String TAG = "ActivityRecognitionMappingManager";
    private List<ActivityRecognitionMappingInfo> activityRecognitionMappingInfoList = new CopyOnWriteArrayList();

    private void callBackWithReport(ActivityRecognitionMappingInfo activityRecognitionMappingInfo, ActivityRecognitionResult activityRecognitionResult) {
        try {
            activityRecognitionMappingInfo.getCallback().onActivityRecognition(activityRecognitionResult);
        } catch (Exception unused) {
            LogConsole.e(TAG, "Failed to get activity recognition callback", true);
        }
    }

    private boolean isUpdate(ActivityRecognitionMappingInfo activityRecognitionMappingInfo) {
        for (int i11 = 0; i11 < this.activityRecognitionMappingInfoList.size(); i11++) {
            if (this.activityRecognitionMappingInfoList.get(i11).equals(activityRecognitionMappingInfo)) {
                ActivityRecognitionMappingInfo activityRecognitionMappingInfo2 = this.activityRecognitionMappingInfoList.get(i11);
                LogConsole.i(TAG, "need update arMappingInfo:time:" + activityRecognitionMappingInfo2.getDetectionIntervalMillis() + "->" + activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setDetectionIntervalMillis(activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setClientInfo(activityRecognitionMappingInfo.getClientInfo());
                return true;
            }
        }
        return false;
    }

    public void addActivityUpdatesMappingInfo(long j11, ARCallback aRCallback, ClientInfo clientInfo) {
        LogConsole.i(TAG, "addActivityUpdatesMappingInfo enter, detectionIntervalMillis:" + j11 + ", callback:" + aRCallback);
        ActivityRecognitionMappingInfo activityRecognitionMappingInfo = new ActivityRecognitionMappingInfo();
        activityRecognitionMappingInfo.setCallback(aRCallback);
        activityRecognitionMappingInfo.setClientInfo(clientInfo);
        activityRecognitionMappingInfo.setDetectionIntervalMillis(j11);
        if (this.activityRecognitionMappingInfoList.isEmpty() || !isUpdate(activityRecognitionMappingInfo)) {
            this.activityRecognitionMappingInfoList.add(activityRecognitionMappingInfo);
        }
        LogConsole.i(TAG, "addActivityUpdatesMappingInfo success, infos size:" + this.activityRecognitionMappingInfoList.size());
    }

    public List<ActivityRecognitionMappingInfo> getInfos() {
        return this.activityRecognitionMappingInfoList;
    }

    public long getMinTime() {
        long j11 = -1;
        for (ActivityRecognitionMappingInfo detectionIntervalMillis : this.activityRecognitionMappingInfoList) {
            long detectionIntervalMillis2 = detectionIntervalMillis.getDetectionIntervalMillis();
            if (j11 == -1 || detectionIntervalMillis2 < j11) {
                j11 = detectionIntervalMillis2;
            }
        }
        LogConsole.i(TAG, "getMinTime ,minTime is " + j11);
        return j11;
    }

    public boolean isEmptyRequest() {
        List<ActivityRecognitionMappingInfo> list = this.activityRecognitionMappingInfoList;
        return list == null || list.isEmpty();
    }

    public void removeActivityUpdatesMappingInfo(ARCallback aRCallback) {
        LogConsole.i(TAG, "removeActivityUpdatesMappingInfo enter, callback:" + aRCallback, true);
        if (aRCallback == null) {
            LogConsole.e(TAG, "callback is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo next : this.activityRecognitionMappingInfoList) {
            if (next.getCallback().equals(aRCallback)) {
                arrayList.add(next);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        LogConsole.i(TAG, "removeActivityUpdatesMappingInfo success,  infos size:" + this.activityRecognitionMappingInfoList.size(), true);
    }

    public List<ActivityRecognitionMappingInfo> removeActivityUpdatesMappingInfoByPackageName(String str) {
        LogConsole.i(TAG, "removeActivityUpdatesMappingInfoByPackageName:enter:" + str);
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo next : this.activityRecognitionMappingInfoList) {
            if (next.getClientInfo().getPackageName().equals(str)) {
                arrayList.add(next);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        LogConsole.i(TAG, "removeActivityUpdatesMappingInfoByPackageName:exit:" + str);
        return arrayList;
    }

    public void send(List<DetectedActivity> list) {
        LogConsole.i(TAG, "send begin");
        if (list.size() > 0) {
            ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult(list, System.currentTimeMillis(), SystemClock.elapsedRealtime());
            for (ActivityRecognitionMappingInfo callBackWithReport : this.activityRecognitionMappingInfoList) {
                LogConsole.i(TAG, "sending");
                callBackWithReport(callBackWithReport, activityRecognitionResult);
            }
        }
    }
}
