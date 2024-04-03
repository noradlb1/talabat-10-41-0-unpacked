package com.huawei.location;

import com.google.gson.Gson;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.logic.LW;
import com.huawei.location.req.RemoveLocationUpdatesReq;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.Vw;
import com.huawei.location.utils.yn;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class RemoveUpdateTaskCall extends BaseApiRequest {
    private static final String TAG = "RemoveLocationUpdateApi";

    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest start");
        RemoveLocationUpdatesReq removeLocationUpdatesReq = new RemoveLocationUpdatesReq();
        yn.yn(str, (IMessageEntity) removeLocationUpdatesReq);
        this.reportBuilder.yn("Location_removeLocationUpdates");
        this.reportBuilder.yn((LocationBaseRequest) removeLocationUpdatesReq);
        try {
            LW.yn().yn(removeLocationUpdatesReq.getUuid());
            this.reportBuilder.yn().yn("0");
            Gson instance = GsonUtil.getInstance();
            RequestLocationUpdatesResponse requestLocationUpdatesResponse = new RequestLocationUpdatesResponse();
            onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestLocationUpdatesResponse) : GsonInstrumentation.toJson(instance, (Object) requestLocationUpdatesResponse), new StatusInfo(0, 0, "SUCCESS")));
        } catch (LocationServiceException e11) {
            Vw yn2 = this.reportBuilder.yn();
            yn2.yn(e11.getExceptionCode() + "");
            Gson instance2 = GsonUtil.getInstance();
            RequestLocationUpdatesResponse requestLocationUpdatesResponse2 = new RequestLocationUpdatesResponse();
            onComplete(new RouterResponse(!(instance2 instanceof Gson) ? instance2.toJson((Object) requestLocationUpdatesResponse2) : GsonInstrumentation.toJson(instance2, (Object) requestLocationUpdatesResponse2), new StatusInfo(0, e11.getExceptionCode(), e11.getMessage())));
        }
    }
}
