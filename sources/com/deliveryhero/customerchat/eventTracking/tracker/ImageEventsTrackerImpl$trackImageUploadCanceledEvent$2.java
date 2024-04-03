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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2", f = "ImageEventsTrackerImpl.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29936h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageEventsTrackerImpl f29937i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29938j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageMetadata f29939k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2(ImageEventsTrackerImpl imageEventsTrackerImpl, EventMetadata eventMetadata, ImageMetadata imageMetadata, Continuation<? super ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2> continuation) {
        super(1, continuation);
        this.f29937i = imageEventsTrackerImpl;
        this.f29938j = eventMetadata;
        this.f29939k = imageMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2(this.f29937i, this.f29938j, this.f29939k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ImageEventsTrackerImpl$trackImageUploadCanceledEvent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29936h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Analytics access$getAnalytics$p = this.f29937i.analytics;
            EventCreationRequest createImageUploadCanceledEvent = this.f29937i.factory.createImageUploadCanceledEvent(this.f29938j, this.f29939k);
            this.f29936h = 1;
            if (access$getAnalytics$p.track(createImageUploadCanceledEvent, this) == coroutine_suspended) {
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
