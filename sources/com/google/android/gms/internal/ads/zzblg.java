package com.google.android.gms.internal.ads;

final class zzblg implements zzbnl {
    final /* synthetic */ zzblh zza;

    public zzblg(zzblh zzblh) {
        this.zza = zzblh;
    }

    public final Boolean zza(String str, boolean z11) {
        return Boolean.valueOf(this.zza.zze.getBoolean(str, z11));
    }

    public final Double zzb(String str, double d11) {
        return Double.valueOf((double) this.zza.zze.getFloat(str, (float) d11));
    }

    public final Long zzc(String str, long j11) {
        try {
            return Long.valueOf(this.zza.zze.getLong(str, j11));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zza.zze.getInt(str, (int) j11));
        }
    }

    public final String zzd(String str, String str2) {
        return this.zza.zze.getString(str, str2);
    }
}
