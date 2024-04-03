package org.mockito.internal.verification;

import d40.a;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.internal.verification.api.VerificationDataInOrder;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

public class NoMoreInteractions implements VerificationMode, VerificationInOrderMode {
    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public void verify(VerificationData verificationData) {
        Invocation findFirstUnverified = InvocationsFinder.findFirstUnverified(verificationData.getAllInvocations());
        if (findFirstUnverified != null) {
            throw Reporter.noMoreInteractionsWanted(findFirstUnverified, verificationData.getAllInvocations());
        }
    }

    public void verifyInOrder(VerificationDataInOrder verificationDataInOrder) {
        Invocation findFirstUnverifiedInOrder = InvocationsFinder.findFirstUnverifiedInOrder(verificationDataInOrder.getOrderingContext(), verificationDataInOrder.getAllInvocations());
        if (findFirstUnverifiedInOrder != null) {
            throw Reporter.noMoreInteractionsWantedInOrder(findFirstUnverifiedInOrder);
        }
    }
}
