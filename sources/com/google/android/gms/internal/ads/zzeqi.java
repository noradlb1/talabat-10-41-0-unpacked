package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzeqi implements zzevm<Bundle> {
    public final zzbfi zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzeqi(zzbfi zzbfi, String str, boolean z11, String str2, float f11, int i11, int i12, String str3, boolean z12) {
        Preconditions.checkNotNull(zzbfi, "the adSize must not be null");
        this.zza = zzbfi;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = str2;
        this.zze = f11;
        this.zzf = i11;
        this.zzg = i12;
        this.zzh = str3;
        this.zzi = z12;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        boolean z11;
        boolean z12;
        Bundle bundle = (Bundle) obj;
        if (this.zza.zze == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfeq.zzg(bundle, "smart_w", "full", z11);
        if (this.zza.zzb == -2) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzfeq.zzg(bundle, "smart_h", "auto", z12);
        Boolean bool = Boolean.TRUE;
        zzfeq.zze(bundle, "ene", bool, this.zza.zzj);
        zzfeq.zzg(bundle, "rafmt", "102", this.zza.zzm);
        zzfeq.zzg(bundle, "rafmt", "103", this.zza.zzn);
        zzfeq.zzg(bundle, "rafmt", "105", this.zza.zzo);
        zzfeq.zze(bundle, "inline_adaptive_slot", bool, this.zzi);
        zzfeq.zze(bundle, "interscroller_slot", bool, this.zza.zzo);
        zzfeq.zzc(bundle, "format", this.zzb);
        zzfeq.zzg(bundle, "fluid", "height", this.zzc);
        String str = this.zzd;
        zzfeq.zzg(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        String str2 = this.zzh;
        zzfeq.zzg(bundle, "sc", str2, !TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzbfi[] zzbfiArr = this.zza.zzg;
        if (zzbfiArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (zzbfi zzbfi : zzbfiArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzbfi.zzi);
                bundle3.putInt("height", zzbfi.zzb);
                bundle3.putInt("width", zzbfi.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
