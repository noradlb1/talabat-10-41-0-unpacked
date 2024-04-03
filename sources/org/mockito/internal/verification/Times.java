package org.mockito.internal.verification;

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

public class Times implements VerificationInOrderMode, VerificationMode {

    /* renamed from: a  reason: collision with root package name */
    public final int f63277a;

    public Times(int i11) {
        if (i11 >= 0) {
            this.f63277a = i11;
            return;
        }
        throw new MockitoException("Negative value is not allowed here");
    }

    public VerificationMode description(String str) {
        return VerificationModeFactory.description(this, str);
    }

    public String toString() {
        return "Wanted invocations count: " + this.f63277a;
    }

    public void verify(VerificationData verificationData) {
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        MatchableInvocation target = verificationData.getTarget();
        if (this.f63277a > 0) {
            MissingInvocationChecker.checkMissingInvocation(verificationData.getAllInvocations(), verificationData.getTarget());
        }
        NumberOfInvocationsChecker.checkNumberOfInvocations(allInvocations, target, this.f63277a);
    }

    public void verifyInOrder(VerificationDataInOrder verificationDataInOrder) {
        List<Invocation> allInvocations = verificationDataInOrder.getAllInvocations();
        MatchableInvocation wanted = verificationDataInOrder.getWanted();
        if (this.f63277a > 0) {
            MissingInvocationChecker.checkMissingInvocation(allInvocations, wanted, verificationDataInOrder.getOrderingContext());
        }
        NumberOfInvocationsChecker.checkNumberOfInvocations(allInvocations, wanted, this.f63277a, verificationDataInOrder.getOrderingContext());
    }
}
