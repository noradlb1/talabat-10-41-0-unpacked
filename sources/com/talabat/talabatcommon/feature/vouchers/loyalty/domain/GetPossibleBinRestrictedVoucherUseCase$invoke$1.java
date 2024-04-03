package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase", f = "GetPossibleBinRestrictedVoucherUseCase.kt", i = {0, 1}, l = {29, 31}, m = "invoke", n = {"customerVoucherId", "customerVoucherId"}, s = {"L$0", "L$0"})
public final class GetPossibleBinRestrictedVoucherUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61612h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetPossibleBinRestrictedVoucherUseCase f61614j;

    /* renamed from: k  reason: collision with root package name */
    public int f61615k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPossibleBinRestrictedVoucherUseCase$invoke$1(GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase, Continuation<? super GetPossibleBinRestrictedVoucherUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61614j = getPossibleBinRestrictedVoucherUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61613i = obj;
        this.f61615k |= Integer.MIN_VALUE;
        return this.f61614j.invoke((String) null, (String) null, (Integer) null, 0, this);
    }
}
