package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzw();
    @NonNull
    public static final LocationAvailability zza = new LocationAvailability(0, 1, 1, 0, (zzac[]) null, true);
    @NonNull
    public static final LocationAvailability zzb = new LocationAvailability(1000, 1, 1, 0, (zzac[]) null, false);
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNSUCCESSFUL", id = 4)
    int zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getCellStatus", id = 1)
    private final int zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getWifiStatus", id = 2)
    private final int zze;
    @SafeParcelable.Field(defaultValueUnchecked = "0", getter = "getElapsedRealtimeNs", id = 3)
    private final long zzf;
    @SafeParcelable.Field(getter = "getBatchedStatus", id = 5)
    private final zzac[] zzg;

    @SafeParcelable.Constructor
    public LocationAvailability(@SafeParcelable.Param(id = 4) int i11, @SafeParcelable.Param(id = 1) int i12, @SafeParcelable.Param(id = 2) int i13, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 5) zzac[] zzacArr, @SafeParcelable.Param(id = 6) boolean z11) {
        this.zzc = i11 < 1000 ? 0 : 1000;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = j11;
        this.zzg = zzacArr;
    }

    @Nullable
    public static LocationAvailability extractLocationAvailability(@NonNull Intent intent) {
        if (!hasLocationAvailability(intent)) {
            return null;
        }
        try {
            return (LocationAvailability) intent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    public static boolean hasLocationAvailability(@Nullable Intent intent) {
        if (intent == null || !intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY")) {
            return false;
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zzd == locationAvailability.zzd && this.zze == locationAvailability.zze && this.zzf == locationAvailability.zzf && this.zzc == locationAvailability.zzc && Arrays.equals(this.zzg, locationAvailability.zzg)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzc));
    }

    public boolean isLocationAvailable() {
        return this.zzc < 1000;
    }

    @NonNull
    public String toString() {
        boolean isLocationAvailable = isLocationAvailable();
        return "LocationAvailability[" + isLocationAvailable + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzd);
        SafeParcelWriter.writeInt(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzg, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 6, isLocationAvailable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
