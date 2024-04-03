package com.deliveryhero.customerchat.analytics.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt", f = "AnalyticsServiceResult.kt", i = {}, l = {19}, m = "handleApi", n = {}, s = {})
public final class AnalyticsServiceResultKt$handleApi$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f29815h;

    /* renamed from: i  reason: collision with root package name */
    public int f29816i;

    public AnalyticsServiceResultKt$handleApi$1(Continuation<? super AnalyticsServiceResultKt$handleApi$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29815h = obj;
        this.f29816i |= Integer.MIN_VALUE;
        return AnalyticsServiceResultKt.handleApi((Function1) null, this);
    }
}
