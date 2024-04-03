package com.talabat.feature.walletaddcard.domain.usecase;

import com.talabat.feature.walletaddcard.domain.model.BankCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase", f = "GetCardTokenUseCase.kt", i = {}, l = {13}, m = "invoke", n = {}, s = {})
public final class GetCardTokenUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59430h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetCardTokenUseCase f59431i;

    /* renamed from: j  reason: collision with root package name */
    public int f59432j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCardTokenUseCase$invoke$1(GetCardTokenUseCase getCardTokenUseCase, Continuation<? super GetCardTokenUseCase$invoke$1> continuation) {
        super(continuation);
        this.f59431i = getCardTokenUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59430h = obj;
        this.f59432j |= Integer.MIN_VALUE;
        return this.f59431i.invoke((BankCard) null, this);
    }
}
