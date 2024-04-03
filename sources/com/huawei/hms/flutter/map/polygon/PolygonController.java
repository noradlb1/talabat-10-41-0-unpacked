package com.huawei.hms.flutter.map.polygon;

import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.Polygon;
import java.util.List;

class PolygonController implements PolygonMethods {
    private boolean clickable;
    private final float compactness;
    private final String mapPolygonId;
    private final Polygon polygon;

    public PolygonController(Polygon polygon2, boolean z11, float f11) {
        this.polygon = polygon2;
        this.compactness = f11;
        this.clickable = z11;
        this.mapPolygonId = polygon2.getId();
    }

    public void delete() {
        this.polygon.remove();
    }

    public String getMapPolygonId() {
        return this.mapPolygonId;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.polygon.setClickable(z11);
    }

    public void setFillColor(int i11) {
        this.polygon.setFillColor(i11);
    }

    public void setGeodesic(boolean z11) {
        this.polygon.setGeodesic(z11);
    }

    public void setHoles(List<List<LatLng>> list) {
        this.polygon.setHoles(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polygon.setPoints(list);
    }

    public void setStrokeColor(int i11) {
        this.polygon.setStrokeColor(i11);
    }

    public void setStrokeJointType(int i11) {
        this.polygon.setStrokeJointType(i11);
    }

    public void setStrokePattern(List<PatternItem> list) {
        this.polygon.setStrokePattern(list);
    }

    public void setStrokeWidth(float f11) {
        this.polygon.setStrokeWidth(f11 * this.compactness);
    }

    public void setVisible(boolean z11) {
        this.polygon.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.polygon.setZIndex(f11);
    }
}
