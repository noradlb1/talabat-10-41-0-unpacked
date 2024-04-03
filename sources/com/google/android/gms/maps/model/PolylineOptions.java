package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StrokeStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
public final class PolylineOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getPoints", id = 2)
    private final List zza;
    @SafeParcelable.Field(getter = "getWidth", id = 3)
    private float zzb;
    @SafeParcelable.Field(getter = "getColor", id = 4)
    private int zzc;
    @SafeParcelable.Field(getter = "getZIndex", id = 5)
    private float zzd;
    @SafeParcelable.Field(getter = "isVisible", id = 6)
    private boolean zze;
    @SafeParcelable.Field(getter = "isGeodesic", id = 7)
    private boolean zzf;
    @SafeParcelable.Field(getter = "isClickable", id = 8)
    private boolean zzg;
    @SafeParcelable.Field(getter = "getStartCap", id = 9)
    private Cap zzh;
    @SafeParcelable.Field(getter = "getEndCap", id = 10)
    private Cap zzi;
    @SafeParcelable.Field(getter = "getJointType", id = 11)
    private int zzj;
    @SafeParcelable.Field(getter = "getPattern", id = 12)
    @Nullable
    private List zzk;
    @SafeParcelable.Field(getter = "getSpans", id = 13)
    private List zzl;

    public PolylineOptions() {
        this.zzb = 10.0f;
        this.zzc = ViewCompat.MEASURED_STATE_MASK;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = new ArrayList();
    }

    @NonNull
    public PolylineOptions add(@NonNull LatLng latLng) {
        Preconditions.checkNotNull(this.zza, "point must not be null.");
        this.zza.add(latLng);
        return this;
    }

    @NonNull
    public PolylineOptions addAll(@NonNull Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        for (LatLng add : iterable) {
            this.zza.add(add);
        }
        return this;
    }

    @NonNull
    public PolylineOptions addAllSpans(@NonNull Iterable<StyleSpan> iterable) {
        for (StyleSpan addSpan : iterable) {
            addSpan(addSpan);
        }
        return this;
    }

    @NonNull
    public PolylineOptions addSpan(@NonNull StyleSpan styleSpan) {
        this.zzl.add(styleSpan);
        return this;
    }

    @NonNull
    public PolylineOptions clickable(boolean z11) {
        this.zzg = z11;
        return this;
    }

    @NonNull
    public PolylineOptions color(int i11) {
        this.zzc = i11;
        return this;
    }

    @NonNull
    public PolylineOptions endCap(@NonNull Cap cap) {
        this.zzi = (Cap) Preconditions.checkNotNull(cap, "endCap must not be null");
        return this;
    }

    @NonNull
    public PolylineOptions geodesic(boolean z11) {
        this.zzf = z11;
        return this;
    }

    public int getColor() {
        return this.zzc;
    }

    @NonNull
    public Cap getEndCap() {
        return this.zzi.zza();
    }

    public int getJointType() {
        return this.zzj;
    }

    @Nullable
    public List<PatternItem> getPattern() {
        return this.zzk;
    }

    @NonNull
    public List<LatLng> getPoints() {
        return this.zza;
    }

    @NonNull
    public Cap getStartCap() {
        return this.zzh.zza();
    }

    public float getWidth() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzd;
    }

    public boolean isClickable() {
        return this.zzg;
    }

    public boolean isGeodesic() {
        return this.zzf;
    }

    public boolean isVisible() {
        return this.zze;
    }

    @NonNull
    public PolylineOptions jointType(int i11) {
        this.zzj = i11;
        return this;
    }

    @NonNull
    public PolylineOptions pattern(@Nullable List<PatternItem> list) {
        this.zzk = list;
        return this;
    }

    @NonNull
    public PolylineOptions startCap(@NonNull Cap cap) {
        this.zzh = (Cap) Preconditions.checkNotNull(cap, "startCap must not be null");
        return this;
    }

    @NonNull
    public PolylineOptions visible(boolean z11) {
        this.zze = z11;
        return this;
    }

    @NonNull
    public PolylineOptions width(float f11) {
        this.zzb = f11;
        return this;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeFloat(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getColor());
        SafeParcelWriter.writeFloat(parcel, 5, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 6, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 7, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 8, isClickable());
        SafeParcelWriter.writeParcelable(parcel, 9, getStartCap(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 10, getEndCap(), i11, false);
        SafeParcelWriter.writeInt(parcel, 11, getJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getPattern(), false);
        ArrayList arrayList = new ArrayList(this.zzl.size());
        for (StyleSpan styleSpan : this.zzl) {
            StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.getStyle());
            builder.zzd(this.zzb);
            builder.zzc(this.zze);
            arrayList.add(new StyleSpan(builder.build(), styleSpan.getSegments()));
        }
        SafeParcelWriter.writeTypedList(parcel, 13, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public PolylineOptions zIndex(float f11) {
        this.zzd = f11;
        return this;
    }

    @NonNull
    public PolylineOptions addSpan(@NonNull StyleSpan... styleSpanArr) {
        for (StyleSpan addSpan : styleSpanArr) {
            addSpan(addSpan);
        }
        return this;
    }

    @NonNull
    public PolylineOptions add(@NonNull LatLng... latLngArr) {
        Preconditions.checkNotNull(latLngArr, "points must not be null.");
        Collections.addAll(this.zza, latLngArr);
        return this;
    }

    @SafeParcelable.Constructor
    public PolylineOptions(@SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) float f11, @SafeParcelable.Param(id = 4) int i11, @SafeParcelable.Param(id = 5) float f12, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) boolean z12, @SafeParcelable.Param(id = 8) boolean z13, @SafeParcelable.Param(id = 9) @Nullable Cap cap, @SafeParcelable.Param(id = 10) @Nullable Cap cap2, @SafeParcelable.Param(id = 11) int i12, @SafeParcelable.Param(id = 12) @Nullable List list2, @SafeParcelable.Param(id = 13) @Nullable List list3) {
        this.zzb = 10.0f;
        this.zzc = ViewCompat.MEASURED_STATE_MASK;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = list;
        this.zzb = f11;
        this.zzc = i11;
        this.zzd = f12;
        this.zze = z11;
        this.zzf = z12;
        this.zzg = z13;
        if (cap != null) {
            this.zzh = cap;
        }
        if (cap2 != null) {
            this.zzi = cap2;
        }
        this.zzj = i12;
        this.zzk = list2;
        if (list3 != null) {
            this.zzl = list3;
        }
    }
}
