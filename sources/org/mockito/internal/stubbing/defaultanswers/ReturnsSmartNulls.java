package org.mockito.internal.stubbing.defaultanswers;

import java.io.Serializable;
import org.mockito.Mockito;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.stubbing.defaultanswers.RetrieveGenericsForDefaultAnswers;
import org.mockito.internal.util.ObjectMethodsGuru;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.Location;
import org.mockito.stubbing.Answer;

public class ReturnsSmartNulls implements Answer<Object>, Serializable {
    private static final long serialVersionUID = 7618312406617949441L;
    private final Answer<Object> delegate = new ReturnsMoreEmptyValues();

    public static class ThrowsSmartNullPointer implements Answer {
        private final Location location;
        private final InvocationOnMock unstubbedInvocation;

        public ThrowsSmartNullPointer(InvocationOnMock invocationOnMock, Location location2) {
            this.unstubbedInvocation = invocationOnMock;
            this.location = location2;
        }

        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            if (ObjectMethodsGuru.isToStringMethod(invocationOnMock.getMethod())) {
                return "SmartNull returned by this unstubbed method call on a mock:\n" + this.unstubbedInvocation;
            }
            throw Reporter.smartNullPointerException(this.unstubbedInvocation.toString(), this.location);
        }
    }

    public Object answer(final InvocationOnMock invocationOnMock) throws Throwable {
        Object answer = this.delegate.answer(invocationOnMock);
        if (answer != null) {
            return answer;
        }
        return RetrieveGenericsForDefaultAnswers.a(invocationOnMock, new RetrieveGenericsForDefaultAnswers.AnswerCallback() {
            public Object apply(Class<?> cls) {
                if (cls == null) {
                    return null;
                }
                return Mockito.mock(cls, (Answer) new ThrowsSmartNullPointer(invocationOnMock, new LocationImpl()));
            }
        });
    }
}
