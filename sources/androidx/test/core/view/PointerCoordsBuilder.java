package androidx.test.core.view;

import android.view.MotionEvent;

public class PointerCoordsBuilder {
    private float orientation;
    private float pressure = 1.0f;
    private float size = 1.0f;
    private float toolMajor;
    private float toolMinor;
    private float touchMajor;
    private float touchMinor;

    /* renamed from: x  reason: collision with root package name */
    private float f37686x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    private float f37687y = 0.0f;

    private PointerCoordsBuilder() {
    }

    public static PointerCoordsBuilder newBuilder() {
        return new PointerCoordsBuilder();
    }

    public MotionEvent.PointerCoords build() {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = this.f37686x;
        pointerCoords.y = this.f37687y;
        pointerCoords.pressure = this.pressure;
        pointerCoords.size = this.size;
        pointerCoords.touchMajor = this.touchMajor;
        pointerCoords.touchMinor = this.touchMinor;
        pointerCoords.toolMajor = this.toolMajor;
        pointerCoords.toolMinor = this.toolMinor;
        pointerCoords.orientation = this.orientation;
        return pointerCoords;
    }

    public PointerCoordsBuilder setCoords(float f11, float f12) {
        this.f37686x = f11;
        this.f37687y = f12;
        return this;
    }

    public PointerCoordsBuilder setOrientation(float f11) {
        this.orientation = f11;
        return this;
    }

    public PointerCoordsBuilder setPressure(float f11) {
        this.pressure = f11;
        return this;
    }

    public PointerCoordsBuilder setSize(float f11) {
        this.size = f11;
        return this;
    }

    public PointerCoordsBuilder setTool(float f11, float f12) {
        this.toolMajor = f11;
        this.toolMinor = f12;
        return this;
    }

    public PointerCoordsBuilder setTouch(float f11, float f12) {
        this.touchMajor = f11;
        this.touchMinor = f12;
        return this;
    }
}
