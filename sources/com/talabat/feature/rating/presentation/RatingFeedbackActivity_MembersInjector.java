package com.talabat.feature.rating.presentation;

import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RatingFeedbackActivity_MembersInjector implements MembersInjector<RatingFeedbackActivity> {
    private final Provider<RatingFeedBackViewModelFactory> viewModelFactoryProvider;

    public RatingFeedbackActivity_MembersInjector(Provider<RatingFeedBackViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<RatingFeedbackActivity> create(Provider<RatingFeedBackViewModelFactory> provider) {
        return new RatingFeedbackActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.rating.presentation.RatingFeedbackActivity.viewModelFactory")
    public static void injectViewModelFactory(RatingFeedbackActivity ratingFeedbackActivity, RatingFeedBackViewModelFactory ratingFeedBackViewModelFactory) {
        ratingFeedbackActivity.viewModelFactory = ratingFeedBackViewModelFactory;
    }

    public void injectMembers(RatingFeedbackActivity ratingFeedbackActivity) {
        injectViewModelFactory(ratingFeedbackActivity, this.viewModelFactoryProvider.get());
    }
}
