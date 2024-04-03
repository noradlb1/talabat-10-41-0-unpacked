package org.mockito.internal.verification;

import d40.a;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

public class Description implements VerificationMode {
    private final String description;
    private final VerificationMode verification;

    public Description(VerificationMode verificationMode, String str) {
        this.verification = verificationMode;
        this.description = str;
    }

    public /* synthetic */ VerificationMode description(String str) {
        return a.a(this, str);
    }

    public void verify(VerificationData verificationData) {
        try {
            this.verification.verify(verificationData);
        } catch (AssertionError e11) {
            throw new MockitoAssertionError(e11, this.description);
        }
    }
}
