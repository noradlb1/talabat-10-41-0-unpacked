package com.talabat.app.di;

import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import com.talabat.location.domain.di.LocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_LocationCoreLibApiFactory implements Factory<LocationCoreLibApi> {
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;
    private final Provider<GmsLocationCoreLibApi> gmsLocationCoreLibApiProvider;
    private final Provider<HmsBaseCoreLibApi> hmsBaseCoreLibApiProvider;
    private final Provider<HmsLocationCoreLibApi> hmsLocationCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_LocationCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<GmsBaseCoreLibApi> provider, Provider<GmsLocationCoreLibApi> provider2, Provider<HmsBaseCoreLibApi> provider3, Provider<HmsLocationCoreLibApi> provider4) {
        this.module = coreLibsModule;
        this.gmsBaseCoreLibApiProvider = provider;
        this.gmsLocationCoreLibApiProvider = provider2;
        this.hmsBaseCoreLibApiProvider = provider3;
        this.hmsLocationCoreLibApiProvider = provider4;
    }

    public static CoreLibsModule_LocationCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<GmsBaseCoreLibApi> provider, Provider<GmsLocationCoreLibApi> provider2, Provider<HmsBaseCoreLibApi> provider3, Provider<HmsLocationCoreLibApi> provider4) {
        return new CoreLibsModule_LocationCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4);
    }

    public static LocationCoreLibApi locationCoreLibApi(CoreLibsModule coreLibsModule, GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsLocationCoreLibApi gmsLocationCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsLocationCoreLibApi hmsLocationCoreLibApi) {
        return (LocationCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.locationCoreLibApi(gmsBaseCoreLibApi, gmsLocationCoreLibApi, hmsBaseCoreLibApi, hmsLocationCoreLibApi));
    }

    public LocationCoreLibApi get() {
        return locationCoreLibApi(this.module, this.gmsBaseCoreLibApiProvider.get(), this.gmsLocationCoreLibApiProvider.get(), this.hmsBaseCoreLibApiProvider.get(), this.hmsLocationCoreLibApiProvider.get());
    }
}
