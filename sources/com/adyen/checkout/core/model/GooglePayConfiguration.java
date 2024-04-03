package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.GooglePayConfigurationImpl;

@ProvidedBy(GooglePayConfigurationImpl.class)
public interface GooglePayConfiguration extends Configuration {
    int getEnvironment();

    @NonNull
    String getGateway();

    @NonNull
    String getGatewayMerchantId();
}
