package org.mockito.internal.stubbing.answers;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.ValidableAnswer;

public abstract class AbstractThrowsException implements Answer<Object>, ValidableAnswer {
    private final ConditionalStackTraceFilter filter = new ConditionalStackTraceFilter();

    public abstract Throwable a();

    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        Throwable a11 = a();
        if (a11 == null) {
            throw new IllegalStateException("throwable is null: you shall not call #answer if #validateFor fails!");
        } else if (!MockUtil.isMock(a11)) {
            Throwable fillInStackTrace = a11.fillInStackTrace();
            if (fillInStackTrace == null) {
                throw a11;
            }
            this.filter.filter(fillInStackTrace);
            throw fillInStackTrace;
        } else {
            throw a11;
        }
    }

    public void validateFor(InvocationOnMock invocationOnMock) {
        Throwable a11 = a();
        if (a11 == null) {
            throw Reporter.cannotStubWithNullThrowable();
        } else if (!(a11 instanceof RuntimeException) && !(a11 instanceof Error) && !new InvocationInfo(invocationOnMock).isValidException(a11)) {
            throw Reporter.checkedExceptionInvalid(a11);
        }
    }
}
