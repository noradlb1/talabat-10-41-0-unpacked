package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.database.APIEvent;
import java.util.List;

public final class cn implements Runnable {
    private bg ikl;
    private List<APIEvent> klm;
    private Context lmn;

    public cn(List<APIEvent> list) {
        Context context = av.lmn().lmn.ghi;
        this.lmn = context;
        this.klm = list;
        this.ikl = bg.lmn(context);
        cl.lmn(this.lmn);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r0 = r10.klm
            java.lang.String r1 = "EventApiUsageRecordMission"
            if (r0 == 0) goto L_0x00b9
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000e
            goto L_0x00b9
        L_0x000e:
            android.content.Context r0 = r10.lmn
            java.lang.String r2 = "latest_upload_time"
            java.lang.String r3 = "apiUsageUploadKey"
            long r4 = com.huawei.hms.analytics.dv.klm(r0, r2, r3)
            long r6 = java.lang.System.currentTimeMillis()
            r8 = -1
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0028
            android.content.Context r0 = r10.lmn
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3, (long) r6)
            goto L_0x003d
        L_0x0028:
            long r4 = r6 - r4
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            java.lang.String r0 = "api usage cycle is exceeded the threshold."
            com.huawei.hms.analytics.core.log.HiLog.i(r1, r0)
            android.content.Context r0 = r10.lmn
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3, (long) r6)
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            java.lang.String r2 = "auto report api data for bi"
            if (r0 != 0) goto L_0x009a
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r0 = r10.klm
            int r0 = r0.size()
            r3 = 20
            if (r0 <= r3) goto L_0x004d
            goto L_0x009a
        L_0x004d:
            com.huawei.hms.analytics.bg r0 = r10.ikl
            java.util.List r0 = r0.ijk()
            int r4 = r0.size()
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r5 = r10.klm
            int r5 = r5.size()
            int r4 = r4 + r5
            if (r4 <= r3) goto L_0x0077
            com.huawei.hms.analytics.core.log.HiLog.i(r1, r2)
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r1 = r10.klm
            r1.addAll(r0)
            com.huawei.hms.analytics.bg r1 = r10.ikl
            r1.klm()
            android.content.Context r1 = r10.lmn
            com.huawei.hms.analytics.cl r1 = com.huawei.hms.analytics.cl.lmn((android.content.Context) r1)
            r1.lmn((java.util.List<com.huawei.hms.analytics.database.APIEvent>) r0)
            return
        L_0x0077:
            com.huawei.hms.analytics.bg r0 = r10.ikl
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r1 = r10.klm
            com.huawei.hms.analytics.database.DaoSession r2 = r0.lmn     // Catch:{ SQLiteFullException -> 0x0085 }
            com.huawei.hms.analytics.database.APIEventDao r2 = r2.getAPIEventDao()     // Catch:{ SQLiteFullException -> 0x0085 }
            r2.insertInTx(r1)     // Catch:{ SQLiteFullException -> 0x0085 }
            return
        L_0x0085:
            r1 = move-exception
            java.lang.String r2 = "DBCommander"
            java.lang.String r3 = "SQLite full exception"
            com.huawei.hms.analytics.core.log.HiLog.w(r2, r3)
            com.huawei.hms.analytics.database.DaoSession r0 = r0.lmn
            com.huawei.hms.analytics.database.APIEventDao r0 = r0.getAPIEventDao()
            r0.deleteAll()
            com.huawei.hms.analytics.dr.lmn(r1)
            return
        L_0x009a:
            com.huawei.hms.analytics.core.log.HiLog.i(r1, r2)
            com.huawei.hms.analytics.bg r0 = r10.ikl
            java.util.List r0 = r0.ijk()
            com.huawei.hms.analytics.bg r1 = r10.ikl
            r1.klm()
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r1 = r10.klm
            r1.addAll(r0)
            android.content.Context r0 = r10.lmn
            com.huawei.hms.analytics.cl r0 = com.huawei.hms.analytics.cl.lmn((android.content.Context) r0)
            java.util.List<com.huawei.hms.analytics.database.APIEvent> r1 = r10.klm
            r0.lmn((java.util.List<com.huawei.hms.analytics.database.APIEvent>) r1)
            return
        L_0x00b9:
            java.lang.String r0 = "apiEvents is empty, no data save"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.cn.run():void");
    }
}
