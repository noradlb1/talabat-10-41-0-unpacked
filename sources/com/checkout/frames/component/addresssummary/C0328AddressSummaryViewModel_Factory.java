package com.checkout.frames.component.addresssummary;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.component.addresssummary.AddressSummaryViewModel_Factory  reason: case insensitive filesystem */
public final class C0328AddressSummaryViewModel_Factory implements Factory<AddressSummaryViewModel> {
    private final Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState>> componentStateMapperProvider;
    private final Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle>> componentStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<AddressSummaryComponentStyle> styleProvider;

    public C0328AddressSummaryViewModel_Factory(Provider<AddressSummaryComponentStyle> provider, Provider<PaymentStateManager> provider2, Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState>> provider3, Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle>> provider4) {
        this.styleProvider = provider;
        this.paymentStateManagerProvider = provider2;
        this.componentStateMapperProvider = provider3;
        this.componentStyleMapperProvider = provider4;
    }

    public static C0328AddressSummaryViewModel_Factory create(Provider<AddressSummaryComponentStyle> provider, Provider<PaymentStateManager> provider2, Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState>> provider3, Provider<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle>> provider4) {
        return new C0328AddressSummaryViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static AddressSummaryViewModel newInstance(AddressSummaryComponentStyle addressSummaryComponentStyle, PaymentStateManager paymentStateManager, Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> mapper, Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> mapper2) {
        return new AddressSummaryViewModel(addressSummaryComponentStyle, paymentStateManager, mapper, mapper2);
    }

    public AddressSummaryViewModel get() {
        return newInstance(this.styleProvider.get(), this.paymentStateManagerProvider.get(), this.componentStateMapperProvider.get(), this.componentStyleMapperProvider.get());
    }
}
