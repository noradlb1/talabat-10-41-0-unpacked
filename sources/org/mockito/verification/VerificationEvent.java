package org.mockito.verification;

import org.mockito.internal.verification.api.VerificationData;

public interface VerificationEvent {
    VerificationData getData();

    Object getMock();

    VerificationMode getMode();

    Throwable getVerificationError();
}
