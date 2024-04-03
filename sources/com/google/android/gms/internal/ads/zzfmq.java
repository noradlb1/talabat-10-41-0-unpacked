package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzfmq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting
    protected final zzfno zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue<zzfoa> zzd;
    private final HandlerThread zze;
    private final zzfmh zzf;
    private final long zzg = System.currentTimeMillis();
    private final int zzh;

    public zzfmq(Context context, int i11, int i12, String str, String str2, String str3, zzfmh zzfmh) {
        this.zzb = str;
        this.zzh = i12;
        this.zzc = str2;
        this.zzf = zzfmh;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfno zzfno = new zzfno(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfno;
        this.zzd = new LinkedBlockingQueue<>();
        zzfno.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static zzfoa zza() {
        return new zzfoa((byte[]) null, 1);
    }

    private final void zze(int i11, long j11, Exception exc) {
        this.zzf.zzc(i11, System.currentTimeMillis() - j11, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfnt zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzfoa zzf2 = zzd2.zzf(new zzfny(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, (Exception) null);
                this.zzd.put(zzf2);
            } catch (Throwable th2) {
                zzc();
                this.zze.quit();
                throw th2;
            }
            zzc();
            this.zze.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i11) {
        try {
            zze(4011, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfoa zzb(int i11) {
        zzfoa zzfoa;
        try {
            zzfoa = this.zzd.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            zze(2009, this.zzg, e11);
            zzfoa = null;
        }
        zze(3004, this.zzg, (Exception) null);
        if (zzfoa != null) {
            if (zzfoa.zzc == 7) {
                zzfmh.zzg(3);
            } else {
                zzfmh.zzg(2);
            }
        }
        if (zzfoa == null) {
            return zza();
        }
        return zzfoa;
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
