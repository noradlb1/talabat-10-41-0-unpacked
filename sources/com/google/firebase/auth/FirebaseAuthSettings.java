package com.google.firebase.auth;

import androidx.annotation.Nullable;

public abstract class FirebaseAuthSettings {
    public abstract void forceRecaptchaFlowForTesting(boolean z11);

    public abstract void setAppVerificationDisabledForTesting(boolean z11);

    public abstract void setAutoRetrievedSmsCodeForPhoneNumber(@Nullable String str, @Nullable String str2);
}
