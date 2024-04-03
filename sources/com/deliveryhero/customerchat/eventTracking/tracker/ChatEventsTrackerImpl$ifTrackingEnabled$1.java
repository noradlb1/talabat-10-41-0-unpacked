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
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.tracker.ChatEventsTrackerImpl", f = "ChatEventsTrackerImpl.kt", i = {0}, l = {17, 18}, m = "ifTrackingEnabled", n = {"block"}, s = {"L$0"})
public final class ChatEventsTrackerImpl$ifTrackingEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29902h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f29903i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatEventsTrackerImpl f29904j;

    /* renamed from: k  reason: collision with root package name */
    public int f29905k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatEventsTrackerImpl$ifTrackingEnabled$1(ChatEventsTrackerImpl chatEventsTrackerImpl, Continuation<? super ChatEventsTrackerImpl$ifTrackingEnabled$1> continuation) {
        super(continuation);
        this.f29904j = chatEventsTrackerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29903i = obj;
        this.f29905k |= Integer.MIN_VALUE;
        return this.f29904j.ifTrackingEnabled((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
