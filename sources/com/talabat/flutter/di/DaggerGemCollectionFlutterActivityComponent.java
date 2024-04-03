package com.talabat.flutter.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.flutter.GemCollectionFlutterActivity;
import com.talabat.flutter.GemCollectionFlutterActivity_MembersInjector;
import com.talabat.flutter.di.GemCollectionFlutterActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGemCollectionFlutterActivityComponent {

    public static final class Factory implements GemCollectionFlutterActivityComponent.Factory {
        private Factory() {
        }

        public GemCollectionFlutterActivityComponent create(NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new GemCollectionFlutterActivityComponentImpl(navigationCoreLibApi, deepLinkCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class GemCollectionFlutterActivityComponentImpl implements GemCollectionFlutterActivityComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final GemCollectionFlutterActivityComponentImpl gemCollectionFlutterActivityComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;

        private GemCollectionFlutterActivityComponentImpl(NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.gemCollectionFlutterActivityComponentImpl = this;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private GemCollectionFlutterActivity injectGemCollectionFlutterActivity(GemCollectionFlutterActivity gemCollectionFlutterActivity) {
            GemCollectionFlutterActivity_MembersInjector.injectNavigator(gemCollectionFlutterActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            GemCollectionFlutterActivity_MembersInjector.injectDeepLinkNavigator(gemCollectionFlutterActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            GemCollectionFlutterActivity_MembersInjector.injectFeatureFlag(gemCollectionFlutterActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return gemCollectionFlutterActivity;
        }

        public void inject(GemCollectionFlutterActivity gemCollectionFlutterActivity) {
            injectGemCollectionFlutterActivity(gemCollectionFlutterActivity);
        }
    }

    private DaggerGemCollectionFlutterActivityComponent() {
    }

    public static GemCollectionFlutterActivityComponent.Factory factory() {
        return new Factory();
    }
}
