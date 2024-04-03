package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

class CircleBuilder implements CircleOptionsSink {
    private final CircleOptions circleOptions = new CircleOptions();
    private boolean consumeTapEvents;
    private final float density;

    public CircleBuilder(float f11) {
        this.density = f11;
    }

    public CircleOptions a() {
        return this.circleOptions;
    }

    public boolean b() {
        return this.consumeTapEvents;
    }

    public void setCenter(LatLng latLng) {
        this.circleOptions.center(latLng);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
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

    public void setStrokeWidth(float f11) {
        this.circleOptions.strokeWidth(f11 * this.density);
    }

    public void setVisible(boolean z11) {
        this.circleOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.circleOptions.zIndex(f11);
    }
}
