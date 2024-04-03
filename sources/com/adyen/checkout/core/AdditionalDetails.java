package com.adyen.checkout.core;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.RedirectData;
import java.util.List;

public interface AdditionalDetails extends Parcelable {
    @NonNull
    List<InputDetail> getInputDetails();

    @NonNull
    String getPaymentMethodType();

    @NonNull
    <T extends RedirectData> T getRedirectData(@NonNull Class<T> cls) throws CheckoutException;
}
