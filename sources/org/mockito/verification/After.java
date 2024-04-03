package org.mockito.verification;

import org.mockito.internal.verification.VerificationOverTimeImpl;
import org.mockito.internal.verification.VerificationWrapper;

public class After extends VerificationWrapper<VerificationOverTimeImpl> implements VerificationAfterDelay {
    public After(long j11, VerificationMode verificationMode) {
        this(10, j11, verificationMode);
    }

    public VerificationMode a(VerificationMode verificationMode) {
        return new After(((VerificationOverTimeImpl) this.f63278a).copyWithVerificationMode(verificationMode));
    }

    public String toString() {
        return "Wanted after " + ((VerificationOverTimeImpl) this.f63278a).getTimer().duration() + " ms: [" + ((VerificationOverTimeImpl) this.f63278a).getDelegate() + "]";
    }

    public After(long j11, long j12, VerificationMode verificationMode) {
        this(new VerificationOverTimeImpl(j11, j12, verificationMode, false));
    }

    public After(VerificationOverTimeImpl verificationOverTimeImpl) {
        super(verificationOverTimeImpl);
    }
}
