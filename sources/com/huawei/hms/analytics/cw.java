package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.database.LogConfig;
import com.huawei.hms.analytics.database.LogEvent;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cw implements Runnable {
    private final boolean hij;
    private final IConfig ijk;
    private int ikl;
    private bi klm;
    private cu lmn;

    public cw(IConfig iConfig, boolean z11) {
        this.ijk = iConfig;
        this.hij = z11;
    }

    private void lmn() {
        String str;
        if (!this.lmn.lmn()) {
            str = "cache log event is error";
        } else {
            try {
                new cx(this.lmn, this.ijk, this.hij).lmn();
                return;
            } catch (Exception unused) {
                str = "event model json error";
            }
        }
        HiLog.e("LgEvtReport", str);
        this.klm.lmn(this.lmn.klm);
        this.lmn.ijk();
    }

    private boolean lmn(LogConfig logConfig, List<LogEvent> list) {
        try {
            int i11 = this.ikl;
            List<LogEvent> subList = i11 > 0 ? list.subList(i11, list.size()) : list;
            int i12 = this.ikl;
            cu cuVar = this.lmn;
            if (logConfig != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("projectId", (Object) logConfig.getProjectId());
                jSONObject.put("groupId", (Object) logConfig.getLogGroupId());
                jSONObject.put("streamId", (Object) logConfig.getLogStreamId());
                jSONObject.put("tags", (Object) TextUtils.isEmpty(logConfig.getLogTags()) ? new JSONObject() : new JSONObject(logConfig.getLogTags()));
                if (!cuVar.ijk.contains(logConfig.getId())) {
                    cuVar.ijk.add(logConfig.getId());
                }
                JSONArray jSONArray = new JSONArray();
                int lmn2 = cuVar.lmn(jSONArray, subList);
                cuVar.ikl = lmn2 == subList.size();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("events_common", (Object) jSONObject);
                jSONObject2.put("events", (Object) jSONArray);
                cuVar.lmn.put((Object) jSONObject2);
                int i13 = i12 + lmn2;
                this.ikl = i13;
                return i13 < list.size();
            }
            throw new IllegalArgumentException("log config is null");
        } catch (IllegalArgumentException | JSONException e11) {
            HiLog.w("LgEvtReport", "construct Event JsonArray exception." + e11.getMessage());
            this.klm.lmn.klm.deleteInTx(list);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0085, code lost:
        if (android.text.TextUtils.isEmpty(r6.lmn.fgh) != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
        r6.lmn.fgh = r1.getRegion();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009b, code lost:
        if (r6.lmn.fgh.equals(r1.getRegion()) == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a1, code lost:
        if (lmn(r1, r2) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a3, code lost:
        lmn();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            java.lang.String r0 = "LgEvtReport"
            com.huawei.hms.analytics.by r1 = new com.huawei.hms.analytics.by
            r1.<init>()
            com.huawei.hms.analytics.framework.config.IConfig r2 = r6.ijk
            boolean r1 = r1.lmn(r2)
            if (r1 != 0) goto L_0x0010
            return
        L_0x0010:
            com.huawei.hms.analytics.bi r1 = com.huawei.hms.analytics.bi.lmn()     // Catch:{ lmn -> 0x00d4 }
            r6.klm = r1     // Catch:{ lmn -> 0x00d4 }
            com.huawei.hms.analytics.bj r1 = r1.lmn
            com.huawei.hms.analytics.database.LogConfigDao r1 = r1.lmn
            java.util.List r1 = r1.loadAll()
            if (r1 == 0) goto L_0x00bd
            int r2 = r1.size()
            if (r2 != 0) goto L_0x0028
            goto L_0x00bd
        L_0x0028:
            com.huawei.hms.analytics.cu r0 = new com.huawei.hms.analytics.cu
            int r2 = r1.size()
            r0.<init>(r2)
            r6.lmn = r0
            com.huawei.hms.analytics.do$klm r0 = new com.huawei.hms.analytics.do$klm
            r0.<init>()
            java.util.Collections.sort(r1, r0)
            java.util.Iterator r0 = r1.iterator()
        L_0x003f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b9
            java.lang.Object r1 = r0.next()
            com.huawei.hms.analytics.database.LogConfig r1 = (com.huawei.hms.analytics.database.LogConfig) r1
            com.huawei.hms.analytics.bi r2 = r6.klm
            java.lang.Long r3 = r1.getId()
            com.huawei.hms.analytics.bj r2 = r2.lmn
            com.huawei.hms.analytics.database.LogEventDao r2 = r2.klm
            org.greenrobot.greendao.query.QueryBuilder r2 = r2.queryBuilder()
            org.greenrobot.greendao.Property r4 = com.huawei.hms.analytics.database.LogEventDao.Properties.ikl
            org.greenrobot.greendao.query.WhereCondition r3 = r4.eq(r3)
            r4 = 0
            org.greenrobot.greendao.query.WhereCondition[] r5 = new org.greenrobot.greendao.query.WhereCondition[r4]
            org.greenrobot.greendao.query.QueryBuilder r2 = r2.where(r3, r5)
            org.greenrobot.greendao.query.Query r2 = r2.build()
            org.greenrobot.greendao.query.Query r2 = r2.forCurrentThread()
            java.util.List r2 = r2.list()
            if (r2 == 0) goto L_0x00a7
            int r3 = r2.size()
            if (r3 != 0) goto L_0x007b
            goto L_0x00a7
        L_0x007b:
            r6.ikl = r4
            com.huawei.hms.analytics.cu r3 = r6.lmn
            java.lang.String r3 = r3.fgh
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x008f
        L_0x0087:
            com.huawei.hms.analytics.cu r3 = r6.lmn
            java.lang.String r4 = r1.getRegion()
            r3.fgh = r4
        L_0x008f:
            com.huawei.hms.analytics.cu r3 = r6.lmn
            java.lang.String r3 = r3.fgh
            java.lang.String r4 = r1.getRegion()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a3
            boolean r3 = r6.lmn(r1, r2)
            if (r3 == 0) goto L_0x003f
        L_0x00a3:
            r6.lmn()
            goto L_0x0087
        L_0x00a7:
            com.huawei.hms.analytics.bi r2 = r6.klm
            com.huawei.hms.analytics.bj r2 = r2.lmn
            com.huawei.hms.analytics.database.LogConfigDao r2 = r2.lmn
            r2.delete(r1)
            com.huawei.hms.analytics.cu r1 = r6.lmn
            int r2 = r1.ghi
            int r2 = r2 + -1
            r1.ghi = r2
            goto L_0x003f
        L_0x00b9:
            r6.lmn()
            return
        L_0x00bd:
            java.lang.String r1 = "No have log events in cache"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r1)
            com.huawei.hms.analytics.bi r0 = r6.klm
            long r0 = r0.klm()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d3
            com.huawei.hms.analytics.bi r0 = r6.klm
            r0.ikl()
        L_0x00d3:
            return
        L_0x00d4:
            java.lang.String r1 = "log db init failed"
            com.huawei.hms.analytics.core.log.HiLog.e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.cw.run():void");
    }
}
