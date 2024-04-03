package com.huawei.hms.flutter.map.groundoverlay;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;

public interface GroundOverlayMethods {
    void delete();

    boolean isClickable();

    void setAnchor(float f11, float f12);

    void setBearing(float f11);

    void setClickable(boolean z11);

    void setImage(BitmapDescriptor bitmapDescriptor);

    void setPosition(LatLng latLng, float f11, float f12);

    void setPositionFromBounds(LatLngBounds latLngBounds);

    void setTransparency(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
