package com.huawei.location.tiles.utils;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

public class yn {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String Vw(java.lang.String r6) {
        /*
            java.lang.String r6 = yn((java.lang.String) r6)
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0039 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0039 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r1.<init>()     // Catch:{ all -> 0x002d }
        L_0x0012:
            int r2 = r0.read(r6)     // Catch:{ all -> 0x002d }
            r3 = -1
            if (r2 == r3) goto L_0x0025
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x002d }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x002d }
            r5 = 0
            r3.<init>(r6, r5, r2, r4)     // Catch:{ all -> 0x002d }
            r1.append(r3)     // Catch:{ all -> 0x002d }
            goto L_0x0012
        L_0x0025:
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x002d }
            r0.close()     // Catch:{ IOException -> 0x0039 }
            return r6
        L_0x002d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r6.addSuppressed(r0)     // Catch:{ IOException -> 0x0039 }
        L_0x0038:
            throw r1     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            java.lang.String r6 = "FileUtils"
            java.lang.String r0 = "read data from file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r6, r0)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.Vw(java.lang.String):java.lang.String");
    }

    public static String yn(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        if (str.contains("../")) {
            str = str.trim().replaceAll("\\.\\./", "");
        }
        return str.contains("..\\") ? str.trim().replaceAll("\\.\\.\\\\", "") : str;
    }

    public static String yn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogConsole.i("FileUtils", "Failed to combine paths, the local dir is empty");
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            LogConsole.i("FileUtils", "Failed to combine paths, the download Url is empty");
            return null;
        } else {
            int lastIndexOf = str2.lastIndexOf(File.separator);
            if (lastIndexOf < 0 || lastIndexOf == str2.length() - 1) {
                LogConsole.i("FileUtils", "Failed to combine paths, The download url is abnormal.");
                return null;
            }
            String substring = str2.substring(lastIndexOf + 1);
            if (!Pattern.compile("[a-zA-Z0-9\\.\\-\\_]+").matcher(substring).matches()) {
                LogConsole.i("FileUtils", "Failed to combine paths, The file path contains invalid characters.");
                return null;
            }
            return str + substring;
        }
    }

    public static void yn(String str, int i11) {
        String str2;
        File file = new File(str);
        if (!file.exists()) {
            str2 = "The directory does not exist.";
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length < i11) {
                str2 = "The number of files does not exceed the limit.";
            } else {
                Arrays.sort(listFiles, new dC());
                for (int i12 = i11 - 1; i12 < listFiles.length; i12++) {
                    if (!listFiles[i12].delete()) {
                        LogConsole.d("FileUtils", "file delete fail");
                    }
                }
                return;
            }
        }
        LogConsole.e("FileUtils", str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0035, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void yn(java.lang.String r3, java.io.File r4) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x003f }
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x003f }
            byte[] r3 = r3.getBytes(r1)     // Catch:{ IOException -> 0x003f }
            r0.<init>(r3)     // Catch:{ IOException -> 0x003f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0033 }
            r3.<init>(r4)     // Catch:{ all -> 0x0033 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0027 }
        L_0x0014:
            int r1 = r0.read(r4)     // Catch:{ all -> 0x0027 }
            r2 = -1
            if (r1 == r2) goto L_0x0020
            r2 = 0
            r3.write(r4, r2, r1)     // Catch:{ all -> 0x0027 }
            goto L_0x0014
        L_0x0020:
            r3.close()     // Catch:{ all -> 0x0033 }
            r0.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0046
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r1 = move-exception
            r3.close()     // Catch:{ all -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x0033 }
        L_0x0032:
            throw r1     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ IOException -> 0x003f }
        L_0x003e:
            throw r4     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            java.lang.String r3 = "FileUtils"
            java.lang.String r4 = "write data to file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r4)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.yn(java.lang.String, java.io.File):void");
    }

    private static void yn(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length / 2; i11++) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[(bArr.length - i11) - 1];
            bArr[(bArr.length - i11) - 1] = b11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean yn(java.io.File r5, java.util.zip.ZipInputStream r6) throws java.io.IOException {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            boolean r1 = r5.exists()
            r2 = 0
            if (r1 != 0) goto L_0x003f
            boolean r1 = r5.createNewFile()
            if (r1 == 0) goto L_0x003f
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0038 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0038 }
            int r5 = r6.read(r0)     // Catch:{ all -> 0x002c }
            r3 = r2
        L_0x001b:
            r4 = -1
            if (r5 == r4) goto L_0x0027
            r1.write(r0, r2, r5)     // Catch:{ all -> 0x002c }
            int r5 = r6.read(r0)     // Catch:{ all -> 0x002c }
            r3 = 1
            goto L_0x001b
        L_0x0027:
            r1.close()     // Catch:{ IOException -> 0x0038 }
            r2 = r3
            goto L_0x003f
        L_0x002c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002e }
        L_0x002e:
            r6 = move-exception
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            r5.addSuppressed(r0)     // Catch:{ IOException -> 0x0038 }
        L_0x0037:
            throw r6     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            java.lang.String r5 = "FileUtils"
            java.lang.String r6 = "zip fos error is: "
            com.huawei.location.lite.common.log.LogConsole.e(r5, r6)
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.yn(java.io.File, java.util.zip.ZipInputStream):boolean");
    }

    public static boolean yn(String str, long j11) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && System.currentTimeMillis() - file.lastModified() <= j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String yn(java.lang.String r21, double r22, double r24) {
        /*
            r1 = r22
            r3 = r24
            java.lang.String r5 = "CityAdminUtils"
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r0 = yn((java.lang.String) r21)
            java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
            r8.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
            r0 = 8
            byte[] r8 = new byte[r0]     // Catch:{ all -> 0x00e1 }
            r9 = 0
            int r10 = r7.read(r8, r9, r0)     // Catch:{ all -> 0x00e1 }
            if (r10 > 0) goto L_0x0026
            goto L_0x00dd
        L_0x0026:
            yn((byte[]) r8)     // Catch:{ all -> 0x00e1 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.wrap(r8)     // Catch:{ all -> 0x00e1 }
            long r10 = r8.getLong()     // Catch:{ all -> 0x00e1 }
            r12 = 0
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 > 0) goto L_0x0039
            goto L_0x00dd
        L_0x0039:
            int r8 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r8 >= 0) goto L_0x00dd
            com.huawei.location.tiles.utils.Vw r8 = new com.huawei.location.tiles.utils.Vw     // Catch:{ all -> 0x00e1 }
            r8.<init>()     // Catch:{ all -> 0x00e1 }
            r14 = 16
            byte[] r15 = new byte[r14]     // Catch:{ all -> 0x00e1 }
            int r14 = r7.read(r15, r9, r14)     // Catch:{ all -> 0x00e1 }
            if (r14 > 0) goto L_0x0053
            r15 = r0
            r17 = r10
            r19 = r12
            goto L_0x00d3
        L_0x0053:
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x00e1 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00e1 }
            r14.<init>(r15, r0)     // Catch:{ all -> 0x00e1 }
            java.lang.String r0 = r14.trim()     // Catch:{ all -> 0x00e1 }
            r8.yn((java.lang.String) r0)     // Catch:{ all -> 0x00e1 }
            r0 = 4
            byte[] r14 = new byte[r0]     // Catch:{ all -> 0x00e1 }
            int r0 = r7.read(r14, r9, r0)     // Catch:{ all -> 0x00e1 }
            if (r0 > 0) goto L_0x0071
        L_0x006a:
            r17 = r10
            r19 = r12
            r15 = 8
            goto L_0x00d3
        L_0x0071:
            yn((byte[]) r14)     // Catch:{ all -> 0x00e1 }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r14)     // Catch:{ all -> 0x00e1 }
            int r0 = r0.getInt()     // Catch:{ all -> 0x00e1 }
            if (r0 > 0) goto L_0x007f
            goto L_0x006a
        L_0x007f:
            r14 = r9
        L_0x0080:
            if (r14 >= r0) goto L_0x00ca
            r15 = 8
            byte[] r9 = new byte[r15]     // Catch:{ all -> 0x00e1 }
            r16 = r0
            r0 = 0
            int r17 = r7.read(r9, r0, r15)     // Catch:{ all -> 0x00e1 }
            if (r17 > 0) goto L_0x0094
            r17 = r10
        L_0x0091:
            r19 = r12
            goto L_0x00c0
        L_0x0094:
            yn((byte[]) r9)     // Catch:{ all -> 0x00e1 }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r9)     // Catch:{ all -> 0x00e1 }
            r17 = r10
            double r9 = r0.getDouble()     // Catch:{ all -> 0x00e1 }
            byte[] r0 = new byte[r15]     // Catch:{ all -> 0x00e1 }
            r11 = 0
            int r19 = r7.read(r0, r11, r15)     // Catch:{ all -> 0x00e1 }
            if (r19 > 0) goto L_0x00ab
            goto L_0x0091
        L_0x00ab:
            yn((byte[]) r0)     // Catch:{ all -> 0x00e1 }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ all -> 0x00e1 }
            r19 = r12
            double r11 = r0.getDouble()     // Catch:{ all -> 0x00e1 }
            com.huawei.location.tiles.utils.d2 r0 = new com.huawei.location.tiles.utils.d2     // Catch:{ all -> 0x00e1 }
            r0.<init>(r11, r9)     // Catch:{ all -> 0x00e1 }
            r8.yn((com.huawei.location.tiles.utils.d2) r0)     // Catch:{ all -> 0x00e1 }
        L_0x00c0:
            int r14 = r14 + 1
            r0 = r16
            r10 = r17
            r12 = r19
            r9 = 0
            goto L_0x0080
        L_0x00ca:
            r17 = r10
            r19 = r12
            r15 = 8
            r6.add(r8)     // Catch:{ all -> 0x00e1 }
        L_0x00d3:
            r8 = 1
            long r12 = r19 + r8
            r0 = r15
            r10 = r17
            r9 = 0
            goto L_0x0039
        L_0x00dd:
            r7.close()     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
            goto L_0x00f8
        L_0x00e1:
            r0 = move-exception
            r8 = r0
            throw r8     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            r0 = move-exception
            r9 = r0
            r7.close()     // Catch:{ all -> 0x00ea }
            goto L_0x00ef
        L_0x00ea:
            r0 = move-exception
            r7 = r0
            r8.addSuppressed(r7)     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
        L_0x00ef:
            throw r9     // Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00f0 }
        L_0x00f0:
            java.lang.String r0 = "Failed to parse file: IOException "
            goto L_0x00f5
        L_0x00f3:
            java.lang.String r0 = "Failed to read file: FileNotFoundException"
        L_0x00f5:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r0)
        L_0x00f8:
            java.util.Iterator r0 = r6.iterator()
            r5 = 0
        L_0x00fd:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x011a
            java.lang.Object r6 = r0.next()
            com.huawei.location.tiles.utils.Vw r6 = (com.huawei.location.tiles.utils.Vw) r6
            boolean r7 = r6.yn(r1, r3)
            boolean r8 = r6.Vw(r1, r3)
            if (r7 != 0) goto L_0x0115
            if (r8 == 0) goto L_0x00fd
        L_0x0115:
            java.lang.String r5 = r6.yn()
            goto L_0x00fd
        L_0x011a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.yn(java.lang.String, double, double):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c0, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c5, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r10.addSuppressed(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cd, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d2, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r9.addSuppressed(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d7, code lost:
        r9 = "zip error";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:22:0x004b, B:49:0x00bf, B:52:0x00c1] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ExcHandler: IOException (unused java.io.IOException), SYNTHETIC, Splitter:B:7:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean yn(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r1 = r0.exists()
            java.lang.String r2 = " not exists!!!"
            java.lang.String r3 = "FileUtils"
            r4 = 0
            if (r1 != 0) goto L_0x001a
            boolean r0 = r0.mkdirs()
            if (r0 != 0) goto L_0x001a
            com.huawei.location.lite.common.log.LogConsole.d(r3, r2)
            return r4
        L_0x001a:
            java.lang.String r9 = yn((java.lang.String) r9)
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00da, IOException -> 0x00d7 }
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00da, IOException -> 0x00d7 }
            r1.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00da, IOException -> 0x00d7 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00da, IOException -> 0x00d7 }
            java.util.zip.ZipInputStream r9 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x00ca }
            r9.<init>(r0)     // Catch:{ all -> 0x00ca }
            java.util.zip.ZipEntry r1 = r9.getNextEntry()     // Catch:{ all -> 0x00bd }
            r5 = r4
        L_0x0032:
            if (r1 == 0) goto L_0x00b1
            java.lang.String r6 = r1.getName()     // Catch:{ all -> 0x00af }
            java.lang.String r7 = "../"
            boolean r7 = r6.contains(r7)     // Catch:{ all -> 0x00af }
            r8 = 1
            if (r7 == 0) goto L_0x0048
            java.lang.String r7 = " is not security!!!"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r7)     // Catch:{ all -> 0x00af }
            r5 = r4
            goto L_0x0049
        L_0x0048:
            r5 = r8
        L_0x0049:
            if (r5 != 0) goto L_0x0052
            r9.close()     // Catch:{ all -> 0x00bb }
            r0.close()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00d7 }
            return r4
        L_0x0052:
            boolean r1 = r1.isDirectory()     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x0088
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            r1.append(r10)     // Catch:{ all -> 0x00af }
            java.lang.String r7 = java.io.File.separator     // Catch:{ all -> 0x00af }
            r1.append(r7)     // Catch:{ all -> 0x00af }
            r1.append(r6)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            java.lang.String r1 = yn((java.lang.String) r1)     // Catch:{ all -> 0x00af }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00af }
            r6.<init>(r1)     // Catch:{ all -> 0x00af }
            boolean r1 = r6.exists()     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x0086
            boolean r1 = r6.mkdirs()     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x0086
            com.huawei.location.lite.common.log.LogConsole.d(r3, r2)     // Catch:{ all -> 0x00af }
            r5 = r8
            goto L_0x00aa
        L_0x0086:
            r5 = r4
            goto L_0x00aa
        L_0x0088:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            r1.append(r10)     // Catch:{ all -> 0x00af }
            java.lang.String r6 = java.io.File.separator     // Catch:{ all -> 0x00af }
            r1.append(r6)     // Catch:{ all -> 0x00af }
            r1.append(r11)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            java.lang.String r1 = yn((java.lang.String) r1)     // Catch:{ all -> 0x00af }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00af }
            r6.<init>(r1)     // Catch:{ all -> 0x00af }
            boolean r1 = yn((java.io.File) r6, (java.util.zip.ZipInputStream) r9)     // Catch:{ all -> 0x00af }
            r5 = r1
        L_0x00aa:
            java.util.zip.ZipEntry r1 = r9.getNextEntry()     // Catch:{ all -> 0x00af }
            goto L_0x0032
        L_0x00af:
            r10 = move-exception
            goto L_0x00bf
        L_0x00b1:
            r9.close()     // Catch:{ all -> 0x00bb }
            r0.close()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00d7 }
            r4 = r5
            goto L_0x00df
        L_0x00b9:
            r4 = r5
            goto L_0x00da
        L_0x00bb:
            r9 = move-exception
            goto L_0x00cc
        L_0x00bd:
            r10 = move-exception
            r5 = r4
        L_0x00bf:
            throw r10     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r11 = move-exception
            r9.close()     // Catch:{ all -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r9 = move-exception
            r10.addSuppressed(r9)     // Catch:{ all -> 0x00bb }
        L_0x00c9:
            throw r11     // Catch:{ all -> 0x00bb }
        L_0x00ca:
            r9 = move-exception
            r5 = r4
        L_0x00cc:
            throw r9     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r10 = move-exception
            r0.close()     // Catch:{ all -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r11 = move-exception
            r9.addSuppressed(r11)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00d7 }
        L_0x00d6:
            throw r10     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00d7 }
        L_0x00d7:
            java.lang.String r9 = "zip error"
            goto L_0x00dc
        L_0x00da:
            java.lang.String r9 = "zip error: file not found"
        L_0x00dc:
            com.huawei.location.lite.common.log.LogConsole.e(r3, r9)
        L_0x00df:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "The unzip file is decompressed: "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r3, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.yn(java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
