package com.talabat.splash.core.interactor;

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
@DebugMetadata(c = "com.talabat.splash.core.interactor.InternalBackgroundUseCase$invoke$job$1", f = "InternalBackgroundUseCase.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class InternalBackgroundUseCase$invoke$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61430h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InternalBackgroundUseCase f61431i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalBackgroundUseCase$invoke$job$1(InternalBackgroundUseCase internalBackgroundUseCase, Continuation<? super InternalBackgroundUseCase$invoke$job$1> continuation) {
        super(2, continuation);
        this.f61431i = internalBackgroundUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InternalBackgroundUseCase$invoke$job$1(this.f61431i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InternalBackgroundUseCase$invoke$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61430h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            InternalBackgroundUseCase internalBackgroundUseCase = this.f61431i;
            this.f61430h = 1;
            if (internalBackgroundUseCase.run(this) == coroutine_suspended) {
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
