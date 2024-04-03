package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.d();
        constraintWidget.verticalRun.d();
        this.orientation = ((Guideline) constraintWidget).getOrientation();
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.f10807f.add(dependencyNode);
        dependencyNode.f10808g.add(this.start);
    }

    public void applyToWidget() {
        if (((Guideline) this.f10831a).getOrientation() == 1) {
            this.f10831a.setX(this.start.value);
        } else {
            this.f10831a.setY(this.start.value);
        }
    }

    public void c() {
        Guideline guideline = (Guideline) this.f10831a;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                this.start.f10808g.add(this.f10831a.mParent.horizontalRun.start);
                this.f10831a.mParent.horizontalRun.start.f10807f.add(this.start);
                this.start.f10804c = relativeBegin;
            } else if (relativeEnd != -1) {
                this.start.f10808g.add(this.f10831a.mParent.horizontalRun.end);
                this.f10831a.mParent.horizontalRun.end.f10807f.add(this.start);
                this.start.f10804c = -relativeEnd;
            } else {
                DependencyNode dependencyNode = this.start;
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.f10808g.add(this.f10831a.mParent.horizontalRun.end);
                this.f10831a.mParent.horizontalRun.end.f10807f.add(this.start);
            }
            addDependency(this.f10831a.horizontalRun.start);
            addDependency(this.f10831a.horizontalRun.end);
            return;
        }
        if (relativeBegin != -1) {
            this.start.f10808g.add(this.f10831a.mParent.verticalRun.start);
            this.f10831a.mParent.verticalRun.start.f10807f.add(this.start);
            this.start.f10804c = relativeBegin;
        } else if (relativeEnd != -1) {
            this.start.f10808g.add(this.f10831a.mParent.verticalRun.end);
            this.f10831a.mParent.verticalRun.end.f10807f.add(this.start);
            this.start.f10804c = -relativeEnd;
        } else {
            DependencyNode dependencyNode2 = this.start;
            dependencyNode2.delegateToWidgetRun = true;
            dependencyNode2.f10808g.add(this.f10831a.mParent.verticalRun.end);
            this.f10831a.mParent.verticalRun.end.f10807f.add(this.start);
        }
        addDependency(this.f10831a.verticalRun.start);
        addDependency(this.f10831a.verticalRun.end);
    }

    public void d() {
        this.start.clear();
    }

    public boolean h() {
        return false;
    }

    public void update(Dependency dependency) {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve && !dependencyNode.resolved) {
            this.start.resolve((int) ((((float) dependencyNode.f10808g.get(0).value) * ((Guideline) this.f10831a).getRelativePercent()) + 0.5f));
        }
    }
}
