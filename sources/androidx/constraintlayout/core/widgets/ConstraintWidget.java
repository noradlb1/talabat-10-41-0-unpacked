package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public ConstraintWidget[] J;
    public ConstraintWidget[] K;
    public ConstraintWidget L;
    public ConstraintWidget M;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10766a;

    /* renamed from: b  reason: collision with root package name */
    public int f10767b;

    /* renamed from: c  reason: collision with root package name */
    public float f10768c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintAnchor f10769d;

    /* renamed from: e  reason: collision with root package name */
    public ConstraintAnchor f10770e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ConstraintAnchor> f10771f;
    public WidgetFrame frame;

    /* renamed from: g  reason: collision with root package name */
    public int f10772g;

    /* renamed from: h  reason: collision with root package name */
    public int f10773h;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;

    /* renamed from: i  reason: collision with root package name */
    public int f10774i;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;

    /* renamed from: j  reason: collision with root package name */
    public int f10775j;

    /* renamed from: k  reason: collision with root package name */
    public int f10776k;

    /* renamed from: l  reason: collision with root package name */
    public int f10777l;

    /* renamed from: m  reason: collision with root package name */
    public int f10778m;
    public ConstraintAnchor mBaseline;
    public ConstraintAnchor mBottom;
    public ConstraintAnchor mCenter;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    private int mHeightOverride;
    public int mHorizontalResolution;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    public ConstraintWidget mParent;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public ConstraintAnchor mTop;
    private String mType;
    public int mVerticalResolution;
    private int mVisibility;
    public float[] mWeight;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    public boolean measured;

    /* renamed from: n  reason: collision with root package name */
    public int f10779n;

    /* renamed from: o  reason: collision with root package name */
    public int f10780o;

    /* renamed from: p  reason: collision with root package name */
    public int f10781p;

    /* renamed from: q  reason: collision with root package name */
    public int f10782q;

    /* renamed from: r  reason: collision with root package name */
    public int f10783r;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;

    /* renamed from: s  reason: collision with root package name */
    public float f10784s;
    public String stringId;

    /* renamed from: t  reason: collision with root package name */
    public float f10785t;

    /* renamed from: u  reason: collision with root package name */
    public int f10786u;

    /* renamed from: v  reason: collision with root package name */
    public int f10787v;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* renamed from: w  reason: collision with root package name */
    public int f10788w;

    /* renamed from: x  reason: collision with root package name */
    public int f10789x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f10790y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f10791z;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10792a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f10793b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10793b = r0
                r1 = 1
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10793b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f10793b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f10793b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f10792a = r4
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f10792a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f10792a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f10766a = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f10767b = -1;
        this.f10768c = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f10769d = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f10770e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.f10771f = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.f10772g = 0;
        this.f10773h = 0;
        this.mDimensionRatio = 0.0f;
        this.f10774i = -1;
        this.f10775j = 0;
        this.f10776k = 0;
        this.f10777l = 0;
        this.f10778m = 0;
        this.f10779n = 0;
        this.f10780o = 0;
        this.f10781p = 0;
        float f11 = DEFAULT_BIAS;
        this.f10784s = f11;
        this.f10785t = f11;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.J = new ConstraintWidget[]{null, null};
        this.K = new ConstraintWidget[]{null, null};
        this.L = null;
        this.M = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.f10771f.add(this.mLeft);
        this.f10771f.add(this.mTop);
        this.f10771f.add(this.mRight);
        this.f10771f.add(this.mBottom);
        this.f10771f.add(this.f10769d);
        this.f10771f.add(this.f10770e);
        this.f10771f.add(this.mCenter);
        this.f10771f.add(this.mBaseline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x041a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x045d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x04df A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:371:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.core.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r54
            r3 = r55
            r4 = r56
            androidx.constraintlayout.core.SolverVariable r9 = r10.createObjectVariable(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.createObjectVariable(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r41.getTarget()
            androidx.constraintlayout.core.SolverVariable r7 = r10.createObjectVariable(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r42.getTarget()
            androidx.constraintlayout.core.SolverVariable r6 = r10.createObjectVariable(r5)
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.getMetrics()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.getMetrics()
            long r11 = r5.nonresolvedWidgets
            r16 = 1
            long r11 = r11 + r16
            r5.nonresolvedWidgets = r11
        L_0x0040:
            boolean r11 = r41.isConnected()
            boolean r12 = r42.isConnected()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.mCenter
            boolean r16 = r5.isConnected()
            if (r12 == 0) goto L_0x0053
            int r5 = r11 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r53
        L_0x005f:
            int[] r17 = androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.f10793b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007e
        L_0x0078:
            r2 = r18
            if (r2 == r14) goto L_0x0075
            r18 = 1
        L_0x007e:
            int r14 = r0.mWidthOverride
            r13 = -1
            if (r14 == r13) goto L_0x008c
            if (r33 == 0) goto L_0x008c
            r0.mWidthOverride = r13
            r21 = r6
            r18 = 0
            goto L_0x0090
        L_0x008c:
            r14 = r44
            r21 = r6
        L_0x0090:
            int r6 = r0.mHeightOverride
            if (r6 == r13) goto L_0x009b
            if (r33 != 0) goto L_0x009b
            r0.mHeightOverride = r13
            r14 = r6
            r18 = 0
        L_0x009b:
            int r6 = r0.mVisibility
            r13 = 8
            if (r6 != r13) goto L_0x00a4
            r14 = 0
            r18 = 0
        L_0x00a4:
            if (r58 == 0) goto L_0x00bd
            if (r11 != 0) goto L_0x00b2
            if (r12 != 0) goto L_0x00b2
            if (r16 != 0) goto L_0x00b2
            r6 = r43
            r10.addEquality(r9, r6)
            goto L_0x00bd
        L_0x00b2:
            if (r11 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00bd
            int r6 = r41.getMargin()
            r10.addEquality(r9, r7, r6, r13)
        L_0x00bd:
            if (r18 != 0) goto L_0x00ea
            if (r40 == 0) goto L_0x00d6
            r6 = 3
            r13 = 0
            r10.addEquality(r8, r9, r13, r6)
            r6 = 8
            if (r15 <= 0) goto L_0x00cd
            r10.addGreaterThan(r8, r9, r15, r6)
        L_0x00cd:
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r14) goto L_0x00db
            r10.addLowerThan(r8, r9, r1, r6)
            goto L_0x00db
        L_0x00d6:
            r6 = r13
            r13 = 0
            r10.addEquality(r8, r9, r14, r6)
        L_0x00db:
            r1 = r4
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r3
            goto L_0x01ec
        L_0x00ea:
            r1 = 2
            r13 = 0
            if (r5 == r1) goto L_0x0113
            if (r48 != 0) goto L_0x0113
            r1 = 1
            if (r2 == r1) goto L_0x00f5
            if (r2 != 0) goto L_0x0113
        L_0x00f5:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00ff
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00ff:
            r6 = 8
            r10.addEquality(r8, r9, r1, r6)
            r18 = r36
            r1 = r4
            r40 = r5
            r15 = r8
            r23 = r13
            r14 = r21
            r21 = r3
            r13 = r7
            goto L_0x01ec
        L_0x0113:
            r1 = -2
            if (r3 != r1) goto L_0x0118
            r6 = r14
            goto L_0x0119
        L_0x0118:
            r6 = r3
        L_0x0119:
            if (r4 != r1) goto L_0x011d
            r1 = r14
            goto L_0x011e
        L_0x011d:
            r1 = r4
        L_0x011e:
            if (r14 <= 0) goto L_0x0124
            r3 = 1
            if (r2 == r3) goto L_0x0124
            r14 = r13
        L_0x0124:
            if (r6 <= 0) goto L_0x012f
            r3 = 8
            r10.addGreaterThan(r8, r9, r6, r3)
            int r14 = java.lang.Math.max(r14, r6)
        L_0x012f:
            if (r1 <= 0) goto L_0x0148
            if (r34 == 0) goto L_0x0138
            r3 = 1
            if (r2 != r3) goto L_0x0138
            r3 = r13
            goto L_0x0139
        L_0x0138:
            r3 = 1
        L_0x0139:
            if (r3 == 0) goto L_0x0141
            r3 = 8
            r10.addLowerThan(r8, r9, r1, r3)
            goto L_0x0143
        L_0x0141:
            r3 = 8
        L_0x0143:
            int r14 = java.lang.Math.min(r14, r1)
            goto L_0x014a
        L_0x0148:
            r3 = 8
        L_0x014a:
            r4 = 1
            if (r2 != r4) goto L_0x0173
            if (r34 == 0) goto L_0x0154
            r10.addEquality(r8, r9, r14, r3)
            r4 = 5
            goto L_0x0165
        L_0x0154:
            if (r50 == 0) goto L_0x015e
            r4 = 5
            r10.addEquality(r8, r9, r14, r4)
            r10.addLowerThan(r8, r9, r14, r3)
            goto L_0x0165
        L_0x015e:
            r4 = 5
            r10.addEquality(r8, r9, r14, r4)
            r10.addLowerThan(r8, r9, r14, r3)
        L_0x0165:
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r6
            goto L_0x01ec
        L_0x0173:
            r4 = 5
            r14 = 2
            if (r2 != r14) goto L_0x01e0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.getType()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x01a1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.getType()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r13) goto L_0x0188
            goto L_0x01a1
        L_0x0188:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.createObjectVariable(r4)
            goto L_0x01b7
        L_0x01a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.createObjectVariable(r4)
        L_0x01b7:
            r23 = r3
            r13 = r4
            androidx.constraintlayout.core.ArrayRow r3 = r32.createRow()
            r24 = 5
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r14
            r14 = r21
            r21 = r6
            r6 = r13
            r13 = r7
            r7 = r23
            r15 = r8
            r8 = r57
            androidx.constraintlayout.core.ArrayRow r3 = r3.createRowDimensionRatio(r4, r5, r6, r7, r8)
            r10.addConstraint(r3)
            if (r34 == 0) goto L_0x01db
            r18 = 0
        L_0x01db:
            r23 = r18
            r18 = r36
            goto L_0x01ec
        L_0x01e0:
            r40 = r5
            r13 = r7
            r15 = r8
            r14 = r21
            r21 = r6
            r23 = r18
            r18 = 1
        L_0x01ec:
            if (r58 == 0) goto L_0x050f
            if (r50 == 0) goto L_0x01fc
            r1 = r37
            r4 = r38
            r5 = r40
            r2 = r15
            r3 = 0
            r6 = 2
            r15 = r9
            goto L_0x0519
        L_0x01fc:
            if (r11 != 0) goto L_0x0207
            if (r12 != 0) goto L_0x0207
            if (r16 != 0) goto L_0x0207
            r2 = r15
            r1 = 5
            r3 = 0
            goto L_0x04da
        L_0x0207:
            if (r11 == 0) goto L_0x0223
            if (r12 != 0) goto L_0x0223
            r7 = r41
            r8 = 0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r7.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mOwner
            if (r34 == 0) goto L_0x021b
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x021b
            r13 = 8
            goto L_0x021c
        L_0x021b:
            r13 = 5
        L_0x021c:
            r22 = r34
            r3 = r8
            r6 = r13
            r2 = r15
            goto L_0x04dd
        L_0x0223:
            r7 = r41
            r8 = 0
            if (r11 != 0) goto L_0x025a
            if (r12 == 0) goto L_0x025a
            int r1 = r42.getMargin()
            int r1 = -r1
            r2 = 8
            r10.addEquality(r15, r14, r1, r2)
            if (r34 == 0) goto L_0x04d7
            boolean r1 = r0.OPTIMIZE_WRAP
            if (r1 == 0) goto L_0x0250
            boolean r1 = r9.isFinalValue
            if (r1 == 0) goto L_0x0250
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.mParent
            if (r1 == 0) goto L_0x0250
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            if (r33 == 0) goto L_0x024b
            r1.addHorizontalWrapMinVariable(r7)
            goto L_0x04d7
        L_0x024b:
            r1.g(r7)
            goto L_0x04d7
        L_0x0250:
            r6 = r37
            r1 = 5
            r10.addGreaterThan(r9, r6, r8, r1)
            r3 = r8
            r2 = r15
            goto L_0x04da
        L_0x025a:
            r6 = r37
            if (r11 == 0) goto L_0x04d7
            if (r12 == 0) goto L_0x04d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.mOwner
            r12 = r42
            r3 = 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.mOwner
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r31.getParent()
            r16 = 6
            if (r23 == 0) goto L_0x0366
            if (r2 != 0) goto L_0x02c9
            if (r1 != 0) goto L_0x029e
            if (r21 != 0) goto L_0x029e
            boolean r1 = r13.isFinalValue
            if (r1 == 0) goto L_0x0293
            boolean r1 = r14.isFinalValue
            if (r1 == 0) goto L_0x0293
            int r1 = r41.getMargin()
            r2 = 8
            r10.addEquality(r9, r13, r1, r2)
            int r1 = r42.getMargin()
            int r1 = -r1
            r10.addEquality(r15, r14, r1, r2)
            return
        L_0x0293:
            r19 = r8
            r24 = r19
            r1 = 8
            r3 = 8
            r22 = 1
            goto L_0x02a6
        L_0x029e:
            r22 = r8
            r1 = 5
            r3 = 5
            r19 = 1
            r24 = 1
        L_0x02a6:
            boolean r8 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 != 0) goto L_0x02bc
            boolean r8 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 == 0) goto L_0x02af
            goto L_0x02bc
        L_0x02af:
            r8 = r38
            r25 = r22
            r22 = r19
            r19 = r3
        L_0x02b7:
            r3 = r1
            r1 = r16
            goto L_0x03b1
        L_0x02bc:
            r8 = r38
            r3 = r1
            r1 = r16
            r25 = r22
            r22 = r19
            r19 = 4
            goto L_0x03b1
        L_0x02c9:
            if (r2 != r3) goto L_0x02e1
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x02dd
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x02d4
            goto L_0x02dd
        L_0x02d4:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 5
            goto L_0x03ab
        L_0x02dd:
            r8 = r38
            goto L_0x03a6
        L_0x02e1:
            r8 = 1
            if (r2 != r8) goto L_0x02ec
            r8 = r38
            r1 = r16
            r3 = 8
            goto L_0x03a9
        L_0x02ec:
            r8 = 3
            if (r2 != r8) goto L_0x035a
            int r8 = r0.f10767b
            r3 = -1
            if (r8 != r3) goto L_0x030e
            if (r51 == 0) goto L_0x02fe
            r8 = r38
            if (r34 == 0) goto L_0x02fc
            r1 = 5
            goto L_0x0302
        L_0x02fc:
            r1 = 4
            goto L_0x0302
        L_0x02fe:
            r8 = r38
            r1 = 8
        L_0x0302:
            r3 = 8
        L_0x0304:
            r19 = 5
        L_0x0306:
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x03b1
        L_0x030e:
            if (r48 == 0) goto L_0x032f
            r3 = r54
            r8 = 2
            if (r3 == r8) goto L_0x031b
            r1 = 1
            if (r3 != r1) goto L_0x0319
            goto L_0x031b
        L_0x0319:
            r1 = 0
            goto L_0x031c
        L_0x031b:
            r1 = 1
        L_0x031c:
            if (r1 != 0) goto L_0x0322
            r1 = 8
            r3 = 5
            goto L_0x0324
        L_0x0322:
            r1 = 5
            r3 = 4
        L_0x0324:
            r8 = r38
            r19 = r3
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x02b7
        L_0x032f:
            if (r1 <= 0) goto L_0x0337
            r8 = r38
            r1 = r16
            r3 = 5
            goto L_0x0304
        L_0x0337:
            if (r1 != 0) goto L_0x0352
            if (r21 != 0) goto L_0x0352
            if (r51 != 0) goto L_0x0345
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 8
            goto L_0x0306
        L_0x0345:
            if (r11 == r4) goto L_0x034b
            if (r5 == r4) goto L_0x034b
            r1 = 4
            goto L_0x034c
        L_0x034b:
            r1 = 5
        L_0x034c:
            r8 = r38
            r3 = r1
            r1 = r16
            goto L_0x0357
        L_0x0352:
            r8 = r38
            r1 = r16
            r3 = 5
        L_0x0357:
            r19 = 4
            goto L_0x0306
        L_0x035a:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 4
            r22 = 0
            r24 = 0
            goto L_0x03af
        L_0x0366:
            boolean r1 = r13.isFinalValue
            if (r1 == 0) goto L_0x02dd
            boolean r1 = r14.isFinalValue
            if (r1 == 0) goto L_0x02dd
            int r1 = r41.getMargin()
            int r2 = r42.getMargin()
            r3 = 8
            r48 = r32
            r49 = r9
            r50 = r13
            r51 = r1
            r52 = r47
            r53 = r14
            r54 = r15
            r55 = r2
            r56 = r3
            r48.addCentering(r49, r50, r51, r52, r53, r54, r55, r56)
            if (r34 == 0) goto L_0x03a5
            if (r18 == 0) goto L_0x03a5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r12.mTarget
            if (r1 == 0) goto L_0x039c
            int r13 = r42.getMargin()
            r8 = r38
            goto L_0x039f
        L_0x039c:
            r8 = r38
            r13 = 0
        L_0x039f:
            if (r14 == r8) goto L_0x03a5
            r1 = 5
            r10.addGreaterThan(r8, r15, r13, r1)
        L_0x03a5:
            return
        L_0x03a6:
            r1 = r16
            r3 = 5
        L_0x03a9:
            r19 = 4
        L_0x03ab:
            r22 = 1
            r24 = 1
        L_0x03af:
            r25 = 0
        L_0x03b1:
            if (r24 == 0) goto L_0x03bc
            if (r13 != r14) goto L_0x03bc
            if (r11 == r4) goto L_0x03bc
            r24 = 0
            r26 = 0
            goto L_0x03be
        L_0x03bc:
            r26 = 1
        L_0x03be:
            if (r22 == 0) goto L_0x0404
            if (r23 != 0) goto L_0x03d3
            if (r49 != 0) goto L_0x03d3
            if (r51 != 0) goto L_0x03d3
            if (r13 != r6) goto L_0x03d3
            if (r14 != r8) goto L_0x03d3
            r22 = 0
            r26 = 8
            r27 = 8
            r28 = 0
            goto L_0x03db
        L_0x03d3:
            r22 = r34
            r27 = r1
            r28 = r26
            r26 = r3
        L_0x03db:
            int r29 = r41.getMargin()
            int r30 = r42.getMargin()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r13
            r39 = r12
            r12 = r4
            r4 = r29
            r29 = r12
            r12 = r5
            r5 = r47
            r6 = r14
            r7 = r15
            r8 = r30
            r20 = r15
            r15 = r9
            r9 = r27
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r26
            r26 = r28
            goto L_0x040e
        L_0x0404:
            r39 = r2
            r29 = r4
            r12 = r5
            r20 = r15
            r15 = r9
            r22 = r34
        L_0x040e:
            int r1 = r0.mVisibility
            r2 = 8
            if (r1 != r2) goto L_0x041b
            boolean r1 = r42.hasDependents()
            if (r1 != 0) goto L_0x041b
            return
        L_0x041b:
            if (r24 == 0) goto L_0x043f
            if (r22 == 0) goto L_0x042d
            if (r13 == r14) goto L_0x042d
            if (r23 != 0) goto L_0x042d
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x042b
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x042d
        L_0x042b:
            r3 = r16
        L_0x042d:
            int r1 = r41.getMargin()
            r10.addGreaterThan(r15, r13, r1, r3)
            int r1 = r42.getMargin()
            int r1 = -r1
            r2 = r20
            r10.addLowerThan(r2, r14, r1, r3)
            goto L_0x0441
        L_0x043f:
            r2 = r20
        L_0x0441:
            if (r22 == 0) goto L_0x0457
            if (r52 == 0) goto L_0x0457
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0457
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0457
            r1 = r29
            if (r12 == r1) goto L_0x0459
            r3 = r16
            r4 = r3
            r26 = 1
            goto L_0x045b
        L_0x0457:
            r1 = r29
        L_0x0459:
            r4 = r19
        L_0x045b:
            if (r26 == 0) goto L_0x04a5
            if (r25 == 0) goto L_0x0485
            if (r51 == 0) goto L_0x0463
            if (r35 == 0) goto L_0x0485
        L_0x0463:
            if (r11 == r1) goto L_0x046a
            if (r12 != r1) goto L_0x0468
            goto L_0x046a
        L_0x0468:
            r6 = r4
            goto L_0x046c
        L_0x046a:
            r6 = r16
        L_0x046c:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 != 0) goto L_0x0474
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 == 0) goto L_0x0475
        L_0x0474:
            r6 = 5
        L_0x0475:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 != 0) goto L_0x047d
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 == 0) goto L_0x047e
        L_0x047d:
            r6 = 5
        L_0x047e:
            if (r51 == 0) goto L_0x0481
            r6 = 5
        L_0x0481:
            int r4 = java.lang.Math.max(r6, r4)
        L_0x0485:
            if (r22 == 0) goto L_0x0496
            int r3 = java.lang.Math.min(r3, r4)
            if (r48 == 0) goto L_0x0495
            if (r51 != 0) goto L_0x0495
            if (r11 == r1) goto L_0x0493
            if (r12 != r1) goto L_0x0495
        L_0x0493:
            r4 = 4
            goto L_0x0496
        L_0x0495:
            r4 = r3
        L_0x0496:
            int r1 = r41.getMargin()
            r10.addEquality(r15, r13, r1, r4)
            int r1 = r42.getMargin()
            int r1 = -r1
            r10.addEquality(r2, r14, r1, r4)
        L_0x04a5:
            if (r22 == 0) goto L_0x04b7
            r1 = r37
            if (r1 != r13) goto L_0x04b0
            int r3 = r41.getMargin()
            goto L_0x04b1
        L_0x04b0:
            r3 = 0
        L_0x04b1:
            if (r13 == r1) goto L_0x04b7
            r4 = 5
            r10.addGreaterThan(r15, r1, r3, r4)
        L_0x04b7:
            if (r22 == 0) goto L_0x04d4
            if (r23 == 0) goto L_0x04d4
            if (r45 != 0) goto L_0x04d4
            if (r21 != 0) goto L_0x04d4
            if (r23 == 0) goto L_0x04ce
            r1 = r39
            r3 = 3
            if (r1 != r3) goto L_0x04ce
            r1 = 8
            r3 = 0
            r10.addGreaterThan(r2, r15, r3, r1)
            r1 = 5
            goto L_0x04dc
        L_0x04ce:
            r3 = 0
            r1 = 5
            r10.addGreaterThan(r2, r15, r3, r1)
            goto L_0x04dc
        L_0x04d4:
            r1 = 5
            r3 = 0
            goto L_0x04dc
        L_0x04d7:
            r3 = r8
            r2 = r15
            r1 = 5
        L_0x04da:
            r22 = r34
        L_0x04dc:
            r6 = r1
        L_0x04dd:
            if (r22 == 0) goto L_0x050e
            if (r18 == 0) goto L_0x050e
            r1 = r42
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04ee
            int r13 = r42.getMargin()
            r4 = r38
            goto L_0x04f1
        L_0x04ee:
            r4 = r38
            r13 = r3
        L_0x04f1:
            if (r14 == r4) goto L_0x050e
            boolean r3 = r0.OPTIMIZE_WRAP
            if (r3 == 0) goto L_0x050b
            boolean r3 = r2.isFinalValue
            if (r3 == 0) goto L_0x050b
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            if (r3 == 0) goto L_0x050b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            if (r33 == 0) goto L_0x0507
            r3.addHorizontalWrapMaxVariable(r1)
            goto L_0x050a
        L_0x0507:
            r3.f(r1)
        L_0x050a:
            return
        L_0x050b:
            r10.addGreaterThan(r4, r2, r13, r6)
        L_0x050e:
            return
        L_0x050f:
            r1 = r37
            r4 = r38
            r2 = r15
            r3 = 0
            r15 = r9
            r5 = r40
            r6 = 2
        L_0x0519:
            if (r5 >= r6) goto L_0x055a
            if (r34 == 0) goto L_0x055a
            if (r18 == 0) goto L_0x055a
            r5 = 8
            r10.addGreaterThan(r15, r1, r3, r5)
            if (r33 != 0) goto L_0x052f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x052d
            goto L_0x052f
        L_0x052d:
            r13 = r3
            goto L_0x0530
        L_0x052f:
            r13 = 1
        L_0x0530:
            if (r33 != 0) goto L_0x0552
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0552
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mOwner
            float r5 = r1.mDimensionRatio
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0550
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r5 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0550
            r5 = 1
            r1 = r1[r5]
            if (r1 != r6) goto L_0x0550
            r14 = r5
            goto L_0x0553
        L_0x0550:
            r14 = r3
            goto L_0x0553
        L_0x0552:
            r14 = r13
        L_0x0553:
            if (r14 == 0) goto L_0x055a
            r1 = 8
            r10.addGreaterThan(r4, r2, r3, r1)
        L_0x055a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
        r0 = r4.mTarget;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isChainHead(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r3.mListAnchors
            r1 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r4.mTarget
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.isChainHead(int):boolean");
    }

    private void serializeAnchor(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb2.append(str);
            sb2.append(" : [ '");
            sb2.append(constraintAnchor.mTarget);
            sb2.append("',");
            sb2.append(constraintAnchor.mMargin);
            sb2.append(",");
            sb2.append(constraintAnchor.f10763a);
            sb2.append(",");
            sb2.append(" ] ,\n");
        }
    }

    private void serializeAttribute(StringBuilder sb2, String str, float f11, float f12) {
        if (f11 != f12) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(f11);
            sb2.append(",\n");
        }
    }

    private void serializeCircle(StringBuilder sb2, ConstraintAnchor constraintAnchor, float f11) {
        if (constraintAnchor.mTarget != null) {
            sb2.append("circle : [ '");
            sb2.append(constraintAnchor.mTarget);
            sb2.append("',");
            sb2.append(constraintAnchor.mMargin);
            sb2.append(",");
            sb2.append(f11);
            sb2.append(",");
            sb2.append(" ] ,\n");
        }
    }

    private void serializeDimensionRatio(StringBuilder sb2, String str, float f11, int i11) {
        if (f11 != 0.0f) {
            sb2.append(str);
            sb2.append(" :  [");
            sb2.append(f11);
            sb2.append(",");
            sb2.append(i11);
            sb2.append("");
            sb2.append("],\n");
        }
    }

    private void serializeSize(StringBuilder sb2, String str, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12) {
        sb2.append(str);
        sb2.append(" :  {\n");
        serializeAttribute(sb2, BindingAdaptersKt.QUERY_SIZE, i11, Integer.MIN_VALUE);
        serializeAttribute(sb2, "min", i12, 0);
        serializeAttribute(sb2, RichContentLoadTimeTracer.MAX, i13, Integer.MAX_VALUE);
        serializeAttribute(sb2, "matchMin", i15, 0);
        serializeAttribute(sb2, "matchDef", i16, 0);
        serializeAttribute(sb2, "matchPercent", i16, 1);
        sb2.append("},\n");
    }

    public boolean a() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i11, boolean z11) {
        if (z11) {
            if (hashSet.contains(this)) {
                Optimizer.a(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i11 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i11, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i11, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x055b  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x05a4  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x05d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mLeft
            androidx.constraintlayout.core.SolverVariable r13 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mRight
            androidx.constraintlayout.core.SolverVariable r12 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mTop
            androidx.constraintlayout.core.SolverVariable r11 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBottom
            androidx.constraintlayout.core.SolverVariable r10 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.SolverVariable r9 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.mListDimensionBehaviors
            r2 = r2[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0036
            r2 = r7
            goto L_0x0037
        L_0x0036:
            r2 = r6
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0043
            r0 = r7
            goto L_0x0044
        L_0x0043:
            r0 = r6
        L_0x0044:
            int r3 = r15.mWrapBehaviorInParent
            if (r3 == r7) goto L_0x0052
            if (r3 == r8) goto L_0x004f
            if (r3 == r1) goto L_0x0055
            r5 = r0
            r4 = r2
            goto L_0x0057
        L_0x004f:
            r5 = r0
            r4 = r6
            goto L_0x0057
        L_0x0052:
            r4 = r2
            r5 = r6
            goto L_0x0057
        L_0x0055:
            r4 = r6
            r5 = r4
        L_0x0057:
            int r0 = r15.mVisibility
            r3 = 8
            if (r0 != r3) goto L_0x006e
            boolean r0 = r53.hasDependencies()
            if (r0 != 0) goto L_0x006e
            boolean[] r0 = r15.mIsInBarrier
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x006e
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x006e
            return
        L_0x006e:
            boolean r0 = r15.resolvedHorizontal
            r2 = 5
            if (r0 != 0) goto L_0x0077
            boolean r8 = r15.resolvedVertical
            if (r8 == 0) goto L_0x00f4
        L_0x0077:
            if (r0 == 0) goto L_0x00a6
            int r0 = r15.f10775j
            r14.addEquality(r13, r0)
            int r0 = r15.f10775j
            int r8 = r15.f10772g
            int r0 = r0 + r8
            r14.addEquality(r12, r0)
            if (r4 == 0) goto L_0x00a6
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x00a6
            boolean r8 = r15.OPTIMIZE_WRAP_ON_RESOLVED
            if (r8 == 0) goto L_0x009d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.mLeft
            r0.addHorizontalWrapMinVariable(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.mRight
            r0.addHorizontalWrapMaxVariable(r8)
            goto L_0x00a6
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r12, r6, r2)
        L_0x00a6:
            boolean r0 = r15.resolvedVertical
            if (r0 == 0) goto L_0x00e7
            int r0 = r15.f10776k
            r14.addEquality(r11, r0)
            int r0 = r15.f10776k
            int r8 = r15.f10773h
            int r0 = r0 + r8
            r14.addEquality(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            boolean r0 = r0.hasDependents()
            if (r0 == 0) goto L_0x00c7
            int r0 = r15.f10776k
            int r8 = r15.f10781p
            int r0 = r0 + r8
            r14.addEquality(r9, r0)
        L_0x00c7:
            if (r5 == 0) goto L_0x00e7
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x00e7
            boolean r8 = r15.OPTIMIZE_WRAP_ON_RESOLVED
            if (r8 == 0) goto L_0x00de
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.mTop
            r0.g(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.mBottom
            r0.f(r8)
            goto L_0x00e7
        L_0x00de:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r10, r6, r2)
        L_0x00e7:
            boolean r0 = r15.resolvedHorizontal
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r15.resolvedVertical
            if (r0 == 0) goto L_0x00f4
            r15.resolvedHorizontal = r6
            r15.resolvedVertical = r6
            return
        L_0x00f4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r17 = 1
            if (r0 == 0) goto L_0x0100
            long r1 = r0.widgets
            long r1 = r1 + r17
            r0.widgets = r1
        L_0x0100:
            if (r55 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r15.horizontalRun
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r15.verticalRun
            if (r2 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r1.start
            boolean r7 = r8.resolved
            if (r7 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.end
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.end
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x018f
            if (r0 == 0) goto L_0x012a
            long r1 = r0.graphSolved
            long r1 = r1 + r17
            r0.graphSolved = r1
        L_0x012a:
            int r0 = r8.value
            r14.addEquality(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r14.addEquality(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r14.addEquality(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r14.addEquality(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r14.addEquality(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x018a
            if (r4 == 0) goto L_0x0170
            boolean[] r0 = r15.isTerminalWidget
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x0170
            boolean r0 = r53.isInHorizontalChain()
            if (r0 != 0) goto L_0x0170
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r12, r6, r3)
        L_0x0170:
            if (r5 == 0) goto L_0x018a
            boolean[] r0 = r15.isTerminalWidget
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x018a
            boolean r0 = r53.isInVerticalChain()
            if (r0 != 0) goto L_0x018a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r10, r6, r3)
        L_0x018a:
            r15.resolvedHorizontal = r6
            r15.resolvedVertical = r6
            return
        L_0x018f:
            if (r0 == 0) goto L_0x0197
            long r1 = r0.linearSolved
            long r1 = r1 + r17
            r0.linearSolved = r1
        L_0x0197:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x020b
            boolean r0 = r15.isChainHead(r6)
            if (r0 == 0) goto L_0x01aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            r0.e(r15, r6)
            r0 = 1
            goto L_0x01ae
        L_0x01aa:
            boolean r0 = r53.isInHorizontalChain()
        L_0x01ae:
            r1 = 1
            boolean r2 = r15.isChainHead(r1)
            if (r2 == 0) goto L_0x01be
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            r2.e(r15, r1)
            r1 = 1
            goto L_0x01c2
        L_0x01be:
            boolean r1 = r53.isInVerticalChain()
        L_0x01c2:
            if (r0 != 0) goto L_0x01e2
            if (r4 == 0) goto L_0x01e2
            int r2 = r15.mVisibility
            if (r2 == r3) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mRight
            androidx.constraintlayout.core.SolverVariable r2 = r14.createObjectVariable(r2)
            r7 = 1
            r14.addGreaterThan(r2, r12, r6, r7)
        L_0x01e2:
            if (r1 != 0) goto L_0x0206
            if (r5 == 0) goto L_0x0206
            int r2 = r15.mVisibility
            if (r2 == r3) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mBaseline
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.core.SolverVariable r2 = r14.createObjectVariable(r2)
            r7 = 1
            r14.addGreaterThan(r2, r10, r6, r7)
        L_0x0206:
            r29 = r0
            r28 = r1
            goto L_0x020f
        L_0x020b:
            r28 = r6
            r29 = r28
        L_0x020f:
            int r0 = r15.f10772g
            int r1 = r15.f10782q
            if (r0 >= r1) goto L_0x0216
            goto L_0x0217
        L_0x0216:
            r1 = r0
        L_0x0217:
            int r2 = r15.f10773h
            int r7 = r15.f10783r
            if (r2 >= r7) goto L_0x021e
            goto L_0x021f
        L_0x021e:
            r7 = r2
        L_0x021f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r15.mListDimensionBehaviors
            r3 = r8[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            if (r3 == r6) goto L_0x022b
            r1 = 1
            goto L_0x022c
        L_0x022b:
            r1 = 0
        L_0x022c:
            r21 = 1
            r8 = r8[r21]
            r23 = r7
            r27 = r9
            if (r8 == r6) goto L_0x0238
            r7 = 1
            goto L_0x0239
        L_0x0238:
            r7 = 0
        L_0x0239:
            int r9 = r15.f10774i
            r15.f10767b = r9
            r30 = r10
            float r10 = r15.mDimensionRatio
            r15.f10768c = r10
            r31 = r11
            int r11 = r15.mMatchConstraintDefaultWidth
            r32 = r12
            int r12 = r15.mMatchConstraintDefaultHeight
            r24 = 0
            int r24 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            r33 = r13
            if (r24 <= 0) goto L_0x02bf
            int r13 = r15.mVisibility
            r14 = 8
            if (r13 == r14) goto L_0x02bf
            if (r3 != r6) goto L_0x025e
            if (r11 != 0) goto L_0x025e
            r11 = 3
        L_0x025e:
            if (r8 != r6) goto L_0x0263
            if (r12 != 0) goto L_0x0263
            r12 = 3
        L_0x0263:
            if (r3 != r6) goto L_0x0270
            if (r8 != r6) goto L_0x0270
            r13 = 3
            if (r11 != r13) goto L_0x0271
            if (r12 != r13) goto L_0x0271
            r15.setupDimensionRatio(r4, r5, r1, r7)
            goto L_0x02b5
        L_0x0270:
            r13 = 3
        L_0x0271:
            r1 = 4
            if (r3 != r6) goto L_0x028d
            if (r11 != r13) goto L_0x028d
            r7 = 0
            r15.f10767b = r7
            float r0 = (float) r2
            float r10 = r10 * r0
            int r0 = (int) r10
            if (r8 == r6) goto L_0x0287
            r36 = r1
            r35 = r12
            r34 = r23
            r14 = 0
            r1 = r0
            goto L_0x02c8
        L_0x0287:
            r1 = r0
            r36 = r11
            r35 = r12
            goto L_0x02bb
        L_0x028d:
            if (r8 != r6) goto L_0x02b5
            if (r12 != r13) goto L_0x02b5
            r2 = 1
            r15.f10767b = r2
            r2 = -1
            if (r9 != r2) goto L_0x029c
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 / r10
            r15.f10768c = r2
        L_0x029c:
            float r2 = r15.f10768c
            float r0 = (float) r0
            float r2 = r2 * r0
            int r7 = (int) r2
            if (r3 == r6) goto L_0x02ac
            r35 = r1
            r34 = r7
            r36 = r11
            r1 = r22
            goto L_0x02c7
        L_0x02ac:
            r34 = r7
            r36 = r11
            r35 = r12
            r1 = r22
            goto L_0x02bd
        L_0x02b5:
            r36 = r11
            r35 = r12
            r1 = r22
        L_0x02bb:
            r34 = r23
        L_0x02bd:
            r14 = 1
            goto L_0x02c8
        L_0x02bf:
            r36 = r11
            r35 = r12
            r1 = r22
            r34 = r23
        L_0x02c7:
            r14 = 0
        L_0x02c8:
            int[] r0 = r15.mResolvedMatchConstraintDefault
            r2 = 0
            r0[r2] = r36
            r2 = 1
            r0[r2] = r35
            r15.f10766a = r14
            if (r14 == 0) goto L_0x02de
            int r0 = r15.f10767b
            r2 = -1
            if (r0 == 0) goto L_0x02db
            if (r0 != r2) goto L_0x02df
        L_0x02db:
            r20 = 1
            goto L_0x02e1
        L_0x02de:
            r2 = -1
        L_0x02df:
            r20 = 0
        L_0x02e1:
            if (r14 == 0) goto L_0x02ed
            int r0 = r15.f10767b
            r3 = 1
            if (r0 == r3) goto L_0x02ea
            if (r0 != r2) goto L_0x02ed
        L_0x02ea:
            r37 = 1
            goto L_0x02ef
        L_0x02ed:
            r37 = 0
        L_0x02ef:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02fe
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x02fe
            r9 = 1
            goto L_0x02ff
        L_0x02fe:
            r9 = 0
        L_0x02ff:
            if (r9 == 0) goto L_0x0304
            r22 = 0
            goto L_0x0306
        L_0x0304:
            r22 = r1
        L_0x0306:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mCenter
            boolean r0 = r0.isConnected()
            r1 = 1
            r38 = r0 ^ 1
            boolean[] r0 = r15.mIsInBarrier
            r2 = 0
            boolean r23 = r0[r2]
            boolean r39 = r0[r1]
            int r0 = r15.mHorizontalResolution
            r40 = 0
            r8 = 2
            if (r0 == r8) goto L_0x042d
            boolean r0 = r15.resolvedHorizontal
            if (r0 != 0) goto L_0x042d
            if (r55 == 0) goto L_0x0384
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            if (r0 == 0) goto L_0x0384
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x0384
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x0334
            goto L_0x0384
        L_0x0334:
            if (r55 == 0) goto L_0x0380
            int r0 = r1.value
            r12 = r54
            r11 = r33
            r12.addEquality(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r10 = r32
            r12.addEquality(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x036a
            if (r4 == 0) goto L_0x036a
            boolean[] r0 = r15.isTerminalWidget
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x036a
            boolean r0 = r53.isInHorizontalChain()
            if (r0 != 0) goto L_0x036a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r12.createObjectVariable(r0)
            r3 = 8
            r12.addGreaterThan(r0, r10, r1, r3)
        L_0x036a:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r32 = r14
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r10
            r31 = r11
            goto L_0x0441
        L_0x0380:
            r12 = r54
            goto L_0x042d
        L_0x0384:
            r12 = r54
            r10 = r32
            r11 = r33
            r3 = 8
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0398
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r12.createObjectVariable(r0)
            r7 = r0
            goto L_0x039a
        L_0x0398:
            r7 = r40
        L_0x039a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x03a7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mLeft
            androidx.constraintlayout.core.SolverVariable r0 = r12.createObjectVariable(r0)
            r16 = r0
            goto L_0x03a9
        L_0x03a7:
            r16 = r40
        L_0x03a9:
            boolean[] r0 = r15.isTerminalWidget
            r17 = 0
            boolean r18 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r32 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mRight
            r41 = r2
            int r2 = r15.f10775j
            r42 = r2
            int r2 = r15.f10782q
            int[] r3 = r15.mMaxDimension
            r44 = r3[r17]
            float r3 = r15.f10784s
            r21 = 1
            r0 = r0[r21]
            if (r0 != r6) goto L_0x03ce
            r45 = r21
            goto L_0x03d0
        L_0x03ce:
            r45 = r17
        L_0x03d0:
            int r0 = r15.mMatchConstraintMinWidth
            r24 = r0
            int r0 = r15.mMatchConstraintMaxWidth
            r25 = r0
            float r0 = r15.mMatchConstraintPercentWidth
            r26 = r0
            r0 = r53
            r46 = r1
            r1 = r54
            r19 = r41
            r33 = r42
            r41 = r2
            r2 = 1
            r42 = r3
            r3 = r4
            r43 = r4
            r4 = r5
            r47 = r5
            r5 = r18
            r48 = r6
            r6 = r16
            r8 = r32
            r49 = r27
            r16 = r10
            r50 = r30
            r10 = r46
            r17 = r11
            r51 = r31
            r11 = r19
            r30 = r16
            r12 = r33
            r52 = r13
            r31 = r17
            r13 = r22
            r32 = r14
            r14 = r41
            r15 = r44
            r16 = r42
            r17 = r20
            r18 = r45
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r36
            r23 = r35
            r27 = r38
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0441
        L_0x042d:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r32
            r31 = r33
            r32 = r14
        L_0x0441:
            if (r55 == 0) goto L_0x04a7
            r15 = r53
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            if (r0 == 0) goto L_0x049a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x049a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x049a
            int r0 = r1.value
            r14 = r54
            r13 = r51
            r14.addEquality(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r12 = r50
            r14.addEquality(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r1 = r49
            r14.addEquality(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0494
            if (r28 != 0) goto L_0x0494
            if (r47 == 0) goto L_0x0494
            boolean[] r2 = r15.isTerminalWidget
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0490
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r2 = 8
            r10 = 0
            r14.addGreaterThan(r0, r12, r10, r2)
            goto L_0x0498
        L_0x0490:
            r2 = 8
            r10 = 0
            goto L_0x0498
        L_0x0494:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x0498:
            r7 = r10
            goto L_0x04b6
        L_0x049a:
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x04b5
        L_0x04a7:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r53
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
        L_0x04b5:
            r7 = r11
        L_0x04b6:
            int r0 = r15.mVerticalResolution
            r3 = 2
            if (r0 != r3) goto L_0x04bd
            r6 = r10
            goto L_0x04be
        L_0x04bd:
            r6 = r7
        L_0x04be:
            if (r6 == 0) goto L_0x059e
            boolean r0 = r15.resolvedVertical
            if (r0 != 0) goto L_0x059e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r0 = r0[r11]
            r3 = r52
            if (r0 != r3) goto L_0x04d2
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x04d2
            r9 = r11
            goto L_0x04d3
        L_0x04d2:
            r9 = r10
        L_0x04d3:
            if (r9 == 0) goto L_0x04d7
            r34 = r10
        L_0x04d7:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x04e3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r7 = r0
            goto L_0x04e5
        L_0x04e3:
            r7 = r40
        L_0x04e5:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x04f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTop
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r6 = r0
            goto L_0x04f3
        L_0x04f1:
            r6 = r40
        L_0x04f3:
            int r0 = r15.f10781p
            if (r0 > 0) goto L_0x04fb
            int r0 = r15.mVisibility
            if (r0 != r2) goto L_0x053b
        L_0x04fb:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0528
            int r0 = r53.getBaselineDistance()
            r14.addEquality(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBaseline
            int r3 = r3.getMargin()
            r14.addEquality(r1, r0, r3, r2)
            if (r47 == 0) goto L_0x0525
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r1 = 5
            r14.addGreaterThan(r7, r0, r10, r1)
        L_0x0525:
            r27 = r10
            goto L_0x053d
        L_0x0528:
            int r3 = r15.mVisibility
            if (r3 != r2) goto L_0x0534
            int r0 = r0.getMargin()
            r14.addEquality(r1, r13, r0, r2)
            goto L_0x053b
        L_0x0534:
            int r0 = r53.getBaselineDistance()
            r14.addEquality(r1, r13, r0, r2)
        L_0x053b:
            r27 = r38
        L_0x053d:
            boolean[] r0 = r15.isTerminalWidget
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            int r1 = r15.f10776k
            int r2 = r15.f10783r
            int[] r10 = r15.mMaxDimension
            r16 = r10[r11]
            float r10 = r15.f10785t
            r17 = 0
            r0 = r0[r17]
            r11 = r48
            if (r0 != r11) goto L_0x055e
            r18 = 1
            goto L_0x0560
        L_0x055e:
            r18 = r17
        L_0x0560:
            int r0 = r15.mMatchConstraintMinHeight
            r24 = r0
            int r0 = r15.mMatchConstraintMaxHeight
            r25 = r0
            float r0 = r15.mMatchConstraintPercentHeight
            r26 = r0
            r0 = r53
            r19 = r1
            r1 = r54
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r47
            r21 = r4
            r4 = r43
            r17 = r10
            r10 = r21
            r33 = r12
            r12 = r19
            r38 = r13
            r13 = r34
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r37
            r19 = r28
            r20 = r29
            r21 = r39
            r22 = r35
            r23 = r36
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05a2
        L_0x059e:
            r33 = r12
            r38 = r13
        L_0x05a2:
            if (r32 == 0) goto L_0x05cf
            r6 = 8
            r7 = r53
            int r0 = r7.f10767b
            r1 = 1
            if (r0 != r1) goto L_0x05bd
            float r5 = r7.f10768c
            r0 = r54
            r1 = r33
            r2 = r38
            r3 = r30
            r4 = r31
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x05d1
        L_0x05bd:
            float r5 = r7.f10768c
            r6 = 8
            r0 = r54
            r1 = r30
            r2 = r31
            r3 = r33
            r4 = r38
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x05d1
        L_0x05cf:
            r7 = r53
        L_0x05d1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x05f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r3 = r54
            r3.addCenterPoint(r7, r0, r1, r2)
        L_0x05f9:
            r0 = 0
            r7.resolvedHorizontal = r0
            r7.resolvedVertical = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public int b() {
        return this.f10775j + this.f10779n;
    }

    public int c() {
        return this.f10776k + this.f10780o;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i11);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i11, 0);
        this.mCircleConstraintAngle = f11;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.f10767b = constraintWidget.f10767b;
        this.f10768c = constraintWidget.f10768c;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.f10769d.reset();
        this.f10770e.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
        this.f10772g = constraintWidget.f10772g;
        this.f10773h = constraintWidget.f10773h;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.f10774i = constraintWidget.f10774i;
        this.f10775j = constraintWidget.f10775j;
        this.f10776k = constraintWidget.f10776k;
        this.f10777l = constraintWidget.f10777l;
        this.f10778m = constraintWidget.f10778m;
        this.f10779n = constraintWidget.f10779n;
        this.f10780o = constraintWidget.f10780o;
        this.f10781p = constraintWidget.f10781p;
        this.f10782q = constraintWidget.f10782q;
        this.f10783r = constraintWidget.f10783r;
        this.f10784s = constraintWidget.f10784s;
        this.f10785t = constraintWidget.f10785t;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.f10786u = constraintWidget.f10786u;
        this.f10787v = constraintWidget.f10787v;
        this.f10788w = constraintWidget.f10788w;
        this.f10789x = constraintWidget.f10789x;
        this.f10790y = constraintWidget.f10790y;
        this.f10791z = constraintWidget.f10791z;
        this.A = constraintWidget.A;
        this.B = constraintWidget.B;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.J;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.J;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.K;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.K;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.L;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.L = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.M;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.M = constraintWidget4;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.f10781p > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void d(int i11, boolean z11) {
        this.mIsInBarrier[i11] = z11;
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f10792a[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.f10769d;
            case 8:
                return this.f10770e;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.f10771f;
    }

    public int getBaselineDistance() {
        return this.f10781p;
    }

    public float getBiasPercent(int i11) {
        if (i11 == 0) {
            return this.f10784s;
        }
        if (i11 == 1) {
            return this.f10785t;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.f10773h;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i11) {
        if (i11 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i11 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.f10774i;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.f10773h;
    }

    public float getHorizontalBiasPercent() {
        return this.f10784s;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getHorizontalChainStyle() {
        return this.F;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i11 = 0;
        if (constraintAnchor != null) {
            i11 = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i11 + constraintAnchor2.mMargin;
        }
        return i11;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i11) {
        if (i11 == 0) {
            return getWidth();
        }
        if (i11 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.f10783r;
    }

    public int getMinWidth() {
        return this.f10782q;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget getNextChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.getNextChainMember(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public int getOptimizerWrapHeight() {
        int i11;
        int i12 = this.f10773h;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i12;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i11 = Math.max(this.mMatchConstraintMinHeight, i12);
        } else {
            i11 = this.mMatchConstraintMinHeight;
            if (i11 > 0) {
                this.f10773h = i11;
            } else {
                i11 = 0;
            }
        }
        int i13 = this.mMatchConstraintMaxHeight;
        if (i13 <= 0 || i13 >= i11) {
            return i11;
        }
        return i13;
    }

    public int getOptimizerWrapWidth() {
        int i11;
        int i12 = this.f10772g;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i12;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i11 = Math.max(this.mMatchConstraintMinWidth, i12);
        } else {
            i11 = this.mMatchConstraintMinWidth;
            if (i11 > 0) {
                this.f10772g = i11;
            } else {
                i11 = 0;
            }
        }
        int i13 = this.mMatchConstraintMaxWidth;
        if (i13 <= 0 || i13 >= i11) {
            return i11;
        }
        return i13;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mTop;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget getPreviousChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.getPreviousChainMember(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public int getRight() {
        return getX() + this.f10772g;
    }

    public WidgetRun getRun(int i11) {
        if (i11 == 0) {
            return this.horizontalRun;
        }
        if (i11 == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb2) {
        sb2.append("  " + this.stringId + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f10772g);
        sb2.append(sb3.toString());
        sb2.append(StringUtils.LF);
        sb2.append("    actualHeight:" + this.f10773h);
        sb2.append(StringUtils.LF);
        sb2.append("    actualLeft:" + this.f10775j);
        sb2.append(StringUtils.LF);
        sb2.append("    actualTop:" + this.f10776k);
        sb2.append(StringUtils.LF);
        getSceneString(sb2, "left", this.mLeft);
        getSceneString(sb2, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.mTop);
        getSceneString(sb2, TtmlNode.RIGHT, this.mRight);
        getSceneString(sb2, "bottom", this.mBottom);
        getSceneString(sb2, "baseline", this.mBaseline);
        getSceneString(sb2, "centerX", this.f10769d);
        getSceneString(sb2, "centerY", this.f10770e);
        getSceneString(sb2, "    width", this.f10772g, this.f10782q, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        getSceneString(sb2, "    height", this.f10773h, this.f10783r, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb2, "    dimensionRatio", this.mDimensionRatio, this.f10774i);
        serializeAttribute(sb2, "    horizontalBias", this.f10784s, DEFAULT_BIAS);
        serializeAttribute(sb2, "    verticalBias", this.f10785t, DEFAULT_BIAS);
        serializeAttribute(sb2, "    horizontalChainStyle", this.F, 0);
        serializeAttribute(sb2, "    verticalChainStyle", this.G, 0);
        sb2.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.f10785t;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getVerticalChainStyle() {
        return this.G;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i11 = 0;
        if (this.mLeft != null) {
            i11 = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return i11 + this.mBottom.mMargin;
        }
        return i11;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.f10772g;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f10775j;
        }
        return ((ConstraintWidgetContainer) constraintWidget).Q + this.f10775j;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f10776k;
        }
        return ((ConstraintWidgetContainer) constraintWidget).R + this.f10776k;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (i11 == 0) {
            if (this.mLeft.mTarget != null) {
                i15 = 1;
            } else {
                i15 = 0;
            }
            if (this.mRight.mTarget != null) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            if (i15 + i16 < 2) {
                return true;
            }
            return false;
        }
        if (this.mTop.mTarget != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        int i17 = i12 + i13;
        if (this.mBaseline.mTarget != null) {
            i14 = 1;
        } else {
            i14 = 0;
        }
        if (i17 + i14 < 2) {
            return true;
        }
        return false;
    }

    public boolean hasDependencies() {
        int size = this.f10771f.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f10771f.get(i11).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i11, int i12) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                if ((this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin()) >= i12) {
                    return true;
                }
                return false;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                if ((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin()) >= i12) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11, int i12) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i11, i12, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int i11) {
        return this.mIsInBarrier[i11];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i11) {
        char c11;
        if (i11 == 0) {
            c11 = 1;
        } else {
            c11 = 0;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i11];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c11];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
            return true;
        }
        return false;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.f10769d.reset();
        this.f10770e.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.f10772g = 0;
        this.f10773h = 0;
        this.mDimensionRatio = 0.0f;
        this.f10774i = -1;
        this.f10775j = 0;
        this.f10776k = 0;
        this.f10779n = 0;
        this.f10780o = 0;
        this.f10781p = 0;
        this.f10782q = 0;
        this.f10783r = 0;
        float f11 = DEFAULT_BIAS;
        this.f10784s = f11;
        this.f10785t = f11;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.C = false;
        this.D = false;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.f10766a = false;
        this.f10767b = -1;
        this.f10768c = 1.0f;
        this.E = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.f10784s = 0.5f;
                this.f10785t = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.f10784s = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.f10785t = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.f10771f.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f10771f.get(i11).reset();
            }
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int size = this.f10771f.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f10771f.get(i11).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.f10769d.resetSolverVariable(cache);
        this.f10770e.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb2) {
        sb2.append("{\n");
        serializeAnchor(sb2, "left", this.mLeft);
        serializeAnchor(sb2, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.mTop);
        serializeAnchor(sb2, TtmlNode.RIGHT, this.mRight);
        serializeAnchor(sb2, "bottom", this.mBottom);
        serializeAnchor(sb2, "baseline", this.mBaseline);
        serializeAnchor(sb2, "centerX", this.f10769d);
        serializeAnchor(sb2, "centerY", this.f10770e);
        serializeCircle(sb2, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(sb2, "width", this.f10772g, this.f10782q, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb2, "height", this.f10773h, this.f10783r, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb2, "dimensionRatio", this.mDimensionRatio, this.f10774i);
        serializeAttribute(sb2, "horizontalBias", this.f10784s, DEFAULT_BIAS);
        serializeAttribute(sb2, "verticalBias", this.f10785t, DEFAULT_BIAS);
        sb2.append("}\n");
        return sb2;
    }

    public void setBaselineDistance(int i11) {
        boolean z11;
        this.f10781p = i11;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.hasBaseline = z11;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i11) {
        if (i11 >= 0) {
            this.mContainerItemSkip = i11;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        createObjectVariable5.setName(str + ".baseline");
    }

    public void setDimension(int i11, int i12) {
        this.f10772g = i11;
        int i13 = this.f10782q;
        if (i11 < i13) {
            this.f10772g = i13;
        }
        this.f10773h = i12;
        int i14 = this.f10783r;
        if (i12 < i14) {
            this.f10773h = i14;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0090
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = r5
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0086
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0086
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0086
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r9 = r0
        L_0x0087:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            r8.mDimensionRatio = r9
            r8.f10774i = r5
        L_0x008f:
            return
        L_0x0090:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setFinalBaseline(int i11) {
        if (this.hasBaseline) {
            int i12 = i11 - this.f10781p;
            int i13 = this.f10773h + i12;
            this.f10776k = i12;
            this.mTop.setFinalValue(i12);
            this.mBottom.setFinalValue(i13);
            this.mBaseline.setFinalValue(i11);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i11, int i12, int i13, int i14, int i15, int i16) {
        setFrame(i11, i12, i13, i14);
        setBaselineDistance(i15);
        if (i16 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i16 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i16 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i11, int i12) {
        if (!this.resolvedHorizontal) {
            this.mLeft.setFinalValue(i11);
            this.mRight.setFinalValue(i12);
            this.f10775j = i11;
            this.f10772g = i12 - i11;
            this.resolvedHorizontal = true;
        }
    }

    public void setFinalLeft(int i11) {
        this.mLeft.setFinalValue(i11);
        this.f10775j = i11;
    }

    public void setFinalTop(int i11) {
        this.mTop.setFinalValue(i11);
        this.f10776k = i11;
    }

    public void setFinalVertical(int i11, int i12) {
        if (!this.resolvedVertical) {
            this.mTop.setFinalValue(i11);
            this.mBottom.setFinalValue(i12);
            this.f10776k = i11;
            this.f10773h = i12 - i11;
            if (this.hasBaseline) {
                this.mBaseline.setFinalValue(i11 + this.f10781p);
            }
            this.resolvedVertical = true;
        }
    }

    public void setFrame(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        this.f10775j = i11;
        this.f10776k = i12;
        if (this.mVisibility == 8) {
            this.f10772g = 0;
            this.f10773h = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i17 < (i16 = this.f10772g)) {
            i17 = i16;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i18 < (i15 = this.f10773h)) {
            i18 = i15;
        }
        this.f10772g = i17;
        this.f10773h = i18;
        int i19 = this.f10783r;
        if (i18 < i19) {
            this.f10773h = i19;
        }
        int i21 = this.f10782q;
        if (i17 < i21) {
            this.f10772g = i21;
        }
        int i22 = this.mMatchConstraintMaxWidth;
        if (i22 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f10772g = Math.min(this.f10772g, i22);
        }
        int i23 = this.mMatchConstraintMaxHeight;
        if (i23 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f10773h = Math.min(this.f10773h, i23);
        }
        int i24 = this.f10772g;
        if (i17 != i24) {
            this.mWidthOverride = i24;
        }
        int i25 = this.f10773h;
        if (i18 != i25) {
            this.mHeightOverride = i25;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i11) {
        int i12 = AnonymousClass1.f10792a[type.ordinal()];
        if (i12 == 1) {
            this.mLeft.f10763a = i11;
        } else if (i12 == 2) {
            this.mTop.f10763a = i11;
        } else if (i12 == 3) {
            this.mRight.f10763a = i11;
        } else if (i12 == 4) {
            this.mBottom.f10763a = i11;
        } else if (i12 == 5) {
            this.mBaseline.f10763a = i11;
        }
    }

    public void setHasBaseline(boolean z11) {
        this.hasBaseline = z11;
    }

    public void setHeight(int i11) {
        this.f10773h = i11;
        int i12 = this.f10783r;
        if (i11 < i12) {
            this.f10773h = i12;
        }
    }

    public void setHeightWrapContent(boolean z11) {
        this.mIsHeightWrapContent = z11;
    }

    public void setHorizontalBiasPercent(float f11) {
        this.f10784s = f11;
    }

    public void setHorizontalChainStyle(int i11) {
        this.F = i11;
    }

    public void setHorizontalDimension(int i11, int i12) {
        this.f10775j = i11;
        int i13 = i12 - i11;
        this.f10772g = i13;
        int i14 = this.f10782q;
        if (i13 < i14) {
            this.f10772g = i14;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i11, int i12, int i13, float f11) {
        this.mMatchConstraintDefaultWidth = i11;
        this.mMatchConstraintMinWidth = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.mMatchConstraintMaxWidth = i13;
        this.mMatchConstraintPercentWidth = f11;
        if (f11 > 0.0f && f11 < 1.0f && i11 == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f11) {
        this.mWeight[0] = f11;
    }

    public void setInPlaceholder(boolean z11) {
        this.inPlaceholder = z11;
    }

    public void setInVirtualLayout(boolean z11) {
        this.mInVirtualLayout = z11;
    }

    public void setLastMeasureSpec(int i11, int i12) {
        this.mLastHorizontalMeasureSpec = i11;
        this.mLastVerticalMeasureSpec = i12;
        setMeasureRequested(false);
    }

    public void setLength(int i11, int i12) {
        if (i12 == 0) {
            setWidth(i11);
        } else if (i12 == 1) {
            setHeight(i11);
        }
    }

    public void setMaxHeight(int i11) {
        this.mMaxDimension[1] = i11;
    }

    public void setMaxWidth(int i11) {
        this.mMaxDimension[0] = i11;
    }

    public void setMeasureRequested(boolean z11) {
        this.mMeasureRequested = z11;
    }

    public void setMinHeight(int i11) {
        if (i11 < 0) {
            this.f10783r = 0;
        } else {
            this.f10783r = i11;
        }
    }

    public void setMinWidth(int i11) {
        if (i11 < 0) {
            this.f10782q = 0;
        } else {
            this.f10782q = i11;
        }
    }

    public void setOffset(int i11, int i12) {
        this.f10779n = i11;
        this.f10780o = i12;
    }

    public void setOrigin(int i11, int i12) {
        this.f10775j = i11;
        this.f10776k = i12;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f11) {
        this.f10785t = f11;
    }

    public void setVerticalChainStyle(int i11) {
        this.G = i11;
    }

    public void setVerticalDimension(int i11, int i12) {
        this.f10776k = i11;
        int i13 = i12 - i11;
        this.f10773h = i13;
        int i14 = this.f10783r;
        if (i13 < i14) {
            this.f10773h = i14;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i11, int i12, int i13, float f11) {
        this.mMatchConstraintDefaultHeight = i11;
        this.mMatchConstraintMinHeight = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.mMatchConstraintMaxHeight = i13;
        this.mMatchConstraintPercentHeight = f11;
        if (f11 > 0.0f && f11 < 1.0f && i11 == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f11) {
        this.mWeight[1] = f11;
    }

    public void setVisibility(int i11) {
        this.mVisibility = i11;
    }

    public void setWidth(int i11) {
        this.f10772g = i11;
        int i12 = this.f10782q;
        if (i11 < i12) {
            this.f10772g = i12;
        }
    }

    public void setWidthWrapContent(boolean z11) {
        this.mIsWidthWrapContent = z11;
    }

    public void setWrapBehaviorInParent(int i11) {
        if (i11 >= 0 && i11 <= 3) {
            this.mWrapBehaviorInParent = i11;
        }
    }

    public void setX(int i11) {
        this.f10775j = i11;
    }

    public void setY(int i11) {
        this.f10776k = i11;
    }

    public void setupDimensionRatio(boolean z11, boolean z12, boolean z13, boolean z14) {
        if (this.f10767b == -1) {
            if (z13 && !z14) {
                this.f10767b = 0;
            } else if (!z13 && z14) {
                this.f10767b = 1;
                if (this.f10774i == -1) {
                    this.f10768c = 1.0f / this.f10768c;
                }
            }
        }
        if (this.f10767b == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.f10767b = 1;
        } else if (this.f10767b == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.f10767b = 0;
        }
        if (this.f10767b == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.f10767b = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.f10768c = 1.0f / this.f10768c;
                this.f10767b = 1;
            }
        }
        if (this.f10767b == -1) {
            int i11 = this.mMatchConstraintMinWidth;
            if (i11 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.f10767b = 0;
            } else if (i11 == 0 && this.mMatchConstraintMinHeight > 0) {
                this.f10768c = 1.0f / this.f10768c;
                this.f10767b = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb2.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f10775j);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.f10776k);
        sb2.append(") - (");
        sb2.append(this.f10772g);
        sb2.append(" x ");
        sb2.append(this.f10773h);
        sb2.append(")");
        return sb2.toString();
    }

    public void updateFromRuns(boolean z11, boolean z12) {
        int i11;
        int i12;
        boolean isResolved = z11 & this.horizontalRun.isResolved();
        boolean isResolved2 = z12 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i13 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i14 = verticalWidgetRun.start.value;
        int i15 = horizontalWidgetRun.end.value;
        int i16 = verticalWidgetRun.end.value;
        int i17 = i16 - i14;
        if (i15 - i13 < 0 || i17 < 0 || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE || i16 == Integer.MIN_VALUE || i16 == Integer.MAX_VALUE) {
            i15 = 0;
            i13 = 0;
            i16 = 0;
            i14 = 0;
        }
        int i18 = i15 - i13;
        int i19 = i16 - i14;
        if (isResolved) {
            this.f10775j = i13;
        }
        if (isResolved2) {
            this.f10776k = i14;
        }
        if (this.mVisibility == 8) {
            this.f10772g = 0;
            this.f10773h = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i18 < (i12 = this.f10772g)) {
                i18 = i12;
            }
            this.f10772g = i18;
            int i21 = this.f10782q;
            if (i18 < i21) {
                this.f10772g = i21;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i19 < (i11 = this.f10773h)) {
                i19 = i11;
            }
            this.f10773h = i19;
            int i22 = this.f10783r;
            if (i19 < i22) {
                this.f10773h = i22;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z11) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z11 && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z11 && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i11 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i11 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z11;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor = getAnchor(type4);
                ConstraintAnchor anchor2 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor.connect(anchor2, 0);
                anchor3.connect(anchor2, 0);
                getAnchor(type6).connect(anchor2, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor4 = constraintWidget.getAnchor(type2);
                getAnchor(type3).connect(anchor4, 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor4, 0);
                getAnchor(type7).connect(anchor4, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
                getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                getAnchor(type7).connect(constraintWidget.getAnchor(type2), 0);
            } else {
                ConstraintAnchor anchor5 = getAnchor(type);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                if (anchor5.isValidConnection(anchor6)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor7 != null) {
                            anchor7.reset();
                        }
                        if (anchor8 != null) {
                            anchor8.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor9 = getAnchor(type12);
                        if (anchor9 != null) {
                            anchor9.reset();
                        }
                        ConstraintAnchor anchor10 = getAnchor(type5);
                        if (anchor10.getTarget() != anchor6) {
                            anchor10.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor11 = getAnchor(type7);
                        if (anchor11.isConnected()) {
                            opposite.reset();
                            anchor11.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor12 = getAnchor(type5);
                        if (anchor12.getTarget() != anchor6) {
                            anchor12.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor13 = getAnchor(type6);
                        if (anchor13.isConnected()) {
                            opposite2.reset();
                            anchor13.reset();
                        }
                    }
                    anchor5.connect(anchor6, i11);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor anchor14 = getAnchor(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor anchor15 = getAnchor(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor anchor16 = getAnchor(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor anchor17 = getAnchor(type16);
            boolean z12 = true;
            if ((anchor14 == null || !anchor14.isConnected()) && (anchor15 == null || !anchor15.isConnected())) {
                connect(type13, constraintWidget, type13, 0);
                connect(type14, constraintWidget, type14, 0);
                z11 = true;
            } else {
                z11 = false;
            }
            if ((anchor16 == null || !anchor16.isConnected()) && (anchor17 == null || !anchor17.isConnected())) {
                connect(type15, constraintWidget, type15, 0);
                connect(type16, constraintWidget, type16, 0);
            } else {
                z12 = false;
            }
            if (z11 && z12) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
            } else if (z11) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            } else if (z12) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(type19, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(type20, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            }
        }
    }

    private void serializeAttribute(StringBuilder sb2, String str, int i11, int i12) {
        if (i11 != i12) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(i11);
            sb2.append(",\n");
        }
    }

    public void setDimensionRatio(float f11, int i11) {
        this.mDimensionRatio = f11;
        this.f10774i = i11;
    }

    public void setFrame(int i11, int i12, int i13) {
        if (i13 == 0) {
            setHorizontalDimension(i11, i12);
        } else if (i13 == 1) {
            setVerticalDimension(i11, i12);
        }
    }

    private void getSceneString(StringBuilder sb2, String str, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12) {
        sb2.append(str);
        sb2.append(" :  {\n");
        serializeAttribute(sb2, "      size", i11, 0);
        serializeAttribute(sb2, "      min", i12, 0);
        serializeAttribute(sb2, "      max", i13, Integer.MAX_VALUE);
        serializeAttribute(sb2, "      matchMin", i15, 0);
        serializeAttribute(sb2, "      matchDef", i16, 0);
        serializeAttribute(sb2, "      matchPercent", f11, 1.0f);
        sb2.append("    },\n");
    }

    private void getSceneString(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb2.append("    ");
            sb2.append(str);
            sb2.append(" : [ '");
            sb2.append(constraintAnchor.mTarget);
            sb2.append("'");
            if (!(constraintAnchor.f10763a == Integer.MIN_VALUE && constraintAnchor.mMargin == 0)) {
                sb2.append(",");
                sb2.append(constraintAnchor.mMargin);
                if (constraintAnchor.f10763a != Integer.MIN_VALUE) {
                    sb2.append(",");
                    sb2.append(constraintAnchor.f10763a);
                    sb2.append(",");
                }
            }
            sb2.append(" ] ,\n");
        }
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f10766a = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f10767b = -1;
        this.f10768c = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f10769d = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f10770e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.f10771f = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.f10772g = 0;
        this.f10773h = 0;
        this.mDimensionRatio = 0.0f;
        this.f10774i = -1;
        this.f10775j = 0;
        this.f10776k = 0;
        this.f10777l = 0;
        this.f10778m = 0;
        this.f10779n = 0;
        this.f10780o = 0;
        this.f10781p = 0;
        float f11 = DEFAULT_BIAS;
        this.f10784s = f11;
        this.f10785t = f11;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.J = new ConstraintWidget[]{null, null};
        this.K = new ConstraintWidget[]{null, null};
        this.L = null;
        this.M = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i11, int i12, int i13, int i14) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f10766a = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f10767b = -1;
        this.f10768c = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f10769d = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f10770e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.f10771f = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.f10774i = -1;
        this.f10777l = 0;
        this.f10778m = 0;
        this.f10779n = 0;
        this.f10780o = 0;
        this.f10781p = 0;
        float f11 = DEFAULT_BIAS;
        this.f10784s = f11;
        this.f10785t = f11;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.J = new ConstraintWidget[]{null, null};
        this.K = new ConstraintWidget[]{null, null};
        this.L = null;
        this.M = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.f10775j = i11;
        this.f10776k = i12;
        this.f10772g = i13;
        this.f10773h = i14;
        addAnchors();
    }

    public ConstraintWidget(String str, int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14);
        setDebugName(str);
    }

    public ConstraintWidget(int i11, int i12) {
        this(0, 0, i11, i12);
    }

    public ConstraintWidget(String str, int i11, int i12) {
        this(i11, i12);
        setDebugName(str);
    }
}
