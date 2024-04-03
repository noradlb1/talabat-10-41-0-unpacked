package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.CommonViewTransactionTypeDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailTransactionCommonView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;", "addViewToContainer", "", "model", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDetailTransactionCommonView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private CommonViewTransactionTypeDisplayModel displayModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionCommonView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new CommonViewTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (CashBackWalletTransactionModel) null, 3, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_transaction_detail_common_view, this);
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

    public final void addViewToContainer(@NotNull CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel) {
        Intrinsics.checkNotNullParameter(commonViewTransactionTypeDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.displayModel = commonViewTransactionTypeDisplayModel;
        boolean z11 = false;
        if (commonViewTransactionTypeDisplayModel.getHeaderInfo().getExpiryDays() <= 0) {
            ((TextView) _$_findCachedViewById(R.id.expiry_date)).setText(getResources().getString(com.talabat.localization.R.string.refund_expiry_date_zero));
        } else {
            ((TextView) _$_findCachedViewById(R.id.expiry_date)).setText(getResources().getString(com.talabat.localization.R.string.refund_expiry_date_string, new Object[]{String.valueOf(this.displayModel.getHeaderInfo().getExpiryDays())}));
        }
        Context context = getContext();
        if (context != null) {
            if (this.displayModel.getCashBack().getAmount() == 0.0f) {
                z11 = true;
            }
            if (!z11) {
                LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
                WalletTransactionDetailCashBackView walletTransactionDetailCashBackView = WalletTransactionDetailCashBackView.INSTANCE;
                View _$_findCachedViewById = _$_findCachedViewById(R.id.common_view_cash_back_container);
                Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "common_view_cash_back_container");
                TextView textView = (TextView) _$_findCachedViewById(R.id.cashback_amount);
                Intrinsics.checkNotNullExpressionValue(textView, "cashback_amount");
                walletTransactionDetailCashBackView.addCashBackView(locationConfigurationRepository, context, _$_findCachedViewById, textView, this.displayModel.getCashBack().getAmount(), com.talabat.talabatcommon.R.color.talabat_red);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionCommonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new CommonViewTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (CashBackWalletTransactionModel) null, 3, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_transaction_detail_common_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionCommonView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new CommonViewTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (CashBackWalletTransactionModel) null, 3, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_transaction_detail_common_view, this);
    }
}
