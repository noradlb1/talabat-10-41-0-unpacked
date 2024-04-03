package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.CoroutinesKt", f = "Coroutines.kt", i = {0}, l = {16}, m = "runSuspended", n = {"onError"}, s = {"L$0"})
public final class CoroutinesKt$runSuspended$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f46992h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f46993i;

    /* renamed from: j  reason: collision with root package name */
    public int f46994j;

    public CoroutinesKt$runSuspended$1(Continuation<? super CoroutinesKt$runSuspended$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f46993i = obj;
        this.f46994j |= Integer.MIN_VALUE;
        return CoroutinesKt.runSuspended((Function1<? super Throwable, Unit>) null, (Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
