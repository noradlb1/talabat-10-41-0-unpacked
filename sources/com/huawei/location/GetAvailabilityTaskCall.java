package com.huawei.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.logic.LW;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.yn;

public class GetAvailabilityTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLocationAvailabilityApi";

    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest GetAvailabilityTaskCall");
        LW yn2 = LW.yn();
        yn2.getClass();
        LocationAvailability locationAvailability = new LocationAvailability();
        if (yn2.Vw() != null) {
            LogConsole.i("HwLocationManager", "get last location successful");
            locationAvailability.setLocationStatus(0);
        } else {
            LogConsole.e("HwLocationManager", "get last location failed");
            locationAvailability.setLocationStatus(1001);
        }
        StatusInfo statusInfo = new StatusInfo(0, 0, "");
        GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest();
        yn.yn(str, (IMessageEntity) locationBaseRequest);
        getLocationAvailabilityResponse.setLocationAvailability(locationAvailability);
        doExecute(new RouterResponse(yn.Vw(getLocationAvailabilityResponse), statusInfo));
        this.errorCode = String.valueOf(0);
        this.reportBuilder.yn("Location_getLocationAvailability");
        this.reportBuilder.yn(locationBaseRequest);
        this.reportBuilder.yn().yn(this.errorCode);
    }
}
