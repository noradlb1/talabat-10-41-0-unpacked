package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;

public class w0 extends h0<r, Void> {

    /* renamed from: b  reason: collision with root package name */
    private x f49214b;

    public w0(String str, String str2, x xVar) {
        super(str, str2, xVar.a());
        this.f49214b = xVar;
    }

    /* renamed from: a */
    public void doExecute(r rVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        try {
            HMSLocationLog.i("RequestActivityTransitionUpdatesTaskApiCall", this.f49189a, "request activityTrans doExecute");
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0) {
                    y.b().a(this.f49214b);
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (Exception unused) {
            HMSLocationLog.e("RequestActivityTransitionUpdatesTaskApiCall", this.f49189a, "request activityTrans doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    public int getApiLevel() {
        return 4;
    }
}
