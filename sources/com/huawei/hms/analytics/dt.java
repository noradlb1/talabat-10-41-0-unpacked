package com.huawei.hms.analytics;

import android.os.Bundle;
import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.type.HAParamType;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class dt {
    private final Map<String, String> bcd;
    private String cde;
    private String def;
    private boolean efg;
    private String fgh;
    private String ghi;
    private int hij;
    public JSONObject ijk;
    public final ArrayList<JSONObject> ikl;
    public Bundle klm;
    public Bundle lmn;

    public dt(String str, Bundle bundle) {
        this.hij = -1;
        this.def = null;
        this.cde = "_openness_config_tag";
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        this.ikl = arrayList;
        this.bcd = new HashMap();
        lmn(str);
        this.lmn = bundle;
        JSONObject lmn2 = dw.lmn(bundle);
        lmn(lmn2, this.ghi, this.fgh, "");
        arrayList.add(lmn2);
    }

    public dt(String str, String str2) {
        this.hij = -1;
        this.def = null;
        this.cde = "_openness_config_tag";
        this.ikl = new ArrayList<>();
        this.bcd = new HashMap();
        this.efg = false;
        this.cde = str2;
        lmn(str);
    }

    public dt(String str, JSONObject jSONObject) {
        this.hij = -1;
        this.def = null;
        this.cde = "_openness_config_tag";
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        this.ikl = arrayList;
        this.bcd = new HashMap();
        lmn(str);
        lmn(jSONObject, str, this.fgh, "");
        arrayList.add(jSONObject);
    }

    public dt(String str, boolean z11) {
        this.hij = -1;
        this.def = null;
        this.cde = "_openness_config_tag";
        this.ikl = new ArrayList<>();
        this.bcd = new HashMap();
        this.efg = z11;
        lmn(str);
    }

    private static List<bb> ghi(Bundle bundle) {
        ArrayList arrayList = new ArrayList(bundle.size());
        for (String next : bundle.keySet()) {
            if (next != null) {
                arrayList.add(new bb(next, bundle.get(next)));
            } else {
                HiLog.w("P_CEvtHandler", "event params key is null");
            }
        }
        Collections.sort(arrayList, new Cdo());
        return arrayList;
    }

    private Bundle hij(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        this.ikl.clear();
        JSONObject jSONObject = new JSONObject();
        Bundle bundle2 = new Bundle();
        Iterator<bb> it = ghi(bundle).iterator();
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bb next = it.next();
            if (i11 >= 2048) {
                HiLog.w("P_CEvtHandler", HiLog.ErrorCode.PE005, "The bundle size exceeds the limit.Unnecessary data is discarded.Limit size: 2048");
                break;
            }
            Object obj = next.klm;
            if (obj instanceof Bundle) {
                if (!z11) {
                    this.hij++;
                    bundle2.putBundle(next.lmn, klm(next.lmn, ghi((Bundle) obj)));
                    z11 = true;
                }
            } else if (obj instanceof List) {
                if (!z12) {
                    ArrayList<?> lmn2 = lmn(next.lmn, (List) obj);
                    lmn(jSONObject, next.lmn, this.def);
                    bundle2.putParcelableArrayList(next.lmn, lmn2);
                    z12 = true;
                }
            } else if (!dl.lmn(obj)) {
                HiLog.w("P_CEvtHandler", "The current data type is invalid.Key:" + next.lmn);
            } else if (klm(next.lmn)) {
                bundle2.putSerializable(next.lmn, (Serializable) obj);
                lmn(jSONObject, next.lmn, obj);
            }
            i11++;
        }
        lmn(jSONObject);
        this.ikl.add(jSONObject);
        return bundle2;
    }

    private Bundle ijk(Bundle bundle) {
        JSONObject jSONObject = this.ijk;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!bundle.containsKey(next)) {
                        bundle.putSerializable(next, (Serializable) this.ijk.get(next));
                    }
                } catch (Exception unused) {
                    HiLog.w("P_CEvtHandler", "def event params error");
                }
            }
        }
        return bundle;
    }

    private Bundle klm(String str, List<bb> list) {
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        int i11 = 0;
        for (bb next : list) {
            if (i11 >= 2048) {
                break;
            } else if (klm(next.lmn)) {
                i11++;
                String str2 = next.lmn;
                Object obj = next.klm;
                if (dl.lmn(obj)) {
                    bundle.putSerializable(str2, (Serializable) obj);
                    lmn(jSONObject, str2, obj);
                } else {
                    HiLog.e("P_CEvtHandler", "bundle value is error");
                }
            }
        }
        String str3 = this.fgh;
        String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(16);
        String uuid = UUID.randomUUID().toString();
        String str4 = "$sub_evt_rel_" + this.hij;
        this.bcd.put(str4, uuid);
        lmn(jSONObject, str4, uuid);
        lmn(jSONObject, "$sub_" + this.ghi + JavaConstant.Dynamic.DEFAULT_NAME + str + JavaConstant.Dynamic.DEFAULT_NAME + this.hij, generateSecureRandomStr, str3);
        this.ikl.add(jSONObject);
        return bundle;
    }

    private boolean klm(String str) {
        if (!this.efg || dl.lmn("bundleKey", str, aq.klm)) {
            return true;
        }
        HiLog.w("P_CEvtHandler", "bundle key check failed! ".concat(String.valueOf(str)));
        return false;
    }

    private ArrayList<?> lmn(String str, List<?> list) {
        ArrayList<?> arrayList = new ArrayList<>();
        int size = list.size();
        ArrayList arrayList2 = null;
        int i11 = 0;
        for (int i12 = 0; i12 < size && i11 < 50; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof Bundle) {
                this.hij++;
                i11++;
                arrayList.add(klm(str, ghi((Bundle) obj)));
            } else if (dl.lmn((Object) obj)) {
                i11++;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList.add(obj);
                arrayList2.add(obj);
            }
        }
        if (arrayList2 != null) {
            this.def = JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) arrayList2));
        }
        return arrayList;
    }

    private void lmn(String str) {
        this.ghi = str;
        this.fgh = RandomUtil.getInstance().generateSecureRandomStr(16);
    }

    private void lmn(JSONObject jSONObject) {
        for (Map.Entry next : this.bcd.entrySet()) {
            lmn(jSONObject, (String) next.getKey(), next.getValue());
        }
        lmn(jSONObject, this.ghi, this.fgh, "");
    }

    private static void lmn(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            HiLog.w("P_CEvtHandler", "put json exception ");
        }
    }

    private void lmn(JSONObject jSONObject, String str, String str2, String str3) {
        lmn(jSONObject, "^eventId", str);
        lmn(jSONObject, "^id", str2);
        lmn(jSONObject, "^pid", str3);
        if ("_openness_config_tag".equals(this.cde) || aq.fgh.contains(this.cde)) {
            lmn(jSONObject, HAParamType.TASKID, av.lmn().lmn.f47858e);
            if (!"$EnterScreen".equals(str) && !"$ExitScreen".equals(str)) {
                Bundle bundle = c.lmn().cde;
                lmn(jSONObject, "$PrePageId", bundle.getString("$PrevActivityClass", ""));
                lmn(jSONObject, "$CurrPageId", bundle.getString("$CurActivityClass", ""));
            }
        }
    }

    public final void ikl(Bundle bundle) {
        this.klm = ijk(bundle);
    }

    public final boolean klm(Bundle bundle) {
        Bundle hij2 = hij(bundle);
        this.lmn = hij2;
        return hij2.toString().length() <= 204800;
    }

    public final boolean lmn(Bundle bundle) {
        ijk(bundle);
        Bundle hij2 = hij(bundle);
        this.lmn = hij2;
        return hij2.toString().length() <= 204800;
    }
}
