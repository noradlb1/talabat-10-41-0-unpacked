package com.talabat.wallet.debitcarddeflection.domain.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase", f = "GetBinsDetailDisplayModelUseCase.kt", i = {}, l = {20, 22}, m = "invoke", n = {}, s = {})
public final class GetBinsDetailDisplayModelUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12566h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12567i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetBinsDetailDisplayModelUseCase f12568j;

    /* renamed from: k  reason: collision with root package name */
    public int f12569k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBinsDetailDisplayModelUseCase$invoke$1(GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase, Continuation<? super GetBinsDetailDisplayModelUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12568j = getBinsDetailDisplayModelUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12567i = obj;
        this.f12569k |= Integer.MIN_VALUE;
        return this.f12568j.invoke((String) null, this);
    }
}
