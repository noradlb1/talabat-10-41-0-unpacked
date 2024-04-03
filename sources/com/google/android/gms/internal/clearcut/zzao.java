package com.google.android.gms.internal.clearcut;

import android.net.Uri;

public final class zzao {
    /* access modifiers changed from: private */
    public final String zzef;
    /* access modifiers changed from: private */
    public final Uri zzeg;
    /* access modifiers changed from: private */
    public final String zzeh;
    /* access modifiers changed from: private */
    public final String zzei;
    /* access modifiers changed from: private */
    public final boolean zzej;
    /* access modifiers changed from: private */
    public final boolean zzek;

    public zzao(Uri uri) {
        this((String) null, uri, "", "", false, false);
    }

    private zzao(String str, Uri uri, String str2, String str3, boolean z11, boolean z12) {
        this.zzef = str;
        this.zzeg = uri;
        this.zzeh = str2;
        this.zzei = str3;
        this.zzej = z11;
        this.zzek = z12;
    }

    public final <T> zzae<T> zza(String str, T t11, zzan<T> zzan) {
        return zzae.zza(this, str, t11, zzan);
    }

    public final zzae<String> zza(String str, String str2) {
        return zzae.zza(this, str, (String) null);
    }

    public final zzae<Boolean> zzc(String str, boolean z11) {
        return zzae.zza(this, str, false);
    }

    public final zzao zzc(String str) {
        boolean z11 = this.zzej;
        if (!z11) {
            return new zzao(this.zzef, this.zzeg, str, this.zzei, z11, this.zzek);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzao zzd(String str) {
        return new zzao(this.zzef, this.zzeg, this.zzeh, str, this.zzej, this.zzek);
    }
}
