package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase", f = "AddVoucherCodeUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {24, 31}, m = "invoke", n = {"this", "voucherCode", "brandId", "branchId", "groceryVendorId", "cartItems", "orderTotalAmount", "areaId", "verticalId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "I$0", "I$1"})
public final class AddVoucherCodeUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61584h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61585i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61586j;

    /* renamed from: k  reason: collision with root package name */
    public Object f61587k;

    /* renamed from: l  reason: collision with root package name */
    public Object f61588l;

    /* renamed from: m  reason: collision with root package name */
    public Object f61589m;

    /* renamed from: n  reason: collision with root package name */
    public float f61590n;

    /* renamed from: o  reason: collision with root package name */
    public int f61591o;

    /* renamed from: p  reason: collision with root package name */
    public int f61592p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f61593q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ AddVoucherCodeUseCase f61594r;

    /* renamed from: s  reason: collision with root package name */
    public int f61595s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddVoucherCodeUseCase$invoke$1(AddVoucherCodeUseCase addVoucherCodeUseCase, Continuation<? super AddVoucherCodeUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61594r = addVoucherCodeUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61593q = obj;
        this.f61595s |= Integer.MIN_VALUE;
        return this.f61594r.invoke(0.0f, (String) null, (String) null, 0, 0, (String) null, (String) null, (List<? extends CartMenuItem>) null, 0, this);
    }
}
