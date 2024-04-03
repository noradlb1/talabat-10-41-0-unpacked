package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.crypto.RandomUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class at {
    private final String ghi;
    private final String hij;
    private final String ijk;
    private final String ikl;
    private final String klm;
    private final String lmn;

    public at(String str, String str2, String str3, as asVar) {
        String str4 = "";
        this.lmn = str == null ? str4 : str;
        this.klm = str2 == null ? str4 : str2;
        this.ikl = str3 == null ? str4 : str3;
        this.hij = asVar.lmn;
        String str5 = asVar.klm;
        this.ijk = str5 != null ? str5 : str4;
        this.ghi = RandomUtil.getInstance().generateSecureRandomStr(16);
    }

    public final JSONObject lmn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$PushMsgId", (Object) this.lmn);
            jSONObject.put("$PushCmdType", (Object) this.klm);
            jSONObject.put("$PushNotifyId", (Object) this.ikl);
            jSONObject.put("$CampaignPushInfo", (Object) this.ijk);
            jSONObject.put("t", (Object) this.hij);
            jSONObject.put("f", (Object) this.ghi);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
