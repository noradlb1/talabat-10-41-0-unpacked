package com.talabat.splash.presentation.ui;

import androidx.lifecycle.ViewModelProvider;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.splash.core.navigation.Navigator;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PresentationUtils> presentationUtilsProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SplashActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<Navigator> provider2, Provider<PresentationUtils> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5, Provider<IObservabilityManager> provider6) {
        this.viewModelFactoryProvider = provider;
        this.navigatorProvider = provider2;
        this.presentationUtilsProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.deepLinkNavigatorProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static MembersInjector<SplashActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<Navigator> provider2, Provider<PresentationUtils> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5, Provider<IObservabilityManager> provider6) {
        return new SplashActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(SplashActivity splashActivity, DeepLinkNavigator deepLinkNavigator) {
        splashActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.navigator")
    public static void injectNavigator(SplashActivity splashActivity, Navigator navigator) {
        splashActivity.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.observabilityManager")
    public static void injectObservabilityManager(SplashActivity splashActivity, IObservabilityManager iObservabilityManager) {
        splashActivity.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.presentationUtils")
    public static void injectPresentationUtils(SplashActivity splashActivity, PresentationUtils presentationUtils) {
        splashActivity.presentationUtils = presentationUtils;
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(SplashActivity splashActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        splashActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.splash.presentation.ui.SplashActivity.viewModelFactory")
    public static void injectViewModelFactory(SplashActivity splashActivity, ViewModelProvider.Factory factory) {
        splashActivity.viewModelFactory = factory;
    }

    public void injectMembers(SplashActivity splashActivity) {
        injectViewModelFactory(splashActivity, this.viewModelFactoryProvider.get());
        injectNavigator(splashActivity, this.navigatorProvider.get());
        injectPresentationUtils(splashActivity, this.presentationUtilsProvider.get());
        injectTalabatFeatureFlag(splashActivity, this.talabatFeatureFlagProvider.get());
        injectDeepLinkNavigator(splashActivity, this.deepLinkNavigatorProvider.get());
        injectObservabilityManager(splashActivity, this.observabilityManagerProvider.get());
    }
}
