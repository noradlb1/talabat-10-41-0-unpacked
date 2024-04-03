package com.apptimize;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ce implements cs {

    /* renamed from: a  reason: collision with root package name */
    private String f41635a;

    /* renamed from: b  reason: collision with root package name */
    private List<az> f41636b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41637c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41638d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41639e;

    private ce(String str, List<az> list, boolean z11, boolean z12, boolean z13) {
        this.f41635a = str;
        this.f41636b = Collections.unmodifiableList(new ArrayList(list));
        this.f41637c = z11;
        this.f41638d = z12;
        this.f41639e = z13;
    }

    public static ce a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        String optString = jSONObject.optString("filterName");
        if (optString == null || optString.equals("")) {
            optString = "unknown_named_filter";
        }
        String str = optString;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        int length = optJSONArray != null ? optJSONArray.length() : 0;
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(az.a(optJSONArray.getJSONObject(i11), auVar));
        }
        return new ce(str, arrayList, jSONObject.optBoolean("trueIsSticky", false), jSONObject.optBoolean("falseIsSticky", false), jSONObject.optBoolean("nullIsSticky", false));
    }

    public String b() {
        return this.f41635a;
    }

    public List<az> c() {
        return Collections.unmodifiableList(this.f41636b);
    }

    public List<cs> e() {
        return Collections.emptyList();
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("filterName", (Object) this.f41635a);
        jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_FILTERS, (Object) az.a(this.f41636b));
        jSONObject.put("trueIsSticky", this.f41637c);
        jSONObject.put("falseIsSticky", this.f41638d);
        jSONObject.put("nullIsSticky", this.f41639e);
        return jSONObject;
    }

    public boolean a(Boolean bool) {
        if (bool == null) {
            return this.f41639e;
        }
        return bool.booleanValue() ? this.f41637c : this.f41638d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean a(com.apptimize.bb r3, java.util.Map<java.lang.String, java.lang.Boolean> r4) {
        /*
            r2 = this;
            java.lang.String r0 = r2.f41635a
            boolean r0 = r4.containsKey(r0)
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r2.f41635a
            java.lang.Object r4 = r4.get(r0)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r0 = r2.a((java.lang.Boolean) r4)
            if (r0 == 0) goto L_0x0017
            return r4
        L_0x0017:
            java.util.List<com.apptimize.az> r4 = r2.f41636b
            java.util.Iterator r4 = r4.iterator()
        L_0x001d:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r4.next()
            com.apptimize.az r0 = (com.apptimize.az) r0
            java.lang.Boolean r0 = r0.b((com.apptimize.bb) r3)
            if (r0 == 0) goto L_0x0035
            boolean r1 = r0.booleanValue()
            if (r1 != 0) goto L_0x001d
        L_0x0035:
            return r0
        L_0x0036:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ce.a(com.apptimize.bb, java.util.Map):java.lang.Boolean");
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
