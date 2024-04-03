package com.talabat.wallet.ui.walletDashboard.view;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$isHeader$1 extends Lambda implements Function1<Integer, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12753g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardFragment$isHeader$1(WalletDashboardFragment walletDashboardFragment) {
        super(1);
        this.f12753g = walletDashboardFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Boolean invoke(int i11) {
        RecyclerView.Adapter adapter = ((RecyclerView) this.f12753g._$_findCachedViewById(R.id.wallet_transaction_list)).getAdapter();
        if (adapter != null) {
            return Boolean.valueOf(((WalletTransactionListAdapter) adapter).getItems().get(i11).getViewTypeId() == 2);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter");
    }
}
