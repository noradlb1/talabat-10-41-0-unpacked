package com.huawei.hms.flutter.map.marker;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.animation.AnimationSet;

public interface MarkerMethods {
    void delete();

    void setAlpha(float f11);

    void setAnchor(float f11, float f12);

    void setAnimationSet(AnimationSet animationSet);

    void setClickable(boolean z11);

    void setClusterable(boolean z11);

    void setDraggable(boolean z11);

    void setFlat(boolean z11);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setInfoWindowAnchor(float f11, float f12);

    void setInfoWindowText(String str, String str2);

    void setPosition(LatLng latLng);

    void setRotation(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);

    void startAnimation();
}
