package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.ab;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.m;

public final class ac extends ah {
    public ac(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
        this.ikl = new ab(context, "com.uodis.opendevice.OPENIDS_SERVICE", "com.huawei.hwid", this);
    }

    public final boolean klm() {
        return klm("com.huawei.hwid");
    }

    public final void lmn() {
        try {
            this.ikl.lmn();
        } catch (Exception unused) {
            lmn("getOaid,bindService error, begin get gaid");
        }
    }

    public final void lmn(ab.lmn lmn) {
        try {
            ai aiVar = new ai("com.uodis.opendevice.aidl.OpenDeviceIdentifierService", lmn.lmn());
            boolean lmn2 = aiVar.lmn();
            boolean z11 = false;
            String lmn3 = aiVar.lmn(new String[0]);
            if (TextUtils.isEmpty(lmn3)) {
                if (!lmn2) {
                    HiLog.w("hwDeviceidHelper", "oaid is empty");
                    throw new IllegalArgumentException();
                }
            }
            m.lmn lmn4 = this.lmn;
            if (!lmn2) {
                z11 = true;
            }
            lmn4.lmn(lmn3, String.valueOf(z11), "oaid");
            ikl();
        } catch (Throwable th2) {
            ikl();
            throw th2;
        }
    }
}
