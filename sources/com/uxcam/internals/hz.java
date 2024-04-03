package com.uxcam.internals;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class hz {

    /* renamed from: a  reason: collision with root package name */
    public String f13612a;

    /* renamed from: b  reason: collision with root package name */
    public Map f13613b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public hz f13614c;

    public hz() {
    }

    public void a() {
        this.f13613b = new HashMap();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject((Map<?, ?>) this.f13613b);
        try {
            String str = this.f13612a;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("kUXCam_UserIdentity", (Object) this.f13612a);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public hz(String str) {
        this.f13612a = str;
    }
}
