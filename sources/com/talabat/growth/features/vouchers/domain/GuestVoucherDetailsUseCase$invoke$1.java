package com.talabat.growth.features.vouchers.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase", f = "GuestVoucherDetailsUseCase.kt", i = {0, 0, 0}, l = {20}, m = "invoke", n = {"this", "voucherCode", "countryCode"}, s = {"L$0", "L$1", "I$0"})
public final class GuestVoucherDetailsUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f60576h;

    /* renamed from: i  reason: collision with root package name */
    public Object f60577i;

    /* renamed from: j  reason: collision with root package name */
    public int f60578j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f60579k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ GuestVoucherDetailsUseCase f60580l;

    /* renamed from: m  reason: collision with root package name */
    public int f60581m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuestVoucherDetailsUseCase$invoke$1(GuestVoucherDetailsUseCase guestVoucherDetailsUseCase, Continuation<? super GuestVoucherDetailsUseCase$invoke$1> continuation) {
        super(continuation);
        this.f60580l = guestVoucherDetailsUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f60579k = obj;
        this.f60581m |= Integer.MIN_VALUE;
        return this.f60580l.invoke((String) null, 0, this);
    }
}
