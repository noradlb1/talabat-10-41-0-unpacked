package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt", f = "KotlinResult.kt", i = {0, 0}, l = {181}, m = "fold", n = {"onFailure", "onSuccess"}, s = {"L$0", "L$1"})
public final class KotlinResultKt$fold$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f47022h;

    /* renamed from: i  reason: collision with root package name */
    public Object f47023i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f47024j;

    /* renamed from: k  reason: collision with root package name */
    public int f47025k;

    public KotlinResultKt$fold$1(Continuation<? super KotlinResultKt$fold$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f47024j = obj;
        this.f47025k |= Integer.MIN_VALUE;
        return KotlinResultKt.fold((Function1) null, (Function1) null, (Function1) null, this);
    }
}
