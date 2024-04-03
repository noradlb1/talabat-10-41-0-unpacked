package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase", f = "GetQPayDeflectionSavedCardUseCase.kt", i = {0, 0, 0}, l = {18}, m = "invoke", n = {"cardList", "$this$invoke_u24lambda_u2d0", "isQPayServiceDown"}, s = {"L$0", "L$1", "Z$0"})
public final class GetQPayDeflectionSavedCardUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public boolean f11918h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11919i;

    /* renamed from: j  reason: collision with root package name */
    public Object f11920j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11921k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ GetQPayDeflectionSavedCardUseCase f11922l;

    /* renamed from: m  reason: collision with root package name */
    public int f11923m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetQPayDeflectionSavedCardUseCase$invoke$1(GetQPayDeflectionSavedCardUseCase getQPayDeflectionSavedCardUseCase, Continuation<? super GetQPayDeflectionSavedCardUseCase$invoke$1> continuation) {
        super(continuation);
        this.f11922l = getQPayDeflectionSavedCardUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f11921k = obj;
        this.f11923m |= Integer.MIN_VALUE;
        return this.f11922l.invoke(false, this);
    }
}
