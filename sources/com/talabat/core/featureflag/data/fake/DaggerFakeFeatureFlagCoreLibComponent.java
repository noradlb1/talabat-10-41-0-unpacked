package com.talabat.core.featureflag.data.fake;

import android.content.Context;
import com.google.gson.Gson;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.data.datasource.impl.LocalFeatureFlagDataSource;
import com.talabat.core.featureflag.data.datasource.impl.LocalFeatureFlagDataSource_Factory;
import com.talabat.core.featureflag.data.fake.FakeFeatureFlagCoreLibComponent;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFakeFeatureFlagCoreLibComponent {

    public static final class Factory implements FakeFeatureFlagCoreLibComponent.Factory {
        private Factory() {
        }

        public FakeFeatureFlagCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            return new FakeFeatureFlagCoreLibComponentImpl(contextCoreLibApi, parserCoreLibApi);
        }
    }

    public static final class FakeFeatureFlagCoreLibComponentImpl implements FakeFeatureFlagCoreLibComponent {
        private final FakeFeatureFlagCoreLibComponentImpl fakeFeatureFlagCoreLibComponentImpl;
        private Provider<Context> getContextProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<LocalFeatureFlagDataSource> localFeatureFlagDataSourceProvider;
        private Provider<ITalabatFeatureFlag> provideTalabatFeatureFlagProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetGsonProvider implements Provider<Gson> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetGsonProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson());
            }
        }

        private FakeFeatureFlagCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            this.fakeFeatureFlagCoreLibComponentImpl = this;
            initialize(contextCoreLibApi, parserCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            GetGsonProvider getGsonProvider2 = new GetGsonProvider(parserCoreLibApi);
            this.getGsonProvider = getGsonProvider2;
            LocalFeatureFlagDataSource_Factory create = LocalFeatureFlagDataSource_Factory.create(this.getContextProvider, getGsonProvider2);
            this.localFeatureFlagDataSourceProvider = create;
            this.provideTalabatFeatureFlagProvider = SingleCheck.provider(FakeFeatureFlagCoreLibModule_ProvideTalabatFeatureFlagFactory.create(create));
        }

        public ITalabatFeatureFlag getTalabatFeatureFlag() {
            return this.provideTalabatFeatureFlagProvider.get();
        }
    }

    private DaggerFakeFeatureFlagCoreLibComponent() {
    }

    public static FakeFeatureFlagCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
