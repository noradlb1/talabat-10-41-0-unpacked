package com.instabug.featuresrequest.models;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class e implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f46554a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f46555b;

    /* renamed from: c  reason: collision with root package name */
    private List f46556c = new ArrayList();

    public static e a(JSONObject jSONObject) {
        e eVar = new e();
        eVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        return eVar;
    }

    public int a() {
        return this.f46554a;
    }

    public void a(int i11) {
        this.f46554a = i11;
    }

    public void a(List list) {
        this.f46556c = list;
    }

    public void a(boolean z11) {
        this.f46555b = z11;
    }

    public List b() {
        return this.f46556c;
    }

    public boolean c() {
        return this.f46555b;
    }

    public void fromJson(String str) {
        InstabugSDKLogger.v("IBG-FR", "Parsing feature request response: " + str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("completed_features_count")) {
            a(jSONObject.getInt("completed_features_count"));
        }
        if (jSONObject.has("has_next_page")) {
            a(jSONObject.getBoolean("has_next_page"));
        }
        if (jSONObject.has("feature_reqs")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("feature_reqs");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i11));
                d dVar = new d(UserManagerWrapper.getUserName(), UserManagerWrapper.getUserEmail(), InstabugCore.getPushNotificationToken());
                dVar.fromJson(JSONObjectInstrumentation.toString(jSONObject2));
                arrayList.add(dVar);
            }
            a((List) arrayList);
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (d json : b()) {
            jSONArray.put((Object) json.toJson());
        }
        jSONObject.put("has_next_page", c()).put("completed_features_count", a()).put("feature_reqs", (Object) jSONArray);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
