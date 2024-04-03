package org.mockito;

import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;

public interface MockedStatic<T> extends ScopedMock {

    public interface Verification {
        void apply() throws Throwable;
    }

    void clearInvocations();

    void reset();

    void verify(Verification verification);

    void verify(Verification verification, VerificationMode verificationMode);

    void verifyNoInteractions();

    void verifyNoMoreInteractions();

    <S> OngoingStubbing<S> when(Verification verification);
}
