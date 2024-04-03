package com.talabat.feature.rating.data.remote;

import com.talabat.feature.rating.domain.model.DashboardOrderResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rating/data/remote/GetPastOrderApi;", "", "fetchPastOrders", "Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetPastOrderApi {
    @Nullable
    @GET("v1/pages/dashboard-orders/{COUNTRY_ID}")
    Object fetchPastOrders(@Path("COUNTRY_ID") int i11, @NotNull Continuation<? super DashboardOrderResponse> continuation);
}
