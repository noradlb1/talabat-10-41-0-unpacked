package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.AuthenticationDetails;
import com.adyen.checkout.core.handler.AuthenticationHandler;
import com.adyen.checkout.core.internal.BaseManager;

final class AuthenticationManager extends BaseManager<AuthenticationHandler, AuthenticationDetails> {
    public AuthenticationManager(@NonNull BaseManager.Listener listener) {
        super(listener);
    }

    /* renamed from: f */
    public void d(@NonNull AuthenticationHandler authenticationHandler, @NonNull AuthenticationDetails authenticationDetails) {
        authenticationHandler.onAuthenticationDetailsRequired(authenticationDetails);
    }
}
