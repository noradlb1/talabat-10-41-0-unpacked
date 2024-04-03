package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase", f = "GuestWelcomeVoucherUseCase.kt", i = {0}, l = {17}, m = "invoke", n = {"countryCode"}, s = {"I$0"})
public final class GuestWelcomeVoucherUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public int f61616h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61617i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GuestWelcomeVoucherUseCase f61618j;

    /* renamed from: k  reason: collision with root package name */
    public int f61619k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuestWelcomeVoucherUseCase$invoke$1(GuestWelcomeVoucherUseCase guestWelcomeVoucherUseCase, Continuation<? super GuestWelcomeVoucherUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61618j = guestWelcomeVoucherUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61617i = obj;
        this.f61619k |= Integer.MIN_VALUE;
        return this.f61618j.invoke(0, this);
    }
}
