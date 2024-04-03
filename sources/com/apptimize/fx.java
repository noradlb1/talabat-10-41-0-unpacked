package com.apptimize;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class fx {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42475a = "fx";

    public static int a(Object... objArr) {
        int length = objArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11 += objArr[i12] != null ? 1 : 0;
        }
        return i11;
    }

    public static long a(long j11, long j12) {
        return j11 < j12 ? j12 - j11 : -(j11 - j12);
    }

    public static String a() {
        return "3.10.18";
    }

    public static boolean b(Object obj, Object obj2) {
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            return a(obj, obj2);
        }
        return ey.a((Number) obj, (Number) obj2);
    }

    public static <T, U extends T, V> Map<U, V> a(Map<T, V> map, Class<U> cls) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (cls.isInstance(next.getKey())) {
                hashMap.put(cls.cast(next.getKey()), next.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.util.Scanner} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (r1 != null) goto L_0x0043;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A[SYNTHETIC, Splitter:B:24:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.io.File r7) {
        /*
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            boolean r1 = r7.exists()     // Catch:{ all -> 0x00b7 }
            r2 = 0
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = f42475a     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r3.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = "file exists "
            r3.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r7.getAbsolutePath()     // Catch:{ all -> 0x00b7 }
            r3.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b7 }
            com.apptimize.bo.k(r1, r3)     // Catch:{ all -> 0x00b7 }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r7, r3)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r3 = "\\A"
            java.util.Scanner r1 = r1.useDelimiter(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0047 }
            if (r3 == 0) goto L_0x0041
            java.lang.String r3 = r1.next()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = r3.trim()     // Catch:{ Exception -> 0x0047 }
            goto L_0x0043
        L_0x0041:
            java.lang.String r2 = ""
        L_0x0043:
            r1.close()     // Catch:{ all -> 0x00b7 }
            goto L_0x008c
        L_0x0047:
            r3 = move-exception
            goto L_0x004d
        L_0x0049:
            r7 = move-exception
            goto L_0x006c
        L_0x004b:
            r3 = move-exception
            r1 = r2
        L_0x004d:
            java.lang.String r4 = f42475a     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r6 = "error scanning "
            r5.append(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r6 = r7.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r5.append(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006a }
            com.apptimize.bo.h(r4, r5, r3)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x008c
            goto L_0x0043
        L_0x006a:
            r7 = move-exception
            r2 = r1
        L_0x006c:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ all -> 0x00b7 }
        L_0x0071:
            throw r7     // Catch:{ all -> 0x00b7 }
        L_0x0072:
            java.lang.String r1 = f42475a     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r3.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = "file does not exist "
            r3.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r7.getAbsolutePath()     // Catch:{ all -> 0x00b7 }
            r3.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b7 }
            com.apptimize.bo.k(r1, r3)     // Catch:{ all -> 0x00b7 }
        L_0x008c:
            android.os.StrictMode.setThreadPolicy(r0)
            java.lang.String r0 = f42475a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "file "
            r1.append(r3)
            java.lang.String r7 = r7.getAbsolutePath()
            r1.append(r7)
            java.lang.String r7 = " contents<"
            r1.append(r7)
            r1.append(r2)
            java.lang.String r7 = ">"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.apptimize.bo.k(r0, r7)
            return r2
        L_0x00b7:
            r7 = move-exception
            android.os.StrictMode.setThreadPolicy(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fx.b(java.io.File):java.lang.String");
    }

    public static String a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(exc.getClass().getName() + ": " + exc.getMessage());
        exc.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static void a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    a(file2);
                }
            }
        }
        file.delete();
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static <T> T a(AtomicReference<T> atomicReference, T t11) {
        atomicReference.set(t11);
        return t11;
    }
}
