package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput", f = "ApplyVoucherUseCaseOutput.kt", i = {0, 0, 0}, l = {43}, m = "invoke", n = {"this", "voucherData", "branchId"}, s = {"L$0", "L$1", "L$2"})
public final class ApplyVoucherUseCaseOutput$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61603h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61604i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61605j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f61606k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherUseCaseOutput f61607l;

    /* renamed from: m  reason: collision with root package name */
    public int f61608m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherUseCaseOutput$invoke$1(ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput, Continuation<? super ApplyVoucherUseCaseOutput$invoke$1> continuation) {
        super(continuation);
        this.f61607l = applyVoucherUseCaseOutput;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61606k = obj;
        this.f61608m |= Integer.MIN_VALUE;
        return this.f61607l.invoke((VoucherData) null, 0.0f, (String) null, (String) null, (String) null, 0, (List<? extends CartMenuItem>) null, 0, this);
    }
}
