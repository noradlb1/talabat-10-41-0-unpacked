package com.talabat.flutter;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GemCollectionFlutterActivity_MembersInjector implements MembersInjector<GemCollectionFlutterActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<Navigator> navigatorProvider;

    public GemCollectionFlutterActivity_MembersInjector(Provider<Navigator> provider, Provider<DeepLinkNavigator> provider2, Provider<ITalabatFeatureFlag> provider3) {
        this.navigatorProvider = provider;
        this.deepLinkNavigatorProvider = provider2;
        this.featureFlagProvider = provider3;
    }

    public static MembersInjector<GemCollectionFlutterActivity> create(Provider<Navigator> provider, Provider<DeepLinkNavigator> provider2, Provider<ITalabatFeatureFlag> provider3) {
        return new GemCollectionFlutterActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.flutter.GemCollectionFlutterActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(GemCollectionFlutterActivity gemCollectionFlutterActivity, DeepLinkNavigator deepLinkNavigator) {
        gemCollectionFlutterActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.flutter.GemCollectionFlutterActivity.featureFlag")
    public static void injectFeatureFlag(GemCollectionFlutterActivity gemCollectionFlutterActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        gemCollectionFlutterActivity.featureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.flutter.GemCollectionFlutterActivity.navigator")
    public static void injectNavigator(GemCollectionFlutterActivity gemCollectionFlutterActivity, Navigator navigator) {
        gemCollectionFlutterActivity.navigator = navigator;
    }

    public void injectMembers(GemCollectionFlutterActivity gemCollectionFlutterActivity) {
        injectNavigator(gemCollectionFlutterActivity, this.navigatorProvider.get());
        injectDeepLinkNavigator(gemCollectionFlutterActivity, this.deepLinkNavigatorProvider.get());
        injectFeatureFlag(gemCollectionFlutterActivity, this.featureFlagProvider.get());
    }
}
