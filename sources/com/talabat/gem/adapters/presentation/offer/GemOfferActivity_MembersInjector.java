package com.talabat.gem.adapters.presentation.offer;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GemOfferActivity_MembersInjector implements MembersInjector<GemOfferActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;

    public GemOfferActivity_MembersInjector(Provider<DeepLinkNavigator> provider) {
        this.deepLinkNavigatorProvider = provider;
    }

    public static MembersInjector<GemOfferActivity> create(Provider<DeepLinkNavigator> provider) {
        return new GemOfferActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.gem.adapters.presentation.offer.GemOfferActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(GemOfferActivity gemOfferActivity, DeepLinkNavigator deepLinkNavigator) {
        gemOfferActivity.deepLinkNavigator = deepLinkNavigator;
    }

    public void injectMembers(GemOfferActivity gemOfferActivity) {
        injectDeepLinkNavigator(gemOfferActivity, this.deepLinkNavigatorProvider.get());
    }
}
