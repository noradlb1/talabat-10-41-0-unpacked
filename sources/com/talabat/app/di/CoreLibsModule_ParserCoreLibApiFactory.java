package com.talabat.app.di;

import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ParserCoreLibApiFactory implements Factory<ParserCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_ParserCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_ParserCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_ParserCoreLibApiFactory(coreLibsModule);
    }

    public static ParserCoreLibApi parserCoreLibApi(CoreLibsModule coreLibsModule) {
        return (ParserCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.parserCoreLibApi());
    }

    public ParserCoreLibApi get() {
        return parserCoreLibApi(this.module);
    }
}
