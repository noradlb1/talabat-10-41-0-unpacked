package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newText", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenFragment$addTextChangeListener$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpScreenFragment f12808g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTopUpScreenFragment$addTextChangeListener$1(WalletTopUpScreenFragment walletTopUpScreenFragment) {
        super(1);
        this.f12808g = walletTopUpScreenFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        if (str != null) {
            WalletTopUpScreenFragment walletTopUpScreenFragment = this.f12808g;
            if (str.length() == 0) {
                walletTopUpScreenFragment.clearTopUpButton();
                return;
            }
            WalletPaymentOptionViewModel access$getWalletPaymentOptionViewModel$p = walletTopUpScreenFragment.walletPaymentOptionViewModel;
            if (access$getWalletPaymentOptionViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
                access$getWalletPaymentOptionViewModel$p = null;
            }
            access$getWalletPaymentOptionViewModel$p.onTopUpAmountChanged(str);
        }
    }
}
