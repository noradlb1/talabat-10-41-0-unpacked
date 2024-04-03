package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.bs;
import com.huawei.hms.analytics.core.crypto.AesCipher;
import com.huawei.hms.analytics.core.log.HiLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class au implements bs.lmn {
    private final String ijk;
    protected ConcurrentHashMap<String, Object> ikl;
    protected final Context klm;
    protected final String lmn;

    public au(Context context, String str, String str2) {
        this.klm = context;
        this.lmn = str;
        this.ijk = str2;
        bs lmn2 = bs.lmn();
        if (lmn2.lmn == null) {
            lmn2.lmn = new ArrayList();
        }
        lmn2.lmn.add(this);
    }

    private static boolean efg() {
        return true;
    }

    public static String klm(String str, String str2) {
        return efg() ? AesCipher.gcmEncrypt(str2, str) : AesCipher.encryptCbc(str2, str);
    }

    public static String lmn(String str, String str2) {
        return efg() ? AesCipher.gcmDecrypt(str2, str) : AesCipher.decryptCbc(str2, str);
    }

    public abstract void fgh();

    public final String ghi() {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.ikl;
        if (!(concurrentHashMap == null || concurrentHashMap.size() == 0)) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                for (Map.Entry next : this.ikl.entrySet()) {
                    jSONStringer.key((String) next.getKey()).value(next.getValue());
                }
                jSONStringer.endObject();
                String jSONStringer2 = jSONStringer.toString();
                return jSONStringer2 == null ? "" : jSONStringer2;
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    public final void hij() {
        this.ikl.clear();
        ijk();
    }

    public final void ijk() {
        dv.lmn(this.klm, this.lmn, this.ijk);
    }

    public final String ikl() {
        return dv.klm(this.klm, this.lmn, this.ijk, "");
    }

    public final String klm() {
        return ghi();
    }

    public final void klm(String str) {
        if (!TextUtils.isEmpty(str)) {
            fgh();
            if (this.ikl.size() > 0) {
                lmn(klm(str, ghi()));
            }
        }
    }

    public final Map<String, Object> lmn() {
        return this.ikl;
    }

    public abstract void lmn(Bundle bundle);

    public final void lmn(String str) {
        if (!TextUtils.isEmpty(str)) {
            dv.lmn(this.klm, this.lmn, this.ijk, str);
        }
    }

    public abstract void lmn(String str, Object obj);

    public final void lmn(JSONObject jSONObject) {
        if (this.ikl == null) {
            this.ikl = new ConcurrentHashMap<>();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.ikl.put(next, jSONObject.opt(next));
        }
    }

    public final boolean lmn(int i11) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.ikl;
        if (concurrentHashMap == null) {
            return false;
        }
        int size = concurrentHashMap.size();
        if (size < i11) {
            return true;
        }
        HiLog.w("cusParams", "The number of customized parameters exceeds the upper limit.Current Number: ".concat(String.valueOf(size)));
        return false;
    }
}
