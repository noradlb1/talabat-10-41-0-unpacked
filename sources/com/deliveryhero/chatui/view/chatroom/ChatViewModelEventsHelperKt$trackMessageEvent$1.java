package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageType;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModelEventsHelperKt$trackMessageEvent$1", f = "ChatViewModelEventsHelper.kt", i = {}, l = {25, 30}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModelEventsHelperKt$trackMessageEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29621h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29622i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MessageMetadata f29623j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f29624k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModelEventsHelperKt$trackMessageEvent$1(ChatViewModel chatViewModel, MessageMetadata messageMetadata, boolean z11, Continuation<? super ChatViewModelEventsHelperKt$trackMessageEvent$1> continuation) {
        super(2, continuation);
        this.f29622i = chatViewModel;
        this.f29623j = messageMetadata;
        this.f29624k = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModelEventsHelperKt$trackMessageEvent$1(this.f29622i, this.f29623j, this.f29624k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModelEventsHelperKt$trackMessageEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29621h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MessageEventsTracker messageEvents$customerchat_basicRelease = this.f29622i.getMessageEvents$customerchat_basicRelease();
            EventMetadata eventMetadata$customerchat_basicRelease = this.f29622i.getEventMetadata$customerchat_basicRelease();
            if (eventMetadata$customerchat_basicRelease == null) {
                return Unit.INSTANCE;
            }
            MessageMetadata messageMetadata = this.f29623j;
            this.f29621h = 1;
            if (messageEvents$customerchat_basicRelease.trackMessageSentEvent(eventMetadata$customerchat_basicRelease, messageMetadata, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.f29624k) {
            MessageEventsTracker messageEvents$customerchat_basicRelease2 = this.f29622i.getMessageEvents$customerchat_basicRelease();
            EventMetadata eventMetadata$customerchat_basicRelease2 = this.f29622i.getEventMetadata$customerchat_basicRelease();
            if (eventMetadata$customerchat_basicRelease2 == null) {
                return Unit.INSTANCE;
            }
            MessageMetadata messageMetadata2 = new MessageMetadata(this.f29623j.getCorrelationId(), (MessageType) null, 0, 0, (String) null, (Boolean) null, this.f29623j.getQuickResponse(), 62, (DefaultConstructorMarker) null);
            this.f29621h = 2;
            if (messageEvents$customerchat_basicRelease2.trackMessageQuickResponseSelectedEvent(eventMetadata$customerchat_basicRelease2, messageMetadata2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
