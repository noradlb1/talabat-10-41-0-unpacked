package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;

public interface CheckoutMethodPickerListener {
    boolean isCheckoutMethodDeletable(@NonNull CheckoutMethod checkoutMethod);

    void onCheckoutMethodDelete(@NonNull CheckoutMethod checkoutMethod);

    void onCheckoutMethodSelected(@NonNull CheckoutMethod checkoutMethod);

    void onClearSelection();
}
