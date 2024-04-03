package com.talabat.feature.darkstorescarrierbag.presentation;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEvent;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShown;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DarkstoresCarrierBagViewModel_Factory implements Factory<DarkstoresCarrierBagViewModel> {
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<SendDarkstoresCarrierBagEvent> sendDarkstoresCarrierBagEventProvider;
    private final Provider<SetDarkstoresCarrierBagFakeDoorTestShown> setDarkstoresCarrierBagFakeDoorTestShownProvider;
    private final Provider<ShouldShowDarkstoresCarrierBagFakeDoorTest> shouldShowDarkstoresCarrierBagFakeDoorTestProvider;
    private final Provider<String> vendorCodeProvider;

    public DarkstoresCarrierBagViewModel_Factory(Provider<ShouldShowDarkstoresCarrierBagFakeDoorTest> provider, Provider<SetDarkstoresCarrierBagFakeDoorTestShown> provider2, Provider<SendDarkstoresCarrierBagEvent> provider3, Provider<RxSchedulersFactory> provider4, Provider<String> provider5) {
        this.shouldShowDarkstoresCarrierBagFakeDoorTestProvider = provider;
        this.setDarkstoresCarrierBagFakeDoorTestShownProvider = provider2;
        this.sendDarkstoresCarrierBagEventProvider = provider3;
        this.rxSchedulersFactoryProvider = provider4;
        this.vendorCodeProvider = provider5;
    }

    public static DarkstoresCarrierBagViewModel_Factory create(Provider<ShouldShowDarkstoresCarrierBagFakeDoorTest> provider, Provider<SetDarkstoresCarrierBagFakeDoorTestShown> provider2, Provider<SendDarkstoresCarrierBagEvent> provider3, Provider<RxSchedulersFactory> provider4, Provider<String> provider5) {
        return new DarkstoresCarrierBagViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DarkstoresCarrierBagViewModel newInstance(ShouldShowDarkstoresCarrierBagFakeDoorTest shouldShowDarkstoresCarrierBagFakeDoorTest, SetDarkstoresCarrierBagFakeDoorTestShown setDarkstoresCarrierBagFakeDoorTestShown, SendDarkstoresCarrierBagEvent sendDarkstoresCarrierBagEvent, RxSchedulersFactory rxSchedulersFactory, String str) {
        return new DarkstoresCarrierBagViewModel(shouldShowDarkstoresCarrierBagFakeDoorTest, setDarkstoresCarrierBagFakeDoorTestShown, sendDarkstoresCarrierBagEvent, rxSchedulersFactory, str);
    }

    public DarkstoresCarrierBagViewModel get() {
        return newInstance(this.shouldShowDarkstoresCarrierBagFakeDoorTestProvider.get(), this.setDarkstoresCarrierBagFakeDoorTestShownProvider.get(), this.sendDarkstoresCarrierBagEventProvider.get(), this.rxSchedulersFactoryProvider.get(), this.vendorCodeProvider.get());
    }
}
