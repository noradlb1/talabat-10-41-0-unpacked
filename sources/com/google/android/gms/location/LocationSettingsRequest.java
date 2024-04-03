package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "LocationSettingsRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getLocationRequests", id = 1)
    private final List zza;
    @SafeParcelable.Field(defaultValue = "false", getter = "alwaysShow", id = 2)
    private final boolean zzb;
    @SafeParcelable.Field(getter = "needBle", id = 3)
    private final boolean zzc;

    public static final class Builder {
        private final ArrayList zza = new ArrayList();
        private boolean zzb = false;
        private boolean zzc = false;

        @NonNull
        public Builder addAllLocationRequests(@NonNull Collection<LocationRequest> collection) {
            for (LocationRequest next : collection) {
                if (next != null) {
                    this.zza.add(next);
                }
            }
            return this;
        }

        @NonNull
        public Builder addLocationRequest(@NonNull LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.zza.add(locationRequest);
            }
            return this;
        }

        @NonNull
        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zza, this.zzb, this.zzc);
        }

        @NonNull
        public Builder setAlwaysShow(boolean z11) {
            this.zzb = z11;
            return this;
        }

        @NonNull
        public Builder setNeedBle(boolean z11) {
            this.zzc = z11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LocationSettingsRequest(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) boolean z12) {
        this.zza = list;
        this.zzb = z11;
        this.zzc = z12;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.zza), false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
