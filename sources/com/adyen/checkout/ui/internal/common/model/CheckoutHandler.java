package com.adyen.checkout.ui.internal.common.model;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.ui.internal.common.fragment.CheckoutDetailsFragment;

public interface CheckoutHandler extends CheckoutSessionProvider {
    void handleWithPaymentMethodHandler(@NonNull PaymentMethodHandler paymentMethodHandler);

    void presentDetailsActivity(@NonNull Intent intent);

    void presentDetailsFragment(@NonNull CheckoutDetailsFragment checkoutDetailsFragment);
}
