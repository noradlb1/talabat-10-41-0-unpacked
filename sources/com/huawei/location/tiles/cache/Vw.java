package com.huawei.location.tiles.cache;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.tiles.store.dC;
import java.io.File;
import java.io.IOException;

public class Vw {

    /* renamed from: yn  reason: collision with root package name */
    private static final String f50242yn;
    private int FB;
    private int LW;
    private dC Vw;

    static {
        String str;
        try {
            str = ContextUtil.getContext().getCacheDir().getCanonicalPath() + File.separator + "tileFile";
        } catch (IOException unused) {
            LogConsole.e("TileCacheManager", "failed to get tile cache file path");
            str = "";
        }
        f50242yn = str;
    }

    public Vw(int i11, int i12) {
        this.FB = i11;
        this.LW = i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0198 A[Catch:{ all -> 0x019e, all -> 0x01a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] yn(long r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "tileId: "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "TileCacheManager"
            com.huawei.location.lite.common.log.LogConsole.d(r4, r0)
            com.huawei.location.tiles.store.dC r0 = r1.Vw
            if (r0 != 0) goto L_0x0029
            com.huawei.location.tiles.store.dC r0 = new com.huawei.location.tiles.store.dC
            int r5 = r1.FB
            int r6 = r1.LW
            r0.<init>(r5, r6)
            r1.Vw = r0
        L_0x0029:
            java.lang.String r0 = "Get files from the TileCache"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            long r5 = java.lang.System.currentTimeMillis()
            java.io.File r0 = new java.io.File
            java.lang.String r7 = f50242yn
            r0.<init>(r7)
            java.io.File[] r0 = r0.listFiles()
            java.lang.String r7 = "file delete fail"
            r8 = 0
            r9 = 0
            if (r0 != 0) goto L_0x0045
            r12 = r8
            goto L_0x0093
        L_0x0045:
            int r10 = r0.length
            r12 = r8
            r11 = r9
        L_0x0048:
            if (r11 >= r10) goto L_0x0093
            r13 = r0[r11]
            boolean r14 = r13.isDirectory()
            if (r14 == 0) goto L_0x0053
            goto L_0x0093
        L_0x0053:
            java.lang.String r14 = r13.getName()
            java.lang.String r15 = java.lang.String.valueOf(r19)
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x0078
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = f50242yn
            r12.append(r13)
            java.lang.String r13 = java.io.File.separator
            r12.append(r13)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            goto L_0x0090
        L_0x0078:
            long r14 = r13.lastModified()
            long r14 = r5 - r14
            r16 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x0090
            boolean r13 = r13.delete()
            if (r13 != 0) goto L_0x0090
            com.huawei.location.lite.common.log.LogConsole.d(r4, r7)
        L_0x0090:
            int r11 = r11 + 1
            goto L_0x0048
        L_0x0093:
            if (r12 != 0) goto L_0x0123
            java.lang.String r0 = "Get files from the StoreCache"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            com.huawei.location.tiles.store.dC r0 = r1.Vw
            java.lang.String r5 = java.lang.String.valueOf(r19)
            com.huawei.location.tiles.store.LW r0 = r0.FB(r5)
            int r5 = r0.yn()
            r6 = 2
            if (r5 != r6) goto L_0x00b1
            java.lang.String r0 = "tile downloading."
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            return r8
        L_0x00b1:
            int r5 = r0.yn()
            r6 = 3
            if (r5 != r6) goto L_0x00c0
            java.lang.String r0 = "tile not exists."
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            byte[] r0 = new byte[r9]
            return r0
        L_0x00c0:
            java.lang.String r0 = r0.Vw()
            java.io.File r5 = new java.io.File
            java.lang.String r8 = f50242yn
            r5.<init>(r8)
            java.io.File[] r5 = r5.listFiles()
            if (r5 == 0) goto L_0x00f2
            int r8 = r5.length
            r10 = 4
            if (r8 >= r10) goto L_0x00d6
            goto L_0x00f2
        L_0x00d6:
            com.huawei.location.tiles.cache.yn r8 = new com.huawei.location.tiles.cache.yn
            r8.<init>(r1)
            java.util.Arrays.sort(r5, r8)
            r8 = r9
        L_0x00df:
            int r10 = r5.length
            if (r8 >= r10) goto L_0x00f2
            if (r8 < r6) goto L_0x00ef
            r10 = r5[r8]
            boolean r10 = r10.delete()
            if (r10 != 0) goto L_0x00ef
            com.huawei.location.lite.common.log.LogConsole.d(r4, r7)
        L_0x00ef:
            int r8 = r8 + 1
            goto L_0x00df
        L_0x00f2:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = f50242yn
            r5.append(r6)
            java.lang.String r6 = java.io.File.separator
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = java.lang.String.valueOf(r19)
            boolean r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r0, (java.lang.String) r5, (java.lang.String) r6)
            if (r0 != 0) goto L_0x0114
            java.lang.String r0 = "Failed to unzip the file."
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
        L_0x0114:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r2)
            java.lang.String r12 = r0.toString()
        L_0x0123:
            com.huawei.location.tiles.store.dC r0 = r1.Vw
            com.huawei.location.tiles.utils.d2 r0 = r0.yn()
            double r5 = r0.f50265yn
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x017d
            double r10 = r0.Vw
            int r7 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x017d
            r7 = 15
            long r5 = com.huawei.location.activity.model.Vw.yn((double) r10, (double) r5, (int) r7)
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0147
            java.lang.String r0 = "no preloading is required."
            com.huawei.location.lite.common.log.LogConsole.d(r4, r0)
            goto L_0x0182
        L_0x0147:
            com.huawei.location.tiles.utils.zp r5 = new com.huawei.location.tiles.utils.zp
            java.lang.Long r2 = java.lang.Long.valueOf(r19)
            r5.<init>(r2, r0)
            java.lang.Long[] r0 = r5.yn()
            com.huawei.location.tiles.store.dC r2 = r1.Vw
            r2.getClass()
            int r3 = r0.length
            java.lang.String r5 = "TileStoreManager"
            if (r3 > 0) goto L_0x0164
            java.lang.String r0 = "tileIdList is empty"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            goto L_0x0182
        L_0x0164:
            java.lang.String r3 = "start preDownload Tile Zip File"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r3)
            int r3 = r0.length
            r5 = r9
        L_0x016b:
            if (r5 >= r3) goto L_0x0182
            r6 = r0[r5]
            long r6 = r6.longValue()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r2.FB(r6)
            int r5 = r5 + 1
            goto L_0x016b
        L_0x017d:
            java.lang.String r0 = "lat lon is null"
            com.huawei.location.lite.common.log.LogConsole.d(r4, r0)
        L_0x0182:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x01ad }
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x01ad }
            r0.<init>(r12)     // Catch:{ IOException -> 0x01ad }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01ad }
            int r0 = r2.available()     // Catch:{ all -> 0x019e }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x019e }
            int r3 = r2.read(r0)     // Catch:{ all -> 0x019e }
            if (r3 != 0) goto L_0x019a
            byte[] r0 = new byte[r9]     // Catch:{ all -> 0x019e }
        L_0x019a:
            r2.close()     // Catch:{ IOException -> 0x01ad }
            goto L_0x01b6
        L_0x019e:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r0 = move-exception
            r5 = r0
            r2.close()     // Catch:{ all -> 0x01a7 }
            goto L_0x01ac
        L_0x01a7:
            r0 = move-exception
            r2 = r0
            r3.addSuppressed(r2)     // Catch:{ IOException -> 0x01ad }
        L_0x01ac:
            throw r5     // Catch:{ IOException -> 0x01ad }
        L_0x01ad:
            java.lang.String r0 = "FileUtils"
            java.lang.String r2 = "getByteFrom IOException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r2)
            byte[] r0 = new byte[r9]
        L_0x01b6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "get tile byte length is: "
            r2.append(r3)
            int r3 = r0.length
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.cache.Vw.yn(long):byte[]");
    }
}
