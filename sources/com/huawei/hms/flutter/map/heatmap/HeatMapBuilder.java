package com.huawei.hms.flutter.map.heatmap;

import com.huawei.hms.maps.model.HeatMapOptions;
import java.util.Map;

class HeatMapBuilder implements HeatMapMethods {
    private final HeatMapOptions heatMapOptions = new HeatMapOptions();

    public HeatMapOptions build() {
        return this.heatMapOptions;
    }

    public void delete() {
    }

    public void setColor(Map<Float, Integer> map) {
        this.heatMapOptions.color(map);
    }

    public void setDataSet(int i11) {
        this.heatMapOptions.dataSet(i11);
    }

    public void setIntensity(float f11) {
        this.heatMapOptions.intensity(f11);
    }

    public void setOpacity(float f11) {
        this.heatMapOptions.opacity(f11);
    }

    public void setRadius(float f11) {
        this.heatMapOptions.radius(f11);
    }

    public void setRadiusUnit(HeatMapOptions.RadiusUnit radiusUnit) {
        this.heatMapOptions.radiusUnit(radiusUnit);
    }

    public void setResourceId(int i11) {
        this.heatMapOptions.setResourceId(i11);
    }

    public void setVisible(boolean z11) {
        this.heatMapOptions.visible(z11);
    }

    public void setDataSet(String str) {
        this.heatMapOptions.dataSet(str);
    }

    public void setIntensity(Map<Float, Float> map) {
        this.heatMapOptions.intensity(map);
    }

    public void setOpacity(Map<Float, Float> map) {
        this.heatMapOptions.opacity(map);
    }

    public void setRadius(Map<Float, Float> map) {
        this.heatMapOptions.radius(map);
    }
}
