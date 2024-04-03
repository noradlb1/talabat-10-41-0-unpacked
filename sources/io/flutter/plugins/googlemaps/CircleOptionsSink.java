package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;

interface CircleOptionsSink {
    void setCenter(LatLng latLng);

    void setConsumeTapEvents(boolean z11);

    void setFillColor(int i11);

    void setRadius(double d11);

    void setStrokeColor(int i11);

    void setStrokeWidth(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
