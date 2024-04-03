package com.talabat.app.di;

import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_NetworkCoreLibApiFactory implements Factory<NetworkCoreLibApi> {
    private final CoreLibsModule module;
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;

    public CoreLibsModule_NetworkCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ParserCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.parserCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_NetworkCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ParserCoreLibApi> provider) {
        return new CoreLibsModule_NetworkCoreLibApiFactory(coreLibsModule, provider);
    }

    public static NetworkCoreLibApi networkCoreLibApi(CoreLibsModule coreLibsModule, ParserCoreLibApi parserCoreLibApi) {
        return (NetworkCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.networkCoreLibApi(parserCoreLibApi));
    }

    public NetworkCoreLibApi get() {
        return networkCoreLibApi(this.module, this.parserCoreLibApiProvider.get());
    }
}
