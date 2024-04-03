package com.talabat.feature.rating.presentation.di;

import android.content.Context;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import com.talabat.feature.rating.presentation.RatingFeedbackActivity;
import com.talabat.feature.rating.presentation.RatingFeedbackActivity_MembersInjector;
import com.talabat.feature.rating.presentation.di.RatingFeedbackActivityComponent;
import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel;
import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModelFactory;
import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel_Factory;
import com.talabat.feature.rating.presentation.ui.RatingResourceProvider;
import com.talabat.feature.rating.presentation.ui.RatingResourceProviderImpl;
import com.talabat.feature.rating.presentation.ui.RatingResourceProviderImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerRatingFeedbackActivityComponent {

    public static final class Factory implements RatingFeedbackActivityComponent.Factory {
        private Factory() {
        }

        public RatingFeedbackActivityComponent create(Context context, RatingFeatureApi ratingFeatureApi) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(ratingFeatureApi);
            return new RatingFeedbackActivityComponentImpl(ratingFeatureApi, context);
        }
    }

    public static final class RatingFeedbackActivityComponentImpl implements RatingFeedbackActivityComponent {
        private Provider<Context> contextProvider;
        private Provider<RatingDataManager> getRatingDataManagerProvider;
        private Provider<RatingDataRepository> getRatingDataRepositoryProvider;
        private Provider<EventTracker> getRatingEventTrackerProvider;
        private Provider<SubmitFeedBackRepository> getSubmitFeedBackRepositoryProvider;
        private Provider<RatingResourceProvider> provideResourceProvider;
        private Provider<RatingFeedBackViewModel> ratingFeedBackViewModelProvider;
        private final RatingFeedbackActivityComponentImpl ratingFeedbackActivityComponentImpl;
        private Provider<RatingResourceProviderImpl> ratingResourceProviderImplProvider;

        public static final class GetRatingDataManagerProvider implements Provider<RatingDataManager> {
            private final RatingFeatureApi ratingFeatureApi;

            public GetRatingDataManagerProvider(RatingFeatureApi ratingFeatureApi2) {
                this.ratingFeatureApi = ratingFeatureApi2;
            }

            public RatingDataManager get() {
                return (RatingDataManager) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getRatingDataManager());
            }
        }

        public static final class GetRatingDataRepositoryProvider implements Provider<RatingDataRepository> {
            private final RatingFeatureApi ratingFeatureApi;

            public GetRatingDataRepositoryProvider(RatingFeatureApi ratingFeatureApi2) {
                this.ratingFeatureApi = ratingFeatureApi2;
            }

            public RatingDataRepository get() {
                return (RatingDataRepository) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getRatingDataRepository());
            }
        }

        public static final class GetRatingEventTrackerProvider implements Provider<EventTracker> {
            private final RatingFeatureApi ratingFeatureApi;

            public GetRatingEventTrackerProvider(RatingFeatureApi ratingFeatureApi2) {
                this.ratingFeatureApi = ratingFeatureApi2;
            }

            public EventTracker get() {
                return (EventTracker) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getRatingEventTracker());
            }
        }

        public static final class GetSubmitFeedBackRepositoryProvider implements Provider<SubmitFeedBackRepository> {
            private final RatingFeatureApi ratingFeatureApi;

            public GetSubmitFeedBackRepositoryProvider(RatingFeatureApi ratingFeatureApi2) {
                this.ratingFeatureApi = ratingFeatureApi2;
            }

            public SubmitFeedBackRepository get() {
                return (SubmitFeedBackRepository) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getSubmitFeedBackRepository());
            }
        }

        private RatingFeedbackActivityComponentImpl(RatingFeatureApi ratingFeatureApi, Context context) {
            this.ratingFeedbackActivityComponentImpl = this;
            initialize(ratingFeatureApi, context);
        }

        private void initialize(RatingFeatureApi ratingFeatureApi, Context context) {
            this.getSubmitFeedBackRepositoryProvider = new GetSubmitFeedBackRepositoryProvider(ratingFeatureApi);
            this.getRatingDataRepositoryProvider = new GetRatingDataRepositoryProvider(ratingFeatureApi);
            dagger.internal.Factory create = InstanceFactory.create(context);
            this.contextProvider = create;
            RatingResourceProviderImpl_Factory create2 = RatingResourceProviderImpl_Factory.create(create);
            this.ratingResourceProviderImplProvider = create2;
            this.provideResourceProvider = SingleCheck.provider(create2);
            this.getRatingDataManagerProvider = new GetRatingDataManagerProvider(ratingFeatureApi);
            GetRatingEventTrackerProvider getRatingEventTrackerProvider2 = new GetRatingEventTrackerProvider(ratingFeatureApi);
            this.getRatingEventTrackerProvider = getRatingEventTrackerProvider2;
            this.ratingFeedBackViewModelProvider = RatingFeedBackViewModel_Factory.create(this.getSubmitFeedBackRepositoryProvider, this.getRatingDataRepositoryProvider, this.provideResourceProvider, this.getRatingDataManagerProvider, getRatingEventTrackerProvider2);
        }

        private RatingFeedbackActivity injectRatingFeedbackActivity(RatingFeedbackActivity ratingFeedbackActivity) {
            RatingFeedbackActivity_MembersInjector.injectViewModelFactory(ratingFeedbackActivity, ratingFeedBackViewModelFactory());
            return ratingFeedbackActivity;
        }

        private RatingFeedBackViewModelFactory ratingFeedBackViewModelFactory() {
            return new RatingFeedBackViewModelFactory(this.ratingFeedBackViewModelProvider);
        }

        public void inject(RatingFeedbackActivity ratingFeedbackActivity) {
            injectRatingFeedbackActivity(ratingFeedbackActivity);
        }
    }

    private DaggerRatingFeedbackActivityComponent() {
    }

    public static RatingFeedbackActivityComponent.Factory factory() {
        return new Factory();
    }
}
