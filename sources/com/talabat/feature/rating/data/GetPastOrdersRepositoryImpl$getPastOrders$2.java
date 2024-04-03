package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.domain.model.DashboardOrderResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rating.data.GetPastOrdersRepositoryImpl$getPastOrders$2", f = "GetPastOrdersRepositoryImpl.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class GetPastOrdersRepositoryImpl$getPastOrders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DashboardOrderResponse>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58672h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetPastOrdersRepositoryImpl f58673i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f58674j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPastOrdersRepositoryImpl$getPastOrders$2(GetPastOrdersRepositoryImpl getPastOrdersRepositoryImpl, int i11, Continuation<? super GetPastOrdersRepositoryImpl$getPastOrders$2> continuation) {
        super(2, continuation);
        this.f58673i = getPastOrdersRepositoryImpl;
        this.f58674j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetPastOrdersRepositoryImpl$getPastOrders$2(this.f58673i, this.f58674j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super DashboardOrderResponse> continuation) {
        return ((GetPastOrdersRepositoryImpl$getPastOrders$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58672h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetPastOrdersService access$getGetPastOrdersService$p = this.f58673i.getPastOrdersService;
            int i12 = this.f58674j;
            this.f58672h = 1;
            obj = access$getGetPastOrdersService$p.fetchPastOrders(i12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (HttpException unused) {
                throw new UnableToFetchLastOrderException();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
