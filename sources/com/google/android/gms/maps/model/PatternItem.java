package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
public class PatternItem extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzm();
    private static final String zza = "PatternItem";
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getLength", id = 3)
    @Nullable
    private final Float zzc;

    @SafeParcelable.Constructor
    public PatternItem(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) @Nullable Float f11) {
        boolean z11 = true;
        if (i11 != 1 && (f11 == null || f11.floatValue() < 0.0f)) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid PatternItem: type=" + i11 + " length=" + f11);
        this.zzb = i11;
        this.zzc = f11;
    }

    @Nullable
    public static List zza(@Nullable List list) {
        PatternItem patternItem;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PatternItem patternItem2 = (PatternItem) it.next();
            if (patternItem2 == null) {
                patternItem2 = null;
            } else {
                int i11 = patternItem2.zzb;
                boolean z11 = false;
                if (i11 == 0) {
                    if (patternItem2.zzc != null) {
                        z11 = true;
                    }
                    Preconditions.checkState(z11, "length must not be null.");
                    patternItem = new Dash(patternItem2.zzc.floatValue());
                } else if (i11 == 1) {
                    patternItem2 = new Dot();
                } else if (i11 != 2) {
                    Log.w(zza, "Unknown PatternItem type: " + i11);
                } else {
                    if (patternItem2.zzc != null) {
                        z11 = true;
                    }
                    Preconditions.checkState(z11, "length must not be null.");
                    patternItem = new Gap(patternItem2.zzc.floatValue());
                }
                patternItem2 = patternItem;
            }
            arrayList.add(patternItem2);
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        if (this.zzb != patternItem.zzb || !Objects.equal(this.zzc, patternItem.zzc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc);
    }

    @NonNull
    public String toString() {
        return "[PatternItem: type=" + this.zzb + " length=" + this.zzc + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int i12 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i12);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
