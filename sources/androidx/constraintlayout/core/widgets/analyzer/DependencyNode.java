package androidx.constraintlayout.core.widgets.analyzer;

import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public WidgetRun f10802a;

    /* renamed from: b  reason: collision with root package name */
    public Type f10803b = Type.UNKNOWN;

    /* renamed from: c  reason: collision with root package name */
    public int f10804c;

    /* renamed from: d  reason: collision with root package name */
    public int f10805d = 1;
    public boolean delegateToWidgetRun = false;

    /* renamed from: e  reason: collision with root package name */
    public DimensionDependency f10806e = null;

    /* renamed from: f  reason: collision with root package name */
    public List<Dependency> f10807f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List<DependencyNode> f10808g = new ArrayList();
    public boolean readyToSolve = false;
    public boolean resolved = false;
    public Dependency updateDelegate = null;
    public int value;

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f10802a = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.f10807f.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.f10808g.clear();
        this.f10807f.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String str;
        String debugName = this.f10802a.f10831a.getDebugName();
        Type type = this.f10803b;
        if (type == Type.LEFT || type == Type.RIGHT) {
            str = debugName + "_HORIZONTAL";
        } else {
            str = debugName + "_VERTICAL";
        }
        return str + CertificateUtil.DELIMITER + this.f10803b.name();
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

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10802a.f10831a.getDebugName());
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(this.f10803b);
        sb2.append("(");
        if (this.resolved) {
            obj = Integer.valueOf(this.value);
        } else {
            obj = "unresolved";
        }
        sb2.append(obj);
        sb2.append(") <t=");
        sb2.append(this.f10808g.size());
        sb2.append(":d=");
        sb2.append(this.f10807f.size());
        sb2.append(">");
        return sb2.toString();
    }

    public void update(Dependency dependency) {
        for (DependencyNode dependencyNode : this.f10808g) {
            if (!dependencyNode.resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.f10802a.update(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i11 = 0;
        for (DependencyNode next : this.f10808g) {
            if (!(next instanceof DimensionDependency)) {
                i11++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i11 == 1 && dependencyNode2.resolved) {
            DimensionDependency dimensionDependency = this.f10806e;
            if (dimensionDependency != null) {
                if (dimensionDependency.resolved) {
                    this.f10804c = this.f10805d * dimensionDependency.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode2.value + this.f10804c);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
