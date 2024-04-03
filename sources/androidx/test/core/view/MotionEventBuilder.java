package androidx.test.core.view;

import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

public class MotionEventBuilder {
    private int action = 0;
    private int actionIndex = -1;
    private int buttonState = 0;
    private int deviceId = 0;
    private long downTime = 0;
    private int edgeFlags = 0;
    private long eventTime = SystemClock.uptimeMillis();
    private int flags = 0;
    private int metaState = 0;
    private List<MotionEvent.PointerCoords> pointerCoordsList = new ArrayList();
    private List<MotionEvent.PointerProperties> pointerPropertiesList = new ArrayList();
    private int source = 0;
    private float xPrecision = 0.0f;
    private float yPrecision = 0.0f;

    private MotionEventBuilder() {
    }

    private static void checkState(boolean z11, String str) {
        if (!z11) {
            throw new IllegalStateException(str);
        }
    }

    public static MotionEventBuilder newBuilder() {
        return new MotionEventBuilder();
    }

    public MotionEvent build() {
        if (this.pointerPropertiesList.size() == 0) {
            setPointer(0.0f, 0.0f);
        }
        int i11 = this.actionIndex;
        if (i11 != -1) {
            this.action = (i11 << 8) | this.action;
        }
        long j11 = this.downTime;
        long j12 = this.eventTime;
        int i12 = this.action;
        int size = this.pointerPropertiesList.size();
        List<MotionEvent.PointerProperties> list = this.pointerPropertiesList;
        List<MotionEvent.PointerCoords> list2 = this.pointerCoordsList;
        return MotionEvent.obtain(j11, j12, i12, size, (MotionEvent.PointerProperties[]) list.toArray(new MotionEvent.PointerProperties[list.size()]), (MotionEvent.PointerCoords[]) list2.toArray(new MotionEvent.PointerCoords[list2.size()]), this.metaState, this.buttonState, this.xPrecision, this.yPrecision, this.deviceId, this.edgeFlags, this.source, this.flags);
    }

    public MotionEventBuilder setAction(int i11) {
        this.action = i11;
        return this;
    }

    public MotionEventBuilder setActionIndex(int i11) {
        boolean z11;
        if (i11 <= 255) {
            z11 = true;
        } else {
            z11 = false;
        }
        checkState(z11, "pointerIndex must be less than 0xff");
        this.actionIndex = i11;
        return this;
    }

    public MotionEventBuilder setButtonState(int i11) {
        this.buttonState = i11;
        return this;
    }

    public MotionEventBuilder setDeviceId(int i11) {
        this.deviceId = i11;
        return this;
    }

    public MotionEventBuilder setDownTime(long j11) {
        this.downTime = j11;
        return this;
    }

    public MotionEventBuilder setEdgeFlags(int i11) {
        this.edgeFlags = i11;
        return this;
    }

    public MotionEventBuilder setEventTime(long j11) {
        this.eventTime = j11;
        return this;
    }

    public MotionEventBuilder setFlags(int i11) {
        this.flags = i11;
        return this;
    }

    public MotionEventBuilder setMetaState(int i11) {
        this.metaState = i11;
        return this;
    }

    public MotionEventBuilder setPointer(float f11, float f12) {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.pointerPropertiesList.size();
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f11;
        pointerCoords.y = f12;
        return setPointer(pointerProperties, pointerCoords);
    }

    public MotionEventBuilder setSource(int i11) {
        this.source = i11;
        return this;
    }

    public MotionEventBuilder setXPrecision(float f11) {
        this.xPrecision = f11;
        return this;
    }

    public MotionEventBuilder setYPrecision(float f11) {
        this.yPrecision = f11;
        return this;
    }

    public MotionEventBuilder setPointer(MotionEvent.PointerProperties pointerProperties, MotionEvent.PointerCoords pointerCoords) {
        this.pointerPropertiesList.add(pointerProperties);
        this.pointerCoordsList.add(pointerCoords);
        return this;
    }
}
