package com.talabat.app.di;

import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_MapsCoreLibApiFactory implements Factory<MapsCoreLibApi> {
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;
    private final Provider<GmsMapsCoreLibApi> gmsMapsCoreLibApiProvider;
    private final Provider<HmsBaseCoreLibApi> hmsBaseCoreLibApiProvider;
    private final Provider<HmsMapsCoreLibApi> hmsMapsCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_MapsCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<GmsBaseCoreLibApi> provider, Provider<GmsMapsCoreLibApi> provider2, Provider<HmsBaseCoreLibApi> provider3, Provider<HmsMapsCoreLibApi> provider4) {
        this.module = coreLibsModule;
        this.gmsBaseCoreLibApiProvider = provider;
        this.gmsMapsCoreLibApiProvider = provider2;
        this.hmsBaseCoreLibApiProvider = provider3;
        this.hmsMapsCoreLibApiProvider = provider4;
    }

    public static CoreLibsModule_MapsCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<GmsBaseCoreLibApi> provider, Provider<GmsMapsCoreLibApi> provider2, Provider<HmsBaseCoreLibApi> provider3, Provider<HmsMapsCoreLibApi> provider4) {
        return new CoreLibsModule_MapsCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4);
    }

    public static MapsCoreLibApi mapsCoreLibApi(CoreLibsModule coreLibsModule, GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsMapsCoreLibApi gmsMapsCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsMapsCoreLibApi hmsMapsCoreLibApi) {
        return (MapsCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.mapsCoreLibApi(gmsBaseCoreLibApi, gmsMapsCoreLibApi, hmsBaseCoreLibApi, hmsMapsCoreLibApi));
    }

    public MapsCoreLibApi get() {
        return mapsCoreLibApi(this.module, this.gmsBaseCoreLibApiProvider.get(), this.gmsMapsCoreLibApiProvider.get(), this.hmsBaseCoreLibApiProvider.get(), this.hmsMapsCoreLibApiProvider.get());
    }
}
