package com.talabat.core.gms.base.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable"})
public final class GmsBaseModule_IsGmsAvailableFactory implements Factory<Boolean> {
    private final Provider<Context> contextProvider;

    public GmsBaseModule_IsGmsAvailableFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static GmsBaseModule_IsGmsAvailableFactory create(Provider<Context> provider) {
        return new GmsBaseModule_IsGmsAvailableFactory(provider);
    }

    public static boolean isGmsAvailable(Context context) {
        return GmsBaseModule.INSTANCE.isGmsAvailable(context);
    }

    public Boolean get() {
        return Boolean.valueOf(isGmsAvailable(this.contextProvider.get()));
    }
}
