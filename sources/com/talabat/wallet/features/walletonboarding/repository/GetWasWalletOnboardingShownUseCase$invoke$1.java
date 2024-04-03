package com.talabat.wallet.features.walletonboarding.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase", f = "GetWasWalletOnboardingShownUseCase.kt", i = {}, l = {9}, m = "invoke", n = {}, s = {})
public final class GetWasWalletOnboardingShownUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12604h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetWasWalletOnboardingShownUseCase f12605i;

    /* renamed from: j  reason: collision with root package name */
    public int f12606j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWasWalletOnboardingShownUseCase$invoke$1(GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase, Continuation<? super GetWasWalletOnboardingShownUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12605i = getWasWalletOnboardingShownUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12604h = obj;
        this.f12606j |= Integer.MIN_VALUE;
        return this.f12605i.invoke(this);
    }
}
