package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfg {
    final String zza;
    final /* synthetic */ zzfi zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzfg(zzfi zzfi, String str, long j11, zzff zzff) {
        boolean z11;
        this.zzb = zzfi;
        Preconditions.checkNotEmpty("health_monitor");
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j11;
    }

    @WorkerThread
    private final long zzc() {
        return this.zzb.zza().getLong(this.zza, 0);
    }

    @WorkerThread
    private final void zzd() {
        this.zzb.zzg();
        long currentTimeMillis = this.zzb.zzt.zzax().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzb.zza().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final Pair zza() {
        long j11;
        this.zzb.zzg();
        this.zzb.zzg();
        long zzc2 = zzc();
        if (zzc2 == 0) {
            zzd();
            j11 = 0;
        } else {
            j11 = Math.abs(zzc2 - this.zzb.zzt.zzax().currentTimeMillis());
        }
        long j12 = this.zze;
        if (j11 < j12) {
            return null;
        }
        if (j11 > j12 + j12) {
            zzd();
            return null;
        }
        String string = this.zzb.zza().getString(this.zzd, (String) null);
        long j13 = this.zzb.zza().getLong(this.zzc, 0);
        zzd();
        if (string == null || j13 <= 0) {
            return zzfi.zza;
        }
        return new Pair(string, Long.valueOf(j13));
    }

    @WorkerThread
    public final void zzb(String str, long j11) {
        this.zzb.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        long j12 = this.zzb.zza().getLong(this.zzc, 0);
        if (j12 <= 0) {
            SharedPreferences.Editor edit = this.zzb.zza().edit();
            edit.putString(this.zzd, str);
            edit.putLong(this.zzc, 1);
            edit.apply();
            return;
        }
        long j13 = j12 + 1;
        SharedPreferences.Editor edit2 = this.zzb.zza().edit();
        if ((this.zzb.zzt.zzv().zzG().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j13) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(this.zzc, j13);
        edit2.apply();
    }
}
