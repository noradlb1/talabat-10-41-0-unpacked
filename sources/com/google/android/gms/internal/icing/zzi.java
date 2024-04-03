package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentIdCreator")
@SafeParcelable.Reserved({1000})
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @SafeParcelable.Field(id = 1)
    @Nullable
    final String zza;
    @SafeParcelable.Field(id = 2)
    @Nullable
    final String zzb;
    @SafeParcelable.Field(id = 3)
    @Nullable
    final String zzc;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
