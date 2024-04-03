package com.huawei.hms.flutter.map.heatmap;

import com.huawei.hms.maps.model.HeatMapOptions;
import java.util.Map;

public interface HeatMapMethods {
    void delete();

    void setColor(Map<Float, Integer> map);

    void setDataSet(int i11);

    void setDataSet(String str);

    void setIntensity(float f11);

    void setIntensity(Map<Float, Float> map);

    void setOpacity(float f11);

    void setOpacity(Map<Float, Float> map);

    void setRadius(float f11);

    void setRadius(Map<Float, Float> map);

    void setRadiusUnit(HeatMapOptions.RadiusUnit radiusUnit);

    void setResourceId(int i11);

    void setVisible(boolean z11);
}
