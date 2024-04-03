package com.adyen.checkout.ui.internal.giropay;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

class GiroPayCheckoutMethod extends CheckoutMethod {
    public GiroPayCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new GiroPayHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }
}
