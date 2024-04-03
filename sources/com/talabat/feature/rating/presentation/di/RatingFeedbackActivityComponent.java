package com.talabat.feature.rating.presentation.di;

import android.content.Context;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.presentation.RatingFeedbackActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rating/presentation/di/RatingFeedbackActivityComponent;", "", "inject", "", "activity", "Lcom/talabat/feature/rating/presentation/RatingFeedbackActivity;", "Factory", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {RatingFeatureApi.class}, modules = {RatingFeedbackPresentationModule.class})
public interface RatingFeedbackActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/rating/presentation/di/RatingFeedbackActivityComponent$Factory;", "", "create", "Lcom/talabat/feature/rating/presentation/di/RatingFeedbackActivityComponent;", "context", "Landroid/content/Context;", "ratingFeatureApi", "Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        RatingFeedbackActivityComponent create(@NotNull @BindsInstance Context context, @NotNull RatingFeatureApi ratingFeatureApi);
    }

    void inject(@NotNull RatingFeedbackActivity ratingFeedbackActivity);
}
