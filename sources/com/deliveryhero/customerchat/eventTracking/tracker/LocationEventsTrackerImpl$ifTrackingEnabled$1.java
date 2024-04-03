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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.LocationEventsTrackerImpl", f = "LocationEventsTrackerImpl.kt", i = {0}, l = {15, 16}, m = "ifTrackingEnabled", n = {"block"}, s = {"L$0"})
public final class LocationEventsTrackerImpl$ifTrackingEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29944h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f29945i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LocationEventsTrackerImpl f29946j;

    /* renamed from: k  reason: collision with root package name */
    public int f29947k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationEventsTrackerImpl$ifTrackingEnabled$1(LocationEventsTrackerImpl locationEventsTrackerImpl, Continuation<? super LocationEventsTrackerImpl$ifTrackingEnabled$1> continuation) {
        super(continuation);
        this.f29946j = locationEventsTrackerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29945i = obj;
        this.f29947k |= Integer.MIN_VALUE;
        return this.f29946j.ifTrackingEnabled((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
