package com.deliveryhero.customerchat.voip;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl", f = "VOIPEventsImpl.kt", i = {0, 0}, l = {38, 41}, m = "ifTrackingEnabled", n = {"this", "block"}, s = {"L$0", "L$1"})
public final class VOIPEventsImpl$ifTrackingEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f30062h;

    /* renamed from: i  reason: collision with root package name */
    public Object f30063i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f30064j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VOIPEventsImpl f30065k;

    /* renamed from: l  reason: collision with root package name */
    public int f30066l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VOIPEventsImpl$ifTrackingEnabled$1(VOIPEventsImpl vOIPEventsImpl, Continuation<? super VOIPEventsImpl$ifTrackingEnabled$1> continuation) {
        super(continuation);
        this.f30065k = vOIPEventsImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30064j = obj;
        this.f30066l |= Integer.MIN_VALUE;
        return this.f30065k.ifTrackingEnabled((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
