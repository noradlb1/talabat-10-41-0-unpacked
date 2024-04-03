package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.f10803b = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f10803b = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public void resolve(int i11) {
        if (!this.resolved) {
            this.resolved = true;
            this.value = i11;
            for (Dependency next : this.f10807f) {
                next.update(next);
            }
        }
    }
}
