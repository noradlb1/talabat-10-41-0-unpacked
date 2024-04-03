package org.mockito.internal.creation.instance;

import com.facebook.internal.security.CertificateUtil;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.mockito.creation.instance.InstantiationException;
import org.mockito.creation.instance.Instantiator;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.Primitives;
import org.mockito.internal.util.StringUtil;

public class ConstructorInstantiator implements Instantiator {
    private final Object[] constructorArgs;
    private final boolean hasOuterClassInstance;

    public ConstructorInstantiator(boolean z11, Object... objArr) {
        this.hasOuterClassInstance = z11;
        this.constructorArgs = objArr;
    }

    private String constructorArgTypes() {
        String str;
        boolean z11 = this.hasOuterClassInstance;
        String[] strArr = new String[(this.constructorArgs.length - (z11 ? 1 : 0))];
        int i11 = z11;
        while (true) {
            Object[] objArr = this.constructorArgs;
            if (i11 >= objArr.length) {
                return Arrays.toString(strArr);
            }
            int i12 = i11 - z11;
            Object obj = objArr[i11];
            if (obj == null) {
                str = null;
            } else {
                str = obj.getClass().getName();
            }
            strArr[i12] = str;
            i11++;
        }
    }

    private String constructorArgsString() {
        Object[] objArr = this.constructorArgs;
        if (objArr.length == 0 || (this.hasOuterClassInstance && objArr.length == 1)) {
            return "a 0-arg constructor";
        }
        return "a constructor that matches these argument types: " + constructorArgTypes();
    }

    private void evaluateConstructor(List<Constructor<?>> list, Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = 0; i11 < parameterTypes.length; i11++) {
            Class cls = parameterTypes[i11];
            if (!cls.isPrimitive()) {
                for (Constructor<?> parameterTypes2 : list) {
                    Class cls2 = parameterTypes2.getParameterTypes()[i11];
                    if (cls != cls2) {
                        if (cls.isAssignableFrom(cls2)) {
                            z11 = true;
                        } else {
                            z12 = true;
                        }
                    }
                }
            }
        }
        if (!z11) {
            list.clear();
        }
        if (z12 || !z11) {
            list.add(constructor);
        }
    }

    private static <T> T invokeConstructor(Constructor<?> constructor, Object... objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        return Plugins.getMemberAccessor().newInstance(constructor, objArr);
    }

    private InstantiationException multipleMatchingConstructors(Class<?> cls, List<Constructor<?>> list) {
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", "Multiple constructors could be matched to arguments of types " + constructorArgTypes() + CertificateUtil.DELIMITER, StringUtil.join("", " - ", list), "If you believe that Mockito could do a better job deciding on which constructor to use, please let us know.", "Ticket 685 contains the discussion and a workaround for ambiguous constructors using inner class.", "See https://github.com/mockito/mockito/issues/685"), (Throwable) null);
    }

    private InstantiationException noMatchingConstructor(Class<?> cls) {
        String str;
        String constructorArgsString = constructorArgsString();
        if (this.hasOuterClassInstance) {
            str = " and provided outer instance is correct";
        } else {
            str = "";
        }
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", "Please ensure that the target class has " + constructorArgsString + str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER), (Throwable) null);
    }

    private InstantiationException paramsException(Class<?> cls, Exception exc) {
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", "Please ensure the target class has " + constructorArgsString() + " and executes cleanly."), exc);
    }

    private static boolean paramsMatch(Class<?>[] clsArr, Object[] objArr) {
        if (objArr.length != clsArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < objArr.length; i11++) {
            if (objArr[i11] == null) {
                if (clsArr[i11].isPrimitive()) {
                    return false;
                }
            } else if ((!clsArr[i11].isPrimitive() && !clsArr[i11].isInstance(objArr[i11])) || (clsArr[i11].isPrimitive() && !clsArr[i11].equals(Primitives.primitiveTypeOf(objArr[i11].getClass())))) {
                return false;
            }
        }
        return true;
    }

    private <T> T withParams(Class<T> cls, Object... objArr) {
        LinkedList linkedList = new LinkedList();
        try {
            for (Constructor constructor : cls.getDeclaredConstructors()) {
                if (paramsMatch(constructor.getParameterTypes(), objArr)) {
                    evaluateConstructor(linkedList, constructor);
                }
            }
            if (linkedList.size() == 1) {
                return invokeConstructor((Constructor) linkedList.get(0), objArr);
            }
            if (linkedList.isEmpty()) {
                throw noMatchingConstructor(cls);
            }
            throw multipleMatchingConstructors(cls, linkedList);
        } catch (Exception e11) {
            throw paramsException(cls, e11);
        }
    }

    public <T> T newInstance(Class<T> cls) {
        return withParams(cls, this.constructorArgs);
    }
}
