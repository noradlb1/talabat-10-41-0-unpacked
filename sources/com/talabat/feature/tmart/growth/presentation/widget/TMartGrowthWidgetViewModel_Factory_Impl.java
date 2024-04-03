package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
public final class TMartGrowthWidgetViewModel_Factory_Impl implements TMartGrowthWidgetViewModel.Factory {
    private final C0479TMartGrowthWidgetViewModel_Factory delegateFactory;

    public TMartGrowthWidgetViewModel_Factory_Impl(C0479TMartGrowthWidgetViewModel_Factory tMartGrowthWidgetViewModel_Factory) {
        this.delegateFactory = tMartGrowthWidgetViewModel_Factory;
    }

    public TMartGrowthWidgetViewModel create(String str, TMartGrowthScreen tMartGrowthScreen) {
        return this.delegateFactory.get(str, tMartGrowthScreen);
    }

    public static Provider<TMartGrowthWidgetViewModel.Factory> create(C0479TMartGrowthWidgetViewModel_Factory tMartGrowthWidgetViewModel_Factory) {
        return InstanceFactory.create(new TMartGrowthWidgetViewModel_Factory_Impl(tMartGrowthWidgetViewModel_Factory));
    }
}
