package com.huawei.hms.location.api.response;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;

public class RequestActivityConversionResp extends BaseLocationResp {
    @Packed
    private ActivityTransitionResult activityTransitionResult;

    public ActivityTransitionResult getActivityTransitionResult() {
        return this.activityTransitionResult;
    }

    public void setActivityTransitionResult(ActivityTransitionResult activityTransitionResult2) {
        this.activityTransitionResult = activityTransitionResult2;
    }
}
