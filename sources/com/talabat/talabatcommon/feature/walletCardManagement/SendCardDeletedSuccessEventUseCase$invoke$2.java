package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.talabatcommon.feature.walletCardManagement.model.event.CardDeleteSuccessEvent;
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
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedSuccessEventUseCase$invoke$2", f = "SendCardDeletedSuccessEventUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SendCardDeletedSuccessEventUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61717h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SendCardDeletedSuccessEventUseCase f61718i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendCardDeletedSuccessEventUseCase$invoke$2(SendCardDeletedSuccessEventUseCase sendCardDeletedSuccessEventUseCase, Continuation<? super SendCardDeletedSuccessEventUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61718i = sendCardDeletedSuccessEventUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SendCardDeletedSuccessEventUseCase$invoke$2(this.f61718i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SendCardDeletedSuccessEventUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61717h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f61718i.tracker.track(new CardDeleteSuccessEvent(CardDeleteEventConstants.CARD_DELETE_EVENT_SCREEN_NAME_VALUE, "wallet"));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
