package org.mockito.internal.invocation;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.SuspendMethod;

public class SerializableMethod implements Serializable, MockitoMethod {
    private static final long serialVersionUID = 6005610965006048445L;
    private final Class<?> declaringClass;
    private final Class<?>[] exceptionTypes;
    private final boolean isAbstract;
    private final boolean isVarArgs;
    private volatile transient Method method;
    private final String methodName;
    private final Class<?>[] parameterTypes;
    private final Class<?> returnType;

    public SerializableMethod(Method method2) {
        boolean z11;
        this.method = method2;
        this.declaringClass = method2.getDeclaringClass();
        this.methodName = method2.getName();
        this.parameterTypes = SuspendMethod.trimSuspendParameterTypes(method2.getParameterTypes());
        this.returnType = method2.getReturnType();
        this.exceptionTypes = method2.getExceptionTypes();
        this.isVarArgs = method2.isVarArgs();
        if ((method2.getModifiers() & 1024) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isAbstract = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SerializableMethod serializableMethod = (SerializableMethod) obj;
        Class<?> cls = this.declaringClass;
        if (cls == null) {
            if (serializableMethod.declaringClass != null) {
                return false;
            }
        } else if (!cls.equals(serializableMethod.declaringClass)) {
            return false;
        }
        String str = this.methodName;
        if (str == null) {
            if (serializableMethod.methodName != null) {
                return false;
            }
        } else if (!str.equals(serializableMethod.methodName)) {
            return false;
        }
        if (!Arrays.equals(this.parameterTypes, serializableMethod.parameterTypes)) {
            return false;
        }
        Class<?> cls2 = this.returnType;
        if (cls2 == null) {
            if (serializableMethod.returnType != null) {
                return false;
            }
        } else if (!cls2.equals(serializableMethod.returnType)) {
            return false;
        }
        return true;
    }

    public Class<?>[] getExceptionTypes() {
        return this.exceptionTypes;
    }

    public Method getJavaMethod() {
        if (this.method != null) {
            return this.method;
        }
        try {
            this.method = this.declaringClass.getDeclaredMethod(this.methodName, this.parameterTypes);
            return this.method;
        } catch (SecurityException e11) {
            throw new MockitoException(String.format("The method %1$s.%2$s is probably private or protected and cannot be mocked.\nPlease report this as a defect with an example of how to reproduce it.", new Object[]{this.declaringClass, this.methodName}), e11);
        } catch (NoSuchMethodException e12) {
            throw new MockitoException(String.format("The method %1$s.%2$s does not exists and you should not get to this point.\nPlease report this as a defect with an example of how to reproduce it.", new Object[]{this.declaringClass, this.methodName}), e12);
        }
    }

    public String getName() {
        return this.methodName;
    }

    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    public Class<?> getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return 1;
    }

    public boolean isAbstract() {
        return this.isAbstract;
    }

    public boolean isVarArgs() {
        return this.isVarArgs;
    }
}
