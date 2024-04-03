package com.apptimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bn {

    /* renamed from: d  reason: collision with root package name */
    private static final String f41387d = "bn";

    /* renamed from: a  reason: collision with root package name */
    public final a f41388a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41389b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41390c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<dc> f41391a;

        /* renamed from: b  reason: collision with root package name */
        public final String f41392b;

        /* renamed from: c  reason: collision with root package name */
        public final String f41393c;

        private a(List<dc> list, String str, String str2) {
            this.f41391a = Collections.unmodifiableList(list);
            this.f41392b = str;
            this.f41393c = str2;
        }

        public static a a(JSONObject jSONObject) throws JSONException {
            return new a(dc.a(jSONObject.getJSONArray("styles")), jSONObject.getString("interfaceType"), jSONObject.getString("softwareVersion"));
        }
    }

    private bn(a aVar, String str, String str2) {
        this.f41388a = aVar;
        this.f41389b = str;
        this.f41390c = str2;
    }

    public static bn a(JSONObject jSONObject) throws JSONException {
        return new bn(a.a(jSONObject.getJSONObject("data")), jSONObject.getString("platform"), jSONObject.getString("version"));
    }

    public static List<bn> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            bn a11 = a(jSONArray.getJSONObject(i11));
            if (a11.a()) {
                arrayList.add(a11);
            }
        }
        return arrayList;
    }

    public boolean a() {
        if (this.f41388a.f41393c.equals(fx.a())) {
            return true;
        }
        bo.f(f41387d, String.format("Discarding WYSIWYG data because this library version (%s) does not match the data's (%s)", new Object[]{fx.a(), this.f41388a.f41393c}));
        return false;
    }
}
