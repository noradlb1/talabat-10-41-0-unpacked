package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10809a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10809a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10809a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10809a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.f10803b = DependencyNode.Type.LEFT;
        this.end.f10803b = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i11, int i12, int i13, int i14, float f11, int i15) {
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        if (i15 == -1) {
            int i18 = (int) ((((float) i17) * f11) + 0.5f);
            int i19 = (int) ((((float) i16) / f11) + 0.5f);
            if (i18 <= i16) {
                iArr[0] = i18;
                iArr[1] = i17;
            } else if (i19 <= i17) {
                iArr[0] = i16;
                iArr[1] = i19;
            }
        } else if (i15 == 0) {
            iArr[0] = (int) ((((float) i17) * f11) + 0.5f);
            iArr[1] = i17;
        } else if (i15 == 1) {
            iArr[0] = i16;
            iArr[1] = (int) ((((float) i16) * f11) + 0.5f);
        }
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.f10831a.setX(dependencyNode.value);
        }
    }

    public void c() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f10831a;
        if (constraintWidget.measured) {
            this.f10834d.resolve(constraintWidget.getWidth());
        }
        if (!this.f10834d.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.f10831a.getHorizontalDimensionBehaviour();
            this.f10833c = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (parent2 = this.f10831a.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.f10831a.mLeft.getMargin()) - this.f10831a.mRight.getMargin();
                    a(this.start, parent2.horizontalRun.start, this.f10831a.mLeft.getMargin());
                    a(this.end, parent2.horizontalRun.end, -this.f10831a.mRight.getMargin());
                    this.f10834d.resolve(width);
                    return;
                } else if (this.f10833c == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f10834d.resolve(this.f10831a.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f10833c;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (parent = this.f10831a.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                a(this.start, parent.horizontalRun.start, this.f10831a.mLeft.getMargin());
                a(this.end, parent.horizontalRun.end, -this.f10831a.mRight.getMargin());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.f10834d;
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget2 = this.f10831a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode f11 = f(constraintAnchor);
                        if (f11 != null) {
                            a(this.start, f11, this.f10831a.mListAnchors[0].getMargin());
                            a(this.end, this.start, this.f10834d.value);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode f12 = f(constraintAnchor3);
                        if (f12 != null) {
                            a(this.end, f12, -this.f10831a.mListAnchors[1].getMargin());
                            a(this.start, this.end, -this.f10834d.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.f10831a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        a(this.start, this.f10831a.getParent().horizontalRun.start, this.f10831a.getX());
                        a(this.end, this.start, this.f10834d.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.isInHorizontalChain()) {
                    this.start.f10804c = this.f10831a.mListAnchors[0].getMargin();
                    this.end.f10804c = -this.f10831a.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode f13 = f(this.f10831a.mListAnchors[0]);
                    if (f13 != null) {
                        a(this.start, f13, this.f10831a.mListAnchors[0].getMargin());
                    }
                    DependencyNode f14 = f(this.f10831a.mListAnchors[1]);
                    if (f14 != null) {
                        a(this.end, f14, -this.f10831a.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f10831a;
            int i11 = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i11 == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency2 = parent3.verticalRun.f10834d;
                    this.f10834d.f10808g.add(dimensionDependency2);
                    dimensionDependency2.f10807f.add(this.f10834d);
                    DimensionDependency dimensionDependency3 = this.f10834d;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.f10807f.add(this.start);
                    this.f10834d.f10807f.add(this.end);
                }
            } else if (i11 == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.f10834d.f10808g.add(this.f10831a.verticalRun.f10834d);
                        this.f10831a.verticalRun.f10834d.f10807f.add(this.f10834d);
                        VerticalWidgetRun verticalWidgetRun2 = this.f10831a.verticalRun;
                        verticalWidgetRun2.f10834d.updateDelegate = this;
                        this.f10834d.f10808g.add(verticalWidgetRun2.start);
                        this.f10834d.f10808g.add(this.f10831a.verticalRun.end);
                        this.f10831a.verticalRun.start.f10807f.add(this.f10834d);
                        this.f10831a.verticalRun.end.f10807f.add(this.f10834d);
                    } else if (this.f10831a.isInHorizontalChain()) {
                        this.f10831a.verticalRun.f10834d.f10808g.add(this.f10834d);
                        this.f10834d.f10807f.add(this.f10831a.verticalRun.f10834d);
                    } else {
                        this.f10831a.verticalRun.f10834d.f10808g.add(this.f10834d);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.verticalRun.f10834d;
                    dimensionDependency.f10808g.add(dimensionDependency4);
                    dimensionDependency4.f10807f.add(this.f10834d);
                    this.f10831a.verticalRun.start.f10807f.add(this.f10834d);
                    this.f10831a.verticalRun.end.f10807f.add(this.f10834d);
                    DimensionDependency dimensionDependency5 = this.f10834d;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.f10807f.add(this.start);
                    this.f10834d.f10807f.add(this.end);
                    this.start.f10808g.add(this.f10834d);
                    this.end.f10808g.add(this.f10834d);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f10831a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchor5 != null) {
                DependencyNode f15 = f(constraintAnchor4);
                if (f15 != null) {
                    a(this.start, f15, this.f10831a.mListAnchors[0].getMargin());
                    b(this.end, this.start, 1, this.f10834d);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.mTarget != null) {
                DependencyNode f16 = f(constraintAnchor6);
                if (f16 != null) {
                    a(this.end, f16, -this.f10831a.mListAnchors[1].getMargin());
                    b(this.start, this.end, -1, this.f10834d);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
                a(this.start, this.f10831a.getParent().horizontalRun.start, this.f10831a.getX());
                b(this.end, this.start, 1, this.f10834d);
            }
        } else if (constraintWidget4.isInHorizontalChain()) {
            this.start.f10804c = this.f10831a.mListAnchors[0].getMargin();
            this.end.f10804c = -this.f10831a.mListAnchors[1].getMargin();
        } else {
            DependencyNode f17 = f(this.f10831a.mListAnchors[0]);
            DependencyNode f18 = f(this.f10831a.mListAnchors[1]);
            if (f17 != null) {
                f17.addDependency(this);
            }
            if (f18 != null) {
                f18.addDependency(this);
            }
            this.f10836f = WidgetRun.RunType.CENTER;
        }
    }

    public void d() {
        this.f10832b = null;
        this.start.clear();
        this.end.clear();
        this.f10834d.clear();
        this.f10835e = false;
    }

    public boolean h() {
        if (this.f10833c != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f10831a.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public void l() {
        this.f10835e = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.f10834d.resolved = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f10831a.getDebugName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b9, code lost:
        if (r14 != 1) goto L_0x031e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.f10809a
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.f10836f
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            r3 = r17
            r8.i(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.j(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.k(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            boolean r0 = r0.resolved
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f10833c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            int r3 = r0.mMatchConstraintDefaultWidth
            if (r3 == r1) goto L_0x0301
            if (r3 == r2) goto L_0x0046
            goto L_0x031e
        L_0x0046:
            int r1 = r0.mMatchConstraintDefaultHeight
            r3 = -1
            if (r1 == 0) goto L_0x008e
            if (r1 != r2) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            int r0 = r0.getDimensionRatioSide()
            if (r0 == r3) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            if (r0 == r9) goto L_0x005a
            r0 = r10
            goto L_0x0087
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f10834d
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
            goto L_0x0084
        L_0x0068:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f10834d
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
            float r1 = r1 / r0
            goto L_0x0085
        L_0x0077:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f10834d
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
        L_0x0084:
            float r1 = r1 * r0
        L_0x0085:
            float r1 = r1 + r11
            int r0 = (int) r1
        L_0x0087:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.f10834d
            r1.resolve(r0)
            goto L_0x031e
        L_0x008e:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.start
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.end
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x009c
            r1 = r9
            goto L_0x009d
        L_0x009c:
            r1 = r10
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x00a5
            r2 = r9
            goto L_0x00a6
        L_0x00a5:
            r2 = r10
        L_0x00a6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x00ae
            r4 = r9
            goto L_0x00af
        L_0x00ae:
            r4 = r10
        L_0x00af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x00b7
            r5 = r9
            goto L_0x00b8
        L_0x00b7:
            r5 = r10
        L_0x00b8:
            int r14 = r0.getDimensionRatioSide()
            if (r1 == 0) goto L_0x01ff
            if (r2 == 0) goto L_0x01ff
            if (r4 == 0) goto L_0x01ff
            if (r5 == 0) goto L_0x01ff
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            float r15 = r0.getDimensionRatio()
            boolean r0 = r12.resolved
            if (r0 == 0) goto L_0x012d
            boolean r0 = r13.resolved
            if (r0 == 0) goto L_0x012d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x012c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 != 0) goto L_0x00df
            goto L_0x012c
        L_0x00df:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.f10804c
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.f10804c
            int r3 = r0 - r1
            int r0 = r12.value
            int r1 = r12.f10804c
            int r4 = r0 + r1
            int r0 = r13.value
            int r1 = r13.f10804c
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
        L_0x012c:
            return
        L_0x012d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.resolved
            if (r1 == 0) goto L_0x018a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x018a
            boolean r2 = r12.readyToSolve
            if (r2 == 0) goto L_0x0189
            boolean r2 = r13.readyToSolve
            if (r2 != 0) goto L_0x0142
            goto L_0x0189
        L_0x0142:
            int r2 = r0.value
            int r0 = r0.f10804c
            int r2 = r2 + r0
            int r0 = r1.value
            int r1 = r1.f10804c
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.f10804c
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.f10804c
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x018a
        L_0x0189:
            return
        L_0x018a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x01fe
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r12.readyToSolve
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r13.readyToSolve
            if (r1 != 0) goto L_0x019f
            goto L_0x01fe
        L_0x019f:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.f10804c
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.f10804c
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.f10804c
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.f10804c
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x031e
        L_0x01fe:
            return
        L_0x01ff:
            if (r1 == 0) goto L_0x0288
            if (r4 == 0) goto L_0x0288
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r0 = r0.readyToSolve
            if (r0 == 0) goto L_0x0287
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            boolean r0 = r0.readyToSolve
            if (r0 != 0) goto L_0x0211
            goto L_0x0287
        L_0x0211:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            float r0 = r0.getDimensionRatio()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f10808g
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r2 = r2.f10804c
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.f10808g
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.end
            int r4 = r4.f10804c
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0264
            if (r14 == 0) goto L_0x0264
            if (r14 == r9) goto L_0x0241
            goto L_0x031e
        L_0x0241:
            int r2 = r2 - r1
            int r1 = r8.e(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.e(r2, r9)
            if (r2 == r3) goto L_0x0254
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0254:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            r0.resolve(r3)
            goto L_0x031e
        L_0x0264:
            int r2 = r2 - r1
            int r1 = r8.e(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.e(r2, r9)
            if (r2 == r3) goto L_0x0277
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0277:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            r0.resolve(r3)
            goto L_0x031e
        L_0x0287:
            return
        L_0x0288:
            if (r2 == 0) goto L_0x031e
            if (r5 == 0) goto L_0x031e
            boolean r0 = r12.readyToSolve
            if (r0 == 0) goto L_0x0300
            boolean r0 = r13.readyToSolve
            if (r0 != 0) goto L_0x0295
            goto L_0x0300
        L_0x0295:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            float r0 = r0.getDimensionRatio()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.f10808g
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            int r2 = r12.f10804c
            int r1 = r1 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r13.f10808g
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r4 = r13.f10804c
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02de
            if (r14 == 0) goto L_0x02bc
            if (r14 == r9) goto L_0x02de
            goto L_0x031e
        L_0x02bc:
            int r2 = r2 - r1
            int r1 = r8.e(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.e(r2, r10)
            if (r2 == r3) goto L_0x02cf
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02cf:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            r0.resolve(r1)
            goto L_0x031e
        L_0x02de:
            int r2 = r2 - r1
            int r1 = r8.e(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.e(r2, r10)
            if (r2 == r3) goto L_0x02f1
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02f1:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            r0.resolve(r1)
            goto L_0x031e
        L_0x0300:
            return
        L_0x0301:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.getParent()
            if (r0 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f10834d
            boolean r1 = r0.resolved
            if (r1 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f10831a
            float r1 = r1.mMatchConstraintPercentWidth
            int r0 = r0.value
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.f10834d
            r1.resolve(r0)
        L_0x031e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x043e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.readyToSolve
            if (r2 != 0) goto L_0x032c
            goto L_0x043e
        L_0x032c:
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x033b
            boolean r0 = r1.resolved
            if (r0 == 0) goto L_0x033b
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x033b
            return
        L_0x033b:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f10833c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f10831a
            int r1 = r0.mMatchConstraintDefaultWidth
            if (r1 != 0) goto L_0x0385
            boolean r0 = r0.isInHorizontalChain()
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f10808g
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r3 = r2.f10804c
            int r0 = r0 + r3
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.end
            int r3 = r3.f10804c
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.resolve(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            r0.resolve(r3)
            return
        L_0x0385:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f10833c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03e9
            int r0 = r8.matchConstraintsType
            if (r0 != r9) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f10808g
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r2 = r2.f10804c
            int r0 = r0 + r2
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            int r2 = r2.f10804c
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            int r0 = r0.wrapValue
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f10831a
            int r2 = r1.mMatchConstraintMaxWidth
            int r1 = r1.mMatchConstraintMinWidth
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03e4
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03e4:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.f10834d
            r1.resolve(r0)
        L_0x03e9:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03f0
            return
        L_0x03f0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f10808g
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f10808g
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.start
            int r3 = r3.f10804c
            int r2 = r2 + r3
            int r3 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.end
            int r4 = r4.f10804c
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.f10831a
            float r4 = r4.getHorizontalBiasPercent()
            if (r0 != r1) goto L_0x041f
            int r2 = r0.value
            int r3 = r1.value
            r4 = r11
        L_0x041f:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f10834d
            int r0 = r0.value
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r8.f10834d
            int r2 = r2.value
            int r1 = r1 + r2
            r0.resolve(r1)
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
