package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.domain.model.DashboardOrderResponse;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rating/data/GetPastOrdersRepositoryImpl;", "Lcom/talabat/feature/rating/domain/repo/GetPastOrdersRepository;", "getPastOrdersService", "Lcom/talabat/feature/rating/data/remote/GetPastOrdersService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/feature/rating/data/remote/GetPastOrdersService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPastOrders", "Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPastOrdersRepositoryImpl implements GetPastOrdersRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final GetPastOrdersService getPastOrdersService;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;

    @Inject
    public GetPastOrdersRepositoryImpl(@NotNull GetPastOrdersService getPastOrdersService2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(getPastOrdersService2, "getPastOrdersService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.getPastOrdersService = getPastOrdersService2;
        this.ioDispatcher = coroutineDispatcher;
    }

    @Nullable
    public Object getPastOrders(int i11, @NotNull Continuation<? super DashboardOrderResponse> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new GetPastOrdersRepositoryImpl$getPastOrders$2(this, i11, (Continuation<? super GetPastOrdersRepositoryImpl$getPastOrders$2>) null), continuation);
    }
}
