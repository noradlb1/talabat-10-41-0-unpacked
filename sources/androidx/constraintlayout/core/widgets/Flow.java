package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ConstraintWidget[] mDisplayedWidgets;
    /* access modifiers changed from: private */
    public int mDisplayedWidgetsCount = 0;
    /* access modifiers changed from: private */
    public float mFirstHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mFirstVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstVerticalStyle = -1;
    /* access modifiers changed from: private */
    public int mHorizontalAlign = 2;
    /* access modifiers changed from: private */
    public float mHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mHorizontalGap = 0;
    /* access modifiers changed from: private */
    public int mHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    /* access modifiers changed from: private */
    public int mVerticalAlign = 2;
    /* access modifiers changed from: private */
    public float mVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mVerticalGap = 0;
    /* access modifiers changed from: private */
    public int mVerticalStyle = -1;
    private int mWrapMode = 0;

    public class WidgetsList {

        /* renamed from: a  reason: collision with root package name */
        public int f10794a = 0;
        /* access modifiers changed from: private */
        public ConstraintWidget biggest = null;
        private ConstraintAnchor mBottom;
        private int mCount = 0;
        private int mHeight = 0;
        private ConstraintAnchor mLeft;
        private int mMax = 0;
        private int mNbMatchConstraintsWidgets = 0;
        private int mOrientation;
        private int mPaddingBottom = 0;
        private int mPaddingLeft = 0;
        private int mPaddingRight = 0;
        private int mPaddingTop = 0;
        private ConstraintAnchor mRight;
        private int mStartIndex = 0;
        private ConstraintAnchor mTop;
        private int mWidth = 0;

        public WidgetsList(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12) {
            this.mOrientation = i11;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i12;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.f10794a = 0;
            int i11 = this.mCount;
            int i12 = 0;
            while (i12 < i11 && this.mStartIndex + i12 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i12];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int h11 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        h11 = 0;
                    }
                    this.mWidth += width + h11;
                    int u11 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.f10794a < u11) {
                        this.biggest = constraintWidget;
                        this.f10794a = u11;
                        this.mHeight = u11;
                    }
                } else {
                    int t11 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int u12 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i13 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i13 = 0;
                    }
                    this.mHeight += u12 + i13;
                    if (this.biggest == null || this.f10794a < t11) {
                        this.biggest = constraintWidget;
                        this.f10794a = t11;
                        this.mWidth = t11;
                    }
                }
                i12++;
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i11 = 0;
            if (this.mOrientation == 0) {
                int t11 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    t11 = 0;
                }
                int h11 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i11 = h11;
                }
                this.mWidth += t11 + i11;
                int u11 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.f10794a < u11) {
                    this.biggest = constraintWidget;
                    this.f10794a = u11;
                    this.mHeight = u11;
                }
            } else {
                int t12 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int u12 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    u12 = 0;
                }
                int i12 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i11 = i12;
                }
                this.mHeight += u12 + i11;
                if (this.biggest == null || this.f10794a < t12) {
                    this.biggest = constraintWidget;
                    this.f10794a = t12;
                    this.mWidth = t12;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.f10794a = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createConstraints(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.mCount
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.mStartIndex
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r5 = r5.mDisplayedWidgetsCount
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.Flow r4 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.mDisplayedWidgets
                int r5 = r0.mStartIndex
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.resetAnchors()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0384
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.biggest
                if (r3 != 0) goto L_0x002f
                goto L_0x0384
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0069
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.mStartIndex
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x004f
                goto L_0x0069
            L_0x004f:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r9
                r9 = r10[r11]
                if (r9 == 0) goto L_0x0066
                int r9 = r9.getVisibility()
                if (r9 != 0) goto L_0x0066
                if (r7 != r5) goto L_0x0065
                r7 = r6
            L_0x0065:
                r8 = r6
            L_0x0066:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0069:
                int r6 = r0.mOrientation
                r9 = 0
                if (r6 != 0) goto L_0x020e
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.biggest
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mVerticalStyle
                r6.setVerticalChainStyle(r10)
                int r10 = r0.mPaddingTop
                if (r18 <= 0) goto L_0x0084
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mVerticalGap
                int r10 = r10 + r11
            L_0x0084:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mTop
                r11.connect(r12, r10)
                if (r19 == 0) goto L_0x0096
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
                int r12 = r0.mPaddingBottom
                r10.connect(r11, r12)
            L_0x0096:
                if (r18 <= 0) goto L_0x00a3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r10.connect(r11, r2)
            L_0x00a3:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mVerticalAlign
                r11 = 3
                if (r10 != r11) goto L_0x00dd
                boolean r10 = r6.hasBaseline()
                if (r10 != 0) goto L_0x00dd
                r10 = r2
            L_0x00b3:
                if (r10 >= r1) goto L_0x00dd
                if (r17 == 0) goto L_0x00bb
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00bc
            L_0x00bb:
                r12 = r10
            L_0x00bc:
                int r13 = r0.mStartIndex
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r14.mDisplayedWidgetsCount
                if (r13 < r14) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.mDisplayedWidgets
                int r14 = r0.mStartIndex
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.hasBaseline()
                if (r13 == 0) goto L_0x00da
                goto L_0x00de
            L_0x00da:
                int r10 = r10 + 1
                goto L_0x00b3
            L_0x00dd:
                r12 = r6
            L_0x00de:
                r10 = r2
            L_0x00df:
                if (r10 >= r1) goto L_0x0384
                if (r17 == 0) goto L_0x00e7
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e8
            L_0x00e7:
                r13 = r10
            L_0x00e8:
                int r14 = r0.mStartIndex
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mDisplayedWidgetsCount
                if (r14 < r15) goto L_0x00f5
                goto L_0x0384
            L_0x00f5:
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.mDisplayedWidgets
                int r15 = r0.mStartIndex
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r14 != 0) goto L_0x0106
                r14 = r9
                r9 = r11
                goto L_0x0208
            L_0x0106:
                if (r10 != 0) goto L_0x0111
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mLeft
                int r3 = r0.mPaddingLeft
                r14.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r15, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (int) r3)
            L_0x0111:
                if (r13 != 0) goto L_0x016f
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mHorizontalStyle
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mHorizontalBias
                if (r17 == 0) goto L_0x0125
                float r13 = r11 - r13
            L_0x0125:
                int r15 = r0.mStartIndex
                if (r15 != 0) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mFirstHorizontalStyle
                if (r15 == r5) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mFirstHorizontalStyle
                if (r17 == 0) goto L_0x0141
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mFirstHorizontalBias
            L_0x013f:
                float r11 = r11 - r13
                goto L_0x0147
            L_0x0141:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.mFirstHorizontalBias
            L_0x0147:
                r13 = r11
                goto L_0x0169
            L_0x0149:
                if (r19 == 0) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mLastHorizontalStyle
                if (r15 == r5) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mLastHorizontalStyle
                if (r17 == 0) goto L_0x0162
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mLastHorizontalBias
                goto L_0x013f
            L_0x0162:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.mLastHorizontalBias
                goto L_0x0147
            L_0x0169:
                r14.setHorizontalChainStyle(r3)
                r14.setHorizontalBiasPercent(r13)
            L_0x016f:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x017c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r14.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r3, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (int) r13)
            L_0x017c:
                if (r9 == 0) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.mRight
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mHorizontalGap
                r3.connect(r11, r13)
                if (r10 != r7) goto L_0x0194
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mLeft
                int r11 = r0.mPaddingLeft
                r3.setGoneMargin(r11)
            L_0x0194:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.mLeft
                r3.connect(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.mRight
                int r9 = r0.mPaddingRight
                r3.setGoneMargin(r9)
            L_0x01a7:
                if (r14 == r6) goto L_0x0207
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                r9 = 3
                if (r3 != r9) goto L_0x01c8
                boolean r3 = r12.hasBaseline()
                if (r3 == 0) goto L_0x01c8
                if (r14 == r12) goto L_0x01c8
                boolean r3 = r14.hasBaseline()
                if (r3 == 0) goto L_0x01c8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBaseline
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.mBaseline
                r3.connect(r11, r2)
                goto L_0x0208
            L_0x01c8:
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                if (r3 == 0) goto L_0x01ff
                r11 = 1
                if (r3 == r11) goto L_0x01f7
                if (r4 == 0) goto L_0x01e8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mTop
                int r13 = r0.mPaddingTop
                r3.connect(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r3.connect(r11, r13)
                goto L_0x0208
            L_0x01e8:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x0208
            L_0x01f7:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x0208
            L_0x01ff:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                goto L_0x0208
            L_0x0207:
                r9 = 3
            L_0x0208:
                int r10 = r10 + 1
                r11 = r9
                r9 = r14
                goto L_0x00df
            L_0x020e:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.biggest
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r6.mHorizontalStyle
                r3.setHorizontalChainStyle(r6)
                int r6 = r0.mPaddingLeft
                if (r18 <= 0) goto L_0x0224
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mHorizontalGap
                int r6 = r6 + r10
            L_0x0224:
                if (r17 == 0) goto L_0x0246
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                r10.connect(r11, r6)
                if (r19 == 0) goto L_0x0238
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mLeft
                int r11 = r0.mPaddingRight
                r6.connect(r10, r11)
            L_0x0238:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mRight
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mRight
                r6.connect(r10, r2)
                goto L_0x0265
            L_0x0246:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mLeft
                r10.connect(r11, r6)
                if (r19 == 0) goto L_0x0258
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mRight
                int r11 = r0.mPaddingRight
                r6.connect(r10, r11)
            L_0x0258:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mLeft
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mLeft
                r6.connect(r10, r2)
            L_0x0265:
                r6 = r2
            L_0x0266:
                if (r6 >= r1) goto L_0x0384
                int r10 = r0.mStartIndex
                int r10 = r10 + r6
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x0275
                goto L_0x0384
            L_0x0275:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r6
                r10 = r10[r11]
                if (r10 != 0) goto L_0x0285
                r12 = 1
                goto L_0x0380
            L_0x0285:
                if (r6 != 0) goto L_0x02d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mTop
                int r13 = r0.mPaddingTop
                r10.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r12, (int) r13)
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mVerticalBias
                int r13 = r0.mStartIndex
                if (r13 != 0) goto L_0x02b5
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mFirstVerticalStyle
                if (r13 == r5) goto L_0x02b5
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mFirstVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mFirstVerticalBias
                goto L_0x02cb
            L_0x02b5:
                if (r19 == 0) goto L_0x02cb
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mLastVerticalStyle
                if (r13 == r5) goto L_0x02cb
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mLastVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mLastVerticalBias
            L_0x02cb:
                r10.setVerticalChainStyle(r11)
                r10.setVerticalBiasPercent(r12)
            L_0x02d1:
                int r11 = r1 + -1
                if (r6 != r11) goto L_0x02de
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r10.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r12, (int) r13)
            L_0x02de:
                if (r9 == 0) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r9.mBottom
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mVerticalGap
                r11.connect(r12, r13)
                if (r6 != r7) goto L_0x02f6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                int r12 = r0.mPaddingTop
                r11.setGoneMargin(r12)
            L_0x02f6:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.mTop
                r11.connect(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r6 != r12) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mBottom
                int r11 = r0.mPaddingBottom
                r9.setGoneMargin(r11)
            L_0x0309:
                if (r10 == r3) goto L_0x037e
                r9 = 2
                if (r17 == 0) goto L_0x033b
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x0333
                r12 = 1
                if (r11 == r12) goto L_0x032b
                if (r11 == r9) goto L_0x031c
                goto L_0x037e
            L_0x031c:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x037e
            L_0x032b:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                goto L_0x037e
            L_0x0333:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x037e
            L_0x033b:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x0375
                r12 = 1
                if (r11 == r12) goto L_0x036d
                if (r11 == r9) goto L_0x0349
                goto L_0x037f
            L_0x0349:
                if (r4 == 0) goto L_0x035e
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mLeft
                int r13 = r0.mPaddingLeft
                r9.connect(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r9.connect(r11, r13)
                goto L_0x037f
            L_0x035e:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x037f
            L_0x036d:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x037f
            L_0x0375:
                r12 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                goto L_0x037f
            L_0x037e:
                r12 = 1
            L_0x037f:
                r9 = r10
            L_0x0380:
                int r6 = r6 + 1
                goto L_0x0266
            L_0x0384:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i11) {
            int i12 = this.mNbMatchConstraintsWidgets;
            if (i12 != 0) {
                int i13 = this.mCount;
                int i14 = i11 / i12;
                int i15 = 0;
                while (i15 < i13 && this.mStartIndex + i15 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i15];
                    if (this.mOrientation == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.e(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i14, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.e(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i14);
                    }
                    i15++;
                }
                recomputeDimensions();
            }
        }

        public void setStartIndex(int i11) {
            this.mStartIndex = i11;
        }

        public void setup(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12, int i13, int i14, int i15, int i16) {
            this.mOrientation = i11;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i12;
            this.mPaddingTop = i13;
            this.mPaddingRight = i14;
            this.mPaddingBottom = i15;
            this.mMax = i16;
        }
    }

    private void createAlignedConstraints(boolean z11) {
        ConstraintWidget constraintWidget;
        float f11;
        int i11;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i12 = 0; i12 < this.mDisplayedWidgetsCount; i12++) {
                this.mDisplayedWidgets[i12].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i13 = iArr[0];
            int i14 = iArr[1];
            float f12 = this.mHorizontalBias;
            ConstraintWidget constraintWidget2 = null;
            int i15 = 0;
            while (i15 < i13) {
                if (z11) {
                    i11 = (i13 - i15) - 1;
                    f11 = 1.0f - this.mHorizontalBias;
                } else {
                    f11 = f12;
                    i11 = i15;
                }
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i11];
                if (!(constraintWidget3 == null || constraintWidget3.getVisibility() == 8)) {
                    if (i15 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(f11);
                    }
                    if (i15 == i13 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i15 > 0 && constraintWidget2 != null) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i15++;
                f12 = f11;
            }
            for (int i16 = 0; i16 < i14; i16++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i16];
                if (!(constraintWidget4 == null || constraintWidget4.getVisibility() == 8)) {
                    if (i16 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i16 == i14 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i16 > 0 && constraintWidget2 != null) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i17 = 0; i17 < i13; i17++) {
                for (int i18 = 0; i18 < i14; i18++) {
                    int i19 = (i18 * i13) + i17;
                    if (this.mOrientation == 1) {
                        i19 = (i17 * i14) + i18;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                    if (!(i19 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i19]) == null || constraintWidget.getVisibility() == 8)) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i17];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i18];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i11));
                if (i13 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    e(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                }
                return i13;
            } else if (i12 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i12 == 3) {
                    return (int) ((((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    /* access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i11));
                if (i13 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    e(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i13;
            } else if (i12 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i12 == 3) {
                    return (int) ((((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e  */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0026
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0023
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.mHorizontalGap
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.getWidgetWidth(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = r0
            goto L_0x0047
        L_0x0026:
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0046
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002d:
            if (r2 >= r12) goto L_0x0046
            if (r2 <= 0) goto L_0x0034
            int r4 = r10.mVerticalGap
            int r3 = r3 + r4
        L_0x0034:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            int r4 = r10.getWidgetHeight(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r1 = r1 + 1
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0046:
            r2 = r0
        L_0x0047:
            int[] r3 = r10.mAlignedDimensions
            if (r3 != 0) goto L_0x0050
            r3 = 2
            int[] r3 = new int[r3]
            r10.mAlignedDimensions = r3
        L_0x0050:
            r3 = 1
            if (r1 != 0) goto L_0x0055
            if (r13 == r3) goto L_0x0059
        L_0x0055:
            if (r2 != 0) goto L_0x005b
            if (r13 != 0) goto L_0x005b
        L_0x0059:
            r4 = r3
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 != 0) goto L_0x011d
            if (r13 != 0) goto L_0x006a
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0073
        L_0x006a:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInCols
            r6 = 0
            if (r5 == 0) goto L_0x0080
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0084
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r10.mAlignedBiggestElementsInCols = r5
        L_0x0084:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInRows
            if (r5 == 0) goto L_0x0090
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0094
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r10.mAlignedBiggestElementsInRows = r5
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 >= r2) goto L_0x00d9
            r6 = r0
        L_0x0098:
            if (r6 >= r1) goto L_0x00d6
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a2
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a2:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            int r8 = r10.getWidgetWidth(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInCols
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00bb
            int r9 = r9.getWidth()
            if (r9 >= r8) goto L_0x00bf
        L_0x00bb:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInCols
            r8[r5] = r7
        L_0x00bf:
            int r8 = r10.getWidgetHeight(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInRows
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cf
            int r9 = r9.getHeight()
            if (r9 >= r8) goto L_0x00d3
        L_0x00cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8[r6] = r7
        L_0x00d3:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00d9:
            r5 = r0
            r6 = r5
        L_0x00db:
            if (r5 >= r2) goto L_0x00f0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r10.mAlignedBiggestElementsInCols
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00ed
            if (r5 <= 0) goto L_0x00e8
            int r8 = r10.mHorizontalGap
            int r6 = r6 + r8
        L_0x00e8:
            int r7 = r10.getWidgetWidth(r7, r14)
            int r6 = r6 + r7
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f0:
            r5 = r0
            r7 = r5
        L_0x00f2:
            if (r5 >= r1) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0104
            if (r5 <= 0) goto L_0x00ff
            int r9 = r10.mVerticalGap
            int r7 = r7 + r9
        L_0x00ff:
            int r8 = r10.getWidgetHeight(r8, r14)
            int r7 = r7 + r8
        L_0x0104:
            int r5 = r5 + 1
            goto L_0x00f2
        L_0x0107:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0115
            if (r6 <= r14) goto L_0x0059
            if (r2 <= r3) goto L_0x0059
            int r2 = r2 + -1
            goto L_0x005c
        L_0x0115:
            if (r7 <= r14) goto L_0x0059
            if (r1 <= r3) goto L_0x0059
            int r1 = r1 + -1
            goto L_0x005c
        L_0x011d:
            int[] r11 = r10.mAlignedDimensions
            r11[r0] = r2
            r11[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z11;
        ConstraintAnchor constraintAnchor;
        int i15;
        int i16;
        int i17;
        ConstraintAnchor constraintAnchor2;
        boolean z12;
        int i18;
        boolean z13;
        int i19;
        int i21 = i11;
        int i22 = i13;
        if (i21 != 0) {
            this.mChainList.clear();
            WidgetsList widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
            this.mChainList.add(widgetsList);
            if (i12 == 0) {
                i14 = 0;
                int i23 = 0;
                int i24 = 0;
                while (i24 < i21) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i24];
                    int widgetWidth = getWidgetWidth(constraintWidget, i22);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i25 = i14;
                    if ((i23 == i22 || this.mHorizontalGap + i23 + widgetWidth > i22) && widgetsList.biggest != null) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z13 && i24 > 0 && (i19 = this.mMaxElementsWrap) > 0 && i24 % i19 == 0) {
                        z13 = true;
                    }
                    if (z13) {
                        widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
                        widgetsList.setStartIndex(i24);
                        this.mChainList.add(widgetsList);
                    } else if (i24 > 0) {
                        i23 += this.mHorizontalGap + widgetWidth;
                        widgetsList.add(constraintWidget);
                        i24++;
                        i14 = i25;
                    }
                    i23 = widgetWidth;
                    widgetsList.add(constraintWidget);
                    i24++;
                    i14 = i25;
                }
            } else {
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                while (i28 < i21) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i28];
                    int widgetHeight = getWidgetHeight(constraintWidget2, i22);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i29 = i14;
                    if ((i27 == i22 || this.mVerticalGap + i27 + widgetHeight > i22) && widgetsList.biggest != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12 && i28 > 0 && (i18 = this.mMaxElementsWrap) > 0 && i28 % i18 == 0) {
                        z12 = true;
                    }
                    if (z12) {
                        widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
                        widgetsList.setStartIndex(i28);
                        this.mChainList.add(widgetsList);
                    } else if (i28 > 0) {
                        i27 += this.mVerticalGap + widgetHeight;
                        widgetsList.add(constraintWidget2);
                        i28++;
                        i26 = i29;
                    }
                    i27 = widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i28++;
                    i26 = i29;
                }
            }
            int size = this.mChainList.size();
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            ConstraintAnchor constraintAnchor5 = this.mRight;
            ConstraintAnchor constraintAnchor6 = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i14 > 0 && z11) {
                for (int i31 = 0; i31 < size; i31++) {
                    WidgetsList widgetsList2 = this.mChainList.get(i31);
                    if (i12 == 0) {
                        widgetsList2.measureMatchConstraints(i22 - widgetsList2.getWidth());
                    } else {
                        widgetsList2.measureMatchConstraints(i22 - widgetsList2.getHeight());
                    }
                }
            }
            int i32 = paddingTop;
            int i33 = paddingRight;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i38 = paddingBottom;
            while (i36 < size) {
                WidgetsList widgetsList3 = this.mChainList.get(i36);
                if (i12 == 0) {
                    if (i36 < size - 1) {
                        constraintAnchor2 = this.mChainList.get(i36 + 1).biggest.mTop;
                        i17 = 0;
                    } else {
                        constraintAnchor2 = this.mBottom;
                        i17 = getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i39 = i34;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i41 = i35;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i15 = i36;
                    widgetsList3.setup(i12, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i37, i32, i33, i17, i13);
                    int max = Math.max(i41, widgetsList3.getWidth());
                    i34 = i39 + widgetsList3.getHeight();
                    if (i15 > 0) {
                        i34 += this.mVerticalGap;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i35 = max;
                    i32 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i42 = i17;
                    constraintAnchor6 = constraintAnchor2;
                    i38 = i42;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i43 = i34;
                    int i44 = i35;
                    i15 = i36;
                    if (i15 < size - 1) {
                        constraintAnchor = this.mChainList.get(i15 + 1).biggest.mLeft;
                        i16 = 0;
                    } else {
                        constraintAnchor = this.mRight;
                        i16 = getPaddingRight();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                    widgetsList3.setup(i12, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i37, i32, i16, i38, i13);
                    i35 = i44 + widgetsList3.getWidth();
                    int max2 = Math.max(i43, widgetsList3.getHeight());
                    if (i15 > 0) {
                        i35 += this.mHorizontalGap;
                    }
                    i34 = max2;
                    i37 = 0;
                    i33 = i16;
                    constraintAnchor8 = constraintAnchor16;
                }
                i36 = i15 + 1;
                int i45 = i13;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i35;
            iArr[1] = i34;
        }
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z11;
        ConstraintAnchor constraintAnchor;
        int i15;
        int i16;
        int i17;
        ConstraintAnchor constraintAnchor2;
        boolean z12;
        int i18;
        boolean z13;
        int i19;
        int i21 = i11;
        int i22 = i13;
        if (i21 != 0) {
            this.mChainList.clear();
            WidgetsList widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
            this.mChainList.add(widgetsList);
            if (i12 == 0) {
                int i23 = 0;
                i14 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i25 < i21) {
                    int i26 = i23 + 1;
                    ConstraintWidget constraintWidget = constraintWidgetArr[i25];
                    int widgetWidth = getWidgetWidth(constraintWidget, i22);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i27 = i14;
                    if ((i24 == i22 || this.mHorizontalGap + i24 + widgetWidth > i22) && widgetsList.biggest != null) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z13 && i25 > 0 && (i19 = this.mMaxElementsWrap) > 0 && i26 > i19) {
                        z13 = true;
                    }
                    if (z13) {
                        widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
                        widgetsList.setStartIndex(i25);
                        this.mChainList.add(widgetsList);
                        i23 = i26;
                        i24 = widgetWidth;
                    } else {
                        if (i25 > 0) {
                            i24 += this.mHorizontalGap + widgetWidth;
                        } else {
                            i24 = widgetWidth;
                        }
                        i23 = 0;
                    }
                    widgetsList.add(constraintWidget);
                    i25++;
                    i14 = i27;
                }
            } else {
                int i28 = 0;
                int i29 = 0;
                int i31 = 0;
                while (i31 < i21) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i31];
                    int widgetHeight = getWidgetHeight(constraintWidget2, i22);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i32 = i14;
                    if ((i28 == i22 || this.mVerticalGap + i28 + widgetHeight > i22) && widgetsList.biggest != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12 && i31 > 0 && (i18 = this.mMaxElementsWrap) > 0 && i18 < 0) {
                        z12 = true;
                    }
                    if (z12) {
                        widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
                        widgetsList.setStartIndex(i31);
                        this.mChainList.add(widgetsList);
                    } else if (i31 > 0) {
                        i28 += this.mVerticalGap + widgetHeight;
                        widgetsList.add(constraintWidget2);
                        i31++;
                        i29 = i32;
                    }
                    i28 = widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i31++;
                    i29 = i32;
                }
            }
            int size = this.mChainList.size();
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            ConstraintAnchor constraintAnchor5 = this.mRight;
            ConstraintAnchor constraintAnchor6 = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i14 > 0 && z11) {
                for (int i33 = 0; i33 < size; i33++) {
                    WidgetsList widgetsList2 = this.mChainList.get(i33);
                    if (i12 == 0) {
                        widgetsList2.measureMatchConstraints(i22 - widgetsList2.getWidth());
                    } else {
                        widgetsList2.measureMatchConstraints(i22 - widgetsList2.getHeight());
                    }
                }
            }
            int i34 = paddingTop;
            int i35 = paddingRight;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i41 = paddingBottom;
            while (i38 < size) {
                WidgetsList widgetsList3 = this.mChainList.get(i38);
                if (i12 == 0) {
                    if (i38 < size - 1) {
                        constraintAnchor2 = this.mChainList.get(i38 + 1).biggest.mTop;
                        i17 = 0;
                    } else {
                        constraintAnchor2 = this.mBottom;
                        i17 = getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i42 = i36;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i43 = i37;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i15 = i38;
                    widgetsList3.setup(i12, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i39, i34, i35, i17, i13);
                    int max = Math.max(i43, widgetsList3.getWidth());
                    i36 = i42 + widgetsList3.getHeight();
                    if (i15 > 0) {
                        i36 += this.mVerticalGap;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i37 = max;
                    i34 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i44 = i17;
                    constraintAnchor6 = constraintAnchor2;
                    i41 = i44;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i45 = i36;
                    int i46 = i37;
                    i15 = i38;
                    if (i15 < size - 1) {
                        constraintAnchor = this.mChainList.get(i15 + 1).biggest.mLeft;
                        i16 = 0;
                    } else {
                        constraintAnchor = this.mRight;
                        i16 = getPaddingRight();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                    widgetsList3.setup(i12, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i39, i34, i16, i41, i13);
                    i37 = i46 + widgetsList3.getWidth();
                    int max2 = Math.max(i45, widgetsList3.getHeight());
                    if (i15 > 0) {
                        i37 += this.mHorizontalGap;
                    }
                    i36 = max2;
                    i39 = 0;
                    i35 = i16;
                    constraintAnchor8 = constraintAnchor16;
                }
                i38 = i15 + 1;
                int i47 = i13;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i37;
            iArr[1] = i36;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        WidgetsList widgetsList;
        int i14 = i11;
        if (i14 != 0) {
            if (this.mChainList.size() == 0) {
                widgetsList = new WidgetsList(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, i13);
                this.mChainList.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = this.mChainList.get(0);
                widgetsList2.clear();
                widgetsList = widgetsList2;
                widgetsList.setup(i12, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i13);
            }
            for (int i15 = 0; i15 < i14; i15++) {
                widgetsList.add(constraintWidgetArr[i15]);
            }
            iArr[0] = widgetsList.getWidth();
            iArr[1] = widgetsList.getHeight();
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean z11) {
        boolean z12;
        boolean z13;
        boolean z14;
        super.addToSolver(linearSystem, z11);
        if (getParent() == null || !((ConstraintWidgetContainer) getParent()).isRtl()) {
            z12 = false;
        } else {
            z12 = true;
        }
        int i11 = this.mWrapMode;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = this.mChainList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    WidgetsList widgetsList = this.mChainList.get(i12);
                    if (i12 == size - 1) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    widgetsList.createConstraints(z12, i12, z13);
                }
            } else if (i11 == 2) {
                createAlignedConstraints(z12);
            } else if (i11 == 3) {
                int size2 = this.mChainList.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    WidgetsList widgetsList2 = this.mChainList.get(i13);
                    if (i13 == size2 - 1) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    widgetsList2.createConstraints(z12, i13, z14);
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z12, 0, true);
        }
        g(false);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return (float) this.mMaxElementsWrap;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measure(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.mWidgetsCount
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.f()
            if (r0 != 0) goto L_0x001c
            r6.setMeasure(r11, r11)
            r6.g(r11)
            return
        L_0x001c:
            int r12 = r18.getPaddingLeft()
            int r13 = r18.getPaddingRight()
            int r14 = r18.getPaddingTop()
            int r15 = r18.getPaddingBottom()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.mOrientation
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.mHorizontalStyle
            if (r2 != r1) goto L_0x0045
            r6.mHorizontalStyle = r11
        L_0x0045:
            int r2 = r6.mVerticalStyle
            if (r2 != r1) goto L_0x0058
            r6.mVerticalStyle = r11
            goto L_0x0058
        L_0x004c:
            int r2 = r6.mHorizontalStyle
            if (r2 != r1) goto L_0x0052
            r6.mHorizontalStyle = r11
        L_0x0052:
            int r2 = r6.mVerticalStyle
            if (r2 != r1) goto L_0x0058
            r6.mVerticalStyle = r11
        L_0x0058:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r6.mWidgets
            r2 = r11
            r3 = r2
        L_0x005c:
            int r11 = r6.mWidgetsCount
            r0 = 8
            if (r2 >= r11) goto L_0x0072
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.mWidgets
            r11 = r11[r2]
            int r11 = r11.getVisibility()
            if (r11 != r0) goto L_0x006e
            int r3 = r3 + 1
        L_0x006e:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005c
        L_0x0072:
            if (r3 <= 0) goto L_0x0091
            int r11 = r11 - r3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0079:
            int r11 = r6.mWidgetsCount
            if (r2 >= r11) goto L_0x008f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.mWidgets
            r11 = r11[r2]
            int r4 = r11.getVisibility()
            if (r4 == r0) goto L_0x008b
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008b:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0079
        L_0x008f:
            r2 = r3
            goto L_0x0092
        L_0x0091:
            r2 = r11
        L_0x0092:
            r6.mDisplayedWidgets = r1
            r6.mDisplayedWidgetsCount = r2
            int r0 = r6.mWrapMode
            if (r0 == 0) goto L_0x00cf
            r4 = 1
            if (r0 == r4) goto L_0x00c2
            r3 = 2
            if (r0 == r3) goto L_0x00b5
            r3 = 3
            if (r0 == r3) goto L_0x00a8
            r11 = r4
            r17 = r5
        L_0x00a6:
            r0 = 0
            goto L_0x00dc
        L_0x00a8:
            int r3 = r6.mOrientation
            r0 = r18
            r11 = r4
            r4 = r16
            r17 = r5
            r0.measureChainWrap_new(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00b5:
            r11 = r4
            r17 = r5
            int r3 = r6.mOrientation
            r0 = r18
            r4 = r16
            r0.measureAligned(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00c2:
            r11 = r4
            r17 = r5
            int r3 = r6.mOrientation
            r0 = r18
            r4 = r16
            r0.measureChainWrap(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00cf:
            r17 = r5
            r11 = 1
            int r3 = r6.mOrientation
            r0 = r18
            r4 = r16
            r0.measureNoWrap(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00dc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00ec
            r1 = r8
            goto L_0x00f7
        L_0x00ec:
            if (r7 != r3) goto L_0x00f3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00f7
        L_0x00f3:
            if (r7 != 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r1 = r0
        L_0x00f7:
            if (r9 != r4) goto L_0x00fb
            r2 = r10
            goto L_0x0106
        L_0x00fb:
            if (r9 != r3) goto L_0x0102
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x0106
        L_0x0102:
            if (r9 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r2 = r0
        L_0x0106:
            r6.setMeasure(r1, r2)
            r6.setWidth(r1)
            r6.setHeight(r2)
            int r1 = r6.mWidgetsCount
            if (r1 <= 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r11 = r0
        L_0x0115:
            r6.g(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measure(int, int, int, int):void");
    }

    public void setFirstHorizontalBias(float f11) {
        this.mFirstHorizontalBias = f11;
    }

    public void setFirstHorizontalStyle(int i11) {
        this.mFirstHorizontalStyle = i11;
    }

    public void setFirstVerticalBias(float f11) {
        this.mFirstVerticalBias = f11;
    }

    public void setFirstVerticalStyle(int i11) {
        this.mFirstVerticalStyle = i11;
    }

    public void setHorizontalAlign(int i11) {
        this.mHorizontalAlign = i11;
    }

    public void setHorizontalBias(float f11) {
        this.mHorizontalBias = f11;
    }

    public void setHorizontalGap(int i11) {
        this.mHorizontalGap = i11;
    }

    public void setHorizontalStyle(int i11) {
        this.mHorizontalStyle = i11;
    }

    public void setLastHorizontalBias(float f11) {
        this.mLastHorizontalBias = f11;
    }

    public void setLastHorizontalStyle(int i11) {
        this.mLastHorizontalStyle = i11;
    }

    public void setLastVerticalBias(float f11) {
        this.mLastVerticalBias = f11;
    }

    public void setLastVerticalStyle(int i11) {
        this.mLastVerticalStyle = i11;
    }

    public void setMaxElementsWrap(int i11) {
        this.mMaxElementsWrap = i11;
    }

    public void setOrientation(int i11) {
        this.mOrientation = i11;
    }

    public void setVerticalAlign(int i11) {
        this.mVerticalAlign = i11;
    }

    public void setVerticalBias(float f11) {
        this.mVerticalBias = f11;
    }

    public void setVerticalGap(int i11) {
        this.mVerticalGap = i11;
    }

    public void setVerticalStyle(int i11) {
        this.mVerticalStyle = i11;
    }

    public void setWrapMode(int i11) {
        this.mWrapMode = i11;
    }
}
