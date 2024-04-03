package com.talabat.core.google.login.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl_Factory;
import com.talabat.core.google.login.data.di.GoogleLoginCoreLibComponent;
import com.talabat.core.google.login.data.impl.GoogleLoginActivityIntegrationImpl_Factory;
import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl_Factory;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerGoogleLoginCoreLibComponent {

    public static final class Factory implements GoogleLoginCoreLibComponent.Factory {
        private Factory() {
        }

        public GoogleLoginCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new GoogleLoginCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class GoogleLoginCoreLibComponentImpl implements GoogleLoginCoreLibComponent {
        private Provider<Context> getContextProvider;
        private final GoogleLoginCoreLibComponentImpl googleLoginCoreLibComponentImpl;
        private Provider<GoogleLoginDataSourceImpl> googleLoginDataSourceImplProvider;
        private Provider<GoogleLoginRepositoryImpl> googleLoginRepositoryImplProvider;
        private Provider<GoogleLoginActivityIntegration> provideGoogleActivityIntegrationProvider;
        private Provider<GoogleLoginRepository> provideGoogleRepositoryProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private GoogleLoginCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.googleLoginCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            Provider<GoogleLoginActivityIntegration> provider = SingleCheck.provider(GoogleLoginActivityIntegrationImpl_Factory.create());
            this.provideGoogleActivityIntegrationProvider = provider;
            GoogleLoginDataSourceImpl_Factory create = GoogleLoginDataSourceImpl_Factory.create(this.getContextProvider, provider);
            this.googleLoginDataSourceImplProvider = create;
            GoogleLoginRepositoryImpl_Factory create2 = GoogleLoginRepositoryImpl_Factory.create(create);
            this.googleLoginRepositoryImplProvider = create2;
            this.provideGoogleRepositoryProvider = SingleCheck.provider(create2);
        }

        public GoogleLoginActivityIntegration getGoogleLoginActivityIntegration() {
            return this.provideGoogleActivityIntegrationProvider.get();
        }

        public GoogleLoginRepository getGoogleLoginRepository() {
            return this.provideGoogleRepositoryProvider.get();
        }
    }

    private DaggerGoogleLoginCoreLibComponent() {
    }

    public static GoogleLoginCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
