package org.mockito.internal.verification;

import d40.a;
import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

public class NoInteractions implements VerificationMode {
    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public void verify(VerificationData verificationData) {
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        if (!allInvocations.isEmpty()) {
            throw Reporter.noInteractionsWanted(allInvocations.get(0).getMock(), allInvocations);
        }
    }
}
