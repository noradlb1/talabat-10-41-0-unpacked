package com.deliveryhero.customerchat.voip;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl", f = "VOIPEventsImpl.kt", i = {0, 1}, l = {30, 32, 33}, m = "getFeatureFlags", n = {"this", "$this$getFeatureFlags_u24lambda_u2d0"}, s = {"L$0", "L$0"})
public final class VOIPEventsImpl$getFeatureFlags$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f30058h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f30059i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VOIPEventsImpl f30060j;

    /* renamed from: k  reason: collision with root package name */
    public int f30061k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VOIPEventsImpl$getFeatureFlags$1(VOIPEventsImpl vOIPEventsImpl, Continuation<? super VOIPEventsImpl$getFeatureFlags$1> continuation) {
        super(continuation);
        this.f30060j = vOIPEventsImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30059i = obj;
        this.f30061k |= Integer.MIN_VALUE;
        return this.f30060j.getFeatureFlags(this);
    }
}
