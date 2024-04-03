package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.f;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* renamed from: com.huawei.hms.dtm.core.s  reason: case insensitive filesystem */
public final class C0432s {
    public static View a(Activity activity, String str) {
        Logger.debug("DTM-Execute", "findViewByXpath in Thread:" + Thread.currentThread().getName());
        View view = null;
        try {
            if (!b(activity, str)) {
                return null;
            }
            List<C0422q> a11 = a(str);
            if (a11.isEmpty()) {
                return null;
            }
            View findViewById = activity.findViewById(16908290);
            String a12 = a11.get(0).a();
            String b11 = a11.get(0).b();
            if (!findViewById.getClass().getSimpleName().equals(a12) || (b11 != null && !b11.equals(f.d(findViewById)))) {
                return null;
            }
            int i11 = 1;
            while (i11 < a11.size()) {
                try {
                    C0422q qVar = a11.get(i11);
                    if (qVar == null || !(findViewById instanceof ViewGroup)) {
                        return null;
                    }
                    String a13 = qVar.a();
                    String b12 = qVar.b();
                    int c11 = qVar.c();
                    View a14 = f.a((ViewGroup) findViewById, a13, b12);
                    if (a14 != null) {
                        findViewById = a14;
                    } else {
                        findViewById = f.a((ViewGroup) findViewById, c11);
                        if (findViewById == null || !findViewById.getClass().getSimpleName().equals(a13) || (b12 != null && !b12.equals(f.d(findViewById)))) {
                            return null;
                        }
                    }
                    i11++;
                } catch (Throwable th2) {
                    view = findViewById;
                    th = th2;
                    Logger.warn("DTM-Execute", "Exception in findViewByXpath#" + th.getClass().getSimpleName());
                    return view;
                }
            }
            return findViewById;
        } catch (Throwable th3) {
            th = th3;
            Logger.warn("DTM-Execute", "Exception in findViewByXpath#" + th.getClass().getSimpleName());
            return view;
        }
    }

    public static C0427r a(Activity activity, View view) {
        boolean z11;
        if (!(activity == null || view == null)) {
            try {
                View findViewById = activity.findViewById(16908290);
                if (findViewById == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(32);
                arrayList.add(view);
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z11 = false;
                        break;
                    }
                    arrayList.add((View) parent);
                    if (parent == findViewById) {
                        z11 = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z11) {
                    return null;
                }
                int size = arrayList.size() - 1;
                if (((View) arrayList.get(size)) != findViewById) {
                    return null;
                }
                ViewParent parent2 = findViewById.getParent();
                C0427r a11 = parent2 instanceof ViewGroup ? a((ViewGroup) parent2, new C0427r(), findViewById, 0) : null;
                ViewGroup viewGroup = (ViewGroup) findViewById;
                for (int i11 = size - 1; i11 >= 0; i11--) {
                    View view2 = (View) arrayList.get(i11);
                    if (view2 != null) {
                        a11 = a(viewGroup, a11, view2, viewGroup.indexOfChild(view2));
                        if ((view2 instanceof ViewGroup) && i11 > 0) {
                            viewGroup = (ViewGroup) view2;
                        }
                    }
                }
                return a11;
            } catch (Throwable th2) {
                Logger.warn("DTM-AutoTrace", "Exception in XPathUtil#" + th2.getClass().getSimpleName());
            }
        }
        return null;
    }

    public static C0427r a(ViewGroup viewGroup, C0427r rVar, View view, int i11) {
        C0427r rVar2 = new C0427r();
        if (!(viewGroup == null || rVar == null || view == null || i11 < 0)) {
            String simpleName = view.getClass().getSimpleName();
            int a11 = f.a(viewGroup, view, i11);
            String d11 = f.d(view);
            String b11 = f.b(view);
            boolean i12 = f.i(viewGroup);
            rVar2.a(a(rVar.a(), simpleName, a11, d11, b11));
            rVar2.b(a(rVar, i12, simpleName, a11, d11, b11));
            rVar2.a(rVar.c() || i12);
        }
        return rVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(com.huawei.hms.dtm.core.C0427r r2, boolean r3, java.lang.String r4, int r5, java.lang.String r6, java.lang.String r7) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 60
            r0.<init>(r1)
            if (r3 == 0) goto L_0x0018
            java.lang.String r2 = r2.a()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x002a
            goto L_0x0022
        L_0x0018:
            java.lang.String r2 = r2.b()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x002a
        L_0x0022:
            r0.append(r2)
            r2 = 124(0x7c, float:1.74E-43)
            r0.append(r2)
        L_0x002a:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto L_0x0033
            r0.append(r4)
        L_0x0033:
            if (r3 != 0) goto L_0x0048
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L_0x0048
            r2 = 91
            r0.append(r2)
            r0.append(r5)
            r2 = 93
            r0.append(r2)
        L_0x0048:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            r3 = 35
            if (r2 != 0) goto L_0x0057
            r0.append(r3)
            r0.append(r7)
            goto L_0x0063
        L_0x0057:
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 != 0) goto L_0x0063
            r0.append(r3)
            r0.append(r6)
        L_0x0063:
            java.lang.String r2 = r0.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.C0432s.a(com.huawei.hms.dtm.core.r, boolean, java.lang.String, int, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String a(String str, String str2, int i11, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder(60);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append('|');
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (TextUtils.isEmpty(str4)) {
            sb2.append('[');
            sb2.append(i11);
            sb2.append(AbstractJsonLexerKt.END_LIST);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append('#');
            sb2.append(str4);
        } else if (!TextUtils.isEmpty(str3)) {
            sb2.append('#');
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public static List<C0422q> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] split = str.split("(\\|)");
        if (split.length == 0) {
            return arrayList;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                C0422q qVar = new C0422q();
                String[] split2 = str2.split("#");
                if (split2.length != 0) {
                    if (split2.length >= 2) {
                        qVar.b(split2[1]);
                    }
                    String[] split3 = split2[0].split("(\\[)");
                    if (split3.length != 0) {
                        if (split3.length >= 2) {
                            String str3 = split3[1];
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    qVar.a(Integer.parseInt(str3.split("(\\])")[0]));
                                } catch (Throwable unused) {
                                    Logger.debug("DTM-Execute", "splitXPath#index error");
                                }
                            }
                        }
                        qVar.a(split3[0]);
                        arrayList.add(qVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean b(Activity activity, String str) {
        return (activity == null || TextUtils.isEmpty(str) || activity.findViewById(16908290) == null) ? false : true;
    }
}
