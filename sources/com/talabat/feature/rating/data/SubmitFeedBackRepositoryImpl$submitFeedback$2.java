package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RateOrderResponse;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/rating/domain/model/RateOrderResponse;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rating.data.SubmitFeedBackRepositoryImpl$submitFeedback$2", f = "SubmitFeedBackRepositoryImpl.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class SubmitFeedBackRepositoryImpl$submitFeedback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RateOrderResponse>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58676h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubmitFeedBackRepositoryImpl f58677i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RateOrderRequest f58678j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubmitFeedBackRepositoryImpl$submitFeedback$2(SubmitFeedBackRepositoryImpl submitFeedBackRepositoryImpl, RateOrderRequest rateOrderRequest, Continuation<? super SubmitFeedBackRepositoryImpl$submitFeedback$2> continuation) {
        super(2, continuation);
        this.f58677i = submitFeedBackRepositoryImpl;
        this.f58678j = rateOrderRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SubmitFeedBackRepositoryImpl$submitFeedback$2(this.f58677i, this.f58678j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RateOrderResponse> continuation) {
        return ((SubmitFeedBackRepositoryImpl$submitFeedback$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58676h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SubmitFeedBackService access$getSubmitFeedBackService$p = this.f58677i.submitFeedBackService;
            RateOrderRequest rateOrderRequest = this.f58678j;
            this.f58676h = 1;
            obj = access$getSubmitFeedBackService$p.submitFeedBack(rateOrderRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
