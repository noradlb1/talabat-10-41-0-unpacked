package org.mockito.internal.stubbing.defaultanswers;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.mockito.internal.MockitoCore;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.invocation.InvocationOnMock;

final class RetrieveGenericsForDefaultAnswers {
    private static final MockitoCore MOCKITO_CORE = new MockitoCore();

    public interface AnswerCallback {
        Object apply(Class<?> cls);
    }

    private RetrieveGenericsForDefaultAnswers() {
    }

    public static Object a(InvocationOnMock invocationOnMock, AnswerCallback answerCallback) {
        Object obj;
        Class<?> returnType = invocationOnMock.getMethod().getReturnType();
        Type genericReturnType = invocationOnMock.getMethod().getGenericReturnType();
        if (!(genericReturnType instanceof TypeVariable) || (returnType = findTypeFromGeneric(invocationOnMock, (TypeVariable) genericReturnType)) == null) {
            obj = null;
        } else {
            obj = delegateChains(returnType);
        }
        if (obj != null) {
            return obj;
        }
        if (returnType == null) {
            return answerCallback.apply((Class<?>) null);
        }
        if (!MOCKITO_CORE.isTypeMockable(returnType)) {
            return null;
        }
        return answerCallback.apply(returnType);
    }

    private static Object delegateChains(Class<?> cls) {
        ReturnsEmptyValues returnsEmptyValues = new ReturnsEmptyValues();
        Object a11 = returnsEmptyValues.a(cls);
        if (a11 == null) {
            for (Class<?> cls2 = cls; cls2 != null && a11 == null; cls2 = cls2.getSuperclass()) {
                for (Class a12 : cls2.getInterfaces()) {
                    a11 = returnsEmptyValues.a(a12);
                    if (a11 != null) {
                        break;
                    }
                }
            }
        }
        if (a11 == null) {
            return new ReturnsMoreEmptyValues().a(cls);
        }
        return a11;
    }

    private static Class<?> findTypeFromGeneric(InvocationOnMock invocationOnMock, TypeVariable typeVariable) {
        Class<?> rawType = GenericMetadataSupport.inferFrom(MockUtil.getMockHandler(invocationOnMock.getMock()).getMockSettings().getTypeToMock()).resolveGenericReturnType(invocationOnMock.getMethod()).rawType();
        if (rawType == Object.class) {
            return findTypeFromGenericInArguments(invocationOnMock, typeVariable);
        }
        return rawType;
    }

    private static Class<?> findTypeFromGenericInArguments(InvocationOnMock invocationOnMock, TypeVariable typeVariable) {
        Type[] genericParameterTypes = invocationOnMock.getMethod().getGenericParameterTypes();
        int i11 = 0;
        while (i11 < genericParameterTypes.length) {
            Type type = genericParameterTypes[i11];
            if (typeVariable.equals(type)) {
                Object argument = invocationOnMock.getArgument(i11);
                if (argument == null) {
                    return null;
                }
                return argument.getClass();
            } else if ((type instanceof GenericArrayType) && typeVariable.equals(((GenericArrayType) type).getGenericComponentType())) {
                return invocationOnMock.getArgument(i11).getClass();
            } else {
                i11++;
            }
        }
        return null;
    }
}
