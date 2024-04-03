package com.huawei.hms.flutter.map.polyline;

import com.huawei.hms.maps.model.Cap;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public interface PolylineMethods {
    void delete();

    void setClickable(boolean z11);

    void setColor(int i11);

    void setColorValues(List<Integer> list);

    void setEndCap(Cap cap);

    void setGeodesic(boolean z11);

    void setGradient(boolean z11);

    void setJointType(int i11);

    void setPattern(List<PatternItem> list);

    void setPoints(List<LatLng> list);

    void setStartCap(Cap cap);

    void setVisible(boolean z11);

    void setWidth(float f11);

    void setZIndex(float f11);
}
