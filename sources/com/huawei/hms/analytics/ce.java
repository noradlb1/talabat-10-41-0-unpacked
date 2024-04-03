package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class ce extends ci {
    public ce(IConfig iConfig) {
        super(ck.lmn("GetOaidSwitch#execute"), "GET", "/analytics/api/config?config_key=oaid_flag", iConfig);
    }

    private static boolean ijk() {
        ax axVar = av.lmn().lmn;
        String klm = dv.klm(axVar.ghi, "global_v2", "oid_switch_info", "");
        if (TextUtils.isEmpty(klm)) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONArray(klm).getJSONObject(0);
            if (System.currentTimeMillis() - jSONObject.getLong("timestamp") > 86400000) {
                return true;
            }
            if (jSONObject.getString("config_value").equals("true")) {
                axVar.f47866m = true;
            }
            return false;
        } catch (JSONException unused) {
            dv.lmn(axVar.ghi, "global_v2", "oid_switch_info");
            return true;
        }
    }

    public final void klm() {
        if (!ijk()) {
            HiLog.d("RequestBas", "no need sync oaid switch");
        } else {
            super.klm();
        }
    }

    public final void onFailure(int i11) {
        HiLog.e("RequestBas", "GET oaid flag exception,errorCode: ".concat(String.valueOf(i11)));
        lmn(i11);
    }

    public final void onSuccess(Response response) {
        this.ikl.lmn = "0";
        lmn(response.getHttpCode());
        ax axVar = av.lmn().lmn;
        if (response.getHttpCode() == 200) {
            HiLog.i("RequestBas", "get oaid_flag result code : " + response.getHttpCode());
            try {
                JSONArray jSONArray = new JSONObject(response.getContent()).getJSONArray("configList");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    axVar.f47866m = jSONObject.getString("config_value").equals("true");
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    dv.lmn(axVar.ghi, "global_v2", "oid_switch_info", JSONArrayInstrumentation.toString(jSONArray));
                }
            } catch (JSONException unused) {
                axVar.f47866m = false;
            }
        }
    }
}
