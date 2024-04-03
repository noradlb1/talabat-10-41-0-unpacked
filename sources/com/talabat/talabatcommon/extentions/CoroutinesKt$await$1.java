package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.CoroutinesKt", f = "Coroutines.kt", i = {0}, l = {108}, m = "await", n = {"defaultValue"}, s = {"L$0"})
public final class CoroutinesKt$await$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f46982h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f46983i;

    /* renamed from: j  reason: collision with root package name */
    public int f46984j;

    public CoroutinesKt$await$1(Continuation<? super CoroutinesKt$await$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f46983i = obj;
        this.f46984j |= Integer.MIN_VALUE;
        return CoroutinesKt.await((Deferred) null, null, this);
    }
}
