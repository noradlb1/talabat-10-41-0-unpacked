package org.mockito.internal.verification;

import d40.a;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

public abstract class VerificationWrapper<WrapperT extends VerificationMode> implements VerificationMode {

    /* renamed from: a  reason: collision with root package name */
    public final WrapperT f63278a;

    public VerificationWrapper(WrapperT wrappert) {
        this.f63278a = wrappert;
    }

    public abstract VerificationMode a(VerificationMode verificationMode);

    public VerificationMode atLeast(int i11) {
        return a(VerificationModeFactory.atLeast(i11));
    }

    public VerificationMode atLeastOnce() {
        return a(VerificationModeFactory.atLeastOnce());
    }

    public VerificationMode atMost(int i11) {
        return a(VerificationModeFactory.atMost(i11));
    }

    public VerificationMode atMostOnce() {
        return a(VerificationModeFactory.atMostOnce());
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public VerificationMode never() {
        return a(VerificationModeFactory.atMost(0));
    }

    public VerificationMode only() {
        return a(VerificationModeFactory.only());
    }

    public VerificationMode times(int i11) {
        return a(VerificationModeFactory.times(i11));
    }

    public void verify(VerificationData verificationData) {
        this.f63278a.verify(verificationData);
    }
}
