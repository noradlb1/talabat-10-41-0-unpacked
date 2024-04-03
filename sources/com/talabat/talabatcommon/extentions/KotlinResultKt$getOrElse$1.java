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
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt", f = "KotlinResult.kt", i = {0}, l = {194}, m = "getOrElse", n = {"onFailure"}, s = {"L$0"})
public final class KotlinResultKt$getOrElse$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f47026h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f47027i;

    /* renamed from: j  reason: collision with root package name */
    public int f47028j;

    public KotlinResultKt$getOrElse$1(Continuation<? super KotlinResultKt$getOrElse$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f47027i = obj;
        this.f47028j |= Integer.MIN_VALUE;
        return KotlinResultKt.getOrElse((Function1) null, (Function1<? super Throwable, Unit>) null, this);
    }
}
