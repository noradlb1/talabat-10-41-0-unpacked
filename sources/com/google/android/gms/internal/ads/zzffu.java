package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
@ParametersAreNonnullByDefault
public final class zzffu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzffu> CREATOR = new zzffv();
    @Nullable
    public final Context zza;
    public final zzffr zzb;
    @SafeParcelable.Field(id = 2)
    public final int zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;
    @SafeParcelable.Field(id = 4)
    public final int zze;
    @SafeParcelable.Field(id = 5)
    public final String zzf;
    public final int zzg;
    private final zzffr[] zzh;
    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzi;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzj;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    @SafeParcelable.Constructor
    public zzffu(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) int i14, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i15, @SafeParcelable.Param(id = 7) int i16) {
        zzffr[] values = zzffr.values();
        this.zzh = values;
        int[] zza2 = zzffs.zza();
        this.zzl = zza2;
        int[] zza3 = zzfft.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i11;
        this.zzb = values[i11];
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = str;
        this.zzj = i15;
        this.zzg = zza2[i15];
        this.zzk = i16;
        int i17 = zza3[i16];
    }

    public static zzffu zza(zzffr zzffr, Context context) {
        if (zzffr == zzffr.Rewarded) {
            return new zzffu(context, zzffr, ((Integer) zzbgq.zzc().zzb(zzblj.zzeO)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzeU)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzeW)).intValue(), (String) zzbgq.zzc().zzb(zzblj.zzeY), (String) zzbgq.zzc().zzb(zzblj.zzeQ), (String) zzbgq.zzc().zzb(zzblj.zzeS));
        } else if (zzffr == zzffr.Interstitial) {
            return new zzffu(context, zzffr, ((Integer) zzbgq.zzc().zzb(zzblj.zzeP)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzeV)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzeX)).intValue(), (String) zzbgq.zzc().zzb(zzblj.zzeZ), (String) zzbgq.zzc().zzb(zzblj.zzeR), (String) zzbgq.zzc().zzb(zzblj.zzeT));
        } else if (zzffr != zzffr.AppOpen) {
            return null;
        } else {
            return new zzffu(context, zzffr, ((Integer) zzbgq.zzc().zzb(zzblj.zzfc)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzfe)).intValue(), ((Integer) zzbgq.zzc().zzb(zzblj.zzff)).intValue(), (String) zzbgq.zzc().zzb(zzblj.zzfa), (String) zzbgq.zzc().zzb(zzblj.zzfb), (String) zzbgq.zzc().zzb(zzblj.zzfd));
        }
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzffu(@Nullable Context context, zzffr zzffr, int i11, int i12, int i13, String str, String str2, String str3) {
        int i14;
        this.zzh = zzffr.values();
        this.zzl = zzffs.zza();
        this.zzm = zzfft.zza();
        this.zza = context;
        this.zzi = zzffr.ordinal();
        this.zzb = zzffr;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i14 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i14 = 3;
        } else {
            i14 = 2;
        }
        this.zzg = i14;
        this.zzj = i14 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
