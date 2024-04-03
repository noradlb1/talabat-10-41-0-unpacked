package com.talabat.core.facebook.login.data.di;

import android.content.Context;
import com.facebook.CallbackManager;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.facebook.login.data.datasource.GraphRequestFactory_Factory;
import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl;
import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl_Factory;
import com.talabat.core.facebook.login.data.di.FacebookLoginCoreLibComponent;
import com.talabat.core.facebook.login.data.impl.FacebookAccessTokenProviderImpl;
import com.talabat.core.facebook.login.data.impl.FacebookAccessTokenProviderImpl_Factory;
import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl;
import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl_Factory;
import com.talabat.core.facebook.login.data.integration.FacebookLoginActivityIntegrationImpl_Factory;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFacebookLoginCoreLibComponent {

    public static final class FacebookLoginCoreLibComponentImpl implements FacebookLoginCoreLibComponent {
        private Provider<FacebookAccessTokenProviderImpl> facebookAccessTokenProviderImplProvider;
        private final FacebookLoginCoreLibComponentImpl facebookLoginCoreLibComponentImpl;
        private Provider<FacebookLoginDataSourceImpl> facebookLoginDataSourceImplProvider;
        private Provider<FacebookLoginRepositoryImpl> facebookLoginRepositoryImplProvider;
        private Provider<Context> getContextProvider;
        private Provider<CallbackManager> provideCallbackManagerProvider;
        private Provider<FacebookLoginActivityIntegration> provideFacebookActivityIntegrationProvider;
        private Provider<FacebookLoginRepository> provideFacebookRepositoryProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private FacebookLoginCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.facebookLoginCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            this.provideCallbackManagerProvider = SingleCheck.provider(FacebookLoginModule_ProvideCallbackManagerFactory.create());
            this.facebookAccessTokenProviderImplProvider = FacebookAccessTokenProviderImpl_Factory.create(FacebookLoginModule_ProvideAccessTokenManagerFactory.create());
            this.provideFacebookActivityIntegrationProvider = SingleCheck.provider(FacebookLoginActivityIntegrationImpl_Factory.create());
            FacebookLoginDataSourceImpl_Factory create = FacebookLoginDataSourceImpl_Factory.create(this.getContextProvider, this.provideCallbackManagerProvider, FacebookLoginModule_ProvideLoginManagerFactory.create(), this.facebookAccessTokenProviderImplProvider, GraphRequestFactory_Factory.create(), this.provideFacebookActivityIntegrationProvider);
            this.facebookLoginDataSourceImplProvider = create;
            FacebookLoginRepositoryImpl_Factory create2 = FacebookLoginRepositoryImpl_Factory.create(create);
            this.facebookLoginRepositoryImplProvider = create2;
            this.provideFacebookRepositoryProvider = SingleCheck.provider(create2);
        }

        public FacebookLoginActivityIntegration getFacebookLoginActivityIntegration() {
            return this.provideFacebookActivityIntegrationProvider.get();
        }

        public FacebookLoginRepository getFacebookLoginRepository() {
            return this.provideFacebookRepositoryProvider.get();
        }
    }

    public static final class Factory implements FacebookLoginCoreLibComponent.Factory {
        private Factory() {
        }

        public FacebookLoginCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new FacebookLoginCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    private DaggerFacebookLoginCoreLibComponent() {
    }

    public static FacebookLoginCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
