package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    @SafeParcelable.Field(getter = "getStartHour", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getStartMinute", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getEndHour", id = 3)
    private final int zzc;
    @SafeParcelable.Field(getter = "getEndMinute", id = 4)
    private final int zzd;

    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) int i14) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = true;
        if (i11 < 0 || i11 > 23) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkState(z11, "Start hour must be in range [0, 23].");
        if (i12 < 0 || i12 > 59) {
            z12 = false;
        } else {
            z12 = true;
        }
        Preconditions.checkState(z12, "Start minute must be in range [0, 59].");
        if (i13 < 0 || i13 > 23) {
            z13 = false;
        } else {
            z13 = true;
        }
        Preconditions.checkState(z13, "End hour must be in range [0, 23].");
        if (i14 < 0 || i14 > 59) {
            z14 = false;
        } else {
            z14 = true;
        }
        Preconditions.checkState(z14, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i11 + i12) + i13) + i14 <= 0 ? false : z15, "Parameters can't be all 0.");
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzaj = (zzaj) obj;
        if (this.zza == zzaj.zza && this.zzb == zzaj.zzb && this.zzc == zzaj.zzc && this.zzd == zzaj.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        int i13 = this.zzc;
        int i14 = this.zzd;
        return "UserPreferredSleepWindow [startHour=" + i11 + ", startMinute=" + i12 + ", endHour=" + i13 + ", endMinute=" + i14 + "]";
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
