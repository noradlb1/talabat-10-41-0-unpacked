package com.talabat.feature.rating.data.remote;

import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RateOrderResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rating/data/remote/SubmitFeedBackService;", "Lcom/talabat/feature/rating/data/remote/SubFeedBackApi;", "api", "(Lcom/talabat/feature/rating/data/remote/SubFeedBackApi;)V", "submitFeedBack", "Lcom/talabat/feature/rating/domain/model/RateOrderResponse;", "rateOrderRequest", "Lcom/talabat/feature/rating/domain/model/RateOrderRequest;", "(Lcom/talabat/feature/rating/domain/model/RateOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubmitFeedBackService implements SubFeedBackApi {
    @NotNull
    private final SubFeedBackApi api;

    public SubmitFeedBackService(@NotNull SubFeedBackApi subFeedBackApi) {
        Intrinsics.checkNotNullParameter(subFeedBackApi, "api");
        this.api = subFeedBackApi;
    }

    @Nullable
    public Object submitFeedBack(@NotNull @Body RateOrderRequest rateOrderRequest, @NotNull Continuation<? super RateOrderResponse> continuation) {
        return this.api.submitFeedBack(rateOrderRequest, continuation);
    }
}
