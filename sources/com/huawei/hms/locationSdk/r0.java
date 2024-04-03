package com.huawei.hms.locationSdk;

import com.google.gson.Gson;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.GsonUtil;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class r0 extends h0<s, OfflineLocationResponse> {
    public r0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<OfflineLocationResponse> taskCompletionSource) {
        OfflineLocationResponse offlineLocationResponse;
        try {
            HMSLocationLog.i("GetOfflineLocationTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0) {
                    Gson instance = GsonUtil.getInstance();
                    Class cls = OfflineLocationResponse.class;
                    offlineLocationResponse = (OfflineLocationResponse) (!(instance instanceof Gson) ? instance.fromJson(str, cls) : GsonInstrumentation.fromJson(instance, str, cls));
                } else {
                    offlineLocationResponse = null;
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, offlineLocationResponse);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("GetOfflineLocationTaskApiCall", str2, "get last location doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("GetOfflineLocationTaskApiCall", this.f49189a, "get last location doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    public int getApiLevel() {
        return 7;
    }
}
