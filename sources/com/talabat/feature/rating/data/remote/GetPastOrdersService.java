package com.talabat.feature.rating.data.remote;

import com.talabat.feature.rating.domain.model.DashboardOrderResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rating/data/remote/GetPastOrdersService;", "Lcom/talabat/feature/rating/data/remote/GetPastOrderApi;", "api", "(Lcom/talabat/feature/rating/data/remote/GetPastOrderApi;)V", "fetchPastOrders", "Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPastOrdersService implements GetPastOrderApi {
    @NotNull
    private final GetPastOrderApi api;

    public GetPastOrdersService(@NotNull GetPastOrderApi getPastOrderApi) {
        Intrinsics.checkNotNullParameter(getPastOrderApi, "api");
        this.api = getPastOrderApi;
    }

    @Nullable
    public Object fetchPastOrders(int i11, @NotNull Continuation<? super DashboardOrderResponse> continuation) {
        return this.api.fetchPastOrders(i11, continuation);
    }
}
