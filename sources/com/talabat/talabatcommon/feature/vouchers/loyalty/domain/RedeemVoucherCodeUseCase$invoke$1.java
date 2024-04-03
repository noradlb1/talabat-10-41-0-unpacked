package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase", f = "RedeemVoucherCodeUseCase.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {39, 41}, m = "invoke", n = {"this", "voucherCode", "brandId", "screenName", "screenType", "countryCode", "this", "voucherCode", "brandId", "screenName", "screenType", "countryCode"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
public final class RedeemVoucherCodeUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61627h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61628i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61629j;

    /* renamed from: k  reason: collision with root package name */
    public Object f61630k;

    /* renamed from: l  reason: collision with root package name */
    public Object f61631l;

    /* renamed from: m  reason: collision with root package name */
    public int f61632m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f61633n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherCodeUseCase f61634o;

    /* renamed from: p  reason: collision with root package name */
    public int f61635p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemVoucherCodeUseCase$invoke$1(RedeemVoucherCodeUseCase redeemVoucherCodeUseCase, Continuation<? super RedeemVoucherCodeUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61634o = redeemVoucherCodeUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61633n = obj;
        this.f61635p |= Integer.MIN_VALUE;
        return this.f61634o.invoke((String) null, (String) null, 0, (Integer) null, (String) null, (String) null, this);
    }
}
