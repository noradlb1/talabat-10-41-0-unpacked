package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzbk {
    final String zzgk;
    final Uri zzgl;
    final String zzgm;
    final String zzgn;
    final boolean zzgo;
    final boolean zzgp;
    final boolean zzgq;
    final boolean zzgr;
    @Nullable
    final zzcl<Context, Boolean> zzgs;

    public zzbk(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzcl<Context, Boolean>) null);
    }

    public final zzbe<Boolean> zza(String str, boolean z11) {
        return zzbe.zza(this, str, z11);
    }

    public final zzbk zzf(String str) {
        boolean z11 = this.zzgo;
        if (!z11) {
            return new zzbk(this.zzgk, this.zzgl, str, this.zzgn, z11, this.zzgp, this.zzgq, this.zzgr, this.zzgs);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    private zzbk(String str, Uri uri, String str2, String str3, boolean z11, boolean z12, boolean z13, boolean z14, @Nullable zzcl<Context, Boolean> zzcl) {
        this.zzgk = str;
        this.zzgl = uri;
        this.zzgm = str2;
        this.zzgn = str3;
        this.zzgo = z11;
        this.zzgp = z12;
        this.zzgq = z13;
        this.zzgr = z14;
        this.zzgs = zzcl;
    }

    public final <T> zzbe<T> zza(String str, T t11, zzbh<T> zzbh) {
        return zzbe.zza(this, str, t11, zzbh);
    }
}
