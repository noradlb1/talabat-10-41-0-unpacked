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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$trackInAppCallButtonShown$2", f = "CallEventsTrackerImpl.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
public final class CallEventsTrackerImpl$trackInAppCallButtonShown$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29846h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CallEventsTrackerImpl f29847i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29848j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CallMetadata f29849k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallEventsTrackerImpl$trackInAppCallButtonShown$2(CallEventsTrackerImpl callEventsTrackerImpl, EventMetadata eventMetadata, CallMetadata callMetadata, Continuation<? super CallEventsTrackerImpl$trackInAppCallButtonShown$2> continuation) {
        super(1, continuation);
        this.f29847i = callEventsTrackerImpl;
        this.f29848j = eventMetadata;
        this.f29849k = callMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CallEventsTrackerImpl$trackInAppCallButtonShown$2(this.f29847i, this.f29848j, this.f29849k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((CallEventsTrackerImpl$trackInAppCallButtonShown$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29846h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29847i.analytics;
            EventCreationRequest createInAppCallButtonShown = this.f29847i.factory.createInAppCallButtonShown(this.f29848j, this.f29849k);
            this.f29846h = 1;
            if (access$getAnalytics$p.track(createInAppCallButtonShown, this) == coroutine_suspended) {
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
