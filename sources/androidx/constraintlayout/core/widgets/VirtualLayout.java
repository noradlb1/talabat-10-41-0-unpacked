package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

public class VirtualLayout extends HelperWidget {
    public BasicMeasure.Measure N = new BasicMeasure.Measure();
    public BasicMeasure.Measurer O = null;
    private int mMeasuredHeight = 0;
    private int mMeasuredWidth = 0;
    private boolean mNeedsCallFromSolver = false;
    private int mPaddingBottom = 0;
    private int mPaddingEnd = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingTop = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;

    public void applyRtl(boolean z11) {
        int i11 = this.mPaddingStart;
        if (i11 <= 0 && this.mPaddingEnd <= 0) {
            return;
        }
        if (z11) {
            this.mResolvedPaddingLeft = this.mPaddingEnd;
            this.mResolvedPaddingRight = i11;
            return;
        }
        this.mResolvedPaddingLeft = i11;
        this.mResolvedPaddingRight = this.mPaddingEnd;
    }

    public void captureWidgets() {
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            if (hashSet.contains(this.mWidgets[i11])) {
                return true;
            }
        }
        return false;
    }

    public void e(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        while (this.O == null && getParent() != null) {
            this.O = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        BasicMeasure.Measure measure = this.N;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i11;
        measure.verticalDimension = i12;
        this.O.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.N.measuredWidth);
        constraintWidget.setHeight(this.N.measuredHeight);
        constraintWidget.setHasBaseline(this.N.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.N.measuredBaseline);
    }

    public boolean f() {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null) {
            measurer = ((ConstraintWidgetContainer) constraintWidget).getMeasurer();
        } else {
            measurer = null;
        }
        if (measurer == null) {
            return false;
        }
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.mWidgets[i11];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                    z11 = false;
                }
                if (!z11) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.N;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.N.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.N);
                    constraintWidget2.setWidth(this.N.measuredWidth);
                    constraintWidget2.setHeight(this.N.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.N.measuredBaseline);
                }
            }
            i11++;
        }
    }

    public void g(boolean z11) {
        this.mNeedsCallFromSolver = z11;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int i11, int i12, int i13, int i14) {
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    public void setMeasure(int i11, int i12) {
        this.mMeasuredWidth = i11;
        this.mMeasuredHeight = i12;
    }

    public void setPadding(int i11) {
        this.mPaddingLeft = i11;
        this.mPaddingTop = i11;
        this.mPaddingRight = i11;
        this.mPaddingBottom = i11;
        this.mPaddingStart = i11;
        this.mPaddingEnd = i11;
    }

    public void setPaddingBottom(int i11) {
        this.mPaddingBottom = i11;
    }

    public void setPaddingEnd(int i11) {
        this.mPaddingEnd = i11;
    }

    public void setPaddingLeft(int i11) {
        this.mPaddingLeft = i11;
        this.mResolvedPaddingLeft = i11;
    }

    public void setPaddingRight(int i11) {
        this.mPaddingRight = i11;
        this.mResolvedPaddingRight = i11;
    }

    public void setPaddingStart(int i11) {
        this.mPaddingStart = i11;
        this.mResolvedPaddingLeft = i11;
        this.mResolvedPaddingRight = i11;
    }

    public void setPaddingTop(int i11) {
        this.mPaddingTop = i11;
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
