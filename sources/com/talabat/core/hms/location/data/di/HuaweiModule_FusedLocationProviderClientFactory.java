package com.talabat.core.hms.location.data.di;

import android.content.Context;
import com.huawei.hms.location.FusedLocationProviderClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_FusedLocationProviderClientFactory implements Factory<FusedLocationProviderClient> {
    private final Provider<Context> contextProvider;

    public HuaweiModule_FusedLocationProviderClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static HuaweiModule_FusedLocationProviderClientFactory create(Provider<Context> provider) {
        return new HuaweiModule_FusedLocationProviderClientFactory(provider);
    }

    public static FusedLocationProviderClient fusedLocationProviderClient(Context context) {
        return (FusedLocationProviderClient) Preconditions.checkNotNullFromProvides(HuaweiModule.INSTANCE.fusedLocationProviderClient(context));
    }

    public FusedLocationProviderClient get() {
        return fusedLocationProviderClient(this.contextProvider.get());
    }
}
