package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.ArrayList;
import java.util.List;

public final class zzfef {
    @Nullable
    public final zzbkq zza;
    @Nullable
    public final zzbtz zzb;
    @Nullable
    public final zzeox zzc;
    public final zzbfd zzd;
    public final zzbfi zze;
    public final String zzf;
    public final ArrayList<String> zzg;
    public final ArrayList<String> zzh;
    public final zzbnw zzi;
    public final zzbfo zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzbhr zzn;
    public final zzfdv zzo;
    public final boolean zzp;
    @Nullable
    public final zzbhv zzq;

    public /* synthetic */ zzfef(zzfed zzfed, zzfee zzfee) {
        zzbkq zzbkq;
        zzbnw zzbnw;
        this.zze = zzfed.zzb;
        this.zzf = zzfed.zzc;
        this.zzq = zzfed.zzr;
        int i11 = zzfed.zza.zza;
        long j11 = zzfed.zza.zzb;
        Bundle bundle = zzfed.zza.zzc;
        int i12 = zzfed.zza.zzd;
        List<String> list = zzfed.zza.zze;
        boolean z11 = zzfed.zza.zzf;
        int i13 = zzfed.zza.zzg;
        boolean z12 = true;
        if (!zzfed.zza.zzh && !zzfed.zze) {
            z12 = false;
        }
        this.zzd = new zzbfd(i11, j11, bundle, i12, list, z11, i13, z12, zzfed.zza.zzi, zzfed.zza.zzj, zzfed.zza.zzk, zzfed.zza.zzl, zzfed.zza.zzm, zzfed.zza.zzn, zzfed.zza.zzo, zzfed.zza.zzp, zzfed.zza.zzq, zzfed.zza.zzr, zzfed.zza.zzs, zzfed.zza.zzt, zzfed.zza.zzu, zzfed.zza.zzv, zzt.zza(zzfed.zza.zzw), zzfed.zza.zzx);
        if (zzfed.zzd != null) {
            zzbkq = zzfed.zzd;
        } else if (zzfed.zzh != null) {
            zzbkq = zzfed.zzh.zzf;
        } else {
            zzbkq = null;
        }
        this.zza = zzbkq;
        this.zzg = zzfed.zzf;
        this.zzh = zzfed.zzg;
        if (zzfed.zzf == null) {
            zzbnw = null;
        } else if (zzfed.zzh == null) {
            zzbnw = new zzbnw(new NativeAdOptions.Builder().build());
        } else {
            zzbnw = zzfed.zzh;
        }
        this.zzi = zzbnw;
        this.zzj = zzfed.zzi;
        this.zzk = zzfed.zzm;
        this.zzl = zzfed.zzj;
        this.zzm = zzfed.zzk;
        this.zzn = zzfed.zzl;
        this.zzb = zzfed.zzn;
        this.zzo = new zzfdv(zzfed.zzo, (zzfdu) null);
        this.zzp = zzfed.zzp;
        this.zzc = zzfed.zzq;
    }

    public final zzbpz zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }
}
