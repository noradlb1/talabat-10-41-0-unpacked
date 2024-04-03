package com.huawei.hms.flutter.map.polyline;

import com.huawei.hms.maps.model.Cap;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.Polyline;
import java.util.List;

class PolylineController implements PolylineMethods {
    private boolean clickable;
    private final float compactness;
    private final String mapPolylineId;
    private final Polyline polyline;

    public PolylineController(Polyline polyline2, boolean z11, float f11) {
        this.polyline = polyline2;
        this.clickable = z11;
        this.compactness = f11;
        this.mapPolylineId = polyline2.getId();
    }

    public void delete() {
        this.polyline.remove();
    }

    public String getMapPolylineId() {
        return this.mapPolylineId;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.polyline.setClickable(z11);
    }

    public void setColor(int i11) {
        this.polyline.setColor(i11);
    }

    public void setColorValues(List<Integer> list) {
        this.polyline.setColorValues(list);
    }

    public void setEndCap(Cap cap) {
        this.polyline.setEndCap(cap);
    }

    public void setGeodesic(boolean z11) {
        this.polyline.setGeodesic(z11);
    }

    public void setGradient(boolean z11) {
        this.polyline.setGradient(z11);
    }

    public void setJointType(int i11) {
        this.polyline.setJointType(i11);
    }

    public void setPattern(List<PatternItem> list) {
        this.polyline.setPattern(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polyline.setPoints(list);
    }

    public void setStartCap(Cap cap) {
        this.polyline.setStartCap(cap);
    }

    public void setVisible(boolean z11) {
        this.polyline.setVisible(z11);
    }

    public void setWidth(float f11) {
        this.polyline.setWidth(f11 * this.compactness);
    }

    public void setZIndex(float f11) {
        this.polyline.setZIndex(f11);
    }
}
