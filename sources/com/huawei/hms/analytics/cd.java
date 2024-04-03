package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.IConfig;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class cd extends ci {
    public cd(IConfig iConfig) {
        super(ck.lmn("GetLocationPolicy#execute"), "GET", "/analytics/api/config?config_key=location_policy", iConfig);
        new dy().lmn();
    }

    public final void klm() {
        if (this.ijk.getServiceUrls() != null) {
            super.klm();
            return;
        }
        throw new IllegalArgumentException("service url Invalid, init failed");
    }

    public abstract void lmn(boolean z11, String str);

    public void onFailure(int i11) {
        HiLog.w("RequestBas", "GET location policy failed,errorCode: ".concat(String.valueOf(i11)));
        lmn(false, String.valueOf(i11));
    }

    public void onSuccess(Response response) {
        try {
            HiLog.i("RequestBas", "get location policy code: " + response.getHttpCode());
            lmn(true, new JSONObject(response.getContent()).getJSONArray("configList").getJSONObject(0).getString("config_value"));
        } catch (JSONException e11) {
            HiLog.w("RequestBas", "location policy content error." + e11.getMessage());
            lmn(false, "-1");
        }
    }
}
