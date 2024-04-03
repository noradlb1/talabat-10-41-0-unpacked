package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class aw extends au {
    private static final Object ijk = new Object();

    public aw(Context context) {
        super(context, "global_v2", "def_evt_params");
        fgh();
    }

    private void efg() {
        if (this.ikl == null) {
            String ikl = ikl();
            String klm = bs.lmn().klm();
            if (!TextUtils.isEmpty(ikl)) {
                try {
                    lmn(new JSONObject(au.lmn(klm, ikl)));
                } catch (JSONException unused) {
                    HiLog.w("DefEvtParam", "cache evt params is error");
                    ijk();
                }
            }
        }
    }

    private void lmn(List<bb> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Cdo());
            for (bb next : list) {
                try {
                    synchronized (ijk) {
                        lmn(next.lmn, next.klm);
                    }
                } catch (Exception unused) {
                    HiLog.w("DefEvtParam", "addParam exception");
                }
            }
        }
    }

    public final void fgh() {
        efg();
        if (this.ikl == null) {
            this.ikl = new ConcurrentHashMap<>();
        }
    }

    public final void lmn(Bundle bundle) {
        String str;
        if (bundle == null) {
            hij();
        } else if (bundle.size() != 0) {
            ArrayList arrayList = null;
            for (String next : bundle.keySet()) {
                if (next == null || next.length() > 256 || !aq.klm.matcher(next).matches()) {
                    str = "defEvtParams key check failed! key= ".concat(String.valueOf(next));
                } else {
                    Object obj = bundle.get(next);
                    if (obj == null) {
                        this.ikl.remove(next);
                    } else if (!dl.lmn(obj) || obj.toString().length() > 256) {
                        str = "defEvtParams value check failed! pls check value type or length";
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(new bb(next, obj));
                    }
                }
                HiLog.w("DefEvtParam", str);
            }
            lmn((List<bb>) arrayList);
            lmn(au.klm(bs.lmn().klm(), ghi()));
        }
    }

    public final void lmn(String str, Object obj) {
        if (this.ikl == null) {
            this.ikl = new ConcurrentHashMap<>();
        }
        if (this.ikl.size() != 0 || obj != null) {
            if (obj == null) {
                this.ikl.remove(str);
            } else if (lmn(100)) {
                this.ikl.put(str, obj);
            }
        }
    }
}
