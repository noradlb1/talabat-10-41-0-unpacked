package com.instabug.library.instacapture.screenshot;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import java.lang.reflect.Field;

public class FieldHelper {
    private static final String FIELD_NAME_GLOBAL = "mGlobal";
    private static final String FIELD_NAME_PARAMS = "mParams";
    private static final String FIELD_NAME_ROOTS = "mRoots";
    private static final String FIELD_NAME_VIEW = "mView";
    private static final String FIELD_NAME_WINDOW_MANAGER = "mWindowManager";
    private static final int[] outLocation = new int[2];

    private FieldHelper() {
    }

    public static Field findField(String str, Class cls) throws NoSuchFieldException {
        Class cls2 = cls;
        while (cls2 != null && cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            cls2 = cls2.getSuperclass();
        }
        throw new NoSuchFieldException("Field: " + str + " is not found in class: " + cls.toString());
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    private static Object getFieldValue(String str, Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field field;
        if (str.equals(FIELD_NAME_WINDOW_MANAGER)) {
            field = findField(str, obj.getClass());
        } else {
            field = obj.getClass().getDeclaredField(str);
        }
        field.setAccessible(true);
        return field.get(obj);
    }

    /* JADX WARNING: type inference failed for: r11v7, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.instabug.library.instacapture.screenshot.RootViewInfo> getRootViews(android.app.Activity r11, @androidx.annotation.IdRes @androidx.annotation.Nullable int[] r12) {
        /*
            java.lang.String r0 = "IBG-Core"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "mGlobal"
            android.view.WindowManager r11 = r11.getWindowManager()     // Catch:{ Exception -> 0x0085 }
            java.lang.Object r11 = getFieldValue(r2, r11)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = "mRoots"
            java.lang.Object r2 = getFieldValue(r2, r11)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r3 = "mParams"
            java.lang.Object r11 = getFieldValue(r3, r11)     // Catch:{ Exception -> 0x0085 }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.util.List r2 = (java.util.List) r2
            java.lang.Object[] r2 = r2.toArray()
            goto L_0x0028
        L_0x0027:
            r2 = r3
        L_0x0028:
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L_0x0039
            int r3 = r11.size()
            android.view.WindowManager$LayoutParams[] r3 = new android.view.WindowManager.LayoutParams[r3]
            java.lang.Object[] r11 = r11.toArray(r3)
            r3 = r11
            android.view.WindowManager$LayoutParams[] r3 = (android.view.WindowManager.LayoutParams[]) r3
        L_0x0039:
            if (r2 == 0) goto L_0x0084
            r11 = 0
            r4 = r11
        L_0x003d:
            int r5 = r2.length
            if (r4 >= r5) goto L_0x0084
            java.lang.String r5 = "mView"
            r6 = r2[r4]     // Catch:{ Exception -> 0x007b }
            java.lang.Object r5 = getFieldValue(r5, r6)     // Catch:{ Exception -> 0x007b }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x007b }
            if (r12 == 0) goto L_0x005f
            int r6 = r12.length     // Catch:{ Exception -> 0x007b }
            r7 = r11
            r8 = r7
        L_0x004f:
            if (r7 >= r6) goto L_0x0060
            r9 = r12[r7]     // Catch:{ Exception -> 0x007b }
            if (r5 == 0) goto L_0x005c
            int r10 = r5.getId()     // Catch:{ Exception -> 0x007b }
            if (r9 != r10) goto L_0x005c
            r8 = 1
        L_0x005c:
            int r7 = r7 + 1
            goto L_0x004f
        L_0x005f:
            r8 = r11
        L_0x0060:
            if (r5 == 0) goto L_0x0081
            int r6 = r5.getVisibility()     // Catch:{ Exception -> 0x007b }
            if (r6 != 0) goto L_0x0081
            if (r8 != 0) goto L_0x0081
            if (r3 == 0) goto L_0x0081
            com.instabug.library.instacapture.screenshot.RootViewInfo r6 = new com.instabug.library.instacapture.screenshot.RootViewInfo     // Catch:{ Exception -> 0x007b }
            android.graphics.Rect r7 = getViewRect(r5)     // Catch:{ Exception -> 0x007b }
            r8 = r3[r4]     // Catch:{ Exception -> 0x007b }
            r6.<init>(r5, r7, r8)     // Catch:{ Exception -> 0x007b }
            r1.add(r6)     // Catch:{ Exception -> 0x007b }
            goto L_0x0081
        L_0x007b:
            r5 = move-exception
            java.lang.String r6 = "Screenshot capturing failed in one of the viewRoots"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r6, r5)
        L_0x0081:
            int r4 = r4 + 1
            goto L_0x003d
        L_0x0084:
            return r1
        L_0x0085:
            r11 = move-exception
            java.lang.String r12 = "Can't fine one of (WindowManager, rootObjects, paramsObject) field name so screenshot capturing failed"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r12, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.instacapture.screenshot.FieldHelper.getRootViews(android.app.Activity, int[]):java.util.List");
    }

    private static Rect getViewRect(View view) {
        int[] iArr = outLocation;
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        return new Rect(i11, i12, view.getWidth() + i11, view.getHeight() + i12);
    }
}
