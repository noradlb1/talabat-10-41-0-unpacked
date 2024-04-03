package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailCreditVoucherView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addViewToParent", "", "model", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDetailCreditVoucherView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailCreditVoucherView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_voucher_credit_view, this);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void addViewToParent(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ((TextView) _$_findCachedViewById(R.id.voucher_amount)).setText(CurrencyFormatter.Companion.formatAmount$default(CurrencyFormatter.Companion, ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository(), walletTransactionDetailHeaderDisplayModel.getAmount(), false, 4, (Object) null));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailCreditVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_voucher_credit_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailCreditVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_voucher_credit_view, this);
    }
}
