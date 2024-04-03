package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.crypto.AesCipher;
import com.huawei.hms.analytics.core.log.HiLog;
import j$.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class bf extends au {
    public bf(Context context) {
        super(context, "global_v2", "common_prop");
        fgh();
    }

    private void efg() {
        String ikl = ikl();
        if (TextUtils.isEmpty(ikl)) {
            HiLog.i("userPro", "commonprop is empty");
            return;
        }
        String ikl2 = ikl(bs.lmn().klm(), ikl);
        if (TextUtils.isEmpty(ikl2)) {
            HiLog.i("userPro", "customParams is error");
            ijk();
            return;
        }
        try {
            lmn(new JSONObject(ikl2));
        } catch (JSONException unused) {
            HiLog.i("userPro", "cache user properties is no json");
            ijk();
        }
    }

    private String ikl(String str, String str2) {
        String lmn = au.lmn(str, str2);
        if (TextUtils.isEmpty(lmn)) {
            lmn = AesCipher.decryptCbc(str2, str);
            if (TextUtils.isEmpty(lmn)) {
                return "";
            }
            lmn(au.klm(str, lmn));
        }
        return lmn;
    }

    public final void fgh() {
        if (this.ikl == null) {
            efg();
        }
        if (this.ikl == null) {
            this.ikl = new ConcurrentHashMap<>();
        }
    }

    public final void lmn(Bundle bundle) {
    }

    public final void lmn(String str, Object obj) {
        if (this.ikl == null) {
            this.ikl = new ConcurrentHashMap<>();
        }
        if (this.ikl.size() != 0 || obj != null) {
            if (obj == null) {
                this.ikl.remove(str);
            } else if (lmn(25)) {
                this.ikl.put(str, obj);
            }
            String ghi = ghi();
            if (!TextUtils.isEmpty(ghi)) {
                lmn(au.klm(bs.lmn().klm(), ghi));
            }
        }
    }
}
