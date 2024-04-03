package com.huawei.hms.support.api.location.common.exception;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class ServiceErrorCodeAdaptor<TResult> {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "ServiceErrorCodeAdaptor";
    private static volatile ServiceErrorCodeAdaptor instance;

    public static ServiceErrorCodeAdaptor getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new ServiceErrorCodeAdaptor();
                }
            }
        }
        return instance;
    }

    public void setTaskByServiceErrorCode(TaskCompletionSource<TResult> taskCompletionSource, ResponseErrorCode responseErrorCode, TResult tresult) throws Exception {
        int i11 = 10000;
        if (taskCompletionSource == null || responseErrorCode == null) {
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        HMSLog.i(TAG, "set task by error code:" + responseErrorCode.getErrorCode() + ",reason:" + responseErrorCode.getErrorReason());
        if (responseErrorCode.getErrorCode() < 10000 || responseErrorCode.getErrorCode() > 10099) {
            i11 = errorCode;
        } else {
            errorReason = LocationStatusCode.getStatusCodeString(10000);
        }
        if (i11 == 0) {
            taskCompletionSource.setResult(tresult);
        } else if (responseErrorCode.hasResolution()) {
            taskCompletionSource.setException(new ResolvableApiException(responseErrorCode));
        } else {
            taskCompletionSource.setException(new ApiException(new Status(i11, errorReason)));
        }
    }
}
