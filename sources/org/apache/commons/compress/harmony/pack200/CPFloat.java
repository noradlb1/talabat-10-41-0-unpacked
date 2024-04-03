package org.apache.commons.compress.harmony.pack200;

public class CPFloat extends CPConstant {
    private final float theFloat;

    public CPFloat(float f11) {
        this.theFloat = f11;
    }

    public int compareTo(Object obj) {
        return Float.compare(this.theFloat, ((CPFloat) obj).theFloat);
    }

    public float getFloat() {
        return this.theFloat;
    }
}
