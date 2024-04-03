package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.core.log.HiLog;
import org.json.JSONException;

public final class g extends f {
    public g(cb cbVar, Context context) {
        this.ikl = cbVar;
        this.klm = context;
        this.lmn = "HwPushHandler";
    }

    public final as lmn() {
        String str;
        String str2;
        String hij = this.ikl.hij("$CampaignPushInfo");
        if (f.lmn(hij)) {
            str = this.lmn;
            str2 = "campaign info check failed";
        } else {
            try {
                return new as(hij);
            } catch (JSONException unused) {
                str = this.lmn;
                str2 = "getCampInfo exception";
            }
        }
        HiLog.w(str, str2);
        return null;
    }
}
