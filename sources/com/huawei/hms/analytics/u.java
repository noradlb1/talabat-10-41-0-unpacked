package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class u extends HuaweiApi<Api.ApiOptions.NoOptions> {
    private static final s lmn = new s();

    public u(Context context) {
        super(context, new Api(""), new Api.ApiOptions.NoOptions(), (AbstractClientBuilder) lmn);
    }

    public final Task<String> lmn() {
        JSONObject jSONObject = new JSONObject();
        try {
            ax axVar = av.lmn().lmn;
            jSONObject.put("method", (Object) "setKitEnable");
            jSONObject.put("pkg_name", (Object) axVar.ghi.getPackageName());
            jSONObject.put("3rd_aaid", (Object) dh.lmn().klm());
            jSONObject.put("app_id", (Object) axVar.f47867n.klm);
            jSONObject.put("enable_collect", axVar.fgh);
            jSONObject.put("_restriction_enabled", axVar.efg);
            jSONObject.put("_restriction_shared", axVar.def);
            jSONObject.put("_region", (Object) axVar.f47867n.lmn("_openness_config_tag"));
        } catch (JSONException unused) {
            HiLog.e("HiAnalyticsClientWatchable", "unableCollect build json failed. ");
        }
        return doWrite(new y("hianalytics.analyticsInvokeService", JSONObjectInstrumentation.toString(jSONObject)));
    }
}
