package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.AdError;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    /* access modifiers changed from: private */
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant = new SparseIntArray();
    private static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    /* access modifiers changed from: private */
    public HashMap<Integer, Constraint> mConstraints = new HashMap<>();
    private boolean mForceId = true;
    public String mIdString;
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mValidate;

    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        public int f11148a;

        /* renamed from: b  reason: collision with root package name */
        public String f11149b;

        /* renamed from: c  reason: collision with root package name */
        public Delta f11150c;
        public final Layout layout = new Layout();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();
        public final Motion motion = new Motion();
        public final PropertySet propertySet = new PropertySet();
        public final Transform transform = new Transform();

        public static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;

            /* renamed from: a  reason: collision with root package name */
            public int[] f11151a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            public int[] f11152b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            public int f11153c = 0;

            /* renamed from: d  reason: collision with root package name */
            public int[] f11154d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            public float[] f11155e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            public int f11156f = 0;

            /* renamed from: g  reason: collision with root package name */
            public int[] f11157g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            public String[] f11158h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            public int f11159i = 0;

            /* renamed from: j  reason: collision with root package name */
            public int[] f11160j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            public boolean[] f11161k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            public int f11162l = 0;

            public void a(int i11, float f11) {
                int i12 = this.f11156f;
                int[] iArr = this.f11154d;
                if (i12 >= iArr.length) {
                    this.f11154d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f11155e;
                    this.f11155e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f11154d;
                int i13 = this.f11156f;
                iArr2[i13] = i11;
                float[] fArr2 = this.f11155e;
                this.f11156f = i13 + 1;
                fArr2[i13] = f11;
            }

            public void b(int i11, int i12) {
                int i13 = this.f11153c;
                int[] iArr = this.f11151a;
                if (i13 >= iArr.length) {
                    this.f11151a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f11152b;
                    this.f11152b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f11151a;
                int i14 = this.f11153c;
                iArr3[i14] = i11;
                int[] iArr4 = this.f11152b;
                this.f11153c = i14 + 1;
                iArr4[i14] = i12;
            }

            public void c(int i11, String str) {
                int i12 = this.f11159i;
                int[] iArr = this.f11157g;
                if (i12 >= iArr.length) {
                    this.f11157g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f11158h;
                    this.f11158h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f11157g;
                int i13 = this.f11159i;
                iArr2[i13] = i11;
                String[] strArr2 = this.f11158h;
                this.f11159i = i13 + 1;
                strArr2[i13] = str;
            }

            public void d(int i11, boolean z11) {
                int i12 = this.f11162l;
                int[] iArr = this.f11160j;
                if (i12 >= iArr.length) {
                    this.f11160j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f11161k;
                    this.f11161k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f11160j;
                int i13 = this.f11162l;
                iArr2[i13] = i11;
                boolean[] zArr2 = this.f11161k;
                this.f11162l = i13 + 1;
                zArr2[i13] = z11;
            }

            public void e(Constraint constraint) {
                for (int i11 = 0; i11 < this.f11153c; i11++) {
                    ConstraintSet.setDeltaValue(constraint, this.f11151a[i11], this.f11152b[i11]);
                }
                for (int i12 = 0; i12 < this.f11156f; i12++) {
                    ConstraintSet.setDeltaValue(constraint, this.f11154d[i12], this.f11155e[i12]);
                }
                for (int i13 = 0; i13 < this.f11159i; i13++) {
                    ConstraintSet.setDeltaValue(constraint, this.f11157g[i13], this.f11158h[i13]);
                }
                for (int i14 = 0; i14 < this.f11162l; i14++) {
                    ConstraintSet.setDeltaValue(constraint, this.f11160j[i14], this.f11161k[i14]);
                }
            }

            @SuppressLint({"LogConditional"})
            public void f(String str) {
                for (int i11 = 0; i11 < this.f11153c; i11++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f11151a[i11]);
                    sb2.append(" = ");
                    sb2.append(this.f11152b[i11]);
                }
                for (int i12 = 0; i12 < this.f11156f; i12++) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f11154d[i12]);
                    sb3.append(" = ");
                    sb3.append(this.f11155e[i12]);
                }
                for (int i13 = 0; i13 < this.f11159i; i13++) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.f11157g[i13]);
                    sb4.append(" = ");
                    sb4.append(this.f11158h[i13]);
                }
                for (int i14 = 0; i14 < this.f11162l; i14++) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f11160j[i14]);
                    sb5.append(" = ");
                    sb5.append(this.f11161k[i14]);
                }
            }
        }

        /* access modifiers changed from: private */
        public void fillFrom(int i11, ConstraintLayout.LayoutParams layoutParams) {
            this.f11148a = i11;
            Layout layout2 = this.layout;
            layout2.leftToLeft = layoutParams.leftToLeft;
            layout2.leftToRight = layoutParams.leftToRight;
            layout2.rightToLeft = layoutParams.rightToLeft;
            layout2.rightToRight = layoutParams.rightToRight;
            layout2.topToTop = layoutParams.topToTop;
            layout2.topToBottom = layoutParams.topToBottom;
            layout2.bottomToTop = layoutParams.bottomToTop;
            layout2.bottomToBottom = layoutParams.bottomToBottom;
            layout2.baselineToBaseline = layoutParams.baselineToBaseline;
            layout2.baselineToTop = layoutParams.baselineToTop;
            layout2.baselineToBottom = layoutParams.baselineToBottom;
            layout2.startToEnd = layoutParams.startToEnd;
            layout2.startToStart = layoutParams.startToStart;
            layout2.endToStart = layoutParams.endToStart;
            layout2.endToEnd = layoutParams.endToEnd;
            layout2.horizontalBias = layoutParams.horizontalBias;
            layout2.verticalBias = layoutParams.verticalBias;
            layout2.dimensionRatio = layoutParams.dimensionRatio;
            layout2.circleConstraint = layoutParams.circleConstraint;
            layout2.circleRadius = layoutParams.circleRadius;
            layout2.circleAngle = layoutParams.circleAngle;
            layout2.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout2.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout2.orientation = layoutParams.orientation;
            layout2.guidePercent = layoutParams.guidePercent;
            layout2.guideBegin = layoutParams.guideBegin;
            layout2.guideEnd = layoutParams.guideEnd;
            layout2.mWidth = layoutParams.width;
            layout2.mHeight = layoutParams.height;
            layout2.leftMargin = layoutParams.leftMargin;
            layout2.rightMargin = layoutParams.rightMargin;
            layout2.topMargin = layoutParams.topMargin;
            layout2.bottomMargin = layoutParams.bottomMargin;
            layout2.baselineMargin = layoutParams.baselineMargin;
            layout2.verticalWeight = layoutParams.verticalWeight;
            layout2.horizontalWeight = layoutParams.horizontalWeight;
            layout2.verticalChainStyle = layoutParams.verticalChainStyle;
            layout2.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout2.constrainedWidth = layoutParams.constrainedWidth;
            layout2.constrainedHeight = layoutParams.constrainedHeight;
            layout2.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout2.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout2.widthMax = layoutParams.matchConstraintMaxWidth;
            layout2.heightMax = layoutParams.matchConstraintMaxHeight;
            layout2.widthMin = layoutParams.matchConstraintMinWidth;
            layout2.heightMin = layoutParams.matchConstraintMinHeight;
            layout2.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout2.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout2.mConstraintTag = layoutParams.constraintTag;
            layout2.goneTopMargin = layoutParams.goneTopMargin;
            layout2.goneBottomMargin = layoutParams.goneBottomMargin;
            layout2.goneLeftMargin = layoutParams.goneLeftMargin;
            layout2.goneRightMargin = layoutParams.goneRightMargin;
            layout2.goneStartMargin = layoutParams.goneStartMargin;
            layout2.goneEndMargin = layoutParams.goneEndMargin;
            layout2.goneBaselineMargin = layoutParams.goneBaselineMargin;
            layout2.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            layout2.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i11, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i11, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout2 = this.layout;
                layout2.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout2.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() == attributeType) {
                    return constraintAttribute;
                }
                throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        /* access modifiers changed from: private */
        public void setColorValue(String str, int i11) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i11);
        }

        /* access modifiers changed from: private */
        public void setFloatValue(String str, float f11) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f11);
        }

        /* access modifiers changed from: private */
        public void setIntValue(String str, int i11) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i11);
        }

        /* access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyDelta(Constraint constraint) {
            Delta delta = this.f11150c;
            if (delta != null) {
                delta.e(constraint);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout2 = this.layout;
            layoutParams.leftToLeft = layout2.leftToLeft;
            layoutParams.leftToRight = layout2.leftToRight;
            layoutParams.rightToLeft = layout2.rightToLeft;
            layoutParams.rightToRight = layout2.rightToRight;
            layoutParams.topToTop = layout2.topToTop;
            layoutParams.topToBottom = layout2.topToBottom;
            layoutParams.bottomToTop = layout2.bottomToTop;
            layoutParams.bottomToBottom = layout2.bottomToBottom;
            layoutParams.baselineToBaseline = layout2.baselineToBaseline;
            layoutParams.baselineToTop = layout2.baselineToTop;
            layoutParams.baselineToBottom = layout2.baselineToBottom;
            layoutParams.startToEnd = layout2.startToEnd;
            layoutParams.startToStart = layout2.startToStart;
            layoutParams.endToStart = layout2.endToStart;
            layoutParams.endToEnd = layout2.endToEnd;
            layoutParams.leftMargin = layout2.leftMargin;
            layoutParams.rightMargin = layout2.rightMargin;
            layoutParams.topMargin = layout2.topMargin;
            layoutParams.bottomMargin = layout2.bottomMargin;
            layoutParams.goneStartMargin = layout2.goneStartMargin;
            layoutParams.goneEndMargin = layout2.goneEndMargin;
            layoutParams.goneTopMargin = layout2.goneTopMargin;
            layoutParams.goneBottomMargin = layout2.goneBottomMargin;
            layoutParams.horizontalBias = layout2.horizontalBias;
            layoutParams.verticalBias = layout2.verticalBias;
            layoutParams.circleConstraint = layout2.circleConstraint;
            layoutParams.circleRadius = layout2.circleRadius;
            layoutParams.circleAngle = layout2.circleAngle;
            layoutParams.dimensionRatio = layout2.dimensionRatio;
            layoutParams.editorAbsoluteX = layout2.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout2.editorAbsoluteY;
            layoutParams.verticalWeight = layout2.verticalWeight;
            layoutParams.horizontalWeight = layout2.horizontalWeight;
            layoutParams.verticalChainStyle = layout2.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout2.horizontalChainStyle;
            layoutParams.constrainedWidth = layout2.constrainedWidth;
            layoutParams.constrainedHeight = layout2.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout2.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout2.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout2.widthMax;
            layoutParams.matchConstraintMaxHeight = layout2.heightMax;
            layoutParams.matchConstraintMinWidth = layout2.widthMin;
            layoutParams.matchConstraintMinHeight = layout2.heightMin;
            layoutParams.matchConstraintPercentWidth = layout2.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout2.heightPercent;
            layoutParams.orientation = layout2.orientation;
            layoutParams.guidePercent = layout2.guidePercent;
            layoutParams.guideBegin = layout2.guideBegin;
            layoutParams.guideEnd = layout2.guideEnd;
            layoutParams.width = layout2.mWidth;
            layoutParams.height = layout2.mHeight;
            String str = layout2.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.wrapBehaviorInParent = layout2.mWrapBehavior;
            layoutParams.setMarginStart(layout2.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        public void printDelta(String str) {
            Delta delta = this.f11150c;
            if (delta != null) {
                delta.f(str);
            }
        }

        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.f11148a = this.f11148a;
            constraint.f11150c = this.f11150c;
            return constraint;
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(int i11, Constraints.LayoutParams layoutParams) {
            fillFrom(i11, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform2 = this.transform;
            transform2.rotation = layoutParams.rotation;
            transform2.rotationX = layoutParams.rotationX;
            transform2.rotationY = layoutParams.rotationY;
            transform2.scaleX = layoutParams.scaleX;
            transform2.scaleY = layoutParams.scaleY;
            transform2.transformPivotX = layoutParams.transformPivotX;
            transform2.transformPivotY = layoutParams.transformPivotY;
            transform2.translationX = layoutParams.translationX;
            transform2.translationY = layoutParams.translationY;
            transform2.translationZ = layoutParams.translationZ;
            transform2.elevation = layoutParams.elevation;
            transform2.applyElevation = layoutParams.applyElevation;
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_MARGIN = 80;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BASELINE_TO_BOTTOM = 78;
        private static final int BASELINE_TO_TOP = 77;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINED_HEIGHT = 88;
        private static final int CONSTRAINED_WIDTH = 87;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int CONSTRAINT_TAG = 89;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BASELINE_MARGIN = 79;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int GUIDE_USE_RTL = 90;
        private static final int HEIGHT_DEFAULT = 82;
        private static final int HEIGHT_MAX = 83;
        private static final int HEIGHT_MIN = 85;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LAYOUT_WRAP_BEHAVIOR = 76;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 91;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_DEFAULT = 81;
        private static final int WIDTH_MAX = 84;
        private static final int WIDTH_MIN = 86;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomMargin = 0;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endMargin = 0;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int heightDefault = 0;
        public int heightMax = 0;
        public int heightMin = 0;
        public float heightPercent = 1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftMargin = 0;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public boolean mApply = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType = -1;
        public boolean mIsGuideline = false;
        public boolean mOverride = false;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior = 0;
        public int orientation = -1;
        public int rightMargin = 0;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startMargin = 0;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topMargin = 0;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int widthDefault = 0;
        public int widthMax = 0;
        public int widthMin = 0;
        public float widthPercent = 1.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_guidelineUseRtl, 90);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = mapToConstant.get(index);
                switch (i12) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.i(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.i(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i12) {
                            case 61:
                                this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                break;
                            case 62:
                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                break;
                            case 63:
                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                break;
                            default:
                                switch (i12) {
                                    case 69:
                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        break;
                                    case 73:
                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        break;
                                    case 74:
                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        break;
                                    case 76:
                                        this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        break;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToTop);
                                        break;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBottom);
                                        break;
                                    case 79:
                                        this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        break;
                                    case 80:
                                        this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        break;
                                    case 81:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 82:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 83:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 84:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 85:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    case 86:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 87:
                                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        break;
                                    case 88:
                                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        break;
                                    case 89:
                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                    case 91:
                                        Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                    default:
                                        Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.guidelineUseRtl = layout.guidelineUseRtl;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr == null || layout.mReferenceIdString != null) {
                this.mReferenceIds = null;
            } else {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        /* JADX WARNING: type inference failed for: r2v8, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dump(androidx.constraintlayout.motion.widget.MotionScene r10, java.lang.StringBuilder r11) {
            /*
                r9 = this;
                java.lang.Class r0 = r9.getClass()
                java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
                java.lang.String r1 = "\n"
                r11.append(r1)
                r1 = 0
            L_0x000e:
                int r2 = r0.length
                if (r1 >= r2) goto L_0x0080
                r2 = r0[r1]
                java.lang.String r3 = r2.getName()
                int r4 = r2.getModifiers()
                boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
                if (r4 == 0) goto L_0x0022
                goto L_0x007d
            L_0x0022:
                java.lang.Object r4 = r2.get(r9)     // Catch:{ IllegalAccessException -> 0x0079 }
                java.lang.Class r2 = r2.getType()     // Catch:{ IllegalAccessException -> 0x0079 }
                java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x0079 }
                java.lang.String r6 = "\"\n"
                java.lang.String r7 = " = \""
                java.lang.String r8 = "    "
                if (r2 != r5) goto L_0x0059
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IllegalAccessException -> 0x0079 }
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0079 }
                r5 = -1
                if (r2 == r5) goto L_0x007d
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0079 }
                java.lang.String r2 = r10.lookUpConstraintName(r2)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0079 }
                if (r2 != 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r4 = r2
            L_0x0052:
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r6)     // Catch:{ IllegalAccessException -> 0x0079 }
                goto L_0x007d
            L_0x0059:
                java.lang.Class r5 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x0079 }
                if (r2 != r5) goto L_0x007d
                java.lang.Float r4 = (java.lang.Float) r4     // Catch:{ IllegalAccessException -> 0x0079 }
                float r2 = r4.floatValue()     // Catch:{ IllegalAccessException -> 0x0079 }
                r5 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 == 0) goto L_0x007d
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0079 }
                r11.append(r6)     // Catch:{ IllegalAccessException -> 0x0079 }
                goto L_0x007d
            L_0x0079:
                r2 = move-exception
                r2.printStackTrace()
            L_0x007d:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x0080:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.Layout.dump(androidx.constraintlayout.motion.widget.MotionScene, java.lang.StringBuilder):void");
        }
    }

    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateCircleAngleTo = 0;
        public int mAnimateRelativeTo = -1;
        public boolean mApply = false;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public int mPolarRelativeTo = -1;
        public int mQuantizeInterpolatorID = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mTransitionEasing = null;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i12 = obtainStyledAttributes.peekValue(index).type;
                        if (i12 != 1) {
                            if (i12 != 3) {
                                this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.mQuantizeInterpolatorString = string;
                                if (string.indexOf("/") <= 0) {
                                    this.mQuantizeInterpolatorType = -1;
                                    break;
                                } else {
                                    this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    this.mQuantizeInterpolatorType = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public boolean mApply = false;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 0;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean applyElevation = false;
        public float elevation = 0.0f;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public int transformPivotTarget = -1;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }
    }

    public class WriteJsonEngine {
        private static final String SPACE = "       ";

        /* renamed from: a  reason: collision with root package name */
        public Writer f11163a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintLayout f11164b;

        /* renamed from: c  reason: collision with root package name */
        public Context f11165c;

        /* renamed from: d  reason: collision with root package name */
        public int f11166d;

        /* renamed from: e  reason: collision with root package name */
        public int f11167e = 0;

        /* renamed from: f  reason: collision with root package name */
        public final String f11168f = "'left'";

        /* renamed from: g  reason: collision with root package name */
        public final String f11169g = "'right'";

        /* renamed from: h  reason: collision with root package name */
        public final String f11170h = "'baseline'";

        /* renamed from: i  reason: collision with root package name */
        public final String f11171i = "'bottom'";

        /* renamed from: j  reason: collision with root package name */
        public final String f11172j = "'top'";

        /* renamed from: k  reason: collision with root package name */
        public final String f11173k = "'start'";

        /* renamed from: l  reason: collision with root package name */
        public final String f11174l = "'end'";

        /* renamed from: m  reason: collision with root package name */
        public HashMap<Integer, String> f11175m = new HashMap<>();

        public WriteJsonEngine(Writer writer, ConstraintLayout constraintLayout, int i11) throws IOException {
            this.f11163a = writer;
            this.f11164b = constraintLayout;
            this.f11165c = constraintLayout.getContext();
            this.f11166d = i11;
        }

        private void writeDimension(String str, int i11, int i12, float f11, int i13, int i14, boolean z11) throws IOException {
            if (i11 == 0) {
                if (i14 == -1 && i13 == -1) {
                    if (i12 == 1) {
                        Writer writer = this.f11163a;
                        writer.write(SPACE + str + ": '???????????',\n");
                    } else if (i12 == 2) {
                        Writer writer2 = this.f11163a;
                        writer2.write(SPACE + str + ": '" + f11 + "%',\n");
                    }
                } else if (i12 == 0) {
                    Writer writer3 = this.f11163a;
                    writer3.write(SPACE + str + ": {'spread' ," + i13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i14 + "}\n");
                } else if (i12 == 1) {
                    Writer writer4 = this.f11163a;
                    writer4.write(SPACE + str + ": {'wrap' ," + i13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i14 + "}\n");
                } else if (i12 == 2) {
                    Writer writer5 = this.f11163a;
                    writer5.write(SPACE + str + ": {'" + f11 + "'% ," + i13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i14 + "}\n");
                }
            } else if (i11 == -2) {
                Writer writer6 = this.f11163a;
                writer6.write(SPACE + str + ": 'wrap'\n");
            } else if (i11 == -1) {
                Writer writer7 = this.f11163a;
                writer7.write(SPACE + str + ": 'parent'\n");
            } else {
                Writer writer8 = this.f11163a;
                writer8.write(SPACE + str + ": " + i11 + ",\n");
            }
        }

        private void writeGuideline(int i11, int i12, int i13, float f11) {
        }

        public String a(int i11) {
            if (this.f11175m.containsKey(Integer.valueOf(i11))) {
                return "'" + this.f11175m.get(Integer.valueOf(i11)) + "'";
            } else if (i11 == 0) {
                return "'parent'";
            } else {
                String b11 = b(i11);
                this.f11175m.put(Integer.valueOf(i11), b11);
                return "'" + b11 + "'";
            }
        }

        public String b(int i11) {
            if (i11 != -1) {
                try {
                    return this.f11165c.getResources().getResourceEntryName(i11);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unknown");
                    int i12 = this.f11167e + 1;
                    this.f11167e = i12;
                    sb2.append(i12);
                    return sb2.toString();
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unknown");
                int i13 = this.f11167e + 1;
                this.f11167e = i13;
                sb3.append(i13);
                return sb3.toString();
            }
        }

        public void c(int i11, float f11, int i12) throws IOException {
            if (i11 != -1) {
                this.f11163a.write("       circle");
                this.f11163a.write(":[");
                this.f11163a.write(a(i11));
                Writer writer = this.f11163a;
                writer.write(IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f11);
                Writer writer2 = this.f11163a;
                writer2.write(i12 + "]");
            }
        }

        public void d(String str, int i11, String str2, int i12, int i13) throws IOException {
            if (i11 != -1) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                this.f11163a.write(":[");
                this.f11163a.write(a(i11));
                this.f11163a.write(" , ");
                this.f11163a.write(str2);
                if (i12 != 0) {
                    Writer writer2 = this.f11163a;
                    writer2.write(" , " + i12);
                }
                this.f11163a.write("],\n");
            }
        }

        public void e() throws IOException {
            this.f11163a.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                String a11 = a(num.intValue());
                Writer writer = this.f11163a;
                writer.write(a11 + ":{\n");
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeDimension("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax, layout.constrainedHeight);
                writeDimension("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax, layout.constrainedWidth);
                d("'left'", layout.leftToLeft, "'left'", layout.leftMargin, layout.goneLeftMargin);
                d("'left'", layout.leftToRight, "'right'", layout.leftMargin, layout.goneLeftMargin);
                d("'right'", layout.rightToLeft, "'left'", layout.rightMargin, layout.goneRightMargin);
                d("'right'", layout.rightToRight, "'right'", layout.rightMargin, layout.goneRightMargin);
                d("'baseline'", layout.baselineToBaseline, "'baseline'", -1, layout.goneBaselineMargin);
                d("'baseline'", layout.baselineToTop, "'top'", -1, layout.goneBaselineMargin);
                d("'baseline'", layout.baselineToBottom, "'bottom'", -1, layout.goneBaselineMargin);
                d("'top'", layout.topToBottom, "'bottom'", layout.topMargin, layout.goneTopMargin);
                d("'top'", layout.topToTop, "'top'", layout.topMargin, layout.goneTopMargin);
                d("'bottom'", layout.bottomToBottom, "'bottom'", layout.bottomMargin, layout.goneBottomMargin);
                d("'bottom'", layout.bottomToTop, "'top'", layout.bottomMargin, layout.goneBottomMargin);
                d("'start'", layout.startToStart, "'start'", layout.startMargin, layout.goneStartMargin);
                d("'start'", layout.startToEnd, "'end'", layout.startMargin, layout.goneStartMargin);
                d("'end'", layout.endToStart, "'start'", layout.endMargin, layout.goneEndMargin);
                d("'end'", layout.endToEnd, "'end'", layout.endMargin, layout.goneEndMargin);
                g("'horizontalBias'", layout.horizontalBias, 0.5f);
                g("'verticalBias'", layout.verticalBias, 0.5f);
                c(layout.circleConstraint, layout.circleAngle, layout.circleRadius);
                writeGuideline(layout.orientation, layout.guideBegin, layout.guideEnd, layout.guidePercent);
                i("'dimensionRatio'", layout.dimensionRatio);
                h("'barrierMargin'", layout.mBarrierMargin);
                h("'type'", layout.mHelperType);
                i("'ReferenceId'", layout.mReferenceIdString);
                j("'mBarrierAllowsGoneWidgets'", layout.mBarrierAllowsGoneWidgets, true);
                h("'WrapBehavior'", layout.mWrapBehavior);
                f("'verticalWeight'", layout.verticalWeight);
                f("'horizontalWeight'", layout.horizontalWeight);
                h("'horizontalChainStyle'", layout.horizontalChainStyle);
                h("'verticalChainStyle'", layout.verticalChainStyle);
                h("'barrierDirection'", layout.mBarrierDirection);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    k("'ReferenceIds'", iArr);
                }
                this.f11163a.write("}\n");
            }
            this.f11163a.write("}\n");
        }

        public void f(String str, float f11) throws IOException {
            if (f11 != -1.0f) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11163a;
                writer2.write(": " + f11);
                this.f11163a.write(",\n");
            }
        }

        public void g(String str, float f11, float f12) throws IOException {
            if (f11 != f12) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11163a;
                writer2.write(": " + f11);
                this.f11163a.write(",\n");
            }
        }

        public void h(String str, int i11) throws IOException {
            if (i11 != 0 && i11 != -1) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                this.f11163a.write(CertificateUtil.DELIMITER);
                Writer writer2 = this.f11163a;
                writer2.write(IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11);
                this.f11163a.write(StringUtils.LF);
            }
        }

        public void i(String str, String str2) throws IOException {
            if (str2 != null) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                this.f11163a.write(CertificateUtil.DELIMITER);
                Writer writer2 = this.f11163a;
                writer2.write(IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2);
                this.f11163a.write(StringUtils.LF);
            }
        }

        public void j(String str, boolean z11, boolean z12) throws IOException {
            if (z11 != z12) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11163a;
                writer2.write(": " + z11);
                this.f11163a.write(",\n");
            }
        }

        public void k(String str, int[] iArr) throws IOException {
            String str2;
            if (iArr != null) {
                Writer writer = this.f11163a;
                writer.write(SPACE + str);
                this.f11163a.write(": ");
                for (int i11 = 0; i11 < iArr.length; i11++) {
                    Writer writer2 = this.f11163a;
                    StringBuilder sb2 = new StringBuilder();
                    if (i11 == 0) {
                        str2 = "[";
                    } else {
                        str2 = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                    }
                    sb2.append(str2);
                    sb2.append(a(iArr[i11]));
                    writer2.write(sb2.toString());
                }
                this.f11163a.write("],\n");
            }
        }
    }

    public class WriteXmlEngine {
        private static final String SPACE = "\n       ";

        /* renamed from: a  reason: collision with root package name */
        public Writer f11177a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintLayout f11178b;

        /* renamed from: c  reason: collision with root package name */
        public Context f11179c;

        /* renamed from: d  reason: collision with root package name */
        public int f11180d;

        /* renamed from: e  reason: collision with root package name */
        public int f11181e = 0;

        /* renamed from: f  reason: collision with root package name */
        public final String f11182f = "'left'";

        /* renamed from: g  reason: collision with root package name */
        public final String f11183g = "'right'";

        /* renamed from: h  reason: collision with root package name */
        public final String f11184h = "'baseline'";

        /* renamed from: i  reason: collision with root package name */
        public final String f11185i = "'bottom'";

        /* renamed from: j  reason: collision with root package name */
        public final String f11186j = "'top'";

        /* renamed from: k  reason: collision with root package name */
        public final String f11187k = "'start'";

        /* renamed from: l  reason: collision with root package name */
        public final String f11188l = "'end'";

        /* renamed from: m  reason: collision with root package name */
        public HashMap<Integer, String> f11189m = new HashMap<>();

        public WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i11) throws IOException {
            this.f11177a = writer;
            this.f11178b = constraintLayout;
            this.f11179c = constraintLayout.getContext();
            this.f11180d = i11;
        }

        private void writeBaseDimension(String str, int i11, int i12) throws IOException {
            if (i11 == i12) {
                return;
            }
            if (i11 == -2) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str + "=\"wrap_content\"");
            } else if (i11 == -1) {
                Writer writer2 = this.f11177a;
                writer2.write(SPACE + str + "=\"match_parent\"");
            } else {
                Writer writer3 = this.f11177a;
                writer3.write(SPACE + str + "=\"" + i11 + "dp\"");
            }
        }

        private void writeBoolen(String str, boolean z11, boolean z12) throws IOException {
            if (z11 != z12) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str + "=\"" + z11 + "dp\"");
            }
        }

        private void writeDimension(String str, int i11, int i12) throws IOException {
            if (i11 != i12) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str + "=\"" + i11 + "dp\"");
            }
        }

        private void writeEnum(String str, int i11, String[] strArr, int i12) throws IOException {
            if (i11 != i12) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str + "=\"" + strArr[i11] + "\"");
            }
        }

        public String a(int i11) {
            if (this.f11189m.containsKey(Integer.valueOf(i11))) {
                return "@+id/" + this.f11189m.get(Integer.valueOf(i11)) + "";
            } else if (i11 == 0) {
                return ConstraintSet.KEY_PERCENT_PARENT;
            } else {
                String b11 = b(i11);
                this.f11189m.put(Integer.valueOf(i11), b11);
                return "@+id/" + b11 + "";
            }
        }

        public String b(int i11) {
            if (i11 != -1) {
                try {
                    return this.f11179c.getResources().getResourceEntryName(i11);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unknown");
                    int i12 = this.f11181e + 1;
                    this.f11181e = i12;
                    sb2.append(i12);
                    return sb2.toString();
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unknown");
                int i13 = this.f11181e + 1;
                this.f11181e = i13;
                sb3.append(i13);
                return sb3.toString();
            }
        }

        public void c() throws IOException {
            this.f11177a.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                String a11 = a(num.intValue());
                this.f11177a.write("  <Constraint");
                Writer writer = this.f11177a;
                writer.write("\n       android:id=\"" + a11 + "\"");
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeBaseDimension("android:layout_width", layout.mWidth, -5);
                writeBaseDimension("android:layout_height", layout.mHeight, -5);
                d("app:layout_constraintGuide_begin", (float) layout.guideBegin, -1.0f);
                d("app:layout_constraintGuide_end", (float) layout.guideEnd, -1.0f);
                d("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                d("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                d("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                f("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                h("app:layout_constraintCircle", layout.circleConstraint);
                d("app:layout_constraintCircleRadius", (float) layout.circleRadius, 0.0f);
                d("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                d("android:orientation", (float) layout.orientation, -1.0f);
                d("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                d("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                d("app:layout_constraintHorizontal_chainStyle", (float) layout.horizontalChainStyle, 0.0f);
                d("app:layout_constraintVertical_chainStyle", (float) layout.verticalChainStyle, 0.0f);
                d("app:barrierDirection", (float) layout.mBarrierDirection, -1.0f);
                d("app:barrierMargin", (float) layout.mBarrierMargin, 0.0f);
                writeDimension("app:layout_marginLeft", layout.leftMargin, 0);
                writeDimension("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginRight", layout.rightMargin, 0);
                writeDimension("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginStart", layout.startMargin, 0);
                writeDimension("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginEnd", layout.endMargin, 0);
                writeDimension("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginTop", layout.topMargin, 0);
                writeDimension("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginBottom", layout.bottomMargin, 0);
                writeDimension("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                writeDimension("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                writeDimension("app:baselineMargin", layout.baselineMargin, 0);
                writeBoolen("app:layout_constrainedWidth", layout.constrainedWidth, false);
                writeBoolen("app:layout_constrainedHeight", layout.constrainedHeight, false);
                writeBoolen("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                d("app:layout_wrapBehaviorInParent", (float) layout.mWrapBehavior, 0.0f);
                h("app:baselineToBaseline", layout.baselineToBaseline);
                h("app:baselineToBottom", layout.baselineToBottom);
                h("app:baselineToTop", layout.baselineToTop);
                h("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                h("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                h("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                h("app:layout_constraintEnd_toStartOf", layout.endToStart);
                h("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                h("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                h("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                h("app:layout_constraintRight_toRightOf", layout.rightToRight);
                h("app:layout_constraintStart_toEndOf", layout.startToEnd);
                h("app:layout_constraintStart_toStartOf", layout.startToStart);
                h("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                h("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                writeEnum("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                d("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                writeDimension("app:layout_constraintHeight_min", layout.heightMin, 0);
                writeDimension("app:layout_constraintHeight_max", layout.heightMax, 0);
                writeBoolen("android:layout_constrainedHeight", layout.constrainedHeight, false);
                writeEnum("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                d("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                writeDimension("app:layout_constraintWidth_min", layout.widthMin, 0);
                writeDimension("app:layout_constraintWidth_max", layout.widthMax, 0);
                writeBoolen("android:layout_constrainedWidth", layout.constrainedWidth, false);
                d("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                d("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                e("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                e("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                writeEnum("app:barrierDirection", layout.mBarrierDirection, new String[]{"left", TtmlNode.RIGHT, ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "start", TtmlNode.END}, -1);
                f("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    g("'ReferenceIds'", iArr);
                }
                this.f11177a.write(" />\n");
            }
            this.f11177a.write("</ConstraintSet>\n");
        }

        public void d(String str, float f11, float f12) throws IOException {
            if (f11 != f12) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11177a;
                writer2.write("=\"" + f11 + "\"");
            }
        }

        public void e(String str, int i11) throws IOException {
            if (i11 != 0 && i11 != -1) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str + "=\"" + i11 + "\"\n");
            }
        }

        public void f(String str, String str2, String str3) throws IOException {
            if (str2 != null && !str2.equals(str3)) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11177a;
                writer2.write("=\"" + str2 + "\"");
            }
        }

        public void g(String str, int[] iArr) throws IOException {
            String str2;
            if (iArr != null) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str);
                this.f11177a.write(CertificateUtil.DELIMITER);
                for (int i11 = 0; i11 < iArr.length; i11++) {
                    Writer writer2 = this.f11177a;
                    StringBuilder sb2 = new StringBuilder();
                    if (i11 == 0) {
                        str2 = "[";
                    } else {
                        str2 = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                    }
                    sb2.append(str2);
                    sb2.append(a(iArr[i11]));
                    writer2.write(sb2.toString());
                }
                this.f11177a.write("],\n");
            }
        }

        public void h(String str, int i11) throws IOException {
            if (i11 != -1) {
                Writer writer = this.f11177a;
                writer.write(SPACE + str);
                Writer writer2 = this.f11177a;
                writer2.write("=\"" + a(i11) + "\"");
            }
        }
    }

    static {
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = overrideMapToConstant;
        int i11 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i11, 6);
        overrideMapToConstant.append(i11, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (this.mSavedAttributes.containsKey(strArr[i11])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i11]);
                if (!(constraintAttribute == null || constraintAttribute.getType() == attributeType)) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i11], new ConstraintAttribute(strArr[i11], attributeType));
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        populateOverride(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] convertReferenceString(View view, String str) {
        int i11;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i12 = 0;
        int i13 = 0;
        while (i12 < split.length) {
            String trim = split[i12].trim();
            try {
                i11 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i11 = 0;
            }
            if (i11 == 0) {
                i11 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i11 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i11 = ((Integer) designInformation).intValue();
            }
            iArr[i13] = i11;
            i12++;
            i13++;
        }
        if (i13 != split.length) {
            return Arrays.copyOf(iArr, i13);
        }
        return iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z11) {
        int[] iArr;
        Constraint constraint = new Constraint();
        if (z11) {
            iArr = R.styleable.ConstraintOverride;
        } else {
            iArr = R.styleable.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        populateConstraint(context, constraint, obtainStyledAttributes, z11);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i11) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i11))) {
            this.mConstraints.put(Integer.valueOf(i11), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L_0x006f
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L_0x0026
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L_0x0022
            r6 = -3
            if (r5 == r6) goto L_0x0020
            if (r5 == r0) goto L_0x002a
            r6 = -1
            if (r5 == r6) goto L_0x002a
        L_0x0020:
            r5 = r2
            goto L_0x002d
        L_0x0022:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L_0x002d
        L_0x0026:
            int r5 = r5.getDimensionPixelSize(r6, r2)
        L_0x002a:
            r3 = r2
            r2 = r5
            r5 = r3
        L_0x002d:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L_0x003f
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L_0x003a
            r4.width = r2
            r4.constrainedWidth = r5
            goto L_0x006e
        L_0x003a:
            r4.height = r2
            r4.constrainedHeight = r5
            goto L_0x006e
        L_0x003f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r6 == 0) goto L_0x0051
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r4
            if (r7 != 0) goto L_0x004c
            r4.mWidth = r2
            r4.constrainedWidth = r5
            goto L_0x006e
        L_0x004c:
            r4.mHeight = r2
            r4.constrainedHeight = r5
            goto L_0x006e
        L_0x0051:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r6 == 0) goto L_0x006e
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r4 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r4
            if (r7 != 0) goto L_0x0064
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            goto L_0x006e
        L_0x0064:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L_0x006e:
            return
        L_0x006f:
            java.lang.String r5 = r5.getString(r6)
            j(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.i(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void j(Object obj, String str, int i11) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if (KEY_RATIO.equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i11 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            k(layoutParams, trim2);
                        } else if (obj instanceof Layout) {
                            ((Layout) obj).dimensionRatio = trim2;
                        } else if (obj instanceof Constraint.Delta) {
                            ((Constraint.Delta) obj).c(5, trim2);
                        }
                    } else if (KEY_WEIGHT.equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i11 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.horizontalWeight = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.verticalWeight = parseFloat;
                            } else if (obj instanceof Layout) {
                                Layout layout = (Layout) obj;
                                if (i11 == 0) {
                                    layout.mWidth = 0;
                                    layout.horizontalWeight = parseFloat;
                                    return;
                                }
                                layout.mHeight = 0;
                                layout.verticalWeight = parseFloat;
                            } else if (obj instanceof Constraint.Delta) {
                                Constraint.Delta delta = (Constraint.Delta) obj;
                                if (i11 == 0) {
                                    delta.b(23, 0);
                                    delta.a(39, parseFloat);
                                    return;
                                }
                                delta.b(21, 0);
                                delta.a(40, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if (KEY_PERCENT_PARENT.equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i11 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.matchConstraintPercentWidth = max;
                                layoutParams3.matchConstraintDefaultWidth = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.matchConstraintPercentHeight = max;
                            layoutParams3.matchConstraintDefaultHeight = 2;
                        } else if (obj instanceof Layout) {
                            Layout layout2 = (Layout) obj;
                            if (i11 == 0) {
                                layout2.mWidth = 0;
                                layout2.widthPercent = max;
                                layout2.widthDefault = 2;
                                return;
                            }
                            layout2.mHeight = 0;
                            layout2.heightPercent = max;
                            layout2.heightDefault = 2;
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                            if (i11 == 0) {
                                delta2.b(23, 0);
                                delta2.b(54, 2);
                                return;
                            }
                            delta2.b(21, 0);
                            delta2.b(55, 2);
                        }
                    }
                }
            }
        }
    }

    public static void k(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f11 = Float.NaN;
        int i11 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i12 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i11 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i11 = 1;
                }
                i12 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i12);
                if (substring2.length() > 0) {
                    f11 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i12, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f11 = i11 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.dimensionRatio = str;
        layoutParams.f11105c = f11;
        layoutParams.f11106d = i11;
    }

    /* access modifiers changed from: private */
    public static int lookupID(TypedArray typedArray, int i11, int i12) {
        int resourceId = typedArray.getResourceId(i11, i12);
        if (resourceId == -1) {
            return typedArray.getInt(i11, -1);
        }
        return resourceId;
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray, boolean z11) {
        if (z11) {
            populateOverride(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.f11148a = typedArray.getResourceId(index, constraint.f11148a);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Motion motion5 = constraint.motion;
                    motion5.mAnimateCircleAngleTo = typedArray.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case 83:
                    Transform transform12 = constraint.transform;
                    transform12.transformPivotTarget = lookupID(typedArray, index, transform12.transformPivotTarget);
                    break;
                case 84:
                    Motion motion6 = constraint.motion;
                    motion6.mQuantizeMotionSteps = typedArray.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case 85:
                    Motion motion7 = constraint.motion;
                    motion7.mQuantizeMotionPhase = typedArray.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            Motion motion8 = constraint.motion;
                            motion8.mQuantizeInterpolatorType = typedArray.getInteger(index, motion8.mQuantizeInterpolatorID);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        Motion motion9 = constraint.motion;
                        if (motion9.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            motion9.mQuantizeInterpolatorType = -2;
                            break;
                        }
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.layout;
                    layout54.baselineToTop = lookupID(typedArray, index, layout54.baselineToTop);
                    break;
                case 92:
                    Layout layout55 = constraint.layout;
                    layout55.baselineToBottom = lookupID(typedArray, index, layout55.baselineToBottom);
                    break;
                case 93:
                    Layout layout56 = constraint.layout;
                    layout56.baselineMargin = typedArray.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case 94:
                    Layout layout57 = constraint.layout;
                    layout57.goneBaselineMargin = typedArray.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case 95:
                    i(constraint.layout, typedArray, index, 0);
                    break;
                case 96:
                    i(constraint.layout, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.layout;
                    layout58.mWrapBehavior = typedArray.getInt(index, layout58.mWrapBehavior);
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
            }
        }
        Layout layout59 = constraint.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private static void populateOverride(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.f11150c = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.b(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 5:
                    delta.c(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.b(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.b(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    delta.b(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                    break;
                case 11:
                    delta.b(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.b(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.b(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.b(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.b(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.b(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.b(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.b(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.a(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.a(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.b(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.b(22, VISIBILITY_FLAGS[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.b(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.b(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.b(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.b(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    delta.b(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                    break;
                case 34:
                    delta.b(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.a(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f11148a);
                    constraint.f11148a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.a(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.b(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.b(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.a(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    delta.d(44, true);
                    delta.a(44, typedArray.getDimension(index, constraint.transform.elevation));
                    break;
                case 45:
                    delta.a(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.a(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.a(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.a(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.a(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.a(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.a(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.a(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    delta.a(53, typedArray.getDimension(index, constraint.transform.translationZ));
                    break;
                case 54:
                    delta.b(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.b(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    delta.b(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    delta.b(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    delta.b(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    delta.b(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    delta.a(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    delta.b(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.a(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    delta.b(64, lookupID(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        delta.c(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        delta.c(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    delta.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.a(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    delta.a(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    delta.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.b(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.c(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.d(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.b(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.c(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.b(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.a(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    delta.d(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    delta.d(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    delta.b(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.b(83, lookupID(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.b(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.a(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            Motion motion = constraint.motion;
                            motion.mQuantizeInterpolatorType = typedArray.getInteger(index, motion.mQuantizeInterpolatorID);
                            delta.b(88, constraint.motion.mQuantizeInterpolatorType);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            delta.c(90, constraint.motion.mQuantizeInterpolatorString);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                delta.b(88, -1);
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                delta.b(89, constraint.motion.mQuantizeInterpolatorID);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                delta.b(88, -2);
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.b(89, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion2 = constraint.motion;
                        if (motion2.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            motion2.mQuantizeInterpolatorType = -2;
                            delta.b(88, -2);
                            break;
                        }
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 93:
                    delta.b(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    delta.b(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    i(delta, typedArray, index, 0);
                    break;
                case 96:
                    i(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.b(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (!MotionLayout.IS_IN_EDIT_MODE) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.f11148a = typedArray.getResourceId(index, constraint.f11148a);
                            break;
                        } else {
                            constraint.f11149b = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f11148a);
                        constraint.f11148a = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            constraint.f11149b = typedArray.getString(index);
                            break;
                        }
                    }
                case 99:
                    delta.d(99, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i11, float f11) {
        if (i11 == 19) {
            constraint.layout.guidePercent = f11;
        } else if (i11 == 20) {
            constraint.layout.horizontalBias = f11;
        } else if (i11 == 37) {
            constraint.layout.verticalBias = f11;
        } else if (i11 == 60) {
            constraint.transform.rotation = f11;
        } else if (i11 == 63) {
            constraint.layout.circleAngle = f11;
        } else if (i11 == 79) {
            constraint.motion.mMotionStagger = f11;
        } else if (i11 == 85) {
            constraint.motion.mQuantizeMotionPhase = f11;
        } else if (i11 == 87) {
        } else {
            if (i11 == 39) {
                constraint.layout.horizontalWeight = f11;
            } else if (i11 != 40) {
                switch (i11) {
                    case 43:
                        constraint.propertySet.alpha = f11;
                        return;
                    case 44:
                        Transform transform = constraint.transform;
                        transform.elevation = f11;
                        transform.applyElevation = true;
                        return;
                    case 45:
                        constraint.transform.rotationX = f11;
                        return;
                    case 46:
                        constraint.transform.rotationY = f11;
                        return;
                    case 47:
                        constraint.transform.scaleX = f11;
                        return;
                    case 48:
                        constraint.transform.scaleY = f11;
                        return;
                    case 49:
                        constraint.transform.transformPivotX = f11;
                        return;
                    case 50:
                        constraint.transform.transformPivotY = f11;
                        return;
                    case 51:
                        constraint.transform.translationX = f11;
                        return;
                    case 52:
                        constraint.transform.translationY = f11;
                        return;
                    case 53:
                        constraint.transform.translationZ = f11;
                        return;
                    default:
                        switch (i11) {
                            case 67:
                                constraint.motion.mPathRotate = f11;
                                return;
                            case 68:
                                constraint.propertySet.mProgress = f11;
                                return;
                            case 69:
                                constraint.layout.widthPercent = f11;
                                return;
                            case 70:
                                constraint.layout.heightPercent = f11;
                                return;
                            default:
                                Log.w(TAG, "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.layout.verticalWeight = f11;
            }
        }
    }

    private String sideToString(int i11) {
        switch (i11) {
            case 1:
                return "left";
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return AdError.UNDEFINED_DOMAIN;
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z11 = false;
        for (int i12 = 0; i12 < charArray.length; i12++) {
            char c11 = charArray[i12];
            if (c11 == ',' && !z11) {
                arrayList.add(new String(charArray, i11, i12 - i11));
                i11 = i12 + 1;
            } else if (c11 == '\"') {
                z11 = !z11;
            }
        }
        arrayList.add(new String(charArray, i11, charArray.length - i11));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i11, int i12, int i13) {
        int i14;
        int i15;
        if (i12 == 0) {
            i14 = 1;
        } else {
            i14 = 2;
        }
        connect(i11, 1, i12, i14, 0);
        if (i13 == 0) {
            i15 = 2;
        } else {
            i15 = 1;
        }
        connect(i11, 2, i13, i15, 0);
        if (i12 != 0) {
            connect(i12, 2, i11, 1, 0);
        }
        if (i13 != 0) {
            connect(i13, 1, i11, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i11, int i12, int i13) {
        int i14;
        int i15;
        if (i12 == 0) {
            i14 = 6;
        } else {
            i14 = 7;
        }
        connect(i11, 6, i12, i14, 0);
        if (i13 == 0) {
            i15 = 7;
        } else {
            i15 = 6;
        }
        connect(i11, 7, i13, i15, 0);
        if (i12 != 0) {
            connect(i12, 7, i11, 6, 0);
        }
        if (i13 != 0) {
            connect(i13, 6, i11, 7, 0);
        }
    }

    public void addToVerticalChain(int i11, int i12, int i13) {
        int i14;
        int i15;
        if (i12 == 0) {
            i14 = 3;
        } else {
            i14 = 4;
        }
        connect(i11, 3, i12, i14, 0);
        if (i13 == 0) {
            i15 = 4;
        } else {
            i15 = 3;
        }
        connect(i11, 4, i13, i15, 0);
        if (i12 != 0) {
            connect(i12, 4, i11, 3, 0);
        }
        if (i13 != 0) {
            connect(i13, 3, i11, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.mConstraints.containsKey(Integer.valueOf(id2)) && (constraint = this.mConstraints.get(Integer.valueOf(id2))) != null) {
                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint next : constraintSet.mConstraints.values()) {
            if (next.f11150c != null) {
                if (next.f11149b != null) {
                    for (Integer intValue : this.mConstraints.keySet()) {
                        Constraint constraint = getConstraint(intValue.intValue());
                        String str = constraint.layout.mConstraintTag;
                        if (str != null && next.f11149b.matches(str)) {
                            next.f11150c.e(constraint);
                            constraint.mCustomConstraints.putAll((HashMap) next.mCustomConstraints.clone());
                        }
                    }
                } else {
                    next.f11150c.e(getConstraint(next.f11148a));
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        h(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id2 = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id2)) && (constraint = this.mConstraints.get(Integer.valueOf(id2))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void applyToLayoutParams(int i11, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (this.mConstraints.containsKey(Integer.valueOf(i11)) && (constraint = this.mConstraints.get(Integer.valueOf(i11))) != null) {
            constraint.applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        h(constraintLayout, false);
        constraintLayout.setConstraintSet((ConstraintSet) null);
    }

    public void center(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11) {
        int i18 = i13;
        float f12 = f11;
        if (i14 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i17 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f12 <= 0.0f || f12 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i18 == 1 || i18 == 2) {
            int i19 = i11;
            connect(i19, 1, i12, i13, i14);
            connect(i19, 2, i15, i16, i17);
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
            if (constraint != null) {
                constraint.layout.horizontalBias = f12;
            }
        } else if (i18 == 6 || i18 == 7) {
            int i21 = i11;
            connect(i21, 6, i12, i13, i14);
            connect(i21, 7, i15, i16, i17);
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(i11));
            if (constraint2 != null) {
                constraint2.layout.horizontalBias = f12;
            }
        } else {
            int i22 = i11;
            connect(i22, 3, i12, i13, i14);
            connect(i22, 4, i15, i16, i17);
            Constraint constraint3 = this.mConstraints.get(Integer.valueOf(i11));
            if (constraint3 != null) {
                constraint3.layout.verticalBias = f12;
            }
        }
    }

    public void centerHorizontally(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11) {
        connect(i11, 1, i12, i13, i14);
        connect(i11, 2, i15, i16, i17);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
        if (constraint != null) {
            constraint.layout.horizontalBias = f11;
        }
    }

    public void centerHorizontallyRtl(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11) {
        connect(i11, 6, i12, i13, i14);
        connect(i11, 7, i15, i16, i17);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
        if (constraint != null) {
            constraint.layout.horizontalBias = f11;
        }
    }

    public void centerVertically(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11) {
        connect(i11, 3, i12, i13, i14);
        connect(i11, 4, i15, i16, i17);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
        if (constraint != null) {
            constraint.layout.verticalBias = f11;
        }
    }

    public void clear(int i11) {
        this.mConstraints.remove(Integer.valueOf(i11));
    }

    public void clone(Context context, int i11) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i11, (ViewGroup) null));
    }

    public void connect(int i11, int i12, int i13, int i14, int i15) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i11))) {
            this.mConstraints.put(Integer.valueOf(i11), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
        if (constraint != null) {
            switch (i12) {
                case 1:
                    if (i14 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i13;
                        layout.leftToRight = -1;
                    } else if (i14 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i13;
                        layout2.leftToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.leftMargin = i15;
                    return;
                case 2:
                    if (i14 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i13;
                        layout3.rightToRight = -1;
                    } else if (i14 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i13;
                        layout4.rightToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.rightMargin = i15;
                    return;
                case 3:
                    if (i14 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i13;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                        layout5.baselineToTop = -1;
                        layout5.baselineToBottom = -1;
                    } else if (i14 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i13;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                        layout6.baselineToTop = -1;
                        layout6.baselineToBottom = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.topMargin = i15;
                    return;
                case 4:
                    if (i14 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i13;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                        layout7.baselineToTop = -1;
                        layout7.baselineToBottom = -1;
                    } else if (i14 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i13;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                        layout8.baselineToTop = -1;
                        layout8.baselineToBottom = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.bottomMargin = i15;
                    return;
                case 5:
                    if (i14 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i13;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    } else if (i14 == 3) {
                        Layout layout10 = constraint.layout;
                        layout10.baselineToTop = i13;
                        layout10.bottomToBottom = -1;
                        layout10.bottomToTop = -1;
                        layout10.topToTop = -1;
                        layout10.topToBottom = -1;
                        return;
                    } else if (i14 == 4) {
                        Layout layout11 = constraint.layout;
                        layout11.baselineToBottom = i13;
                        layout11.bottomToBottom = -1;
                        layout11.bottomToTop = -1;
                        layout11.topToTop = -1;
                        layout11.topToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 6:
                    if (i14 == 6) {
                        Layout layout12 = constraint.layout;
                        layout12.startToStart = i13;
                        layout12.startToEnd = -1;
                    } else if (i14 == 7) {
                        Layout layout13 = constraint.layout;
                        layout13.startToEnd = i13;
                        layout13.startToStart = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.startMargin = i15;
                    return;
                case 7:
                    if (i14 == 7) {
                        Layout layout14 = constraint.layout;
                        layout14.endToEnd = i13;
                        layout14.endToStart = -1;
                    } else if (i14 == 6) {
                        Layout layout15 = constraint.layout;
                        layout15.endToStart = i13;
                        layout15.endToEnd = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                    constraint.layout.endMargin = i15;
                    return;
                default:
                    throw new IllegalArgumentException(sideToString(i12) + " to " + sideToString(i14) + " unknown");
            }
        }
    }

    public void constrainCircle(int i11, int i12, int i13, float f11) {
        Layout layout = get(i11).layout;
        layout.circleConstraint = i12;
        layout.circleRadius = i13;
        layout.circleAngle = f11;
    }

    public void constrainDefaultHeight(int i11, int i12) {
        get(i11).layout.heightDefault = i12;
    }

    public void constrainDefaultWidth(int i11, int i12) {
        get(i11).layout.widthDefault = i12;
    }

    public void constrainHeight(int i11, int i12) {
        get(i11).layout.mHeight = i12;
    }

    public void constrainMaxHeight(int i11, int i12) {
        get(i11).layout.heightMax = i12;
    }

    public void constrainMaxWidth(int i11, int i12) {
        get(i11).layout.widthMax = i12;
    }

    public void constrainMinHeight(int i11, int i12) {
        get(i11).layout.heightMin = i12;
    }

    public void constrainMinWidth(int i11, int i12) {
        get(i11).layout.widthMin = i12;
    }

    public void constrainPercentHeight(int i11, float f11) {
        get(i11).layout.heightPercent = f11;
    }

    public void constrainPercentWidth(int i11, float f11) {
        get(i11).layout.widthPercent = f11;
    }

    public void constrainWidth(int i11, int i12) {
        get(i11).layout.mWidth = i12;
    }

    public void constrainedHeight(int i11, boolean z11) {
        get(i11).layout.constrainedHeight = z11;
    }

    public void constrainedWidth(int i11, boolean z11) {
        get(i11).layout.constrainedWidth = z11;
    }

    public void create(int i11, int i12) {
        Layout layout = get(i11).layout;
        layout.mIsGuideline = true;
        layout.orientation = i12;
    }

    public void createBarrier(int i11, int i12, int i13, int... iArr) {
        Layout layout = get(i11).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i12;
        layout.mBarrierMargin = i13;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i11, int i12, int i13, int i14, int[] iArr, float[] fArr, int i15) {
        createHorizontalChain(i11, i12, i13, i14, iArr, fArr, i15, 1, 2);
    }

    public void createHorizontalChainRtl(int i11, int i12, int i13, int i14, int[] iArr, float[] fArr, int i15) {
        createHorizontalChain(i11, i12, i13, i14, iArr, fArr, i15, 6, 7);
    }

    public void createVerticalChain(int i11, int i12, int i13, int i14, int[] iArr, float[] fArr, int i15) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                get(iArr2[0]).layout.verticalWeight = fArr2[0];
            }
            get(iArr2[0]).layout.verticalChainStyle = i15;
            connect(iArr2[0], 3, i11, i12, 0);
            for (int i16 = 1; i16 < iArr2.length; i16++) {
                int i17 = i16 - 1;
                connect(iArr2[i16], 3, iArr2[i17], 4, 0);
                connect(iArr2[i17], 4, iArr2[i16], 3, 0);
                if (fArr2 != null) {
                    get(iArr2[i16]).layout.verticalWeight = fArr2[i16];
                }
            }
            connect(iArr2[iArr2.length - 1], 4, i13, i14, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int valueOf : iArr) {
                hashSet.add(Integer.valueOf(valueOf));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb2 = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            if (constraint != null) {
                sb2.append("<Constraint id=");
                sb2.append(num);
                sb2.append(" \n");
                constraint.layout.dump(motionScene, sb2);
                sb2.append("/>\n");
            }
        }
        System.out.println(sb2.toString());
    }

    public boolean getApplyElevation(int i11) {
        return get(i11).transform.applyElevation;
    }

    public Constraint getConstraint(int i11) {
        if (this.mConstraints.containsKey(Integer.valueOf(i11))) {
            return this.mConstraints.get(Integer.valueOf(i11));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i11) {
        return get(i11).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i11) {
        return get(i11);
    }

    public int[] getReferencedIds(int i11) {
        int[] iArr = get(i11).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i11) {
        return get(i11).propertySet.visibility;
    }

    public int getVisibilityMode(int i11) {
        return get(i11).propertySet.mVisibilityMode;
    }

    public int getWidth(int i11) {
        return get(i11).layout.mWidth;
    }

    public void h(ConstraintLayout constraintLayout, boolean z11) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.mConstraints.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
                    if (constraint != null) {
                        if (childAt instanceof Barrier) {
                            constraint.layout.mHelperType = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraint.layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                            Layout layout = constraint.layout;
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.mReferenceIdString;
                                if (str != null) {
                                    layout.mReferenceIds = convertReferenceString(barrier, str);
                                    barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        if (z11) {
                            ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.propertySet;
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(constraint.propertySet.alpha);
                        childAt.setRotation(constraint.transform.rotation);
                        childAt.setRotationX(constraint.transform.rotationX);
                        childAt.setRotationY(constraint.transform.rotationY);
                        childAt.setScaleX(constraint.transform.scaleX);
                        childAt.setScaleY(constraint.transform.scaleY);
                        Transform transform = constraint.transform;
                        if (transform.transformPivotTarget != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget);
                            if (findViewById != null) {
                                float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(left - ((float) childAt.getLeft()));
                                    childAt.setPivotY(top - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(transform.transformPivotX)) {
                                childAt.setPivotX(constraint.transform.transformPivotX);
                            }
                            if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                childAt.setPivotY(constraint.transform.transformPivotY);
                            }
                        }
                        childAt.setTranslationX(constraint.transform.translationX);
                        childAt.setTranslationY(constraint.transform.translationY);
                        childAt.setTranslationZ(constraint.transform.translationZ);
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            childAt.setElevation(transform2.elevation);
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("WARNING NO CONSTRAINTS for view ");
                    sb2.append(id2);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).c(constraintLayout);
            }
        }
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name2 = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name2.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.f11148a), fillFromAttributeList);
                }
            }
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        } catch (IOException e12) {
            e12.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i11 = 0; i11 < split.length; i11++) {
            String[] split2 = split[i11].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i11]);
            } else {
                constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i11 = 0; i11 < split.length; i11++) {
            String[] split2 = split[i11].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i11]);
            } else {
                constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i11 = 0; i11 < split.length; i11++) {
            String[] split2 = split[i11].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i11]);
            } else {
                constraint.setFloatValue(split2[0], (float) Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] splitString = splitString(str);
        for (int i11 = 0; i11 < splitString.length; i11++) {
            String[] split = splitString[i11].split("=");
            Log.w(TAG, " Unable to parse " + splitString[i11]);
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer next : constraintSet.mConstraints.keySet()) {
            int intValue = next.intValue();
            Constraint constraint = constraintSet.mConstraints.get(next);
            if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String next2 : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(next2)) {
                        constraint2.mCustomConstraints.put(next2, constraint.mCustomConstraints.get(next2));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i11) {
        Constraint constraint;
        if (this.mConstraints.containsKey(Integer.valueOf(i11)) && (constraint = this.mConstraints.get(Integer.valueOf(i11))) != null) {
            Layout layout = constraint.layout;
            int i12 = layout.leftToRight;
            int i13 = layout.rightToLeft;
            if (i12 == -1 && i13 == -1) {
                int i14 = layout.startToEnd;
                int i15 = layout.endToStart;
                if (!(i14 == -1 && i15 == -1)) {
                    if (i14 != -1 && i15 != -1) {
                        connect(i14, 7, i15, 6, 0);
                        connect(i15, 6, i12, 7, 0);
                    } else if (i15 != -1) {
                        int i16 = layout.rightToRight;
                        if (i16 != -1) {
                            connect(i12, 7, i16, 7, 0);
                        } else {
                            int i17 = layout.leftToLeft;
                            if (i17 != -1) {
                                connect(i15, 6, i17, 6, 0);
                            }
                        }
                    }
                }
                clear(i11, 6);
                clear(i11, 7);
                return;
            }
            if (i12 == -1 || i13 == -1) {
                int i18 = layout.rightToRight;
                if (i18 != -1) {
                    connect(i12, 2, i18, 2, 0);
                } else {
                    int i19 = layout.leftToLeft;
                    if (i19 != -1) {
                        connect(i13, 1, i19, 1, 0);
                    }
                }
            } else {
                connect(i12, 2, i13, 1, 0);
                connect(i13, 1, i12, 2, 0);
            }
            clear(i11, 1);
            clear(i11, 2);
        }
    }

    public void removeFromVerticalChain(int i11) {
        if (this.mConstraints.containsKey(Integer.valueOf(i11))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
            if (constraint != null) {
                Layout layout = constraint.layout;
                int i12 = layout.topToBottom;
                int i13 = layout.bottomToTop;
                if (!(i12 == -1 && i13 == -1)) {
                    if (i12 == -1 || i13 == -1) {
                        int i14 = layout.bottomToBottom;
                        if (i14 != -1) {
                            connect(i12, 4, i14, 4, 0);
                        } else {
                            int i15 = layout.topToTop;
                            if (i15 != -1) {
                                connect(i13, 3, i15, 3, 0);
                            }
                        }
                    } else {
                        connect(i12, 4, i13, 3, 0);
                        connect(i13, 3, i12, 4, 0);
                    }
                }
            } else {
                return;
            }
        }
        clear(i11, 3);
        clear(i11, 4);
    }

    public void setAlpha(int i11, float f11) {
        get(i11).propertySet.alpha = f11;
    }

    public void setApplyElevation(int i11, boolean z11) {
        get(i11).transform.applyElevation = z11;
    }

    public void setBarrierType(int i11, int i12) {
        get(i11).layout.mHelperType = i12;
    }

    public void setColorValue(int i11, String str, int i12) {
        get(i11).setColorValue(str, i12);
    }

    public void setDimensionRatio(int i11, String str) {
        get(i11).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i11, int i12) {
        get(i11).layout.editorAbsoluteX = i12;
    }

    public void setEditorAbsoluteY(int i11, int i12) {
        get(i11).layout.editorAbsoluteY = i12;
    }

    public void setElevation(int i11, float f11) {
        get(i11).transform.elevation = f11;
        get(i11).transform.applyElevation = true;
    }

    public void setFloatValue(int i11, String str, float f11) {
        get(i11).setFloatValue(str, f11);
    }

    public void setForceId(boolean z11) {
        this.mForceId = z11;
    }

    public void setGoneMargin(int i11, int i12, int i13) {
        Constraint constraint = get(i11);
        switch (i12) {
            case 1:
                constraint.layout.goneLeftMargin = i13;
                return;
            case 2:
                constraint.layout.goneRightMargin = i13;
                return;
            case 3:
                constraint.layout.goneTopMargin = i13;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i13;
                return;
            case 5:
                constraint.layout.goneBaselineMargin = i13;
                return;
            case 6:
                constraint.layout.goneStartMargin = i13;
                return;
            case 7:
                constraint.layout.goneEndMargin = i13;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i11, int i12) {
        get(i11).layout.guideBegin = i12;
        get(i11).layout.guideEnd = -1;
        get(i11).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i11, int i12) {
        get(i11).layout.guideEnd = i12;
        get(i11).layout.guideBegin = -1;
        get(i11).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i11, float f11) {
        get(i11).layout.guidePercent = f11;
        get(i11).layout.guideEnd = -1;
        get(i11).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i11, float f11) {
        get(i11).layout.horizontalBias = f11;
    }

    public void setHorizontalChainStyle(int i11, int i12) {
        get(i11).layout.horizontalChainStyle = i12;
    }

    public void setHorizontalWeight(int i11, float f11) {
        get(i11).layout.horizontalWeight = f11;
    }

    public void setIntValue(int i11, String str, int i12) {
        get(i11).setIntValue(str, i12);
    }

    public void setLayoutWrapBehavior(int i11, int i12) {
        if (i12 >= 0 && i12 <= 3) {
            get(i11).layout.mWrapBehavior = i12;
        }
    }

    public void setMargin(int i11, int i12, int i13) {
        Constraint constraint = get(i11);
        switch (i12) {
            case 1:
                constraint.layout.leftMargin = i13;
                return;
            case 2:
                constraint.layout.rightMargin = i13;
                return;
            case 3:
                constraint.layout.topMargin = i13;
                return;
            case 4:
                constraint.layout.bottomMargin = i13;
                return;
            case 5:
                constraint.layout.baselineMargin = i13;
                return;
            case 6:
                constraint.layout.startMargin = i13;
                return;
            case 7:
                constraint.layout.endMargin = i13;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i11, int... iArr) {
        get(i11).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i11, float f11) {
        get(i11).transform.rotation = f11;
    }

    public void setRotationX(int i11, float f11) {
        get(i11).transform.rotationX = f11;
    }

    public void setRotationY(int i11, float f11) {
        get(i11).transform.rotationY = f11;
    }

    public void setScaleX(int i11, float f11) {
        get(i11).transform.scaleX = f11;
    }

    public void setScaleY(int i11, float f11) {
        get(i11).transform.scaleY = f11;
    }

    public void setStringValue(int i11, String str, String str2) {
        get(i11).setStringValue(str, str2);
    }

    public void setTransformPivot(int i11, float f11, float f12) {
        Transform transform = get(i11).transform;
        transform.transformPivotY = f12;
        transform.transformPivotX = f11;
    }

    public void setTransformPivotX(int i11, float f11) {
        get(i11).transform.transformPivotX = f11;
    }

    public void setTransformPivotY(int i11, float f11) {
        get(i11).transform.transformPivotY = f11;
    }

    public void setTranslation(int i11, float f11, float f12) {
        Transform transform = get(i11).transform;
        transform.translationX = f11;
        transform.translationY = f12;
    }

    public void setTranslationX(int i11, float f11) {
        get(i11).transform.translationX = f11;
    }

    public void setTranslationY(int i11, float f11) {
        get(i11).transform.translationY = f11;
    }

    public void setTranslationZ(int i11, float f11) {
        get(i11).transform.translationZ = f11;
    }

    public void setValidateOnParse(boolean z11) {
        this.mValidate = z11;
    }

    public void setVerticalBias(int i11, float f11) {
        get(i11).layout.verticalBias = f11;
    }

    public void setVerticalChainStyle(int i11, int i12) {
        get(i11).layout.verticalChainStyle = i12;
    }

    public void setVerticalWeight(int i11, float f11) {
        get(i11).layout.verticalWeight = f11;
    }

    public void setVisibility(int i11, int i12) {
        get(i11).propertySet.visibility = i12;
    }

    public void setVisibilityMode(int i11, int i12) {
        get(i11).propertySet.mVisibilityMode = i12;
    }

    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i11) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i11 & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i11).c();
        } else {
            new WriteJsonEngine(writer, constraintLayout, i11).e();
        }
        writer.write("\n---------------------------------------------\n");
    }

    private void createHorizontalChain(int i11, int i12, int i13, int i14, int[] iArr, float[] fArr, int i15, int i16, int i17) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                get(iArr2[0]).layout.horizontalWeight = fArr2[0];
            }
            get(iArr2[0]).layout.horizontalChainStyle = i15;
            connect(iArr2[0], i16, i11, i12, -1);
            for (int i18 = 1; i18 < iArr2.length; i18++) {
                int i19 = i18 - 1;
                connect(iArr2[i18], i16, iArr2[i19], i17, -1);
                connect(iArr2[i19], i17, iArr2[i18], i16, -1);
                if (fArr2 != null) {
                    get(iArr2[i18]).layout.horizontalWeight = fArr2[i18];
                }
            }
            connect(iArr2[iArr2.length - 1], i17, i13, i14, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void clear(int i11, int i12) {
        Constraint constraint;
        if (this.mConstraints.containsKey(Integer.valueOf(i11)) && (constraint = this.mConstraints.get(Integer.valueOf(i11))) != null) {
            switch (i12) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = Integer.MIN_VALUE;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = Integer.MIN_VALUE;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = 0;
                    layout3.goneTopMargin = Integer.MIN_VALUE;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = 0;
                    layout4.goneBottomMargin = Integer.MIN_VALUE;
                    return;
                case 5:
                    Layout layout5 = constraint.layout;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    layout5.baselineMargin = 0;
                    layout5.goneBaselineMargin = Integer.MIN_VALUE;
                    return;
                case 6:
                    Layout layout6 = constraint.layout;
                    layout6.startToEnd = -1;
                    layout6.startToStart = -1;
                    layout6.startMargin = 0;
                    layout6.goneStartMargin = Integer.MIN_VALUE;
                    return;
                case 7:
                    Layout layout7 = constraint.layout;
                    layout7.endToStart = -1;
                    layout7.endToEnd = -1;
                    layout7.endMargin = 0;
                    layout7.goneEndMargin = Integer.MIN_VALUE;
                    return;
                case 8:
                    Layout layout8 = constraint.layout;
                    layout8.circleAngle = -1.0f;
                    layout8.circleRadius = -1;
                    layout8.circleConstraint = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer next : constraintSet.mConstraints.keySet()) {
            Constraint constraint = constraintSet.mConstraints.get(next);
            if (constraint != null) {
                this.mConstraints.put(next, constraint.clone());
            }
        }
    }

    public void centerHorizontally(int i11, int i12) {
        if (i12 == 0) {
            center(i11, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i11, i12, 2, 0, i12, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i11, int i12) {
        if (i12 == 0) {
            center(i11, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i11, i12, 7, 0, i12, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i11, int i12) {
        if (i12 == 0) {
            center(i11, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i11, i12, 4, 0, i12, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.mForceId || id2 != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                    this.mConstraints.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
                if (constraint != null) {
                    constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                    constraint.fillFrom(id2, layoutParams);
                    constraint.propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform2 = constraint.transform;
                    if (transform2.applyElevation) {
                        transform2.elevation = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                        constraint.layout.mReferenceIds = barrier.getReferencedIds();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01da
            if (r0 == 0) goto L_0x01c8
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0015
            goto L_0x01cb
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r7
            goto L_0x004e
        L_0x0031:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r6
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r3
            goto L_0x004e
        L_0x0045:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r5) goto L_0x0058
            goto L_0x01cb
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r0 = r9.mConstraints     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r3 = r2.f11148a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2 = r1
            goto L_0x01cb
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r7
            goto L_0x00d9
        L_0x007e:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r5
            goto L_0x00d9
        L_0x0093:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r6
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r3
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cb
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.ConstraintSet$Motion r0 = r2.motion     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.layout     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.ConstraintSet$Transform r0 = r2.transform     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r0 = r2.propertySet     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.layout     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.mHelperType = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.layout     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.mIsGuideline = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.mApply = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01b5:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01be:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01c6:
            r2 = r0
            goto L_0x01cb
        L_0x01c8:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01cb:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x0006
        L_0x01d1:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01da
        L_0x01d6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.mForceId || id2 != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                    this.mConstraints.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
                if (constraint != null) {
                    if (!constraint.layout.mApply) {
                        constraint.fillFrom(id2, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                                constraint.layout.mBarrierDirection = barrier.getType();
                                constraint.layout.mBarrierMargin = barrier.getMargin();
                            }
                        }
                        constraint.layout.mApply = true;
                    }
                    PropertySet propertySet = constraint.propertySet;
                    if (!propertySet.mApply) {
                        propertySet.visibility = childAt.getVisibility();
                        constraint.propertySet.alpha = childAt.getAlpha();
                        constraint.propertySet.mApply = true;
                    }
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = childAt.getRotation();
                        constraint.transform.rotationX = childAt.getRotationX();
                        constraint.transform.rotationY = childAt.getRotationY();
                        constraint.transform.scaleX = childAt.getScaleX();
                        constraint.transform.scaleY = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = childAt.getTranslationX();
                        constraint.transform.translationY = childAt.getTranslationY();
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        Transform transform3 = constraint.transform;
                        if (transform3.applyElevation) {
                            transform3.elevation = childAt.getElevation();
                        }
                    }
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i11, int i12) {
        if (i11 == 6) {
            constraint.layout.editorAbsoluteX = i12;
        } else if (i11 == 7) {
            constraint.layout.editorAbsoluteY = i12;
        } else if (i11 == 8) {
            constraint.layout.endMargin = i12;
        } else if (i11 == 27) {
            constraint.layout.orientation = i12;
        } else if (i11 == 28) {
            constraint.layout.rightMargin = i12;
        } else if (i11 == 41) {
            constraint.layout.horizontalChainStyle = i12;
        } else if (i11 == 42) {
            constraint.layout.verticalChainStyle = i12;
        } else if (i11 == 61) {
            constraint.layout.circleConstraint = i12;
        } else if (i11 == 62) {
            constraint.layout.circleRadius = i12;
        } else if (i11 == 72) {
            constraint.layout.mBarrierDirection = i12;
        } else if (i11 != 73) {
            switch (i11) {
                case 2:
                    constraint.layout.bottomMargin = i12;
                    return;
                case 11:
                    constraint.layout.goneBottomMargin = i12;
                    return;
                case 12:
                    constraint.layout.goneEndMargin = i12;
                    return;
                case 13:
                    constraint.layout.goneLeftMargin = i12;
                    return;
                case 14:
                    constraint.layout.goneRightMargin = i12;
                    return;
                case 15:
                    constraint.layout.goneStartMargin = i12;
                    return;
                case 16:
                    constraint.layout.goneTopMargin = i12;
                    return;
                case 17:
                    constraint.layout.guideBegin = i12;
                    return;
                case 18:
                    constraint.layout.guideEnd = i12;
                    return;
                case 31:
                    constraint.layout.startMargin = i12;
                    return;
                case 34:
                    constraint.layout.topMargin = i12;
                    return;
                case 38:
                    constraint.f11148a = i12;
                    return;
                case 64:
                    constraint.motion.mAnimateRelativeTo = i12;
                    return;
                case 66:
                    constraint.motion.mDrawPath = i12;
                    return;
                case 76:
                    constraint.motion.mPathMotionArc = i12;
                    return;
                case 78:
                    constraint.propertySet.mVisibilityMode = i12;
                    return;
                case 93:
                    constraint.layout.baselineMargin = i12;
                    return;
                case 94:
                    constraint.layout.goneBaselineMargin = i12;
                    return;
                case 97:
                    constraint.layout.mWrapBehavior = i12;
                    return;
                default:
                    switch (i11) {
                        case 21:
                            constraint.layout.mHeight = i12;
                            return;
                        case 22:
                            constraint.propertySet.visibility = i12;
                            return;
                        case 23:
                            constraint.layout.mWidth = i12;
                            return;
                        case 24:
                            constraint.layout.leftMargin = i12;
                            return;
                        default:
                            switch (i11) {
                                case 54:
                                    constraint.layout.widthDefault = i12;
                                    return;
                                case 55:
                                    constraint.layout.heightDefault = i12;
                                    return;
                                case 56:
                                    constraint.layout.widthMax = i12;
                                    return;
                                case 57:
                                    constraint.layout.heightMax = i12;
                                    return;
                                case 58:
                                    constraint.layout.widthMin = i12;
                                    return;
                                case 59:
                                    constraint.layout.heightMin = i12;
                                    return;
                                default:
                                    switch (i11) {
                                        case 82:
                                            constraint.motion.mAnimateCircleAngleTo = i12;
                                            return;
                                        case 83:
                                            constraint.transform.transformPivotTarget = i12;
                                            return;
                                        case 84:
                                            constraint.motion.mQuantizeMotionSteps = i12;
                                            return;
                                        default:
                                            switch (i11) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.motion.mQuantizeInterpolatorType = i12;
                                                    return;
                                                case 89:
                                                    constraint.motion.mQuantizeInterpolatorID = i12;
                                                    return;
                                                default:
                                                    Log.w(TAG, "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.layout.mBarrierMargin = i12;
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraints.getChildAt(i11);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.mForceId || id2 != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                    this.mConstraints.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
                if (constraint != null) {
                    if (childAt instanceof ConstraintHelper) {
                        constraint.fillFromConstraints((ConstraintHelper) childAt, id2, layoutParams);
                    }
                    constraint.fillFromConstraints(id2, layoutParams);
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void connect(int i11, int i12, int i13, int i14) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i11))) {
            this.mConstraints.put(Integer.valueOf(i11), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i11));
        if (constraint != null) {
            switch (i12) {
                case 1:
                    if (i14 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i13;
                        layout.leftToRight = -1;
                        return;
                    } else if (i14 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i13;
                        layout2.leftToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + sideToString(i14) + " undefined");
                    }
                case 2:
                    if (i14 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i13;
                        layout3.rightToRight = -1;
                        return;
                    } else if (i14 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i13;
                        layout4.rightToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 3:
                    if (i14 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i13;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                        layout5.baselineToTop = -1;
                        layout5.baselineToBottom = -1;
                        return;
                    } else if (i14 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i13;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                        layout6.baselineToTop = -1;
                        layout6.baselineToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 4:
                    if (i14 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i13;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                        layout7.baselineToTop = -1;
                        layout7.baselineToBottom = -1;
                        return;
                    } else if (i14 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i13;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                        layout8.baselineToTop = -1;
                        layout8.baselineToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 5:
                    if (i14 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i13;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    } else if (i14 == 3) {
                        Layout layout10 = constraint.layout;
                        layout10.baselineToTop = i13;
                        layout10.bottomToBottom = -1;
                        layout10.bottomToTop = -1;
                        layout10.topToTop = -1;
                        layout10.topToBottom = -1;
                        return;
                    } else if (i14 == 4) {
                        Layout layout11 = constraint.layout;
                        layout11.baselineToBottom = i13;
                        layout11.bottomToBottom = -1;
                        layout11.bottomToTop = -1;
                        layout11.topToTop = -1;
                        layout11.topToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 6:
                    if (i14 == 6) {
                        Layout layout12 = constraint.layout;
                        layout12.startToStart = i13;
                        layout12.startToEnd = -1;
                        return;
                    } else if (i14 == 7) {
                        Layout layout13 = constraint.layout;
                        layout13.startToEnd = i13;
                        layout13.startToStart = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                case 7:
                    if (i14 == 7) {
                        Layout layout14 = constraint.layout;
                        layout14.endToEnd = i13;
                        layout14.endToStart = -1;
                        return;
                    } else if (i14 == 6) {
                        Layout layout15 = constraint.layout;
                        layout15.endToStart = i13;
                        layout15.endToEnd = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i14) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(sideToString(i12) + " to " + sideToString(i14) + " unknown");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i11, String str) {
        if (i11 == 5) {
            constraint.layout.dimensionRatio = str;
        } else if (i11 == 65) {
            constraint.motion.mTransitionEasing = str;
        } else if (i11 == 74) {
            Layout layout = constraint.layout;
            layout.mReferenceIdString = str;
            layout.mReferenceIds = null;
        } else if (i11 == 77) {
            constraint.layout.mConstraintTag = str;
        } else if (i11 == 87) {
        } else {
            if (i11 != 90) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.motion.mQuantizeInterpolatorString = str;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i11, boolean z11) {
        if (i11 == 44) {
            constraint.transform.applyElevation = z11;
        } else if (i11 == 75) {
            constraint.layout.mBarrierAllowsGoneWidgets = z11;
        } else if (i11 == 87) {
        } else {
            if (i11 == 80) {
                constraint.layout.constrainedWidth = z11;
            } else if (i11 != 81) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.layout.constrainedHeight = z11;
            }
        }
    }
}
