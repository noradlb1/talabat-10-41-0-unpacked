package com.huawei.hms.maps.model;

import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final int f49569a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49570b;

    public UrlTileProvider(int i11, int i12) {
        this.f49570b = i11;
        this.f49569a = i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007c A[SYNTHETIC, Splitter:B:33:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0099 A[SYNTHETIC, Splitter:B:38:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9 A[SYNTHETIC, Splitter:B:47:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6 A[SYNTHETIC, Splitter:B:52:0x00d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.huawei.hms.maps.model.Tile getTile(int r9, int r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Output stream close IOException"
            java.lang.String r1 = "Input stream close IOException"
            java.lang.String r2 = "UrlTileProvider"
            java.net.URL r9 = r8.getTileUrl(r9, r10, r11)
            if (r9 != 0) goto L_0x000f
            com.huawei.hms.maps.model.Tile r9 = com.huawei.hms.maps.model.TileProvider.NO_TILE
            return r9
        L_0x000f:
            r10 = 0
            java.io.InputStream r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r9)     // Catch:{ IOException -> 0x00b5, all -> 0x0076 }
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0074, all -> 0x006f }
            r11.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x006f }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
        L_0x001d:
            int r4 = r9.read(r3)     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            r5 = -1
            if (r4 == r5) goto L_0x0029
            r5 = 0
            r11.write(r3, r5, r4)     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            goto L_0x001d
        L_0x0029:
            com.huawei.hms.maps.model.Tile r3 = new com.huawei.hms.maps.model.Tile     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            int r4 = r8.f49570b     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            int r5 = r8.f49569a     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            byte[] r6 = r11.toByteArray()     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            r3.<init>(r4, r5, r6)     // Catch:{ IOException -> 0x00b7, all -> 0x006d }
            r9.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0051
        L_0x003a:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x0051:
            r11.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x006c
        L_0x0055:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x006c:
            return r3
        L_0x006d:
            r10 = move-exception
            goto L_0x007a
        L_0x006f:
            r11 = move-exception
            r7 = r11
            r11 = r10
            r10 = r7
            goto L_0x007a
        L_0x0074:
            r11 = r10
            goto L_0x00b7
        L_0x0076:
            r9 = move-exception
            r11 = r10
            r10 = r9
            r9 = r11
        L_0x007a:
            if (r9 == 0) goto L_0x0097
            r9.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0097
        L_0x0080:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x0097:
            if (r11 == 0) goto L_0x00b4
            r11.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00b4
        L_0x009d:
            r9 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            java.lang.String r9 = r9.getMessage()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x00b4:
            throw r10
        L_0x00b5:
            r9 = r10
            r11 = r9
        L_0x00b7:
            if (r9 == 0) goto L_0x00d4
            r9.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00d4
        L_0x00bd:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x00d4:
            if (r11 == 0) goto L_0x00f1
            r11.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00f1
        L_0x00da:
            r9 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            java.lang.String r9 = r9.getMessage()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.huawei.hms.maps.utils.LogM.e(r2, r9)
        L_0x00f1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.maps.model.UrlTileProvider.getTile(int, int, int):com.huawei.hms.maps.model.Tile");
    }

    public abstract URL getTileUrl(int i11, int i12, int i13);
}
