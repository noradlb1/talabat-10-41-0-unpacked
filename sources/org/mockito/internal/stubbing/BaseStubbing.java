package org.mockito.internal.stubbing;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.mockito.internal.stubbing.answers.Returns;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.internal.stubbing.answers.ThrowsExceptionForClassType;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

public abstract class BaseStubbing<T> implements OngoingStubbing<T> {
    private final Object strongMockRef;

    public BaseStubbing(Object obj) {
        this.strongMockRef = obj;
    }

    private OngoingStubbing<T> thenThrow(Throwable th2) {
        return thenAnswer(new ThrowsException(th2));
    }

    public <M> M getMock() {
        return this.strongMockRef;
    }

    public OngoingStubbing<T> then(Answer<?> answer) {
        return thenAnswer(answer);
    }

    public OngoingStubbing<T> thenCallRealMethod() {
        return thenAnswer(new CallsRealMethods());
    }

    public OngoingStubbing<T> thenReturn(T t11) {
        return thenAnswer(new Returns(t11));
    }

    public OngoingStubbing<T> thenReturn(T t11, T... tArr) {
        OngoingStubbing<T> thenReturn = thenReturn(t11);
        if (tArr == null) {
            return thenReturn.thenReturn(null);
        }
        for (T thenReturn2 : tArr) {
            thenReturn = thenReturn.thenReturn(thenReturn2);
        }
        return thenReturn;
    }

    public OngoingStubbing<T> thenThrow(Throwable... thArr) {
        OngoingStubbing<T> ongoingStubbing = null;
        if (thArr == null) {
            return thenThrow((Throwable) null);
        }
        for (Throwable th2 : thArr) {
            if (ongoingStubbing == null) {
                ongoingStubbing = thenThrow(th2);
            } else {
                ongoingStubbing = ongoingStubbing.thenThrow(th2);
            }
        }
        return ongoingStubbing;
    }

    public OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls) {
        if (cls != null) {
            return thenAnswer(new ThrowsExceptionForClassType(cls));
        }
        ThreadSafeMockingProgress.mockingProgress().reset();
        throw Reporter.notAnException();
    }

    public OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        if (clsArr == null) {
            return thenThrow((Class<? extends Throwable>) null);
        }
        OngoingStubbing<? extends Throwable> thenThrow = thenThrow(cls);
        for (Class<? extends Throwable> thenThrow2 : clsArr) {
            thenThrow = thenThrow.thenThrow(thenThrow2);
        }
        return thenThrow;
    }
}
