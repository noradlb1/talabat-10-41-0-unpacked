package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.hms.utils.JsonUtil;

public class p0 extends h0<s, LocationAvailability> {
    public p0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<LocationAvailability> taskCompletionSource) {
        LocationAvailability locationAvailability;
        try {
            HMSLocationLog.i("GetLocationAvailabilityTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0) {
                    GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
                    JsonUtil.jsonToEntity(str, getLocationAvailabilityResponse);
                    locationAvailability = getLocationAvailabilityResponse.getLocationAvailability();
                } else {
                    locationAvailability = null;
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, locationAvailability);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (Exception unused) {
            HMSLocationLog.e("GetLocationAvailabilityTaskApiCall", this.f49189a, "doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
