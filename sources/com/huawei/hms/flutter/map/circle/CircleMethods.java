package com.huawei.hms.flutter.map.circle;

import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.animation.Animation;
import java.util.List;

public interface CircleMethods {
    void delete();

    boolean isClickable();

    void setAnimation(Animation animation);

    void setCenter(LatLng latLng);

    void setClickable(boolean z11);

    void setFillColor(int i11);

    void setRadius(double d11);

    void setStrokeColor(int i11);

    void setStrokePattern(List<PatternItem> list);

    void setStrokeWidth(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);

    void startAnimation();
}
