package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.ab;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.m;

public abstract class ah implements aa {
    private final ah ijk;
    protected ab ikl;
    protected final Context klm;
    protected final m.lmn lmn;

    public ah(Context context, m.lmn lmn2, ah ahVar) {
        this.klm = context;
        this.lmn = lmn2;
        this.ijk = ahVar;
    }

    private boolean lmn(ah ahVar) {
        if (ahVar == null) {
            return false;
        }
        if (ahVar.klm()) {
            ahVar.lmn();
            return true;
        }
        lmn(ahVar.ijk);
        return false;
    }

    public final void ikl() {
        ab abVar = this.ikl;
        if (abVar != null) {
            try {
                ab.lmn lmn2 = abVar.klm;
                if (lmn2 != null) {
                    abVar.lmn.unbindService(lmn2);
                }
            } catch (Exception unused) {
                HiLog.w("oaidHelper", "unBind service exception");
            }
        }
    }

    public abstract boolean klm();

    public final boolean klm(String str) {
        try {
            return this.klm.getPackageManager().getPackageInfo(str, 16384) != null;
        } catch (Exception unused) {
        }
    }

    public abstract void lmn();

    public void lmn(ab.lmn lmn2) {
    }

    public void lmn(String str) {
        HiLog.w("oaidHelper", str);
        if (!lmn(this.ijk)) {
            this.lmn.lmn("", "", "");
        }
    }
}
