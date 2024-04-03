package com.adyen.checkout.ui.internal.googlepay;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.googlepay.GooglePayHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

final class GooglePayCheckoutMethod extends CheckoutMethod {
    public GooglePayCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new GooglePayHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }
}
