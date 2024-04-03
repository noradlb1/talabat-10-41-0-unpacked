package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_CustomerCoreLibApiFactory implements Factory<Api> {
    private final Provider<CustomerCoreLibApi> customerCoreLibApiProvider;

    public CoreApiModule_CustomerCoreLibApiFactory(Provider<CustomerCoreLibApi> provider) {
        this.customerCoreLibApiProvider = provider;
    }

    public static CoreApiModule_CustomerCoreLibApiFactory create(Provider<CustomerCoreLibApi> provider) {
        return new CoreApiModule_CustomerCoreLibApiFactory(provider);
    }

    public static Api customerCoreLibApi(CustomerCoreLibApi customerCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.customerCoreLibApi(customerCoreLibApi));
    }

    public Api get() {
        return customerCoreLibApi(this.customerCoreLibApiProvider.get());
    }
}
