package org.mockito.listeners;

import org.mockito.verification.VerificationEvent;

public interface VerificationListener extends MockitoListener {
    void onVerification(VerificationEvent verificationEvent);
}
