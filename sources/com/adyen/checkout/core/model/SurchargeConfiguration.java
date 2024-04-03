package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.SurchargeConfigurationImpl;

@ProvidedBy(SurchargeConfigurationImpl.class)
public interface SurchargeConfiguration extends Configuration {
    @NonNull
    String getSurchargeCurrencyCode();

    long getSurchargeFinalAmount();

    long getSurchargeFixedCost();

    long getSurchargeTotalCost();

    int getSurchargeVariableCost();
}
