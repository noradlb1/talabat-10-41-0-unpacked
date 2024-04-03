package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CustomVariable {
    private static final String TAG = "TransitionLayout";

    /* renamed from: a  reason: collision with root package name */
    public String f10473a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10474b;
    private float mFloatValue;
    private int mIntegerValue;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = customVariable.f10473a;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.f10474b = customVariable.f10474b;
    }

    private static int clamp(int i11) {
        int i12 = (i11 & (~(i11 >> 31))) - 255;
        return (i12 & (i12 >> 31)) + 255;
    }

    public static String colorString(int i11) {
        String str = "00000000" + Integer.toHexString(i11);
        return "#" + str.substring(str.length() - 8);
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

    public static int rgbaTocColor(float f11, float f12, float f13, float f14) {
        int clamp = clamp((int) (f11 * 255.0f));
        int clamp2 = clamp((int) (f12 * 255.0f));
        return (clamp << 16) | (clamp((int) (f14 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f13 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i11 = this.mType;
        switch (i11) {
            case TypedValues.Custom.TYPE_INT /*900*/:
            case TypedValues.Custom.TYPE_COLOR /*902*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                motionWidget.setCustomAttribute(this.f10473a, i11, this.mIntegerValue);
                return;
            case 901:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                motionWidget.setCustomAttribute(this.f10473a, i11, this.mFloatValue);
                return;
            case 903:
                motionWidget.setCustomAttribute(this.f10473a, i11, this.mStringValue);
                return;
            case 904:
                motionWidget.setCustomAttribute(this.f10473a, i11, this.f10474b);
                return;
            default:
                return;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i11;
        if (customVariable == null || (i11 = this.mType) != customVariable.mType) {
            return false;
        }
        switch (i11) {
            case TypedValues.Custom.TYPE_INT /*900*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                    return true;
                }
                return false;
            case 901:
                if (this.mFloatValue == customVariable.mFloatValue) {
                    return true;
                }
                return false;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                    return true;
                }
                return false;
            case 903:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                    return true;
                }
                return false;
            case 904:
                if (this.f10474b == customVariable.f10474b) {
                    return true;
                }
                return false;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                if (this.mFloatValue == customVariable.mFloatValue) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public boolean getBooleanValue() {
        return this.f10474b;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.f10473a;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case TypedValues.Custom.TYPE_INT /*900*/:
                return (float) this.mIntegerValue;
            case 901:
                return this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                if (this.f10474b) {
                    return 1.0f;
                }
                return 0.0f;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f11;
        switch (this.mType) {
            case TypedValues.Custom.TYPE_INT /*900*/:
                fArr[0] = (float) this.mIntegerValue;
                return;
            case 901:
                fArr[0] = this.mFloatValue;
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                int i11 = this.mIntegerValue;
                float pow = (float) Math.pow((double) (((float) ((i11 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i11 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i11 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i11 >> 24) & 255)) / 255.0f;
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                if (this.f10474b) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                fArr[0] = f11;
                return;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i11 = this.mType;
        return (i11 == 903 || i11 == 904 || i11 == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.mType != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z11) {
        this.f10474b = z11;
    }

    public void setFloatValue(float f11) {
        this.mFloatValue = f11;
    }

    public void setIntValue(int i11) {
        this.mIntegerValue = i11;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i11 = this.mType;
        boolean z11 = true;
        switch (i11) {
            case TypedValues.Custom.TYPE_INT /*900*/:
                motionWidget.setCustomAttribute(this.f10473a, i11, (int) fArr[0]);
                return;
            case 901:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                motionWidget.setCustomAttribute(this.f10473a, i11, fArr[0]);
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                motionWidget.setCustomAttribute(this.f10473a, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case 903:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                throw new RuntimeException("unable to interpolate " + this.f10473a);
            case 904:
                String str = this.f10473a;
                if (fArr[0] <= 0.5f) {
                    z11 = false;
                }
                motionWidget.setCustomAttribute(str, i11, z11);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        boolean z11 = true;
        switch (this.mType) {
            case TypedValues.Custom.TYPE_INT /*900*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 901:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                this.mFloatValue = fArr[0];
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow((double) fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow((double) fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow((double) fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                if (((double) fArr[0]) <= 0.5d) {
                    z11 = false;
                }
                this.f10474b = z11;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f10473a + AbstractJsonLexerKt.COLON;
        switch (this.mType) {
            case TypedValues.Custom.TYPE_INT /*900*/:
                return str + this.mIntegerValue;
            case 901:
                return str + this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                return str + colorString(this.mIntegerValue);
            case 903:
                return str + this.mStringValue;
            case 904:
                return str + Boolean.valueOf(this.f10474b);
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                return str + this.mFloatValue;
            default:
                return str + "????";
        }
    }

    public CustomVariable(String str, int i11, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.f10473a = str;
        this.mType = i11;
        this.mStringValue = str2;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case TypedValues.Custom.TYPE_INT /*900*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 901:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 903:
                this.mStringValue = (String) obj;
                return;
            case 904:
                this.f10474b = ((Boolean) obj).booleanValue();
                return;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public CustomVariable(String str, int i11, int i12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = str;
        this.mType = i11;
        if (i11 == 901) {
            this.mFloatValue = (float) i12;
        } else {
            this.mIntegerValue = i12;
        }
    }

    public CustomVariable(String str, int i11, float f11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.f10473a = str;
        this.mType = i11;
        this.mFloatValue = f11;
    }

    public CustomVariable(String str, int i11, boolean z11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = str;
        this.mType = i11;
        this.f10474b = z11;
    }

    public CustomVariable(String str, int i11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = str;
        this.mType = i11;
    }

    public CustomVariable(String str, int i11, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = str;
        this.mType = i11;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.f10473a = customVariable.f10473a;
        this.mType = customVariable.mType;
        setValue(obj);
    }
}
