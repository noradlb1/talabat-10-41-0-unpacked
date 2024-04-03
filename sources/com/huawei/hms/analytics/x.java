package com.huawei.hms.analytics;

import android.content.Intent;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;

public final class x extends TaskApiCall<v, w> {
    public x(String str, String str2) {
        super(str, str2, (String) null);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource taskCompletionSource) {
        if (responseErrorCode == null || taskCompletionSource == null) {
            HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header or taskCompletionSource is null");
        } else if (responseErrorCode.getErrorCode() == 0) {
            w wVar = new w(str);
            if (responseErrorCode.getParcelable() == null) {
                HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header.getParcelable() is null");
                taskCompletionSource.setResult(wVar);
            } else if (responseErrorCode.getParcelable() instanceof Intent) {
                HiLog.i("HiAnalyticsTaskApiRequire", "HMS API call succeed.");
                taskCompletionSource.setResult(new w((Intent) responseErrorCode.getParcelable()));
            } else {
                HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header.getParcelable() is not Intent");
                taskCompletionSource.setResult(wVar);
            }
        } else {
            HiLog.w("HiAnalyticsTaskApiRequire", "HMS API call failed. header.getErrorCode() != CommonCode.OK");
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    public final int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
