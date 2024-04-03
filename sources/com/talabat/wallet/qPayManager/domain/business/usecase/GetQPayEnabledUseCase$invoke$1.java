package com.talabat.wallet.qPayManager.domain.business.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase", f = "GetQPayEnabledUseCase.kt", i = {0}, l = {10}, m = "invoke", n = {"isDebitCardAccepted"}, s = {"Z$0"})
public final class GetQPayEnabledUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public boolean f12656h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12657i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetQPayEnabledUseCase f12658j;

    /* renamed from: k  reason: collision with root package name */
    public int f12659k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetQPayEnabledUseCase$invoke$1(GetQPayEnabledUseCase getQPayEnabledUseCase, Continuation<? super GetQPayEnabledUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12658j = getQPayEnabledUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12657i = obj;
        this.f12659k |= Integer.MIN_VALUE;
        return this.f12658j.invoke(false, this);
    }
}
