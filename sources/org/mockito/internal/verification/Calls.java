package org.mockito.internal.verification;

import d40.a;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.internal.verification.api.VerificationDataInOrder;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.internal.verification.checkers.MissingInvocationChecker;
import org.mockito.internal.verification.checkers.NumberOfInvocationsChecker;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.verification.VerificationMode;

public class Calls implements VerificationMode, VerificationInOrderMode {

    /* renamed from: a  reason: collision with root package name */
    public final int f63275a;

    public Calls(int i11) {
        if (i11 > 0) {
            this.f63275a = i11;
            return;
        }
        throw new MockitoException("Negative and zero values are not allowed here");
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public String toString() {
        return "Wanted invocations count (non-greedy): " + this.f63275a;
    }

    public void verify(VerificationData verificationData) {
        throw new MockitoException("calls is only intended to work with InOrder");
    }

    public void verifyInOrder(VerificationDataInOrder verificationDataInOrder) {
        List<Invocation> allInvocations = verificationDataInOrder.getAllInvocations();
        MatchableInvocation wanted = verificationDataInOrder.getWanted();
        MissingInvocationChecker.checkMissingInvocation(allInvocations, wanted, verificationDataInOrder.getOrderingContext());
        NumberOfInvocationsChecker.checkNumberOfInvocationsNonGreedy(allInvocations, wanted, this.f63275a, verificationDataInOrder.getOrderingContext());
    }
}
