package com.huawei.hms.analytics.type;

import com.huawei.hms.analytics.core.log.HiLog;

public enum ReportPolicy {
    ON_SCHEDULED_TIME_POLICY(60),
    ON_APP_LAUNCH_POLICY(-1),
    ON_MOVE_BACKGROUND_POLICY(-1),
    ON_CACHE_THRESHOLD_POLICY(30);
    
    private long threshold;

    /* renamed from: com.huawei.hms.analytics.type.ReportPolicy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] lmn = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.huawei.hms.analytics.type.ReportPolicy[] r0 = com.huawei.hms.analytics.type.ReportPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                lmn = r0
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_CACHE_THRESHOLD_POLICY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_SCHEDULED_TIME_POLICY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.type.ReportPolicy.AnonymousClass1.<clinit>():void");
        }
    }

    private ReportPolicy(long j11) {
        this.threshold = j11;
    }

    private long checkThreshold(long j11) {
        String str;
        long j12;
        String str2;
        int i11 = AnonymousClass1.lmn[ordinal()];
        if (i11 == 1) {
            long j13 = 1000;
            if (j11 > 1000) {
                str = "The number of automatically reported thresholds is too large. Use the maximum  default value.";
            } else {
                j13 = 30;
                if (j11 >= 30) {
                    return j11;
                }
                str = "The number of automatically reported thresholds is too small. Use the minimum  default value.";
            }
            HiLog.i("PolicyToolsKit", str);
        } else if (i11 != 2) {
            return -1;
        } else {
            j12 = 1800;
            if (j11 > 1800) {
                str2 = "The auto-reporting period is too long.Use the default value.";
            } else {
                j12 = 60;
                if (j11 >= 60) {
                    return j11;
                }
                str2 = "The auto-reporting period is too short. Use the default value.";
            }
            HiLog.w("PolicyToolsKit", str2);
        }
        return j12;
    }

    public final long getThreshold() {
        return this.threshold;
    }

    public final void setThreshold(long j11) {
        this.threshold = checkThreshold(j11);
    }
}
