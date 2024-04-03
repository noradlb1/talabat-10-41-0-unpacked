package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TMartGrowthWidgetView_MembersInjector implements MembersInjector<TMartGrowthWidgetView> {
    private final Provider<TMartGrowthWidgetViewModel.Factory> viewModelFactoryProvider;

    public TMartGrowthWidgetView_MembersInjector(Provider<TMartGrowthWidgetViewModel.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<TMartGrowthWidgetView> create(Provider<TMartGrowthWidgetViewModel.Factory> provider) {
        return new TMartGrowthWidgetView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetView.viewModelFactory")
    public static void injectViewModelFactory(TMartGrowthWidgetView tMartGrowthWidgetView, TMartGrowthWidgetViewModel.Factory factory) {
        tMartGrowthWidgetView.viewModelFactory = factory;
    }

    public void injectMembers(TMartGrowthWidgetView tMartGrowthWidgetView) {
        injectViewModelFactory(tMartGrowthWidgetView, this.viewModelFactoryProvider.get());
    }
}
