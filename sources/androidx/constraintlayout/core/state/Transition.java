package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;
import x0.a;
import x0.b;
import x0.c;
import x0.d;
import x0.e;
import x0.f;
import x0.g;
import x0.h;

public class Transition implements TypedValues {
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, HashMap<String, KeyPosition>> f10720a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public TypedBundle f10721b = new TypedBundle();
    private int mAutoTransition = 0;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDuration = 400;
    private Easing mEasing = null;
    private float mStagger = 0.0f;
    private HashMap<String, WidgetState> state = new HashMap<>();

    public static class KeyPosition {

        /* renamed from: a  reason: collision with root package name */
        public int f10722a;

        /* renamed from: b  reason: collision with root package name */
        public String f10723b;

        /* renamed from: c  reason: collision with root package name */
        public int f10724c;

        /* renamed from: d  reason: collision with root package name */
        public float f10725d;

        /* renamed from: e  reason: collision with root package name */
        public float f10726e;

        public KeyPosition(String str, int i11, int i12, float f11, float f12) {
            this.f10723b = str;
            this.f10722a = i11;
            this.f10724c = i12;
            this.f10725d = f11;
            this.f10726e = f12;
        }
    }

    public static class WidgetState {

        /* renamed from: a  reason: collision with root package name */
        public WidgetFrame f10727a = new WidgetFrame();

        /* renamed from: b  reason: collision with root package name */
        public WidgetFrame f10728b = new WidgetFrame();

        /* renamed from: c  reason: collision with root package name */
        public WidgetFrame f10729c = new WidgetFrame();

        /* renamed from: d  reason: collision with root package name */
        public Motion f10730d;

        /* renamed from: e  reason: collision with root package name */
        public MotionWidget f10731e = new MotionWidget(this.f10727a);

        /* renamed from: f  reason: collision with root package name */
        public MotionWidget f10732f = new MotionWidget(this.f10728b);

        /* renamed from: g  reason: collision with root package name */
        public MotionWidget f10733g = new MotionWidget(this.f10729c);

        /* renamed from: h  reason: collision with root package name */
        public KeyCache f10734h = new KeyCache();

        /* renamed from: i  reason: collision with root package name */
        public int f10735i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f10736j = -1;

        public WidgetState() {
            Motion motion = new Motion(this.f10731e);
            this.f10730d = motion;
            motion.setStart(this.f10731e);
            this.f10730d.setEnd(this.f10732f);
        }

        public WidgetFrame getFrame(int i11) {
            if (i11 == 0) {
                return this.f10727a;
            }
            if (i11 == 1) {
                return this.f10728b;
            }
            return this.f10729c;
        }

        public void interpolate(int i11, int i12, float f11, Transition transition) {
            this.f10735i = i12;
            this.f10736j = i11;
            this.f10730d.setup(i11, i12, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(i11, i12, this.f10729c, this.f10727a, this.f10728b, transition, f11);
            this.f10729c.interpolatedPos = f11;
            this.f10730d.interpolate(this.f10733g, f11, System.nanoTime(), this.f10734h);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta((TypedValues) motionKeyAttributes);
            this.f10730d.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta((TypedValues) motionKeyCycle);
            this.f10730d.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta((TypedValues) motionKeyPosition);
            this.f10730d.addKey(motionKeyPosition);
        }

        public void update(ConstraintWidget constraintWidget, int i11) {
            if (i11 == 0) {
                this.f10727a.update(constraintWidget);
                this.f10730d.setStart(this.f10731e);
            } else if (i11 == 1) {
                this.f10728b.update(constraintWidget);
                this.f10730d.setEnd(this.f10732f);
            }
            this.f10736j = -1;
        }
    }

    public static Interpolator getInterpolator(int i11, String str) {
        switch (i11) {
            case -1:
                return new a(str);
            case 0:
                return new b();
            case 1:
                return new c();
            case 2:
                return new d();
            case 3:
                return new e();
            case 4:
                return new h();
            case 5:
                return new g();
            case 6:
                return new f();
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str) {
        return this.state.get(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$0(String str, float f11) {
        return (float) Easing.getInterpolator(str).get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$1(float f11) {
        return (float) Easing.getInterpolator("standard").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$2(float f11) {
        return (float) Easing.getInterpolator("accelerate").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$3(float f11) {
        return (float) Easing.getInterpolator("decelerate").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$4(float f11) {
        return (float) Easing.getInterpolator("linear").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$5(float f11) {
        return (float) Easing.getInterpolator("anticipate").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$6(float f11) {
        return (float) Easing.getInterpolator("overshoot").get((double) f11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$7(float f11) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get((double) f11);
    }

    public void addCustomColor(int i11, String str, String str2, int i12) {
        getWidgetState(str, (ConstraintWidget) null, i11).getFrame(i11).addCustomColor(str2, i12);
    }

    public void addCustomFloat(int i11, String str, String str2, float f11) {
        getWidgetState(str, (ConstraintWidget) null, i11).getFrame(i11).addCustomFloat(str2, f11);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
    }

    public void clear() {
        this.state.clear();
    }

    public boolean contains(String str) {
        return this.state.containsKey(str);
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i11 = 0;
        for (int i12 = 0; i12 <= 100; i12++) {
            HashMap hashMap = this.f10720a.get(Integer.valueOf(i12));
            if (!(hashMap == null || (keyPosition = (KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                fArr[i11] = keyPosition.f10725d;
                fArr2[i11] = keyPosition.f10726e;
                fArr3[i11] = (float) keyPosition.f10722a;
                i11++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i11) {
        KeyPosition keyPosition;
        while (i11 <= 100) {
            HashMap hashMap = this.f10720a.get(Integer.valueOf(i11));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i11++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i11) {
        KeyPosition keyPosition;
        while (i11 >= 0) {
            HashMap hashMap = this.f10720a.get(Integer.valueOf(i11));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i11--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f10728b;
    }

    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f10729c;
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.state.get(str).f10730d.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, (ConstraintWidget) null, 0).f10730d;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i11 = 0;
        for (int i12 = 0; i12 <= 100; i12++) {
            HashMap hashMap = this.f10720a.get(Integer.valueOf(i12));
            if (!(hashMap == null || ((KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                i11++;
            }
        }
        return i11;
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.state.get(str).f10730d.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f10727a;
    }

    public boolean hasPositionKeyframes() {
        return this.f10720a.size() > 0;
    }

    public void interpolate(int i11, int i12, float f11) {
        Easing easing = this.mEasing;
        if (easing != null) {
            f11 = (float) easing.get((double) f11);
        }
        for (String str : this.state.keySet()) {
            this.state.get(str).interpolate(i11, i12, f11, this);
        }
    }

    public boolean isEmpty() {
        return this.state.isEmpty();
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.f10721b);
        typedBundle.applyDelta((TypedValues) this);
    }

    public boolean setValue(int i11, float f11) {
        if (i11 != 706) {
            return false;
        }
        this.mStagger = f11;
        return false;
    }

    public boolean setValue(int i11, int i12) {
        return false;
    }

    public boolean setValue(int i11, boolean z11) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i11) {
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget = children.get(i12);
            getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, i11).update(constraintWidget, i11);
        }
    }

    private WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i11) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.f10721b.applyDelta((TypedValues) widgetState.f10730d);
            this.state.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i11);
            }
        }
        return widgetState;
    }

    public void addKeyPosition(String str, int i11, int i12, float f11, float f12) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add((int) TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        typedBundle.add(100, i11);
        typedBundle.add((int) TypedValues.PositionType.TYPE_PERCENT_X, f11);
        typedBundle.add((int) TypedValues.PositionType.TYPE_PERCENT_Y, f12);
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i11, i12, f11, f12);
        HashMap hashMap = this.f10720a.get(Integer.valueOf(i11));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f10720a.put(Integer.valueOf(i11), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    public boolean setValue(int i11, String str) {
        if (i11 != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 1).f10728b;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 2).f10729c;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 0).f10727a;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }
}
