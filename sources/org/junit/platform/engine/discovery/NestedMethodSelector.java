package org.junit.platform.engine.discovery;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.6", status = API.Status.STABLE)
public class NestedMethodSelector implements DiscoverySelector {
    private final MethodSelector methodSelector;
    private final NestedClassSelector nestedClassSelector;

    public NestedMethodSelector(List<String> list, String str, String str2) {
        this.nestedClassSelector = new NestedClassSelector(list, str);
        this.methodSelector = new MethodSelector(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NestedMethodSelector nestedMethodSelector = (NestedMethodSelector) obj;
        if (!this.nestedClassSelector.equals(nestedMethodSelector.nestedClassSelector) || !this.methodSelector.equals(nestedMethodSelector.methodSelector)) {
            return false;
        }
        return true;
    }

    public List<String> getEnclosingClassNames() {
        return this.nestedClassSelector.getEnclosingClassNames();
    }

    public List<Class<?>> getEnclosingClasses() {
        return this.nestedClassSelector.getEnclosingClasses();
    }

    public Method getMethod() {
        return this.methodSelector.getJavaMethod();
    }

    public String getMethodName() {
        return this.methodSelector.getMethodName();
    }

    public String getMethodParameterTypes() {
        return this.methodSelector.getMethodParameterTypes();
    }

    public Class<?> getNestedClass() {
        return this.nestedClassSelector.getNestedClass();
    }

    public String getNestedClassName() {
        return this.nestedClassSelector.getNestedClassName();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.nestedClassSelector, this.methodSelector});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("enclosingClassNames", getEnclosingClassNames()).append("nestedClassName", getNestedClassName()).append(HexAttribute.HEX_ATTR_METHOD_NAME, getMethodName()).append("methodParameterTypes", getMethodParameterTypes()).toString();
    }

    public NestedMethodSelector(List<String> list, String str, String str2, String str3) {
        this.nestedClassSelector = new NestedClassSelector(list, str);
        this.methodSelector = new MethodSelector(str, str2, str3);
    }

    public NestedMethodSelector(List<Class<?>> list, Class<?> cls, String str) {
        this.nestedClassSelector = new NestedClassSelector(list, cls);
        this.methodSelector = new MethodSelector(cls, str);
    }

    public NestedMethodSelector(List<Class<?>> list, Class<?> cls, String str, String str2) {
        this.nestedClassSelector = new NestedClassSelector(list, cls);
        this.methodSelector = new MethodSelector(cls, str, str2);
    }

    public NestedMethodSelector(List<Class<?>> list, Class<?> cls, Method method) {
        this.nestedClassSelector = new NestedClassSelector(list, cls);
        this.methodSelector = new MethodSelector(cls, method);
    }
}
