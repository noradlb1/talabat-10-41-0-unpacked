package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory implements Factory<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState>> {
    private final Provider<Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState>> billingAddressInputComponentStateMapperProvider;

    public BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory(Provider<Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState>> provider) {
        this.billingAddressInputComponentStateMapperProvider = provider;
    }

    public static BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory create(Provider<Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState>> provider) {
        return new BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory(provider);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.checkout.base.mapper.Mapper<com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle, com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState>, com.checkout.base.mapper.Mapper] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.checkout.base.usecase.UseCase<com.checkout.frames.style.screen.BillingAddressDetailsStyle, com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState> provideBillingAddressInputComponentsStateUseCase(com.checkout.base.mapper.Mapper<com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle, com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState> r1) {
        /*
            com.checkout.frames.di.module.BillingAddressDetailsModule$Companion r0 = com.checkout.frames.di.module.BillingAddressDetailsModule.Companion
            com.checkout.base.usecase.UseCase r1 = r0.provideBillingAddressInputComponentsStateUseCase(r1)
            java.lang.Object r1 = dagger.internal.Preconditions.checkNotNullFromProvides(r1)
            com.checkout.base.usecase.UseCase r1 = (com.checkout.base.usecase.UseCase) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.di.module.BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory.provideBillingAddressInputComponentsStateUseCase(com.checkout.base.mapper.Mapper):com.checkout.base.usecase.UseCase");
    }

    public UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> get() {
        return provideBillingAddressInputComponentsStateUseCase(this.billingAddressInputComponentStateMapperProvider.get());
    }
}
