package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionDetailsUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$loadData$1", f = "TproSubscriptionDetailsViewModel.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
public final class TproSubscriptionDetailsViewModel$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59339h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f59340i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59341j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionDetailsViewModel$loadData$1(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, String str, Continuation<? super TproSubscriptionDetailsViewModel$loadData$1> continuation) {
        super(2, continuation);
        this.f59340i = tproSubscriptionDetailsViewModel;
        this.f59341j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproSubscriptionDetailsViewModel$loadData$1 tproSubscriptionDetailsViewModel$loadData$1 = new TproSubscriptionDetailsViewModel$loadData$1(this.f59340i, this.f59341j, continuation);
        tproSubscriptionDetailsViewModel$loadData$1.L$0 = obj;
        return tproSubscriptionDetailsViewModel$loadData$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproSubscriptionDetailsViewModel$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59339h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel = this.f59340i;
            String str = this.f59341j;
            Result.Companion companion = Result.Companion;
            GetSubscriptionDetailsUseCase access$getGetSubscriptionDetails$p = tproSubscriptionDetailsViewModel.getSubscriptionDetails;
            GetSubscriptionDetailsUseCase.Params params = new GetSubscriptionDetailsUseCase.Params(str);
            this.f59339h = 1;
            obj = access$getGetSubscriptionDetails$p.invoke(params, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((Subscription) obj);
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel2 = this.f59340i;
        if (Result.m6336isSuccessimpl(obj2)) {
            tproSubscriptionDetailsViewModel2._subscription.postValue((Subscription) obj2);
        }
        return Unit.INSTANCE;
    }
}
