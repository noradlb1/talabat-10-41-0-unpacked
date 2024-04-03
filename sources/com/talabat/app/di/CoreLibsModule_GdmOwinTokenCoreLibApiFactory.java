package com.talabat.app.di;

import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GdmOwinTokenCoreLibApiFactory implements Factory<GdmOwinTokenApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_GdmOwinTokenCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_GdmOwinTokenCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_GdmOwinTokenCoreLibApiFactory(coreLibsModule);
    }

    public static GdmOwinTokenApi gdmOwinTokenCoreLibApi(CoreLibsModule coreLibsModule) {
        return (GdmOwinTokenApi) Preconditions.checkNotNullFromProvides(coreLibsModule.gdmOwinTokenCoreLibApi());
    }

    public GdmOwinTokenApi get() {
        return gdmOwinTokenCoreLibApi(this.module);
    }
}
