package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionDetailCashBackView;", "", "()V", "addCashBackView", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "context", "Landroid/content/Context;", "cashBackContainer", "Landroid/view/View;", "textView", "Landroid/widget/TextView;", "amount", "", "colorId", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailCashBackView {
    @NotNull
    public static final WalletTransactionDetailCashBackView INSTANCE = new WalletTransactionDetailCashBackView();

    private WalletTransactionDetailCashBackView() {
    }

    public final void addCashBackView(@NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Context context, @NotNull View view, @NotNull TextView textView, float f11, int i11) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "cashBackContainer");
        Intrinsics.checkNotNullParameter(textView, "textView");
        view.setVisibility(0);
        if (f11 < 0.0f) {
            textView.setTextColor(ContextCompat.getColor(context, i11));
        }
        textView.setText(CurrencyFormatter.Companion.formatAmount(locationConfigurationRepository, f11, true));
    }
}
