package com.huawei.hms.flutter.map.polygon;

import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.PolygonOptions;
import java.util.List;

class PolygonBuilder implements PolygonMethods {
    private boolean clickable;
    private final float compactness;
    private final PolygonOptions polygonOptions = new PolygonOptions();

    public PolygonBuilder(float f11) {
        this.compactness = f11;
    }

    public PolygonOptions build() {
        return this.polygonOptions;
    }

    public void delete() {
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.polygonOptions.clickable(z11);
    }

    public void setFillColor(int i11) {
        this.polygonOptions.fillColor(i11);
    }

    public void setGeodesic(boolean z11) {
        this.polygonOptions.geodesic(z11);
    }

    public void setHoles(List<List<LatLng>> list) {
        for (List<LatLng> addHole : list) {
            this.polygonOptions.addHole(addHole);
        }
    }

    public void setPoints(List<LatLng> list) {
        this.polygonOptions.addAll(list);
    }

    public void setStrokeColor(int i11) {
        this.polygonOptions.strokeColor(i11);
    }

    public void setStrokeJointType(int i11) {
        this.polygonOptions.strokeJointType(i11);
    }

    public void setStrokePattern(List<PatternItem> list) {
        this.polygonOptions.strokePattern(list);
    }

    public void setStrokeWidth(float f11) {
        this.polygonOptions.strokeWidth(f11 * this.compactness);
    }

    public void setVisible(boolean z11) {
        this.polygonOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.polygonOptions.zIndex(f11);
    }
}
