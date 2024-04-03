package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.SyncManager;

public final class fgh extends hij {
    public fgh(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    public final void lmn(bc bcVar) {
        if (TextUtils.isEmpty(this.hij) && !bcVar.lmn.containsKey(bcVar.hij)) {
            throw new IllegalArgumentException("collect urls check failed");
        }
    }

    public final void run() {
        bl blVar;
        HiLog.d("OpennessInitTask", "init running");
        try {
            lmn();
            a.lmn(this.hij);
            be.lmn(this.ikl, Boolean.TRUE);
            ikl ikl = this.ijk;
            if (!(ikl == null || (blVar = ikl.lmn) == null || !(blVar instanceof def))) {
                def def = (def) blVar;
                boolean z11 = false;
                boolean klm = dv.klm(def.ijk, "global_v2", "isFirstRun", false);
                if (dp.ghi(def.ijk) || !klm) {
                    z11 = true;
                }
                if (z11) {
                    HiLog.i("instanceimpl", "start to report referrer");
                    dg.ikl().lmn(new cs(def.ijk, def));
                }
                if (av.lmn().lmn.fgh) {
                    ax axVar = av.lmn().lmn;
                    String str = axVar.klm;
                    String str2 = axVar.ikl;
                    if (!TextUtils.isEmpty(str2) && !str.equals(str2)) {
                        HiLog.i("instanceimpl", "app version changed");
                        Bundle bundle = new Bundle();
                        bundle.putString("$PrevVersion", str2);
                        bundle.putString("$CurrVersion", str);
                        def.lmn("$UpdateApp", new dt("$UpdateApp", bundle), System.currentTimeMillis());
                    }
                }
            }
        } catch (Throwable th2) {
            dv.lmn(this.klm, "global_v2", "lib_ver", "6.9.0.302");
            SyncManager.getInstance().countDown(this.fgh);
            throw th2;
        }
        dv.lmn(this.klm, "global_v2", "lib_ver", "6.9.0.302");
        SyncManager.getInstance().countDown(this.fgh);
    }
}
