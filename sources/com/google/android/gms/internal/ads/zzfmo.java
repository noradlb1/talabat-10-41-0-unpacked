package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzfmo implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting
    protected final zzfno zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue<zzajp> zzd = new LinkedBlockingQueue<>();
    private final HandlerThread zze;

    public zzfmo(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfno zzfno = new zzfno(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzfno;
        zzfno.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static zzajp zza() {
        zzaiz zza2 = zzajp.zza();
        zza2.zzz(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return (zzajp) zza2.zzah();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        zzc();
        r3.zze.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zzd.put(zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzfnt r4 = r3.zzd()
            if (r4 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzfnp r0 = new com.google.android.gms.internal.ads.zzfnp     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.zzb     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.zzc     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzfnr r4 = r4.zze(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzajp r4 = r4.zza()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzajp> r0 = r3.zzd     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
        L_0x001c:
            r3.zzc()
            android.os.HandlerThread r4 = r3.zze
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzajp> r4 = r3.zzd     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            com.google.android.gms.internal.ads.zzajp r0 = zza()     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            goto L_0x001c
        L_0x002f:
            r4 = move-exception
            r3.zzc()
            android.os.HandlerThread r0 = r3.zze
            r0.quit()
            throw r4
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmo.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i11) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzajp zzb(int i11) {
        zzajp zzajp;
        try {
            zzajp = this.zzd.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzajp = null;
        }
        if (zzajp == null) {
            return zza();
        }
        return zzajp;
    }

    public final void zzc() {
        zzfno zzfno = this.zza;
        if (zzfno == null) {
            return;
        }
        if (zzfno.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    public final zzfnt zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
