package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

public final class bw implements EvtHeaderAttributeCollector {
    private String ikl;
    private IConfig klm;
    private JSONObject lmn;

    public bw(JSONObject jSONObject, IConfig iConfig, String str) {
        this.lmn = jSONObject;
        this.klm = iConfig;
        this.ikl = str;
    }

    public final JSONObject doCollector() {
        if (this.lmn == null) {
            return null;
        }
        ax axVar = av.lmn().lmn;
        String str = axVar.f47867n.ikl;
        String lmn2 = axVar.lmn(this.klm.getSite());
        try {
            JSONObject jSONObject = this.lmn;
            if (str == null) {
                str = "";
            }
            jSONObject.put("productid", (Object) str);
            JSONObject jSONObject2 = this.lmn;
            if (lmn2 == null) {
                lmn2 = "";
            }
            jSONObject2.put("pubkey_version", (Object) lmn2);
            if (("_openness_config_tag".equals(this.ikl) || aq.fgh.contains(this.ikl)) && Profile.Country.CN.equals(this.klm.getSite())) {
                this.lmn.put("wxappid", (Object) axVar.f47874u);
            }
        } catch (JSONException unused) {
            HiLog.e("OpennessHeaderGathering", "doCollector JSONException");
        }
        return this.lmn;
    }
}
