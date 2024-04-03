package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.KlarnaConfigurationImpl;

@ProvidedBy(KlarnaConfigurationImpl.class)
public interface KlarnaConfiguration extends Configuration {
    @NonNull
    String getShopperInfoSsnLookupUrl();
}
