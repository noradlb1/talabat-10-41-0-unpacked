package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzac();
    private static final Integer zza = Integer.valueOf(Color.argb(255, 236, 233, 225));
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZOrderOnTopForParcel", id = 2, type = "byte")
    @Nullable
    private Boolean zzb;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getUseViewLifecycleInFragmentForParcel", id = 3, type = "byte")
    @Nullable
    private Boolean zzc;
    @SafeParcelable.Field(getter = "getMapType", id = 4)
    private int zzd = -1;
    @SafeParcelable.Field(getter = "getCamera", id = 5)
    @Nullable
    private CameraPosition zze;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomControlsEnabledForParcel", id = 6, type = "byte")
    @Nullable
    private Boolean zzf;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getCompassEnabledForParcel", id = 7, type = "byte")
    @Nullable
    private Boolean zzg;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledForParcel", id = 8, type = "byte")
    @Nullable
    private Boolean zzh;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomGesturesEnabledForParcel", id = 9, type = "byte")
    @Nullable
    private Boolean zzi;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTiltGesturesEnabledForParcel", id = 10, type = "byte")
    @Nullable
    private Boolean zzj;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getRotateGesturesEnabledForParcel", id = 11, type = "byte")
    @Nullable
    private Boolean zzk;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLiteModeForParcel", id = 12, type = "byte")
    @Nullable
    private Boolean zzl;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getMapToolbarEnabledForParcel", id = 14, type = "byte")
    @Nullable
    private Boolean zzm;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getAmbientEnabledForParcel", id = 15, type = "byte")
    @Nullable
    private Boolean zzn;
    @SafeParcelable.Field(getter = "getMinZoomPreference", id = 16)
    @Nullable
    private Float zzo = null;
    @SafeParcelable.Field(getter = "getMaxZoomPreference", id = 17)
    @Nullable
    private Float zzp = null;
    @SafeParcelable.Field(getter = "getLatLngBoundsForCameraTarget", id = 18)
    @Nullable
    private LatLngBounds zzq = null;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", id = 19, type = "byte")
    @Nullable
    private Boolean zzr;
    @SafeParcelable.Field(getter = "getBackgroundColor", id = 20)
    @ColorInt
    @Nullable
    private Integer zzs = null;
    @SafeParcelable.Field(getter = "getMapId", id = 21)
    @Nullable
    private String zzt = null;

    public GoogleMapOptions() {
    }

    @Nullable
    public static GoogleMapOptions createFromAttributes(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        String string;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i11 = R.styleable.MapAttrs_mapType;
        if (obtainAttributes.hasValue(i11)) {
            googleMapOptions.mapType(obtainAttributes.getInt(i11, -1));
        }
        int i12 = R.styleable.MapAttrs_zOrderOnTop;
        if (obtainAttributes.hasValue(i12)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(i12, false));
        }
        int i13 = R.styleable.MapAttrs_useViewLifecycle;
        if (obtainAttributes.hasValue(i13)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(i13, false));
        }
        int i14 = R.styleable.MapAttrs_uiCompass;
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(i14, true));
        }
        int i15 = R.styleable.MapAttrs_uiRotateGestures;
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(i15, true));
        }
        int i16 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
        if (obtainAttributes.hasValue(i16)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(i16, true));
        }
        int i17 = R.styleable.MapAttrs_uiScrollGestures;
        if (obtainAttributes.hasValue(i17)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(i17, true));
        }
        int i18 = R.styleable.MapAttrs_uiTiltGestures;
        if (obtainAttributes.hasValue(i18)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(i18, true));
        }
        int i19 = R.styleable.MapAttrs_uiZoomGestures;
        if (obtainAttributes.hasValue(i19)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(i19, true));
        }
        int i21 = R.styleable.MapAttrs_uiZoomControls;
        if (obtainAttributes.hasValue(i21)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(i21, true));
        }
        int i22 = R.styleable.MapAttrs_liteMode;
        if (obtainAttributes.hasValue(i22)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(i22, false));
        }
        int i23 = R.styleable.MapAttrs_uiMapToolbar;
        if (obtainAttributes.hasValue(i23)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(i23, true));
        }
        int i24 = R.styleable.MapAttrs_ambientEnabled;
        if (obtainAttributes.hasValue(i24)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(i24, false));
        }
        int i25 = R.styleable.MapAttrs_cameraMinZoomPreference;
        if (obtainAttributes.hasValue(i25)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(i25, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(i25)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        int i26 = R.styleable.MapAttrs_backgroundColor;
        if (obtainAttributes.hasValue(i26)) {
            googleMapOptions.backgroundColor(Integer.valueOf(obtainAttributes.getColor(i26, zza.intValue())));
        }
        int i27 = R.styleable.MapAttrs_mapId;
        if (obtainAttributes.hasValue(i27) && (string = obtainAttributes.getString(i27)) != null && !string.isEmpty()) {
            googleMapOptions.mapId(string);
        }
        googleMapOptions.latLngBoundsForCameraTarget(zzb(context, attributeSet));
        googleMapOptions.camera(zza(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    @Nullable
    public static CameraPosition zza(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        float f11;
        float f12;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i11 = R.styleable.MapAttrs_cameraTargetLat;
        if (obtainAttributes.hasValue(i11)) {
            f11 = obtainAttributes.getFloat(i11, 0.0f);
        } else {
            f11 = 0.0f;
        }
        int i12 = R.styleable.MapAttrs_cameraTargetLng;
        if (obtainAttributes.hasValue(i12)) {
            f12 = obtainAttributes.getFloat(i12, 0.0f);
        } else {
            f12 = 0.0f;
        }
        LatLng latLng = new LatLng((double) f11, (double) f12);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        int i13 = R.styleable.MapAttrs_cameraZoom;
        if (obtainAttributes.hasValue(i13)) {
            builder.zoom(obtainAttributes.getFloat(i13, 0.0f));
        }
        int i14 = R.styleable.MapAttrs_cameraBearing;
        if (obtainAttributes.hasValue(i14)) {
            builder.bearing(obtainAttributes.getFloat(i14, 0.0f));
        }
        int i15 = R.styleable.MapAttrs_cameraTilt;
        if (obtainAttributes.hasValue(i15)) {
            builder.tilt(obtainAttributes.getFloat(i15, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    @Nullable
    public static LatLngBounds zzb(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i11 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        if (obtainAttributes.hasValue(i11)) {
            f11 = Float.valueOf(obtainAttributes.getFloat(i11, 0.0f));
        } else {
            f11 = null;
        }
        int i12 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        if (obtainAttributes.hasValue(i12)) {
            f12 = Float.valueOf(obtainAttributes.getFloat(i12, 0.0f));
        } else {
            f12 = null;
        }
        int i13 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        if (obtainAttributes.hasValue(i13)) {
            f13 = Float.valueOf(obtainAttributes.getFloat(i13, 0.0f));
        } else {
            f13 = null;
        }
        int i14 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        if (obtainAttributes.hasValue(i14)) {
            f14 = Float.valueOf(obtainAttributes.getFloat(i14, 0.0f));
        } else {
            f14 = null;
        }
        obtainAttributes.recycle();
        if (f11 == null || f12 == null || f13 == null || f14 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) f11.floatValue(), (double) f12.floatValue()), new LatLng((double) f13.floatValue(), (double) f14.floatValue()));
    }

    @NonNull
    public GoogleMapOptions ambientEnabled(boolean z11) {
        this.zzn = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions backgroundColor(@ColorInt @Nullable Integer num) {
        this.zzs = num;
        return this;
    }

    @NonNull
    public GoogleMapOptions camera(@Nullable CameraPosition cameraPosition) {
        this.zze = cameraPosition;
        return this;
    }

    @NonNull
    public GoogleMapOptions compassEnabled(boolean z11) {
        this.zzg = Boolean.valueOf(z11);
        return this;
    }

    @Nullable
    public Boolean getAmbientEnabled() {
        return this.zzn;
    }

    @ColorInt
    @Nullable
    public Integer getBackgroundColor() {
        return this.zzs;
    }

    @Nullable
    public CameraPosition getCamera() {
        return this.zze;
    }

    @Nullable
    public Boolean getCompassEnabled() {
        return this.zzg;
    }

    @Nullable
    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzq;
    }

    @Nullable
    public Boolean getLiteMode() {
        return this.zzl;
    }

    @Nullable
    public String getMapId() {
        return this.zzt;
    }

    @Nullable
    public Boolean getMapToolbarEnabled() {
        return this.zzm;
    }

    public int getMapType() {
        return this.zzd;
    }

    @Nullable
    public Float getMaxZoomPreference() {
        return this.zzp;
    }

    @Nullable
    public Float getMinZoomPreference() {
        return this.zzo;
    }

    @Nullable
    public Boolean getRotateGesturesEnabled() {
        return this.zzk;
    }

    @Nullable
    public Boolean getScrollGesturesEnabled() {
        return this.zzh;
    }

    @Nullable
    public Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.zzr;
    }

    @Nullable
    public Boolean getTiltGesturesEnabled() {
        return this.zzj;
    }

    @Nullable
    public Boolean getUseViewLifecycleInFragment() {
        return this.zzc;
    }

    @Nullable
    public Boolean getZOrderOnTop() {
        return this.zzb;
    }

    @Nullable
    public Boolean getZoomControlsEnabled() {
        return this.zzf;
    }

    @Nullable
    public Boolean getZoomGesturesEnabled() {
        return this.zzi;
    }

    @NonNull
    public GoogleMapOptions latLngBoundsForCameraTarget(@Nullable LatLngBounds latLngBounds) {
        this.zzq = latLngBounds;
        return this;
    }

    @NonNull
    public GoogleMapOptions liteMode(boolean z11) {
        this.zzl = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions mapId(@NonNull String str) {
        this.zzt = str;
        return this;
    }

    @NonNull
    public GoogleMapOptions mapToolbarEnabled(boolean z11) {
        this.zzm = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions mapType(int i11) {
        this.zzd = i11;
        return this;
    }

    @NonNull
    public GoogleMapOptions maxZoomPreference(float f11) {
        this.zzp = Float.valueOf(f11);
        return this;
    }

    @NonNull
    public GoogleMapOptions minZoomPreference(float f11) {
        this.zzo = Float.valueOf(f11);
        return this;
    }

    @NonNull
    public GoogleMapOptions rotateGesturesEnabled(boolean z11) {
        this.zzk = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions scrollGesturesEnabled(boolean z11) {
        this.zzh = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
        this.zzr = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions tiltGesturesEnabled(boolean z11) {
        this.zzj = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.zzd)).add("LiteMode", this.zzl).add("Camera", this.zze).add("CompassEnabled", this.zzg).add("ZoomControlsEnabled", this.zzf).add("ScrollGesturesEnabled", this.zzh).add("ZoomGesturesEnabled", this.zzi).add("TiltGesturesEnabled", this.zzj).add("RotateGesturesEnabled", this.zzk).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzr).add("MapToolbarEnabled", this.zzm).add("AmbientEnabled", this.zzn).add("MinZoomPreference", this.zzo).add("MaxZoomPreference", this.zzp).add("BackgroundColor", this.zzs).add("LatLngBoundsForCameraTarget", this.zzq).add("ZOrderOnTop", this.zzb).add("UseViewLifecycleInFragment", this.zzc).toString();
    }

    @NonNull
    public GoogleMapOptions useViewLifecycleInFragment(boolean z11) {
        this.zzc = Boolean.valueOf(z11);
        return this;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, zza.zza(this.zzb));
        SafeParcelWriter.writeByte(parcel, 3, zza.zza(this.zzc));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i11, false);
        SafeParcelWriter.writeByte(parcel, 6, zza.zza(this.zzf));
        SafeParcelWriter.writeByte(parcel, 7, zza.zza(this.zzg));
        SafeParcelWriter.writeByte(parcel, 8, zza.zza(this.zzh));
        SafeParcelWriter.writeByte(parcel, 9, zza.zza(this.zzi));
        SafeParcelWriter.writeByte(parcel, 10, zza.zza(this.zzj));
        SafeParcelWriter.writeByte(parcel, 11, zza.zza(this.zzk));
        SafeParcelWriter.writeByte(parcel, 12, zza.zza(this.zzl));
        SafeParcelWriter.writeByte(parcel, 14, zza.zza(this.zzm));
        SafeParcelWriter.writeByte(parcel, 15, zza.zza(this.zzn));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i11, false);
        SafeParcelWriter.writeByte(parcel, 19, zza.zza(this.zzr));
        SafeParcelWriter.writeIntegerObject(parcel, 20, getBackgroundColor(), false);
        SafeParcelWriter.writeString(parcel, 21, getMapId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public GoogleMapOptions zOrderOnTop(boolean z11) {
        this.zzb = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions zoomControlsEnabled(boolean z11) {
        this.zzf = Boolean.valueOf(z11);
        return this;
    }

    @NonNull
    public GoogleMapOptions zoomGesturesEnabled(boolean z11) {
        this.zzi = Boolean.valueOf(z11);
        return this;
    }

    @SafeParcelable.Constructor
    public GoogleMapOptions(@SafeParcelable.Param(id = 2) byte b11, @SafeParcelable.Param(id = 3) byte b12, @SafeParcelable.Param(id = 4) int i11, @SafeParcelable.Param(id = 5) @Nullable CameraPosition cameraPosition, @SafeParcelable.Param(id = 6) byte b13, @SafeParcelable.Param(id = 7) byte b14, @SafeParcelable.Param(id = 8) byte b15, @SafeParcelable.Param(id = 9) byte b16, @SafeParcelable.Param(id = 10) byte b17, @SafeParcelable.Param(id = 11) byte b18, @SafeParcelable.Param(id = 12) byte b19, @SafeParcelable.Param(id = 14) byte b21, @SafeParcelable.Param(id = 15) byte b22, @SafeParcelable.Param(id = 16) @Nullable Float f11, @SafeParcelable.Param(id = 17) @Nullable Float f12, @SafeParcelable.Param(id = 18) @Nullable LatLngBounds latLngBounds, @SafeParcelable.Param(id = 19) byte b23, @SafeParcelable.Param(id = 20) @ColorInt @Nullable Integer num, @SafeParcelable.Param(id = 21) @Nullable String str) {
        this.zzb = zza.zzb(b11);
        this.zzc = zza.zzb(b12);
        this.zzd = i11;
        this.zze = cameraPosition;
        this.zzf = zza.zzb(b13);
        this.zzg = zza.zzb(b14);
        this.zzh = zza.zzb(b15);
        this.zzi = zza.zzb(b16);
        this.zzj = zza.zzb(b17);
        this.zzk = zza.zzb(b18);
        this.zzl = zza.zzb(b19);
        this.zzm = zza.zzb(b21);
        this.zzn = zza.zzb(b22);
        this.zzo = f11;
        this.zzp = f12;
        this.zzq = latLngBounds;
        this.zzr = zza.zzb(b23);
        this.zzs = num;
        this.zzt = str;
    }
}
