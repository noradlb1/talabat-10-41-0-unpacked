package com.talabat.location.area.domain.usecases;

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
@DebugMetadata(c = "com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1", f = "UpdateAreaOfSelectedAddressIfChangedUseCase.kt", i = {}, l = {10}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61029h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UpdateAreaOfSelectedAddressIfChangedUseCase f61030i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1(UpdateAreaOfSelectedAddressIfChangedUseCase updateAreaOfSelectedAddressIfChangedUseCase, Continuation<? super UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1> continuation) {
        super(2, continuation);
        this.f61030i = updateAreaOfSelectedAddressIfChangedUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1(this.f61030i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61029h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateAreaOfSelectedAddressIfChangedUseCase updateAreaOfSelectedAddressIfChangedUseCase = this.f61030i;
            this.f61029h = 1;
            if (updateAreaOfSelectedAddressIfChangedUseCase.updateAreaOfSelectedAddressIfChanged(this) == coroutine_suspended) {
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
