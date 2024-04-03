package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StreetViewSourceCreator")
@SafeParcelable.Reserved({1})
public final class StreetViewSource extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzy();
    @NonNull
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    @NonNull
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);
    private static final String zza = "StreetViewSource";
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;

    @SafeParcelable.Constructor
    public StreetViewSource(@SafeParcelable.Param(id = 2) int i11) {
        this.zzb = i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StreetViewSource) && this.zzb == ((StreetViewSource) obj).zzb) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb));
    }

    @NonNull
    public String toString() {
        String str;
        int i11 = this.zzb;
        if (i11 == 0) {
            str = "DEFAULT";
        } else if (i11 != 1) {
            str = String.format("UNKNOWN(%s)", new Object[]{Integer.valueOf(i11)});
        } else {
            str = "OUTDOOR";
        }
        return String.format("StreetViewSource:%s", new Object[]{str});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int i12 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i12);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
