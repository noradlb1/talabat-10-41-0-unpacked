package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory implements Factory<Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle>> {
    private final Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> inputComponentStyleMapperProvider;

    public BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory(Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider) {
        this.inputComponentStyleMapperProvider = provider;
    }

    public static BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory create(Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider) {
        return new BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory(provider);
    }

    public static Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> provideBillingAddressInputComponentsStyleMapper(Mapper<InputComponentStyle, InputComponentViewStyle> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(BillingAddressDetailsModule.Companion.provideBillingAddressInputComponentsStyleMapper(mapper));
    }

    public Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> get() {
        return provideBillingAddressInputComponentsStyleMapper(this.inputComponentStyleMapperProvider.get());
    }
}
