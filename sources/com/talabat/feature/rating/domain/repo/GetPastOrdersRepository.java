package com.talabat.feature.rating.domain.repo;

import com.talabat.feature.rating.domain.model.DashboardOrderResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rating/domain/repo/GetPastOrdersRepository;", "", "getPastOrders", "Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetPastOrdersRepository {
    @Nullable
    Object getPastOrders(int i11, @NotNull Continuation<? super DashboardOrderResponse> continuation);
}
