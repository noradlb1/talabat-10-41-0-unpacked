package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase", f = "GetQPayDeflectionBinsUseCase.kt", i = {0, 0}, l = {15, 17}, m = "invoke", n = {"binsCsv", "$this$invoke_u24lambda_u2d0"}, s = {"L$0", "L$1"})
public final class GetQPayDeflectionBinsUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f11913h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11914i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11915j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetQPayDeflectionBinsUseCase f11916k;

    /* renamed from: l  reason: collision with root package name */
    public int f11917l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetQPayDeflectionBinsUseCase$invoke$1(GetQPayDeflectionBinsUseCase getQPayDeflectionBinsUseCase, Continuation<? super GetQPayDeflectionBinsUseCase$invoke$1> continuation) {
        super(continuation);
        this.f11916k = getQPayDeflectionBinsUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f11915j = obj;
        this.f11917l |= Integer.MIN_VALUE;
        return this.f11916k.invoke((String) null, this);
    }
}
