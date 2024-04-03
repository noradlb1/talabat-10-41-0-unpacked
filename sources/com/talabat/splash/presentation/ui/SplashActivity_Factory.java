package com.talabat.splash.presentation.ui;

import androidx.lifecycle.ViewModelProvider;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.splash.core.navigation.Navigator;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SplashActivity_Factory implements Factory<SplashActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PresentationUtils> presentationUtilsProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SplashActivity_Factory(Provider<ViewModelProvider.Factory> provider, Provider<Navigator> provider2, Provider<PresentationUtils> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5, Provider<IObservabilityManager> provider6) {
        this.viewModelFactoryProvider = provider;
        this.navigatorProvider = provider2;
        this.presentationUtilsProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.deepLinkNavigatorProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static SplashActivity_Factory create(Provider<ViewModelProvider.Factory> provider, Provider<Navigator> provider2, Provider<PresentationUtils> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5, Provider<IObservabilityManager> provider6) {
        return new SplashActivity_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SplashActivity newInstance() {
        return new SplashActivity();
    }

    public SplashActivity get() {
        SplashActivity newInstance = newInstance();
        SplashActivity_MembersInjector.injectViewModelFactory(newInstance, this.viewModelFactoryProvider.get());
        SplashActivity_MembersInjector.injectNavigator(newInstance, this.navigatorProvider.get());
        SplashActivity_MembersInjector.injectPresentationUtils(newInstance, this.presentationUtilsProvider.get());
        SplashActivity_MembersInjector.injectTalabatFeatureFlag(newInstance, this.talabatFeatureFlagProvider.get());
        SplashActivity_MembersInjector.injectDeepLinkNavigator(newInstance, this.deepLinkNavigatorProvider.get());
        SplashActivity_MembersInjector.injectObservabilityManager(newInstance, this.observabilityManagerProvider.get());
        return newInstance;
    }
}
