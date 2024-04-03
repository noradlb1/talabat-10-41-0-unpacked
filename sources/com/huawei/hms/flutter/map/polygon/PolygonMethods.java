package com.huawei.hms.flutter.map.polygon;

import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public interface PolygonMethods {
    void delete();

    void setClickable(boolean z11);

    void setFillColor(int i11);

    void setGeodesic(boolean z11);

    void setHoles(List<List<LatLng>> list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i11);

    void setStrokeJointType(int i11);

    void setStrokePattern(List<PatternItem> list);

    void setStrokeWidth(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
