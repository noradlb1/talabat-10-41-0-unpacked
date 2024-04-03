package com.adyen.checkout.ui.internal.paypal;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.StoredDetails;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

abstract class PayPalCheckoutMethod extends CheckoutMethod {

    public static final class Default extends PayPalCheckoutMethod {
        public Default(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            super(application, paymentMethod);
        }
    }

    public static final class OneClick extends PayPalCheckoutMethod {
        public OneClick(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            super(application, paymentMethod);
        }

        @Nullable
        public String getSecondaryText() {
            String str;
            StoredDetails storedDetails = getPaymentMethod().getStoredDetails();
            if (storedDetails != null) {
                str = storedDetails.getEmailAddress();
            } else {
                str = null;
            }
            if (str != null) {
                return str;
            }
            return super.getSecondaryText();
        }
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new PayPalHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }

    private PayPalCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }
}
