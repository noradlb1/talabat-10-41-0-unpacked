package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;

public class x0 extends h0<r, Void> {

    /* renamed from: b  reason: collision with root package name */
    private z f49216b;

    public x0(String str, String str2, z zVar) {
        super(str, str2, zVar.a());
        this.f49216b = zVar;
    }

    /* renamed from: a */
    public void doExecute(r rVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        try {
            HMSLocationLog.i("RequestActivityUpdatesTaskApiCall", this.f49189a, "request activity doExecute");
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0) {
                    a0.b().a(this.f49216b);
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (Exception unused) {
            HMSLocationLog.e("RequestActivityUpdatesTaskApiCall", this.f49189a, "request activity doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    public int getApiLevel() {
        return 4;
    }
}
