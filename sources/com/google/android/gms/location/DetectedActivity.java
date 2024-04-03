package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
public class DetectedActivity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    @NonNull
    public static final Comparator zza = new zzk();
    @SafeParcelable.Field(id = 1)
    int zzb;
    @SafeParcelable.Field(id = 2)
    int zzc;

    @SafeParcelable.Constructor
    public DetectedActivity(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12) {
        this.zzb = i11;
        this.zzc = i12;
    }

    @ShowFirstParty
    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.zzb == detectedActivity.zzb && this.zzc == detectedActivity.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getConfidence() {
        return this.zzc;
    }

    public int getType() {
        int i11 = this.zzb;
        if (i11 > 22 || i11 < 0) {
            return 4;
        }
        return i11;
    }

    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @NonNull
    public String toString() {
        String str;
        int type = getType();
        if (type == 0) {
            str = "IN_VEHICLE";
        } else if (type == 1) {
            str = "ON_BICYCLE";
        } else if (type == 2) {
            str = "ON_FOOT";
        } else if (type == 3) {
            str = "STILL";
        } else if (type == 4) {
            str = "UNKNOWN";
        } else if (type == 5) {
            str = "TILTING";
        } else if (type == 7) {
            str = "WALKING";
        } else if (type == 8) {
            str = DebugCoroutineInfoImplKt.RUNNING;
        } else if (type == 16) {
            str = "IN_ROAD_VEHICLE";
        } else if (type != 17) {
            str = Integer.toString(type);
        } else {
            str = "IN_RAIL_VEHICLE";
        }
        int i11 = this.zzc;
        return "DetectedActivity [type=" + str + ", confidence=" + i11 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
