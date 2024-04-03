package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.core.log.HiLog;

public abstract class df {
    private final String ghi;
    private final String hij;
    private final bl ijk;
    protected Context ikl = av.lmn().lmn.ghi;
    protected boolean klm;
    protected String lmn;

    public df(bl blVar, String str, String str2) {
        this.ijk = blVar;
        this.hij = str;
        this.ghi = str2;
    }

    public abstract boolean klm();

    public abstract long lmn();

    public final void lmn(de deVar) {
        boolean z11 = false;
        boolean klm2 = dv.klm(this.ikl, "global_v2", this.ghi, false);
        boolean ghi2 = dp.ghi(this.ikl);
        this.klm = ghi2;
        if (ghi2 || !klm2) {
            z11 = true;
        }
        if (z11) {
            dt dtVar = new dt(this.hij, deVar.lmn());
            long lmn2 = lmn();
            if (this.klm) {
                HiLog.i(this.lmn, "debugview referrer event");
                this.ijk.lmn(this.hij, dtVar, lmn2);
                return;
            }
            HiLog.i(this.lmn, "normal referrer event");
            if (klm()) {
                ((def) this.ijk).klm(this.hij, dtVar, lmn2);
            } else {
                this.ijk.lmn(this.hij, dtVar, lmn2);
            }
            dv.lmn(this.ikl, "global_v2", this.ghi, true);
        }
    }
}
