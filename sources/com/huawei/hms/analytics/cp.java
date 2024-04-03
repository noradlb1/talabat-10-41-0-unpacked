package com.huawei.hms.analytics;

import com.huawei.hms.analytics.cc;
import com.huawei.hms.analytics.framework.config.IConfig;

public final class cp implements Runnable {
    private final IConfig lmn;

    public static class lmn implements cc.lmn {
        public final void lmn() {
            bl lmn = cde.lmn().lmn("_openness_config_tag");
            cde lmn2 = cde.lmn();
            String[] strArr = aq.ghi;
            bl lmn3 = lmn2.lmn(strArr[0]);
            if (lmn != null) {
                lmn.lmn();
            }
            if (lmn3 != null) {
                lmn3.lmn();
            }
            bl lmn4 = cde.lmn().lmn(strArr[3]);
            if (lmn4 != null) {
                lmn4.lmn();
            }
            bl lmn5 = cde.lmn().lmn(strArr[5]);
            if (lmn5 != null) {
                lmn5.lmn();
            }
        }
    }

    public cp(IConfig iConfig) {
        this.lmn = iConfig;
    }

    public final void run() {
        cc ccVar = new cc(this.lmn);
        ccVar.lmn = new lmn();
        ccVar.klm();
    }
}
