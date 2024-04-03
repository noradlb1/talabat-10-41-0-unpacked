package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintReference implements Reference {
    public float A = Float.NaN;
    public float B = Float.NaN;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public float E = Float.NaN;
    public float F = Float.NaN;
    public float G = Float.NaN;
    public float H = Float.NaN;
    public int I = 0;
    public Object J = null;
    public Object K = null;
    public Object L = null;
    public Object M = null;
    public Object N = null;
    public Object O = null;
    public Object P = null;
    public Object Q = null;
    public Object R = null;
    public Object S = null;
    public Object T = null;
    public Object U = null;
    public Object V = null;
    public Object W = null;
    public Object X = null;
    public Object Y = null;
    public State.Constraint Z = null;

    /* renamed from: a  reason: collision with root package name */
    public final State f10677a;

    /* renamed from: a0  reason: collision with root package name */
    public Dimension f10678a0;

    /* renamed from: b  reason: collision with root package name */
    public String f10679b = null;

    /* renamed from: b0  reason: collision with root package name */
    public Dimension f10680b0;

    /* renamed from: c  reason: collision with root package name */
    public Facade f10681c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f10682d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f10683e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f10684f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f10685g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f10686h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public float f10687i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    public int f10688j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f10689k = 0;
    private Object key;

    /* renamed from: l  reason: collision with root package name */
    public int f10690l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f10691m = 0;
    private float mCircularAngle;
    private float mCircularDistance;
    private ConstraintWidget mConstraintWidget;
    private HashMap<String, Integer> mCustomColors;
    private HashMap<String, Float> mCustomFloats;
    private Object mView;

    /* renamed from: n  reason: collision with root package name */
    public int f10692n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f10693o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f10694p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f10695q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f10696r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f10697s = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f10698t = 0;

    /* renamed from: u  reason: collision with root package name */
    public int f10699u = 0;

    /* renamed from: v  reason: collision with root package name */
    public int f10700v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f10701w = 0;

    /* renamed from: x  reason: collision with root package name */
    public float f10702x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    public float f10703y = Float.NaN;

    /* renamed from: z  reason: collision with root package name */
    public float f10704z = Float.NaN;

    /* renamed from: androidx.constraintlayout.core.state.ConstraintReference$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10705a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.state.State$Constraint[] r0 = androidx.constraintlayout.core.state.State.Constraint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10705a = r0
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.LEFT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.LEFT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.RIGHT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.RIGHT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.START_TO_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.START_TO_END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.END_TO_START     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.END_TO_END     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.TOP_TO_TOP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.TOP_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BOTTOM_TO_TOP     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BOTTOM_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_TOP     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_BASELINE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CIRCULAR_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CENTER_HORIZONTALLY     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f10705a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CENTER_VERTICALLY     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintReference.AnonymousClass1.<clinit>():void");
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    public static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.WRAP_DIMENSION;
        this.f10678a0 = Dimension.Fixed(obj);
        this.f10680b0 = Dimension.Fixed(obj);
        this.mCustomColors = new HashMap<>();
        this.mCustomFloats = new HashMap<>();
        this.f10677a = state;
    }

    private void applyConnection(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget target = getTarget(obj);
        if (target != null) {
            int[] iArr = AnonymousClass1.f10705a;
            int i11 = iArr[constraint.ordinal()];
            switch (iArr[constraint.ordinal()]) {
                case 1:
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type).connect(target.getAnchor(type), this.f10688j, this.f10694p, false);
                    return;
                case 2:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.f10688j, this.f10694p, false);
                    return;
                case 3:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.f10689k, this.f10695q, false);
                    return;
                case 4:
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type2).connect(target.getAnchor(type2), this.f10689k, this.f10695q, false);
                    return;
                case 5:
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type3).connect(target.getAnchor(type3), this.f10690l, this.f10696r, false);
                    return;
                case 6:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.f10690l, this.f10696r, false);
                    return;
                case 7:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.f10691m, this.f10697s, false);
                    return;
                case 8:
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type4).connect(target.getAnchor(type4), this.f10691m, this.f10697s, false);
                    return;
                case 9:
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                    constraintWidget.getAnchor(type5).connect(target.getAnchor(type5), this.f10692n, this.f10698t, false);
                    return;
                case 10:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.f10692n, this.f10698t, false);
                    return;
                case 11:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.f10693o, this.f10699u, false);
                    return;
                case 12:
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.getAnchor(type6).connect(target.getAnchor(type6), this.f10693o, this.f10699u, false);
                    return;
                case 13:
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, target, ConstraintAnchor.Type.BOTTOM, this.f10700v, this.f10701w);
                    return;
                case 14:
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, target, ConstraintAnchor.Type.TOP, this.f10700v, this.f10701w);
                    return;
                case 15:
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                    constraintWidget.immediateConnect(type7, target, type7, this.f10700v, this.f10701w);
                    return;
                case 16:
                    constraintWidget.connectCircularConstraint(target, this.mCircularAngle, (int) this.mCircularDistance);
                    return;
                default:
                    return;
            }
        }
    }

    private void dereference() {
        this.J = get(this.J);
        this.K = get(this.K);
        this.L = get(this.L);
        this.M = get(this.M);
        this.N = get(this.N);
        this.O = get(this.O);
        this.P = get(this.P);
        this.Q = get(this.Q);
        this.R = get(this.R);
        this.S = get(this.S);
        this.T = get(this.T);
        this.U = get(this.U);
        this.V = get(this.V);
        this.W = get(this.W);
        this.X = get(this.X);
    }

    private Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof ConstraintReference)) {
            return this.f10677a.a(obj);
        }
        return obj;
    }

    private ConstraintWidget getTarget(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).getConstraintWidget();
        }
        return null;
    }

    public void addCustomColor(String str, int i11) {
        this.mCustomColors.put(str, Integer.valueOf(i11));
    }

    public void addCustomFloat(String str, float f11) {
        if (this.mCustomFloats == null) {
            this.mCustomFloats = new HashMap<>();
        }
        this.mCustomFloats.put(str, Float.valueOf(f11));
    }

    public ConstraintReference alpha(float f11) {
        this.F = f11;
        return this;
    }

    public void apply() {
        if (this.mConstraintWidget != null) {
            Facade facade = this.f10681c;
            if (facade != null) {
                facade.apply();
            }
            this.f10678a0.apply(this.f10677a, this.mConstraintWidget, 0);
            this.f10680b0.apply(this.f10677a, this.mConstraintWidget, 1);
            dereference();
            applyConnection(this.mConstraintWidget, this.J, State.Constraint.LEFT_TO_LEFT);
            applyConnection(this.mConstraintWidget, this.K, State.Constraint.LEFT_TO_RIGHT);
            applyConnection(this.mConstraintWidget, this.L, State.Constraint.RIGHT_TO_LEFT);
            applyConnection(this.mConstraintWidget, this.M, State.Constraint.RIGHT_TO_RIGHT);
            applyConnection(this.mConstraintWidget, this.N, State.Constraint.START_TO_START);
            applyConnection(this.mConstraintWidget, this.O, State.Constraint.START_TO_END);
            applyConnection(this.mConstraintWidget, this.P, State.Constraint.END_TO_START);
            applyConnection(this.mConstraintWidget, this.Q, State.Constraint.END_TO_END);
            applyConnection(this.mConstraintWidget, this.R, State.Constraint.TOP_TO_TOP);
            applyConnection(this.mConstraintWidget, this.S, State.Constraint.TOP_TO_BOTTOM);
            applyConnection(this.mConstraintWidget, this.T, State.Constraint.BOTTOM_TO_TOP);
            applyConnection(this.mConstraintWidget, this.U, State.Constraint.BOTTOM_TO_BOTTOM);
            applyConnection(this.mConstraintWidget, this.V, State.Constraint.BASELINE_TO_BASELINE);
            applyConnection(this.mConstraintWidget, this.W, State.Constraint.BASELINE_TO_TOP);
            applyConnection(this.mConstraintWidget, this.X, State.Constraint.BASELINE_TO_BOTTOM);
            applyConnection(this.mConstraintWidget, this.Y, State.Constraint.CIRCULAR_CONSTRAINT);
            int i11 = this.f10682d;
            if (i11 != 0) {
                this.mConstraintWidget.setHorizontalChainStyle(i11);
            }
            int i12 = this.f10683e;
            if (i12 != 0) {
                this.mConstraintWidget.setVerticalChainStyle(i12);
            }
            float f11 = this.f10684f;
            if (f11 != -1.0f) {
                this.mConstraintWidget.setHorizontalWeight(f11);
            }
            float f12 = this.f10685g;
            if (f12 != -1.0f) {
                this.mConstraintWidget.setVerticalWeight(f12);
            }
            this.mConstraintWidget.setHorizontalBiasPercent(this.f10686h);
            this.mConstraintWidget.setVerticalBiasPercent(this.f10687i);
            ConstraintWidget constraintWidget = this.mConstraintWidget;
            WidgetFrame widgetFrame = constraintWidget.frame;
            widgetFrame.pivotX = this.f10702x;
            widgetFrame.pivotY = this.f10703y;
            widgetFrame.rotationX = this.f10704z;
            widgetFrame.rotationY = this.A;
            widgetFrame.rotationZ = this.B;
            widgetFrame.translationX = this.C;
            widgetFrame.translationY = this.D;
            widgetFrame.translationZ = this.E;
            widgetFrame.scaleX = this.G;
            widgetFrame.scaleY = this.H;
            widgetFrame.alpha = this.F;
            int i13 = this.I;
            widgetFrame.visibility = i13;
            constraintWidget.setVisibility(i13);
            HashMap<String, Integer> hashMap = this.mCustomColors;
            if (hashMap != null) {
                for (String next : hashMap.keySet()) {
                    this.mConstraintWidget.frame.setCustomAttribute(next, (int) TypedValues.Custom.TYPE_COLOR, this.mCustomColors.get(next).intValue());
                }
            }
            HashMap<String, Float> hashMap2 = this.mCustomFloats;
            if (hashMap2 != null) {
                for (String next2 : hashMap2.keySet()) {
                    this.mConstraintWidget.frame.setCustomAttribute(next2, 901, this.mCustomFloats.get(next2).floatValue());
                }
            }
        }
    }

    public ConstraintReference baseline() {
        this.Z = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_BASELINE;
        this.V = obj;
        return this;
    }

    public ConstraintReference baselineToBottom(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_BOTTOM;
        this.X = obj;
        return this;
    }

    public ConstraintReference baselineToTop(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_TOP;
        this.W = obj;
        return this;
    }

    public ConstraintReference bias(float f11) {
        State.Constraint constraint = this.Z;
        if (constraint == null) {
            return this;
        }
        int i11 = AnonymousClass1.f10705a[constraint.ordinal()];
        if (i11 != 17) {
            if (i11 != 18) {
                switch (i11) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        break;
                }
            }
            this.f10687i = f11;
            return this;
        }
        this.f10686h = f11;
        return this;
    }

    public ConstraintReference bottom() {
        if (this.T != null) {
            this.Z = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.Z = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.Z = State.Constraint.BOTTOM_TO_BOTTOM;
        this.U = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.Z = State.Constraint.BOTTOM_TO_TOP;
        this.T = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object obj2 = get(obj);
        this.N = obj2;
        this.Q = obj2;
        this.Z = State.Constraint.CENTER_HORIZONTALLY;
        this.f10686h = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object obj2 = get(obj);
        this.R = obj2;
        this.U = obj2;
        this.Z = State.Constraint.CENTER_VERTICALLY;
        this.f10687i = 0.5f;
        return this;
    }

    public ConstraintReference circularConstraint(Object obj, float f11, float f12) {
        this.Y = get(obj);
        this.mCircularAngle = f11;
        this.mCircularDistance = f12;
        this.Z = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint constraint = this.Z;
        if (constraint != null) {
            switch (AnonymousClass1.f10705a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.J = null;
                    this.K = null;
                    this.f10688j = 0;
                    this.f10694p = 0;
                    break;
                case 3:
                case 4:
                    this.L = null;
                    this.M = null;
                    this.f10689k = 0;
                    this.f10695q = 0;
                    break;
                case 5:
                case 6:
                    this.N = null;
                    this.O = null;
                    this.f10690l = 0;
                    this.f10696r = 0;
                    break;
                case 7:
                case 8:
                    this.P = null;
                    this.Q = null;
                    this.f10691m = 0;
                    this.f10697s = 0;
                    break;
                case 9:
                case 10:
                    this.R = null;
                    this.S = null;
                    this.f10692n = 0;
                    this.f10698t = 0;
                    break;
                case 11:
                case 12:
                    this.T = null;
                    this.U = null;
                    this.f10693o = 0;
                    this.f10699u = 0;
                    break;
                case 15:
                    this.V = null;
                    break;
                case 16:
                    this.Y = null;
                    break;
            }
        } else {
            this.J = null;
            this.K = null;
            this.f10688j = 0;
            this.L = null;
            this.M = null;
            this.f10689k = 0;
            this.N = null;
            this.O = null;
            this.f10690l = 0;
            this.P = null;
            this.Q = null;
            this.f10691m = 0;
            this.R = null;
            this.S = null;
            this.f10692n = 0;
            this.T = null;
            this.U = null;
            this.f10693o = 0;
            this.V = null;
            this.Y = null;
            this.f10686h = 0.5f;
            this.f10687i = 0.5f;
            this.f10694p = 0;
            this.f10695q = 0;
            this.f10696r = 0;
            this.f10697s = 0;
            this.f10698t = 0;
            this.f10699u = 0;
        }
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().a(), getHeight().a());
    }

    public ConstraintReference end() {
        if (this.P != null) {
            this.Z = State.Constraint.END_TO_START;
        } else {
            this.Z = State.Constraint.END_TO_END;
        }
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.Z = State.Constraint.END_TO_END;
        this.Q = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.Z = State.Constraint.END_TO_START;
        this.P = obj;
        return this;
    }

    public float getAlpha() {
        return this.F;
    }

    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.mConstraintWidget = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.mView);
        }
        return this.mConstraintWidget;
    }

    public Facade getFacade() {
        return this.f10681c;
    }

    public Dimension getHeight() {
        return this.f10680b0;
    }

    public int getHorizontalChainStyle() {
        return this.f10682d;
    }

    public float getHorizontalChainWeight() {
        return this.f10684f;
    }

    public Object getKey() {
        return this.key;
    }

    public float getPivotX() {
        return this.f10702x;
    }

    public float getPivotY() {
        return this.f10703y;
    }

    public float getRotationX() {
        return this.f10704z;
    }

    public float getRotationY() {
        return this.A;
    }

    public float getRotationZ() {
        return this.B;
    }

    public float getScaleX() {
        return this.G;
    }

    public float getScaleY() {
        return this.H;
    }

    public String getTag() {
        return this.f10679b;
    }

    public float getTranslationX() {
        return this.C;
    }

    public float getTranslationY() {
        return this.D;
    }

    public float getTranslationZ() {
        return this.E;
    }

    public int getVerticalChainStyle(int i11) {
        return this.f10683e;
    }

    public float getVerticalChainWeight() {
        return this.f10685g;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.f10678a0;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f11) {
        this.f10686h = f11;
        return this;
    }

    public ConstraintReference left() {
        if (this.J != null) {
            this.Z = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.Z = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.Z = State.Constraint.LEFT_TO_LEFT;
        this.J = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.Z = State.Constraint.LEFT_TO_RIGHT;
        this.K = obj;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.f10677a.convertDimension(obj));
    }

    public ConstraintReference marginGone(Object obj) {
        return marginGone(this.f10677a.convertDimension(obj));
    }

    public ConstraintReference pivotX(float f11) {
        this.f10702x = f11;
        return this;
    }

    public ConstraintReference pivotY(float f11) {
        this.f10703y = f11;
        return this;
    }

    public ConstraintReference right() {
        if (this.L != null) {
            this.Z = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.Z = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.Z = State.Constraint.RIGHT_TO_LEFT;
        this.L = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.Z = State.Constraint.RIGHT_TO_RIGHT;
        this.M = obj;
        return this;
    }

    public ConstraintReference rotationX(float f11) {
        this.f10704z = f11;
        return this;
    }

    public ConstraintReference rotationY(float f11) {
        this.A = f11;
        return this;
    }

    public ConstraintReference rotationZ(float f11) {
        this.B = f11;
        return this;
    }

    public ConstraintReference scaleX(float f11) {
        this.G = f11;
        return this;
    }

    public ConstraintReference scaleY(float f11) {
        this.H = f11;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget != null) {
            this.mConstraintWidget = constraintWidget;
            constraintWidget.setCompanionWidget(this.mView);
        }
    }

    public void setFacade(Facade facade) {
        this.f10681c = facade;
        if (facade != null) {
            setConstraintWidget(facade.getConstraintWidget());
        }
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.f10680b0 = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i11) {
        this.f10682d = i11;
    }

    public void setHorizontalChainWeight(float f11) {
        this.f10684f = f11;
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    public void setTag(String str) {
        this.f10679b = str;
    }

    public void setVerticalChainStyle(int i11) {
        this.f10683e = i11;
    }

    public void setVerticalChainWeight(float f11) {
        this.f10685g = f11;
    }

    public void setView(Object obj) {
        this.mView = obj;
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.f10678a0 = dimension;
        return this;
    }

    public ConstraintReference start() {
        if (this.N != null) {
            this.Z = State.Constraint.START_TO_START;
        } else {
            this.Z = State.Constraint.START_TO_END;
        }
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.Z = State.Constraint.START_TO_END;
        this.O = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.Z = State.Constraint.START_TO_START;
        this.N = obj;
        return this;
    }

    public ConstraintReference top() {
        if (this.R != null) {
            this.Z = State.Constraint.TOP_TO_TOP;
        } else {
            this.Z = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.Z = State.Constraint.TOP_TO_BOTTOM;
        this.S = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.Z = State.Constraint.TOP_TO_TOP;
        this.R = obj;
        return this;
    }

    public ConstraintReference translationX(float f11) {
        this.C = f11;
        return this;
    }

    public ConstraintReference translationY(float f11) {
        this.D = f11;
        return this;
    }

    public ConstraintReference translationZ(float f11) {
        this.E = f11;
        return this;
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (!(this.J == null || this.K == null)) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (!(this.L == null || this.M == null)) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (!(this.N == null || this.O == null)) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (!(this.P == null || this.Q == null)) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if (!((this.J == null && this.K == null && this.L == null && this.M == null) || (this.N == null && this.O == null && this.P == null && this.Q == null))) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new IncorrectConstraintException(arrayList);
        }
    }

    public ConstraintReference verticalBias(float f11) {
        this.f10687i = f11;
        return this;
    }

    public ConstraintReference visibility(int i11) {
        this.I = i11;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }

    public ConstraintReference margin(int i11) {
        State.Constraint constraint = this.Z;
        if (constraint != null) {
            switch (AnonymousClass1.f10705a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.f10688j = i11;
                    break;
                case 3:
                case 4:
                    this.f10689k = i11;
                    break;
                case 5:
                case 6:
                    this.f10690l = i11;
                    break;
                case 7:
                case 8:
                    this.f10691m = i11;
                    break;
                case 9:
                case 10:
                    this.f10692n = i11;
                    break;
                case 11:
                case 12:
                    this.f10693o = i11;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f10700v = i11;
                    break;
                case 16:
                    break;
            }
            this.mCircularDistance = (float) i11;
        } else {
            this.f10688j = i11;
            this.f10689k = i11;
            this.f10690l = i11;
            this.f10691m = i11;
            this.f10692n = i11;
            this.f10693o = i11;
        }
        return this;
    }

    public ConstraintReference marginGone(int i11) {
        State.Constraint constraint = this.Z;
        if (constraint != null) {
            switch (AnonymousClass1.f10705a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.f10694p = i11;
                    break;
                case 3:
                case 4:
                    this.f10695q = i11;
                    break;
                case 5:
                case 6:
                    this.f10696r = i11;
                    break;
                case 7:
                case 8:
                    this.f10697s = i11;
                    break;
                case 9:
                case 10:
                    this.f10698t = i11;
                    break;
                case 11:
                case 12:
                    this.f10699u = i11;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f10701w = i11;
                    break;
            }
        } else {
            this.f10694p = i11;
            this.f10695q = i11;
            this.f10696r = i11;
            this.f10697s = i11;
            this.f10698t = i11;
            this.f10699u = i11;
        }
        return this;
    }
}
