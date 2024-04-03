package org.mockito.internal.verification;

import d40.a;
import org.mockito.internal.util.Timer;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

public class VerificationOverTimeImpl implements VerificationMode {
    private final VerificationMode delegate;
    private final long pollingPeriodMillis;
    private final boolean returnOnSuccess;
    private final Timer timer;

    public VerificationOverTimeImpl(long j11, long j12, VerificationMode verificationMode, boolean z11) {
        this(j11, verificationMode, z11, new Timer(j12));
    }

    private AssertionError handleVerifyException(AssertionError assertionError) {
        if (a(this.delegate)) {
            sleep(this.pollingPeriodMillis);
            return assertionError;
        }
        throw assertionError;
    }

    private void sleep(long j11) {
        try {
            Thread.sleep(j11);
        } catch (InterruptedException e11) {
            throw new RuntimeException("Thread sleep has been interrupted", e11);
        }
    }

    public boolean a(VerificationMode verificationMode) {
        return !(verificationMode instanceof AtMost) && !(verificationMode instanceof NoMoreInteractions);
    }

    public VerificationOverTimeImpl copyWithVerificationMode(VerificationMode verificationMode) {
        return new VerificationOverTimeImpl(this.pollingPeriodMillis, this.timer.duration(), verificationMode, this.returnOnSuccess);
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public VerificationMode getDelegate() {
        return this.delegate;
    }

    public long getPollingPeriodMillis() {
        return this.pollingPeriodMillis;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public boolean isReturnOnSuccess() {
        return this.returnOnSuccess;
    }

    public void verify(VerificationData verificationData) {
        this.timer.start();
        do {
            AssertionError assertionError = null;
            while (this.timer.isCounting()) {
                try {
                    this.delegate.verify(verificationData);
                } catch (AssertionError e11) {
                    assertionError = handleVerifyException(e11);
                }
            }
            if (assertionError != null) {
                throw assertionError;
            }
            return;
        } while (!this.returnOnSuccess);
    }

    public VerificationOverTimeImpl(long j11, VerificationMode verificationMode, boolean z11, Timer timer2) {
        this.pollingPeriodMillis = j11;
        this.delegate = verificationMode;
        this.returnOnSuccess = z11;
        this.timer = timer2;
    }
}
