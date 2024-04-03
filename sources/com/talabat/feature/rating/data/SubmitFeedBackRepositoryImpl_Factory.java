package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubmitFeedBackRepositoryImpl_Factory implements Factory<SubmitFeedBackRepositoryImpl> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<SubmitFeedBackService> submitFeedBackServiceProvider;

    public SubmitFeedBackRepositoryImpl_Factory(Provider<SubmitFeedBackService> provider, Provider<CoroutineDispatcher> provider2) {
        this.submitFeedBackServiceProvider = provider;
        this.ioDispatcherProvider = provider2;
    }

    public static SubmitFeedBackRepositoryImpl_Factory create(Provider<SubmitFeedBackService> provider, Provider<CoroutineDispatcher> provider2) {
        return new SubmitFeedBackRepositoryImpl_Factory(provider, provider2);
    }

    public static SubmitFeedBackRepositoryImpl newInstance(SubmitFeedBackService submitFeedBackService, CoroutineDispatcher coroutineDispatcher) {
        return new SubmitFeedBackRepositoryImpl(submitFeedBackService, coroutineDispatcher);
    }

    public SubmitFeedBackRepositoryImpl get() {
        return newInstance(this.submitFeedBackServiceProvider.get(), this.ioDispatcherProvider.get());
    }
}
