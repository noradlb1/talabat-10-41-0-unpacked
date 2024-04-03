package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput", f = "ApplyVoucherUseCaseOutput.kt", i = {0, 0, 0, 0}, l = {169}, m = "applyVoucher-bMdYcbs", n = {"this", "voucherData", "cartItems", "orderTotalAmount"}, s = {"L$0", "L$1", "L$2", "F$0"})
public final class ApplyVoucherUseCaseOutput$applyVoucher$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61596h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61597i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61598j;

    /* renamed from: k  reason: collision with root package name */
    public float f61599k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f61600l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherUseCaseOutput f61601m;

    /* renamed from: n  reason: collision with root package name */
    public int f61602n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherUseCaseOutput$applyVoucher$1(ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput, Continuation<? super ApplyVoucherUseCaseOutput$applyVoucher$1> continuation) {
        super(continuation);
        this.f61601m = applyVoucherUseCaseOutput;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61600l = obj;
        this.f61602n |= Integer.MIN_VALUE;
        Object r92 = this.f61601m.m10932applyVoucherbMdYcbs((VoucherData) null, (String) null, 0, 0.0f, (List<? extends CartMenuItem>) null, 0, this);
        return r92 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r92 : Result.m6328boximpl(r92);
    }
}
