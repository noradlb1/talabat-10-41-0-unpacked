package com.huawei.agconnect.common.api;

public class CPUModelUtil {
    private static final String FILE_KEY = "Hardware";
    private static final String FILE_PATH = "/proc/cpuinfo";
    private static final String SPLIT_KEY = ":";
    private static final String TAG = "CPUModelUtil";

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e A[SYNTHETIC, Splitter:B:33:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0 A[SYNTHETIC, Splitter:B:42:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0 A[SYNTHETIC, Splitter:B:48:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuModel() {
        /*
            java.lang.String r0 = ":"
            java.lang.String r1 = "close cpuinfo io error :"
            java.lang.String r2 = "CPUModelUtil"
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
            java.lang.String r7 = "/proc/cpuinfo"
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
            java.lang.String r7 = "UTF-8"
            r5.<init>(r6, r7)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0073 }
        L_0x001a:
            java.lang.String r3 = r4.readLine()     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            if (r3 == 0) goto L_0x005e
            java.lang.String r5 = "Hardware"
            boolean r5 = r3.contains(r5)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            if (r5 == 0) goto L_0x001a
            java.lang.String[] r5 = r3.split(r0)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            int r5 = r5.length     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            r6 = 1
            if (r5 <= r6) goto L_0x001a
            java.lang.String[] r5 = r3.split(r0)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            r5 = r5[r6]     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            if (r5 == 0) goto L_0x001a
            java.lang.String[] r0 = r3.split(r0)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            r0 = r0[r6]     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            java.lang.String r0 = r0.trim()     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006c, all -> 0x0069 }
            r4.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x005d
        L_0x0046:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = r3.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.huawei.agconnect.common.api.Logger.e(r2, r1)
        L_0x005d:
            return r0
        L_0x005e:
            r4.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x00bb
        L_0x0062:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00aa
        L_0x0069:
            r0 = move-exception
            r3 = r4
            goto L_0x00be
        L_0x006c:
            r0 = move-exception
            r3 = r4
            goto L_0x0074
        L_0x006f:
            r3 = r4
            goto L_0x0099
        L_0x0071:
            r0 = move-exception
            goto L_0x00be
        L_0x0073:
            r0 = move-exception
        L_0x0074:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r4.<init>()     // Catch:{ all -> 0x0071 }
            java.lang.String r5 = "read cpuinfo file error :"
            r4.append(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0071 }
            r4.append(r0)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0071 }
            com.huawei.agconnect.common.api.Logger.e(r2, r0)     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x00bb
            r3.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x00bb
        L_0x0092:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00aa
        L_0x0099:
            java.lang.String r0 = "can not find cpuinfo file"
            com.huawei.agconnect.common.api.Logger.e(r2, r0)     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x00bb
            r3.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00bb
        L_0x00a4:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00aa:
            r3.append(r1)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.agconnect.common.api.Logger.e(r2, r0)
        L_0x00bb:
            java.lang.String r0 = ""
            return r0
        L_0x00be:
            if (r3 == 0) goto L_0x00db
            r3.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00db
        L_0x00c4:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = r3.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.huawei.agconnect.common.api.Logger.e(r2, r1)
        L_0x00db:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.common.api.CPUModelUtil.getCpuModel():java.lang.String");
    }
}
