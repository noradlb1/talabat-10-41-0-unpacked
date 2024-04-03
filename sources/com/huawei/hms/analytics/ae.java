package com.huawei.hms.analytics;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.analytics.ab;
import com.huawei.hms.analytics.m;

public final class ae extends ah {
    public ae(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        this.ikl = new ab(context, intent, this);
    }

    public final boolean klm() {
        return klm("com.zui.deviceidservice");
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
            ai aiVar = new ai("com.zui.deviceidservice.IDeviceidInterface", lmn.lmn());
            if (aiVar.klm()) {
                String lmn2 = aiVar.lmn(new String[0]);
                if (!TextUtils.isEmpty(lmn2)) {
                    this.lmn.lmn(lmn2, "", "oaid");
                    ikl();
                    return;
                }
                throw new IllegalArgumentException("oaid is mepty");
            }
            throw new IllegalAccessException("is supported is false");
        } catch (Throwable th2) {
            ikl();
            throw th2;
        }
    }
}
