package com.adyen.checkout.ui.internal.openinvoice;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

public class OpenInvoiceCheckoutMethod extends CheckoutMethod {
    public OpenInvoiceCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new OpenInvoiceHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }
}
