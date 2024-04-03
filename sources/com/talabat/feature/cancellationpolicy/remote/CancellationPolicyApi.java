package com.talabat.feature.cancellationpolicy.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyApi;", "", "getCancellationPolicyContent", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyResponse;", "countryId", "", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CancellationPolicyApi {
    @Nullable
    @GET("/api/v2/Refund/order/policy/content")
    Object getCancellationPolicyContent(@NotNull @Query("countryId") String str, @NotNull @Query("verticalId") String str2, @NotNull Continuation<? super CancellationPolicyResponse> continuation);
}
