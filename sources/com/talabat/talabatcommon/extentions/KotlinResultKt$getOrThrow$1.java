package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt", f = "KotlinResult.kt", i = {}, l = {187}, m = "getOrThrow", n = {}, s = {})
public final class KotlinResultKt$getOrThrow$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f47029h;

    /* renamed from: i  reason: collision with root package name */
    public int f47030i;

    public KotlinResultKt$getOrThrow$1(Continuation<? super KotlinResultKt$getOrThrow$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f47029h = obj;
        this.f47030i |= Integer.MIN_VALUE;
        return KotlinResultKt.getOrThrow((Function1) null, this);
    }
}
