package com.huawei.location;

import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.Vw;

public abstract class BaseApiRequest extends BaseRouterTaskCallImpl {
    private static final String TAG = "BaseApiRequest";
    protected String apiName;
    protected String errorCode = String.valueOf(0);
    protected Vw.yn reportBuilder = new Vw.yn();

    public void checkApproximatelyPermission() throws LocationServiceException {
        if (com.huawei.location.activity.model.Vw.yn()) {
            throw new LocationServiceException(LocationStatusCode.NO_PRECISE_LOCATION_PERMISSION, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_PRECISE_LOCATION_PERMISSION));
        }
    }

    public void onRequestFail(int i11, String str) {
        onComplete(new RouterResponse("", new StatusInfo(0, i11, str)));
    }

    public void report(LocationBaseRequest locationBaseRequest) {
        this.reportBuilder.yn(this.apiName);
        this.reportBuilder.yn(locationBaseRequest);
        this.reportBuilder.yn().yn(this.errorCode);
    }
}
