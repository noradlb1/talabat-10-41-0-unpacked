package com.adyen.checkout.core.internal.model;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import com.adyen.checkout.core.model.PaymentMethodDetails;

public abstract class AdditionalPaymentMethodDetails extends PaymentMethodDetails {
    public AdditionalPaymentMethodDetails() {
    }

    public static void finalize(@NonNull AdditionalPaymentMethodDetails additionalPaymentMethodDetails, @NonNull PaymentInitiationResponse.DetailFields detailFields) throws CheckoutException {
        additionalPaymentMethodDetails.a(detailFields);
    }

    public abstract void a(@NonNull PaymentInitiationResponse.DetailFields detailFields) throws CheckoutException;

    public AdditionalPaymentMethodDetails(@NonNull Parcel parcel) {
        super(parcel);
    }
}
