package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.RedirectDetails;

public interface RedirectHandler {
    void onRedirectRequired(@NonNull RedirectDetails redirectDetails);
}
