package com.talabat.feature.tpro.presentation.welcome;

import com.talabat.core.navigation.domain.Navigator;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TProWelcomeBottomSheetFragment_MembersInjector implements MembersInjector<TProWelcomeBottomSheetFragment> {
    private final Provider<Navigator> navigatorProvider;

    public TProWelcomeBottomSheetFragment_MembersInjector(Provider<Navigator> provider) {
        this.navigatorProvider = provider;
    }

    public static MembersInjector<TProWelcomeBottomSheetFragment> create(Provider<Navigator> provider) {
        return new TProWelcomeBottomSheetFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment.navigator")
    public static void injectNavigator(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment, Navigator navigator) {
        tProWelcomeBottomSheetFragment.navigator = navigator;
    }

    public void injectMembers(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment) {
        injectNavigator(tProWelcomeBottomSheetFragment, this.navigatorProvider.get());
    }
}
