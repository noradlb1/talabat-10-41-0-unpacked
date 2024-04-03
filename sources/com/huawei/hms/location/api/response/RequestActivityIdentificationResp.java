package com.huawei.hms.location.api.response;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;

public class RequestActivityIdentificationResp extends BaseLocationResp {
    @Packed
    private ActivityRecognitionResult activityRecognitionResult;

    public ActivityRecognitionResult getActivityRecognitionResult() {
        return this.activityRecognitionResult;
    }

    public void setActivityRecognitionResult(ActivityRecognitionResult activityRecognitionResult2) {
        this.activityRecognitionResult = activityRecognitionResult2;
    }
}
