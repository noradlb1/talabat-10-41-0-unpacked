package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_CustomerCoreLibApiFactory implements Factory<CustomerCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_CustomerCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_CustomerCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_CustomerCoreLibApiFactory(coreLibsModule, provider);
    }

    public static CustomerCoreLibApi customerCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (CustomerCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.customerCoreLibApi(contextCoreLibApi));
    }

    public CustomerCoreLibApi get() {
        return customerCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
