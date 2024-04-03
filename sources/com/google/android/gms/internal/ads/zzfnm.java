package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
public final class zzfnm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfnm> CREATOR = new zzfnn();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final byte[] zzb;

    @SafeParcelable.Constructor
    public zzfnm(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i11;
        this.zzb = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfnm(byte[] bArr) {
        this(1, bArr);
    }
}
