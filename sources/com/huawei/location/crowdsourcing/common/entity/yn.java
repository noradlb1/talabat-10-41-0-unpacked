package com.huawei.location.crowdsourcing.common.entity;

import android.os.SystemClock;
import android.telephony.CellInfo;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.log.LogConsole;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private static boolean f50047yn = true;
    private final CellInfo FB;
    private final long Vw;

    static {
        LogConsole.i("CellWrapper", "nano time delay:" + (SystemClock.elapsedRealtimeNanos() - System.nanoTime()));
    }

    public yn(@NonNull CellInfo cellInfo, long j11) {
        this.FB = cellInfo;
        this.Vw = j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[LOOP:1: B:18:0x007b->B:20:0x0081, LOOP_END] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.huawei.location.crowdsourcing.common.entity.yn> yn(java.util.List<android.telephony.CellInfo> r8) {
        /*
            boolean r0 = f50047yn
            if (r0 == 0) goto L_0x0070
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0070
            long r0 = android.os.SystemClock.elapsedRealtimeNanos()
            long r2 = java.lang.System.nanoTime()
            long r0 = r0 - r2
            r4 = 100000000000(0x174876e800, double:4.9406564584E-313)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            java.lang.String r5 = "CellWrapper"
            if (r4 <= 0) goto L_0x005c
            java.lang.String r4 = "detect nano"
            com.huawei.location.lite.common.log.LogConsole.d(r5, r4)
            java.util.Iterator r4 = r8.iterator()
        L_0x0027:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0043
            java.lang.Object r6 = r4.next()
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6
            long r6 = r6.getTimeStamp()
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0027
            java.lang.String r2 = "close nano detect"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r2)
            r2 = 0
            f50047yn = r2
        L_0x0043:
            boolean r2 = f50047yn
            if (r2 == 0) goto L_0x0070
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "use nano. diff:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r5, r2)
            goto L_0x0072
        L_0x005c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "not detect nano. diff:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r5, r0)
        L_0x0070:
            r0 = 0
        L_0x0072:
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x007b:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0090
            java.lang.Object r3 = r8.next()
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3
            com.huawei.location.crowdsourcing.common.entity.yn r4 = new com.huawei.location.crowdsourcing.common.entity.yn
            r4.<init>(r3, r0)
            r2.add(r4)
            goto L_0x007b
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.common.entity.yn.yn(java.util.List):java.util.List");
    }

    @NonNull
    public CellInfo Vw() {
        return this.FB;
    }

    public long yn() {
        return this.FB.getTimeStamp() + this.Vw;
    }
}
