package com.talabat.rating.presentation.viewmodel;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.rating.domain.usecases.StarRatingFeatureToggleUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/rating/presentation/viewmodel/RateVendorViewModel;", "Lcom/talabat/rating/presentation/viewmodel/RateBaseViewModel;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "isStarRatingFeatureToggle", "Lcom/talabat/rating/domain/usecases/StarRatingFeatureToggleUseCase;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/rating/domain/usecases/StarRatingFeatureToggleUseCase;)V", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateVendorViewModel extends RateBaseViewModel {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateVendorViewModel(ITalabatFeatureFlag iTalabatFeatureFlag, StarRatingFeatureToggleUseCase starRatingFeatureToggleUseCase, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTalabatFeatureFlag, (i11 & 2) != 0 ? new StarRatingFeatureToggleUseCase(iTalabatFeatureFlag) : starRatingFeatureToggleUseCase);
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return this.talabatFeatureFlag;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateVendorViewModel(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull StarRatingFeatureToggleUseCase starRatingFeatureToggleUseCase) {
        super(starRatingFeatureToggleUseCase);
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(starRatingFeatureToggleUseCase, "isStarRatingFeatureToggle");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
