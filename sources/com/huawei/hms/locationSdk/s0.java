package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;

public class s0 extends h0<r, Void> {

    /* renamed from: b  reason: collision with root package name */
    private x f49211b;

    public s0(String str, String str2, x xVar) {
        super(str, str2, xVar.a());
        this.f49211b = xVar;
    }

    /* renamed from: a */
    public void doExecute(r rVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        if (responseErrorCode != null) {
            try {
                if (responseErrorCode.getErrorCode() == 0) {
                    y.b().c(this.f49211b);
                }
                HMSLocationLog.i("RemoveActivityTransitionUpdatesTaskApiCall", this.f49189a, "doExecute");
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
            } catch (Exception unused) {
                HMSLocationLog.e("RemoveActivityTransitionUpdatesTaskApiCall", this.f49189a, "doExecute exception");
                taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            }
        } else {
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
    }
}
