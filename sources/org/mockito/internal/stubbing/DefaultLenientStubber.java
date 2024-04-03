package org.mockito.internal.stubbing;

import org.mockito.internal.MockitoCore;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;

public class DefaultLenientStubber implements LenientStubber {
    private static final MockitoCore MOCKITO_CORE = new MockitoCore();

    private static Stubber stubber() {
        return MOCKITO_CORE.stubber(Strictness.LENIENT);
    }

    public Stubber doAnswer(Answer answer) {
        return stubber().doAnswer(answer);
    }

    public Stubber doCallRealMethod() {
        return stubber().doCallRealMethod();
    }

    public Stubber doNothing() {
        return stubber().doNothing();
    }

    public Stubber doReturn(Object obj) {
        return stubber().doReturn(obj);
    }

    public Stubber doThrow(Throwable... thArr) {
        return stubber().doThrow(thArr);
    }

    public <T> OngoingStubbing<T> when(T t11) {
        OngoingStubbingImpl ongoingStubbingImpl = (OngoingStubbingImpl) MOCKITO_CORE.when(t11);
        ongoingStubbingImpl.setStrictness(Strictness.LENIENT);
        return ongoingStubbingImpl;
    }

    public Stubber doReturn(Object obj, Object... objArr) {
        return stubber().doReturn(obj, objArr);
    }

    public Stubber doThrow(Class<? extends Throwable> cls) {
        return stubber().doThrow(cls);
    }

    public Stubber doThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return stubber().doThrow(cls, clsArr);
    }
}
