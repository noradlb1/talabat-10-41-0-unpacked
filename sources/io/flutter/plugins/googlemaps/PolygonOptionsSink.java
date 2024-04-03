package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

interface PolygonOptionsSink {
    void setConsumeTapEvents(boolean z11);

    void setFillColor(int i11);

    void setGeodesic(boolean z11);

    void setHoles(List<List<LatLng>> list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i11);

    void setStrokeWidth(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
