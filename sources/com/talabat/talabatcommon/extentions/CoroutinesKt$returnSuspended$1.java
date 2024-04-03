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
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.CoroutinesKt", f = "Coroutines.kt", i = {0, 0}, l = {38}, m = "returnSuspended", n = {"onError", "defaultValue"}, s = {"L$0", "L$1"})
public final class CoroutinesKt$returnSuspended$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f46988h;

    /* renamed from: i  reason: collision with root package name */
    public Object f46989i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f46990j;

    /* renamed from: k  reason: collision with root package name */
    public int f46991k;

    public CoroutinesKt$returnSuspended$1(Continuation<? super CoroutinesKt$returnSuspended$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f46990j = obj;
        this.f46991k |= Integer.MIN_VALUE;
        return CoroutinesKt.returnSuspended((Function1<? super Throwable, Unit>) null, null, (Function1) null, this);
    }
}
