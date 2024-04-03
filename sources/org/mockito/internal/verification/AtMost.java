package org.mockito.internal.verification;

import d40.a;
import java.util.Iterator;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.verification.VerificationMode;

public class AtMost implements VerificationMode {
    private final int maxNumberOfInvocations;

    public AtMost(int i11) {
        if (i11 >= 0) {
            this.maxNumberOfInvocations = i11;
            return;
        }
        throw new MockitoException("Negative value is not allowed here");
    }

    private void removeAlreadyVerified(List<Invocation> list) {
        Iterator<Invocation> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isVerified()) {
                it.remove();
            }
        }
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public String toString() {
        return "Wanted invocations count: at most " + this.maxNumberOfInvocations;
    }

    public void verify(VerificationData verificationData) {
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        MatchableInvocation target = verificationData.getTarget();
        List<Invocation> findInvocations = InvocationsFinder.findInvocations(allInvocations, target);
        int size = findInvocations.size();
        int i11 = this.maxNumberOfInvocations;
        if (size <= i11) {
            removeAlreadyVerified(findInvocations);
            InvocationMarker.markVerified(findInvocations, target);
            return;
        }
        throw Reporter.wantedAtMostX(i11, size);
    }
}
