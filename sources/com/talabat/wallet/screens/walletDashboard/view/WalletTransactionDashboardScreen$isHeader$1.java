package com.talabat.wallet.screens.walletDashboard.view;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreen$isHeader$1 extends Lambda implements Function1<Integer, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreen f12688g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDashboardScreen$isHeader$1(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
        super(1);
        this.f12688g = walletTransactionDashboardScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Boolean invoke(int i11) {
        RecyclerView.Adapter adapter = ((RecyclerView) this.f12688g._$_findCachedViewById(R.id.wallet_transaction_list)).getAdapter();
        if (adapter != null) {
            return Boolean.valueOf(((WalletCreditTransactionListAdapter) adapter).getItem().get(i11).getTypeId() == this.f12688g.HEADER_VIEW_TYPE);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.wallet.screens.walletDashboard.view.WalletCreditTransactionListAdapter");
    }
}
