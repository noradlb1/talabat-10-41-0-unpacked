package com.huawei.location.crowdsourcing.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LW {
    private void yn(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, long j11, byte[] bArr) throws IOException {
        int read = fileInputStream.read(bArr, 0, (int) j11);
        if (read != -1) {
            bufferedOutputStream.write(bArr, 0, read);
        }
    }

    private boolean yn(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                if (!yn(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c9 A[LOOP:2: B:44:0x00c3->B:46:0x00c9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7 A[LOOP:0: B:1:0x0005->B:49:0x00e7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ed A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean yn(java.util.List<com.huawei.location.crowdsourcing.upload.entity.FB.yn> r24, java.lang.String r25, java.io.FileInputStream r26) {
        /*
            r23 = this;
            java.lang.String r1 = "UploadFile"
            r2 = 0
            r0 = r2
            r3 = r0
        L_0x0005:
            int r4 = r24.size()
            if (r3 >= r4) goto L_0x00ec
            r4 = r24
            java.lang.Object r0 = r4.get(r3)
            r5 = r0
            com.huawei.location.crowdsourcing.upload.entity.FB$yn r5 = (com.huawei.location.crowdsourcing.upload.entity.FB.yn) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = r25
            r0.append(r6)
            java.util.Locale r7 = java.util.Locale.ENGLISH
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            r9[r2] = r10
            java.lang.String r10 = ".%02d"
            java.lang.String r7 = java.lang.String.format(r7, r10, r9)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r0]
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
            r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
            r14.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
            long r12 = r5.Vw     // Catch:{ all -> 0x0095 }
            long r10 = (long) r0     // Catch:{ all -> 0x0095 }
            int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            long r16 = r12 / r10
            long r18 = r12 % r10
            r0 = r2
        L_0x0050:
            long r12 = (long) r0
            int r9 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x006b
            r9 = r23
            r20 = r10
            r10 = r26
            r11 = r14
            r12 = r20
            r22 = r14
            r14 = r15
            r9.yn(r10, r11, r12, r14)     // Catch:{ all -> 0x0093 }
            int r0 = r0 + 1
            r10 = r20
            r14 = r22
            goto L_0x0050
        L_0x006b:
            r22 = r14
            r9 = 0
            int r0 = (r18 > r9 ? 1 : (r18 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x008c
            r9 = r23
            r10 = r26
            r11 = r22
            r12 = r18
            r14 = r15
            r9.yn(r10, r11, r12, r14)     // Catch:{ all -> 0x0093 }
            goto L_0x008c
        L_0x0080:
            r22 = r14
            r9 = r23
            r10 = r26
            r11 = r22
            r14 = r15
            r9.yn(r10, r11, r12, r14)     // Catch:{ all -> 0x0093 }
        L_0x008c:
            r22.flush()     // Catch:{ all -> 0x0093 }
            r22.close()     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
            goto L_0x00ae
        L_0x0093:
            r0 = move-exception
            goto L_0x0098
        L_0x0095:
            r0 = move-exception
            r22 = r14
        L_0x0098:
            r9 = r0
            throw r9     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            r10 = r0
            r22.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00a5
        L_0x00a0:
            r0 = move-exception
            r11 = r0
            r9.addSuppressed(r11)     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
        L_0x00a5:
            throw r10     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x00a6 }
        L_0x00a6:
            java.lang.String r0 = "IOException"
            goto L_0x00ab
        L_0x00a9:
            java.lang.String r0 = "FileNotFoundException"
        L_0x00ab:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x00ae:
            com.huawei.location.crowdsourcing.upload.http.LW r0 = new com.huawei.location.crowdsourcing.upload.http.LW
            java.lang.String r9 = r5.f50081yn
            r0.<init>(r9)
            com.huawei.location.crowdsourcing.upload.http.LW r0 = r0.Vw(r7)
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.FB
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x00c3:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00df
            java.lang.Object r7 = r5.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            r0.yn(r9, r7)
            goto L_0x00c3
        L_0x00df:
            java.lang.Class<com.huawei.location.crowdsourcing.upload.http.yn> r5 = com.huawei.location.crowdsourcing.upload.http.yn.class
            com.huawei.location.crowdsourcing.upload.http.yn r0 = r0.yn(r5)
            if (r0 == 0) goto L_0x00ed
            int r3 = r3 + 1
            r0 = r8
            goto L_0x0005
        L_0x00ec:
            r2 = r0
        L_0x00ed:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.LW.yn(java.util.List, java.lang.String, java.io.FileInputStream):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean yn(java.util.List<com.huawei.location.crowdsourcing.upload.entity.FB.yn> r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            java.lang.String r9 = r0.getName()
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getParent()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            java.lang.String r4 = "split"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r7.yn(r1)
            boolean r2 = r1.mkdir()
            java.lang.String r4 = "UploadFile"
            r5 = 0
            if (r2 != 0) goto L_0x003a
            java.lang.String r8 = "make split dir failed"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r8)
            return r5
        L_0x003a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = r1.getPath()
            r2.append(r6)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0069 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0069 }
            boolean r5 = r7.yn(r8, r9, r2)     // Catch:{ all -> 0x005d }
            r2.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006e
        L_0x005d:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x005f }
        L_0x005f:
            r9 = move-exception
            r2.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            r8.addSuppressed(r0)     // Catch:{ IOException -> 0x0069 }
        L_0x0068:
            throw r9     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            java.lang.String r8 = "IOException:....fileinputstream."
            com.huawei.location.lite.common.log.LogConsole.i(r4, r8)
        L_0x006e:
            r7.yn(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.LW.yn(java.util.List, java.lang.String):boolean");
    }
}
