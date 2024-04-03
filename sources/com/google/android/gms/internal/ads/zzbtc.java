package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
public final class zzbtc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbtc> CREATOR = new zzbtd();
    @SafeParcelable.Field(id = 1)
    public final boolean zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;
    @SafeParcelable.Field(id = 4)
    public final byte[] zzd;
    @SafeParcelable.Field(id = 5)
    public final String[] zze;
    @SafeParcelable.Field(id = 6)
    public final String[] zzf;
    @SafeParcelable.Field(id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(id = 8)
    public final long zzh;

    @SafeParcelable.Constructor
    public zzbtc(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z12, @SafeParcelable.Param(id = 8) long j11) {
        this.zza = z11;
        this.zzb = str;
        this.zzc = i11;
        this.zzd = bArr;
        this.zze = strArr;
        this.zzf = strArr2;
        this.zzg = z12;
        this.zzh = j11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
