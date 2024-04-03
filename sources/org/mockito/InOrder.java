package org.mockito;

import org.mockito.verification.VerificationMode;

public interface InOrder {
    <T> T verify(T t11);

    <T> T verify(T t11, VerificationMode verificationMode);

    void verifyNoMoreInteractions();
}
