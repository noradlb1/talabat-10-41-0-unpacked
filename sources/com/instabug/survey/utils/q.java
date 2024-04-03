package com.instabug.survey.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.common.models.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class q {
    @VisibleForTesting
    public static int a(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        try {
            Method declaredMethod = InstabugUserEventLogger.class.getDeclaredMethod("e", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(InstabugUserEventLogger.getInstance(), new Object[]{str});
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", e11.getMessage() + "");
        }
        return 0;
    }

    @VisibleForTesting
    public static boolean a(@NonNull c cVar) {
        if (cVar == null) {
            return true;
        }
        HashMap<String, String> all = UserAttributesDbHelper.getAll();
        return all.containsKey(cVar.a()) && a(cVar, all.get(cVar.a()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.instabug.survey.common.models.c r8, int r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkUserEvent(condition: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ", actualValue: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "IBG-Surveys"
            com.instabug.library.util.InstabugSDKLogger.v(r1, r0)
            r0 = 1
            if (r8 != 0) goto L_0x0027
            return r0
        L_0x0027:
            java.lang.String r1 = r8.c()
            r2 = 0
            if (r1 == 0) goto L_0x00a9
            java.lang.String r1 = r8.b()
            if (r1 != 0) goto L_0x0036
            goto L_0x00a9
        L_0x0036:
            java.lang.String r1 = r8.c()     // Catch:{ NumberFormatException -> 0x00a3 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00a3 }
            java.lang.String r3 = r8.b()     // Catch:{ NumberFormatException -> 0x00a3 }
            int r4 = r3.hashCode()     // Catch:{ NumberFormatException -> 0x00a3 }
            r5 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r6 = 3
            r7 = 2
            if (r4 == r5) goto L_0x007b
            r5 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r4 == r5) goto L_0x0071
            r5 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r4 == r5) goto L_0x0067
            r5 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r4 == r5) goto L_0x005d
            goto L_0x0085
        L_0x005d:
            java.lang.String r4 = "not_equal"
            boolean r8 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a3 }
            if (r8 == 0) goto L_0x0085
            r8 = r0
            goto L_0x0086
        L_0x0067:
            java.lang.String r4 = "less_than"
            boolean r8 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a3 }
            if (r8 == 0) goto L_0x0085
            r8 = r6
            goto L_0x0086
        L_0x0071:
            java.lang.String r4 = "equal"
            boolean r8 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a3 }
            if (r8 == 0) goto L_0x0085
            r8 = r2
            goto L_0x0086
        L_0x007b:
            java.lang.String r4 = "greater_than"
            boolean r8 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a3 }
            if (r8 == 0) goto L_0x0085
            r8 = r7
            goto L_0x0086
        L_0x0085:
            r8 = -1
        L_0x0086:
            if (r8 == 0) goto L_0x009e
            if (r8 == r0) goto L_0x0099
            if (r8 == r7) goto L_0x0094
            if (r8 == r6) goto L_0x008f
            return r2
        L_0x008f:
            if (r9 >= r1) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r0 = r2
        L_0x0093:
            return r0
        L_0x0094:
            if (r9 <= r1) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r0 = r2
        L_0x0098:
            return r0
        L_0x0099:
            if (r9 == r1) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r0 = r2
        L_0x009d:
            return r0
        L_0x009e:
            if (r9 != r1) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r0 = r2
        L_0x00a2:
            return r0
        L_0x00a3:
            r9 = move-exception
            boolean r8 = a((com.instabug.survey.common.models.c) r8, (java.lang.Throwable) r9)
            return r8
        L_0x00a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.q.a(com.instabug.survey.common.models.c, int):boolean");
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static boolean a(@Nullable c cVar, @Nullable String str) {
        boolean contains;
        InstabugSDKLogger.v("IBG-Surveys", "checkStringCondition(condition: " + cVar + ", actualValue: " + str + ")");
        if (cVar == null) {
            return true;
        }
        if (!(cVar.c() == null || str == null)) {
            String c11 = cVar.c();
            if (cVar.b() != null) {
                String b11 = cVar.b();
                b11.hashCode();
                char c12 = 65535;
                switch (b11.hashCode()) {
                    case -630852760:
                        if (b11.equals("not_contain")) {
                            c12 = 0;
                            break;
                        }
                        break;
                    case 96757556:
                        if (b11.equals("equal")) {
                            c12 = 1;
                            break;
                        }
                        break;
                    case 951526612:
                        if (b11.equals("contain")) {
                            c12 = 2;
                            break;
                        }
                        break;
                    case 1614662344:
                        if (b11.equals("not_equal")) {
                            c12 = 3;
                            break;
                        }
                        break;
                }
                switch (c12) {
                    case 0:
                        contains = str.contains(c11);
                        break;
                    case 1:
                        return str.equals(c11);
                    case 2:
                        return str.contains(c11);
                    case 3:
                        contains = str.equals(c11);
                        break;
                    default:
                        return false;
                }
                return !contains;
            }
        }
        return false;
    }

    public static boolean a(c cVar, Throwable th2) {
        InstabugCore.reportError(th2, "Failed to resolve condition: " + cVar);
        InstabugSDKLogger.e("IBG-Surveys", "Failed to resolve condition: " + cVar, th2);
        return false;
    }

    @VisibleForTesting
    public static boolean a(ArrayList arrayList, String str) {
        int i11 = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        InstabugSDKLogger.v("IBG-Surveys", "checkCustomAttributesConditions(customAttributesConditions: " + size + ", conditionsOperator: " + str + ")");
        boolean equals = str.equals("and");
        while (i11 < size) {
            boolean a11 = a((c) arrayList.get(i11));
            equals = i11 == 0 ? a11 : "or".equals(str) ? equals | a11 : equals & a11;
            i11++;
        }
        return equals;
    }

    public static boolean b(c cVar) {
        if (cVar == null) {
            return true;
        }
        int a11 = a(cVar.a());
        InstabugSDKLogger.v("IBG-Surveys", "checkUserEvent(condition: " + cVar + ", actualEventLoggingCount: " + a11 + ")");
        return a(cVar, a11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.ArrayList r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "and"
            boolean r1 = r8.equals(r0)
            if (r7 != 0) goto L_0x0009
            return r1
        L_0x0009:
            r2 = 0
            r3 = r2
        L_0x000b:
            int r4 = r7.size()
            if (r3 >= r4) goto L_0x0048
            java.lang.Object r4 = r7.get(r3)
            com.instabug.survey.common.models.c r4 = (com.instabug.survey.common.models.c) r4
            boolean r4 = b(r4)
            if (r3 != 0) goto L_0x001f
            r1 = r4
            goto L_0x0045
        L_0x001f:
            int r5 = r8.hashCode()
            r6 = 3555(0xde3, float:4.982E-42)
            if (r5 == r6) goto L_0x0035
            r6 = 96727(0x179d7, float:1.35543E-40)
            if (r5 == r6) goto L_0x002d
            goto L_0x003f
        L_0x002d:
            boolean r5 = r8.equals(r0)
            if (r5 == 0) goto L_0x003f
            r5 = 1
            goto L_0x0040
        L_0x0035:
            java.lang.String r5 = "or"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x003f
            r5 = r2
            goto L_0x0040
        L_0x003f:
            r5 = -1
        L_0x0040:
            if (r5 == 0) goto L_0x0044
            r1 = r1 & r4
            goto L_0x0045
        L_0x0044:
            r1 = r1 | r4
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.q.b(java.util.ArrayList, java.lang.String):boolean");
    }
}
