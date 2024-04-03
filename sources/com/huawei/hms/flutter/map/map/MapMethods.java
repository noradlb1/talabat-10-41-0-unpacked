package com.huawei.hms.flutter.map.map;

import android.graphics.Point;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MyLocationStyle;
import java.util.HashMap;
import java.util.List;

public interface MapMethods {
    void setAllGesturesEnabled(Boolean bool);

    void setBuildingsEnabled(boolean z11);

    void setCameraTargetBounds(LatLngBounds latLngBounds);

    void setCircles(List<HashMap<String, Object>> list);

    void setClusterMarkerColor(Integer num);

    void setClusterMarkerIcon(BitmapDescriptor bitmapDescriptor);

    void setClusterMarkerTextColor(Integer num);

    void setCompassEnabled(boolean z11);

    void setDark(boolean z11);

    void setGestureScaleByMapCenter(boolean z11);

    void setGroundOverlays(List<HashMap<String, Object>> list);

    void setHeatMaps(List<HashMap<String, Object>> list);

    void setLiteMode(Boolean bool);

    void setLogoPadding(int i11, int i12, int i13, int i14);

    void setLogoPosition(int i11);

    void setMapToolbarEnabled(boolean z11);

    void setMapType(int i11);

    void setMarkers(List<HashMap<String, Object>> list);

    void setMarkersClustering(boolean z11);

    void setMinMaxZoomPreference(Float f11, Float f12);

    void setMyLocationButtonEnabled(boolean z11);

    void setMyLocationEnabled(boolean z11);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setPadding(float f11, float f12, float f13, float f14);

    void setPointToCenter(Point point);

    void setPolygons(List<HashMap<String, Object>> list);

    void setPolylines(List<HashMap<String, Object>> list);

    void setPreviewId(String str);

    void setRotateGesturesEnabled(boolean z11);

    void setScrollGesturesEnabled(boolean z11);

    void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11);

    void setStyleId(String str);

    void setTileOverlays(List<HashMap<String, Object>> list);

    void setTiltGesturesEnabled(boolean z11);

    void setTrackCameraPosition(boolean z11);

    void setTrafficEnabled(boolean z11);

    void setZoomControlsEnabled(boolean z11);

    void setZoomGesturesEnabled(boolean z11);
}
