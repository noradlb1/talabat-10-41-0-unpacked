package com.talabat.wallet.debitcarddeflection.domain.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.debitcarddeflection.domain.business.GetBinVerificationDisplayModelUseCase", f = "GetBinVerificationDisplayModelUseCase.kt", i = {}, l = {19, 22}, m = "invoke", n = {}, s = {})
public final class GetBinVerificationDisplayModelUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12562h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12563i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetBinVerificationDisplayModelUseCase f12564j;

    /* renamed from: k  reason: collision with root package name */
    public int f12565k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBinVerificationDisplayModelUseCase$invoke$1(GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase, Continuation<? super GetBinVerificationDisplayModelUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12564j = getBinVerificationDisplayModelUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12563i = obj;
        this.f12565k |= Integer.MIN_VALUE;
        return this.f12564j.invoke((String) null, this);
    }
}
