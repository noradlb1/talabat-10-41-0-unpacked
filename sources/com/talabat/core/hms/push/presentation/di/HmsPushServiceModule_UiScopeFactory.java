package com.talabat.core.hms.push.presentation.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsPushServiceModule_UiScopeFactory implements Factory<CoroutineScope> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;

    public HmsPushServiceModule_UiScopeFactory(Provider<CoroutineDispatchersFactory> provider) {
        this.coroutineDispatchersFactoryProvider = provider;
    }

    public static HmsPushServiceModule_UiScopeFactory create(Provider<CoroutineDispatchersFactory> provider) {
        return new HmsPushServiceModule_UiScopeFactory(provider);
    }

    public static CoroutineScope uiScope(CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(HmsPushServiceModule.INSTANCE.uiScope(coroutineDispatchersFactory));
    }

    public CoroutineScope get() {
        return uiScope(this.coroutineDispatchersFactoryProvider.get());
    }
}
