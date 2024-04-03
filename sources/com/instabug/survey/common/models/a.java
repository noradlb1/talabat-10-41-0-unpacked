package com.instabug.survey.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.NewRateActivity;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class a implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private C0096a f52324a;

    /* renamed from: b  reason: collision with root package name */
    public long f52325b;

    /* renamed from: c  reason: collision with root package name */
    public int f52326c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52327d = false;

    /* renamed from: com.instabug.survey.common.models.a$a  reason: collision with other inner class name */
    public enum C0096a {
        SHOW("show"),
        DISMISS("dismiss"),
        SUBMIT("submit"),
        RATE(NewRateActivity.RATE),
        UNDEFINED(AdError.UNDEFINED_DOMAIN);
        

        /* renamed from: a  reason: collision with root package name */
        private final String f52334a;

        private C0096a(String str) {
            this.f52334a = str;
        }

        public String toString() {
            return this.f52334a;
        }
    }

    private a() {
    }

    public a(@NonNull C0096a aVar, long j11, int i11) {
        this.f52324a = aVar;
        this.f52325b = j11;
        this.f52326c = i11;
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            a aVar = new a();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            aVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (arrayList.get(i11) != null) {
                    jSONArray.put((Object) new JSONObject(((a) arrayList.get(i11)).toJson()));
                }
            }
        }
        return jSONArray;
    }

    @Nullable
    public C0096a a() {
        return this.f52324a;
    }

    public void a(int i11) {
        this.f52326c = i11;
    }

    public void a(long j11) {
        this.f52325b = j11;
    }

    public void a(@NonNull C0096a aVar) {
        this.f52324a = aVar;
    }

    public void a(boolean z11) {
        this.f52327d = z11;
    }

    public int b() {
        return this.f52326c;
    }

    public long c() {
        return this.f52325b;
    }

    public boolean d() {
        return this.f52327d;
    }

    public void fromJson(String str) {
        C0096a aVar;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("event_type")) {
            String string = jSONObject.getString("event_type");
            string.hashCode();
            char c11 = 65535;
            switch (string.hashCode()) {
                case -891535336:
                    if (string.equals("submit")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3493088:
                    if (string.equals(NewRateActivity.RATE)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3529469:
                    if (string.equals("show")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1671672458:
                    if (string.equals("dismiss")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    aVar = C0096a.SUBMIT;
                    break;
                case 1:
                    aVar = C0096a.RATE;
                    break;
                case 2:
                    aVar = C0096a.SHOW;
                    break;
                case 3:
                    aVar = C0096a.DISMISS;
                    break;
                default:
                    aVar = C0096a.UNDEFINED;
                    break;
            }
            a(aVar);
        }
        if (jSONObject.has(FirebaseAnalytics.Param.INDEX)) {
            a(jSONObject.getInt(FirebaseAnalytics.Param.INDEX));
        }
        if (jSONObject.has("timestamp")) {
            a(jSONObject.getLong("timestamp"));
        }
        if (jSONObject.has(CalibrationDiagnosticEvent.Action.Synced)) {
            a(jSONObject.getBoolean(CalibrationDiagnosticEvent.Action.Synced));
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_type", (Object) a() == null ? "" : a().toString());
        jSONObject.put(FirebaseAnalytics.Param.INDEX, b());
        jSONObject.put("timestamp", this.f52325b);
        jSONObject.put(CalibrationDiagnosticEvent.Action.Synced, this.f52327d);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
