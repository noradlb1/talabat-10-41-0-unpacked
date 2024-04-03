package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.f10807f.add(dependencyNode);
        dependencyNode.f10808g.add(this.start);
    }

    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.f10831a;
        if (constraintWidget instanceof Barrier) {
            int barrierType = ((Barrier) constraintWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.f10831a.setX(this.start.value);
            } else {
                this.f10831a.setY(this.start.value);
            }
        }
    }

    public void c() {
        ConstraintWidget constraintWidget = this.f10831a;
        if (constraintWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
            int i11 = 0;
            if (barrierType == 0) {
                this.start.f10803b = DependencyNode.Type.LEFT;
                while (i11 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i11];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.horizontalRun.start;
                        dependencyNode.f10807f.add(this.start);
                        this.start.f10808g.add(dependencyNode);
                    }
                    i11++;
                }
                addDependency(this.f10831a.horizontalRun.start);
                addDependency(this.f10831a.horizontalRun.end);
            } else if (barrierType == 1) {
                this.start.f10803b = DependencyNode.Type.RIGHT;
                while (i11 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i11];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.horizontalRun.end;
                        dependencyNode2.f10807f.add(this.start);
                        this.start.f10808g.add(dependencyNode2);
                    }
                    i11++;
                }
                addDependency(this.f10831a.horizontalRun.start);
                addDependency(this.f10831a.horizontalRun.end);
            } else if (barrierType == 2) {
                this.start.f10803b = DependencyNode.Type.TOP;
                while (i11 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i11];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.verticalRun.start;
                        dependencyNode3.f10807f.add(this.start);
                        this.start.f10808g.add(dependencyNode3);
                    }
                    i11++;
                }
                addDependency(this.f10831a.verticalRun.start);
                addDependency(this.f10831a.verticalRun.end);
            } else if (barrierType == 3) {
                this.start.f10803b = DependencyNode.Type.BOTTOM;
                while (i11 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget5 = barrier.mWidgets[i11];
                    if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.verticalRun.end;
                        dependencyNode4.f10807f.add(this.start);
                        this.start.f10808g.add(dependencyNode4);
                    }
                    i11++;
                }
                addDependency(this.f10831a.verticalRun.start);
                addDependency(this.f10831a.verticalRun.end);
            }
        }
    }

    public void d() {
        this.f10832b = null;
        this.start.clear();
    }

    public boolean h() {
        return false;
    }

    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.f10831a;
        int barrierType = barrier.getBarrierType();
        int i11 = 0;
        int i12 = -1;
        for (DependencyNode dependencyNode : this.start.f10808g) {
            int i13 = dependencyNode.value;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i11 < i13) {
                i11 = i13;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(i12 + barrier.getMargin());
        } else {
            this.start.resolve(i11 + barrier.getMargin());
        }
    }
}
