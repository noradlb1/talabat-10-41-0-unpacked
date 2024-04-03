package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;

interface MarkerOptionsSink {
    void setAlpha(float f11);

    void setAnchor(float f11, float f12);

    void setConsumeTapEvents(boolean z11);

    void setDraggable(boolean z11);

    void setFlat(boolean z11);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setInfoWindowAnchor(float f11, float f12);

    void setInfoWindowText(String str, String str2);

    void setPosition(LatLng latLng);

    void setRotation(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
