package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

public class CustomAttribute {
    private static final String TAG = "TransitionLayout";

    /* renamed from: a  reason: collision with root package name */
    public String f10470a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10471b;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    private String mStringValue;
    private AttributeType mType;

    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10472a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType[] r0 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10472a = r0
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10472a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.CustomAttribute.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.f10470a = str;
        this.mType = attributeType;
    }

    private static int clamp(int i11) {
        int i12 = (i11 & (~(i11 >> 31))) - 255;
        return (i12 & (i12 >> 31)) + 255;
    }

    public static int hsvToRgb(float f11, float f12, float f13) {
        float f14 = f11 * 6.0f;
        int i11 = (int) f14;
        float f15 = f14 - ((float) i11);
        float f16 = f13 * 255.0f;
        int i12 = (int) (((1.0f - f12) * f16) + 0.5f);
        int i13 = (int) (((1.0f - (f15 * f12)) * f16) + 0.5f);
        int i14 = (int) (((1.0f - ((1.0f - f15) * f12)) * f16) + 0.5f);
        int i15 = (int) (f16 + 0.5f);
        if (i11 == 0) {
            return ((i15 << 16) + (i14 << 8) + i12) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i11 == 1) {
            return ((i13 << 16) + (i15 << 8) + i12) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i11 == 2) {
            return ((i12 << 16) + (i15 << 8) + i14) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i11 == 3) {
            return ((i12 << 16) + (i13 << 8) + i15) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i11 == 4) {
            return ((i14 << 16) + (i12 << 8) + i15) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i11 != 5) {
            return 0;
        }
        return ((i15 << 16) + (i12 << 8) + i13) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute == null || (attributeType = this.mType) != customAttribute.mType) {
            return false;
        }
        switch (AnonymousClass1.f10472a[attributeType.ordinal()]) {
            case 1:
            case 6:
                if (this.mIntegerValue == customAttribute.mIntegerValue) {
                    return true;
                }
                return false;
            case 2:
                if (this.f10471b == customAttribute.f10471b) {
                    return true;
                }
                return false;
            case 3:
                if (this.mIntegerValue == customAttribute.mIntegerValue) {
                    return true;
                }
                return false;
            case 4:
            case 5:
                if (this.mColorValue == customAttribute.mColorValue) {
                    return true;
                }
                return false;
            case 7:
                if (this.mFloatValue == customAttribute.mFloatValue) {
                    return true;
                }
                return false;
            case 8:
                if (this.mFloatValue == customAttribute.mFloatValue) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (AnonymousClass1.f10472a[this.mType.ordinal()]) {
            case 2:
                if (this.f10471b) {
                    return 1.0f;
                }
                return 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return (float) this.mIntegerValue;
            case 7:
                return this.mFloatValue;
            case 8:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f11;
        switch (AnonymousClass1.f10472a[this.mType.ordinal()]) {
            case 2:
                if (this.f10471b) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                fArr[0] = f11;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i11 = this.mColorValue;
                float pow = (float) Math.pow((double) (((float) ((i11 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i11 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i11 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i11 >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.mIntegerValue;
                return;
            case 7:
                fArr[0] = this.mFloatValue;
                return;
            case 8:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i11 = AnonymousClass1.f10472a[this.mType.ordinal()];
        return (i11 == 1 || i11 == 2 || i11 == 3) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int i11 = AnonymousClass1.f10472a[this.mType.ordinal()];
        return (i11 == 4 || i11 == 5) ? 4 : 1;
    }

    public void setColorValue(int i11) {
        this.mColorValue = i11;
    }

    public void setFloatValue(float f11) {
        this.mFloatValue = f11;
    }

    public void setIntValue(int i11) {
        this.mIntegerValue = i11;
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        boolean z11 = true;
        switch (AnonymousClass1.f10472a[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 2:
                if (((double) fArr[0]) <= 0.5d) {
                    z11 = false;
                }
                this.f10471b = z11;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = hsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (hsvToRgb & 16777215);
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            case 8:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z11) {
        this.f10470a = str;
        this.mType = attributeType;
        this.mMethod = z11;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (AnonymousClass1.f10472a[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 2:
                this.f10471b = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.mStringValue = (String) obj;
                return;
            case 4:
            case 5:
                this.mColorValue = ((Integer) obj).intValue();
                return;
            case 7:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case 8:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.f10470a = customAttribute.f10470a;
        this.mType = customAttribute.mType;
        setValue(obj);
    }
}
