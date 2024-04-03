package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class by implements IStoragePolicy {
    protected String lmn;

    /* renamed from: com.huawei.hms.analytics.by$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] lmn;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType[] r0 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                lmn = r0
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType r1 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.STORAGELENGTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType r1 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.NETWORK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType r1 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.PARAMS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType r1 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.STORAGECYCLY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.analytics.framework.policy.IStoragePolicy$PolicyType r1 = com.huawei.hms.analytics.framework.policy.IStoragePolicy.PolicyType.STORAGESIZE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.by.AnonymousClass1.<clinit>():void");
        }
    }

    public by() {
    }

    public by(String str) {
        this.lmn = str;
    }

    public final boolean decide(IStoragePolicy.PolicyType policyType, long j11) {
        int i11 = AnonymousClass1.lmn[policyType.ordinal()];
        return i11 != 4 ? i11 == 5 && j11 >= av.lmn().lmn.f47856c : System.currentTimeMillis() - j11 > 604800000;
    }

    public final boolean decide(IStoragePolicy.PolicyType policyType, Object obj) {
        int i11 = AnonymousClass1.lmn[policyType.ordinal()];
        if (i11 == 1) {
            return new File(av.lmn().lmn.ghi.getDatabasePath((String) obj).getPath()).length() > 10485760;
        }
        if (i11 != 2) {
            if (i11 != 3) {
                return true;
            }
            return lmn((IConfig) obj) && !TextUtils.isEmpty(dh.lmn().klm());
        } else if (!TextUtils.isEmpty(dp.cde(av.lmn().lmn.ghi))) {
            return true;
        } else {
            HiLog.w("ReportPolicy", "The network is unavailable.");
            return false;
        }
    }

    public final boolean lmn(IConfig iConfig) {
        dy dyVar;
        if (dx.klm()) {
            try {
                dx.lmn().await(3, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                HiLog.w("ReportPolicy", "Interrupted Exception");
            }
            dyVar = new dy(new cf(this.lmn, iConfig));
        } else {
            dx.ikl();
            dyVar = new dy(dx.lmn(), new cf(this.lmn, iConfig));
        }
        return !TextUtils.isEmpty(dyVar.lmn());
    }
}
