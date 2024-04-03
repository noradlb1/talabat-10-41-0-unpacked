package com.talabat.feature.rating.domain.repo;

import com.talabat.feature.rating.domain.model.RatingReasonsData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "", "getDeliveryExperienceTitle", "", "getDeliveryReasonList", "", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "getVendorLogoUrl", "getVendorReasonList", "getVendorTitle", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RatingDataRepository {
    @NotNull
    String getDeliveryExperienceTitle();

    @NotNull
    List<RatingReasonsData> getDeliveryReasonList();

    @Nullable
    String getVendorLogoUrl();

    @NotNull
    List<RatingReasonsData> getVendorReasonList();

    @NotNull
    String getVendorTitle();
}
