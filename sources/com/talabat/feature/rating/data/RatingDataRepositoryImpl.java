package com.talabat.feature.rating.data;

import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingReasonMapper;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rating/data/RatingDataRepositoryImpl;", "Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "ratingReasonMapper", "Lcom/talabat/feature/rating/domain/RatingReasonMapper;", "ratingDataManager", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "(Lcom/talabat/feature/rating/domain/RatingReasonMapper;Lcom/talabat/feature/rating/domain/RatingDataManager;)V", "getDeliveryExperienceTitle", "", "getDeliveryReasonList", "", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "getVendorLogoUrl", "getVendorReasonList", "getVendorTitle", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingDataRepositoryImpl implements RatingDataRepository {
    @NotNull
    private final RatingDataManager ratingDataManager;
    @NotNull
    private final RatingReasonMapper ratingReasonMapper;

    @Inject
    public RatingDataRepositoryImpl(@NotNull RatingReasonMapper ratingReasonMapper2, @NotNull RatingDataManager ratingDataManager2) {
        Intrinsics.checkNotNullParameter(ratingReasonMapper2, "ratingReasonMapper");
        Intrinsics.checkNotNullParameter(ratingDataManager2, "ratingDataManager");
        this.ratingReasonMapper = ratingReasonMapper2;
        this.ratingDataManager = ratingDataManager2;
    }

    @NotNull
    public String getDeliveryExperienceTitle() {
        return this.ratingDataManager.getDeliveryExperienceRatingTitle();
    }

    @NotNull
    public List<RatingReasonsData> getDeliveryReasonList() {
        return this.ratingReasonMapper.map(this.ratingDataManager.getDeliveryRateReasons());
    }

    @Nullable
    public String getVendorLogoUrl() {
        return this.ratingDataManager.getVendorLogoUrl();
    }

    @NotNull
    public List<RatingReasonsData> getVendorReasonList() {
        return this.ratingReasonMapper.map(this.ratingDataManager.getVendorRateReasons());
    }

    @NotNull
    public String getVendorTitle() {
        return this.ratingDataManager.getVendorExperienceRatingTitle();
    }
}
