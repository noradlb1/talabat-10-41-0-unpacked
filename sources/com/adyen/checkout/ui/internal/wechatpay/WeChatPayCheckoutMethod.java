package com.adyen.checkout.ui.internal.wechatpay;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.wechatpay.WeChatPayHandler;

public class WeChatPayCheckoutMethod extends CheckoutMethod {
    public WeChatPayCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }

    public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
        checkoutHandler.handleWithPaymentMethodHandler(new WeChatPayHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
    }
}
