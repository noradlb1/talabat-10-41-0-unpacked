package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;

public class k0 extends h0<s, Void> {
    public k0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        HMSLocationLog.i("EnableBackgroundLocationTaskApiCall", this.f49189a, "doExecute");
        if (responseErrorCode != null) {
            try {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
            } catch (Exception unused) {
                HMSLocationLog.e("EnableBackgroundLocationTaskApiCall", this.f49189a, "enable background location doExecute exception");
                taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            }
        } else {
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
    }
}
