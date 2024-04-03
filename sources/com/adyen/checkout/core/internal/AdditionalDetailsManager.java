package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.AdditionalDetails;
import com.adyen.checkout.core.handler.AdditionalDetailsHandler;
import com.adyen.checkout.core.internal.BaseManager;

final class AdditionalDetailsManager extends BaseManager<AdditionalDetailsHandler, AdditionalDetails> {
    public AdditionalDetailsManager(@NonNull BaseManager.Listener listener) {
        super(listener);
    }

    /* renamed from: f */
    public void d(@NonNull AdditionalDetailsHandler additionalDetailsHandler, @NonNull AdditionalDetails additionalDetails) {
        additionalDetailsHandler.onAdditionalDetailsRequired(additionalDetails);
    }
}
