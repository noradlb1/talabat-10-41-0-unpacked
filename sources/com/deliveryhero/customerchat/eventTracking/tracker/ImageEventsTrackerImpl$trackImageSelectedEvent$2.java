package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTrackerImpl$trackImageSelectedEvent$2", f = "ImageEventsTrackerImpl.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class ImageEventsTrackerImpl$trackImageSelectedEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29932h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageEventsTrackerImpl f29933i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29934j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageMetadata f29935k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageEventsTrackerImpl$trackImageSelectedEvent$2(ImageEventsTrackerImpl imageEventsTrackerImpl, EventMetadata eventMetadata, ImageMetadata imageMetadata, Continuation<? super ImageEventsTrackerImpl$trackImageSelectedEvent$2> continuation) {
        super(1, continuation);
        this.f29933i = imageEventsTrackerImpl;
        this.f29934j = eventMetadata;
        this.f29935k = imageMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ImageEventsTrackerImpl$trackImageSelectedEvent$2(this.f29933i, this.f29934j, this.f29935k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ImageEventsTrackerImpl$trackImageSelectedEvent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29932h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29933i.analytics;
            EventCreationRequest createImageSelectedEvent = this.f29933i.factory.createImageSelectedEvent(this.f29934j, this.f29935k);
            this.f29932h = 1;
            if (access$getAnalytics$p.track(createImageSelectedEvent, this) == coroutine_suspended) {
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
