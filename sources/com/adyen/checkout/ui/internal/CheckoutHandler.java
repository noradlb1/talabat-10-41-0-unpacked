package com.adyen.checkout.ui.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.StartPaymentParameters;
import com.adyen.checkout.ui.internal.common.activity.CheckoutActivity;

public final class CheckoutHandler implements PaymentMethodHandler {
    private final StartPaymentParameters mPaymentParameters;

    public CheckoutHandler(@NonNull StartPaymentParameters startPaymentParameters) {
        this.mPaymentParameters = startPaymentParameters;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        activity.finishActivity(i11);
        activity.startActivityForResult(CheckoutActivity.newIntent(activity, this.mPaymentParameters.getPaymentReference()), i11);
        activity.overridePendingTransition(0, 0);
    }
}
