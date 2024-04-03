package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || constraintWidget.mDimensionRatio <= 0.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z12 || constraintWidget.mDimensionRatio <= 0.0f) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z13 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z14 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.mDimensionRatio <= 0.0f) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void measureChildren(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.mChildren
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.optimizeFor(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.getMeasurer()
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r0) goto L_0x00b0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.mChildren
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L_0x0022
            goto L_0x00ac
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L_0x0028
            goto L_0x00ac
        L_0x0028:
            boolean r6 = r5.isInVirtualLayout()
            if (r6 == 0) goto L_0x0030
            goto L_0x00ac
        L_0x0030:
            if (r1 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.horizontalRun
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.verticalRun
            if (r7 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f10834d
            boolean r6 = r6.resolved
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.f10834d
            boolean r6 = r6.resolved
            if (r6 == 0) goto L_0x0048
            goto L_0x00ac
        L_0x0048:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.getDimensionBehaviour(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.getDimensionBehaviour(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0061
            int r10 = r5.mMatchConstraintDefaultWidth
            if (r10 == r7) goto L_0x0061
            if (r8 != r9) goto L_0x0061
            int r10 = r5.mMatchConstraintDefaultHeight
            if (r10 == r7) goto L_0x0061
            r10 = r7
            goto L_0x0062
        L_0x0061:
            r10 = r3
        L_0x0062:
            if (r10 != 0) goto L_0x0098
            boolean r11 = r13.optimizeFor(r7)
            if (r11 == 0) goto L_0x0098
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L_0x0098
            if (r6 != r9) goto L_0x007d
            int r11 = r5.mMatchConstraintDefaultWidth
            if (r11 != 0) goto L_0x007d
            if (r8 == r9) goto L_0x007d
            boolean r11 = r5.isInHorizontalChain()
            if (r11 != 0) goto L_0x007d
            r10 = r7
        L_0x007d:
            if (r8 != r9) goto L_0x008c
            int r11 = r5.mMatchConstraintDefaultHeight
            if (r11 != 0) goto L_0x008c
            if (r6 == r9) goto L_0x008c
            boolean r11 = r5.isInHorizontalChain()
            if (r11 != 0) goto L_0x008c
            r10 = r7
        L_0x008c:
            if (r6 == r9) goto L_0x0090
            if (r8 != r9) goto L_0x0098
        L_0x0090:
            float r6 = r5.mDimensionRatio
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r7 = r10
        L_0x0099:
            if (r7 == 0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            r12.measure(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.mMetrics
            if (r5 == 0) goto L_0x00ac
            long r6 = r5.measuredWidgets
            r8 = 1
            long r6 = r6 + r8
            r5.measuredWidgets = r6
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00b0:
            r2.didMeasures()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.measureChildren(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i11, int i12, int i13) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i12);
        constraintWidgetContainer2.setHeight(i13);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.setPass(i11);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        boolean z11;
        boolean z12;
        int i21;
        boolean z13;
        int i22;
        boolean z14;
        boolean z15;
        int i23;
        boolean z16;
        Measurer measurer;
        int i24;
        int i25;
        int i26;
        boolean z17;
        boolean z18;
        boolean z19;
        Metrics metrics;
        boolean z21;
        boolean z22;
        boolean z23;
        ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer2;
        int i27 = i11;
        int i28 = i14;
        int i29 = i16;
        Measurer measurer2 = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer3.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean enabled = Optimizer.enabled(i27, 128);
        if (enabled || Optimizer.enabled(i27, 64)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i31 = 0;
            while (true) {
                if (i31 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer3.mChildren.get(i31);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour == dimensionBehaviour) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                if (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                if (!z21 || !z22 || constraintWidget.getDimensionRatio() <= 0.0f) {
                    z23 = false;
                } else {
                    z23 = true;
                }
                if ((!constraintWidget.isInHorizontalChain() || !z23) && ((!constraintWidget.isInVerticalChain() || !z23) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i31++;
                }
            }
            z11 = false;
        }
        if (z11 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        if (!(i28 == 1073741824 && i29 == 1073741824) && !enabled) {
            z12 = false;
        } else {
            z12 = true;
        }
        boolean z24 = z11 & z12;
        int i32 = 2;
        if (z24) {
            int min = Math.min(constraintWidgetContainer2.getMaxWidth(), i15);
            int min2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i17);
            if (i28 == 1073741824 && constraintWidgetContainer2.getWidth() != min) {
                constraintWidgetContainer3.setWidth(min);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i29 == 1073741824 && constraintWidgetContainer2.getHeight() != min2) {
                constraintWidgetContainer3.setHeight(min2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i28 == 1073741824 && i29 == 1073741824) {
                z13 = constraintWidgetContainer3.directMeasure(enabled);
                i21 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer3.directMeasureSetup(enabled);
                if (i28 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer3.directMeasureWithOrientation(enabled, 0);
                    i21 = 1;
                } else {
                    i21 = 0;
                }
                if (i29 == 1073741824) {
                    z13 = constraintWidgetContainer3.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i21++;
                } else {
                    z13 = directMeasureSetup;
                }
            }
            if (z13) {
                if (i28 == 1073741824) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (i29 == 1073741824) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                constraintWidgetContainer3.updateFromRuns(z18, z19);
            }
        } else {
            z13 = false;
            i21 = 0;
        }
        if (z13 && i21 == 2) {
            return 0;
        }
        int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
        if (size > 0) {
            measureChildren(constraintWidgetContainer2);
        }
        updateHierarchy(constraintWidgetContainer2);
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer2, "First pass", 0, width, height);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer2.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (horizontalDimensionBehaviour2 == dimensionBehaviour2) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (constraintWidgetContainer2.getVerticalDimensionBehaviour() == dimensionBehaviour2) {
                z15 = true;
            } else {
                z15 = false;
            }
            int max = Math.max(constraintWidgetContainer2.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer2.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i33 = 0;
            boolean z25 = false;
            while (i33 < size2) {
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i33);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i24 = optimizationLevel;
                    i25 = width;
                    i26 = height;
                } else {
                    int width2 = constraintWidget2.getWidth();
                    i24 = optimizationLevel;
                    int height2 = constraintWidget2.getHeight();
                    i26 = height;
                    boolean measure = measure(measurer2, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | z25;
                    Metrics metrics2 = constraintWidgetContainer3.mMetrics;
                    i25 = width;
                    boolean z26 = measure;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z14 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z17 = true;
                    } else {
                        z17 = z26;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z15 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z17 = true;
                    }
                    z25 = z17 | ((VirtualLayout) constraintWidget2).needSolverPass();
                }
                i33++;
                optimizationLevel = i24;
                height = i26;
                width = i25;
                i32 = 2;
            }
            int i34 = optimizationLevel;
            int i35 = width;
            int i36 = height;
            int i37 = i32;
            int i38 = 0;
            while (i38 < i37) {
                int i39 = 0;
                while (i39 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i39);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!z24 || !constraintWidget3.horizontalRun.f10834d.resolved || !constraintWidget3.verticalRun.f10834d.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i41 = Measure.TRY_GIVEN_DIMENSIONS;
                        z16 = z24;
                        if (i38 == 1) {
                            i41 = Measure.USE_GIVEN_DIMENSIONS;
                        }
                        boolean measure2 = measure(measurer2, constraintWidget3, i41) | z25;
                        Metrics metrics3 = constraintWidgetContainer3.mMetrics;
                        i23 = size2;
                        measurer = measurer2;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z14 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            measure2 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z15 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            measure2 = true;
                        }
                        if (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) {
                            z25 = measure2;
                        } else {
                            z25 = true;
                        }
                    } else {
                        z16 = z24;
                        i23 = size2;
                        measurer = measurer2;
                    }
                    i39++;
                    measurer2 = measurer;
                    z24 = z16;
                    size2 = i23;
                }
                boolean z27 = z24;
                int i42 = size2;
                Measurer measurer3 = measurer2;
                if (!z25) {
                    break;
                }
                i38++;
                solveLinearSystem(constraintWidgetContainer2, "intermediate pass", i38, i35, i36);
                measurer2 = measurer3;
                z24 = z27;
                size2 = i42;
                i37 = 2;
                z25 = false;
            }
            i22 = i34;
        } else {
            i22 = optimizationLevel;
        }
        constraintWidgetContainer3.setOptimizationLevel(i22);
        return 0;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i11);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }
}
