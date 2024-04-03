package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public final /* synthetic */ class zzfex implements Runnable {
    public final /* synthetic */ InputStream zza;
    public final /* synthetic */ ParcelFileDescriptor zzb;

    public /* synthetic */ zzfex(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = inputStream;
        this.zzb = parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0011, B:19:0x0020] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0019 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.io.InputStream r0 = r3.zza
            android.os.ParcelFileDescriptor r1 = r3.zzb
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r2 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ all -> 0x001a }
            r2.<init>(r1)     // Catch:{ all -> 0x001a }
            com.google.android.gms.common.util.IOUtils.copyStream(r0, r2)     // Catch:{ all -> 0x0015 }
            r2.close()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0014
            r0.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0014:
            return
        L_0x0015:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x0019 }
        L_0x0019:
            throw r1     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            if (r0 == 0) goto L_0x0020
            r0.close()     // Catch:{ all -> 0x0020 }
        L_0x0020:
            throw r1     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfex.run():void");
    }
}
