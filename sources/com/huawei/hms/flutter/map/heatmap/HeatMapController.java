package com.huawei.hms.flutter.map.heatmap;

import android.content.Context;
import com.huawei.hms.maps.model.HeatMap;
import com.huawei.hms.maps.model.HeatMapOptions;
import java.util.Map;

class HeatMapController implements HeatMapMethods {
    private final Context context;
    private final HeatMap heatMap;
    private final String heatMapId;

    public HeatMapController(HeatMap heatMap2, Context context2) {
        this.context = context2;
        this.heatMap = heatMap2;
        this.heatMapId = heatMap2.getId();
    }

    public void delete() {
        this.heatMap.remove();
    }

    public String getHeatMapId() {
        return this.heatMapId;
    }

    public void setColor(Map<Float, Integer> map) {
        this.heatMap.setColor(map);
    }

    public void setDataSet(int i11) {
        this.heatMap.changeDataSet(this.context, i11);
    }

    public void setIntensity(float f11) {
        this.heatMap.setIntensity(Float.valueOf(f11));
    }

    public void setOpacity(float f11) {
        this.heatMap.setOpacity(Float.valueOf(f11));
    }

    public void setRadius(float f11) {
        this.heatMap.setRadius(Float.valueOf(f11));
    }

    public void setRadiusUnit(HeatMapOptions.RadiusUnit radiusUnit) {
        this.heatMap.setRadiusUnit(radiusUnit);
    }

    public void setResourceId(int i11) {
    }

    public void setVisible(boolean z11) {
        this.heatMap.setVisible(z11);
    }

    public void setDataSet(String str) {
        this.heatMap.changeDataSet(str);
    }

    public void setIntensity(Map<Float, Float> map) {
        this.heatMap.setIntensity(map);
    }

    public void setOpacity(Map<Float, Float> map) {
        this.heatMap.setOpacity(map);
    }

    public void setRadius(Map<Float, Float> map) {
        this.heatMap.setRadius(map);
    }
}
