package com.google.android.gms.location;

import android.content.Intent;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "SleepClassifyEventCreator")
public class SleepClassifyEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "getTimestampSec", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getConfidence", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getMotion", id = 3)
    private final int zzc;
    @SafeParcelable.Field(getter = "getLight", id = 4)
    private final int zzd;
    @SafeParcelable.Field(getter = "getNoise", id = 5)
    private final int zze;
    @SafeParcelable.Field(getter = "getLightDiff", id = 6)
    private final int zzf;
    @SafeParcelable.Field(getter = "getNightOrDay", id = 7)
    private final int zzg;
    @SafeParcelable.Field(getter = "getConfidenceOverwrittenByAlarmClockTrigger", id = 8)
    private final boolean zzh;
    @SafeParcelable.Field(getter = "getPresenceConfidence", id = 9)
    private final int zzi;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SleepClassifyEvent(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) int i14, @SafeParcelable.Param(id = 5) int i15, @SafeParcelable.Param(id = 6) int i16, @SafeParcelable.Param(id = 7) int i17, @SafeParcelable.Param(id = 8) boolean z11, @SafeParcelable.Param(id = 9) int i18) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
        this.zzf = i16;
        this.zzg = i17;
        this.zzh = z11;
        this.zzi = i18;
    }

    @NonNull
    public static List<SleepClassifyEvent> extractEvents(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        if (!hasEvents(intent)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
        if (arrayList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            byte[] bArr = (byte[]) arrayList.get(i11);
            Preconditions.checkNotNull(bArr);
            arrayList2.add((SleepClassifyEvent) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR));
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean hasEvents(@Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        if (this.zza == sleepClassifyEvent.zza && this.zzb == sleepClassifyEvent.zzb) {
            return true;
        }
        return false;
    }

    public int getConfidence() {
        return this.zzb;
    }

    public int getLight() {
        return this.zzd;
    }

    public int getMotion() {
        return this.zzc;
    }

    public long getTimestampMillis() {
        return ((long) this.zza) * 1000;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    @NonNull
    public String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        int i13 = this.zzc;
        int i14 = this.zzd;
        return i11 + " Conf:" + i12 + " Motion:" + i13 + " Light:" + i14;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, getConfidence());
        SafeParcelWriter.writeInt(parcel, 3, getMotion());
        SafeParcelWriter.writeInt(parcel, 4, getLight());
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
