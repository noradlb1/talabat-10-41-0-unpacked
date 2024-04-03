package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.UtilsKt", f = "utils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {14, 16, 20, 23}, m = "retryIf", n = {"backoff", "predicate", "block", "currentDelay", "backoff", "predicate", "block", "currentDelay", "e", "backoff", "predicate", "block", "currentDelay"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
public final class UtilsKt$retryIf$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55507h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55508i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55509j;

    /* renamed from: k  reason: collision with root package name */
    public Object f55510k;

    /* renamed from: l  reason: collision with root package name */
    public Object f55511l;

    /* renamed from: m  reason: collision with root package name */
    public int f55512m;

    /* renamed from: n  reason: collision with root package name */
    public int f55513n;

    /* renamed from: o  reason: collision with root package name */
    public /* synthetic */ Object f55514o;

    /* renamed from: p  reason: collision with root package name */
    public int f55515p;

    public UtilsKt$retryIf$1(Continuation<? super UtilsKt$retryIf$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55514o = obj;
        this.f55515p |= Integer.MIN_VALUE;
        return UtilsKt.retryIf(0, (Backoff) null, (Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, (Function1) null, this);
    }
}
