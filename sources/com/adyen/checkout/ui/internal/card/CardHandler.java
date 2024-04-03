package com.adyen.checkout.ui.internal.card;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.CardDetails;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;

public final class CardHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull final Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            if (paymentSession.getPublicKey() != null) {
                return true;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    Toast.makeText(application, "Public key for card payments has not been generated.", 1).show();
                }
            });
            return false;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            if ("card".equals(paymentMethod.getType())) {
                return true;
            }
            List<InputDetail> inputDetails = paymentMethod.getInputDetails();
            if (inputDetails == null) {
                return false;
            }
            InputDetail findByKey = InputDetailImpl.findByKey(inputDetails, CardDetails.KEY_ENCRYPTED_CARD_NUMBER);
            InputDetail findByKey2 = InputDetailImpl.findByKey(inputDetails, CardDetails.KEY_ENCRYPTED_EXPIRY_MONTH);
            InputDetail findByKey3 = InputDetailImpl.findByKey(inputDetails, CardDetails.KEY_ENCRYPTED_EXPIRY_YEAR);
            if (findByKey == null || findByKey2 == null || findByKey3 == null || !inputDetails.remove(findByKey) || !inputDetails.remove(findByKey2) || !inputDetails.remove(findByKey3)) {
                return false;
            }
            for (InputDetail next : inputDetails) {
                String key = next.getKey();
                if (!CardDetails.KEY_ENCRYPTED_SECURITY_CODE.equals(key) && !"holderName".equals(key) && !"telephoneNumber".equals(key) && !CardDetails.KEY_INSTALLMENTS.equals(key) && !"storeDetails".equals(key) && !next.isOptional()) {
                    return false;
                }
            }
            return true;
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public CardHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        activity.finishActivity(i11);
        activity.startActivityForResult(CardDetailsActivity.newIntent(activity, this.mPaymentReference, this.mPaymentMethod), i11);
    }
}
