package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase", f = "IsQPayServiceDownUseCase.kt", i = {0, 0}, l = {11, 15}, m = "invoke", n = {"this", "isDebitCardAccepted"}, s = {"L$0", "Z$0"})
public final class IsQPayServiceDownUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f11924h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11925i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11926j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IsQPayServiceDownUseCase f11927k;

    /* renamed from: l  reason: collision with root package name */
    public int f11928l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsQPayServiceDownUseCase$invoke$1(IsQPayServiceDownUseCase isQPayServiceDownUseCase, Continuation<? super IsQPayServiceDownUseCase$invoke$1> continuation) {
        super(continuation);
        this.f11927k = isQPayServiceDownUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f11926j = obj;
        this.f11928l |= Integer.MIN_VALUE;
        return this.f11927k.invoke(false, this);
    }
}
