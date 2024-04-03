package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.3";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer = new Measurer(this);
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11102a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11102a = r0
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11102a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11102a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f11102a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public class Measurer implements BasicMeasure.Measurer {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f11125a;

        /* renamed from: b  reason: collision with root package name */
        public int f11126b;

        /* renamed from: c  reason: collision with root package name */
        public int f11127c;

        /* renamed from: d  reason: collision with root package name */
        public int f11128d;

        /* renamed from: e  reason: collision with root package name */
        public int f11129e;

        /* renamed from: f  reason: collision with root package name */
        public int f11130f;

        /* renamed from: g  reason: collision with root package name */
        public int f11131g;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f11125a = constraintLayout;
        }

        private boolean isSimilarSpec(int i11, int i12, int i13) {
            if (i11 == i12) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i11);
            View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i13 == size) {
                return true;
            }
            return false;
        }

        public void captureLayoutInfo(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f11126b = i13;
            this.f11127c = i14;
            this.f11128d = i15;
            this.f11129e = i16;
            this.f11130f = i11;
            this.f11131g = i12;
        }

        public final void didMeasures() {
            int childCount = this.f11125a.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.f11125a.getChildAt(i11);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.f11125a);
                }
            }
            int size = this.f11125a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    ((ConstraintHelper) this.f11125a.mConstraintHelpers.get(i12)).updatePostMeasure(this.f11125a);
                }
            }
        }

        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int i11;
            int i12;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            int i13;
            int i14;
            int i15;
            int i16;
            boolean z17;
            boolean z18;
            int i17;
            int i18;
            boolean z19;
            boolean z21;
            boolean z22;
            boolean z23;
            boolean z24;
            boolean z25;
            boolean z26;
            ConstraintWidget constraintWidget2 = constraintWidget;
            BasicMeasure.Measure measure2 = measure;
            if (constraintWidget2 != null) {
                if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                    measure2.measuredWidth = 0;
                    measure2.measuredHeight = 0;
                    measure2.measuredBaseline = 0;
                } else if (constraintWidget.getParent() != null) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure2.horizontalBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure2.verticalBehavior;
                    int i19 = measure2.horizontalDimension;
                    int i21 = measure2.verticalDimension;
                    int i22 = this.f11126b + this.f11127c;
                    int i23 = this.f11128d;
                    View view = (View) constraintWidget.getCompanionWidget();
                    int[] iArr = AnonymousClass1.f11102a;
                    int i24 = iArr[dimensionBehaviour.ordinal()];
                    if (i24 == 1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    } else if (i24 == 2) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f11130f, i23, -2);
                    } else if (i24 == 3) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f11130f, i23 + constraintWidget.getHorizontalMargin(), -1);
                    } else if (i24 != 4) {
                        i11 = 0;
                    } else {
                        i11 = ViewGroup.getChildMeasureSpec(this.f11130f, i23, -2);
                        if (constraintWidget2.mMatchConstraintDefaultWidth == 1) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        int i25 = measure2.measureStrategy;
                        if (i25 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i25 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                            if (view.getMeasuredHeight() == constraintWidget.getHeight()) {
                                z25 = true;
                            } else {
                                z25 = false;
                            }
                            if (measure2.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z24 || ((z24 && z25) || (view instanceof Placeholder) || constraintWidget.isResolvedHorizontally())) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                i11 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                            }
                        }
                    }
                    int i26 = iArr[dimensionBehaviour2.ordinal()];
                    if (i26 == 1) {
                        i12 = View.MeasureSpec.makeMeasureSpec(i21, 1073741824);
                    } else if (i26 == 2) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f11131g, i22, -2);
                    } else if (i26 == 3) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f11131g, i22 + constraintWidget.getVerticalMargin(), -1);
                    } else if (i26 != 4) {
                        i12 = 0;
                    } else {
                        i12 = ViewGroup.getChildMeasureSpec(this.f11131g, i22, -2);
                        if (constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        int i27 = measure2.measureStrategy;
                        if (i27 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i27 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                            if (view.getMeasuredWidth() == constraintWidget.getWidth()) {
                                z22 = true;
                            } else {
                                z22 = false;
                            }
                            if (measure2.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z21 || ((z21 && z22) || (view instanceof Placeholder) || constraintWidget.isResolvedVertically())) {
                                z23 = true;
                            } else {
                                z23 = false;
                            }
                            if (z23) {
                                i12 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                            }
                        }
                    }
                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
                    if (constraintWidgetContainer != null && Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
                        if (!isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), i11, constraintWidget.getWidth()) || !isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), i12, constraintWidget.getHeight())) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        if (z19) {
                            measure2.measuredWidth = constraintWidget.getWidth();
                            measure2.measuredHeight = constraintWidget.getHeight();
                            measure2.measuredBaseline = constraintWidget.getBaselineDistance();
                            return;
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                    if (dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (!z11 || constraintWidget2.mDimensionRatio <= 0.0f) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (!z12 || constraintWidget2.mDimensionRatio <= 0.0f) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (view != null) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int i28 = measure2.measureStrategy;
                        if (i28 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i28 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z11 || constraintWidget2.mMatchConstraintDefaultWidth != 0 || !z12 || constraintWidget2.mMatchConstraintDefaultHeight != 0) {
                            if (!(view instanceof VirtualLayout) || !(constraintWidget2 instanceof VirtualLayout)) {
                                view.measure(i11, i12);
                            } else {
                                ((VirtualLayout) view).onMeasure((VirtualLayout) constraintWidget2, i11, i12);
                            }
                            constraintWidget2.setLastMeasureSpec(i11, i12);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            i14 = view.getBaseline();
                            int i29 = constraintWidget2.mMatchConstraintMinWidth;
                            if (i29 > 0) {
                                i13 = Math.max(i29, measuredWidth);
                            } else {
                                i13 = measuredWidth;
                            }
                            int i31 = constraintWidget2.mMatchConstraintMaxWidth;
                            if (i31 > 0) {
                                i13 = Math.min(i31, i13);
                            }
                            int i32 = constraintWidget2.mMatchConstraintMinHeight;
                            if (i32 > 0) {
                                i15 = Math.max(i32, measuredHeight);
                                i17 = i11;
                            } else {
                                i17 = i11;
                                i15 = measuredHeight;
                            }
                            int i33 = constraintWidget2.mMatchConstraintMaxHeight;
                            if (i33 > 0) {
                                i15 = Math.min(i33, i15);
                            }
                            if (!Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 1)) {
                                if (z15 && z13) {
                                    i13 = (int) ((((float) i15) * constraintWidget2.mDimensionRatio) + 0.5f);
                                } else if (z16 && z14) {
                                    i15 = (int) ((((float) i13) / constraintWidget2.mDimensionRatio) + 0.5f);
                                }
                            }
                            if (!(measuredWidth == i13 && measuredHeight == i15)) {
                                if (measuredWidth != i13) {
                                    i18 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                } else {
                                    i18 = i17;
                                }
                                if (measuredHeight != i15) {
                                    i12 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                }
                                view.measure(i18, i12);
                                constraintWidget2.setLastMeasureSpec(i18, i12);
                                i13 = view.getMeasuredWidth();
                                i15 = view.getMeasuredHeight();
                                i14 = view.getBaseline();
                            }
                            i16 = -1;
                        } else {
                            i16 = -1;
                            i15 = 0;
                            i14 = 0;
                            i13 = 0;
                        }
                        if (i14 != i16) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i13 == measure2.horizontalDimension && i15 == measure2.verticalDimension) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        measure2.measuredNeedsSolverPass = z18;
                        if (layoutParams.f11109g) {
                            z17 = true;
                        }
                        if (!(!z17 || i14 == -1 || constraintWidget.getBaselineDistance() == i14)) {
                            measure2.measuredNeedsSolverPass = true;
                        }
                        measure2.measuredWidth = i13;
                        measure2.measuredHeight = i15;
                        measure2.measuredHasBaseline = z17;
                        measure2.measuredBaseline = i14;
                    }
                }
            }
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int i11) {
        if (i11 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i11);
        if (view == null && (view = findViewById(i11)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f11124v;
    }

    private void init(AttributeSet attributeSet, int i11, int i12) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i11, i12);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i13 = 0; i13 < indexCount; i13++) {
                int index = obtainStyledAttributes.getIndex(i13);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i11));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.h(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                this.mConstraintHelpers.get(i14).updatePreLayout(this);
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt3 = getChildAt(i15);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt4 = getChildAt(i16);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt5 = getChildAt(i17);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i11, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i11);
        ConstraintWidget constraintWidget2 = sparseArray.get(i11);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f11109g = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f11109g = true;
                layoutParams2.f11124v.setHasBaseline(true);
            }
            constraintWidget.getAnchor(type2).connect(constraintWidget2.getAnchor(type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
            constraintWidget.setHasBaseline(true);
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
            constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            } else if (getChildAt(i11).isLayoutRequested()) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            setChildrenConstraints();
        }
        return z11;
    }

    public void applyConstraintsFromLayoutParams(boolean z11, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i11;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        View view2 = view;
        ConstraintWidget constraintWidget6 = constraintWidget;
        LayoutParams layoutParams2 = layoutParams;
        SparseArray<ConstraintWidget> sparseArray2 = sparseArray;
        layoutParams.validate();
        layoutParams2.helped = false;
        constraintWidget6.setVisibility(view.getVisibility());
        if (layoutParams2.f11112j) {
            constraintWidget6.setInPlaceholder(true);
            constraintWidget6.setVisibility(8);
        }
        constraintWidget6.setCompanionWidget(view2);
        if (view2 instanceof ConstraintHelper) {
            ((ConstraintHelper) view2).resolveRtl(constraintWidget6, this.mLayoutWidget.isRtl());
        }
        if (layoutParams2.f11110h) {
            Guideline guideline = (Guideline) constraintWidget6;
            int i12 = layoutParams2.f11121s;
            int i13 = layoutParams2.f11122t;
            float f11 = layoutParams2.f11123u;
            if (f11 != -1.0f) {
                guideline.setGuidePercent(f11);
            } else if (i12 != -1) {
                guideline.setGuideBegin(i12);
            } else if (i13 != -1) {
                guideline.setGuideEnd(i13);
            }
        } else {
            int i14 = layoutParams2.f11114l;
            int i15 = layoutParams2.f11115m;
            int i16 = layoutParams2.f11116n;
            int i17 = layoutParams2.f11117o;
            int i18 = layoutParams2.f11118p;
            int i19 = layoutParams2.f11119q;
            float f12 = layoutParams2.f11120r;
            int i21 = layoutParams2.circleConstraint;
            if (i21 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray2.get(i21);
                if (constraintWidget7 != null) {
                    constraintWidget6.connectCircularConstraint(constraintWidget7, layoutParams2.circleAngle, layoutParams2.circleRadius);
                }
            } else {
                if (i14 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray2.get(i14);
                    if (constraintWidget8 != null) {
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        constraintWidget.immediateConnect(type, constraintWidget8, type, layoutParams2.leftMargin, i18);
                    }
                } else if (!(i15 == -1 || (constraintWidget5 = sparseArray2.get(i15)) == null)) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, layoutParams2.leftMargin, i18);
                }
                if (i16 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray2.get(i16);
                    if (constraintWidget9 != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget9, ConstraintAnchor.Type.LEFT, layoutParams2.rightMargin, i19);
                    }
                } else if (!(i17 == -1 || (constraintWidget4 = sparseArray2.get(i17)) == null)) {
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.immediateConnect(type2, constraintWidget4, type2, layoutParams2.rightMargin, i19);
                }
                int i22 = layoutParams2.topToTop;
                if (i22 != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray2.get(i22);
                    if (constraintWidget10 != null) {
                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                        constraintWidget.immediateConnect(type3, constraintWidget10, type3, layoutParams2.topMargin, layoutParams2.goneTopMargin);
                    }
                } else {
                    int i23 = layoutParams2.topToBottom;
                    if (!(i23 == -1 || (constraintWidget3 = sparseArray2.get(i23)) == null)) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, layoutParams2.topMargin, layoutParams2.goneTopMargin);
                    }
                }
                int i24 = layoutParams2.bottomToTop;
                if (i24 != -1) {
                    ConstraintWidget constraintWidget11 = sparseArray2.get(i24);
                    if (constraintWidget11 != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget11, ConstraintAnchor.Type.TOP, layoutParams2.bottomMargin, layoutParams2.goneBottomMargin);
                    }
                } else {
                    int i25 = layoutParams2.bottomToBottom;
                    if (!(i25 == -1 || (constraintWidget2 = sparseArray2.get(i25)) == null)) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                        constraintWidget.immediateConnect(type4, constraintWidget2, type4, layoutParams2.bottomMargin, layoutParams2.goneBottomMargin);
                    }
                }
                int i26 = layoutParams2.baselineToBaseline;
                if (i26 != -1) {
                    setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i26, ConstraintAnchor.Type.BASELINE);
                } else {
                    int i27 = layoutParams2.baselineToTop;
                    if (i27 != -1) {
                        setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i27, ConstraintAnchor.Type.TOP);
                    } else {
                        int i28 = layoutParams2.baselineToBottom;
                        if (i28 != -1) {
                            setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i28, ConstraintAnchor.Type.BOTTOM);
                        }
                    }
                }
                if (f12 >= 0.0f) {
                    constraintWidget6.setHorizontalBiasPercent(f12);
                }
                float f13 = layoutParams2.verticalBias;
                if (f13 >= 0.0f) {
                    constraintWidget6.setVerticalBiasPercent(f13);
                }
            }
            if (z11 && !((i11 = layoutParams2.editorAbsoluteX) == -1 && layoutParams2.editorAbsoluteY == -1)) {
                constraintWidget6.setOrigin(i11, layoutParams2.editorAbsoluteY);
            }
            if (layoutParams2.f11107e) {
                constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.setWidth(layoutParams2.width);
                if (layoutParams2.width == -2) {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.width == -1) {
                if (layoutParams2.constrainedWidth) {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = layoutParams2.leftMargin;
                constraintWidget6.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = layoutParams2.rightMargin;
            } else {
                constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.setWidth(0);
            }
            if (layoutParams2.f11108f) {
                constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.setHeight(layoutParams2.height);
                if (layoutParams2.height == -2) {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.height == -1) {
                if (layoutParams2.constrainedHeight) {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.getAnchor(ConstraintAnchor.Type.TOP).mMargin = layoutParams2.topMargin;
                constraintWidget6.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams2.bottomMargin;
            } else {
                constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.setHeight(0);
            }
            constraintWidget6.setDimensionRatio(layoutParams2.dimensionRatio);
            constraintWidget6.setHorizontalWeight(layoutParams2.horizontalWeight);
            constraintWidget6.setVerticalWeight(layoutParams2.verticalWeight);
            constraintWidget6.setHorizontalChainStyle(layoutParams2.horizontalChainStyle);
            constraintWidget6.setVerticalChainStyle(layoutParams2.verticalChainStyle);
            constraintWidget6.setWrapBehaviorInParent(layoutParams2.wrapBehaviorInParent);
            constraintWidget6.setHorizontalMatchStyle(layoutParams2.matchConstraintDefaultWidth, layoutParams2.matchConstraintMinWidth, layoutParams2.matchConstraintMaxWidth, layoutParams2.matchConstraintPercentWidth);
            constraintWidget6.setVerticalMatchStyle(layoutParams2.matchConstraintDefaultHeight, layoutParams2.matchConstraintMinHeight, layoutParams2.matchConstraintMaxHeight, layoutParams2.matchConstraintPercentHeight);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.mConstraintHelpers.get(i11).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i13 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i14 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f11 = (float) i13;
                        float f12 = (float) i14;
                        float f13 = (float) (i13 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f14 = f12;
                        float f15 = f12;
                        float f16 = f13;
                        float f17 = f11;
                        Paint paint2 = paint;
                        canvas2.drawLine(f11, f14, f16, f15, paint);
                        float parseInt4 = (float) (i14 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f18 = f13;
                        float f19 = parseInt4;
                        canvas2.drawLine(f18, f15, f16, f19, paint);
                        float f21 = parseInt4;
                        float f22 = f17;
                        canvas2.drawLine(f18, f21, f22, f19, paint);
                        float f23 = f17;
                        canvas2.drawLine(f23, f21, f22, f15, paint);
                        paint.setColor(-16711936);
                        float f24 = f13;
                        Paint paint3 = paint;
                        canvas2.drawLine(f23, f15, f24, parseInt4, paint);
                        canvas2.drawLine(f23, parseInt4, f24, f15, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i11, Object obj) {
        if (i11 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.mLayoutWidget.stringId == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.mLayoutWidget.stringId = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.mLayoutWidget.stringId = "parent";
            }
        }
        if (this.mLayoutWidget.getDebugName() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.setDebugName(constraintWidgetContainer.stringId);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" setDebugName ");
            sb3.append(this.mLayoutWidget.getDebugName());
        }
        Iterator<ConstraintWidget> it = this.mLayoutWidget.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.getCompanionWidget();
            if (view != null) {
                if (next.stringId == null && (id2 = view.getId()) != -1) {
                    next.stringId = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.getDebugName() == null) {
                    next.setDebugName(next.stringId);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" setDebugName ");
                    sb4.append(next.getDebugName());
                }
            }
        }
        this.mLayoutWidget.getSceneString(sb2);
        return sb2.toString();
    }

    public View getViewById(int i11) {
        return this.mChildrenByIds.get(i11);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f11124v;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f11124v;
        }
        return null;
    }

    public boolean isRtl() {
        boolean z11;
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i11) {
        if (i11 != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i11);
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f11124v;
            if ((childAt.getVisibility() != 8 || layoutParams.f11110h || layoutParams.f11111i || layoutParams.f11113k || isInEditMode) && !layoutParams.f11112j) {
                int x11 = constraintWidget.getX();
                int y11 = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x11;
                int height = constraintWidget.getHeight() + y11;
                childAt.layout(x11, y11, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x11, y11, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i16 = 0; i16 < size; i16++) {
                this.mConstraintHelpers.get(i16).updatePostLayout(this);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        if (this.mOnMeasureWidthMeasureSpec == i11) {
            int i13 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount) {
                    break;
                } else if (getChildAt(i14).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i14++;
                }
            }
        }
        boolean z11 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = i11;
        this.mOnMeasureHeightMeasureSpec = i12;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i11, i12);
        resolveMeasuredDimension(i11, i12, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.f11124v = guideline;
            layoutParams.f11110h = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).f11111i = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i11);
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
        Measurer measurer = this.mMeasurer;
        int i15 = measurer.f11129e;
        int resolveSizeAndState = View.resolveSizeAndState(i13 + measurer.f11128d, i11, 0);
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, View.resolveSizeAndState(i14 + i15, i12, 0) & 16777215);
        if (z11) {
            min |= 16777216;
        }
        if (z12) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i11, int i12, int i13) {
        int i14;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i15 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(i12, i13, max, max2, paddingWidth, i15);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i14 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i14 = max4;
        } else {
            i14 = max3;
        }
        int i16 = size - paddingWidth;
        int i17 = size2 - i15;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i16, mode2, i17);
        constraintWidgetContainer.measure(i11, mode, i16, mode2, i17, this.mLastMeasureWidth, this.mLastMeasureHeight, i14, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i11, Object obj, Object obj2) {
        if (i11 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i11) {
        this.mChildrenByIds.remove(getId());
        super.setId(i11);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i11) {
        if (i11 != this.mMaxHeight) {
            this.mMaxHeight = i11;
            requestLayout();
        }
    }

    public void setMaxWidth(int i11) {
        if (i11 != this.mMaxWidth) {
            this.mMaxWidth = i11;
            requestLayout();
        }
    }

    public void setMinHeight(int i11) {
        if (i11 != this.mMinHeight) {
            this.mMinHeight = i11;
            requestLayout();
        }
    }

    public void setMinWidth(int i11) {
        if (i11 != this.mMinWidth) {
            this.mMinWidth = i11;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i11) {
        this.mOptimizationLevel = i11;
        this.mLayoutWidget.setOptimizationLevel(i11);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i11, int i12, int i13, int i14) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i15 = measurer.f11129e;
        int i16 = measurer.f11128d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i11 != Integer.MIN_VALUE) {
            if (i11 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i12 = Math.max(0, this.mMinWidth);
                }
            } else if (i11 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i12 = Math.min(this.mMaxWidth - i16, i12);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i12 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i12 = Math.max(0, this.mMinWidth);
            }
        }
        if (i13 != Integer.MIN_VALUE) {
            if (i13 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i14 = Math.max(0, this.mMinHeight);
                }
            } else if (i13 == 1073741824) {
                i14 = Math.min(this.mMaxHeight - i15, i14);
            }
            i14 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i14 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i12 == constraintWidgetContainer.getWidth() && i14 == constraintWidgetContainer.getHeight())) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i16);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i15);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i12);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i14);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i16);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i15);
    }

    public void setState(int i11, int i12, int i13) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i11, (float) i12, (float) i13);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet, i11, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(attributeSet, i11, i12);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11103a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11104b = true;
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f11105c = 0.0f;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String constraintTag = null;

        /* renamed from: d  reason: collision with root package name */
        public int f11106d = 1;
        public String dimensionRatio = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11107e = true;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11108f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11109g = false;
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

        /* renamed from: h  reason: collision with root package name */
        public boolean f11110h = false;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11111i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f11112j = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f11113k = false;

        /* renamed from: l  reason: collision with root package name */
        public int f11114l = -1;
        public int leftToLeft = -1;
        public int leftToRight = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f11115m = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;

        /* renamed from: n  reason: collision with root package name */
        public int f11116n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f11117o = -1;
        public int orientation = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f11118p = Integer.MIN_VALUE;

        /* renamed from: q  reason: collision with root package name */
        public int f11119q = Integer.MIN_VALUE;

        /* renamed from: r  reason: collision with root package name */
        public float f11120r = 0.5f;
        public int rightToLeft = -1;
        public int rightToRight = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f11121s;
        public int startToEnd = -1;
        public int startToStart = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f11122t;
        public int topToBottom = -1;
        public int topToTop = -1;

        /* renamed from: u  reason: collision with root package name */
        public float f11123u;

        /* renamed from: v  reason: collision with root package name */
        public ConstraintWidget f11124v = new ConstraintWidget();
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int wrapBehaviorInParent = 0;

        public static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int GUIDELINE_USE_RTL = 67;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF = 53;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF = 52;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT = 65;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH = 64;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BASELINE = 55;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int LAYOUT_MARGIN_BASELINE = 54;
            public static final int LAYOUT_WRAP_BEHAVIOR_IN_PARENT = 66;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }

            private Table() {
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.guidelineUseRtl = layoutParams.guidelineUseRtl;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.baselineToTop = layoutParams.baselineToTop;
            this.baselineToBottom = layoutParams.baselineToBottom;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.goneBaselineMargin = layoutParams.goneBaselineMargin;
            this.baselineMargin = layoutParams.baselineMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.f11105c = layoutParams.f11105c;
            this.f11106d = layoutParams.f11106d;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.f11107e = layoutParams.f11107e;
            this.f11108f = layoutParams.f11108f;
            this.f11109g = layoutParams.f11109g;
            this.f11110h = layoutParams.f11110h;
            this.f11114l = layoutParams.f11114l;
            this.f11115m = layoutParams.f11115m;
            this.f11116n = layoutParams.f11116n;
            this.f11117o = layoutParams.f11117o;
            this.f11118p = layoutParams.f11118p;
            this.f11119q = layoutParams.f11119q;
            this.f11120r = layoutParams.f11120r;
            this.constraintTag = layoutParams.constraintTag;
            this.wrapBehaviorInParent = layoutParams.wrapBehaviorInParent;
            this.f11124v = layoutParams.f11124v;
            this.f11103a = layoutParams.f11103a;
            this.f11104b = layoutParams.f11104b;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.f11124v;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.f11124v;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r11) goto L_0x0011
                r11 = r3
                goto L_0x0012
            L_0x0011:
                r11 = r2
            L_0x0012:
                r4 = -1
                r10.f11116n = r4
                r10.f11117o = r4
                r10.f11114l = r4
                r10.f11115m = r4
                int r5 = r10.goneLeftMargin
                r10.f11118p = r5
                int r5 = r10.goneRightMargin
                r10.f11119q = r5
                float r5 = r10.horizontalBias
                r10.f11120r = r5
                int r6 = r10.guideBegin
                r10.f11121s = r6
                int r7 = r10.guideEnd
                r10.f11122t = r7
                float r8 = r10.guidePercent
                r10.f11123u = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x0094
                int r11 = r10.startToEnd
                if (r11 == r4) goto L_0x003f
                r10.f11116n = r11
            L_0x003d:
                r2 = r3
                goto L_0x0046
            L_0x003f:
                int r11 = r10.startToStart
                if (r11 == r4) goto L_0x0046
                r10.f11117o = r11
                goto L_0x003d
            L_0x0046:
                int r11 = r10.endToStart
                if (r11 == r4) goto L_0x004d
                r10.f11115m = r11
                r2 = r3
            L_0x004d:
                int r11 = r10.endToEnd
                if (r11 == r4) goto L_0x0054
                r10.f11114l = r11
                r2 = r3
            L_0x0054:
                int r11 = r10.goneStartMargin
                if (r11 == r9) goto L_0x005a
                r10.f11119q = r11
            L_0x005a:
                int r11 = r10.goneEndMargin
                if (r11 == r9) goto L_0x0060
                r10.f11118p = r11
            L_0x0060:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0068
                float r2 = r11 - r5
                r10.f11120r = r2
            L_0x0068:
                boolean r2 = r10.f11110h
                if (r2 == 0) goto L_0x00b8
                int r2 = r10.orientation
                if (r2 != r3) goto L_0x00b8
                boolean r2 = r10.guidelineUseRtl
                if (r2 == 0) goto L_0x00b8
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0082
                float r11 = r11 - r8
                r10.f11123u = r11
                r10.f11121s = r4
                r10.f11122t = r4
                goto L_0x00b8
            L_0x0082:
                if (r6 == r4) goto L_0x008b
                r10.f11122t = r6
                r10.f11121s = r4
                r10.f11123u = r2
                goto L_0x00b8
            L_0x008b:
                if (r7 == r4) goto L_0x00b8
                r10.f11121s = r7
                r10.f11122t = r4
                r10.f11123u = r2
                goto L_0x00b8
            L_0x0094:
                int r11 = r10.startToEnd
                if (r11 == r4) goto L_0x009a
                r10.f11115m = r11
            L_0x009a:
                int r11 = r10.startToStart
                if (r11 == r4) goto L_0x00a0
                r10.f11114l = r11
            L_0x00a0:
                int r11 = r10.endToStart
                if (r11 == r4) goto L_0x00a6
                r10.f11116n = r11
            L_0x00a6:
                int r11 = r10.endToEnd
                if (r11 == r4) goto L_0x00ac
                r10.f11117o = r11
            L_0x00ac:
                int r11 = r10.goneStartMargin
                if (r11 == r9) goto L_0x00b2
                r10.f11118p = r11
            L_0x00b2:
                int r11 = r10.goneEndMargin
                if (r11 == r9) goto L_0x00b8
                r10.f11119q = r11
            L_0x00b8:
                int r11 = r10.endToStart
                if (r11 != r4) goto L_0x0102
                int r11 = r10.endToEnd
                if (r11 != r4) goto L_0x0102
                int r11 = r10.startToStart
                if (r11 != r4) goto L_0x0102
                int r11 = r10.startToEnd
                if (r11 != r4) goto L_0x0102
                int r11 = r10.rightToLeft
                if (r11 == r4) goto L_0x00d7
                r10.f11116n = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
                goto L_0x00e5
            L_0x00d7:
                int r11 = r10.rightToRight
                if (r11 == r4) goto L_0x00e5
                r10.f11117o = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
            L_0x00e5:
                int r11 = r10.leftToLeft
                if (r11 == r4) goto L_0x00f4
                r10.f11114l = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
                goto L_0x0102
            L_0x00f4:
                int r11 = r10.leftToRight
                if (r11 == r4) goto L_0x0102
                r10.f11115m = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void setWidgetDebugName(String str) {
            this.f11124v.setDebugName(str);
        }

        public void validate() {
            this.f11110h = false;
            this.f11107e = true;
            this.f11108f = true;
            int i11 = this.width;
            if (i11 == -2 && this.constrainedWidth) {
                this.f11107e = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i12 = this.height;
            if (i12 == -2 && this.constrainedHeight) {
                this.f11108f = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f11107e = false;
                if (i11 == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i12 == 0 || i12 == -1) {
                this.f11108f = false;
                if (i12 == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.f11110h = true;
                this.f11107e = true;
                this.f11108f = true;
                if (!(this.f11124v instanceof Guideline)) {
                    this.f11124v = new Guideline();
                }
                ((Guideline) this.f11124v).setOrientation(this.orientation);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = Table.map.get(index);
                switch (i12) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f11 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f11;
                        if (f11 >= 0.0f) {
                            break;
                        } else {
                            this.circleAngle = (360.0f - f11) % 360.0f;
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i13;
                        if (i13 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i14;
                        if (i14 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinWidth = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinHeight = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i12) {
                            case 44:
                                ConstraintSet.k(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                                this.baselineToTop = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                                this.baselineToBottom = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                break;
                            case 55:
                                this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                break;
                            default:
                                switch (i12) {
                                    case 64:
                                        ConstraintSet.i(this, obtainStyledAttributes, index, 0);
                                        this.f11103a = true;
                                        break;
                                    case 65:
                                        ConstraintSet.i(this, obtainStyledAttributes, index, 1);
                                        this.f11104b = true;
                                        break;
                                    case 66:
                                        this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                        break;
                                    case 67:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
