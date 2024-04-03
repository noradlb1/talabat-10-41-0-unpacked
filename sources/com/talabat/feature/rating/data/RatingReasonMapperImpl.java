package com.talabat.feature.rating.data;

import com.talabat.feature.rating.domain.RatingReasonMapper;
import com.talabat.feature.rating.domain.model.RateReason;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/feature/rating/data/RatingReasonMapperImpl;", "Lcom/talabat/feature/rating/domain/RatingReasonMapper;", "()V", "map", "", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "rateReason", "Lcom/talabat/feature/rating/domain/model/RateReason;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingReasonMapperImpl implements RatingReasonMapper {
    @NotNull
    public List<RatingReasonsData> map(@NotNull List<RateReason> list) {
        Intrinsics.checkNotNullParameter(list, "rateReason");
        Iterable<RateReason> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (RateReason rateReason : iterable) {
            arrayList.add(new RatingReasonsData(rateReason.getRatingReason(), rateReason.getId(), false, rateReason.getEnabledForRatings()));
        }
        return arrayList;
    }
}
