package androidx.dynamicanimation.animation;

public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f11) {
        this.mValue = f11;
    }

    public FloatValueHolder(float f11) {
        setValue(f11);
    }
}
