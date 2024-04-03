package com.google.android.gms.maps.model;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AdvancedMarkerOptions extends MarkerOptions {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface CollisionBehavior {
        public static final int OPTIONAL_AND_HIDES_LOWER_PRIORITY = 2;
        public static final int REQUIRED = 0;
        public static final int REQUIRED_AND_HIDES_OPTIONAL = 1;
    }

    @NonNull
    public AdvancedMarkerOptions alpha(float f11) {
        super.alpha(f11);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions anchor(float f11, float f12) {
        super.anchor(f11, f12);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions collisionBehavior(@CollisionBehavior int i11) {
        super.zzd(i11);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions contentDescription(@Nullable String str) {
        super.contentDescription(str);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions draggable(boolean z11) {
        super.draggable(z11);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions flat(boolean z11) {
        super.flat(z11);
        return this;
    }

    public int getCollisionBehavior() {
        return super.zza();
    }

    @Nullable
    public View getIconView() {
        return super.zzc();
    }

    @NonNull
    public AdvancedMarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor) {
        super.icon(bitmapDescriptor);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions iconView(@Nullable View view) {
        zze(view);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions infoWindowAnchor(float f11, float f12) {
        super.infoWindowAnchor(f11, f12);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions position(@NonNull LatLng latLng) {
        super.position(latLng);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions rotation(float f11) {
        super.rotation(f11);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions snippet(@Nullable String str) {
        super.snippet(str);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions title(@Nullable String str) {
        super.title(str);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions visible(boolean z11) {
        super.visible(z11);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions zIndex(float f11) {
        super.zIndex(f11);
        return this;
    }
}
