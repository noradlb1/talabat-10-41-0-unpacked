package com.talabat.core.network.di;

import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.core.network.data.endpoint.DefaultBaseUrlFactory_Factory;
import com.talabat.core.network.di.NetworkCoreLibComponent;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerNetworkCoreLibComponent {

    public static final class Factory implements NetworkCoreLibComponent.Factory {
        private Factory() {
        }

        public NetworkCoreLibComponent create(ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(parserCoreLibApi);
            return new NetworkCoreLibComponentImpl(parserCoreLibApi);
        }
    }

    public static final class NetworkCoreLibComponentImpl implements NetworkCoreLibComponent {
        private Provider<BaseUrlFactory> baseUrlFactoryProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<Moshi> getMoshiProvider;
        private final NetworkCoreLibComponentImpl networkCoreLibComponentImpl;
        private Provider<OkHttpClient> okHttpClientProvider;
        private Provider<Retrofit.Builder> retrofitProvider;
        private Provider<Retrofit.Builder> retrofitWithGsonProvider;
        private Provider<Retrofit.Builder> retrofitWithMoshiProvider;

        public static final class GetGsonProvider implements Provider<Gson> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetGsonProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson());
            }
        }

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
            }
        }

        private NetworkCoreLibComponentImpl(ParserCoreLibApi parserCoreLibApi) {
            this.networkCoreLibComponentImpl = this;
            initialize(parserCoreLibApi);
        }

        private void initialize(ParserCoreLibApi parserCoreLibApi) {
            this.baseUrlFactoryProvider = SingleCheck.provider(DefaultBaseUrlFactory_Factory.create());
            Provider<OkHttpClient> provider = SingleCheck.provider(NetworkCoreLibModule_OkHttpClientFactory.create());
            this.okHttpClientProvider = provider;
            this.retrofitProvider = SingleCheck.provider(RestModule_RetrofitFactory.create(provider));
            GetGsonProvider getGsonProvider2 = new GetGsonProvider(parserCoreLibApi);
            this.getGsonProvider = getGsonProvider2;
            this.retrofitWithGsonProvider = SingleCheck.provider(RestModule_RetrofitWithGsonFactory.create(this.okHttpClientProvider, getGsonProvider2));
            GetMoshiProvider getMoshiProvider2 = new GetMoshiProvider(parserCoreLibApi);
            this.getMoshiProvider = getMoshiProvider2;
            this.retrofitWithMoshiProvider = SingleCheck.provider(RestModule_RetrofitWithMoshiFactory.create(this.okHttpClientProvider, getMoshiProvider2));
        }

        public BaseUrlFactory getBaseUrlFactory() {
            return this.baseUrlFactoryProvider.get();
        }

        public OkHttpClient getOkHttpClient() {
            return this.okHttpClientProvider.get();
        }

        public Retrofit.Builder getRetrofit() {
            return this.retrofitProvider.get();
        }

        public Retrofit.Builder getRetrofitWithGson() {
            return this.retrofitWithGsonProvider.get();
        }

        public Retrofit.Builder getRetrofitWithMoshi() {
            return this.retrofitWithMoshiProvider.get();
        }
    }

    private DaggerNetworkCoreLibComponent() {
    }

    public static NetworkCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
