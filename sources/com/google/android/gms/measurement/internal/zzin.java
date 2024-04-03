package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.net.URL;
import java.util.Map;

@Instrumented
@WorkerThread
final class zzin implements Runnable {
    final /* synthetic */ zzio zza;
    private final URL zzb;
    private final String zzc;
    private final zzgb zzd;

    public zzin(zzio zzio, String str, URL url, byte[] bArr, Map map, zzgb zzgb) {
        this.zza = zzio;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgb);
        this.zzb = url;
        this.zzd = zzgb;
        this.zzc = str;
    }

    private final void zzb(int i11, Exception exc, byte[] bArr, Map map) {
        this.zza.zzt.zzaB().zzp(new zzim(this, i11, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[SYNTHETIC, Splitter:B:26:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzio r0 = r10.zza
            r0.zzaz()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzio r2 = r10.zza     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            java.net.URL r3 = r10.zzb     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            java.net.URLConnection r3 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r3)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            if (r4 == 0) goto L_0x0080
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r3.setDefaultUseCaches(r0)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            com.google.android.gms.measurement.internal.zzgd r4 = r2.zzt     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r4.zzf()     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r2.zzf()     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r2 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r3.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            r2 = 1
            r3.setDoInput(r2)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            int r2 = r3.getResponseCode()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.util.Map r4 = r3.getHeaderFields()     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0068 }
            r5.<init>()     // Catch:{ all -> 0x0068 }
            java.io.InputStream r6 = r3.getInputStream()     // Catch:{ all -> 0x0068 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0066 }
        L_0x004e:
            int r8 = r6.read(r7)     // Catch:{ all -> 0x0066 }
            if (r8 <= 0) goto L_0x0058
            r5.write(r7, r0, r8)     // Catch:{ all -> 0x0066 }
            goto L_0x004e
        L_0x0058:
            byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x0066 }
            r6.close()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
            r3.disconnect()
            r10.zzb(r2, r1, r0, r4)
            return
        L_0x0066:
            r0 = move-exception
            goto L_0x006a
        L_0x0068:
            r0 = move-exception
            r6 = r1
        L_0x006a:
            if (r6 == 0) goto L_0x006f
            r6.close()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x006f:
            throw r0     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x0070:
            r0 = move-exception
            goto L_0x008e
        L_0x0072:
            r0 = move-exception
            goto L_0x009d
        L_0x0074:
            r0 = move-exception
            r4 = r1
            goto L_0x008e
        L_0x0077:
            r0 = move-exception
            r4 = r1
            goto L_0x009d
        L_0x007a:
            r2 = move-exception
            r4 = r1
            goto L_0x008b
        L_0x007d:
            r2 = move-exception
            r4 = r1
            goto L_0x009a
        L_0x0080:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
            throw r2     // Catch:{ IOException -> 0x0097, all -> 0x0088 }
        L_0x0088:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x008b:
            r9 = r2
            r2 = r0
            r0 = r9
        L_0x008e:
            if (r3 == 0) goto L_0x0093
            r3.disconnect()
        L_0x0093:
            r10.zzb(r2, r1, r1, r4)
            throw r0
        L_0x0097:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x009a:
            r9 = r2
            r2 = r0
            r0 = r9
        L_0x009d:
            if (r3 == 0) goto L_0x00a2
            r3.disconnect()
        L_0x00a2:
            r10.zzb(r2, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.run():void");
    }

    public final /* synthetic */ void zza(int i11, Exception exc, byte[] bArr, Map map) {
        zzgb zzgb = this.zzd;
        zzgb.zza.zzC(this.zzc, i11, exc, bArr, map);
    }
}
