package com.huawei.hms.locationSdk;

import android.location.Location;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;

public class o0 extends h0<s, Location> {
    public o0(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Location> taskCompletionSource) {
        try {
            HMSLocationLog.i("GetLastLocationTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, LocationJsonUtil.convertLocation(responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str)) : null));
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("GetLastLocationTaskApiCall", str2, "get last location doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", this.f49189a, "get last location doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
