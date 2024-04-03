package com.instabug.library.util;

import com.instabug.library.util.BitmapUtils;
import java.io.File;

class c implements BitmapUtils.OnBitmapReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f52055a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BitmapUtils.d f52056b;

    public c(BitmapUtils.d dVar, File file) {
        this.f52056b = dVar;
        this.f52055a = file;
    }

    public void onBitmapFailedToLoad() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[SYNTHETIC, Splitter:B:31:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBitmapReady(@androidx.annotation.Nullable android.graphics.Bitmap r7) {
        /*
            r6 = this;
            java.lang.String r0 = "can't close BufferedOutputStream"
            java.lang.String r1 = "IBG-Core"
            if (r7 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0026 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0026 }
            java.io.File r5 = r6.f52055a     // Catch:{ IOException -> 0x0026 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0026 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0026 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            r4 = 100
            boolean r7 = com.instabug.library.util.BitmapUtils.compressQuietly(r7, r2, r4, r3)     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            r3.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0035
        L_0x0020:
            r7 = move-exception
            goto L_0x0057
        L_0x0022:
            r2 = r3
            goto L_0x0026
        L_0x0024:
            r7 = move-exception
            goto L_0x0056
        L_0x0026:
            java.lang.String r7 = "can't compress bitmap"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r7)     // Catch:{ all -> 0x0024 }
            r7 = 0
            if (r2 == 0) goto L_0x0035
            r2.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0035
        L_0x0032:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x0035:
            java.io.File r0 = r6.f52055a
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            if (r7 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x0047
            com.instabug.library.util.BitmapUtils$d r7 = r6.f52056b
            com.instabug.library.util.BitmapUtils$OnSaveBitmapCallback r7 = r7.f52031d
            r7.onSuccess(r0)
            goto L_0x0055
        L_0x0047:
            com.instabug.library.util.BitmapUtils$d r7 = r6.f52056b
            com.instabug.library.util.BitmapUtils$OnSaveBitmapCallback r7 = r7.f52031d
            java.lang.Throwable r0 = new java.lang.Throwable
            java.lang.String r1 = "Uri equal null"
            r0.<init>(r1)
            r7.onError(r0)
        L_0x0055:
            return
        L_0x0056:
            r3 = r2
        L_0x0057:
            if (r3 == 0) goto L_0x0060
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0060
        L_0x005d:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x0060:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.c.onBitmapReady(android.graphics.Bitmap):void");
    }
}
