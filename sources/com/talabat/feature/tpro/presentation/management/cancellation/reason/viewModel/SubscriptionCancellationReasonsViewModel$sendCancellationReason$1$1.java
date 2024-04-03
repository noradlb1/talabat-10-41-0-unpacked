package com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.subscriptions.domain.usecase.SendCancellationFeedbackUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1", f = "SubscriptionCancellationReasonsViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59300h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonsViewModel f59301i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReason f59302j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59303k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f59304l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f59305m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1(SubscriptionCancellationReasonsViewModel subscriptionCancellationReasonsViewModel, SubscriptionCancellationReason subscriptionCancellationReason, String str, String str2, Function0<Unit> function0, Continuation<? super SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1> continuation) {
        super(2, continuation);
        this.f59301i = subscriptionCancellationReasonsViewModel;
        this.f59302j = subscriptionCancellationReason;
        this.f59303k = str;
        this.f59304l = str2;
        this.f59305m = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1 subscriptionCancellationReasonsViewModel$sendCancellationReason$1$1 = new SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1(this.f59301i, this.f59302j, this.f59303k, this.f59304l, this.f59305m, continuation);
        subscriptionCancellationReasonsViewModel$sendCancellationReason$1$1.L$0 = obj;
        return subscriptionCancellationReasonsViewModel$sendCancellationReason$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59300h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SubscriptionCancellationReasonsViewModel subscriptionCancellationReasonsViewModel = this.f59301i;
            SubscriptionCancellationReason subscriptionCancellationReason = this.f59302j;
            String str = this.f59303k;
            String str2 = this.f59304l;
            Result.Companion companion = Result.Companion;
            SendCancellationFeedbackUseCase access$getSendCancellationFeedbackUseCase$p = subscriptionCancellationReasonsViewModel.sendCancellationFeedbackUseCase;
            SendCancellationFeedbackUseCase.Params params = new SendCancellationFeedbackUseCase.Params(subscriptionCancellationReason.getId(), str, str2);
            this.f59300h = 1;
            if (access$getSendCancellationFeedbackUseCase$p.invoke(params, this) == coroutine_suspended) {
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
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        Function0<Unit> function0 = this.f59305m;
        if (Result.m6336isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            function0.invoke();
        }
        Function0<Unit> function02 = this.f59305m;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            function02.invoke();
        }
        return Unit.INSTANCE;
    }
}
