package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;

public final class da extends df {
    public da(bl blVar) {
        super(blVar, "$AppFirstOpen", "isFirstRun");
        this.lmn = "FsOpenHandler";
    }

    public final boolean klm() {
        return true;
    }

    public final long lmn() {
        try {
            return Long.parseLong(dv.klm(this.ikl, "global_v2", "firstRunTime", ""));
        } catch (NumberFormatException unused) {
            HiLog.w(this.lmn, "first run time error");
            long currentTimeMillis = System.currentTimeMillis();
            dv.lmn(this.ikl, "global_v2", "firstRunTime", String.valueOf(currentTimeMillis));
            return currentTimeMillis;
        }
    }
}
