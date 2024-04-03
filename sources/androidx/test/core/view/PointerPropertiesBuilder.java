package androidx.test.core.view;

import android.view.MotionEvent;

public class PointerPropertiesBuilder {

    /* renamed from: id  reason: collision with root package name */
    private int f37688id;
    private int toolType;

    private PointerPropertiesBuilder() {
    }

    public static PointerPropertiesBuilder newBuilder() {
        return new PointerPropertiesBuilder();
    }

    public MotionEvent.PointerProperties build() {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.f37688id;
        pointerProperties.toolType = this.toolType;
        return pointerProperties;
    }

    public PointerPropertiesBuilder setId(int i11) {
        this.f37688id = i11;
        return this;
    }

    public PointerPropertiesBuilder setToolType(int i11) {
        this.toolType = i11;
        return this;
    }
}
