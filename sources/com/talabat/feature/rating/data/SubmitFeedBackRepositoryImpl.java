package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RateOrderResponse;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rating/data/SubmitFeedBackRepositoryImpl;", "Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;", "submitFeedBackService", "Lcom/talabat/feature/rating/data/remote/SubmitFeedBackService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/feature/rating/data/remote/SubmitFeedBackService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "submitFeedback", "Lcom/talabat/feature/rating/domain/model/RateOrderResponse;", "requestRateOrderRequest", "Lcom/talabat/feature/rating/domain/model/RateOrderRequest;", "(Lcom/talabat/feature/rating/domain/model/RateOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubmitFeedBackRepositoryImpl implements SubmitFeedBackRepository {
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final SubmitFeedBackService submitFeedBackService;

    @Inject
    public SubmitFeedBackRepositoryImpl(@NotNull SubmitFeedBackService submitFeedBackService2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(submitFeedBackService2, "submitFeedBackService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.submitFeedBackService = submitFeedBackService2;
        this.ioDispatcher = coroutineDispatcher;
    }

    @Nullable
    public Object submitFeedback(@NotNull RateOrderRequest rateOrderRequest, @NotNull Continuation<? super RateOrderResponse> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new SubmitFeedBackRepositoryImpl$submitFeedback$2(this, rateOrderRequest, (Continuation<? super SubmitFeedBackRepositoryImpl$submitFeedback$2>) null), continuation);
    }
}
