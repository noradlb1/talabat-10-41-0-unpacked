package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    public boolean N = false;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;

    public Barrier() {
    }

    public void addToSolver(LinearSystem linearSystem, boolean z11) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i16 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i16 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i16];
            constraintAnchor.f10764b = linearSystem.createObjectVariable(constraintAnchor);
            i16++;
        }
        int i17 = this.mBarrierType;
        if (i17 >= 0 && i17 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i17];
            if (!this.N) {
                allSolved();
            }
            if (this.N) {
                this.N = false;
                int i18 = this.mBarrierType;
                if (i18 == 0 || i18 == 1) {
                    linearSystem.addEquality(this.mLeft.f10764b, this.f10775j);
                    linearSystem.addEquality(this.mRight.f10764b, this.f10775j);
                } else if (i18 == 2 || i18 == 3) {
                    linearSystem.addEquality(this.mTop.f10764b, this.f10776k);
                    linearSystem.addEquality(this.mBottom.f10764b, this.f10776k);
                }
            } else {
                int i19 = 0;
                while (true) {
                    if (i19 >= this.mWidgetsCount) {
                        z12 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.mWidgets[i19];
                    if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i14 = this.mBarrierType) == 0 || i14 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i15 = this.mBarrierType) == 2 || i15 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                        z12 = true;
                    } else {
                        i19++;
                    }
                }
                z12 = true;
                if (this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents()) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z12 || (((i13 = this.mBarrierType) != 0 || !z13) && ((i13 != 2 || !z14) && ((i13 != 1 || !z13) && (i13 != 3 || !z14))))) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                if (!z15) {
                    i11 = 4;
                } else {
                    i11 = 5;
                }
                for (int i21 = 0; i21 < this.mWidgetsCount; i21++) {
                    ConstraintWidget constraintWidget2 = this.mWidgets[i21];
                    if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                        int i22 = this.mBarrierType;
                        ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i22];
                        constraintAnchor3.f10764b = createObjectVariable;
                        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                        if (constraintAnchor4 == null || constraintAnchor4.mOwner != this) {
                            i12 = 0;
                        } else {
                            i12 = constraintAnchor3.mMargin + 0;
                        }
                        if (i22 == 0 || i22 == 2) {
                            linearSystem.addLowerBarrier(constraintAnchor2.f10764b, createObjectVariable, this.mMargin - i12, z12);
                        } else {
                            linearSystem.addGreaterBarrier(constraintAnchor2.f10764b, createObjectVariable, this.mMargin + i12, z12);
                        }
                        linearSystem.addEquality(constraintAnchor2.f10764b, createObjectVariable, this.mMargin + i12, i11);
                    }
                }
                int i23 = this.mBarrierType;
                if (i23 == 0) {
                    linearSystem.addEquality(this.mRight.f10764b, this.mLeft.f10764b, 0, 8);
                    linearSystem.addEquality(this.mLeft.f10764b, this.mParent.mRight.f10764b, 0, 4);
                    linearSystem.addEquality(this.mLeft.f10764b, this.mParent.mLeft.f10764b, 0, 0);
                } else if (i23 == 1) {
                    linearSystem.addEquality(this.mLeft.f10764b, this.mRight.f10764b, 0, 8);
                    linearSystem.addEquality(this.mLeft.f10764b, this.mParent.mLeft.f10764b, 0, 4);
                    linearSystem.addEquality(this.mLeft.f10764b, this.mParent.mRight.f10764b, 0, 0);
                } else if (i23 == 2) {
                    linearSystem.addEquality(this.mBottom.f10764b, this.mTop.f10764b, 0, 8);
                    linearSystem.addEquality(this.mTop.f10764b, this.mParent.mBottom.f10764b, 0, 4);
                    linearSystem.addEquality(this.mTop.f10764b, this.mParent.mTop.f10764b, 0, 0);
                } else if (i23 == 3) {
                    linearSystem.addEquality(this.mTop.f10764b, this.mBottom.f10764b, 0, 8);
                    linearSystem.addEquality(this.mTop.f10764b, this.mParent.mTop.f10764b, 0, 4);
                    linearSystem.addEquality(this.mTop.f10764b, this.mParent.mBottom.f10764b, 0, 0);
                }
            }
        }
    }

    public boolean allSolved() {
        int i11;
        int i12;
        int i13;
        boolean z11 = true;
        int i14 = 0;
        while (true) {
            i11 = this.mWidgetsCount;
            if (i14 >= i11) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i14];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i12 = this.mBarrierType) == 0 || i12 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i13 = this.mBarrierType) == 2 || i13 == 3) && !constraintWidget.isResolvedVertically()))) {
                z11 = false;
            }
            i14++;
        }
        if (!z11 || i11 <= 0) {
            return false;
        }
        int i15 = 0;
        boolean z12 = false;
        for (int i16 = 0; i16 < this.mWidgetsCount; i16++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i16];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z12) {
                    int i17 = this.mBarrierType;
                    if (i17 == 0) {
                        i15 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i17 == 1) {
                        i15 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i17 == 2) {
                        i15 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i17 == 3) {
                        i15 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z12 = true;
                }
                int i18 = this.mBarrierType;
                if (i18 == 0) {
                    i15 = Math.min(i15, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i18 == 1) {
                    i15 = Math.max(i15, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i18 == 2) {
                    i15 = Math.min(i15, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i18 == 3) {
                    i15 = Math.max(i15, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i19 = i15 + this.mMargin;
        int i21 = this.mBarrierType;
        if (i21 == 0 || i21 == 1) {
            setFinalHorizontal(i19, i19);
        } else {
            setFinalVertical(i19, i19);
        }
        this.N = true;
        return true;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public void e() {
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i12 = this.mBarrierType;
                if (i12 == 0 || i12 == 1) {
                    constraintWidget.d(0, true);
                } else if (i12 == 2 || i12 == 3) {
                    constraintWidget.d(1, true);
                }
            }
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i11 = this.mBarrierType;
        if (i11 == 0 || i11 == 1) {
            return 0;
        }
        return (i11 == 2 || i11 == 3) ? 1 : -1;
    }

    public boolean isResolvedHorizontally() {
        return this.N;
    }

    public boolean isResolvedVertically() {
        return this.N;
    }

    public void setAllowsGoneWidget(boolean z11) {
        this.mAllowsGoneWidget = z11;
    }

    public void setBarrierType(int i11) {
        this.mBarrierType = i11;
    }

    public void setMargin(int i11) {
        this.mMargin = i11;
    }

    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if (i11 > 0) {
                str = str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
