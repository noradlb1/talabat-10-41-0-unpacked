package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.AndroidPayConfigurationImpl;

@Deprecated
@ProvidedBy(AndroidPayConfigurationImpl.class)
public interface AndroidPayConfiguration extends Configuration {
    int getEnvironment();

    @NonNull
    String getMerchantName();

    @NonNull
    String getPublicKey();
}
