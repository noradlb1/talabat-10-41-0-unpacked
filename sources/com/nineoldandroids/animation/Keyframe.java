package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public float f52799b;

    /* renamed from: c  reason: collision with root package name */
    public Class f52800c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52801d = false;
    private Interpolator mInterpolator = null;

    public static Keyframe ofFloat(float f11, float f12) {
        return new FloatKeyframe(f11, f12);
    }

    public static Keyframe ofInt(float f11, int i11) {
        return new IntKeyframe(f11, i11);
    }

    public static Keyframe ofObject(float f11, Object obj) {
        return new ObjectKeyframe(f11, obj);
    }

    public abstract Keyframe clone();

    public float getFraction() {
        return this.f52799b;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public Class getType() {
        return this.f52800c;
    }

    public abstract Object getValue();

    public boolean hasValue() {
        return this.f52801d;
    }

    public void setFraction(float f11) {
        this.f52799b = f11;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public abstract void setValue(Object obj);

    public static class FloatKeyframe extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        public float f52802e;

        public FloatKeyframe(float f11, float f12) {
            this.f52799b = f11;
            this.f52802e = f12;
            this.f52800c = Float.TYPE;
            this.f52801d = true;
        }

        public float getFloatValue() {
            return this.f52802e;
        }

        public Object getValue() {
            return Float.valueOf(this.f52802e);
        }

        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f52802e = ((Float) obj).floatValue();
                this.f52801d = true;
            }
        }

        public FloatKeyframe clone() {
            FloatKeyframe floatKeyframe = new FloatKeyframe(getFraction(), this.f52802e);
            floatKeyframe.setInterpolator(getInterpolator());
            return floatKeyframe;
        }

        public FloatKeyframe(float f11) {
            this.f52799b = f11;
            this.f52800c = Float.TYPE;
        }
    }

    public static class IntKeyframe extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        public int f52803e;

        public IntKeyframe(float f11, int i11) {
            this.f52799b = f11;
            this.f52803e = i11;
            this.f52800c = Integer.TYPE;
            this.f52801d = true;
        }

        public int getIntValue() {
            return this.f52803e;
        }

        public Object getValue() {
            return Integer.valueOf(this.f52803e);
        }

        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f52803e = ((Integer) obj).intValue();
                this.f52801d = true;
            }
        }

        public IntKeyframe clone() {
            IntKeyframe intKeyframe = new IntKeyframe(getFraction(), this.f52803e);
            intKeyframe.setInterpolator(getInterpolator());
            return intKeyframe;
        }

        public IntKeyframe(float f11) {
            this.f52799b = f11;
            this.f52800c = Integer.TYPE;
        }
    }

    public static class ObjectKeyframe extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        public Object f52804e;

        public ObjectKeyframe(float f11, Object obj) {
            boolean z11;
            Class cls;
            this.f52799b = f11;
            this.f52804e = obj;
            if (obj != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f52801d = z11;
            if (z11) {
                cls = obj.getClass();
            } else {
                cls = Object.class;
            }
            this.f52800c = cls;
        }

        public Object getValue() {
            return this.f52804e;
        }

        public void setValue(Object obj) {
            boolean z11;
            this.f52804e = obj;
            if (obj != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f52801d = z11;
        }

        public ObjectKeyframe clone() {
            ObjectKeyframe objectKeyframe = new ObjectKeyframe(getFraction(), this.f52804e);
            objectKeyframe.setInterpolator(getInterpolator());
            return objectKeyframe;
        }
    }

    public static Keyframe ofFloat(float f11) {
        return new FloatKeyframe(f11);
    }

    public static Keyframe ofInt(float f11) {
        return new IntKeyframe(f11);
    }

    public static Keyframe ofObject(float f11) {
        return new ObjectKeyframe(f11, (Object) null);
    }
}
