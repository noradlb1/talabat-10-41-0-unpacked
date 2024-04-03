package com.huawei.location;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class DisableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "DisableGroundTaskCall";

    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest DisableGroundTaskCall");
        Context context = ContextUtil.getContext();
        context.stopService(new Intent(context, BackGroundService.class));
        Gson instance = GsonUtil.getInstance();
        RequestLocationUpdatesResponse requestLocationUpdatesResponse = new RequestLocationUpdatesResponse();
        onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestLocationUpdatesResponse) : GsonInstrumentation.toJson(instance, (Object) requestLocationUpdatesResponse), new StatusInfo(0, 0, "SUCCESS")));
    }
}
