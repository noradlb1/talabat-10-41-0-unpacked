package com.huawei.location;

import com.google.gson.Gson;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.callback.oc;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.logic.LW;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

public class RequestUpdatesExTaskCall extends BaseApiRequest {
    private static final String TAG = "RequestLocationUpdatesExAPI";
    private oc hwLocationCallback = new yn();

    @Instrumented
    public class yn implements oc {
        public yn() {
        }

        public void yn() {
            RequestUpdatesExTaskCall requestUpdatesExTaskCall = RequestUpdatesExTaskCall.this;
            Gson instance = GsonUtil.getInstance();
            RequestLocationUpdatesResponse requestLocationUpdatesResponse = new RequestLocationUpdatesResponse();
            requestUpdatesExTaskCall.onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestLocationUpdatesResponse) : GsonInstrumentation.toJson(instance, (Object) requestLocationUpdatesResponse), new StatusInfo(0, 0, "success")));
        }

        public void yn(RouterResponse routerResponse) {
            RequestUpdatesExTaskCall.this.doExecute(routerResponse);
        }
    }

    private boolean checkNeedOffLineLocation(LocationRequest locationRequest) {
        LogConsole.i(TAG, "checkNeedOffLineLocation Ex");
        if (!agcFail()) {
            return true;
        }
        if (locationRequest.getPriority() == 100 || locationRequest.getPriority() == 200) {
            LogConsole.i(TAG, "agc fail ,but use offLine Ex");
            return true;
        }
        RouterResponse routerResponse = new RouterResponse("", new StatusInfo(0, 10808, LocationStatusCode.getStatusCodeString(10808)));
        if (getRouterCallback() != null) {
            getRouterCallback().onComplete(routerResponse);
        }
        return false;
    }

    private void checkRequest(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() == null) {
            LogConsole.e(TAG, "locationRequest is invalid");
            throw new LocationServiceException(10000, LocationStatusCode.getStatusCodeString(10000));
        } else if (Vw.FB(requestLocationUpdatesRequest.getLocationRequest().getPriority())) {
            LogConsole.i(TAG, "onRequest，tid is " + requestLocationUpdatesRequest.getTid() + ", packageName is " + requestLocationUpdatesRequest.getPackageName() + ", uuid is " + requestLocationUpdatesRequest.getUuid() + ", locationRequest is " + requestLocationUpdatesRequest.getLocationRequest().getPriority());
        } else {
            LogConsole.i(TAG, "request is invalid");
            throw new LocationServiceException(10101, LocationStatusCode.getStatusCodeString(10101));
        }
    }

    public void onRequest(String str) {
        LogConsole.i(TAG, "RequestLocationUpdatesExAPI begin");
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest();
        this.apiName = "Location_requestLocationUpdatesEx";
        try {
            com.huawei.location.utils.yn.yn(str, (IMessageEntity) requestLocationUpdatesRequest);
            checkRequest(requestLocationUpdatesRequest);
            checkApproximatelyPermission();
            if (checkNeedOffLineLocation(requestLocationUpdatesRequest.getLocationRequest())) {
                boolean yn2 = com.huawei.location.cache.yn.Vw().yn(requestLocationUpdatesRequest.getUuid());
                LW.yn().FB(new com.huawei.location.cache.Vw(requestLocationUpdatesRequest), this.hwLocationCallback);
                this.reportBuilder.Vw();
                this.reportBuilder.yn(requestLocationUpdatesRequest.getLocationRequest(), yn2);
                report(requestLocationUpdatesRequest);
            }
        } catch (LocationServiceException e11) {
            this.errorCode = String.valueOf(e11.getExceptionCode());
            onRequestFail(e11.getExceptionCode(), e11.getMessage());
        } catch (Exception unused) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
    }
}
