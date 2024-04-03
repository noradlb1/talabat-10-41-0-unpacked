package org.mockito.verification;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.VerificationOverTimeImpl;
import org.mockito.internal.verification.VerificationWrapper;

public class Timeout extends VerificationWrapper<VerificationOverTimeImpl> implements VerificationWithTimeout {
    public Timeout(long j11, VerificationMode verificationMode) {
        this(10, j11, verificationMode);
    }

    public VerificationMode a(VerificationMode verificationMode) {
        return new Timeout(((VerificationOverTimeImpl) this.f63278a).copyWithVerificationMode(verificationMode));
    }

    public VerificationMode atMost(int i11) {
        throw Reporter.atMostAndNeverShouldNotBeUsedWithTimeout();
    }

    public VerificationMode never() {
        throw Reporter.atMostAndNeverShouldNotBeUsedWithTimeout();
    }

    public String toString() {
        return "Wanted after at most " + ((VerificationOverTimeImpl) this.f63278a).getTimer().duration() + " ms: [" + ((VerificationOverTimeImpl) this.f63278a).getDelegate() + "]";
    }

    public Timeout(long j11, long j12, VerificationMode verificationMode) {
        this(new VerificationOverTimeImpl(j11, j12, verificationMode, true));
    }

    public Timeout(VerificationOverTimeImpl verificationOverTimeImpl) {
        super(verificationOverTimeImpl);
    }
}
