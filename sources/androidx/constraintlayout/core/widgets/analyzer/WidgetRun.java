package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f10831a;

    /* renamed from: b  reason: collision with root package name */
    public RunGroup f10832b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f10833c;

    /* renamed from: d  reason: collision with root package name */
    public DimensionDependency f10834d = new DimensionDependency(this);

    /* renamed from: e  reason: collision with root package name */
    public boolean f10835e = false;
    public DependencyNode end = new DependencyNode(this);

    /* renamed from: f  reason: collision with root package name */
    public RunType f10836f = RunType.NONE;
    public int matchConstraintsType;
    public int orientation = 0;
    public DependencyNode start = new DependencyNode(this);

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10837a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10837a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10837a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10837a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10837a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10837a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f10831a = constraintWidget;
    }

    private void resolveDimension(int i11, int i12) {
        WidgetRun widgetRun;
        float f11;
        int i13;
        int i14 = this.matchConstraintsType;
        if (i14 == 0) {
            this.f10834d.resolve(e(i12, i11));
        } else if (i14 == 1) {
            this.f10834d.resolve(Math.min(e(this.f10834d.wrapValue, i11), i12));
        } else if (i14 == 2) {
            ConstraintWidget parent = this.f10831a.getParent();
            if (parent != null) {
                if (i11 == 0) {
                    widgetRun = parent.horizontalRun;
                } else {
                    widgetRun = parent.verticalRun;
                }
                DimensionDependency dimensionDependency = widgetRun.f10834d;
                if (dimensionDependency.resolved) {
                    ConstraintWidget constraintWidget = this.f10831a;
                    if (i11 == 0) {
                        f11 = constraintWidget.mMatchConstraintPercentWidth;
                    } else {
                        f11 = constraintWidget.mMatchConstraintPercentHeight;
                    }
                    this.f10834d.resolve(e((int) ((((float) dimensionDependency.value) * f11) + 0.5f), i11));
                }
            }
        } else if (i14 == 3) {
            ConstraintWidget constraintWidget2 = this.f10831a;
            WidgetRun widgetRun2 = constraintWidget2.horizontalRun;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.f10833c;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                if (verticalWidgetRun.f10833c == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                    return;
                }
            }
            if (i11 == 0) {
                widgetRun2 = constraintWidget2.verticalRun;
            }
            if (widgetRun2.f10834d.resolved) {
                float dimensionRatio = constraintWidget2.getDimensionRatio();
                if (i11 == 1) {
                    i13 = (int) ((((float) widgetRun2.f10834d.value) / dimensionRatio) + 0.5f);
                } else {
                    i13 = (int) ((dimensionRatio * ((float) widgetRun2.f10834d.value)) + 0.5f);
                }
                this.f10834d.resolve(i13);
            }
        }
    }

    public final void a(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11) {
        dependencyNode.f10808g.add(dependencyNode2);
        dependencyNode.f10804c = i11;
        dependencyNode2.f10807f.add(dependencyNode);
    }

    public abstract void applyToWidget();

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11, DimensionDependency dimensionDependency) {
        dependencyNode.f10808g.add(dependencyNode2);
        dependencyNode.f10808g.add(this.f10834d);
        dependencyNode.f10805d = i11;
        dependencyNode.f10806e = dimensionDependency;
        dependencyNode2.f10807f.add(dependencyNode);
        dimensionDependency.f10807f.add(dependencyNode);
    }

    public abstract void c();

    public abstract void d();

    public final int e(int i11, int i12) {
        int i13;
        if (i12 == 0) {
            ConstraintWidget constraintWidget = this.f10831a;
            int i14 = constraintWidget.mMatchConstraintMaxWidth;
            i13 = Math.max(constraintWidget.mMatchConstraintMinWidth, i11);
            if (i14 > 0) {
                i13 = Math.min(i14, i11);
            }
            if (i13 == i11) {
                return i11;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f10831a;
            int i15 = constraintWidget2.mMatchConstraintMaxHeight;
            int max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i11);
            if (i15 > 0) {
                max = Math.min(i15, i11);
            }
            if (i13 == i11) {
                return i11;
            }
        }
        return i13;
    }

    public final DependencyNode f(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i11 = AnonymousClass1.f10837a[constraintAnchor2.mType.ordinal()];
        if (i11 == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (i11 == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (i11 == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (i11 == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (i11 != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    public final DependencyNode g(ConstraintAnchor constraintAnchor, int i11) {
        WidgetRun widgetRun;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        if (i11 == 0) {
            widgetRun = constraintWidget.horizontalRun;
        } else {
            widgetRun = constraintWidget.verticalRun;
        }
        int i12 = AnonymousClass1.f10837a[constraintAnchor2.mType.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    if (i12 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.f10834d;
        if (dimensionDependency.resolved) {
            return (long) dimensionDependency.value;
        }
        return 0;
    }

    public abstract boolean h();

    public void i(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        float f11;
        DependencyNode f12 = f(constraintAnchor);
        DependencyNode f13 = f(constraintAnchor2);
        if (f12.resolved && f13.resolved) {
            int margin = f12.value + constraintAnchor.getMargin();
            int margin2 = f13.value - constraintAnchor2.getMargin();
            int i12 = margin2 - margin;
            if (!this.f10834d.resolved && this.f10833c == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i11, i12);
            }
            DimensionDependency dimensionDependency = this.f10834d;
            if (dimensionDependency.resolved) {
                if (dimensionDependency.value == i12) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.f10831a;
                if (i11 == 0) {
                    f11 = constraintWidget.getHorizontalBiasPercent();
                } else {
                    f11 = constraintWidget.getVerticalBiasPercent();
                }
                if (f12 == f13) {
                    margin = f12.value;
                    margin2 = f13.value;
                    f11 = 0.5f;
                }
                this.start.resolve((int) (((float) margin) + 0.5f + (((float) ((margin2 - margin) - this.f10834d.value)) * f11)));
                this.end.resolve(this.start.value + this.f10834d.value);
            }
        }
    }

    public boolean isCenterConnection() {
        int size = this.start.f10808g.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            if (this.start.f10808g.get(i12).f10802a != this) {
                i11++;
            }
        }
        int size2 = this.end.f10808g.size();
        for (int i13 = 0; i13 < size2; i13++) {
            if (this.end.f10808g.get(i13).f10802a != this) {
                i11++;
            }
        }
        if (i11 >= 2) {
            return true;
        }
        return false;
    }

    public boolean isDimensionResolved() {
        return this.f10834d.resolved;
    }

    public boolean isResolved() {
        return this.f10835e;
    }

    public void j(Dependency dependency) {
    }

    public void k(Dependency dependency) {
    }

    public void update(Dependency dependency) {
    }

    public long wrapSize(int i11) {
        int i12;
        DimensionDependency dimensionDependency = this.f10834d;
        if (!dimensionDependency.resolved) {
            return 0;
        }
        long j11 = (long) dimensionDependency.value;
        if (isCenterConnection()) {
            i12 = this.start.f10804c - this.end.f10804c;
        } else if (i11 != 0) {
            return j11 - ((long) this.end.f10804c);
        } else {
            i12 = this.start.f10804c;
        }
        return j11 + ((long) i12);
    }
}
