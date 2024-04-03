package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$trackMessageSentEvent$2", f = "MessageEventsTrackerImpl.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class MessageEventsTrackerImpl$trackMessageSentEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29970h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MessageEventsTrackerImpl f29971i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29972j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MessageMetadata f29973k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageEventsTrackerImpl$trackMessageSentEvent$2(MessageEventsTrackerImpl messageEventsTrackerImpl, EventMetadata eventMetadata, MessageMetadata messageMetadata, Continuation<? super MessageEventsTrackerImpl$trackMessageSentEvent$2> continuation) {
        super(1, continuation);
        this.f29971i = messageEventsTrackerImpl;
        this.f29972j = eventMetadata;
        this.f29973k = messageMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MessageEventsTrackerImpl$trackMessageSentEvent$2(this.f29971i, this.f29972j, this.f29973k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((MessageEventsTrackerImpl$trackMessageSentEvent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29970h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29971i.analytics;
            EventCreationRequest createMessageSentEvent = this.f29971i.factory.createMessageSentEvent(this.f29972j, this.f29973k);
            this.f29970h = 1;
            if (access$getAnalytics$p.track(createMessageSentEvent, this) == coroutine_suspended) {
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
