package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;

    /* renamed from: g  reason: collision with root package name */
    public DimensionDependency f10815g = null;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10816a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10816a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10816a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10816a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.start.f10803b = DependencyNode.Type.TOP;
        this.end.f10803b = DependencyNode.Type.BOTTOM;
        dependencyNode.f10803b = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.f10831a.setY(dependencyNode.value);
        }
    }

    public void c() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f10831a;
        if (constraintWidget.measured) {
            this.f10834d.resolve(constraintWidget.getHeight());
        }
        if (!this.f10834d.resolved) {
            this.f10833c = this.f10831a.getVerticalDimensionBehaviour();
            if (this.f10831a.hasBaseline()) {
                this.f10815g = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f10833c;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.f10831a.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.f10831a.mTop.getMargin()) - this.f10831a.mBottom.getMargin();
                    a(this.start, parent2.verticalRun.start, this.f10831a.mTop.getMargin());
                    a(this.end, parent2.verticalRun.end, -this.f10831a.mBottom.getMargin());
                    this.f10834d.resolve(height);
                    return;
                } else if (this.f10833c == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f10834d.resolve(this.f10831a.getHeight());
                }
            }
        } else if (this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.f10831a.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            a(this.start, parent.verticalRun.start, this.f10831a.mTop.getMargin());
            a(this.end, parent.verticalRun.end, -this.f10831a.mBottom.getMargin());
            return;
        }
        DimensionDependency dimensionDependency = this.f10834d;
        boolean z11 = dimensionDependency.resolved;
        if (z11) {
            ConstraintWidget constraintWidget2 = this.f10831a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.f10804c = this.f10831a.mListAnchors[2].getMargin();
                        this.end.f10804c = -this.f10831a.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode f11 = f(this.f10831a.mListAnchors[2]);
                        if (f11 != null) {
                            a(this.start, f11, this.f10831a.mListAnchors[2].getMargin());
                        }
                        DependencyNode f12 = f(this.f10831a.mListAnchors[3]);
                        if (f12 != null) {
                            a(this.end, f12, -this.f10831a.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.f10831a.hasBaseline()) {
                        a(this.baseline, this.start, this.f10831a.getBaselineDistance());
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode f13 = f(constraintAnchor);
                    if (f13 != null) {
                        a(this.start, f13, this.f10831a.mListAnchors[2].getMargin());
                        a(this.end, this.start, this.f10834d.value);
                        if (this.f10831a.hasBaseline()) {
                            a(this.baseline, this.start, this.f10831a.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode f14 = f(constraintAnchor3);
                        if (f14 != null) {
                            a(this.end, f14, -this.f10831a.mListAnchors[3].getMargin());
                            a(this.start, this.end, -this.f10834d.value);
                        }
                        if (this.f10831a.hasBaseline()) {
                            a(this.baseline, this.start, this.f10831a.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.mTarget != null) {
                        DependencyNode f15 = f(constraintAnchor4);
                        if (f15 != null) {
                            a(this.baseline, f15, 0);
                            a(this.start, this.baseline, -this.f10831a.getBaselineDistance());
                            a(this.end, this.start, this.f10834d.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.f10831a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        a(this.start, this.f10831a.getParent().verticalRun.start, this.f10831a.getY());
                        a(this.end, this.start, this.f10834d.value);
                        if (this.f10831a.hasBaseline()) {
                            a(this.baseline, this.start, this.f10831a.getBaselineDistance());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (z11 || this.f10833c != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            dimensionDependency.addDependency(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f10831a;
            int i11 = constraintWidget3.mMatchConstraintDefaultHeight;
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
            } else if (i11 == 3 && !constraintWidget3.isInVerticalChain()) {
                ConstraintWidget constraintWidget4 = this.f10831a;
                if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                    DimensionDependency dimensionDependency4 = constraintWidget4.horizontalRun.f10834d;
                    this.f10834d.f10808g.add(dimensionDependency4);
                    dimensionDependency4.f10807f.add(this.f10834d);
                    DimensionDependency dimensionDependency5 = this.f10834d;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.f10807f.add(this.start);
                    this.f10834d.f10807f.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f10831a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.f10804c = this.f10831a.mListAnchors[2].getMargin();
                this.end.f10804c = -this.f10831a.mListAnchors[3].getMargin();
            } else {
                DependencyNode f16 = f(this.f10831a.mListAnchors[2]);
                DependencyNode f17 = f(this.f10831a.mListAnchors[3]);
                if (f16 != null) {
                    f16.addDependency(this);
                }
                if (f17 != null) {
                    f17.addDependency(this);
                }
                this.f10836f = WidgetRun.RunType.CENTER;
            }
            if (this.f10831a.hasBaseline()) {
                b(this.baseline, this.start, 1, this.f10815g);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode f18 = f(constraintAnchor5);
            if (f18 != null) {
                a(this.start, f18, this.f10831a.mListAnchors[2].getMargin());
                b(this.end, this.start, 1, this.f10834d);
                if (this.f10831a.hasBaseline()) {
                    b(this.baseline, this.start, 1, this.f10815g);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f10833c;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f10831a.getDimensionRatio() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.f10831a.horizontalRun;
                    if (horizontalWidgetRun.f10833c == dimensionBehaviour3) {
                        horizontalWidgetRun.f10834d.f10807f.add(this.f10834d);
                        this.f10834d.f10808g.add(this.f10831a.horizontalRun.f10834d);
                        this.f10834d.updateDelegate = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode f19 = f(constraintAnchor7);
                if (f19 != null) {
                    a(this.end, f19, -this.f10831a.mListAnchors[3].getMargin());
                    b(this.start, this.end, -1, this.f10834d);
                    if (this.f10831a.hasBaseline()) {
                        b(this.baseline, this.start, 1, this.f10815g);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode f21 = f(constraintAnchor8);
                    if (f21 != null) {
                        a(this.baseline, f21, 0);
                        b(this.start, this.baseline, -1, this.f10815g);
                        b(this.end, this.start, 1, this.f10834d);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.getParent() != null) {
                    a(this.start, this.f10831a.getParent().verticalRun.start, this.f10831a.getY());
                    b(this.end, this.start, 1, this.f10834d);
                    if (this.f10831a.hasBaseline()) {
                        b(this.baseline, this.start, 1, this.f10815g);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f10833c;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f10831a.getDimensionRatio() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.f10831a.horizontalRun;
                        if (horizontalWidgetRun2.f10833c == dimensionBehaviour5) {
                            horizontalWidgetRun2.f10834d.f10807f.add(this.f10834d);
                            this.f10834d.f10808g.add(this.f10831a.horizontalRun.f10834d);
                            this.f10834d.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if (this.f10834d.f10808g.size() == 0) {
            this.f10834d.readyToSolve = true;
        }
    }

    public void d() {
        this.f10832b = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.f10834d.clear();
        this.f10835e = false;
    }

    public boolean h() {
        if (this.f10833c != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f10831a.mMatchConstraintDefaultHeight == 0) {
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
        this.baseline.clear();
        this.baseline.resolved = false;
        this.f10834d.resolved = false;
    }

    public String toString() {
        return "VerticalRun " + this.f10831a.getDebugName();
    }

    public void update(Dependency dependency) {
        int i11;
        float f11;
        float f12;
        float f13;
        int i12 = AnonymousClass1.f10816a[this.f10836f.ordinal()];
        if (i12 == 1) {
            k(dependency);
        } else if (i12 == 2) {
            j(dependency);
        } else if (i12 == 3) {
            ConstraintWidget constraintWidget = this.f10831a;
            i(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.f10834d;
        if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f10831a;
            int i13 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i13 == 2) {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    DimensionDependency dimensionDependency2 = parent.verticalRun.f10834d;
                    if (dimensionDependency2.resolved) {
                        this.f10834d.resolve((int) ((((float) dimensionDependency2.value) * this.f10831a.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            } else if (i13 == 3 && constraintWidget2.horizontalRun.f10834d.resolved) {
                int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                if (dimensionRatioSide == -1) {
                    ConstraintWidget constraintWidget3 = this.f10831a;
                    f13 = (float) constraintWidget3.horizontalRun.f10834d.value;
                    f12 = constraintWidget3.getDimensionRatio();
                } else if (dimensionRatioSide == 0) {
                    ConstraintWidget constraintWidget4 = this.f10831a;
                    f11 = ((float) constraintWidget4.horizontalRun.f10834d.value) * constraintWidget4.getDimensionRatio();
                    i11 = (int) (f11 + 0.5f);
                    this.f10834d.resolve(i11);
                } else if (dimensionRatioSide != 1) {
                    i11 = 0;
                    this.f10834d.resolve(i11);
                } else {
                    ConstraintWidget constraintWidget5 = this.f10831a;
                    f13 = (float) constraintWidget5.horizontalRun.f10834d.value;
                    f12 = constraintWidget5.getDimensionRatio();
                }
                f11 = f13 / f12;
                i11 = (int) (f11 + 0.5f);
                this.f10834d.resolve(i11);
            }
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (!dependencyNode.resolved || !dependencyNode2.resolved || !this.f10834d.resolved) {
                    if (!this.f10834d.resolved && this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.f10831a;
                        if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInVerticalChain()) {
                            int i14 = this.start.f10808g.get(0).value;
                            DependencyNode dependencyNode3 = this.start;
                            int i15 = i14 + dependencyNode3.f10804c;
                            int i16 = this.end.f10808g.get(0).value + this.end.f10804c;
                            dependencyNode3.resolve(i15);
                            this.end.resolve(i16);
                            this.f10834d.resolve(i16 - i15);
                            return;
                        }
                    }
                    if (!this.f10834d.resolved && this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.f10808g.size() > 0 && this.end.f10808g.size() > 0) {
                        int i17 = (this.end.f10808g.get(0).value + this.end.f10804c) - (this.start.f10808g.get(0).value + this.start.f10804c);
                        DimensionDependency dimensionDependency3 = this.f10834d;
                        int i18 = dimensionDependency3.wrapValue;
                        if (i17 < i18) {
                            dimensionDependency3.resolve(i17);
                        } else {
                            dimensionDependency3.resolve(i18);
                        }
                    }
                    if (this.f10834d.resolved && this.start.f10808g.size() > 0 && this.end.f10808g.size() > 0) {
                        DependencyNode dependencyNode4 = this.start.f10808g.get(0);
                        DependencyNode dependencyNode5 = this.end.f10808g.get(0);
                        int i19 = dependencyNode4.value + this.start.f10804c;
                        int i21 = dependencyNode5.value + this.end.f10804c;
                        float verticalBiasPercent = this.f10831a.getVerticalBiasPercent();
                        if (dependencyNode4 == dependencyNode5) {
                            i19 = dependencyNode4.value;
                            i21 = dependencyNode5.value;
                            verticalBiasPercent = 0.5f;
                        }
                        this.start.resolve((int) (((float) i19) + 0.5f + (((float) ((i21 - i19) - this.f10834d.value)) * verticalBiasPercent)));
                        this.end.resolve(this.start.value + this.f10834d.value);
                    }
                }
            }
        }
    }
}
