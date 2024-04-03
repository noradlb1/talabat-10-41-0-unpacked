package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

public final /* synthetic */ class zzdsu implements zzfpv {
    public final /* synthetic */ String zza;
    public final /* synthetic */ double zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdsu(String str, double d11, int i11, int i12) {
        this.zza = str;
        this.zzb = d11;
        this.zzc = i11;
        this.zzd = i12;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        return new zzbnu(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzb, this.zzc, this.zzd);
    }
}
