package com.huawei.hms.flutter.map.groundoverlay;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.GroundOverlay;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;

public class GroundOverlayController implements GroundOverlayMethods {
    private final boolean clickable;
    private final GroundOverlay groundOverlay;
    private final String mapGroundOverlayId;

    public GroundOverlayController(GroundOverlay groundOverlay2, boolean z11) {
        this.groundOverlay = groundOverlay2;
        this.clickable = z11;
        this.mapGroundOverlayId = groundOverlay2.getId();
    }

    public void delete() {
        this.groundOverlay.remove();
    }

    public String getMapGroundOverlayId() {
        return this.mapGroundOverlayId;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setAnchor(float f11, float f12) {
    }

    public void setBearing(float f11) {
        this.groundOverlay.setBearing(f11);
    }

    public void setClickable(boolean z11) {
        this.groundOverlay.setClickable(z11);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        this.groundOverlay.setImage(bitmapDescriptor);
    }

    public void setPosition(LatLng latLng, float f11, float f12) {
        this.groundOverlay.setPosition(latLng);
        this.groundOverlay.setDimensions(f11, f12);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.groundOverlay.setPositionFromBounds(latLngBounds);
    }

    public void setTransparency(float f11) {
        this.groundOverlay.setTransparency(f11);
    }

    public void setVisible(boolean z11) {
        this.groundOverlay.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.groundOverlay.setZIndex(f11);
    }
}
