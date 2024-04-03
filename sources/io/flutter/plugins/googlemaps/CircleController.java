package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;

class CircleController implements CircleOptionsSink {
    private final Circle circle;
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsCircleId;

    public CircleController(Circle circle2, boolean z11, float f11) {
        this.circle = circle2;
        this.consumeTapEvents = z11;
        this.density = f11;
        this.googleMapsCircleId = circle2.getId();
    }

    public boolean a() {
        return this.consumeTapEvents;
    }

    public String b() {
        return this.googleMapsCircleId;
    }

    public void c() {
        this.circle.remove();
    }

    public void setCenter(LatLng latLng) {
        this.circle.setCenter(latLng);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
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

    public void setStrokeWidth(float f11) {
        this.circle.setStrokeWidth(f11 * this.density);
    }

    public void setVisible(boolean z11) {
        this.circle.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.circle.setZIndex(f11);
    }
}
