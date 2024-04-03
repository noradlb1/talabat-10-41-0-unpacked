package com.talabat.core.hms.base.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.hms.base.domain.IsHmsAvailable"})
public final class HmsBaseModule_IsHmsAvailableFactory implements Factory<Boolean> {
    private final Provider<Context> contextProvider;

    public HmsBaseModule_IsHmsAvailableFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static HmsBaseModule_IsHmsAvailableFactory create(Provider<Context> provider) {
        return new HmsBaseModule_IsHmsAvailableFactory(provider);
    }

    public static boolean isHmsAvailable(Context context) {
        return HmsBaseModule.INSTANCE.isHmsAvailable(context);
    }

    public Boolean get() {
        return Boolean.valueOf(isHmsAvailable(this.contextProvider.get()));
    }
}
