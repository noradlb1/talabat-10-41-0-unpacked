package org.mockito.internal.stubbing.answers;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.ValidableAnswer;

public class ReturnsArgumentAt implements Answer<Object>, ValidableAnswer, Serializable {
    public static final int LAST_ARGUMENT = -1;
    private static final long serialVersionUID = -589315085166295101L;
    private final int wantedArgumentPosition;

    public ReturnsArgumentAt(int i11) {
        if (i11 == -1 || i11 >= 0) {
            this.wantedArgumentPosition = i11;
            return;
        }
        throw Reporter.invalidArgumentRangeAtIdentityAnswerCreationTime();
    }

    private Class<?> inferArgumentType(Invocation invocation, int i11) {
        Class<?>[] parameterTypes = invocation.getMethod().getParameterTypes();
        if (!invocation.getMethod().isVarArgs()) {
            Class<?> cls = parameterTypes[i11];
            Object argument = invocation.getArgument(i11);
            if (cls.isPrimitive() || argument == null) {
                return cls;
            }
            return argument.getClass();
        }
        int length = parameterTypes.length - 1;
        if (i11 < length) {
            return parameterTypes[i11];
        }
        if (wantedArgIndexIsVarargAndSameTypeAsReturnType(invocation.getMethod(), i11)) {
            return parameterTypes[i11];
        }
        return parameterTypes[length].getComponentType();
    }

    private int inferWantedArgumentPosition(InvocationOnMock invocationOnMock) {
        int i11 = this.wantedArgumentPosition;
        if (i11 == -1) {
            return invocationOnMock.getArguments().length - 1;
        }
        return i11;
    }

    private void validateArgumentTypeCompatibility(Invocation invocation, int i11) {
        InvocationInfo invocationInfo = new InvocationInfo(invocation);
        Class<?> inferArgumentType = inferArgumentType(invocation, i11);
        if (!invocationInfo.isValidReturnType(inferArgumentType)) {
            throw Reporter.wrongTypeOfArgumentToReturn(invocation, invocationInfo.printMethodReturnType(), inferArgumentType, this.wantedArgumentPosition);
        }
    }

    private void validateIndexWithinInvocationRange(InvocationOnMock invocationOnMock, int i11) {
        boolean z11;
        if (!wantedArgumentPositionIsValidForInvocation(invocationOnMock, i11)) {
            int i12 = this.wantedArgumentPosition;
            if (i12 == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            throw Reporter.invalidArgumentPositionRangeAtInvocationTime(invocationOnMock, z11, i12);
        }
    }

    private boolean wantedArgIndexIsVarargAndSameTypeAsReturnType(Method method, int i11) {
        Class[] parameterTypes = method.getParameterTypes();
        if (!method.isVarArgs() || i11 != parameterTypes.length - 1 || !method.getReturnType().isAssignableFrom(parameterTypes[i11])) {
            return false;
        }
        return true;
    }

    private boolean wantedArgumentPositionIsValidForInvocation(InvocationOnMock invocationOnMock, int i11) {
        if (i11 < 0) {
            return false;
        }
        if (invocationOnMock.getMethod().isVarArgs()) {
            return true;
        }
        if (invocationOnMock.getArguments().length > i11) {
            return true;
        }
        return false;
    }

    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        int inferWantedArgumentPosition = inferWantedArgumentPosition(invocationOnMock);
        validateIndexWithinInvocationRange(invocationOnMock, inferWantedArgumentPosition);
        if (wantedArgIndexIsVarargAndSameTypeAsReturnType(invocationOnMock.getMethod(), inferWantedArgumentPosition)) {
            return ((Invocation) invocationOnMock).getRawArguments()[inferWantedArgumentPosition];
        }
        return invocationOnMock.getArgument(inferWantedArgumentPosition);
    }

    public void validateFor(InvocationOnMock invocationOnMock) {
        int inferWantedArgumentPosition = inferWantedArgumentPosition(invocationOnMock);
        validateIndexWithinInvocationRange(invocationOnMock, inferWantedArgumentPosition);
        validateArgumentTypeCompatibility((Invocation) invocationOnMock, inferWantedArgumentPosition);
    }
}
