package androidx.constraintlayout.core.widgets.analyzer;

class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        WidgetRun widgetRun = this.f10802a;
        ((VerticalWidgetRun) widgetRun).baseline.f10804c = widgetRun.f10831a.getBaselineDistance();
        this.resolved = true;
    }
}
