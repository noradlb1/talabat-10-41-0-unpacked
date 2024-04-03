package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2", f = "ChatEventsTrackerImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29906h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatEventsTrackerImpl f29907i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29908j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2(ChatEventsTrackerImpl chatEventsTrackerImpl, EventMetadata eventMetadata, Continuation<? super ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2> continuation) {
        super(1, continuation);
        this.f29907i = chatEventsTrackerImpl;
        this.f29908j = eventMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2(this.f29907i, this.f29908j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ChatEventsTrackerImpl$trackChatClientDisconnectedEvent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29906h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29907i.analytics;
            EventCreationRequest createChatClientDisconnectedEvent = this.f29907i.factory.createChatClientDisconnectedEvent(this.f29908j);
            this.f29906h = 1;
            if (access$getAnalytics$p.track(createChatClientDisconnectedEvent, this) == coroutine_suspended) {
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
