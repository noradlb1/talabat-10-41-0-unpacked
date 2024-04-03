package com.talabat.feature.ridertips.presentation.view;

import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RiderTipView_MembersInjector implements MembersInjector<RiderTipView> {
    private final Provider<RiderTipViewModelFactory> factoryProvider;

    public RiderTipView_MembersInjector(Provider<RiderTipViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<RiderTipView> create(Provider<RiderTipViewModelFactory> provider) {
        return new RiderTipView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.ridertips.presentation.view.RiderTipView.factory")
    public static void injectFactory(RiderTipView riderTipView, RiderTipViewModelFactory riderTipViewModelFactory) {
        riderTipView.factory = riderTipViewModelFactory;
    }

    public void injectMembers(RiderTipView riderTipView) {
        injectFactory(riderTipView, this.factoryProvider.get());
    }
}
