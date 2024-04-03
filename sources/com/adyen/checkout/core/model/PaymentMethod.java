package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.TxVariantProvider;
import com.adyen.checkout.core.CheckoutException;
import java.util.List;

public interface PaymentMethod extends TxVariantProvider, Parcelable {
    @NonNull
    <T extends Configuration> T getConfiguration(@NonNull Class<T> cls) throws CheckoutException;

    @Nullable
    PaymentMethod getGroup();

    @Nullable
    List<InputDetail> getInputDetails();

    @NonNull
    String getName();

    @Nullable
    StoredDetails getStoredDetails();

    @NonNull
    String getType();
}
