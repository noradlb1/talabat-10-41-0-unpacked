package org.mockito.internal.verification;

import d40.a;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.InOrderImpl;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.verification.VerificationMode;

public class VerificationWrapperInOrderWrapper implements VerificationMode {
    private final VerificationMode delegate;

    public VerificationWrapperInOrderWrapper(VerificationWrapper<?> verificationWrapper, InOrderImpl inOrderImpl) {
        this.delegate = verificationWrapper.a(wrapInOrder(verificationWrapper, verificationWrapper.f63278a, inOrderImpl));
    }

    private VerificationMode wrapInOrder(VerificationWrapper<?> verificationWrapper, VerificationMode verificationMode, InOrderImpl inOrderImpl) {
        if (verificationMode instanceof VerificationInOrderMode) {
            return new InOrderWrapper((VerificationInOrderMode) verificationMode, inOrderImpl);
        }
        if (verificationMode instanceof VerificationOverTimeImpl) {
            VerificationOverTimeImpl verificationOverTimeImpl = (VerificationOverTimeImpl) verificationMode;
            if (verificationOverTimeImpl.isReturnOnSuccess()) {
                return new VerificationOverTimeImpl(verificationOverTimeImpl.getPollingPeriodMillis(), verificationOverTimeImpl.getTimer().duration(), wrapInOrder(verificationWrapper, verificationOverTimeImpl.getDelegate(), inOrderImpl), verificationOverTimeImpl.isReturnOnSuccess());
            }
        }
        throw new MockitoException(verificationMode.getClass().getSimpleName() + " is not implemented to work with InOrder wrapped inside a " + verificationWrapper.getClass().getSimpleName());
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public void verify(VerificationData verificationData) {
        this.delegate.verify(verificationData);
    }
}
