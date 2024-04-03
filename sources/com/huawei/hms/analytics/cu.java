package com.huawei.hms.analytics;

import com.braze.models.FeatureFlag;
import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.database.LogEvent;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cu {
    String fgh;
    int ghi;
    String hij = RandomUtil.getInstance().generateSecureRandomStr(16);
    final List<Long> ijk = new ArrayList();
    boolean ikl;
    final List<Long> klm = new ArrayList();
    JSONArray lmn = new JSONArray();

    public cu(int i11) {
        this.ghi = i11;
    }

    public final void hij() {
        this.ijk.clear();
        this.fgh = "";
    }

    public final void ijk() {
        this.klm.clear();
        this.hij = RandomUtil.getInstance().generateSecureRandomStr(16);
        this.lmn = new JSONArray();
    }

    public final boolean ikl() {
        return this.ikl && this.ijk.size() == this.ghi;
    }

    public final JSONObject klm() {
        JSONObject jSONObject = new JSONObject();
        ax axVar = av.lmn().lmn;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("protocol_version", (Object) "1");
        jSONObject2.put("productid", (Object) axVar.f47867n.ikl);
        jSONObject2.put("chifer", (Object) "");
        jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, (Object) axVar.f47867n.klm);
        jSONObject2.put("requestid", (Object) this.hij);
        jSONObject2.put("servicetag", (Object) "_openness_log_tag");
        jSONObject2.put("compress_mode", (Object) "0");
        jSONObject2.put("serviceid", (Object) "hmshimaintqrt");
        jSONObject2.put("timestamp", (Object) String.valueOf(System.currentTimeMillis()));
        jSONObject.put("header", (Object) jSONObject2);
        jSONObject.put("event", (Object) this.lmn);
        return jSONObject;
    }

    public final int lmn(JSONArray jSONArray, List<LogEvent> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("log events is empty");
        }
        int i11 = 0;
        for (LogEvent next : list) {
            i11++;
            this.klm.add(next.getId());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", (Object) next.getEventId());
            jSONObject.put("eventtime", (Object) next.getEvtTime());
            try {
                jSONObject.put(FeatureFlag.PROPERTIES, (Object) new JSONObject(next.getContent()));
                jSONArray.put((Object) jSONObject);
                if (this.klm.size() >= 300) {
                    break;
                }
            } catch (JSONException unused) {
            }
        }
        return i11;
    }

    public final boolean lmn() {
        return this.lmn.length() != 0;
    }
}
