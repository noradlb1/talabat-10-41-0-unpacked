package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$trackInAppCallTimedOut$2", f = "CallEventsTrackerImpl.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class CallEventsTrackerImpl$trackInAppCallTimedOut$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29890h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CallEventsTrackerImpl f29891i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29892j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CallMetadata f29893k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallEventsTrackerImpl$trackInAppCallTimedOut$2(CallEventsTrackerImpl callEventsTrackerImpl, EventMetadata eventMetadata, CallMetadata callMetadata, Continuation<? super CallEventsTrackerImpl$trackInAppCallTimedOut$2> continuation) {
        super(1, continuation);
        this.f29891i = callEventsTrackerImpl;
        this.f29892j = eventMetadata;
        this.f29893k = callMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CallEventsTrackerImpl$trackInAppCallTimedOut$2(this.f29891i, this.f29892j, this.f29893k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((CallEventsTrackerImpl$trackInAppCallTimedOut$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29890h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29891i.analytics;
            EventCreationRequest createInAppCallTimedOut = this.f29891i.factory.createInAppCallTimedOut(this.f29892j, this.f29893k);
            this.f29890h = 1;
            if (access$getAnalytics$p.track(createInAppCallTimedOut, this) == coroutine_suspended) {
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
