package com.talabat.feature.fees.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.fees.domain.usecase.GetFeesUseCase", f = "GetFeesUseCase.kt", i = {0, 0}, l = {26}, m = "invoke", n = {"this", "subtotalBeforeDiscounts"}, s = {"L$0", "F$0"})
public final class GetFeesUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58532h;

    /* renamed from: i  reason: collision with root package name */
    public float f58533i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f58534j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetFeesUseCase f58535k;

    /* renamed from: l  reason: collision with root package name */
    public int f58536l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetFeesUseCase$invoke$1(GetFeesUseCase getFeesUseCase, Continuation<? super GetFeesUseCase$invoke$1> continuation) {
        super(continuation);
        this.f58535k = getFeesUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58534j = obj;
        this.f58536l |= Integer.MIN_VALUE;
        return this.f58535k.invoke(0.0f, 0.0f, 0.0f, 0.0d, 0.0d, this);
    }
}
