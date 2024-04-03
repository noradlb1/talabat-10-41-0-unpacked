package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    public BasicMeasure N = new BasicMeasure(this);
    public BasicMeasure.Measurer O = null;
    public LinearSystem P = new LinearSystem();
    public int Q;
    public int R;
    public int S;
    public int T;
    public ChainHead[] U = new ChainHead[4];
    public ChainHead[] V = new ChainHead[4];
    public int W = 0;
    public HashSet<ConstraintWidget> X = new HashSet<>();
    private WeakReference<ConstraintAnchor> horizontalWrapMax = null;
    private WeakReference<ConstraintAnchor> horizontalWrapMin = null;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    public int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    public BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    public Metrics mMetrics;
    private int mOptimizationLevel = 257;
    public boolean mSkipSolver = false;
    public int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;
    private int pass;
    private WeakReference<ConstraintAnchor> verticalWrapMax = null;
    private WeakReference<ConstraintAnchor> verticalWrapMin = null;

    public ConstraintWidgetContainer() {
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i11 = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.V;
        if (i11 >= chainHeadArr.length) {
            this.V = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.V[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.P.addGreaterThan(solverVariable, this.P.createObjectVariable(constraintAnchor), 0, 5);
    }

    private void addMinWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.P.addGreaterThan(this.P.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i11 = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.U;
        if (i11 >= chainHeadArr.length) {
            this.U = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.U[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        int i11;
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i12);
            constraintWidget.d(0, false);
            constraintWidget.d(1, false);
            if (constraintWidget instanceof Barrier) {
                z11 = true;
            }
        }
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i13);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).e();
                }
            }
        }
        this.X.clear();
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i14);
            if (constraintWidget3.a()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.X.add(constraintWidget3);
                } else {
                    constraintWidget3.addToSolver(linearSystem, optimizeFor);
                }
            }
        }
        while (this.X.size() > 0) {
            int size2 = this.X.size();
            Iterator<ConstraintWidget> it = this.X.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.contains(this.X)) {
                    virtualLayout.addToSolver(linearSystem, optimizeFor);
                    this.X.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.X.size()) {
                Iterator<ConstraintWidget> it2 = this.X.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(linearSystem, optimizeFor);
                }
                this.X.clear();
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet hashSet = new HashSet();
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget4 = this.mChildren.get(i15);
                if (!constraintWidget4.a()) {
                    hashSet.add(constraintWidget4);
                }
            }
            if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet, i11, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it3.next();
                Optimizer.a(this, linearSystem, constraintWidget5);
                constraintWidget5.addToSolver(linearSystem, optimizeFor);
            }
        } else {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = this.mChildren.get(i16);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.addToSolver(linearSystem, optimizeFor);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget6);
                    if (!constraintWidget6.a()) {
                        constraintWidget6.addToSolver(linearSystem, optimizeFor);
                    }
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) {
            this.horizontalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) {
            this.horizontalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z11) {
        return this.mDependencyGraph.directMeasure(z11);
    }

    public boolean directMeasureSetup(boolean z11) {
        return this.mDependencyGraph.directMeasureSetup(z11);
    }

    public boolean directMeasureWithOrientation(boolean z11, int i11) {
        return this.mDependencyGraph.directMeasureWithOrientation(z11, i11);
    }

    public void e(ConstraintWidget constraintWidget, int i11) {
        if (i11 == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i11 == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public void f(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) {
            this.verticalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.P.fillMetrics(metrics);
    }

    public void g(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) {
            this.verticalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i11);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.O;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public void getSceneString(StringBuilder sb2) {
        sb2.append(this.stringId + ":{\n");
        sb2.append("  actualWidth:" + this.f10772g);
        sb2.append(StringUtils.LF);
        sb2.append("  actualHeight:" + this.f10773h);
        sb2.append(StringUtils.LF);
        Iterator<ConstraintWidget> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().getSceneString(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public LinearSystem getSystem() {
        return this.P;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i11);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r1.f10775j = r2
            r1.f10776k = r2
            r1.mWidthMeasuredTooSmall = r2
            r1.mHeightMeasuredTooSmall = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.mChildren
            int r3 = r0.size()
            int r0 = r18.getWidth()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r18.getHeight()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            androidx.constraintlayout.core.Metrics r8 = r1.mMetrics
            if (r8 == 0) goto L_0x0033
            long r9 = r8.layouts
            r11 = 1
            long r9 = r9 + r11
            r8.layouts = r9
        L_0x0033:
            int r8 = r1.pass
            if (r8 != 0) goto L_0x0093
            int r8 = r1.mOptimizationLevel
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r8, r6)
            if (r8 == 0) goto L_0x0093
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r18.getMeasurer()
            androidx.constraintlayout.core.widgets.analyzer.Direct.solvingPass(r1, r8)
            r8 = r2
        L_0x0047:
            if (r8 >= r3) goto L_0x0093
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.isMeasureRequested()
            if (r10 == 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9.isInVirtualLayout()
            if (r10 != 0) goto L_0x0090
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.getDimensionBehaviour(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.getDimensionBehaviour(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0081
            int r10 = r9.mMatchConstraintDefaultWidth
            if (r10 == r6) goto L_0x0081
            if (r11 != r12) goto L_0x0081
            int r10 = r9.mMatchConstraintDefaultHeight
            if (r10 == r6) goto L_0x0081
            r10 = r6
            goto L_0x0082
        L_0x0081:
            r10 = r2
        L_0x0082:
            if (r10 != 0) goto L_0x0090
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r11 = r1.O
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            measure(r2, r9, r11, r10, r12)
        L_0x0090:
            int r8 = r8 + 1
            goto L_0x0047
        L_0x0093:
            r8 = 2
            if (r3 <= r8) goto L_0x00dc
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x009c
            if (r7 != r9) goto L_0x00dc
        L_0x009c:
            int r10 = r1.mOptimizationLevel
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r10, r11)
            if (r10 == 0) goto L_0x00dc
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r10 = r18.getMeasurer()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.Grouping.simpleSolvingPass(r1, r10)
            if (r10 == 0) goto L_0x00dc
            if (r5 != r9) goto L_0x00c4
            int r10 = r18.getWidth()
            if (r0 >= r10) goto L_0x00c0
            if (r0 <= 0) goto L_0x00c0
            r1.setWidth(r0)
            r1.mWidthMeasuredTooSmall = r6
            goto L_0x00c4
        L_0x00c0:
            int r0 = r18.getWidth()
        L_0x00c4:
            if (r7 != r9) goto L_0x00d8
            int r9 = r18.getHeight()
            if (r4 >= r9) goto L_0x00d4
            if (r4 <= 0) goto L_0x00d4
            r1.setHeight(r4)
            r1.mHeightMeasuredTooSmall = r6
            goto L_0x00d8
        L_0x00d4:
            int r4 = r18.getHeight()
        L_0x00d8:
            r9 = r4
            r4 = r0
            r0 = r6
            goto L_0x00df
        L_0x00dc:
            r9 = r4
            r4 = r0
            r0 = r2
        L_0x00df:
            r10 = 64
            boolean r11 = r1.optimizeFor(r10)
            if (r11 != 0) goto L_0x00f2
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.optimizeFor(r11)
            if (r11 == 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r11 = r2
            goto L_0x00f3
        L_0x00f2:
            r11 = r6
        L_0x00f3:
            androidx.constraintlayout.core.LinearSystem r12 = r1.P
            r12.graphOptimizer = r2
            r12.newgraphOptimizer = r2
            int r13 = r1.mOptimizationLevel
            if (r13 == 0) goto L_0x0101
            if (r11 == 0) goto L_0x0101
            r12.newgraphOptimizer = r6
        L_0x0101:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.mChildren
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0114
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.getVerticalDimensionBehaviour()
            if (r12 != r13) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r12 = r2
            goto L_0x0115
        L_0x0114:
            r12 = r6
        L_0x0115:
            r18.resetChains()
            r13 = r2
        L_0x0119:
            if (r13 >= r3) goto L_0x012f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.mChildren
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r15 == 0) goto L_0x012c
            androidx.constraintlayout.core.widgets.WidgetContainer r14 = (androidx.constraintlayout.core.widgets.WidgetContainer) r14
            r14.layout()
        L_0x012c:
            int r13 = r13 + 1
            goto L_0x0119
        L_0x012f:
            boolean r10 = r1.optimizeFor(r10)
            r13 = r0
            r0 = r2
            r14 = r6
        L_0x0136:
            if (r14 == 0) goto L_0x0324
            int r15 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.P     // Catch:{ Exception -> 0x01e7 }
            r0.reset()     // Catch:{ Exception -> 0x01e7 }
            r18.resetChains()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r0 = r1.P     // Catch:{ Exception -> 0x01e7 }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x01e7 }
            r0 = r2
        L_0x0148:
            if (r0 >= r3) goto L_0x015c
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.mChildren     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r2 = r1.P     // Catch:{ Exception -> 0x01e7 }
            r6.createObjectVariables(r2)     // Catch:{ Exception -> 0x01e7 }
            int r0 = r0 + 1
            r2 = 0
            r6 = 1
            goto L_0x0148
        L_0x015c:
            androidx.constraintlayout.core.LinearSystem r0 = r1.P     // Catch:{ Exception -> 0x01e7 }
            boolean r14 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x01e7 }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMin     // Catch:{ Exception -> 0x01e7 }
            r2 = 0
            if (r0 == 0) goto L_0x0182
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x0182
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMin     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.P     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mTop     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.addMinWrap(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.verticalWrapMin = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x0182:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMax     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01a1
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01a1
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMax     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.P     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mBottom     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.addMaxWrap(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.verticalWrapMax = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01a1:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMin     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01c0
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01c0
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMin     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.P     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mLeft     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.addMinWrap(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.horizontalWrapMin = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01c0:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMax     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01df
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01df
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMax     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.P     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mRight     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.addMaxWrap(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.horizontalWrapMax = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01df:
            if (r14 == 0) goto L_0x0201
            androidx.constraintlayout.core.LinearSystem r0 = r1.P     // Catch:{ Exception -> 0x01e7 }
            r0.minimize()     // Catch:{ Exception -> 0x01e7 }
            goto L_0x0201
        L_0x01e7:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x0201:
            if (r14 == 0) goto L_0x020c
            androidx.constraintlayout.core.LinearSystem r0 = r1.P
            boolean[] r2 = androidx.constraintlayout.core.widgets.Optimizer.f10797a
            boolean r0 = r1.updateChildrenFromSolver(r0, r2)
            goto L_0x0225
        L_0x020c:
            androidx.constraintlayout.core.LinearSystem r0 = r1.P
            r1.updateFromSolver(r0, r10)
            r0 = 0
        L_0x0212:
            if (r0 >= r3) goto L_0x0224
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mChildren
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.LinearSystem r6 = r1.P
            r2.updateFromSolver(r6, r10)
            int r0 = r0 + 1
            goto L_0x0212
        L_0x0224:
            r0 = 0
        L_0x0225:
            r2 = 8
            if (r12 == 0) goto L_0x0296
            if (r15 >= r2) goto L_0x0296
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.f10797a
            r8 = 2
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x0296
            r6 = 0
            r8 = 0
            r14 = 0
        L_0x0235:
            if (r6 >= r3) goto L_0x025f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mChildren
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r16 = r0
            int r0 = r2.f10775j
            int r17 = r2.getWidth()
            int r0 = r0 + r17
            int r14 = java.lang.Math.max(r14, r0)
            int r0 = r2.f10776k
            int r2 = r2.getHeight()
            int r0 = r0 + r2
            int r8 = java.lang.Math.max(r8, r0)
            int r6 = r6 + 1
            r0 = r16
            r2 = 8
            goto L_0x0235
        L_0x025f:
            r16 = r0
            int r0 = r1.f10782q
            int r0 = java.lang.Math.max(r0, r14)
            int r2 = r1.f10783r
            int r2 = java.lang.Math.max(r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x0282
            int r8 = r18.getWidth()
            if (r8 >= r0) goto L_0x0282
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r8 = 0
            r0[r8] = r6
            r13 = 1
            r16 = 1
        L_0x0282:
            if (r7 != r6) goto L_0x0298
            int r0 = r18.getHeight()
            if (r0 >= r2) goto L_0x0298
            r1.setHeight(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r2 = 1
            r0[r2] = r6
            r13 = 1
            r16 = 1
            goto L_0x0298
        L_0x0296:
            r16 = r0
        L_0x0298:
            int r0 = r1.f10782q
            int r2 = r18.getWidth()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.getWidth()
            if (r0 <= r2) goto L_0x02b5
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 0
            r0[r6] = r2
            r13 = 1
            r16 = 1
        L_0x02b5:
            int r0 = r1.f10783r
            int r2 = r18.getHeight()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.getHeight()
            if (r0 <= r2) goto L_0x02d3
            r1.setHeight(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 1
            r0[r6] = r2
            r2 = r6
            r16 = r2
            goto L_0x02d5
        L_0x02d3:
            r6 = 1
            r2 = r13
        L_0x02d5:
            if (r2 != 0) goto L_0x0314
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r8 = 0
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02f6
            if (r4 <= 0) goto L_0x02f6
            int r0 = r18.getWidth()
            if (r0 <= r4) goto L_0x02f6
            r1.mWidthMeasuredTooSmall = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r2
            r1.setWidth(r4)
            r2 = r6
            r16 = r2
        L_0x02f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0 = r0[r6]
            if (r0 != r13) goto L_0x0314
            if (r9 <= 0) goto L_0x0314
            int r0 = r18.getHeight()
            if (r0 <= r9) goto L_0x0314
            r1.mHeightMeasuredTooSmall = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.setHeight(r9)
            r0 = 8
            r2 = 1
            r13 = 1
            goto L_0x0319
        L_0x0314:
            r13 = r2
            r2 = r16
            r0 = 8
        L_0x0319:
            if (r15 <= r0) goto L_0x031d
            r14 = 0
            goto L_0x031e
        L_0x031d:
            r14 = r2
        L_0x031e:
            r0 = r15
            r2 = 0
            r6 = 1
            r8 = 2
            goto L_0x0136
        L_0x0324:
            r1.mChildren = r11
            if (r13 == 0) goto L_0x0330
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r2 = 0
            r0[r2] = r5
            r2 = 1
            r0[r2] = r7
        L_0x0330:
            androidx.constraintlayout.core.LinearSystem r0 = r1.P
            androidx.constraintlayout.core.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.layout():void");
    }

    public long measure(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        int i21 = i18;
        this.Q = i21;
        int i22 = i19;
        this.R = i22;
        return this.N.solverMeasure(this, i11, i21, i22, i12, i13, i14, i15, i16, i17);
    }

    public boolean optimizeFor(int i11) {
        return (this.mOptimizationLevel & i11) == i11;
    }

    public void reset() {
        this.P.reset();
        this.Q = 0;
        this.S = 0;
        this.R = 0;
        this.T = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.O = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i11) {
        this.mOptimizationLevel = i11;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        this.Q = i11;
        this.R = i12;
        this.S = i13;
        this.T = i14;
    }

    public void setPass(int i11) {
        this.pass = i11;
    }

    public void setRtl(boolean z11) {
        this.mIsRtl = z11;
    }

    public boolean updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean optimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i11);
            constraintWidget.updateFromSolver(linearSystem, optimizeFor);
            if (constraintWidget.hasDimensionOverride()) {
                z11 = true;
            }
        }
        return z11;
    }

    public void updateFromRuns(boolean z11, boolean z12) {
        super.updateFromRuns(z11, z12);
        int size = this.mChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mChildren.get(i11).updateFromRuns(z11, z12);
        }
    }

    public void updateHierarchy() {
        this.N.updateHierarchy(this);
    }

    public static boolean measure(int i11, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i12) {
        int i13;
        int i14;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.getVisibility() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour == dimensionBehaviour2;
        boolean z12 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z13 = z11 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z14 = z12 && constraintWidget.mDimensionRatio > 0.0f;
        if (z11 && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z13) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z12 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (z12 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z14) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z12 = false;
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z12 = false;
        }
        if (z13) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z12) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.verticalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i14 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i14 = measure.measuredHeight;
                }
                measure.horizontalBehavior = dimensionBehaviour4;
                measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * ((float) i14));
            }
        }
        if (z14) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.horizontalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i13 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i13 = measure.measuredWidth;
                }
                measure.verticalBehavior = dimensionBehaviour6;
                if (constraintWidget.getDimensionRatioSide() == -1) {
                    measure.verticalDimension = (int) (((float) i13) / constraintWidget.getDimensionRatio());
                } else {
                    measure.verticalDimension = (int) (constraintWidget.getDimensionRatio() * ((float) i13));
                }
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    public ConstraintWidgetContainer(int i11, int i12, int i13, int i14) {
        super(i11, i12, i13, i14);
    }

    public ConstraintWidgetContainer(int i11, int i12) {
        super(i11, i12);
    }

    public ConstraintWidgetContainer(String str, int i11, int i12) {
        super(i11, i12);
        setDebugName(str);
    }
}
