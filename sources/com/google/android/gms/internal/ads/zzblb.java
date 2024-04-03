package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

public abstract class zzblb<T> {
    private final int zza;
    private final String zzb;
    private final T zzc;

    public /* synthetic */ zzblb(int i11, String str, Object obj, zzbla zzbla) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = obj;
        zzbgq.zza().zzd(this);
    }

    public static zzblb<Float> zzf(int i11, String str, float f11) {
        return new zzbky(1, str, Float.valueOf(f11));
    }

    public static zzblb<Integer> zzg(int i11, String str, int i12) {
        return new zzbkw(1, str, Integer.valueOf(i12));
    }

    public static zzblb<Long> zzh(int i11, String str, long j11) {
        return new zzbkx(1, str, Long.valueOf(j11));
    }

    public static zzblb<Boolean> zzi(int i11, String str, Boolean bool) {
        return new zzbkv(i11, str, bool);
    }

    public static zzblb<String> zzj(int i11, String str, String str2) {
        return new zzbkz(1, str, str2);
    }

    public static zzblb<String> zzk(int i11, String str) {
        zzblb<String> zzj = zzj(1, "gads:sdk_core_constants:experiment_id", (String) null);
        zzbgq.zza().zzc(zzj);
        return zzj;
    }

    public abstract T zza(JSONObject jSONObject);

    public abstract T zzb(Bundle bundle);

    public abstract T zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, T t11);

    public final int zze() {
        return this.zza;
    }

    public final T zzl() {
        return this.zzc;
    }

    public final String zzm() {
        return this.zzb;
    }
}
