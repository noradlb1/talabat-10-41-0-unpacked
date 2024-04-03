package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;

@SafeParcelable.Class(creator = "MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
public class MarkerOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getPosition", id = 2)
    private LatLng zza;
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    @Nullable
    private String zzb;
    @SafeParcelable.Field(getter = "getSnippet", id = 4)
    @Nullable
    private String zzc;
    @SafeParcelable.Field(getter = "getWrappedIconDescriptorImplBinder", id = 5, type = "android.os.IBinder")
    @Nullable
    private BitmapDescriptor zzd;
    @SafeParcelable.Field(getter = "getAnchorU", id = 6)
    private float zze = 0.5f;
    @SafeParcelable.Field(getter = "getAnchorV", id = 7)
    private float zzf = 1.0f;
    @SafeParcelable.Field(getter = "isDraggable", id = 8)
    private boolean zzg;
    @SafeParcelable.Field(getter = "isVisible", id = 9)
    private boolean zzh = true;
    @SafeParcelable.Field(getter = "isFlat", id = 10)
    private boolean zzi = false;
    @SafeParcelable.Field(getter = "getRotation", id = 11)
    private float zzj = 0.0f;
    @SafeParcelable.Field(defaultValue = "0.5f", getter = "getInfoWindowAnchorU", id = 12)
    private float zzk = 0.5f;
    @SafeParcelable.Field(getter = "getInfoWindowAnchorV", id = 13)
    private float zzl = 0.0f;
    @SafeParcelable.Field(defaultValue = "1.0f", getter = "getAlpha", id = 14)
    private float zzm = 1.0f;
    @SafeParcelable.Field(getter = "getZIndex", id = 15)
    private float zzn;
    @SafeParcelable.Field(getter = "getCollisionBehaviorInternal", id = 17)
    @AdvancedMarkerOptions.CollisionBehavior
    private int zzo = 0;
    @SafeParcelable.Field(getter = "getIconViewBinder", id = 18, type = "android.os.IBinder")
    @Nullable
    private View zzp;
    @SafeParcelable.Field(getter = "getMarkerType", id = 19)
    private int zzq;
    @SafeParcelable.Field(getter = "getContentDescription", id = 20)
    @Nullable
    private String zzr;
    @SafeParcelable.Field(getter = "getAltitudeInternal", id = 21)
    private float zzs;

    public MarkerOptions() {
    }

    @NonNull
    public MarkerOptions alpha(float f11) {
        this.zzm = f11;
        return this;
    }

    @NonNull
    public MarkerOptions anchor(float f11, float f12) {
        this.zze = f11;
        this.zzf = f12;
        return this;
    }

    @NonNull
    public MarkerOptions contentDescription(@Nullable String str) {
        this.zzr = str;
        return this;
    }

    @NonNull
    public MarkerOptions draggable(boolean z11) {
        this.zzg = z11;
        return this;
    }

    @NonNull
    public MarkerOptions flat(boolean z11) {
        this.zzi = z11;
        return this;
    }

    public float getAlpha() {
        return this.zzm;
    }

    public float getAnchorU() {
        return this.zze;
    }

    public float getAnchorV() {
        return this.zzf;
    }

    @Nullable
    public BitmapDescriptor getIcon() {
        return this.zzd;
    }

    public float getInfoWindowAnchorU() {
        return this.zzk;
    }

    public float getInfoWindowAnchorV() {
        return this.zzl;
    }

    @NonNull
    public LatLng getPosition() {
        return this.zza;
    }

    public float getRotation() {
        return this.zzj;
    }

    @Nullable
    public String getSnippet() {
        return this.zzc;
    }

    @Nullable
    public String getTitle() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzn;
    }

    @NonNull
    public MarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor) {
        this.zzd = bitmapDescriptor;
        return this;
    }

    @NonNull
    public MarkerOptions infoWindowAnchor(float f11, float f12) {
        this.zzk = f11;
        this.zzl = f12;
        return this;
    }

    public boolean isDraggable() {
        return this.zzg;
    }

    public boolean isFlat() {
        return this.zzi;
    }

    public boolean isVisible() {
        return this.zzh;
    }

    @NonNull
    public MarkerOptions position(@NonNull LatLng latLng) {
        if (latLng != null) {
            this.zza = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    @NonNull
    public MarkerOptions rotation(float f11) {
        this.zzj = f11;
        return this;
    }

    @NonNull
    public MarkerOptions snippet(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @NonNull
    public MarkerOptions title(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    @NonNull
    public MarkerOptions visible(boolean z11) {
        this.zzh = z11;
        return this;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getPosition(), i11, false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeString(parcel, 4, getSnippet(), false);
        BitmapDescriptor bitmapDescriptor = this.zzd;
        if (bitmapDescriptor == null) {
            iBinder = null;
        } else {
            iBinder = bitmapDescriptor.zza().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder, false);
        SafeParcelWriter.writeFloat(parcel, 6, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 7, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 8, isDraggable());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 10, isFlat());
        SafeParcelWriter.writeFloat(parcel, 11, getRotation());
        SafeParcelWriter.writeFloat(parcel, 12, getInfoWindowAnchorU());
        SafeParcelWriter.writeFloat(parcel, 13, getInfoWindowAnchorV());
        SafeParcelWriter.writeFloat(parcel, 14, getAlpha());
        SafeParcelWriter.writeFloat(parcel, 15, getZIndex());
        SafeParcelWriter.writeInt(parcel, 17, this.zzo);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 19, this.zzq);
        SafeParcelWriter.writeString(parcel, 20, this.zzr, false);
        SafeParcelWriter.writeFloat(parcel, 21, this.zzs);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public MarkerOptions zIndex(float f11) {
        this.zzn = f11;
        return this;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzq;
    }

    @Nullable
    public final View zzc() {
        return this.zzp;
    }

    @NonNull
    public final MarkerOptions zzd(@AdvancedMarkerOptions.CollisionBehavior int i11) {
        this.zzo = i11;
        return this;
    }

    @NonNull
    public final MarkerOptions zze(@Nullable View view) {
        this.zzp = view;
        return this;
    }

    @NonNull
    public final MarkerOptions zzf(int i11) {
        this.zzq = 1;
        return this;
    }

    @SafeParcelable.Constructor
    public MarkerOptions(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 6) float f11, @SafeParcelable.Param(id = 7) float f12, @SafeParcelable.Param(id = 8) boolean z11, @SafeParcelable.Param(id = 9) boolean z12, @SafeParcelable.Param(id = 10) boolean z13, @SafeParcelable.Param(id = 11) float f13, @SafeParcelable.Param(id = 12) float f14, @SafeParcelable.Param(id = 13) float f15, @SafeParcelable.Param(id = 14) float f16, @SafeParcelable.Param(id = 15) float f17, @SafeParcelable.Param(id = 17) int i11, @SafeParcelable.Param(id = 18) IBinder iBinder2, @SafeParcelable.Param(id = 19) int i12, @SafeParcelable.Param(id = 20) String str3, @SafeParcelable.Param(id = 21) float f18) {
        this.zza = latLng;
        this.zzb = str;
        this.zzc = str2;
        View view = null;
        if (iBinder == null) {
            this.zzd = null;
        } else {
            this.zzd = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        this.zze = f11;
        this.zzf = f12;
        this.zzg = z11;
        this.zzh = z12;
        this.zzi = z13;
        this.zzj = f13;
        this.zzk = f14;
        this.zzl = f15;
        this.zzm = f16;
        this.zzn = f17;
        this.zzq = i12;
        this.zzo = i11;
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(iBinder2);
        this.zzp = asInterface != null ? (View) ObjectWrapper.unwrap(asInterface) : view;
        this.zzr = str3;
        this.zzs = f18;
    }
}
