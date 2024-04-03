package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_ParserCoreLibApiFactory implements Factory<Api> {
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;

    public CoreApiModule_ParserCoreLibApiFactory(Provider<ParserCoreLibApi> provider) {
        this.parserCoreLibApiProvider = provider;
    }

    public static CoreApiModule_ParserCoreLibApiFactory create(Provider<ParserCoreLibApi> provider) {
        return new CoreApiModule_ParserCoreLibApiFactory(provider);
    }

    public static Api parserCoreLibApi(ParserCoreLibApi parserCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.parserCoreLibApi(parserCoreLibApi));
    }

    public Api get() {
        return parserCoreLibApi(this.parserCoreLibApiProvider.get());
    }
}
