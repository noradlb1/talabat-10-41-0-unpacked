package org.junit.platform.engine.support.descriptor;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.ClassUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;
import p30.g;
import p30.h;
import p30.i;

@API(since = "1.0", status = API.Status.STABLE)
public class MethodSource implements TestSource {
    private static final long serialVersionUID = 1;
    private final String className;
    private Class<?> javaClass;
    private transient Method javaMethod;
    private final String methodName;
    private final String methodParameterTypes;

    private MethodSource(String str, String str2) {
        this(str, str2, (String) null);
    }

    public static MethodSource from(String str, String str2) {
        return new MethodSource(str, str2);
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
            this.javaClass = ReflectionUtils.tryToLoadClass(this.className).getOrThrow(new g(this));
        }
    }

    private void lazyLoadJavaMethod() {
        lazyLoadJavaClass();
        if (this.javaMethod != null) {
            return;
        }
        if (StringUtils.isNotBlank(this.methodParameterTypes)) {
            this.javaMethod = ReflectionUtils.findMethod(this.javaClass, this.methodName, this.methodParameterTypes).orElseThrow(new h(this));
        } else {
            this.javaMethod = ReflectionUtils.findMethod(this.javaClass, this.methodName, (Class<?>[]) new Class[0]).orElseThrow(new i(this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MethodSource methodSource = (MethodSource) obj;
        if (!Objects.equals(this.className, methodSource.className) || !Objects.equals(this.methodName, methodSource.methodName) || !Objects.equals(this.methodParameterTypes, methodSource.methodParameterTypes)) {
            return false;
        }
        return true;
    }

    public String getClassName() {
        return this.className;
    }

    @API(since = "1.7", status = API.Status.STABLE)
    public final Class<?> getJavaClass() {
        lazyLoadJavaClass();
        return this.javaClass;
    }

    @API(since = "1.7", status = API.Status.STABLE)
    public final Method getJavaMethod() {
        lazyLoadJavaMethod();
        return this.javaMethod;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final String getMethodParameterTypes() {
        return this.methodParameterTypes;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.className, this.methodName, this.methodParameterTypes});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(HexAttribute.HEX_ATTR_CLASS_NAME, this.className).append(HexAttribute.HEX_ATTR_METHOD_NAME, this.methodName).append("methodParameterTypes", this.methodParameterTypes).toString();
    }

    private MethodSource(String str, String str2, String str3) {
        Preconditions.notBlank(str, "Class name must not be null or blank");
        Preconditions.notBlank(str2, "Method name must not be null or blank");
        this.className = str;
        this.methodName = str2;
        this.methodParameterTypes = str3;
    }

    public static MethodSource from(String str, String str2, String str3) {
        return new MethodSource(str, str2, str3);
    }

    @API(since = "1.5", status = API.Status.STABLE)
    public static MethodSource from(String str, String str2, Class<?>... clsArr) {
        return new MethodSource(str, str2, ClassUtils.nullSafeToString(clsArr));
    }

    public static MethodSource from(Method method) {
        return new MethodSource(method);
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public static MethodSource from(Class<?> cls, Method method) {
        return new MethodSource(cls, method);
    }

    private MethodSource(Method method) {
        this(((Method) Preconditions.notNull(method, "Method must not be null")).getDeclaringClass(), method);
    }

    private MethodSource(Class<?> cls, Method method) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(method, "Method must not be null");
        this.className = cls.getName();
        this.methodName = method.getName();
        this.methodParameterTypes = ClassUtils.nullSafeToString((Class<?>[]) method.getParameterTypes());
        this.javaClass = cls;
        this.javaMethod = method;
    }
}
