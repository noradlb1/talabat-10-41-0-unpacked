package com.deliveryhero.customerchat.eventTracking.tracker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTrackerImpl", f = "ImageEventsTrackerImpl.kt", i = {0}, l = {16, 17}, m = "ifTrackingEnabled", n = {"block"}, s = {"L$0"})
public final class ImageEventsTrackerImpl$ifTrackingEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29919h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f29920i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImageEventsTrackerImpl f29921j;

    /* renamed from: k  reason: collision with root package name */
    public int f29922k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageEventsTrackerImpl$ifTrackingEnabled$1(ImageEventsTrackerImpl imageEventsTrackerImpl, Continuation<? super ImageEventsTrackerImpl$ifTrackingEnabled$1> continuation) {
        super(continuation);
        this.f29921j = imageEventsTrackerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29920i = obj;
        this.f29922k |= Integer.MIN_VALUE;
        return this.f29921j.ifTrackingEnabled((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
