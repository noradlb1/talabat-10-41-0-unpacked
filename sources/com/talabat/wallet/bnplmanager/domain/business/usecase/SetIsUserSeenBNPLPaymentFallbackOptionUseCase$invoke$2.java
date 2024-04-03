package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2", f = "SetIsUserSeenBNPLPaymentFallbackOptionUseCase.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
public final class SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12489h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SetIsUserSeenBNPLPaymentFallbackOptionUseCase f12490i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f12491j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2(SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase, boolean z11, Continuation<? super SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12490i = setIsUserSeenBNPLPaymentFallbackOptionUseCase;
        this.f12491j = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2(this.f12490i, this.f12491j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12489h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BNPLManagerRepository access$getBNPLManagerRepository$p = this.f12490i.bNPLManagerRepository;
            boolean z11 = this.f12491j;
            this.f12489h = 1;
            if (access$getBNPLManagerRepository$p.setIsUserSeenBnplPaymentFallbackOption(z11, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
