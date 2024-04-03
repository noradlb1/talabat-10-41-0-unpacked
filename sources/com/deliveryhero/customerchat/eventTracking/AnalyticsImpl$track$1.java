package com.deliveryhero.customerchat.eventTracking;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.eventTracking.AnalyticsImpl", f = "AnalyticsImpl.kt", i = {0, 0}, l = {22}, m = "track", n = {"this", "event"}, s = {"L$0", "L$1"})
public final class AnalyticsImpl$track$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29829h;

    /* renamed from: i  reason: collision with root package name */
    public Object f29830i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f29831j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnalyticsImpl f29832k;

    /* renamed from: l  reason: collision with root package name */
    public int f29833l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnalyticsImpl$track$1(AnalyticsImpl analyticsImpl, Continuation<? super AnalyticsImpl$track$1> continuation) {
        super(continuation);
        this.f29832k = analyticsImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29831j = obj;
        this.f29833l |= Integer.MIN_VALUE;
        return this.f29832k.track((EventCreationRequest) null, this);
    }
}
