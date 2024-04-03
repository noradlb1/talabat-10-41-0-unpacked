package org.junit.platform.engine.discovery;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.util.Objects;
import n30.l;
import n30.m;
import n30.n;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.ClassUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class MethodSelector implements DiscoverySelector {
    private final String className;
    private Class<?> javaClass;
    private Method javaMethod;
    private final String methodName;
    private final String methodParameterTypes;

    public MethodSelector(String str, String str2) {
        this(str, str2, "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PreconditionViolationException lambda$lazyLoadJavaClass$0(Exception exc) {
        return new PreconditionViolationException("Could not load class with name: " + this.className, exc);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PreconditionViolationException lambda$lazyLoadJavaMethod$1() {
        return new PreconditionViolationException(String.format("Could not find method with name [%s] and parameter types [%s] in class [%s].", new Object[]{this.methodName, this.methodParameterTypes, this.javaClass.getName()}));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PreconditionViolationException lambda$lazyLoadJavaMethod$2() {
        return new PreconditionViolationException(String.format("Could not find method with name [%s] in class [%s].", new Object[]{this.methodName, this.javaClass.getName()}));
    }

    private void lazyLoadJavaClass() {
        if (this.javaClass == null) {
            this.javaClass = ReflectionUtils.tryToLoadClass(this.className).getOrThrow(new l(this));
        }
    }

    private void lazyLoadJavaMethod() {
        lazyLoadJavaClass();
        if (this.javaMethod != null) {
            return;
        }
        if (StringUtils.isNotBlank(this.methodParameterTypes)) {
            this.javaMethod = ReflectionUtils.findMethod(this.javaClass, this.methodName, this.methodParameterTypes).orElseThrow(new m(this));
        } else {
            this.javaMethod = ReflectionUtils.findMethod(this.javaClass, this.methodName, (Class<?>[]) new Class[0]).orElseThrow(new n(this));
        }
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MethodSelector methodSelector = (MethodSelector) obj;
        if (!Objects.equals(this.className, methodSelector.className) || !Objects.equals(this.methodName, methodSelector.methodName) || !Objects.equals(this.methodParameterTypes, methodSelector.methodParameterTypes)) {
            return false;
        }
        return true;
    }

    public String getClassName() {
        return this.className;
    }

    public Class<?> getJavaClass() {
        lazyLoadJavaClass();
        return this.javaClass;
    }

    public Method getJavaMethod() {
        lazyLoadJavaMethod();
        return this.javaMethod;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getMethodParameterTypes() {
        return this.methodParameterTypes;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return Objects.hash(new Object[]{this.className, this.methodName, this.methodParameterTypes});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(HexAttribute.HEX_ATTR_CLASS_NAME, this.className).append(HexAttribute.HEX_ATTR_METHOD_NAME, this.methodName).append("methodParameterTypes", this.methodParameterTypes).toString();
    }

    public MethodSelector(String str, String str2, String str3) {
        this.className = str;
        this.methodName = str2;
        this.methodParameterTypes = str3;
    }

    public MethodSelector(Class<?> cls, String str) {
        this(cls, str, "");
    }

    public MethodSelector(Class<?> cls, String str, String str2) {
        this.javaClass = cls;
        this.className = cls.getName();
        this.methodName = str;
        this.methodParameterTypes = str2;
    }

    public MethodSelector(Class<?> cls, Method method) {
        this.javaClass = cls;
        this.className = cls.getName();
        this.javaMethod = method;
        this.methodName = method.getName();
        this.methodParameterTypes = ClassUtils.nullSafeToString((Class<?>[]) method.getParameterTypes());
    }
}
