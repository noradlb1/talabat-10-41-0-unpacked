package org.mockito.internal.verification;

import d40.a;
import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.verification.VerificationMode;

public class Only implements VerificationMode {
    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public String toString() {
        return "Wanted invocations count: 1 and no other method invoked";
    }

    public void verify(VerificationData verificationData) {
        MatchableInvocation target = verificationData.getTarget();
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        List<Invocation> findInvocations = InvocationsFinder.findInvocations(allInvocations, target);
        if (allInvocations.size() != 1 && !findInvocations.isEmpty()) {
            throw Reporter.noMoreInteractionsWanted(InvocationsFinder.findFirstUnverified(allInvocations), allInvocations);
        } else if (allInvocations.size() != 1 || findInvocations.isEmpty()) {
            throw Reporter.wantedButNotInvoked(target);
        } else {
            InvocationMarker.markVerified(findInvocations.get(0), target);
        }
    }
}
