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
import java.util.List;

@SafeParcelable.Class(creator = "SleepSegmentRequestCreator")
@SafeParcelable.Reserved({1000})
public class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final int CLASSIFY_EVENTS_ONLY = 2;
    @NonNull
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new zzah();
    public static final int SEGMENT_AND_CLASSIFY_EVENTS = 0;
    public static final int SEGMENT_EVENTS_ONLY = 1;
    @SafeParcelable.Field(getter = "getUserPreferredSleepWindow", id = 1)
    @Nullable
    private final List zza;
    @SafeParcelable.Field(defaultValue = "0", getter = "getRequestedDataType", id = 2)
    private final int zzb;

    public SleepSegmentRequest(int i11) {
        this((List) null, i11);
    }

    @NonNull
    public static SleepSegmentRequest getDefaultSleepSegmentRequest() {
        return new SleepSegmentRequest((List) null, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        if (!Objects.equal(this.zza, sleepSegmentRequest.zza) || this.zzb != sleepSegmentRequest.zzb) {
            return false;
        }
        return true;
    }

    public int getRequestedDataType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, getRequestedDataType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SleepSegmentRequest(@SafeParcelable.Param(id = 1) @Nullable List list, @SafeParcelable.Param(id = 2) int i11) {
        this.zza = list;
        this.zzb = i11;
    }
}
