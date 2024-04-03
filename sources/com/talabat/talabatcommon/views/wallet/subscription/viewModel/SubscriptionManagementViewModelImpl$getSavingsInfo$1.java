package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModelImpl$getSavingsInfo$1", f = "SubscriptionManagementViewModelImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class SubscriptionManagementViewModelImpl$getSavingsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f11932h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementViewModelImpl f11933i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f11934j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionManagementViewModelImpl$getSavingsInfo$1(SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl, int i11, Continuation<? super SubscriptionManagementViewModelImpl$getSavingsInfo$1> continuation) {
        super(2, continuation);
        this.f11933i = subscriptionManagementViewModelImpl;
        this.f11934j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SubscriptionManagementViewModelImpl$getSavingsInfo$1 subscriptionManagementViewModelImpl$getSavingsInfo$1 = new SubscriptionManagementViewModelImpl$getSavingsInfo$1(this.f11933i, this.f11934j, continuation);
        subscriptionManagementViewModelImpl$getSavingsInfo$1.L$0 = obj;
        return subscriptionManagementViewModelImpl$getSavingsInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SubscriptionManagementViewModelImpl$getSavingsInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11932h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl = this.f11933i;
            int i12 = this.f11934j;
            Result.Companion companion = Result.Companion;
            GetSavingsInfoUseCase access$getGetSavingsInfoUseCase$p = subscriptionManagementViewModelImpl.getSavingsInfoUseCase;
            GetSavingsInfoUseCase.Params params = new GetSavingsInfoUseCase.Params(i12);
            this.f11932h = 1;
            obj = access$getGetSavingsInfoUseCase$p.invoke(params, this);
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
        obj2 = Result.m6329constructorimpl((SubscriptionSavingsInfo) obj);
        SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl2 = this.f11933i;
        if (Result.m6336isSuccessimpl(obj2)) {
            subscriptionManagementViewModelImpl2.getSubscriptionsSavingsData().setValue((SubscriptionSavingsInfo) obj2);
        }
        SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl3 = this.f11933i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            subscriptionManagementViewModelImpl3.getSubscriptionsSavingsData().setValue(null);
        }
        return Unit.INSTANCE;
    }
}
