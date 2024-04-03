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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl", f = "MessageEventsTrackerImpl.kt", i = {0}, l = {18, 19}, m = "ifTrackingEnabled", n = {"block"}, s = {"L$0"})
public final class MessageEventsTrackerImpl$ifTrackingEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29954h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f29955i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MessageEventsTrackerImpl f29956j;

    /* renamed from: k  reason: collision with root package name */
    public int f29957k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageEventsTrackerImpl$ifTrackingEnabled$1(MessageEventsTrackerImpl messageEventsTrackerImpl, Continuation<? super MessageEventsTrackerImpl$ifTrackingEnabled$1> continuation) {
        super(continuation);
        this.f29956j = messageEventsTrackerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29955i = obj;
        this.f29957k |= Integer.MIN_VALUE;
        return this.f29956j.ifTrackingEnabled((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
