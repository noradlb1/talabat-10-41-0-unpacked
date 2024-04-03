package org.mockito.internal.verification;

import org.mockito.verification.VerificationMode;

public final class VerificationModeFactory {
    private VerificationModeFactory() {
    }

    public static VerificationMode atLeast(int i11) {
        return new AtLeast(i11);
    }

    public static VerificationMode atLeastOnce() {
        return atLeast(1);
    }

    public static VerificationMode atMost(int i11) {
        return new AtMost(i11);
    }

    public static VerificationMode atMostOnce() {
        return atMost(1);
    }

    public static Calls calls(int i11) {
        return new Calls(i11);
    }

    public static VerificationMode description(VerificationMode verificationMode, String str) {
        return new Description(verificationMode, str);
    }

    public static NoInteractions noInteractions() {
        return new NoInteractions();
    }

    public static NoMoreInteractions noMoreInteractions() {
        return new NoMoreInteractions();
    }

    public static VerificationMode only() {
        return new Only();
    }

    public static Times times(int i11) {
        return new Times(i11);
    }
}
