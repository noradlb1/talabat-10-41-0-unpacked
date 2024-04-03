package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.CharacterStyle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "AutocompletePredictionEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzc extends AbstractSafeParcelable implements AutocompletePrediction {
    public static final Parcelable.Creator<zzc> CREATOR = new zze();
    private static final List<zzb> zzbb = Collections.emptyList();
    @SafeParcelable.Field(id = 2)
    private final String placeId;
    @SafeParcelable.Field(id = 1)
    private final String zzbc;
    @SafeParcelable.Field(id = 4)
    private final List<zzb> zzbd;
    @SafeParcelable.Field(id = 5)
    private final int zzbe;
    @SafeParcelable.Field(id = 6)
    private final String zzbf;
    @SafeParcelable.Field(id = 7)
    private final List<zzb> zzbg;
    @SafeParcelable.Field(id = 8)
    private final String zzbh;
    @SafeParcelable.Field(id = 9)
    private final List<zzb> zzbi;
    @SafeParcelable.Field(id = 3)
    private final List<Integer> zzg;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<Integer> list, @SafeParcelable.Param(id = 5) int i11, @SafeParcelable.Param(id = 1) String str2, @SafeParcelable.Param(id = 4) List<zzb> list2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) List<zzb> list3, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) List<zzb> list4) {
        this.placeId = str;
        this.zzg = list;
        this.zzbe = i11;
        this.zzbc = str2;
        this.zzbd = list2;
        this.zzbf = str3;
        this.zzbg = list3;
        this.zzbh = str4;
        this.zzbi = list4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        if (!Objects.equal(this.placeId, zzc.placeId) || !Objects.equal(this.zzg, zzc.zzg) || !Objects.equal(Integer.valueOf(this.zzbe), Integer.valueOf(zzc.zzbe)) || !Objects.equal(this.zzbc, zzc.zzbc) || !Objects.equal(this.zzbd, zzc.zzbd) || !Objects.equal(this.zzbf, zzc.zzbf) || !Objects.equal(this.zzbg, zzc.zzbg) || !Objects.equal(this.zzbh, zzc.zzbh) || !Objects.equal(this.zzbi, zzc.zzbi)) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.zzbc, this.zzbd, characterStyle);
    }

    @Nullable
    public final String getPlaceId() {
        return this.placeId;
    }

    public final List<Integer> getPlaceTypes() {
        return this.zzg;
    }

    public final CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.zzbf, this.zzbg, characterStyle);
    }

    public final CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.zzbh, this.zzbi, characterStyle);
    }

    public final int hashCode() {
        return Objects.hashCode(this.placeId, this.zzg, Integer.valueOf(this.zzbe), this.zzbc, this.zzbd, this.zzbf, this.zzbg, this.zzbh, this.zzbi);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(Param.PLACE_ID, this.placeId).add("placeTypes", this.zzg).add("fullText", this.zzbc).add("fullTextMatchedSubstrings", this.zzbd).add("primaryText", this.zzbf).add("primaryTextMatchedSubstrings", this.zzbg).add("secondaryText", this.zzbh).add("secondaryTextMatchedSubstrings", this.zzbi).toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbc, false);
        SafeParcelWriter.writeString(parcel, 2, this.placeId, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.zzg, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzbd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbe);
        SafeParcelWriter.writeString(parcel, 6, this.zzbf, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzbg, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbh, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.zzbi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
