package com.talabat.feature.tpro.presentation.di;

import android.content.Context;
import com.bumptech.glide.RequestManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TproPresentationModule_ProvideGlideRequestFactory implements Factory<RequestManager> {
    private final Provider<Context> contextProvider;

    public TproPresentationModule_ProvideGlideRequestFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static TproPresentationModule_ProvideGlideRequestFactory create(Provider<Context> provider) {
        return new TproPresentationModule_ProvideGlideRequestFactory(provider);
    }

    public static RequestManager provideGlideRequest(Context context) {
        return (RequestManager) Preconditions.checkNotNullFromProvides(TproPresentationModule.INSTANCE.provideGlideRequest(context));
    }

    public RequestManager get() {
        return provideGlideRequest(this.contextProvider.get());
    }
}
