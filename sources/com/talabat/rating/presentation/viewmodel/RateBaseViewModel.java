package com.talabat.rating.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.rating.domain.usecases.StarRatingFeatureToggleUseCase;
import com.talabat.rating.presentation.viewstate.RatingParadigm;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/talabat/rating/presentation/viewmodel/RateBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "isStarRatingFeatureToggle", "Lcom/talabat/rating/domain/usecases/StarRatingFeatureToggleUseCase;", "(Lcom/talabat/rating/domain/usecases/StarRatingFeatureToggleUseCase;)V", "_ratingViewLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "ratingViewLiveData", "Landroidx/lifecycle/LiveData;", "getRatingViewLiveData", "()Landroidx/lifecycle/LiveData;", "getRating", "", "starRatingValue", "Lkotlin/Function0;", "smileyRatingValue", "onAttach", "", "showStarRatingView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RateBaseViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<RatingParadigm> _ratingViewLiveData;
    @NotNull
    private final StarRatingFeatureToggleUseCase isStarRatingFeatureToggle;
    @NotNull
    private final LiveData<RatingParadigm> ratingViewLiveData;

    public RateBaseViewModel(@NotNull StarRatingFeatureToggleUseCase starRatingFeatureToggleUseCase) {
        Intrinsics.checkNotNullParameter(starRatingFeatureToggleUseCase, "isStarRatingFeatureToggle");
        this.isStarRatingFeatureToggle = starRatingFeatureToggleUseCase;
        MutableLiveData<RatingParadigm> mutableLiveData = new MutableLiveData<>();
        this._ratingViewLiveData = mutableLiveData;
        this.ratingViewLiveData = mutableLiveData;
    }

    private final void showStarRatingView() {
        this._ratingViewLiveData.postValue(RatingParadigm.Star.INSTANCE);
    }

    public final int getRating(@NotNull Function0<Integer> function0, @NotNull Function0<Integer> function02) {
        Intrinsics.checkNotNullParameter(function0, "starRatingValue");
        Intrinsics.checkNotNullParameter(function02, "smileyRatingValue");
        return function0.invoke().intValue();
    }

    @NotNull
    public final LiveData<RatingParadigm> getRatingViewLiveData() {
        return this.ratingViewLiveData;
    }

    public final void onAttach() {
        showStarRatingView();
    }
}
