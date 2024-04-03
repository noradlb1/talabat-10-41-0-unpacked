package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.m;

public final class an extends ah {
    private Object hij;
    private Class<?> ijk;

    public an(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.ijk = cls;
            this.hij = cls.newInstance();
        } catch (Exception unused) {
            HiLog.w("miOaid", "invoke class Exception");
        }
    }

    private String ijk() {
        try {
            Object invoke = this.ijk.getMethod("getOAID", new Class[]{Context.class}).invoke(this.hij, new Object[]{this.klm});
            return invoke instanceof String ? (String) invoke : "";
        } catch (Exception unused) {
            HiLog.w("miOaid", "invoke method Exception");
            return "";
        }
    }

    public final boolean klm() {
        return this.hij != null;
    }

    public final void lmn() {
        String ijk2 = ijk();
        this.lmn.lmn(ijk2, TextUtils.isEmpty(ijk2) ? "false" : "", "oaid");
    }
}
