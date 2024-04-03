package com.huawei.hms.locationSdk;

import android.os.Build;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.vdr.VdrManager;

public class v0 extends h0<s, Void> {

    /* renamed from: b  reason: collision with root package name */
    private e0 f49213b;

    public v0(String str, String str2, String str3, e0 e0Var, String str4) {
        super(str, str2, str3, str4);
        this.f49213b = e0Var;
        if (Build.VERSION.SDK_INT >= 24 && ReflectionUtils.isSupportClass("com.huawei.location.vdr.VdrManager")) {
            VdrManager.getInstance().unRegisterVdrLocationLis(this.f49213b.h());
        }
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        try {
            HMSLocationLog.i("RemoveLocationUpdatesTaskApiCall", this.f49189a, "doExecute");
            d0.b().a(this.f49213b.c());
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0 || responseErrorCode.getErrorCode() == 10104) {
                    d0.b().c(this.f49213b);
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (Exception unused) {
            HMSLocationLog.e("RemoveLocationUpdatesTaskApiCall", this.f49189a, "doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
