package org.mockito.internal.verification;

import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationEvent;
import org.mockito.verification.VerificationMode;

public class VerificationEventImpl implements VerificationEvent {
    private final Throwable cause;
    private final VerificationData data;
    private final Object mock;
    private final VerificationMode mode;

    public VerificationEventImpl(Object obj, VerificationMode verificationMode, VerificationData verificationData, Throwable th2) {
        this.mock = obj;
        this.mode = verificationMode;
        this.data = verificationData;
        this.cause = th2;
    }

    public VerificationData getData() {
        return this.data;
    }

    public Object getMock() {
        return this.mock;
    }

    public VerificationMode getMode() {
        return this.mode;
    }

    public Throwable getVerificationError() {
        return this.cause;
    }
}
