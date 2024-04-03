package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingUserDataModule_ProvideSubmitFeedBackRepositoryFactory implements Factory<SubmitFeedBackRepository> {
    private final Provider<SubmitFeedBackService> submitFeedBackServiceProvider;

    public RatingUserDataModule_ProvideSubmitFeedBackRepositoryFactory(Provider<SubmitFeedBackService> provider) {
        this.submitFeedBackServiceProvider = provider;
    }

    public static RatingUserDataModule_ProvideSubmitFeedBackRepositoryFactory create(Provider<SubmitFeedBackService> provider) {
        return new RatingUserDataModule_ProvideSubmitFeedBackRepositoryFactory(provider);
    }

    public static SubmitFeedBackRepository provideSubmitFeedBackRepository(SubmitFeedBackService submitFeedBackService) {
        return (SubmitFeedBackRepository) Preconditions.checkNotNullFromProvides(RatingUserDataModule.INSTANCE.provideSubmitFeedBackRepository(submitFeedBackService));
    }

    public SubmitFeedBackRepository get() {
        return provideSubmitFeedBackRepository(this.submitFeedBackServiceProvider.get());
    }
}
