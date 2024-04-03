package com.adyen.checkout.core;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.Authentication;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentResultCode;
import java.util.List;

public interface AuthenticationDetails extends Parcelable {
    @NonNull
    <T extends Authentication> T getAuthentication(@NonNull Class<T> cls) throws CheckoutException;

    @NonNull
    List<InputDetail> getInputDetails();

    @NonNull
    String getPaymentMethodType();

    @NonNull
    PaymentResultCode getResultCode();
}
