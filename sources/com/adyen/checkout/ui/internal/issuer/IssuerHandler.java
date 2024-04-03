package com.adyen.checkout.ui.internal.issuer;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.IssuerDetails;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;

public final class IssuerHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            return true;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            InputDetail findByKey;
            List<Item> items;
            List<InputDetail> inputDetails = paymentMethod.getInputDetails();
            if (inputDetails == null || (findByKey = InputDetailImpl.findByKey(inputDetails, IssuerDetails.KEY_ISSUER)) == null || !inputDetails.remove(findByKey) || (items = findByKey.getItems()) == null || items.isEmpty()) {
                return false;
            }
            for (InputDetail isOptional : inputDetails) {
                if (!isOptional.isOptional()) {
                    return false;
                }
            }
            return true;
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public IssuerHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        activity.finishActivity(i11);
        activity.startActivityForResult(IssuerDetailsActivity.newIntent(activity, this.mPaymentReference, this.mPaymentMethod), i11);
    }
}
