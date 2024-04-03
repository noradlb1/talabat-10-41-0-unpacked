package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

class SddCheckoutMethod extends CheckoutMethod {
    public SddCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new SepaDirectDebitHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }
}
