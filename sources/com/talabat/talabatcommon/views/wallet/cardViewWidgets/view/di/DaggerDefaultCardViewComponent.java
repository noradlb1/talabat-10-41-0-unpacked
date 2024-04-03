package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView_MembersInjector;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di.DefaultCardViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDefaultCardViewComponent {

    public static final class DefaultCardViewComponentImpl implements DefaultCardViewComponent {
        private final DefaultCardViewComponentImpl defaultCardViewComponentImpl;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private DefaultCardViewComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.defaultCardViewComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private DefaultCardView injectDefaultCardView(DefaultCardView defaultCardView) {
            DefaultCardView_MembersInjector.injectFeatureFlagRepo(defaultCardView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return defaultCardView;
        }

        public void inject(DefaultCardView defaultCardView) {
            injectDefaultCardView(defaultCardView);
        }
    }

    public static final class Factory implements DefaultCardViewComponent.Factory {
        private Factory() {
        }

        public DefaultCardViewComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new DefaultCardViewComponentImpl(featureFlagCoreLibApi);
        }
    }

    private DaggerDefaultCardViewComponent() {
    }

    public static DefaultCardViewComponent.Factory factory() {
        return new Factory();
    }
}
