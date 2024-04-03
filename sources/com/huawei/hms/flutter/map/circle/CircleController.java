package com.huawei.hms.flutter.map.circle;

import com.huawei.hms.maps.model.Circle;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.animation.Animation;
import java.util.List;

class CircleController implements CircleMethods {
    private final Circle circle;
    private final float compactness;
    private final String idOnMap;
    private boolean isClickable;

    public CircleController(Circle circle2, boolean z11, float f11) {
        this.circle = circle2;
        this.isClickable = z11;
        this.compactness = f11;
        this.idOnMap = circle2.getId();
    }

    public void delete() {
        this.circle.remove();
    }

    public String getIdOnMap() {
        return this.idOnMap;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public void setAnimation(Animation animation) {
        this.circle.setAnimation(animation);
    }

    public void setCenter(LatLng latLng) {
        this.circle.setCenter(latLng);
    }

    public void setClickable(boolean z11) {
        this.isClickable = z11;
        this.circle.setClickable(z11);
    }

    public void setFillColor(int i11) {
        this.circle.setFillColor(i11);
    }

    public void setRadius(double d11) {
        this.circle.setRadius(d11);
    }

    public void setStrokeColor(int i11) {
        this.circle.setStrokeColor(i11);
    }

    public void setStrokePattern(List<PatternItem> list) {
        this.circle.setStrokePattern(list);
    }

    public void setStrokeWidth(float f11) {
        this.circle.setStrokeWidth(f11 * this.compactness);
    }

    public void setVisible(boolean z11) {
        this.circle.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.circle.setZIndex(f11);
    }

    public void startAnimation() {
        this.circle.startAnimation();
    }
}
