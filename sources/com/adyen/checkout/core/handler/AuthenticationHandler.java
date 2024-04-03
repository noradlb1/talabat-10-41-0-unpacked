package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.AuthenticationDetails;

public interface AuthenticationHandler {
    void onAuthenticationDetailsRequired(@NonNull AuthenticationDetails authenticationDetails);
}
