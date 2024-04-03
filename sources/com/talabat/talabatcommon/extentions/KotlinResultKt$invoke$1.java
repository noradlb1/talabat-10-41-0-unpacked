package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt", f = "KotlinResult.kt", i = {0}, l = {254, 254, 254}, m = "invoke", n = {"$this$invoke_u24lambda_u2d8"}, s = {"L$1"})
public final class KotlinResultKt$invoke$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f47031h;

    /* renamed from: i  reason: collision with root package name */
    public Object f47032i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f47033j;

    /* renamed from: k  reason: collision with root package name */
    public int f47034k;

    public KotlinResultKt$invoke$1(Continuation<? super KotlinResultKt$invoke$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f47033j = obj;
        this.f47034k |= Integer.MIN_VALUE;
        return KotlinResultKt.invoke((Function1) null, (Function1) null, this);
    }
}
