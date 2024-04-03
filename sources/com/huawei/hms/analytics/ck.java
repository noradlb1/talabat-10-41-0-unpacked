package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.database.APIEvent;
import java.util.ArrayList;
import java.util.Map;

public final class ck {
    public static APIEvent klm(cj cjVar) {
        return new APIEvent("rpt_api_dist", String.valueOf(System.currentTimeMillis()), "0", cjVar.ikl, cjVar.lmn, cjVar.klm, cjVar.ijk, "1", String.valueOf(cjVar.lmn()));
    }

    public static synchronized cj lmn(String str) {
        cj cjVar;
        synchronized (ck.class) {
            cjVar = new cj();
            cjVar.ikl = str;
        }
        return cjVar;
    }

    public static synchronized void lmn(cj cjVar) {
        synchronized (ck.class) {
            if (!av.lmn().lmn.fgh) {
                HiLog.w("APIEvtRecordHolder", "The Analytics Kit is disabled, don't record");
            } else if (cjVar != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(klm(cjVar));
                try {
                    dg.klm().lmn(new cn(arrayList));
                } catch (Exception unused) {
                    HiLog.e("APIEvtRecordHolder", "HMSBIInitializer init failed");
                } catch (NoClassDefFoundError unused2) {
                    HiLog.e("APIEvtRecordHolder", HiLog.ErrorCode.IE004, "HMSBIInitializer init failed,Missing hms sdk");
                }
            }
        }
    }

    public static void lmn(Map<String, Integer> map, String str, long j11, int i11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("APIEvtRecordHolder", "The Analytics Kit is disabled, don't record");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new APIEvent("rpt_api_dist", String.valueOf(System.currentTimeMillis()), "1", str, i11 == 200 ? "0" : "1", String.valueOf(i11), (String) next.getKey(), String.valueOf((Integer) next.getValue()), String.valueOf(j11)));
        }
        try {
            dg.klm().lmn(new cn(arrayList));
        } catch (Exception unused) {
            HiLog.e("APIEvtRecordHolder", "HMSBIInitializer init failed!");
        } catch (NoClassDefFoundError unused2) {
            HiLog.e("APIEvtRecordHolder", HiLog.ErrorCode.IE004, "HMSBIInitializer init failed,Missing hms sdk!");
        }
    }
}
