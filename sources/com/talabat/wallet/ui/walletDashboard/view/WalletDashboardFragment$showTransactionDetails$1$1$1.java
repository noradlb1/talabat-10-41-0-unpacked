package com.talabat.wallet.ui.walletDashboard.view;

import android.content.Intent;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionDetailsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$showTransactionDetails$1$1$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailsDisplayModel f12758g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardFragment$showTransactionDetails$1$1$1(WalletTransactionDetailsDisplayModel walletTransactionDetailsDisplayModel) {
        super(1);
        this.f12758g = walletTransactionDetailsDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$$receiver");
        intent.putExtra("transactionId", this.f12758g.getId());
        intent.putExtra("transactionType", this.f12758g.getTypeId());
    }
}
