package com.huawei.location.lite.common.util.unzip;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public class Un7Z implements IUnzip {
    private static final String INVALID_STR = "../";
    private static final String INVALID_STR2 = "..\\";
    private static final String TAG = "Un7Z";
    private static final int TOP_FILE_NUM = 1000;
    private static final int TOP_SIZE = 104857600;
    private boolean isHasUn7ZCoreMethod = isHasCoreMethod();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createFile(java.lang.String r3, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r4, org.apache.commons.compress.archivers.sevenz.SevenZFile r5, java.util.List<java.lang.String> r6, java.util.List<java.lang.String> r7) throws java.io.IOException {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r4.getName()
            r0.<init>(r3, r1)
            java.io.File r3 = r0.getParentFile()
            if (r6 == 0) goto L_0x001c
            if (r3 == 0) goto L_0x001c
            java.lang.String r1 = r3.getName()
            boolean r6 = r6.contains(r1)
            if (r6 != 0) goto L_0x001c
            return
        L_0x001c:
            if (r7 == 0) goto L_0x0029
            java.lang.String r4 = r4.getName()
            boolean r4 = r7.contains(r4)
            if (r4 != 0) goto L_0x0029
            return
        L_0x0029:
            if (r3 == 0) goto L_0x0034
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x0034
            r3.mkdirs()
        L_0x0034:
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r4 = new java.io.FileOutputStream
            r4.<init>(r0)
            r3.<init>(r4)
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0052 }
        L_0x0042:
            int r6 = r5.read(r4)     // Catch:{ all -> 0x0052 }
            r7 = -1
            if (r6 == r7) goto L_0x004e
            r7 = 0
            r3.write(r4, r7, r6)     // Catch:{ all -> 0x0052 }
            goto L_0x0042
        L_0x004e:
            r3.close()
            return
        L_0x0052:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r5 = move-exception
            r3.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r3 = move-exception
            r4.addSuppressed(r3)
        L_0x005d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.Un7Z.createFile(java.lang.String, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry, org.apache.commons.compress.archivers.sevenz.SevenZFile, java.util.List, java.util.List):void");
    }

    private void createFileDir(String str, SevenZArchiveEntry sevenZArchiveEntry, List<String> list) {
        File file = new File(str, sevenZArchiveEntry.getName());
        if ((list == null || list.contains(sevenZArchiveEntry.getName())) && !file.exists()) {
            file.mkdirs();
        }
    }

    private static boolean isContainInvalidStr(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "isContainInvalidStr: name is null";
        } else if (str.contains(INVALID_STR) || str.contains(INVALID_STR2)) {
            str2 = "isContainInvalidStr: ../ or ..\\";
        } else if (str.contains("..") || str.contains("./")) {
            str2 = "isContainInvalidStr: .. or ./";
        } else if (!str.contains(".\\.\\") && !str.contains("%00")) {
            return false;
        } else {
            str2 = "isContainInvalidStr: .\\.\\ or %00";
        }
        LogConsole.e(TAG, str2);
        return true;
    }

    private static boolean isFileOrDirSafe(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || isContainInvalidStr(str)) {
            str3 = "zip file is not valid";
        } else if (TextUtils.isEmpty(str2) || isContainInvalidStr(str2)) {
            str3 = "target directory is not valid";
        } else if (isZipFileValid(str, 104857600, 1000)) {
            return true;
        } else {
            str3 = "zip file contains invalid chars or too many files";
        }
        LogConsole.e(TAG, str3);
        return false;
    }

    private boolean isHasCoreMethod() {
        return ReflectionUtils.getMethod(ReflectionUtils.getClass("java.io.File"), "toPath", new Class[0]) != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[Catch:{ IOException -> 0x0065, all -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006d A[SYNTHETIC, Splitter:B:33:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077 A[SYNTHETIC, Splitter:B:39:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isZipFileValid(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "Un7Z"
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0066 }
            r4.<init>(r11)     // Catch:{ IOException -> 0x0066 }
            boolean r11 = r4.exists()     // Catch:{ IOException -> 0x0066 }
            if (r11 != 0) goto L_0x0019
            java.lang.String r11 = "Decompress7zFromPath: has no .7zfile"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r11)     // Catch:{ IOException -> 0x0066 }
            return r3
        L_0x0017:
            r11 = move-exception
            goto L_0x0075
        L_0x0019:
            org.apache.commons.compress.archivers.sevenz.SevenZFile r11 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch:{ IOException -> 0x0066 }
            r11.<init>((java.io.File) r4)     // Catch:{ IOException -> 0x0066 }
            java.lang.Iterable r2 = r11.getEntries()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r4 = 0
            r6 = r3
        L_0x0029:
            boolean r7 = r2.hasNext()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r8 = 1
            if (r7 == 0) goto L_0x005c
            java.lang.Object r7 = r2.next()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r7 = (org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry) r7     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            long r9 = r7.getSize()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            long r4 = r4 + r9
            int r6 = r6 + r8
            java.lang.String r8 = r7.getName()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            boolean r8 = isContainInvalidStr(r8)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            if (r8 != 0) goto L_0x0056
            if (r6 >= r14) goto L_0x0056
            int r8 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r8 > 0) goto L_0x0056
            long r7 = r7.getSize()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0029
        L_0x0056:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r12)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            goto L_0x005d
        L_0x005c:
            r3 = r8
        L_0x005d:
            r11.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0074
        L_0x0061:
            r12 = move-exception
            r2 = r11
            r11 = r12
            goto L_0x0075
        L_0x0065:
            r2 = r11
        L_0x0066:
            java.lang.String r11 = "not a valid zip file, IOException"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r11)     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0074
        L_0x0071:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x0074:
            return r3
        L_0x0075:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007e
        L_0x007b:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x007e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.Un7Z.isZipFileValid(java.lang.String, long, int):boolean");
    }

    public boolean doUnzip(String str, String str2) {
        return doUnzip(str, str2, (List<String>) null, (List<String>) null);
    }

    public boolean doUnzip(String str, String str2, List<String> list, List<String> list2) {
        boolean z11;
        String str3;
        if (!isSupportUnZip(str)) {
            str3 = "Decompress7zFromPath:  path or inputFile not support";
        } else if (!isFileOrDirSafe(str, str2)) {
            str3 = "Decompress7zFromPath:  path or inputFile invalid";
        } else {
            String str4 = File.separator;
            if (str2.endsWith(str4) && str2.length() > str4.length()) {
                str2 = str2.substring(0, str2.length() - str4.length());
            }
            File file = new File(str);
            if (!file.exists()) {
                LogConsole.e(TAG, "Decompress7zFromPath: has no .7zfile");
                z11 = false;
            } else {
                z11 = true;
            }
            try {
                SevenZFile sevenZFile = new SevenZFile(file);
                while (true) {
                    SevenZArchiveEntry nextEntry = sevenZFile.getNextEntry();
                    if (nextEntry == null) {
                        return z11;
                    }
                    String name2 = nextEntry.getName();
                    if (!TextUtils.isEmpty(name2)) {
                        String normalize = Normalizer.normalize(name2.replaceAll("\\\\", "/"), Normalizer.Form.NFKC);
                        if (isContainInvalidStr(normalize)) {
                            LogConsole.e(TAG, "zipPath is a invalid path: " + normalize);
                            return false;
                        } else if (nextEntry.isDirectory()) {
                            createFileDir(str2, nextEntry, list);
                        } else {
                            createFile(str2, nextEntry, sevenZFile, list, list2);
                        }
                    }
                }
            } catch (IOException unused) {
                LogConsole.e(TAG, "decompress7zFromPath : IOException");
                return false;
            }
        }
        LogConsole.e(TAG, str3);
        return false;
    }

    public boolean isSupportUnZip(String str) {
        return str.contains(".7z") && this.isHasUn7ZCoreMethod;
    }
}
