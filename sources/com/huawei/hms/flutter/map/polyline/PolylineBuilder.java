package com.huawei.hms.flutter.map.polyline;

import com.huawei.hms.maps.model.Cap;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.PolylineOptions;
import java.util.List;

class PolylineBuilder implements PolylineMethods {
    private boolean clickable;
    private final float compactness;
    private final PolylineOptions polylineOptions = new PolylineOptions();

    public PolylineBuilder(float f11) {
        this.compactness = f11;
    }

    public PolylineOptions build() {
        return this.polylineOptions;
    }

    public void delete() {
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.polylineOptions.clickable(z11);
    }

    public void setColor(int i11) {
        this.polylineOptions.color(i11);
    }

    public void setColorValues(List<Integer> list) {
        this.polylineOptions.colorValues(list);
    }

    public void setEndCap(Cap cap) {
        this.polylineOptions.endCap(cap);
    }

    public void setGeodesic(boolean z11) {
        this.polylineOptions.geodesic(z11);
    }

    public void setGradient(boolean z11) {
        this.polylineOptions.gradient(z11);
    }

    public void setJointType(int i11) {
        this.polylineOptions.jointType(i11);
    }

    public void setPattern(List<PatternItem> list) {
        this.polylineOptions.pattern(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polylineOptions.addAll(list);
    }

    public void setStartCap(Cap cap) {
        this.polylineOptions.startCap(cap);
    }

    public void setVisible(boolean z11) {
        this.polylineOptions.visible(z11);
    }

    public void setWidth(float f11) {
        this.polylineOptions.width(f11 * this.compactness);
    }

    public void setZIndex(float f11) {
        this.polylineOptions.zIndex(f11);
    }
}
