package com.huawei.location.activity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.logic.zp;
import com.huawei.location.router.entity.IRouterResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class RequestAdapterSDMTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RequestAdapterSDMAPI";

    public IRouterResponse onExecute(String str) {
        BaseLocationReq baseLocationReq;
        LogConsole.i(TAG, "onExecute start");
        try {
            Gson instance = GsonUtil.getInstance();
            Class cls = BaseLocationReq.class;
            baseLocationReq = (BaseLocationReq) (!(instance instanceof Gson) ? instance.fromJson(str, cls) : GsonInstrumentation.fromJson(instance, str, cls));
        } catch (JsonSyntaxException unused) {
            LogConsole.i(TAG, "removeActivityIdentificationUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest RequestAdapterSDMTaskCall exception";
            baseLocationReq = null;
        }
        this.reportBuilder.yn("AR_requestAdapterSDM");
        zp yn2 = zp.yn();
        this.reportBuilder.yn(baseLocationReq);
        this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
        return yn2;
    }

    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest start");
    }
}
