package com.talabat.feature.tpro.presentation.multiplan;

import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TProPlanSelectionFragment_MembersInjector implements MembersInjector<TProPlanSelectionFragment> {
    private final Provider<TProPlanSelectionViewModelFactory> viewModelFactoryProvider;

    public TProPlanSelectionFragment_MembersInjector(Provider<TProPlanSelectionViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<TProPlanSelectionFragment> create(Provider<TProPlanSelectionViewModelFactory> provider) {
        return new TProPlanSelectionFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment.viewModelFactory")
    public static void injectViewModelFactory(TProPlanSelectionFragment tProPlanSelectionFragment, TProPlanSelectionViewModelFactory tProPlanSelectionViewModelFactory) {
        tProPlanSelectionFragment.viewModelFactory = tProPlanSelectionViewModelFactory;
    }

    public void injectMembers(TProPlanSelectionFragment tProPlanSelectionFragment) {
        injectViewModelFactory(tProPlanSelectionFragment, this.viewModelFactoryProvider.get());
    }
}
