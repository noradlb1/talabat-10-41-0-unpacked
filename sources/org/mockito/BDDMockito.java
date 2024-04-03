package org.mockito;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;

public class BDDMockito extends Mockito {

    public interface BDDMyOngoingStubbing<T> {
        <M> M getMock();

        BDDMyOngoingStubbing<T> will(Answer<?> answer);

        BDDMyOngoingStubbing<T> willAnswer(Answer<?> answer);

        BDDMyOngoingStubbing<T> willCallRealMethod();

        BDDMyOngoingStubbing<T> willReturn(T t11);

        BDDMyOngoingStubbing<T> willReturn(T t11, T... tArr);

        BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls);

        BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr);

        BDDMyOngoingStubbing<T> willThrow(Throwable... thArr);
    }

    public static class BDDOngoingStubbingImpl<T> implements BDDMyOngoingStubbing<T> {
        private final OngoingStubbing<T> mockitoOngoingStubbing;

        public BDDOngoingStubbingImpl(OngoingStubbing<T> ongoingStubbing) {
            this.mockitoOngoingStubbing = ongoingStubbing;
        }

        public <M> M getMock() {
            return this.mockitoOngoingStubbing.getMock();
        }

        public BDDMyOngoingStubbing<T> will(Answer<?> answer) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.then(answer));
        }

        public BDDMyOngoingStubbing<T> willAnswer(Answer<?> answer) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenAnswer(answer));
        }

        public BDDMyOngoingStubbing<T> willCallRealMethod() {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenCallRealMethod());
        }

        public BDDMyOngoingStubbing<T> willReturn(T t11) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenReturn(t11));
        }

        public BDDMyOngoingStubbing<T> willThrow(Throwable... thArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(thArr));
        }

        public BDDMyOngoingStubbing<T> willReturn(T t11, T... tArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenReturn(t11, tArr));
        }

        public BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(cls));
        }

        public BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(cls, clsArr));
        }
    }

    public interface BDDStubber {
        <T> T given(T t11);

        BDDStubber will(Answer<?> answer);

        BDDStubber willAnswer(Answer<?> answer);

        BDDStubber willCallRealMethod();

        BDDStubber willDoNothing();

        BDDStubber willReturn(Object obj);

        BDDStubber willReturn(Object obj, Object... objArr);

        BDDStubber willThrow(Class<? extends Throwable> cls);

        BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr);

        BDDStubber willThrow(Throwable... thArr);
    }

    public static class BDDStubberImpl implements BDDStubber {
        private final Stubber mockitoStubber;

        public BDDStubberImpl(Stubber stubber) {
            this.mockitoStubber = stubber;
        }

        public <T> T given(T t11) {
            return this.mockitoStubber.when(t11);
        }

        public BDDStubber will(Answer<?> answer) {
            return new BDDStubberImpl(this.mockitoStubber.doAnswer(answer));
        }

        public BDDStubber willAnswer(Answer<?> answer) {
            return new BDDStubberImpl(this.mockitoStubber.doAnswer(answer));
        }

        public BDDStubber willCallRealMethod() {
            return new BDDStubberImpl(this.mockitoStubber.doCallRealMethod());
        }

        public BDDStubber willDoNothing() {
            return new BDDStubberImpl(this.mockitoStubber.doNothing());
        }

        public BDDStubber willReturn(Object obj) {
            return new BDDStubberImpl(this.mockitoStubber.doReturn(obj));
        }

        public BDDStubber willThrow(Throwable... thArr) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(thArr));
        }

        public BDDStubber willReturn(Object obj, Object... objArr) {
            return new BDDStubberImpl(this.mockitoStubber.doReturn(obj).doReturn(objArr));
        }

        public BDDStubber willThrow(Class<? extends Throwable> cls) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(cls));
        }

        public BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(cls, clsArr));
        }
    }

    public interface Then<T> {
        T should();

        T should(InOrder inOrder);

        T should(InOrder inOrder, VerificationMode verificationMode);

        T should(VerificationMode verificationMode);

        void shouldHaveNoInteractions();

        void shouldHaveNoMoreInteractions();
    }

    public static class ThenImpl<T> implements Then<T> {
        private final T mock;

        public ThenImpl(T t11) {
            this.mock = t11;
        }

        public T should() {
            return Mockito.verify(this.mock);
        }

        public void shouldHaveNoInteractions() {
            Mockito.verifyNoInteractions(this.mock);
        }

        public void shouldHaveNoMoreInteractions() {
            Mockito.verifyNoMoreInteractions(this.mock);
        }

        public T should(VerificationMode verificationMode) {
            return Mockito.verify(this.mock, verificationMode);
        }

        public T should(InOrder inOrder) {
            return inOrder.verify(this.mock);
        }

        public T should(InOrder inOrder, VerificationMode verificationMode) {
            return inOrder.verify(this.mock, verificationMode);
        }
    }

    public static <T> BDDMyOngoingStubbing<T> given(T t11) {
        return new BDDOngoingStubbingImpl(Mockito.when(t11));
    }

    public static <T> Then<T> then(T t11) {
        return new ThenImpl(t11);
    }

    public static BDDStubber will(Answer<?> answer) {
        return new BDDStubberImpl(Mockito.doAnswer(answer));
    }

    public static BDDStubber willAnswer(Answer<?> answer) {
        return new BDDStubberImpl(Mockito.doAnswer(answer));
    }

    public static BDDStubber willCallRealMethod() {
        return new BDDStubberImpl(Mockito.doCallRealMethod());
    }

    public static BDDStubber willDoNothing() {
        return new BDDStubberImpl(Mockito.doNothing());
    }

    public static BDDStubber willReturn(Object obj) {
        return new BDDStubberImpl(Mockito.doReturn(obj));
    }

    public static BDDStubber willThrow(Throwable... thArr) {
        return new BDDStubberImpl(Mockito.doThrow(thArr));
    }

    public static BDDStubber willReturn(Object obj, Object... objArr) {
        return new BDDStubberImpl(Mockito.doReturn(obj, objArr));
    }

    public static BDDStubber willThrow(Class<? extends Throwable> cls) {
        return new BDDStubberImpl(Mockito.doThrow(cls));
    }

    public static BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return new BDDStubberImpl(Mockito.doThrow(cls, clsArr));
    }
}
