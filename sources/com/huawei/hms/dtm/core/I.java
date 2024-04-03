package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.l;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
class I implements D {

    /* renamed from: a  reason: collision with root package name */
    private final Nc f48319a;

    public I(Nc nc2) {
        this.f48319a = nc2;
    }

    private List<C0371fd> a() {
        List<Qc<Wc<?>>> c11 = this.f48319a.c();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < c11.size(); i11++) {
            Qc qc2 = c11.get(i11);
            if (qc2 == null) {
                Logger.warn("DTM-Decode", "IExecNode is null in decodeResourcesVariables");
            } else if ("__vt".equals(qc2.b())) {
                C0371fd fdVar = new C0371fd();
                Map params = qc2.getParams();
                if (a(i11, qc2, fdVar, params)) {
                    Wc wc2 = (Wc) params.get("xpath");
                    if (wc2 instanceof C0346ad) {
                        fdVar.c((String) ((C0346ad) wc2).getValue());
                    }
                    Wc wc3 = (Wc) params.get("page");
                    if (wc3 instanceof C0346ad) {
                        fdVar.b((String) ((C0346ad) wc3).getValue());
                    }
                    arrayList.add(fdVar);
                }
            }
        }
        c11.clear();
        return arrayList;
    }

    private List<C0361dd> a(List<Oc> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Oc oc2 = list.get(i11);
            if (oc2 != null) {
                C0361dd ddVar = new C0361dd();
                ddVar.a(i11);
                ddVar.a(a(oc2));
                List<Rc> c11 = oc2.c();
                String b11 = b(c11);
                if (!TextUtils.isEmpty(b11)) {
                    ddVar.b(b11);
                    a(ddVar, c11);
                    arrayList.add(ddVar);
                }
            }
        }
        return arrayList;
    }

    private void a(C0361dd ddVar, Rc rc2) {
        if ("_vp".equals(rc2.a()) && rc2.d() != null && rc2.d().size() > 0) {
            ddVar.b(rc2.d());
        }
    }

    private void a(C0361dd ddVar, String str, String str2) {
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -825339898:
                if (str2.equals("$DTM_AT_XPATH_LIST")) {
                    c11 = 0;
                    break;
                }
                break;
            case -232307552:
                if (str2.equals("$DTM_AT_TYPE")) {
                    c11 = 1;
                    break;
                }
                break;
            case 68641143:
                if (str2.equals("$DTM_AT_TARGET")) {
                    c11 = 2;
                    break;
                }
                break;
            case 322715955:
                if (str2.equals("$DTM_AT_CONTENT")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1391812567:
                if (str2.equals("$DTM_AT_XPATH")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                ddVar.e(str);
                ddVar.d(true);
                return;
            case 1:
            case 4:
                ddVar.e(str);
                return;
            case 2:
                ddVar.c(str);
                return;
            case 3:
                ddVar.c(true);
                ddVar.a(str);
                return;
            default:
                return;
        }
    }

    private void a(C0361dd ddVar, List<Rc> list) {
        for (Rc next : list) {
            if (next != null) {
                b(ddVar, next);
                a(ddVar, next);
            }
        }
    }

    private void a(List<Oc> list, List<C0371fd> list2) {
        b(a(list), list2);
    }

    private void a(JSONObject jSONObject) throws JSONException {
        boolean z11;
        List asList = Arrays.asList(new Integer[]{C0356cd.f48455a, C0356cd.f48456b, C0356cd.f48457c, C0356cd.f48458d});
        List<String> f11 = this.f48319a.f();
        List<C0361dd> g11 = this.f48319a.g();
        JSONArray jSONArray = jSONObject.getJSONArray("visual");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            if (jSONObject2 != null) {
                C0361dd ddVar = new C0361dd();
                ddVar.b(true);
                if (jSONObject2.has("name")) {
                    ddVar.b(jSONObject2.getString("name"));
                }
                if (jSONObject2.has("pageId")) {
                    String string = jSONObject2.getString("pageId");
                    ddVar.c(string);
                    if (!f11.contains(string)) {
                        f11.add(string);
                    }
                }
                if (jSONObject2.has("type")) {
                    int i12 = jSONObject2.getInt("type");
                    z11 = asList.contains(Integer.valueOf(i12));
                    ddVar.d(C0356cd.f48456b.intValue() == i12);
                    ddVar.c(C0356cd.f48458d.intValue() == i12);
                } else {
                    z11 = false;
                }
                a(jSONObject2, ddVar);
                if (z11 && !TextUtils.isEmpty(ddVar.c()) && !TextUtils.isEmpty(ddVar.d())) {
                    g11.add(ddVar);
                }
            }
        }
    }

    private void a(JSONObject jSONObject, C0361dd ddVar) throws JSONException {
        if (jSONObject.has("xpath")) {
            ddVar.e(jSONObject.getString("xpath"));
        }
        if (jSONObject.has("tag_template")) {
            ddVar.d(jSONObject.getString("tag_template"));
        }
        if (jSONObject.has("content")) {
            ddVar.a(jSONObject.getString("content"));
        }
        if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject2.getString(next);
                C0366ed edVar = new C0366ed();
                edVar.a(next);
                edVar.b(ddVar.d());
                edVar.c(string);
                arrayList.add(edVar);
            }
            if (!arrayList.isEmpty()) {
                ddVar.a((List<C0366ed>) arrayList);
            }
        }
    }

    private boolean a(int i11, Qc<Wc<?>> qc2, C0371fd fdVar, Map<String, Wc<?>> map) {
        String name2 = qc2.getName();
        if (TextUtils.isEmpty(name2)) {
            Logger.warn("DTM-Decode", "Variable's name is empty in decodeVariableNameAndIndex");
            return false;
        } else if (name2.startsWith("__vt_")) {
            Wc wc2 = map.get("name");
            if (wc2 instanceof C0346ad) {
                fdVar.a((String) ((C0346ad) wc2).getValue());
            }
            fdVar.a(i11);
            return true;
        } else {
            fdVar.a(name2);
            return true;
        }
    }

    private boolean a(Oc oc2) {
        if (oc2 == null || oc2.a() == null) {
            return false;
        }
        for (Qc next : oc2.a()) {
            if (next != null && "__ha".equals(next.b())) {
                return true;
            }
        }
        return false;
    }

    private String b(List<Rc> list) {
        for (Rc next : list) {
            if ("_vp".equals(next.a())) {
                Wc<?> c11 = next.c();
                if (c11 instanceof C0346ad) {
                    return (String) ((C0346ad) c11).getValue();
                }
            }
        }
        return "";
    }

    private void b(C0361dd ddVar, Rc rc2) {
        Wc<?> c11 = rc2.c();
        Wc<?> b11 = rc2.b();
        if ((c11 instanceof C0346ad) && (b11 instanceof C0351bd)) {
            String str = (String) ((C0346ad) c11).getValue();
            String str2 = (String) ((C0351bd) b11).getValue();
            if (!TextUtils.isEmpty(str2)) {
                a(ddVar, str, str2);
            }
        }
    }

    private void b(List<C0361dd> list, List<C0371fd> list2) {
        for (C0361dd next : list) {
            ArrayList arrayList = new ArrayList();
            List<Integer> f11 = next.f();
            String str = next.c() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
            for (C0371fd next2 : list2) {
                String b11 = next2.b();
                boolean z11 = true;
                boolean z12 = f11 != null && f11.size() > 0;
                C0366ed edVar = new C0366ed();
                if (z12) {
                    z11 = f11.contains(Integer.valueOf(next2.a()));
                } else {
                    if (TextUtils.isEmpty(b11) || !b11.startsWith(str)) {
                        z11 = false;
                    }
                    b11 = l.a(b11);
                }
                if (z11) {
                    edVar.a(b11);
                    edVar.b(next2.c());
                    edVar.c(next2.d());
                    arrayList.add(edVar);
                }
            }
            next.a((List<C0366ed>) arrayList);
        }
        this.f48319a.g().addAll(list);
    }

    private void b(JSONObject jSONObject) {
        try {
            String str = "";
            String string = !jSONObject.isNull("function") ? jSONObject.getString("function") : str;
            if (!jSONObject.isNull("visual")) {
                JSONArray jSONArray = jSONObject.getJSONArray("visual");
                str = !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    arrayList.add(((JSONObject) jSONArray.get(i11)).getString("pageId"));
                }
                this.f48319a.h().addAll(arrayList);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("!(function(){");
            sb2.append(string);
            sb2.append("})(");
            sb2.append(str);
            sb2.append(",'android');");
            C0416od.a(sb2.toString(), "dtm-tracker.js");
        } catch (JSONException e11) {
            Logger.error("DTM-Decode", "failed to decode WebView:" + e11.getMessage());
        }
    }

    public void a(JSONObject jSONObject, Set<String> set) throws JSONException {
        if (jSONObject.has("resources")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resources");
            List arrayList = new ArrayList();
            if (jSONObject2.has("variables")) {
                arrayList = a();
            }
            if (jSONObject2.has("visual")) {
                a(jSONObject2);
            }
            a(this.f48319a.b(), (List<C0371fd>) arrayList);
            if (jSONObject2.has("webview")) {
                b(jSONObject2.getJSONObject("webview"));
            }
        }
    }
}
