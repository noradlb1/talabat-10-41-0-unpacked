package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Set;
import org.apache.commons.lang3.CharUtils;

public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha = Float.NaN;
    public int bottom = 0;
    public float interpolatedPos = Float.NaN;
    public int left = 0;
    public final HashMap<String, CustomVariable> mCustom = new HashMap<>();

    /* renamed from: name  reason: collision with root package name */
    public String f10737name = null;
    public float pivotX = Float.NaN;
    public float pivotY = Float.NaN;
    public int right = 0;
    public float rotationX = Float.NaN;
    public float rotationY = Float.NaN;
    public float rotationZ = Float.NaN;
    public float scaleX = Float.NaN;
    public float scaleY = Float.NaN;
    public int top = 0;
    public float translationX = Float.NaN;
    public float translationY = Float.NaN;
    public float translationZ = Float.NaN;
    public int visibility = 0;
    public ConstraintWidget widget = null;

    public WidgetFrame() {
    }

    private static void add(StringBuilder sb2, String str, int i11) {
        sb2.append(str);
        sb2.append(": ");
        sb2.append(i11);
        sb2.append(",\n");
    }

    public static void interpolate(int i11, int i12, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f11) {
        int i13;
        float f12;
        int i14;
        int i15;
        float f13;
        float f14;
        int i16;
        int i17;
        int i18;
        float f15;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24 = i11;
        int i25 = i12;
        WidgetFrame widgetFrame4 = widgetFrame;
        WidgetFrame widgetFrame5 = widgetFrame2;
        WidgetFrame widgetFrame6 = widgetFrame3;
        Transition transition2 = transition;
        float f16 = 100.0f * f11;
        int i26 = (int) f16;
        int i27 = widgetFrame5.left;
        int i28 = widgetFrame5.top;
        int i29 = widgetFrame6.left;
        int i31 = widgetFrame6.top;
        int i32 = widgetFrame6.right - i29;
        int i33 = widgetFrame5.right - i27;
        int i34 = widgetFrame6.bottom - i31;
        int i35 = widgetFrame5.bottom - i28;
        float f17 = widgetFrame5.alpha;
        float f18 = widgetFrame6.alpha;
        float f19 = f16;
        if (widgetFrame5.visibility == 8) {
            i28 = (int) (((float) i28) - (((float) i34) / 2.0f));
            i13 = (int) (((float) i27) - (((float) i32) / 2.0f));
            if (Float.isNaN(f17)) {
                i14 = i34;
                i15 = i32;
                f12 = 0.0f;
            } else {
                f12 = f17;
                i15 = i32;
                i14 = i34;
            }
        } else {
            i15 = i33;
            f12 = f17;
            i14 = i35;
            i13 = i27;
        }
        if (widgetFrame6.visibility == 8) {
            i29 = (int) (((float) i29) - (((float) i15) / 2.0f));
            i31 = (int) (((float) i31) - (((float) i14) / 2.0f));
            i32 = i15;
            i34 = i14;
            if (Float.isNaN(f18)) {
                f18 = 0.0f;
            }
        }
        if (Float.isNaN(f12) && !Float.isNaN(f18)) {
            f12 = 1.0f;
        }
        if (!Float.isNaN(f12) && Float.isNaN(f18)) {
            f18 = 1.0f;
        }
        if (widgetFrame5.visibility == 4) {
            f13 = f18;
            f14 = 0.0f;
        } else {
            f14 = f12;
            f13 = f18;
        }
        float f21 = widgetFrame6.visibility == 4 ? 0.0f : f13;
        if (widgetFrame4.widget == null || !transition.hasPositionKeyframes()) {
            i16 = i28;
            f15 = f11;
            i18 = i13;
            i17 = i29;
        } else {
            Transition.KeyPosition findPreviousPosition = transition2.findPreviousPosition(widgetFrame4.widget.stringId, i26);
            i16 = i28;
            Transition.KeyPosition findNextPosition = transition2.findNextPosition(widgetFrame4.widget.stringId, i26);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i13 = (int) (findPreviousPosition.f10725d * ((float) i24));
                i19 = i29;
                i22 = i12;
                i16 = (int) (findPreviousPosition.f10726e * ((float) i22));
                i21 = findPreviousPosition.f10722a;
            } else {
                i22 = i12;
                i19 = i29;
                i21 = 0;
            }
            i18 = i13;
            if (findNextPosition != null) {
                int i36 = (int) (findNextPosition.f10725d * ((float) i24));
                int i37 = (int) (findNextPosition.f10726e * ((float) i22));
                i23 = findNextPosition.f10722a;
                i17 = i36;
                i31 = i37;
            } else {
                i23 = 100;
                i17 = i19;
            }
            f15 = (f19 - ((float) i21)) / ((float) (i23 - i21));
        }
        int i38 = i16;
        widgetFrame4.widget = widgetFrame5.widget;
        int i39 = (int) (((float) i18) + (((float) (i17 - i18)) * f15));
        widgetFrame4.left = i39;
        int i41 = (int) (((float) i38) + (f15 * ((float) (i31 - i38))));
        widgetFrame4.top = i41;
        float f22 = f11;
        float f23 = 1.0f - f22;
        widgetFrame4.right = i39 + ((int) ((((float) i15) * f23) + (((float) i32) * f22)));
        widgetFrame4.bottom = i41 + ((int) ((f23 * ((float) i14)) + (((float) i34) * f22)));
        widgetFrame4.pivotX = interpolate(widgetFrame5.pivotX, widgetFrame6.pivotX, 0.5f, f22);
        widgetFrame4.pivotY = interpolate(widgetFrame5.pivotY, widgetFrame6.pivotY, 0.5f, f22);
        widgetFrame4.rotationX = interpolate(widgetFrame5.rotationX, widgetFrame6.rotationX, 0.0f, f22);
        widgetFrame4.rotationY = interpolate(widgetFrame5.rotationY, widgetFrame6.rotationY, 0.0f, f22);
        widgetFrame4.rotationZ = interpolate(widgetFrame5.rotationZ, widgetFrame6.rotationZ, 0.0f, f22);
        widgetFrame4.scaleX = interpolate(widgetFrame5.scaleX, widgetFrame6.scaleX, 1.0f, f22);
        widgetFrame4.scaleY = interpolate(widgetFrame5.scaleY, widgetFrame6.scaleY, 1.0f, f22);
        widgetFrame4.translationX = interpolate(widgetFrame5.translationX, widgetFrame6.translationX, 0.0f, f22);
        widgetFrame4.translationY = interpolate(widgetFrame5.translationY, widgetFrame6.translationY, 0.0f, f22);
        widgetFrame4.translationZ = interpolate(widgetFrame5.translationZ, widgetFrame6.translationZ, 0.0f, f22);
        widgetFrame4.alpha = interpolate(f14, f21, 1.0f, f22);
        Set<String> keySet = widgetFrame6.mCustom.keySet();
        widgetFrame4.mCustom.clear();
        for (String next : keySet) {
            if (widgetFrame5.mCustom.containsKey(next)) {
                CustomVariable customVariable = widgetFrame5.mCustom.get(next);
                CustomVariable customVariable2 = widgetFrame6.mCustom.get(next);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame4.mCustom.put(next, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue((Object) Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f22)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i42 = 0; i42 < numberOfInterpolatedValues; i42++) {
                        fArr[i42] = interpolate(fArr[i42], fArr2[i42], 0.0f, f22);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb2, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor != null && anchor.mTarget != null) {
            sb2.append("Anchor");
            sb2.append(type.name());
            sb2.append(": ['");
            String str = anchor.mTarget.getOwner().stringId;
            if (str == null) {
                str = "#PARENT";
            }
            sb2.append(str);
            sb2.append("', '");
            sb2.append(anchor.mTarget.getType().name());
            sb2.append("', '");
            sb2.append(anchor.mMargin);
            sb2.append("'],\n");
        }
    }

    public void a(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i11 = 0; i11 < size; i11++) {
            CLKey cLKey = (CLKey) cLObject.get(i11);
            cLKey.content();
            CLElement value = cLKey.getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(cLKey.content(), (int) TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(cLKey.content(), 901, value.getFloat());
            } else {
                setCustomAttribute(cLKey.content(), 903, content);
            }
        }
    }

    public void addCustomColor(String str, int i11) {
        setCustomAttribute(str, (int) TypedValues.Custom.TYPE_COLOR, i11);
    }

    public void addCustomFloat(String str, float f11) {
        setCustomAttribute(str, 901, f11);
    }

    public float centerX() {
        int i11 = this.left;
        return ((float) i11) + (((float) (this.right - i11)) / 2.0f);
    }

    public float centerY() {
        int i11 = this.top;
        return ((float) i11) + (((float) (this.bottom - i11)) / 2.0f);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) {
            return "unknown";
        }
        return constraintWidget.stringId;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (!Float.isNaN(this.rotationX) || !Float.isNaN(this.rotationY) || !Float.isNaN(this.rotationZ) || !Float.isNaN(this.translationX) || !Float.isNaN(this.translationY) || !Float.isNaN(this.translationZ) || !Float.isNaN(this.scaleX) || !Float.isNaN(this.scaleY) || !Float.isNaN(this.alpha)) {
            return false;
        }
        return true;
    }

    public StringBuilder serialize(StringBuilder sb2) {
        return serialize(sb2, false);
    }

    public void setCustomAttribute(String str, int i11, float f11) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f11);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i11, f11));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 6;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 7;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 8;
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c11 = 9;
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c11 = 10;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 11;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 12;
                    break;
                }
                break;
            case 115029:
                if (str.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c11 = 14;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 15;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c11 = 16;
                    break;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c11 = 17;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                phone_orientation = cLElement.getFloat();
                break;
            case 1:
                this.bottom = cLElement.getInt();
                break;
            case 2:
                a(cLElement);
                break;
            case 3:
                this.rotationX = cLElement.getFloat();
                break;
            case 4:
                this.rotationY = cLElement.getFloat();
                break;
            case 5:
                this.rotationZ = cLElement.getFloat();
                break;
            case 6:
                this.translationX = cLElement.getFloat();
                break;
            case 7:
                this.translationY = cLElement.getFloat();
                break;
            case 8:
                this.translationZ = cLElement.getFloat();
                break;
            case 9:
                this.pivotX = cLElement.getFloat();
                break;
            case 10:
                this.pivotY = cLElement.getFloat();
                break;
            case 11:
                this.scaleX = cLElement.getFloat();
                break;
            case 12:
                this.scaleY = cLElement.getFloat();
                break;
            case 13:
                this.top = cLElement.getInt();
                break;
            case 14:
                this.left = cLElement.getInt();
                break;
            case 15:
                this.alpha = cLElement.getFloat();
                break;
            case 16:
                this.right = cLElement.getInt();
                break;
            case 17:
                this.interpolatedPos = cLElement.getFloat();
                break;
            default:
                return false;
        }
        return true;
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.mCustom.clear();
        for (CustomVariable next : widgetFrame.mCustom.values()) {
            this.mCustom.put(next.getName(), next.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb2, boolean z11) {
        sb2.append("{\n");
        add(sb2, "left", this.left);
        add(sb2, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.top);
        add(sb2, TtmlNode.RIGHT, this.right);
        add(sb2, "bottom", this.bottom);
        add(sb2, "pivotX", this.pivotX);
        add(sb2, "pivotY", this.pivotY);
        add(sb2, "rotationX", this.rotationX);
        add(sb2, "rotationY", this.rotationY);
        add(sb2, "rotationZ", this.rotationZ);
        add(sb2, "translationX", this.translationX);
        add(sb2, "translationY", this.translationY);
        add(sb2, "translationZ", this.translationZ);
        add(sb2, "scaleX", this.scaleX);
        add(sb2, "scaleY", this.scaleY);
        add(sb2, "alpha", this.alpha);
        add(sb2, "visibility", this.visibility);
        add(sb2, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type serializeAnchor : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb2, serializeAnchor);
            }
        }
        if (z11) {
            add(sb2, "phone_orientation", phone_orientation);
        }
        if (z11) {
            add(sb2, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb2.append("custom : {\n");
            for (String next : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(next);
                sb2.append(next);
                sb2.append(": ");
                switch (customVariable.getType()) {
                    case TypedValues.Custom.TYPE_INT:
                        sb2.append(customVariable.getIntegerValue());
                        sb2.append(",\n");
                        break;
                    case 901:
                    case TypedValues.Custom.TYPE_DIMENSION:
                        sb2.append(customVariable.getFloatValue());
                        sb2.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR:
                        sb2.append("'");
                        sb2.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb2.append("',\n");
                        break;
                    case 903:
                        sb2.append("'");
                        sb2.append(customVariable.getStringValue());
                        sb2.append("',\n");
                        break;
                    case 904:
                        sb2.append("'");
                        sb2.append(customVariable.getBooleanValue());
                        sb2.append("',\n");
                        break;
                }
            }
            sb2.append("}\n");
        }
        sb2.append("}\n");
        return sb2;
    }

    public void setCustomAttribute(String str, int i11, int i12) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i12);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i11, i12));
        }
    }

    private static void add(StringBuilder sb2, String str, float f11) {
        if (!Float.isNaN(f11)) {
            sb2.append(str);
            sb2.append(": ");
            sb2.append(f11);
            sb2.append(",\n");
        }
    }

    public void setCustomAttribute(String str, int i11, boolean z11) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z11);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i11, z11));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i11, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i11, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    private static float interpolate(float f11, float f12, float f13, float f14) {
        boolean isNaN = Float.isNaN(f11);
        boolean isNaN2 = Float.isNaN(f12);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f11 = f13;
        }
        if (isNaN2) {
            f12 = f13;
        }
        return f11 + (f14 * (f12 - f11));
    }
}
