package com.huawei.hms.dtm.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.safe.SafeBundle;

/* renamed from: com.huawei.hms.dtm.core.bd  reason: case insensitive filesystem */
public final class C0351bd extends Sc<String> {
    public C0351bd(String str) {
        super(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.huawei.hms.dtm.core.Qc<?> r3) {
        /*
            r2 = this;
            java.util.Map r0 = r3.getParams()
            if (r0 == 0) goto L_0x001d
            java.util.Map r0 = r3.getParams()
            java.lang.String r1 = "name"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof com.huawei.hms.dtm.core.C0346ad
            if (r1 == 0) goto L_0x001d
            com.huawei.hms.dtm.core.ad r0 = (com.huawei.hms.dtm.core.C0346ad) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001f
        L_0x001d:
            java.lang.String r0 = ""
        L_0x001f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x002d
            java.lang.String r3 = r3.getName()
            java.lang.String r0 = com.huawei.hms.dtm.core.util.l.a(r3)
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.C0351bd.a(com.huawei.hms.dtm.core.Qc):java.lang.String");
    }

    public C0435sc<?> a(X x11) {
        Qc<?> execNode = DynamicTagManager.getInstance().getExecNode((String) this.f48409a);
        if (execNode == null) {
            return C0470zc.f48641a;
        }
        if (!execNode.b().equals("__vt")) {
            return execNode.a(x11);
        }
        Bundle b11 = x11.b();
        if (b11 == null) {
            return new Cc("");
        }
        SafeBundle safeBundle = new SafeBundle(b11);
        String a11 = a(execNode);
        String string = safeBundle.getString(a11);
        if (TextUtils.isEmpty(string)) {
            string = safeBundle.getString("$DTM_VP_" + a11);
        }
        return new Cc(string);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0351bd)) {
            return false;
        }
        return ((String) ((C0351bd) obj).f48409a).equals(this.f48409a);
    }

    public /* synthetic */ Object getValue() {
        return super.getValue();
    }

    public int hashCode() {
        return ((String) this.f48409a).hashCode();
    }
}
