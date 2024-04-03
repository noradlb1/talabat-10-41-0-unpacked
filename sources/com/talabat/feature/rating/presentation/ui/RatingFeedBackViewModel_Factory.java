package com.talabat.feature.rating.presentation.ui;

import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingFeedBackViewModel_Factory implements Factory<RatingFeedBackViewModel> {
    private final Provider<RatingDataManager> ratingDataManagerProvider;
    private final Provider<RatingDataRepository> ratingDataRepositoryProvider;
    private final Provider<EventTracker> ratingEventTrackerProvider;
    private final Provider<RatingResourceProvider> ratingResourceProvider;
    private final Provider<SubmitFeedBackRepository> submitFeedBackRepositoryProvider;

    public RatingFeedBackViewModel_Factory(Provider<SubmitFeedBackRepository> provider, Provider<RatingDataRepository> provider2, Provider<RatingResourceProvider> provider3, Provider<RatingDataManager> provider4, Provider<EventTracker> provider5) {
        this.submitFeedBackRepositoryProvider = provider;
        this.ratingDataRepositoryProvider = provider2;
        this.ratingResourceProvider = provider3;
        this.ratingDataManagerProvider = provider4;
        this.ratingEventTrackerProvider = provider5;
    }

    public static RatingFeedBackViewModel_Factory create(Provider<SubmitFeedBackRepository> provider, Provider<RatingDataRepository> provider2, Provider<RatingResourceProvider> provider3, Provider<RatingDataManager> provider4, Provider<EventTracker> provider5) {
        return new RatingFeedBackViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static RatingFeedBackViewModel newInstance(SubmitFeedBackRepository submitFeedBackRepository, RatingDataRepository ratingDataRepository, RatingResourceProvider ratingResourceProvider2, RatingDataManager ratingDataManager, EventTracker eventTracker) {
        return new RatingFeedBackViewModel(submitFeedBackRepository, ratingDataRepository, ratingResourceProvider2, ratingDataManager, eventTracker);
    }

    public RatingFeedBackViewModel get() {
        return newInstance(this.submitFeedBackRepositoryProvider.get(), this.ratingDataRepositoryProvider.get(), this.ratingResourceProvider.get(), this.ratingDataManagerProvider.get(), this.ratingEventTrackerProvider.get());
    }
}
