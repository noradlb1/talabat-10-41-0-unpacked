package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

public final class zzbc {
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zza;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzb;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzc;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzd;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zze;
    /* access modifiers changed from: private */
    @Nullable
    public byte[] zzf;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzg;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzh;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzi;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzj;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzk;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzl;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzm;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzn;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzo;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzp;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzq;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence zzr;

    public zzbc() {
    }

    public /* synthetic */ zzbc(zzbe zzbe, zzbb zzbb) {
        this.zza = zzbe.zzc;
        this.zzb = zzbe.zzd;
        this.zzc = zzbe.zze;
        this.zzd = zzbe.zzf;
        this.zze = zzbe.zzg;
        this.zzf = zzbe.zzh;
        this.zzg = zzbe.zzi;
        this.zzh = zzbe.zzj;
        this.zzi = zzbe.zzk;
        this.zzj = zzbe.zzm;
        this.zzk = zzbe.zzn;
        this.zzl = zzbe.zzo;
        this.zzm = zzbe.zzp;
        this.zzn = zzbe.zzq;
        this.zzo = zzbe.zzr;
        this.zzp = zzbe.zzs;
        this.zzq = zzbe.zzt;
        this.zzr = zzbe.zzu;
    }

    public final zzbc zza(byte[] bArr, int i11) {
        if (this.zzf == null || zzfn.zzP(Integer.valueOf(i11), 3) || !zzfn.zzP(this.zzg, 3)) {
            this.zzf = (byte[]) bArr.clone();
            this.zzg = Integer.valueOf(i11);
        }
        return this;
    }

    public final zzbc zzb(@Nullable CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzbc zzc(@Nullable CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzbc zzd(@Nullable CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzbc zze(@Nullable CharSequence charSequence) {
        this.zzq = charSequence;
        return this;
    }

    public final zzbc zzf(@Nullable CharSequence charSequence) {
        this.zzr = charSequence;
        return this;
    }

    public final zzbc zzg(@Nullable CharSequence charSequence) {
        this.zze = charSequence;
        return this;
    }

    public final zzbc zzh(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzl = num;
        return this;
    }

    public final zzbc zzi(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzbc zzj(@Nullable Integer num) {
        this.zzj = num;
        return this;
    }

    public final zzbc zzk(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzo = num;
        return this;
    }

    public final zzbc zzl(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzn = num;
        return this;
    }

    public final zzbc zzm(@Nullable Integer num) {
        this.zzm = num;
        return this;
    }

    public final zzbc zzn(@Nullable CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzbc zzo(@Nullable Integer num) {
        this.zzi = num;
        return this;
    }

    public final zzbc zzp(@Nullable Integer num) {
        this.zzh = num;
        return this;
    }

    public final zzbc zzq(@Nullable CharSequence charSequence) {
        this.zzp = charSequence;
        return this;
    }

    public final zzbe zzr() {
        return new zzbe(this);
    }
}
