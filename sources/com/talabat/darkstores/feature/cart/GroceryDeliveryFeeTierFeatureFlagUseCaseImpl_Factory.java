package com.talabat.darkstores.feature.cart;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory implements Factory<GroceryDeliveryFeeTierFeatureFlagUseCaseImpl> {
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagProvider = provider;
    }

    public static GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory create(Provider<ITalabatFeatureFlag> provider) {
        return new GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory(provider);
    }

    public static GroceryDeliveryFeeTierFeatureFlagUseCaseImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GroceryDeliveryFeeTierFeatureFlagUseCaseImpl(iTalabatFeatureFlag);
    }

    public GroceryDeliveryFeeTierFeatureFlagUseCaseImpl get() {
        return newInstance(this.featureFlagProvider.get());
    }
}
