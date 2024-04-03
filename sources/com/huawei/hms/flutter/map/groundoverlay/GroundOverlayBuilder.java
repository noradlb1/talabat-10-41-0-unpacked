package com.huawei.hms.flutter.map.groundoverlay;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.GroundOverlayOptions;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;

public class GroundOverlayBuilder implements GroundOverlayMethods {
    private boolean clickable;
    private final GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();

    public GroundOverlayOptions build() {
        return this.groundOverlayOptions;
    }

    public void delete() {
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setAnchor(float f11, float f12) {
        this.groundOverlayOptions.anchor(f11, f12);
    }

    public void setBearing(float f11) {
        this.groundOverlayOptions.bearing(f11);
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.groundOverlayOptions.clickable(z11);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        this.groundOverlayOptions.image(bitmapDescriptor);
    }

    public void setPosition(LatLng latLng, float f11, float f12) {
        this.groundOverlayOptions.position(latLng, f11, f12);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.groundOverlayOptions.positionFromBounds(latLngBounds);
    }

    public void setTransparency(float f11) {
        this.groundOverlayOptions.transparency(f11);
    }

    public void setVisible(boolean z11) {
        this.groundOverlayOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.groundOverlayOptions.zIndex(f11);
    }
}
