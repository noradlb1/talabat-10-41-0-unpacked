package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(id = 2)
    public final boolean zza;
    @SafeParcelable.Field(id = 3)
    public final boolean zzb;
    @SafeParcelable.Field(id = 4)
    public final String zzc;
    @SafeParcelable.Field(id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(id = 6)
    public final float zze;
    @SafeParcelable.Field(id = 7)
    public final int zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) boolean z12, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z13, @SafeParcelable.Param(id = 6) float f11, @SafeParcelable.Param(id = 7) int i11, @SafeParcelable.Param(id = 8) boolean z14, @SafeParcelable.Param(id = 9) boolean z15, @SafeParcelable.Param(id = 10) boolean z16) {
        this.zza = z11;
        this.zzb = z12;
        this.zzc = str;
        this.zzd = z13;
        this.zze = f11;
        this.zzf = i11;
        this.zzg = z14;
        this.zzh = z15;
        this.zzi = z16;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeFloat(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzj(boolean z11, boolean z12, boolean z13, float f11, int i11, boolean z14, boolean z15, boolean z16) {
        this(z11, z12, (String) null, z13, f11, -1, z14, z15, z16);
    }
}
