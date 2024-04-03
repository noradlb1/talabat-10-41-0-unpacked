package com.talabat.feature.rating.domain;

import com.talabat.feature.rating.domain.model.RateReason;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rating/domain/RatingReasonMapper;", "", "map", "", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "rateReason", "Lcom/talabat/feature/rating/domain/model/RateReason;", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RatingReasonMapper {
    @NotNull
    List<RatingReasonsData> map(@NotNull List<RateReason> list);
}
