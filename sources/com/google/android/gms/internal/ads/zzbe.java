package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzbe {
    public static final zzbe zza = new zzbe(new zzbc());
    public static final zzj<zzbe> zzb = zzba.zza;
    @Nullable
    public final CharSequence zzc;
    @Nullable
    public final CharSequence zzd;
    @Nullable
    public final CharSequence zze;
    @Nullable
    public final CharSequence zzf;
    @Nullable
    public final CharSequence zzg;
    @Nullable
    public final byte[] zzh;
    @Nullable
    public final Integer zzi;
    @Nullable
    public final Integer zzj;
    @Nullable
    public final Integer zzk;
    @Deprecated
    @Nullable
    public final Integer zzl;
    @Nullable
    public final Integer zzm;
    @Nullable
    public final Integer zzn;
    @Nullable
    public final Integer zzo;
    @Nullable
    public final Integer zzp;
    @Nullable
    public final Integer zzq;
    @Nullable
    public final Integer zzr;
    @Nullable
    public final CharSequence zzs;
    @Nullable
    public final CharSequence zzt;
    @Nullable
    public final CharSequence zzu;

    private zzbe(zzbc zzbc) {
        this.zzc = zzbc.zza;
        this.zzd = zzbc.zzb;
        this.zze = zzbc.zzc;
        this.zzf = zzbc.zzd;
        this.zzg = zzbc.zze;
        this.zzh = zzbc.zzf;
        this.zzi = zzbc.zzg;
        this.zzj = zzbc.zzh;
        this.zzk = zzbc.zzi;
        this.zzl = zzbc.zzj;
        this.zzm = zzbc.zzj;
        this.zzn = zzbc.zzk;
        this.zzo = zzbc.zzl;
        this.zzp = zzbc.zzm;
        this.zzq = zzbc.zzn;
        this.zzr = zzbc.zzo;
        this.zzs = zzbc.zzp;
        this.zzt = zzbc.zzq;
        this.zzu = zzbc.zzr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbe.class == obj.getClass()) {
            zzbe zzbe = (zzbe) obj;
            if (!zzfn.zzP(this.zzc, zzbe.zzc) || !zzfn.zzP(this.zzd, zzbe.zzd) || !zzfn.zzP(this.zze, zzbe.zze) || !zzfn.zzP(this.zzf, zzbe.zzf) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP(this.zzg, zzbe.zzg) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !Arrays.equals(this.zzh, zzbe.zzh) || !zzfn.zzP(this.zzi, zzbe.zzi) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP(this.zzj, zzbe.zzj) || !zzfn.zzP(this.zzk, zzbe.zzk) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP(this.zzm, zzbe.zzm) || !zzfn.zzP(this.zzn, zzbe.zzn) || !zzfn.zzP(this.zzo, zzbe.zzo) || !zzfn.zzP(this.zzp, zzbe.zzp) || !zzfn.zzP(this.zzq, zzbe.zzq) || !zzfn.zzP(this.zzr, zzbe.zzr) || !zzfn.zzP(this.zzs, zzbe.zzs) || !zzfn.zzP(this.zzt, zzbe.zzt) || !zzfn.zzP(this.zzu, zzbe.zzu) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzc, this.zzd, this.zze, this.zzf, null, null, this.zzg, null, null, null, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, null, this.zzj, this.zzk, null, null, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, null, null, null, null});
    }

    public final zzbc zza() {
        return new zzbc(this, (zzbb) null);
    }
}
