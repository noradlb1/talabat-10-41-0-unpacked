package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.JavaConstant;

@SuppressLint({"LogConditional"})
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            System.out.println(str2 + "     " + getName(childAt));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Field[] fields = layoutParams.getClass().getFields();
            for (int i12 = 0; i12 < fields.length; i12++) {
                Field field = fields[i12];
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To")) {
                        if (!obj.toString().equals("-1")) {
                            System.out.println(str2 + "       " + field.getName() + " " + obj);
                        }
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        System.out.println(str + "------------- " + cls.getName() + " --------------------");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint")) {
                    if (!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) {
                        if (!(obj2 instanceof Integer) || !obj2.toString().equals("0")) {
                            if (!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) {
                                if (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")) {
                                    System.out.println(str + "    " + field.getName() + " " + obj2);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Field[] fields = MotionEvent.class.getFields();
        for (Field field : fields) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt((Object) null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i11) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i11 + 2];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i11) {
        return getState(motionLayout, i11, -1);
    }

    public static void logStack(String str, String str2, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i11, stackTrace.length - 1);
        String str3 = " ";
        for (int i12 = 1; i12 <= min; i12++) {
            StackTraceElement stackTraceElement = stackTrace[i12];
            str3 = str3 + " ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str3);
            sb2.append(".(" + stackTrace[i12].getFileName() + CertificateUtil.DELIMITER + stackTrace[i12].getLineNumber() + ") " + stackTrace[i12].getMethodName());
            sb2.append(str3);
        }
    }

    public static void printStack(String str, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i11, stackTrace.length - 1);
        String str2 = " ";
        for (int i12 = 1; i12 <= min; i12++) {
            StackTraceElement stackTraceElement = stackTrace[i12];
            str2 = str2 + " ";
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i12].getFileName() + CertificateUtil.DELIMITER + stackTrace[i12].getLineNumber() + ") ") + str2);
        }
    }

    public static String getState(MotionLayout motionLayout, int i11, int i12) {
        int length;
        if (i11 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i11);
        if (i12 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i12) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i12 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        int length2 = (resourceEntryName.length() - i12) / length;
        return resourceEntryName.replaceAll(CharBuffer.allocate(length2).toString().replace(0, '.') + JavaConstant.Dynamic.DEFAULT_NAME, JavaConstant.Dynamic.DEFAULT_NAME);
    }

    public static String getName(Context context, int i11) {
        if (i11 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i11);
        } catch (Exception unused) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL + i11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = "? " + r6[r1] + " ";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getName(android.content.Context r5, int[] r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r0.<init>()     // Catch:{ Exception -> 0x0072 }
            int r1 = r6.length     // Catch:{ Exception -> 0x0072 }
            r0.append(r1)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = "["
            r0.append(r1)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0072 }
            r1 = 0
        L_0x0013:
            int r2 = r6.length     // Catch:{ Exception -> 0x0072 }
            if (r1 >= r2) goto L_0x0060
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r2.<init>()     // Catch:{ Exception -> 0x0072 }
            r2.append(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = " "
            if (r1 != 0) goto L_0x0025
            java.lang.String r3 = ""
            goto L_0x0026
        L_0x0025:
            r3 = r0
        L_0x0026:
            r2.append(r3)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0072 }
            android.content.res.Resources r3 = r5.getResources()     // Catch:{ NotFoundException -> 0x0038 }
            r4 = r6[r1]     // Catch:{ NotFoundException -> 0x0038 }
            java.lang.String r0 = r3.getResourceEntryName(r4)     // Catch:{ NotFoundException -> 0x0038 }
            goto L_0x004e
        L_0x0038:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "? "
            r3.append(r4)     // Catch:{ Exception -> 0x0072 }
            r4 = r6[r1]     // Catch:{ Exception -> 0x0072 }
            r3.append(r4)     // Catch:{ Exception -> 0x0072 }
            r3.append(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0072 }
        L_0x004e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            r3.append(r2)     // Catch:{ Exception -> 0x0072 }
            r3.append(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0072 }
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0060:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r5.<init>()     // Catch:{ Exception -> 0x0072 }
            r5.append(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = "]"
            r5.append(r6)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0072 }
            return r5
        L_0x0072:
            r5 = move-exception
            r5.toString()
            java.lang.String r5 = "UNKNOWN"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.Debug.getName(android.content.Context, int[]):java.lang.String");
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + "  " + layoutParams.getClass().getName());
        Field[] fields = layoutParams.getClass().getFields();
        for (Field field : fields) {
            try {
                Object obj = field.get(layoutParams);
                String name2 = field.getName();
                if (name2.contains("To")) {
                    if (!obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + name2 + " " + obj);
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }
}
