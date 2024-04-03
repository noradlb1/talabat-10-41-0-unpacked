package com.checkout.frames.component.country;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.component.country.CountryViewModel_Factory  reason: case insensitive filesystem */
public final class C0331CountryViewModel_Factory implements Factory<CountryViewModel> {
    private final Provider<Mapper<InputComponentStyle, InputComponentState>> inputComponentStateMapperProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> inputComponentStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<CountryComponentStyle> styleProvider;

    public C0331CountryViewModel_Factory(Provider<PaymentStateManager> provider, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider2, Provider<Mapper<InputComponentStyle, InputComponentState>> provider3, Provider<CountryComponentStyle> provider4) {
        this.paymentStateManagerProvider = provider;
        this.inputComponentStyleMapperProvider = provider2;
        this.inputComponentStateMapperProvider = provider3;
        this.styleProvider = provider4;
    }

    public static C0331CountryViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider2, Provider<Mapper<InputComponentStyle, InputComponentState>> provider3, Provider<CountryComponentStyle> provider4) {
        return new C0331CountryViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static CountryViewModel newInstance(PaymentStateManager paymentStateManager, Mapper<InputComponentStyle, InputComponentViewStyle> mapper, Mapper<InputComponentStyle, InputComponentState> mapper2, CountryComponentStyle countryComponentStyle) {
        return new CountryViewModel(paymentStateManager, mapper, mapper2, countryComponentStyle);
    }

    public CountryViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.inputComponentStyleMapperProvider.get(), this.inputComponentStateMapperProvider.get(), this.styleProvider.get());
    }
}
