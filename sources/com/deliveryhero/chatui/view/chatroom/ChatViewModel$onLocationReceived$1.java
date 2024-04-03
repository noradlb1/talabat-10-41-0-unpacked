package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
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
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$onLocationReceived$1", f = "ChatViewModel.kt", i = {}, l = {416}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$onLocationReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MessageMetadata f29538j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$onLocationReceived$1(ChatViewModel chatViewModel, MessageMetadata messageMetadata, Continuation<? super ChatViewModel$onLocationReceived$1> continuation) {
        super(2, continuation);
        this.f29537i = chatViewModel;
        this.f29538j = messageMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$onLocationReceived$1(this.f29537i, this.f29538j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$onLocationReceived$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29536h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MessageEventsTracker messageEvents$customerchat_basicRelease = this.f29537i.getMessageEvents$customerchat_basicRelease();
            EventMetadata eventMetadata$customerchat_basicRelease = this.f29537i.getEventMetadata$customerchat_basicRelease();
            if (eventMetadata$customerchat_basicRelease == null) {
                return Unit.INSTANCE;
            }
            MessageMetadata messageMetadata = this.f29538j;
            this.f29536h = 1;
            if (messageEvents$customerchat_basicRelease.trackMessageSentEvent(eventMetadata$customerchat_basicRelease, messageMetadata, this) == coroutine_suspended) {
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
