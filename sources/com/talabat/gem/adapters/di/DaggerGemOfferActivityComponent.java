package com.talabat.gem.adapters.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.gem.adapters.di.GemOfferActivityComponent;
import com.talabat.gem.adapters.presentation.offer.GemOfferActivity;
import com.talabat.gem.adapters.presentation.offer.GemOfferActivity_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGemOfferActivityComponent {

    public static final class Factory implements GemOfferActivityComponent.Factory {
        private Factory() {
        }

        public GemOfferActivityComponent create(DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new GemOfferActivityComponentImpl(deepLinkCoreLibApi);
        }
    }

    public static final class GemOfferActivityComponentImpl implements GemOfferActivityComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final GemOfferActivityComponentImpl gemOfferActivityComponentImpl;

        private GemOfferActivityComponentImpl(DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.gemOfferActivityComponentImpl = this;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private GemOfferActivity injectGemOfferActivity(GemOfferActivity gemOfferActivity) {
            GemOfferActivity_MembersInjector.injectDeepLinkNavigator(gemOfferActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return gemOfferActivity;
        }

        public void inject(GemOfferActivity gemOfferActivity) {
            injectGemOfferActivity(gemOfferActivity);
        }
    }

    private DaggerGemOfferActivityComponent() {
    }

    public static GemOfferActivityComponent.Factory factory() {
        return new Factory();
    }
}
