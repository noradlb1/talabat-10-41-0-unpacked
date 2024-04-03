package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;

public class u0 extends h0<v, Void> {
    public u0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: a */
    public void doExecute(v vVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        try {
            HMSLocationLog.i("RemoveGeofencesTaskApiCall", this.f49189a, "remove geofences doExecute");
            if (responseErrorCode != null) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("RemoveGeofencesTaskApiCall", str2, "remove geofences doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("RemoveGeofencesTaskApiCall", this.f49189a, "remove geofences doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
