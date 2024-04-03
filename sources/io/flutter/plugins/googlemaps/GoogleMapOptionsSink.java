package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Map;

interface GoogleMapOptionsSink {
    void setBuildingsEnabled(boolean z11);

    void setCameraTargetBounds(LatLngBounds latLngBounds);

    void setCompassEnabled(boolean z11);

    void setIndoorEnabled(boolean z11);

    void setInitialCircles(Object obj);

    void setInitialMarkers(Object obj);

    void setInitialPolygons(Object obj);

    void setInitialPolylines(Object obj);

    void setInitialTileOverlays(List<Map<String, ?>> list);

    void setLiteModeEnabled(boolean z11);

    void setMapToolbarEnabled(boolean z11);

    void setMapType(int i11);

    void setMinMaxZoomPreference(Float f11, Float f12);

    void setMyLocationButtonEnabled(boolean z11);

    void setMyLocationEnabled(boolean z11);

    void setPadding(float f11, float f12, float f13, float f14);

    void setRotateGesturesEnabled(boolean z11);

    void setScrollGesturesEnabled(boolean z11);

    void setTiltGesturesEnabled(boolean z11);

    void setTrackCameraPosition(boolean z11);

    void setTrafficEnabled(boolean z11);

    void setZoomControlsEnabled(boolean z11);

    void setZoomGesturesEnabled(boolean z11);
}
