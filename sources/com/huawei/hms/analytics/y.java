package com.huawei.hms.analytics;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;

public final class y extends TaskApiCall<v, String> {
    public y(String str, String str2) {
        super(str, str2, (String) null);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource taskCompletionSource) {
        if (responseErrorCode == null || taskCompletionSource == null) {
            HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header or taskCompletionSource is null");
        } else if (responseErrorCode.getErrorCode() == 0) {
            HiLog.i("HiAnalyticsTaskApiRequire", "HMS API call succeed.");
            taskCompletionSource.setResult("HMS API call succeed.");
        } else {
            HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header.getErrorCode() != CommonCode.OK ");
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    public final int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
