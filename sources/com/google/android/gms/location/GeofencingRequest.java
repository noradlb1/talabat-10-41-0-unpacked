package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzdh;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
public class GeofencingRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzn();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    @SafeParcelable.Field(getter = "getParcelableGeofences", id = 1)
    private final List zza;
    @InitialTrigger
    @SafeParcelable.Field(getter = "getInitialTrigger", id = 2)
    private final int zzb;
    @SafeParcelable.Field(defaultValue = "", getter = "getTag", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getContextAttributionTag", id = 4)
    @Nullable
    private final String zzd;

    public static final class Builder {
        private final List zza = new ArrayList();
        @InitialTrigger
        private int zzb = 5;
        private String zzc = "";

        @NonNull
        public Builder addGeofence(@NonNull Geofence geofence) {
            Preconditions.checkNotNull(geofence, "geofence can't be null.");
            Preconditions.checkArgument(geofence instanceof zzdh, "Geofence must be created using Geofence.Builder.");
            this.zza.add((zzdh) geofence);
            return this;
        }

        @NonNull
        public Builder addGeofences(@NonNull List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence next : list) {
                    if (next != null) {
                        addGeofence(next);
                    }
                }
            }
            return this;
        }

        @NonNull
        public GeofencingRequest build() {
            Preconditions.checkArgument(!this.zza.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zza, this.zzb, this.zzc, (String) null);
        }

        @NonNull
        public Builder setInitialTrigger(@InitialTrigger int i11) {
            this.zzb = i11 & 7;
            return this;
        }
    }

    public @interface InitialTrigger {
    }

    @SafeParcelable.Constructor
    public GeofencingRequest(@SafeParcelable.Param(id = 1) List list, @InitialTrigger @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable String str2) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = str;
        this.zzd = str2;
    }

    @NonNull
    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zza);
        return arrayList;
    }

    @InitialTrigger
    public int getInitialTrigger() {
        return this.zzb;
    }

    @NonNull
    public String toString() {
        return "GeofencingRequest[geofences=" + this.zza + ", initialTrigger=" + this.zzb + ", tag=" + this.zzc + ", attributionTag=" + this.zzd + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, getInitialTrigger());
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final GeofencingRequest zza(@Nullable String str) {
        return new GeofencingRequest(this.zza, this.zzb, this.zzc, str);
    }
}
