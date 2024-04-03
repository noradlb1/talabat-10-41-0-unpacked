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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$trackMessageDeliveredEvent$2", f = "MessageEventsTrackerImpl.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class MessageEventsTrackerImpl$trackMessageDeliveredEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29962h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MessageEventsTrackerImpl f29963i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29964j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MessageMetadata f29965k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageEventsTrackerImpl$trackMessageDeliveredEvent$2(MessageEventsTrackerImpl messageEventsTrackerImpl, EventMetadata eventMetadata, MessageMetadata messageMetadata, Continuation<? super MessageEventsTrackerImpl$trackMessageDeliveredEvent$2> continuation) {
        super(1, continuation);
        this.f29963i = messageEventsTrackerImpl;
        this.f29964j = eventMetadata;
        this.f29965k = messageMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MessageEventsTrackerImpl$trackMessageDeliveredEvent$2(this.f29963i, this.f29964j, this.f29965k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((MessageEventsTrackerImpl$trackMessageDeliveredEvent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29962h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29963i.analytics;
            EventCreationRequest createMessageDeliveredEvent = this.f29963i.factory.createMessageDeliveredEvent(this.f29964j, this.f29965k);
            this.f29962h = 1;
            if (access$getAnalytics$p.track(createMessageDeliveredEvent, this) == coroutine_suspended) {
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
