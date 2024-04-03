package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getElapsedRealTimeNanos", id = 3)
    private final long zzc;

    @SafeParcelable.Constructor
    public ActivityTransitionEvent(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) long j11) {
        ActivityTransition.zza(i12);
        this.zza = i11;
        this.zzb = i12;
        this.zzc = j11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        if (this.zza == activityTransitionEvent.zza && this.zzb == activityTransitionEvent.zzb && this.zzc == activityTransitionEvent.zzc) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public long getElapsedRealTimeNanos() {
        return this.zzc;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i11 = this.zza;
        sb2.append("ActivityType " + i11);
        sb2.append(" ");
        int i12 = this.zzb;
        sb2.append("TransitionType " + i12);
        sb2.append(" ");
        long j11 = this.zzc;
        sb2.append("ElapsedRealTimeNanos " + j11);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.writeLong(parcel, 3, getElapsedRealTimeNanos());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
