package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.p  reason: case insensitive filesystem */
public class C0417p {
    private static String a(String str, int i11) {
        String str2 = "[" + i11 + "]";
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : str.split("\\|")) {
            if (str3.endsWith("]")) {
                sb2.append(str3);
            } else {
                a(sb2, str3, str2);
            }
            sb2.append("|");
        }
        return sb2.deleteCharAt(sb2.length() - 1).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.ref.WeakReference<android.app.Activity> r1, java.lang.String r2) {
        /*
            java.lang.Object r1 = r1.get()
            android.app.Activity r1 = (android.app.Activity) r1
            if (r1 == 0) goto L_0x0061
            android.view.View r1 = com.huawei.hms.dtm.core.C0432s.a((android.app.Activity) r1, (java.lang.String) r2)
            boolean r2 = r1 instanceof android.widget.RadioGroup
            if (r2 == 0) goto L_0x002d
            r2 = r1
            android.widget.RadioGroup r2 = (android.widget.RadioGroup) r2
            int r2 = r2.getCheckedRadioButtonId()
            r0 = -1
            if (r2 == r0) goto L_0x0061
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RadioButton r1 = (android.widget.RadioButton) r1
        L_0x0020:
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            goto L_0x0063
        L_0x002d:
            boolean r2 = r1 instanceof android.widget.Switch
            if (r2 == 0) goto L_0x003a
            android.widget.Switch r1 = (android.widget.Switch) r1
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x004b
            goto L_0x0048
        L_0x003a:
            boolean r2 = com.huawei.hms.dtm.core.util.f.k(r1)
            if (r2 == 0) goto L_0x004e
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x004b
        L_0x0048:
            java.lang.String r1 = "true"
            goto L_0x0063
        L_0x004b:
            java.lang.String r1 = "false"
            goto L_0x0063
        L_0x004e:
            boolean r2 = r1 instanceof android.widget.TextView
            if (r2 == 0) goto L_0x0061
            boolean r2 = com.huawei.hms.dtm.core.util.f.j(r1)
            if (r2 != 0) goto L_0x0061
            int r2 = r1.getVisibility()
            if (r2 != 0) goto L_0x0061
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0020
        L_0x0061:
            java.lang.String r1 = ""
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.C0417p.a(java.lang.ref.WeakReference, java.lang.String):java.lang.String");
    }

    private static List<C0361dd> a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        List<C0361dd> visualPointList = DynamicTagManager.getInstance().getVisualPointList();
        ArrayList arrayList = new ArrayList();
        for (C0361dd next : visualPointList) {
            if (str.equals(next.d())) {
                boolean z11 = true;
                boolean z12 = !next.k() && str2.equals(next.g());
                boolean z13 = next.k() && str3.equals(next.g());
                if (TextUtils.isEmpty(str4) || !next.j() || !str4.equalsIgnoreCase(next.b())) {
                    z11 = false;
                }
                if (z12 || z13 || z11) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private static void a(StringBuilder sb2, String str, String str2) {
        if (str.contains("#")) {
            String[] split = str.split("#");
            if (split.length > 0 && split[0].endsWith("]")) {
                sb2.append(str);
                return;
            } else if (split.length > 1) {
                sb2.append(split[0]);
                sb2.append(str2);
                sb2.append("#");
                sb2.append(split[1]);
                return;
            }
        }
        sb2.append(str);
        sb2.append(str2);
    }

    public static void a(WeakReference<Activity> weakReference, Bundle bundle, View view) {
        if (weakReference.get() != null && bundle != null) {
            SafeBundle safeBundle = new SafeBundle(bundle);
            List<C0361dd> a11 = a(safeBundle.getString("$DTM_AT_TARGET"), safeBundle.getString("$DTM_AT_XPATH"), safeBundle.getString("$DTM_AT_XPATH_LIST"), safeBundle.getString("$DTM_AT_CONTENT"));
            if (a11 != null && !a11.isEmpty()) {
                int i11 = -1;
                for (C0361dd next : a11) {
                    if (next.k() && i11 == -1 && (i11 = f.c(view)) == -1) {
                        Logger.error("DTM-AutoTrace", "Get position is -1 in ListView");
                    } else {
                        a(weakReference, bundle, next, i11);
                    }
                }
            }
        }
    }

    private static void a(WeakReference<Activity> weakReference, Bundle bundle, C0361dd ddVar, int i11) {
        if (weakReference.get() != null && ddVar != null && bundle != null) {
            List<C0366ed> e11 = ddVar.e();
            Bundle bundle2 = (Bundle) bundle.clone();
            for (C0366ed next : e11) {
                String b11 = next.b();
                if (ddVar.k() && i11 >= 0) {
                    b11 = a(b11, i11);
                }
                String a11 = next.a();
                String a12 = a(weakReference, b11);
                if (ddVar.h()) {
                    a11 = "$DTM_VP_" + a11;
                }
                bundle2.putString(a11, a12);
            }
            if (ddVar.a() >= 0) {
                bundle2.putInt("$DTM_AT_VP_CONDITION_INDEX", ddVar.a());
            }
            bundle2.putBoolean("$DTM_AT_VP_NO_TAG", ddVar.i());
            Logger.debug("DTM-AutoTrace", bundle2.toString());
            DynamicTagManager.getInstance().logEvent(ddVar.c(), bundle2);
        }
    }

    public static void a(WeakReference<Activity> weakReference, Bundle bundle, String str, String str2) {
        List<C0361dd> a11 = a(str, str2, str2, "");
        if (a11 != null && !a11.isEmpty()) {
            for (C0361dd a12 : a11) {
                a(weakReference, bundle, a12, -1);
            }
        }
    }
}
