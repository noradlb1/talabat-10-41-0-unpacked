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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    @NonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)
    private final int zzb;

    public static class Builder {
        private int zza = -1;
        private int zzb = -1;

        @NonNull
        public ActivityTransition build() {
            boolean z11;
            boolean z12 = true;
            if (this.zza != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Activity type not set.");
            if (this.zzb == -1) {
                z12 = false;
            }
            Preconditions.checkState(z12, "Activity transition type not set.");
            return new ActivityTransition(this.zza, this.zzb);
        }

        @NonNull
        public Builder setActivityTransition(int i11) {
            ActivityTransition.zza(i11);
            this.zzb = i11;
            return this;
        }

        @NonNull
        public Builder setActivityType(int i11) {
            this.zza = i11;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    @SafeParcelable.Constructor
    public ActivityTransition(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12) {
        this.zza = i11;
        this.zzb = i12;
    }

    public static void zza(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= 1) {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "Transition type " + i11 + " is not valid.");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        if (this.zza == activityTransition.zza && this.zzb == activityTransition.zzb) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    @NonNull
    public String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        return "ActivityTransition [mActivityType=" + i11 + ", mTransitionType=" + i12 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
