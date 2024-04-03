package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import java.util.List;
import org.json.JSONObject;

public class l0 extends h0<u, List<HWLocation>> {

    /* renamed from: b  reason: collision with root package name */
    private Context f49201b;

    public l0(Context context, String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f49201b = context;
    }

    /* renamed from: a */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<List<HWLocation>> taskCompletionSource) {
        try {
            HMSLocationLog.i("GetFromLocationNameTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseHwLocationsFromJsonObject(new JSONObject(str)) : null);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("GetFromLocationNameTaskApiCall", str2, "getFromLocationName doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("GetFromLocationNameTaskApiCall", this.f49189a, "getFromLocationName doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    public int getApiLevel() {
        int deviceFeature = DeviceInfoUtil.getDeviceFeature(this.f49201b);
        return (deviceFeature == 0 || deviceFeature == 1) ? 6 : 5;
    }
}
