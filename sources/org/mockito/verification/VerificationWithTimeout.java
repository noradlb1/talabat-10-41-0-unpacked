package org.mockito.verification;

public interface VerificationWithTimeout extends VerificationMode {
    VerificationMode atLeast(int i11);

    VerificationMode atLeastOnce();

    VerificationMode only();

    VerificationMode times(int i11);
}
