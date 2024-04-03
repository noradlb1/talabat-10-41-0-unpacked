package com.huawei.hms.flutter.map.marker;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.animation.AnimationSet;

class MarkerBuilder implements MarkerMethods {
    private AnimationSet animationSet;
    private final MarkerOptions markerOptions = new MarkerOptions();

    public MarkerOptions build() {
        return this.markerOptions;
    }

    public void delete() {
    }

    public AnimationSet getAnimationSet() {
        return this.animationSet;
    }

    public boolean isClickable() {
        return this.markerOptions.isClickable();
    }

    public boolean isClusterable() {
        return this.markerOptions.ismClusterable();
    }

    public void setAlpha(float f11) {
        this.markerOptions.alpha(f11);
    }

    public void setAnchor(float f11, float f12) {
        this.markerOptions.anchorMarker(f11, f12);
    }

    public void setAnimationSet(AnimationSet animationSet2) {
        this.animationSet = animationSet2;
    }

    public void setClickable(boolean z11) {
        this.markerOptions.clickable(z11);
    }

    public void setClusterable(boolean z11) {
        this.markerOptions.clusterable(z11);
    }

    public void setDraggable(boolean z11) {
        this.markerOptions.draggable(z11);
    }

    public void setFlat(boolean z11) {
        this.markerOptions.flat(z11);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerOptions.icon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float f11, float f12) {
        this.markerOptions.infoWindowAnchor(f11, f12);
    }

    public void setInfoWindowText(String str, String str2) {
        this.markerOptions.title(str);
        this.markerOptions.snippet(str2);
    }

    public void setPosition(LatLng latLng) {
        this.markerOptions.position(latLng);
    }

    public void setRotation(float f11) {
        this.markerOptions.rotation(f11);
    }

    public void setVisible(boolean z11) {
        this.markerOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.markerOptions.zIndex(f11);
    }

    public void startAnimation() {
    }
}
