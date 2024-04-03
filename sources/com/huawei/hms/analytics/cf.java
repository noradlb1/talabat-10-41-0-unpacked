package com.huawei.hms.analytics;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class cf extends ci {
    private String lmn;

    public cf(String str, IConfig iConfig) {
        super(ck.lmn("GetPublicKey#execute"), "POST", "/getPublicKey", iConfig);
        this.lmn = str;
    }

    private boolean ijk() {
        ax axVar = av.lmn().lmn;
        String klm = dv.klm(axVar.ghi, "Privacy_MY", this.ijk.getSite(), "");
        if (TextUtils.isEmpty(klm)) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(klm);
            String string = jSONObject.getString("timeInterval");
            long j11 = jSONObject.getLong("requestTime");
            String string2 = jSONObject.getString("publicKey");
            String string3 = jSONObject.getString("pubkey_version");
            if (System.currentTimeMillis() - j11 > Long.parseLong(string)) {
                return true;
            }
            axVar.lmn(this.ijk.getSite(), string2);
            axVar.klm(this.ijk.getSite(), string3);
            return false;
        } catch (Throwable th2) {
            dv.lmn(axVar.ghi, "Privacy_MY", this.ijk.getSite());
            dr.lmn(th2);
            return true;
        }
    }

    private static String lmn(String str) {
        Map<String, String> map;
        if (str == null || (map = av.lmn().lmn(str).klm) == null) {
            return null;
        }
        return map.get("ha-sdk-service");
    }

    public final void klm() {
        if (!ijk()) {
            HiLog.d("RequestBas", "no need sync pub key");
            return;
        }
        dv.lmn(av.lmn().lmn.ghi, "Privacy_MY", "pubK_info");
        super.klm();
    }

    public final Map<String, String> lmn() {
        Map<String, String> lmn2 = super.lmn();
        lmn2.put("Os", "0");
        lmn2.put("Os-Ver", Build.VERSION.RELEASE);
        if (lmn(this.lmn) != null) {
            lmn2.put("ha-sdk-service", lmn(this.lmn));
        }
        return lmn2;
    }

    public final void onFailure(int i11) {
        HiLog.e("RequestBas", "GET pub key exception,errorCode: ".concat(String.valueOf(i11)));
        lmn(i11);
    }

    public final void onSuccess(Response response) {
        String str;
        this.ikl.lmn = "0";
        lmn(response.getHttpCode());
        try {
            if (response.getHttpCode() == 200) {
                HiLog.i("RequestBas", "get pub key result code : " + response.getHttpCode());
                JSONObject jSONObject = new JSONObject(response.getContent());
                String string = jSONObject.getString("publicKey");
                String string2 = jSONObject.getString("pubkey_version");
                if (!TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put("timeInterval", Long.parseLong(jSONObject.getString("timeInterval")) + (((long) new Random().nextInt(1380)) * 60000));
                        jSONObject.put("requestTime", System.currentTimeMillis());
                        ax axVar = av.lmn().lmn;
                        axVar.lmn(this.ijk.getSite(), string.trim());
                        axVar.klm(this.ijk.getSite(), string2);
                        dv.lmn(axVar.ghi, "Privacy_MY", this.ijk.getSite(), JSONObjectInstrumentation.toString(jSONObject));
                        return;
                    }
                }
                HiLog.e("RequestBas", "pub key or version is empty");
            }
        } catch (JSONException unused) {
            str = "GET pub key,json exception";
            HiLog.e("RequestBas", str);
        } catch (Throwable th2) {
            str = "GET pub key exception " + th2.getMessage();
            HiLog.e("RequestBas", str);
        }
    }
}
