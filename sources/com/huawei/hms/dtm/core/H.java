package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class H implements D {

    /* renamed from: a  reason: collision with root package name */
    private final Nc f48312a;

    public H(Nc nc2) {
        this.f48312a = nc2;
    }

    private Wc<?> a(Object obj, List<String> list) throws JSONException {
        if (obj instanceof String) {
            return new C0346ad((String) obj);
        }
        if (obj instanceof Integer) {
            return new Xc((Integer) obj);
        }
        if (obj instanceof Double) {
            return new Uc((Double) obj);
        }
        if (obj instanceof Boolean) {
            return Tc.a(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Long) {
            return new Zc((Long) obj);
        }
        if (obj instanceof JSONArray) {
            return d((JSONArray) obj, list);
        }
        throw new JSONException("invalid type#" + obj);
    }

    private Wc<?> a(JSONArray jSONArray, List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < jSONArray.length(); i11++) {
            arrayList.add(a(jSONArray.get(i11), list));
        }
        return new Vc(arrayList);
    }

    private List<Integer> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() >= 4) {
            Object obj = jSONArray.get(3);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    arrayList.add(Integer.valueOf(jSONArray2.getInt(i11)));
                }
            } else {
                throw new JSONException("Decoding operator's varIndexList exception.");
            }
        }
        return arrayList;
    }

    private List<Qc<Wc<?>>> a(JSONArray jSONArray, List<String> list, Set<String> set) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            if (jSONObject != null) {
                Pc pc2 = new Pc();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject.get(next);
                    if ("exec".equals(next)) {
                        if (obj instanceof String) {
                            pc2.a((String) obj);
                        } else {
                            throw new JSONException("execute#invalid exec");
                        }
                    } else if ("name".equals(next)) {
                        if (obj instanceof String) {
                            pc2.b((String) obj);
                        } else {
                            throw new JSONException("execute#invalid name");
                        }
                    } else if (!NativeProtocol.WEB_DIALOG_PARAMS.equals(next)) {
                        pc2.a(next, a(obj, list));
                    } else if (obj instanceof JSONObject) {
                        pc2.a(a((JSONObject) obj, list));
                    } else {
                        throw new JSONException("execute#invalid params");
                    }
                }
                set.add(pc2.b());
                arrayList.add(pc2);
            }
        }
        return arrayList;
    }

    private Map<String, Wc<?>> a(JSONObject jSONObject, List<String> list) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next), list));
        }
        return hashMap;
    }

    private void a(Oc oc2) {
        if (!oc2.d()) {
            for (Oc next : this.f48312a.b()) {
                if (next.equals(oc2)) {
                    next.a(oc2.a());
                    next.b(oc2.b());
                    return;
                }
            }
            this.f48312a.b().add(oc2);
        }
    }

    private void a(Wc<?> wc2, Wc<?> wc3) {
        if ("$DTM_AT_TARGET".equals(wc2.getValue().toString())) {
            this.f48312a.f().add(wc3.getValue().toString());
        }
    }

    private void a(List<Qc<Wc<?>>> list, List<Rc> list2) throws JSONException {
        for (Qc next : list) {
            Wc wc2 = (Wc) next.a().get("conditions");
            if (!(wc2 instanceof Yc)) {
                Logger.warn("DTM-Decode", "conditions not list");
            } else {
                for (Wc wc3 : (List) ((Yc) wc2).getValue()) {
                    if (!(wc3 instanceof Yc)) {
                        throw new JSONException("condition not list");
                    } else if (!a((Qc<Wc<?>>) next, (Yc) wc3, list2)) {
                        throw new JSONException("Conditions configured wrong for tag " + next.getName());
                    }
                }
                continue;
            }
        }
    }

    private boolean a(Qc<Wc<?>> qc2, Yc yc2, List<Rc> list) {
        int intValue;
        List list2 = (List) yc2.getValue();
        if (list2.size() < 1) {
            return false;
        }
        Wc wc2 = (Wc) list2.get(0);
        if (!(wc2 instanceof Xc)) {
            return false;
        }
        Oc oc2 = new Oc();
        for (int i11 = 1; i11 < list2.size(); i11++) {
            Wc wc3 = (Wc) list2.get(i11);
            if (!(wc3 instanceof Xc) || (intValue = ((Integer) ((Xc) wc3).getValue()).intValue()) >= list.size()) {
                return false;
            }
            oc2.a(list.get(intValue));
        }
        if (((Integer) ((Xc) wc2).getValue()).intValue() == 0) {
            oc2.a((Qc<?>) qc2);
        } else {
            oc2.b((Qc<?>) qc2);
        }
        a(oc2);
        return true;
    }

    private Wc<?> b(JSONArray jSONArray, List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < jSONArray.length(); i11++) {
            arrayList.add(a(jSONArray.get(i11), list));
        }
        return new Yc(arrayList);
    }

    private List<Rc> b(JSONArray jSONArray, List<String> list, Set<String> set) throws JSONException {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() >= 3) {
                    String string = jSONArray2.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        if (set != null) {
                            set.add(string);
                        }
                        Wc<?> a11 = a(jSONArray2.get(1), list);
                        Wc<?> a12 = a(jSONArray2.get(2), list);
                        arrayList.add(new Rc(string, a11, a12, a(jSONArray2)));
                        a(a11, a12);
                        i11++;
                    } else {
                        throw new JSONException("operator#empty operator#" + i11);
                    }
                } else {
                    throw new JSONException("operator#invalid size#" + i11);
                }
            } else {
                throw new JSONException("operator#invalid type#" + i11);
            }
        }
        return arrayList;
    }

    private Wc<?> c(JSONArray jSONArray, List<String> list) throws JSONException {
        if (jSONArray.length() != 0) {
            if (Math.abs(jSONArray.length()) % 2 == 1) {
                HashMap hashMap = new HashMap();
                for (int i11 = 1; i11 < jSONArray.length(); i11 += 2) {
                    hashMap.put(a(jSONArray.get(i11), list), a(jSONArray.get(i11 + 1), list));
                }
                return new _c(hashMap);
            }
        }
        throw new JSONException("wrong map size");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r2.equals(com.huawei.hms.flutter.map.constants.Param.MAP) == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.dtm.core.Wc<?> d(org.json.JSONArray r6, java.util.List<java.lang.String> r7) throws org.json.JSONException {
        /*
            r5 = this;
            int r0 = r6.length()
            r1 = 1
            if (r0 < r1) goto L_0x0070
            r0 = 0
            java.lang.String r2 = r6.getString(r0)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = -1
            switch(r3) {
                case -1202757124: goto L_0x0038;
                case 107868: goto L_0x002f;
                case 116519: goto L_0x0024;
                case 3322014: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            r1 = r4
            goto L_0x0042
        L_0x0019:
            java.lang.String r0 = "list"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x0017
        L_0x0022:
            r1 = 3
            goto L_0x0042
        L_0x0024:
            java.lang.String r0 = "var"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            r1 = 2
            goto L_0x0042
        L_0x002f:
            java.lang.String r0 = "map"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x0017
        L_0x0038:
            java.lang.String r1 = "hybrid"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0041
            goto L_0x0017
        L_0x0041:
            r1 = r0
        L_0x0042:
            switch(r1) {
                case 0: goto L_0x006b;
                case 1: goto L_0x0066;
                case 2: goto L_0x0061;
                case 3: goto L_0x005c;
                default: goto L_0x0045;
            }
        L_0x0045:
            org.json.JSONException r6 = new org.json.JSONException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "invalid type#"
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x005c:
            com.huawei.hms.dtm.core.Wc r6 = r5.b(r6, r7)
            return r6
        L_0x0061:
            com.huawei.hms.dtm.core.Wc r6 = r5.e(r6, r7)
            return r6
        L_0x0066:
            com.huawei.hms.dtm.core.Wc r6 = r5.c(r6, r7)
            return r6
        L_0x006b:
            com.huawei.hms.dtm.core.Wc r6 = r5.a((org.json.JSONArray) r6, (java.util.List<java.lang.String>) r7)
            return r6
        L_0x0070:
            org.json.JSONException r7 = new org.json.JSONException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "invalid value#"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>((java.lang.String) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.H.d(org.json.JSONArray, java.util.List):com.huawei.hms.dtm.core.Wc");
    }

    private Wc<?> e(JSONArray jSONArray, List<String> list) throws JSONException {
        int i11 = jSONArray.getInt(1);
        if (i11 >= 0 && i11 < list.size()) {
            return new C0351bd(list.get(i11));
        }
        throw new JSONException("invalid variable index#" + i11);
    }

    public void a(JSONObject jSONObject, Set<String> set) throws JSONException {
        this.f48312a.a();
        if (jSONObject.has("resources")) {
            Object obj = jSONObject.get("resources");
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                this.f48312a.b(jSONObject2.optString("version"));
                List arrayList = new ArrayList();
                if (jSONObject2.has("variables")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("variables");
                    List a11 = E.a(jSONArray);
                    List<Qc<Wc<?>>> a12 = a(jSONArray, (List<String>) a11, set);
                    this.f48312a.c().addAll(a12);
                    for (Qc<Wc<?>> a13 : a12) {
                        this.f48312a.a((Qc<?>) a13);
                    }
                    arrayList = a11;
                }
                List<Rc> arrayList2 = new ArrayList<>();
                if (jSONObject2.has("conditions")) {
                    arrayList2 = b(jSONObject2.getJSONArray("conditions"), arrayList, set);
                }
                List<Qc<Wc<?>>> arrayList3 = new ArrayList<>();
                if (jSONObject2.has("tags")) {
                    arrayList3 = a(jSONObject2.getJSONArray("tags"), (List<String>) arrayList, set);
                }
                a(arrayList3, arrayList2);
                return;
            }
            throw new JSONException("resource map not found");
        }
    }
}
