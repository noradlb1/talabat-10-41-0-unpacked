package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.talabatcommon.feature.walletCardManagement.model.event.CardDeleteFailedEvent;
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
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedFailedEventUseCase$invoke$2", f = "SendCardDeletedFailedEventUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SendCardDeletedFailedEventUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61713h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SendCardDeletedFailedEventUseCase f61714i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61715j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61716k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendCardDeletedFailedEventUseCase$invoke$2(SendCardDeletedFailedEventUseCase sendCardDeletedFailedEventUseCase, String str, String str2, Continuation<? super SendCardDeletedFailedEventUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61714i = sendCardDeletedFailedEventUseCase;
        this.f61715j = str;
        this.f61716k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SendCardDeletedFailedEventUseCase$invoke$2(this.f61714i, this.f61715j, this.f61716k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SendCardDeletedFailedEventUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61713h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f61714i.tracker.track(new CardDeleteFailedEvent(CardDeleteEventConstants.CARD_DELETE_EVENT_SCREEN_NAME_VALUE, "wallet", this.f61715j, this.f61716k));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
