package com.apptimize;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.security.CertificateUtil;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bt implements bw, cs {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41497a = "bt";

    /* renamed from: b  reason: collision with root package name */
    private bv f41498b;

    /* renamed from: c  reason: collision with root package name */
    private cf f41499c;

    public static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        private final String f41500b;

        public a(String str, String str2, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41500b = str2;
        }

        public String a() {
            return "block";
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            jSONObject.put(HexAttribute.HEX_ATTR_METHOD_NAME, (Object) this.f41500b);
        }

        public String g() {
            return this.f41500b;
        }

        /* renamed from: h */
        public String i() {
            return this.f41500b;
        }
    }

    public static abstract class f extends bt {

        /* renamed from: a  reason: collision with root package name */
        protected final String f41505a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f41506b;

        public f(String str, boolean z11, bv bvVar, cf cfVar) {
            super(bvVar, cfVar);
            this.f41505a = str;
            this.f41506b = z11;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            jSONObject.put("key", (Object) this.f41505a);
            boolean z11 = this.f41506b;
            if (z11) {
                jSONObject.put("useDefaultValue", z11);
            }
        }

        public abstract Object i();

        public String j() {
            return bt.a(a(), (String) null, this.f41505a);
        }

        public boolean k() {
            return this.f41506b;
        }
    }

    public static abstract class h extends f {

        /* renamed from: b  reason: collision with root package name */
        protected final String f41508b;

        public h(String str, String str2, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41508b = str2;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            jSONObject.put("nestedType", (Object) this.f41508b);
        }

        public String h() {
            return this.f41508b;
        }

        public String j() {
            return bt.a(a(), this.f41508b, this.f41505a);
        }
    }

    public static class j extends bt {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f41510a;

        public String a() {
            return "unknown";
        }

        public void a(JSONObject jSONObject) throws JSONException {
        }

        private j(JSONObject jSONObject) {
            super(bv.f41512a, cf.f41640a);
            this.f41510a = jSONObject;
        }
    }

    public static class k extends bt {

        /* renamed from: a  reason: collision with root package name */
        private final dc f41511a;

        public k(dc dcVar, bv bvVar, cf cfVar) {
            super(bvVar, cfVar);
            this.f41511a = dcVar;
        }

        public String a() {
            return "wysiwyg";
        }

        public void a(JSONObject jSONObject) throws JSONException {
            this.f41511a.b(jSONObject);
        }

        public dc g() {
            return this.f41511a;
        }

        public void a(List<dc> list) {
            list.add(this.f41511a);
        }
    }

    public static bt a(JSONObject jSONObject, au auVar) {
        try {
            String string = jSONObject.getString("type");
            bv a11 = bv.a(jSONObject, auVar);
            cf a12 = cf.a(jSONObject, auVar);
            if ("block".equals(string)) {
                return new a(jSONObject.getString("key"), jSONObject.getString(HexAttribute.HEX_ATTR_METHOD_NAME), false, a11, a12);
            }
            if (TypedValues.Custom.S_STRING.equals(string)) {
                return i.a(jSONObject, a11, a12);
            }
            if ("int".equals(string)) {
                return e.a(jSONObject, a11, a12);
            }
            if ("double".equals(string)) {
                return d.a(jSONObject, a11, a12);
            }
            if (TypedValues.Custom.S_BOOLEAN.equals(string)) {
                return b.a(jSONObject, a11, a12);
            }
            if (DefaultCardView.CARD_LIST.equals(string)) {
                return g.a(jSONObject, a11, a12);
            }
            if ("dictionary".equals(string)) {
                return c.a(jSONObject, a11, a12);
            }
            if ("wysiwyg".equals(string)) {
                return new k(dc.a(jSONObject), a11, a12);
            }
            String str = f41497a;
            bo.j(str, "Unknown alteration type " + jSONObject);
            return new j(jSONObject);
        } catch (JSONException e11) {
            String str2 = f41497a;
            bo.j(str2, "Unknown alteration type " + jSONObject + " " + e11);
            return new j(jSONObject);
        }
    }

    public abstract String a();

    public void a(List<dc> list) {
    }

    public abstract void a(JSONObject jSONObject) throws JSONException;

    public List<az> b() {
        return this.f41498b.a();
    }

    public List<az> c() {
        return this.f41499c.a();
    }

    public JSONObject d() throws JSONException {
        if (this instanceof j) {
            return ((j) this).f41510a;
        }
        JSONObject jSONObject = new JSONObject();
        this.f41498b.a(jSONObject);
        this.f41499c.a(jSONObject);
        jSONObject.put("type", (Object) a());
        a(jSONObject);
        return jSONObject;
    }

    public List<cs> e() {
        return Collections.emptyList();
    }

    private bt(bv bvVar, cf cfVar) {
        this.f41498b = bvVar;
        this.f41499c = cfVar;
    }

    public static class b extends f {

        /* renamed from: b  reason: collision with root package name */
        private final Boolean f41501b;

        public b(String str, Boolean bool, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41501b = bool;
        }

        public static b a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            return new b(jSONObject.getString("key"), !jSONObject.isNull("value") ? Boolean.valueOf(jSONObject.getBoolean("value")) : null, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return TypedValues.Custom.S_BOOLEAN;
        }

        /* renamed from: g */
        public Boolean i() {
            return this.f41501b;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            Boolean bool = this.f41501b;
            if (bool != null) {
                jSONObject.put("value", (Object) bool);
            } else {
                jSONObject.put("value", JSONObject.NULL);
            }
        }
    }

    public static class d extends f {

        /* renamed from: b  reason: collision with root package name */
        private final Double f41503b;

        public d(String str, Double d11, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41503b = d11;
        }

        public static d a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            return new d(jSONObject.getString("key"), !jSONObject.isNull("value") ? Double.valueOf(jSONObject.getDouble("value")) : null, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return "double";
        }

        /* renamed from: g */
        public Double i() {
            return this.f41503b;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            Double d11 = this.f41503b;
            if (d11 != null) {
                jSONObject.put("value", (Object) d11);
            } else {
                jSONObject.put("value", JSONObject.NULL);
            }
        }
    }

    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        private final Integer f41504b;

        public e(String str, Integer num, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41504b = num;
        }

        public static e a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            return new e(jSONObject.getString("key"), !jSONObject.isNull("value") ? Integer.valueOf(jSONObject.getInt("value")) : null, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return "int";
        }

        /* renamed from: g */
        public Integer i() {
            return this.f41504b;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            Integer num = this.f41504b;
            if (num != null) {
                jSONObject.put("value", (Object) num);
            } else {
                jSONObject.put("value", JSONObject.NULL);
            }
        }
    }

    public static class i extends f {

        /* renamed from: b  reason: collision with root package name */
        private final String f41509b;

        public i(String str, String str2, boolean z11, bv bvVar, cf cfVar) {
            super(str, z11, bvVar, cfVar);
            this.f41509b = str2;
        }

        public static i a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            return new i(jSONObject.getString("key"), !jSONObject.isNull("value") ? jSONObject.getString("value") : null, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return TypedValues.Custom.S_STRING;
        }

        /* renamed from: g */
        public String i() {
            return this.f41509b;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            String str = this.f41509b;
            if (str != null) {
                jSONObject.put("value", (Object) str);
            } else {
                jSONObject.put("value", JSONObject.NULL);
            }
        }
    }

    public static class g extends h {

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f41507c;

        public g(String str, String str2, List<Object> list, boolean z11, bv bvVar, cf cfVar) {
            super(str, str2, z11, bvVar, cfVar);
            this.f41507c = list;
        }

        public static bt a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            String string = jSONObject.getString("nestedType");
            ArrayList arrayList = null;
            if (!jSONObject.isNull("value")) {
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    if (jSONArray.isNull(i11)) {
                        arrayList2.add((Object) null);
                    } else if (TypedValues.Custom.S_STRING.equals(string)) {
                        arrayList2.add(jSONArray.getString(i11));
                    } else if ("int".equals(string)) {
                        arrayList2.add(Integer.valueOf(jSONArray.getInt(i11)));
                    } else if ("double".equals(string)) {
                        arrayList2.add(Double.valueOf(jSONArray.getDouble(i11)));
                    } else if (TypedValues.Custom.S_BOOLEAN.equals(string)) {
                        arrayList2.add(Boolean.valueOf(jSONArray.getBoolean(i11)));
                    } else {
                        String f11 = bt.f41497a;
                        bo.f(f11, "Received value for a List ApptimizeVar '" + jSONObject.getString("key") + "' with an unrecognized nested type '" + string + "'; received value will be ignored.");
                        return new j(jSONObject);
                    }
                }
                arrayList = arrayList2;
            }
            return new g(jSONObject.getString("key"), string, arrayList, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return DefaultCardView.CARD_LIST;
        }

        /* renamed from: g */
        public List<Object> i() {
            return this.f41507c;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            List<Object> list = this.f41507c;
            if (list != null) {
                jSONObject.put("value", (Object) new JSONArray((Collection<?>) list));
            } else {
                jSONObject.put("value", JSONObject.NULL);
            }
        }
    }

    public static class c extends h {

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Object> f41502c;

        public c(String str, String str2, Map<String, Object> map, boolean z11, bv bvVar, cf cfVar) {
            super(str, str2, z11, bvVar, cfVar);
            this.f41502c = map;
        }

        public static bt a(JSONObject jSONObject, bv bvVar, cf cfVar) throws JSONException {
            String string = jSONObject.getString("nestedType");
            HashMap hashMap = null;
            if (!jSONObject.isNull("value")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("value");
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (jSONObject2.isNull(next)) {
                        hashMap2.put(next, (Object) null);
                    } else if (TypedValues.Custom.S_STRING.equals(string)) {
                        hashMap2.put(next, jSONObject2.getString(next));
                    } else if ("int".equals(string)) {
                        hashMap2.put(next, Integer.valueOf(jSONObject2.getInt(next)));
                    } else if ("double".equals(string)) {
                        hashMap2.put(next, Double.valueOf(jSONObject2.getDouble(next)));
                    } else if (TypedValues.Custom.S_BOOLEAN.equals(string)) {
                        hashMap2.put(next, Boolean.valueOf(jSONObject2.getBoolean(next)));
                    } else {
                        String f11 = bt.f41497a;
                        bo.f(f11, "Received value for a Dictionary ApptimizeVar '" + jSONObject.getString("key") + "' with an unrecognized nested type '" + string + "'; received value will be ignored.");
                        return new j(jSONObject);
                    }
                }
                hashMap = hashMap2;
            }
            return new c(jSONObject.getString("key"), string, hashMap, jSONObject.optBoolean("useDefaultValue"), bvVar, cfVar);
        }

        public String a() {
            return "dictionary";
        }

        /* renamed from: g */
        public Map<String, Object> i() {
            return this.f41502c;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            if (this.f41502c != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : this.f41502c.entrySet()) {
                    if (next.getValue() != null) {
                        jSONObject2.put((String) next.getKey(), next.getValue());
                    } else {
                        jSONObject2.put((String) next.getKey(), JSONObject.NULL);
                    }
                }
                jSONObject.put("value", (Object) jSONObject2);
                return;
            }
            jSONObject.put("value", JSONObject.NULL);
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str2 != null) {
            return str + "/" + str2 + CertificateUtil.DELIMITER + str3;
        }
        return str + CertificateUtil.DELIMITER + str3;
    }

    public static String a(String str) {
        String[] split = str.split(CertificateUtil.DELIMITER, 2);
        if (split.length <= 1) {
            bo.e(f41497a, "Alteration key was not prefixed with type. This should never happen.");
            return str;
        }
        String str2 = split[0];
        String[] split2 = str2.split("/", 2);
        if (split2.length < 2) {
            return "'" + split[1] + "' of type " + str2;
        } else if (split2[0].equals("dictionary")) {
            return "'" + split[1] + "' of type map of " + split2[1] + "s";
        } else {
            return "'" + split[1] + "' of type " + split2[0] + " of " + split2[1] + "s";
        }
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
