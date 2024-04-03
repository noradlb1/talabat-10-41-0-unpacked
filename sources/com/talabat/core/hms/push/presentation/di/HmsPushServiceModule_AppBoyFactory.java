package com.talabat.core.hms.push.presentation.di;

import android.content.Context;
import com.braze.Braze;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsPushServiceModule_AppBoyFactory implements Factory<Braze> {
    private final Provider<Context> contextProvider;

    public HmsPushServiceModule_AppBoyFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static Braze appBoy(Context context) {
        return (Braze) Preconditions.checkNotNullFromProvides(HmsPushServiceModule.INSTANCE.appBoy(context));
    }

    public static HmsPushServiceModule_AppBoyFactory create(Provider<Context> provider) {
        return new HmsPushServiceModule_AppBoyFactory(provider);
    }

    public Braze get() {
        return appBoy(this.contextProvider.get());
    }
}
