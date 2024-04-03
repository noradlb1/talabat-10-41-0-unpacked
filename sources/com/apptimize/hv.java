package com.apptimize;

import android.widget.LinearLayout;
import org.json.JSONException;
import org.json.JSONObject;

public class hv {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42967a = "hv";

    public static void a(hl hlVar) {
        hlVar.b(hj.a("orientation", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("Horizontal", 0);
                    put("Vertical", 1);
                } catch (JSONException e11) {
                    bo.g(hv.f42967a, "Error initializing options: ", e11);
                }
            }
        }), LinearLayout.class));
    }
}
