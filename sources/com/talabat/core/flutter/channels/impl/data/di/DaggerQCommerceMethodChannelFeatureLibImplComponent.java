package com.talabat.core.flutter.channels.impl.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.impl.data.di.QCommerceMethodChannelFeatureLibImplComponent;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceChannelCallbackImpl;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerQCommerceMethodChannelFeatureLibImplComponent {

    public static final class Factory implements QCommerceMethodChannelFeatureLibImplComponent.Factory {
        private Factory() {
        }

        public QCommerceMethodChannelFeatureLibImplComponent create(NavigationCoreLibApi navigationCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            return new QCommerceMethodChannelFeatureLibImplComponentImpl(new QCommerceMethodChannelFeatureImplLibModule(), navigationCoreLibApi, parserCoreLibApi);
        }
    }

    public static final class QCommerceMethodChannelFeatureLibImplComponentImpl implements QCommerceMethodChannelFeatureLibImplComponent {
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule;
        private final QCommerceMethodChannelFeatureLibImplComponentImpl qCommerceMethodChannelFeatureLibImplComponentImpl;

        private QCommerceMethodChannelFeatureLibImplComponentImpl(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule2, NavigationCoreLibApi navigationCoreLibApi2, ParserCoreLibApi parserCoreLibApi2) {
            this.qCommerceMethodChannelFeatureLibImplComponentImpl = this;
            this.qCommerceMethodChannelFeatureImplLibModule = qCommerceMethodChannelFeatureImplLibModule2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.parserCoreLibApi = parserCoreLibApi2;
        }

        private QCommerceChannelCallbackImpl qCommerceChannelCallbackImpl() {
            return new QCommerceChannelCallbackImpl((Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()), QCommerceMethodChannelFeatureImplLibModule_ProvideNonMigratedCartFactory.provideNonMigratedCart(this.qCommerceMethodChannelFeatureImplLibModule), (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()), QCommerceMethodChannelFeatureImplLibModule_ProvideUniversalGsonFactory.provideUniversalGson(this.qCommerceMethodChannelFeatureImplLibModule));
        }

        public QCommerceChannelCallback getQCommerceChannelCallback() {
            return QCommerceMethodChannelFeatureImplLibModule_ProvideQCommerceChannelCallbackImplFactory.provideQCommerceChannelCallbackImpl(this.qCommerceMethodChannelFeatureImplLibModule, qCommerceChannelCallbackImpl());
        }
    }

    private DaggerQCommerceMethodChannelFeatureLibImplComponent() {
    }

    public static QCommerceMethodChannelFeatureLibImplComponent.Factory factory() {
        return new Factory();
    }
}
