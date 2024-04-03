package com.instabug.library.diagnostics.nonfatals.settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.settings.SettingsManager;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f34319a;

    /* renamed from: b  reason: collision with root package name */
    private int f34320b;

    /* renamed from: c  reason: collision with root package name */
    private int f34321c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Set f34322d;

    public void a(boolean z11) {
        this.f34319a = z11;
    }

    public int b() {
        return this.f34320b;
    }

    public int c() {
        return this.f34321c;
    }

    public boolean d() {
        return this.f34319a;
    }

    public void a(int i11) {
        this.f34320b = i11;
    }

    public void b(int i11) {
        this.f34321c = i11;
    }

    @Nullable
    public Set a() {
        return this.f34322d;
    }

    public void b(@NonNull JSONObject jSONObject) throws JSONException {
        boolean z11 = false;
        if (SettingsManager.getInstance().getFeatureState(Feature.NON_FATAL_ERRORS, false) == Feature.State.ENABLED) {
            z11 = true;
        }
        a(z11);
        a(jSONObject.optInt("non_fatals_max_count", 10));
        b(jSONObject.optInt("occurrences_max_count", 5));
        if (jSONObject.has("blacklist")) {
            try {
                a(a(jSONObject.getJSONObject("blacklist")));
            } catch (JSONException unused) {
                a((Set) null);
            }
        } else {
            a((Set) null);
        }
    }

    public void a(@Nullable Set set) {
        this.f34322d = set;
    }

    public void a(String str) throws JSONException {
        b(new JSONObject(str));
    }

    public Set a(@Nullable JSONObject jSONObject) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONObject != null && jSONObject.has("android")) {
            JSONArray jSONArray = jSONObject.getJSONArray("android");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                com.instabug.library.diagnostics.nonfatals.model.a aVar = new com.instabug.library.diagnostics.nonfatals.model.a();
                aVar.b(jSONObject2.getString("exception_type"));
                aVar.a(jSONObject2.getString("class"));
                aVar.c(jSONObject2.getString("file_name"));
                aVar.e(jSONObject2.getString("method_name"));
                hashSet.add(aVar);
            }
        }
        return hashSet;
    }
}
