package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MutateRequestCreator")
@SafeParcelable.Reserved({4})
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    @Nullable
    public final Thing[] zzb;
    @SafeParcelable.Field(id = 3)
    @Nullable
    public final String[] zzc;
    @SafeParcelable.Field(id = 5)
    @Nullable
    public final String[] zzd;
    @SafeParcelable.Field(id = 6)
    @Nullable
    public final zzc zze;
    @SafeParcelable.Field(id = 7)
    @Nullable
    public final String zzf;
    @SafeParcelable.Field(id = 8)
    @Nullable
    public final String zzg;

    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) @Nullable Thing[] thingArr, @SafeParcelable.Param(id = 3) @Nullable String[] strArr, @SafeParcelable.Param(id = 5) @Nullable String[] strArr2, @SafeParcelable.Param(id = 6) @Nullable zzc zzc2, @SafeParcelable.Param(id = 7) @Nullable String str, @SafeParcelable.Param(id = 8) @Nullable String str2) {
        if (!(i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 6 || i11 == 7)) {
            i11 = 0;
        }
        this.zza = i11;
        this.zzb = thingArr;
        this.zzc = strArr;
        this.zzd = strArr2;
        this.zze = zzc2;
        this.zzf = str;
        this.zzg = str2;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i11, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i11, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
