package com.talabat.feature.darkstorestooltip.presentation;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShown;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TooltipViewController_Factory implements Factory<TooltipViewController> {
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<SetTooltipShown> setTooltipShownProvider;
    private final Provider<WasTooltipAlreadyShown> wasTooltipAlreadyShownProvider;

    public TooltipViewController_Factory(Provider<WasTooltipAlreadyShown> provider, Provider<SetTooltipShown> provider2, Provider<RxSchedulersFactory> provider3) {
        this.wasTooltipAlreadyShownProvider = provider;
        this.setTooltipShownProvider = provider2;
        this.rxSchedulersFactoryProvider = provider3;
    }

    public static TooltipViewController_Factory create(Provider<WasTooltipAlreadyShown> provider, Provider<SetTooltipShown> provider2, Provider<RxSchedulersFactory> provider3) {
        return new TooltipViewController_Factory(provider, provider2, provider3);
    }

    public static TooltipViewController newInstance(WasTooltipAlreadyShown wasTooltipAlreadyShown, SetTooltipShown setTooltipShown, RxSchedulersFactory rxSchedulersFactory) {
        return new TooltipViewController(wasTooltipAlreadyShown, setTooltipShown, rxSchedulersFactory);
    }

    public TooltipViewController get() {
        return newInstance(this.wasTooltipAlreadyShownProvider.get(), this.setTooltipShownProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
