package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Optimizer {
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f10797a = new boolean[3];

    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.mHorizontalResolution = -1;
        constraintWidget.mVerticalResolution = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            constraintAnchor.f10764b = linearSystem.createObjectVariable(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
            constraintAnchor2.f10764b = linearSystem.createObjectVariable(constraintAnchor2);
            linearSystem.addEquality(constraintWidget.mLeft.f10764b, i11);
            linearSystem.addEquality(constraintWidget.mRight.f10764b, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i11, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != dimensionBehaviour2 && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i12 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            constraintAnchor3.f10764b = linearSystem.createObjectVariable(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.mBottom;
            constraintAnchor4.f10764b = linearSystem.createObjectVariable(constraintAnchor4);
            linearSystem.addEquality(constraintWidget.mTop.f10764b, i12);
            linearSystem.addEquality(constraintWidget.mBottom.f10764b, height);
            if (constraintWidget.f10781p > 0 || constraintWidget.getVisibility() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.mBaseline;
                constraintAnchor5.f10764b = linearSystem.createObjectVariable(constraintAnchor5);
                linearSystem.addEquality(constraintWidget.mBaseline.f10764b, constraintWidget.f10781p + i12);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i12, height);
        }
    }

    public static final boolean enabled(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
