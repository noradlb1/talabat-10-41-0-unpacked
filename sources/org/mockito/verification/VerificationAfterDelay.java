package org.mockito.verification;

public interface VerificationAfterDelay extends VerificationMode {
    VerificationMode atLeast(int i11);

    VerificationMode atLeastOnce();

    VerificationMode atMost(int i11);

    VerificationMode atMostOnce();

    VerificationMode never();

    VerificationMode only();

    VerificationMode times(int i11);
}
