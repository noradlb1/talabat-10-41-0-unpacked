package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import org.json.JSONObject;

public final class j {
    private static void klm(Context context, JSONObject jSONObject) {
        if (be.lmn()) {
            bl lmn = cde.lmn().lmn("_openness_config_tag");
            if (lmn instanceof def) {
                jSONObject.remove("t");
                ((def) lmn).klm("$CampaignPushClick", new dt("$CampaignPushClick", jSONObject), System.currentTimeMillis());
                return;
            }
            return;
        }
        String klm = dv.klm(context, "Privacy_MY", "_openness_config_tag_region", "");
        if (TextUtils.isEmpty(klm)) {
            HiAnalytics.getInstance(context);
        } else {
            HiAnalytics.getInstance(context, klm);
        }
    }

    private static h lmn(cb cbVar, Context context) {
        return ad.ghi() ? new i(cbVar, context) : new g(cbVar, context);
    }

    private static JSONObject lmn(cb cbVar) {
        String lmn = di.lmn(cbVar);
        if (!TextUtils.isEmpty(lmn) && lmn.length() <= 20480) {
            try {
                JSONObject jSONObject = new JSONObject(lmn);
                if (jSONObject.has("t")) {
                    return jSONObject;
                }
                HiLog.w("PshCamp", "The time key is missing.");
                return null;
            } catch (Throwable unused) {
                HiLog.w("PshCamp", "JSONException: Failed to format Json.");
            }
        }
        return null;
    }

    public static void lmn(Context context, cb cbVar) {
        if (cbVar != null) {
            di.klm(cbVar);
            JSONObject lmn = lmn(cbVar);
            if (lmn != null) {
                new g(cbVar, context).lmn(lmn, (JSONObject) null);
                return;
            }
            h lmn2 = lmn(cbVar, context);
            as lmn3 = lmn2.lmn();
            if (lmn3 != null) {
                JSONObject lmn4 = lmn2.lmn(lmn3).lmn();
                lmn2.lmn(lmn3.lmn(), lmn4);
                lmn(context, lmn4);
            }
        }
    }

    private static void lmn(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            klm(context, jSONObject);
        }
    }
}
