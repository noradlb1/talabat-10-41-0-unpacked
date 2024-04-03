package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.visa.checkout.Profile;
import org.json.JSONObject;

public class q0 extends h0<t, NavigationResult> {
    public q0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: a */
    public void doExecute(t tVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<NavigationResult> taskCompletionSource) {
        try {
            HMSLocationLog.i("GetNavigationContextStateTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                int errorCode = responseErrorCode.getErrorCode();
                HMSLocationLog.d("GetNavigationContextStateTaskApiCall", this.f49189a, "getNavigationContextState message start");
                NavigationResult navigationResult = new NavigationResult();
                if (errorCode == 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    navigationResult.setState(jSONObject.getInt(Profile.ENVIRONMENT));
                    navigationResult.setPossibility(jSONObject.getInt("confidence"));
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, navigationResult);
                HMSLocationLog.d("GetNavigationContextStateTaskApiCall", this.f49189a, "getNavigationContextState message success");
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("GetNavigationContextStateTaskApiCall", str2, "get navi doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("GetNavigationContextStateTaskApiCall", this.f49189a, "get navi doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
