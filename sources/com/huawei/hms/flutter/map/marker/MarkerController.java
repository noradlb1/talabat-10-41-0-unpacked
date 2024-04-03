package com.huawei.hms.flutter.map.marker;

import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.animation.AnimationSet;

class MarkerController implements MarkerMethods {
    private final boolean clusterable;
    private final String mapMarkerId;
    private final Marker marker;

    public MarkerController(Marker marker2, boolean z11) {
        this.marker = marker2;
        this.mapMarkerId = marker2.getId();
        this.clusterable = z11;
    }

    public void delete() {
        this.marker.remove();
    }

    public String getMapMarkerId() {
        return this.mapMarkerId;
    }

    public void hideInfoWindow() {
        this.marker.hideInfoWindow();
    }

    public boolean isClickable() {
        return this.marker.isClickable();
    }

    public boolean isClusterable() {
        return this.clusterable;
    }

    public boolean isInfoWindowShown() {
        return this.marker.isInfoWindowShown();
    }

    public void setAlpha(float f11) {
        this.marker.setAlpha(f11);
    }

    public void setAnchor(float f11, float f12) {
        this.marker.setMarkerAnchor(f11, f12);
    }

    public void setAnimationSet(AnimationSet animationSet) {
        this.marker.setAnimation(animationSet);
    }

    public void setClickable(boolean z11) {
        this.marker.setClickable(z11);
    }

    public void setClusterable(boolean z11) {
    }

    public void setDraggable(boolean z11) {
        this.marker.setDraggable(z11);
    }

    public void setFlat(boolean z11) {
        this.marker.setFlat(z11);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.marker.setIcon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float f11, float f12) {
        this.marker.setInfoWindowAnchor(f11, f12);
    }

    public void setInfoWindowText(String str, String str2) {
        this.marker.setTitle(str);
        this.marker.setSnippet(str2);
    }

    public void setPosition(LatLng latLng) {
        this.marker.setPosition(latLng);
    }

    public void setRotation(float f11) {
        this.marker.setRotation(f11);
    }

    public void setVisible(boolean z11) {
        this.marker.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.marker.setZIndex(f11);
    }

    public void showInfoWindow() {
        this.marker.showInfoWindow();
    }

    public void startAnimation() {
        this.marker.startAnimation();
    }
}
