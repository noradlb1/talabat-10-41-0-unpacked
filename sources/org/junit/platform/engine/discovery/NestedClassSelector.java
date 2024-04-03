package org.junit.platform.engine.discovery;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.Objects;
import n30.o;
import n30.p;
import n30.q;
import n30.r;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.6", status = API.Status.STABLE)
public class NestedClassSelector implements DiscoverySelector {
    private List<ClassSelector> enclosingClassSelectors;
    private ClassSelector nestedClassSelector;

    public NestedClassSelector(List<String> list, String str) {
        this.enclosingClassSelectors = (List) Collection.EL.stream(list).map(new o()).collect(Collectors.toList());
        this.nestedClassSelector = new ClassSelector(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NestedClassSelector nestedClassSelector2 = (NestedClassSelector) obj;
        if (!this.enclosingClassSelectors.equals(nestedClassSelector2.enclosingClassSelectors) || !this.nestedClassSelector.equals(nestedClassSelector2.nestedClassSelector)) {
            return false;
        }
        return true;
    }

    public List<String> getEnclosingClassNames() {
        return (List) Collection.EL.stream(this.enclosingClassSelectors).map(new p()).collect(Collectors.toList());
    }

    public List<Class<?>> getEnclosingClasses() {
        return (List) Collection.EL.stream(this.enclosingClassSelectors).map(new q()).collect(Collectors.toList());
    }

    public Class<?> getNestedClass() {
        return this.nestedClassSelector.getJavaClass();
    }

    public String getNestedClassName() {
        return this.nestedClassSelector.getClassName();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.enclosingClassSelectors, this.nestedClassSelector});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("enclosingClassNames", getEnclosingClassNames()).append("nestedClassName", getNestedClassName()).toString();
    }

    public NestedClassSelector(List<Class<?>> list, Class<?> cls) {
        this.enclosingClassSelectors = (List) Collection.EL.stream(list).map(new r()).collect(Collectors.toList());
        this.nestedClassSelector = new ClassSelector(cls);
    }
}
