package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.RedirectDetails;
import com.adyen.checkout.core.handler.RedirectHandler;
import com.adyen.checkout.core.internal.BaseManager;

final class RedirectManager extends BaseManager<RedirectHandler, RedirectDetails> {
    public RedirectManager(@NonNull BaseManager.Listener listener) {
        super(listener);
    }

    /* renamed from: f */
    public void d(@NonNull RedirectHandler redirectHandler, @NonNull RedirectDetails redirectDetails) {
        redirectHandler.onRedirectRequired(redirectDetails);
    }
}
