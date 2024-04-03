package com.talabat.wallet.checkoutbinvoucher.domain.business.usecase;

import buisnessmodels.Cart;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase", f = "GetOrderVoucherUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {27}, m = "invoke", n = {"this", "binVoucherCheckEligibilityModel", "mobileNumber", "binNumber", "cart", "nonVoucherEligibleModel", "selectedAreaId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class GetOrderVoucherUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12517h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12518i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12519j;

    /* renamed from: k  reason: collision with root package name */
    public Object f12520k;

    /* renamed from: l  reason: collision with root package name */
    public Object f12521l;

    /* renamed from: m  reason: collision with root package name */
    public Object f12522m;

    /* renamed from: n  reason: collision with root package name */
    public int f12523n;

    /* renamed from: o  reason: collision with root package name */
    public /* synthetic */ Object f12524o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ GetOrderVoucherUseCase f12525p;

    /* renamed from: q  reason: collision with root package name */
    public int f12526q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetOrderVoucherUseCase$invoke$1(GetOrderVoucherUseCase getOrderVoucherUseCase, Continuation<? super GetOrderVoucherUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12525p = getOrderVoucherUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12524o = obj;
        this.f12526q |= Integer.MIN_VALUE;
        return this.f12525p.invoke((BinVoucherCheckEligibilityModel) null, (String) null, 0, (String) null, (Cart) null, this);
    }
}
