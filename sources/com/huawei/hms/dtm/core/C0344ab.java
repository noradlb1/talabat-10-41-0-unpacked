package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ab  reason: case insensitive filesystem */
public class C0344ab extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null) {
            boolean z11 = true;
            if (list.size() == 1 && (list.get(0) instanceof Cc)) {
                String str = (String) ((Cc) list.get(0)).value();
                if (TextUtils.isEmpty(str)) {
                    return new Cc("ParseErr#It is empty");
                }
                int[] iArr = {46, 101, 69};
                int i11 = 0;
                while (true) {
                    if (i11 >= 3) {
                        z11 = false;
                        break;
                    } else if (str.indexOf(iArr[i11]) != -1) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    try {
                        Double valueOf = Double.valueOf(Double.parseDouble(str));
                        return Double.isInfinite(valueOf.doubleValue()) ? new Cc("ParseErr#It is infinite") : new C0440tc(valueOf);
                    } catch (NumberFormatException unused) {
                        return new Cc("ParseErr#It is NaN");
                    }
                } else {
                    try {
                        return new C0460xc(Long.valueOf(Long.parseLong(str)));
                    } catch (NumberFormatException unused2) {
                        return new Cc("ParseErr#It is NaN or overflow");
                    }
                }
            }
        }
        throw new V("__string2num#param must be a string");
    }

    public String a() {
        return "__string2num";
    }
}
