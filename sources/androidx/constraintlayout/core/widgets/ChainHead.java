package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f10744a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintWidget f10745b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintWidget f10746c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintWidget f10747d;

    /* renamed from: e  reason: collision with root package name */
    public ConstraintWidget f10748e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintWidget f10749f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintWidget f10750g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ConstraintWidget> f10751h;

    /* renamed from: i  reason: collision with root package name */
    public int f10752i;

    /* renamed from: j  reason: collision with root package name */
    public int f10753j;

    /* renamed from: k  reason: collision with root package name */
    public float f10754k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public int f10755l;

    /* renamed from: m  reason: collision with root package name */
    public int f10756m;
    private boolean mDefined;
    private boolean mIsRtl;
    private int mOrientation;

    /* renamed from: n  reason: collision with root package name */
    public int f10757n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f10758o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f10759p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f10760q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f10761r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f10762s;

    public ChainHead(ConstraintWidget constraintWidget, int i11, boolean z11) {
        this.f10744a = constraintWidget;
        this.mOrientation = i11;
        this.mIsRtl = z11;
    }

    private void defineChainProperties() {
        int i11 = this.mOrientation * 2;
        ConstraintWidget constraintWidget = this.f10744a;
        boolean z11 = true;
        this.f10758o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z12 = false;
        while (!z12) {
            this.f10752i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.K;
            int i12 = this.mOrientation;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i12] = null;
            constraintWidget.J[i12] = null;
            if (constraintWidget.getVisibility() != 8) {
                this.f10755l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(this.mOrientation);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour2) {
                    this.f10756m += constraintWidget.getLength(this.mOrientation);
                }
                int margin = this.f10756m + constraintWidget.mListAnchors[i11].getMargin();
                this.f10756m = margin;
                int i13 = i11 + 1;
                this.f10756m = margin + constraintWidget.mListAnchors[i13].getMargin();
                int margin2 = this.f10757n + constraintWidget.mListAnchors[i11].getMargin();
                this.f10757n = margin2;
                this.f10757n = margin2 + constraintWidget.mListAnchors[i13].getMargin();
                if (this.f10745b == null) {
                    this.f10745b = constraintWidget;
                }
                this.f10747d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                int i14 = this.mOrientation;
                if (dimensionBehaviourArr[i14] == dimensionBehaviour2) {
                    int i15 = constraintWidget.mResolvedMatchConstraintDefault[i14];
                    if (i15 == 0 || i15 == 3 || i15 == 2) {
                        this.f10753j++;
                        float f11 = constraintWidget.mWeight[i14];
                        if (f11 > 0.0f) {
                            this.f10754k += f11;
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget, i14)) {
                            if (f11 < 0.0f) {
                                this.f10759p = true;
                            } else {
                                this.f10760q = true;
                            }
                            if (this.f10751h == null) {
                                this.f10751h = new ArrayList<>();
                            }
                            this.f10751h.add(constraintWidget);
                        }
                        if (this.f10749f == null) {
                            this.f10749f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f10750g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.J[this.mOrientation] = constraintWidget;
                        }
                        this.f10750g = constraintWidget;
                    }
                    if (this.mOrientation == 0) {
                        if (constraintWidget.mMatchConstraintDefaultWidth != 0) {
                            this.f10758o = false;
                        } else if (!(constraintWidget.mMatchConstraintMinWidth == 0 && constraintWidget.mMatchConstraintMaxWidth == 0)) {
                            this.f10758o = false;
                        }
                    } else if (constraintWidget.mMatchConstraintDefaultHeight != 0) {
                        this.f10758o = false;
                    } else if (!(constraintWidget.mMatchConstraintMinHeight == 0 && constraintWidget.mMatchConstraintMaxHeight == 0)) {
                        this.f10758o = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.f10758o = false;
                        this.f10762s = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.K[this.mOrientation] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i11 + 1].mTarget;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.mListAnchors[i11].mTarget;
                if (constraintAnchor2 != null && constraintAnchor2.mOwner == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z12 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f10745b;
        if (constraintWidget6 != null) {
            this.f10756m -= constraintWidget6.mListAnchors[i11].getMargin();
        }
        ConstraintWidget constraintWidget7 = this.f10747d;
        if (constraintWidget7 != null) {
            this.f10756m -= constraintWidget7.mListAnchors[i11 + 1].getMargin();
        }
        this.f10746c = constraintWidget;
        if (this.mOrientation != 0 || !this.mIsRtl) {
            this.f10748e = this.f10744a;
        } else {
            this.f10748e = constraintWidget;
        }
        if (!this.f10760q || !this.f10759p) {
            z11 = false;
        }
        this.f10761r = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = r2.mResolvedMatchConstraintDefault[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isMatchConstraintEqualityCandidate(androidx.constraintlayout.core.widgets.ConstraintWidget r2, int r3) {
        /*
            int r0 = r2.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r2.mListDimensionBehaviors
            r0 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001b
            int[] r2 = r2.mResolvedMatchConstraintDefault
            r2 = r2[r3]
            if (r2 == 0) goto L_0x0019
            r3 = 3
            if (r2 != r3) goto L_0x001b
        L_0x0019:
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ChainHead.isMatchConstraintEqualityCandidate(androidx.constraintlayout.core.widgets.ConstraintWidget, int):boolean");
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.f10744a;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.f10749f;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.f10745b;
    }

    public ConstraintWidget getHead() {
        return this.f10748e;
    }

    public ConstraintWidget getLast() {
        return this.f10746c;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.f10750g;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.f10747d;
    }

    public float getTotalWeight() {
        return this.f10754k;
    }
}
