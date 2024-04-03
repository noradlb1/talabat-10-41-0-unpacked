package com.talabat.wallet.ui.walletTopUp.viewModel;

import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase", f = "SetDebitCardsDeflectionUseCase.kt", i = {0, 0, 0, 0}, l = {22}, m = "invoke", n = {"this", "cards", "walletCards", "deflectionType"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class SetDebitCardsDeflectionUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12810h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12811i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12812j;

    /* renamed from: k  reason: collision with root package name */
    public Object f12813k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f12814l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SetDebitCardsDeflectionUseCase f12815m;

    /* renamed from: n  reason: collision with root package name */
    public int f12816n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetDebitCardsDeflectionUseCase$invoke$1(SetDebitCardsDeflectionUseCase setDebitCardsDeflectionUseCase, Continuation<? super SetDebitCardsDeflectionUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12815m = setDebitCardsDeflectionUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12814l = obj;
        this.f12816n |= Integer.MIN_VALUE;
        return this.f12815m.invoke((List<? extends WalletCreditCardListDataItemDisplayModel>) null, this);
    }
}
