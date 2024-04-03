package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

interface PolylineOptionsSink {
    void setColor(int i11);

    void setConsumeTapEvents(boolean z11);

    void setEndCap(Cap cap);

    void setGeodesic(boolean z11);

    void setJointType(int i11);

    void setPattern(List<PatternItem> list);

    void setPoints(List<LatLng> list);

    void setStartCap(Cap cap);

    void setVisible(boolean z11);

    void setWidth(float f11);

    void setZIndex(float f11);
}
