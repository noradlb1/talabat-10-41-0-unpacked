package com.huawei.hms.flutter.map.circle;

import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.animation.Animation;
import java.util.List;

class CircleBuilder implements CircleMethods {
    private Animation animation;
    private final CircleOptions circleOptions = new CircleOptions();
    private boolean clickable;
    private final float compactness;

    public CircleBuilder(float f11) {
        this.compactness = f11;
    }

    public CircleOptions build() {
        return this.circleOptions;
    }

    public void delete() {
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setAnimation(Animation animation2) {
        this.animation = animation2;
    }

    public void setCenter(LatLng latLng) {
        this.circleOptions.center(latLng);
    }

    public void setClickable(boolean z11) {
        this.clickable = z11;
        this.circleOptions.clickable(z11);
    }

    public void setFillColor(int i11) {
        this.circleOptions.fillColor(i11);
    }

    public void setRadius(double d11) {
        this.circleOptions.radius(d11);
    }

    public void setStrokeColor(int i11) {
        this.circleOptions.strokeColor(i11);
    }

    public void setStrokePattern(List<PatternItem> list) {
        this.circleOptions.strokePattern(list);
    }

    public void setStrokeWidth(float f11) {
        this.circleOptions.strokeWidth(f11 * this.compactness);
    }

    public void setVisible(boolean z11) {
        this.circleOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.circleOptions.zIndex(f11);
    }

    public void startAnimation() {
    }
}
