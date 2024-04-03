package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.RefundSentWalletTransactionTypeDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionDetailRefundSent;", "Landroid/widget/LinearLayout;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionRefundView$WalletRefundOrderDetailInterface;", "addViewToParent", "", "model", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;", "setWalletRefundOrderDetailListener", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRefundSent extends LinearLayout implements CreditCardHelperInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private WalletTransactionRefundView.WalletRefundOrderDetailInterface listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRefundSent(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_sent, this);
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m6083_init_$lambda0(WalletTransactionDetailRefundSent walletTransactionDetailRefundSent, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundSent, "this$0");
        WalletTransactionRefundView.WalletRefundOrderDetailInterface walletRefundOrderDetailInterface = walletTransactionDetailRefundSent.listener;
        if (walletRefundOrderDetailInterface != null) {
            walletRefundOrderDetailInterface.navigateToHelpCenter();
        }
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

    public final void addViewToParent(@NotNull RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel) {
        Intrinsics.checkNotNullParameter(refundSentWalletTransactionTypeDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        PaymentMethod.Companion companion = PaymentMethod.Companion;
        PaymentMethod fromInt = companion.fromInt(refundSentWalletTransactionTypeDisplayModel.getPaymentDisplay().getPaymentMethod());
        String cardType = refundSentWalletTransactionTypeDisplayModel.getPaymentDisplay().getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_icon);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_icon");
        displayPaymentIcon(fromInt, cardType, imageView);
        PaymentMethod fromInt2 = companion.fromInt(refundSentWalletTransactionTypeDisplayModel.getPaymentDisplay().getPaymentMethod());
        String cardType2 = refundSentWalletTransactionTypeDisplayModel.getPaymentDisplay().getCardType();
        String takeLast = StringsKt___StringsKt.takeLast(refundSentWalletTransactionTypeDisplayModel.getPaymentDisplay().getCard4Digits(), 4);
        TextView textView = (TextView) _$_findCachedViewById(R.id.card_name);
        Intrinsics.checkNotNullExpressionValue(textView, "card_name");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        displayPaymentName(fromInt2, cardType2, takeLast, textView, context);
        ((TextView) _$_findCachedViewById(R.id.bank_refund_duration_message)).setText(getContext().getString(com.talabat.localization.R.string.bank_revert_message, new Object[]{String.valueOf(refundSentWalletTransactionTypeDisplayModel.getRefundDisplay().getRevertMinDays()), String.valueOf(refundSentWalletTransactionTypeDisplayModel.getRefundDisplay().getRevertMaxDays())}));
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

    public final void setWalletRefundOrderDetailListener(@NotNull WalletTransactionRefundView.WalletRefundOrderDetailInterface walletRefundOrderDetailInterface) {
        Intrinsics.checkNotNullParameter(walletRefundOrderDetailInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = walletRefundOrderDetailInterface;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRefundSent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_sent, this);
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new c(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRefundSent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_sent, this);
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new c(this));
    }
}
