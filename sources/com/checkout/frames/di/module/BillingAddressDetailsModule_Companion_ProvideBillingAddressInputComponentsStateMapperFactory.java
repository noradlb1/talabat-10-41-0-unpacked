package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory implements Factory<Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState>> {
    private final Provider<Mapper<InputComponentStyle, InputComponentState>> inputComponentStateMapperProvider;

    public BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory(Provider<Mapper<InputComponentStyle, InputComponentState>> provider) {
        this.inputComponentStateMapperProvider = provider;
    }

    public static BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory create(Provider<Mapper<InputComponentStyle, InputComponentState>> provider) {
        return new BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory(provider);
    }

    public static Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState> provideBillingAddressInputComponentsStateMapper(Mapper<InputComponentStyle, InputComponentState> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(BillingAddressDetailsModule.Companion.provideBillingAddressInputComponentsStateMapper(mapper));
    }

    public Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState> get() {
        return provideBillingAddressInputComponentsStateMapper(this.inputComponentStateMapperProvider.get());
    }
}
