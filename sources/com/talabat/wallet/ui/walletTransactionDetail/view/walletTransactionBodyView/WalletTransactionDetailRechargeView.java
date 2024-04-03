package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.RechargeWalletTransactionTypeDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionDetailRechargeView;", "Landroid/widget/LinearLayout;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;", "addViewToParent", "", "model", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRechargeView extends LinearLayout implements CreditCardHelperInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private RechargeWalletTransactionTypeDisplayModel displayModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRechargeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RechargeWalletTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (PaymentWalletTransactionDisplayModel) null, (CashBackWalletTransactionModel) null, 7, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_recharge_view, this);
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

    public final void addViewToParent(@NotNull RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel) {
        Intrinsics.checkNotNullParameter(rechargeWalletTransactionTypeDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
        this.displayModel = rechargeWalletTransactionTypeDisplayModel;
        String cardType = rechargeWalletTransactionTypeDisplayModel.getPayment().getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_logo);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_logo");
        setCardTypeIcon(cardType, imageView);
        boolean z11 = false;
        ((TextView) _$_findCachedViewById(R.id.credit_card_name)).setText(getResources().getString(com.talabat.localization.R.string.credit_card_name_string_transaction_detail, new Object[]{this.displayModel.getPayment().getCardType(), this.displayModel.getPayment().getCard4Digits()}));
        ((TextView) _$_findCachedViewById(R.id.credit_card_amount_deducted)).setText(CurrencyFormatter.Companion.formatAmountWithSign(locationConfigurationRepository, this.displayModel.getHeaderInfo().getAmount(), true));
        Context context = getContext();
        if (context != null) {
            if (this.displayModel.getCashBack().getAmount() == 0.0f) {
                z11 = true;
            }
            if (!z11) {
                WalletTransactionDetailCashBackView walletTransactionDetailCashBackView = WalletTransactionDetailCashBackView.INSTANCE;
                View _$_findCachedViewById = _$_findCachedViewById(R.id.recharge_cash_back_container);
                Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "recharge_cash_back_container");
                TextView textView = (TextView) _$_findCachedViewById(R.id.cashback_amount);
                Intrinsics.checkNotNullExpressionValue(textView, "cashback_amount");
                walletTransactionDetailCashBackView.addCashBackView(locationConfigurationRepository, context, _$_findCachedViewById, textView, this.displayModel.getCashBack().getAmount(), com.talabat.talabatcommon.R.color.talabat_red);
            }
        }
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRechargeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RechargeWalletTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (PaymentWalletTransactionDisplayModel) null, (CashBackWalletTransactionModel) null, 7, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_recharge_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRechargeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RechargeWalletTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (PaymentWalletTransactionDisplayModel) null, (CashBackWalletTransactionModel) null, 7, (DefaultConstructorMarker) null);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_recharge_view, this);
    }
}
