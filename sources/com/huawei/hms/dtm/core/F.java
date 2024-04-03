package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class F {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48294a = true;

    /* renamed from: b  reason: collision with root package name */
    private final D f48295b;

    /* renamed from: c  reason: collision with root package name */
    private final D f48296c;

    /* renamed from: d  reason: collision with root package name */
    private final D f48297d;

    public F(Nc nc2, W w11) {
        this.f48295b = new H(nc2);
        this.f48296c = new G(w11);
        this.f48297d = new I(nc2);
    }

    private boolean a(JSONObject jSONObject) throws JSONException {
        String str;
        if (jSONObject.has("switch_ha")) {
            Object obj = jSONObject.get("switch_ha");
            if (!(obj instanceof Boolean)) {
                str = "not boolean, use true";
            } else {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                Logger.warn("DTM-Decode", "report open#" + booleanValue);
                return booleanValue;
            }
        } else {
            str = "switch_ha not exist, use true";
        }
        Logger.warn("DTM-Decode", str);
        return true;
    }

    public void a(String str) {
        String str2;
        Logger.info("DTM-Decode", "decode json begin...");
        if (TextUtils.isEmpty(str)) {
            Logger.error("DTM-Decode", "decode json#empty json");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f48294a = a(jSONObject);
            HashSet hashSet = new HashSet();
            this.f48295b.a(jSONObject, hashSet);
            this.f48296c.a(jSONObject, hashSet);
            this.f48297d.a(jSONObject, hashSet);
            Logger.info("DTM-Decode", "decode json#success");
            return;
        } catch (JSONException e11) {
            str2 = "decode json#" + e11.getMessage();
        } catch (NullPointerException unused) {
            str2 = "decode json#NullPointerException";
        }
        Logger.error("DTM-Decode", str2);
    }

    public boolean a() {
        return this.f48294a;
    }
}
