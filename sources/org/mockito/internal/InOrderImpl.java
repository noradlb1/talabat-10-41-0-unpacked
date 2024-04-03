package org.mockito.internal;

import java.util.ArrayList;
import java.util.List;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.InOrderContextImpl;
import org.mockito.internal.verification.InOrderWrapper;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.internal.verification.VerificationWrapper;
import org.mockito.internal.verification.VerificationWrapperInOrderWrapper;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

public class InOrderImpl implements InOrder, InOrderContext {
    private final InOrderContext inOrderContext;
    private final MockitoCore mockitoCore = new MockitoCore();
    private final List<Object> mocksToBeVerifiedInOrder;

    public InOrderImpl(List<?> list) {
        ArrayList arrayList = new ArrayList();
        this.mocksToBeVerifiedInOrder = arrayList;
        this.inOrderContext = new InOrderContextImpl();
        arrayList.addAll(list);
    }

    private boolean objectIsMockToBeVerified(Object obj) {
        for (Object obj2 : this.mocksToBeVerifiedInOrder) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    public List<Object> getMocksToBeVerifiedInOrder() {
        return this.mocksToBeVerifiedInOrder;
    }

    public boolean isVerified(Invocation invocation) {
        return this.inOrderContext.isVerified(invocation);
    }

    public void markVerified(Invocation invocation) {
        this.inOrderContext.markVerified(invocation);
    }

    public <T> T verify(T t11) {
        return verify(t11, VerificationModeFactory.times(1));
    }

    public void verifyNoMoreInteractions() {
        this.mockitoCore.verifyNoMoreInteractionsInOrder(this.mocksToBeVerifiedInOrder, this);
    }

    public <T> T verify(T t11, VerificationMode verificationMode) {
        if (t11 == null) {
            throw Reporter.nullPassedToVerify();
        } else if (!Mockito.mockingDetails(t11).isMock()) {
            throw Reporter.notAMockPassedToVerify(t11.getClass());
        } else if (!objectIsMockToBeVerified(t11)) {
            throw Reporter.inOrderRequiresFamiliarMock();
        } else if (verificationMode instanceof VerificationWrapper) {
            return this.mockitoCore.verify(t11, new VerificationWrapperInOrderWrapper((VerificationWrapper) verificationMode, this));
        } else {
            if (verificationMode instanceof VerificationInOrderMode) {
                return this.mockitoCore.verify(t11, new InOrderWrapper((VerificationInOrderMode) verificationMode, this));
            }
            throw new MockitoException(verificationMode.getClass().getSimpleName() + " is not implemented to work with InOrder");
        }
    }
}
