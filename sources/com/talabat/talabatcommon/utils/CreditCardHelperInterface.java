package com.talabat.talabatcommon.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J2\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "", "displayPaymentIcon", "", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "cardType", "", "imageView", "Landroid/widget/ImageView;", "displayPaymentName", "card4Digits", "textView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "setCardTypeIcon", "setExpiryInformation", "expiryMonth", "expiryYear", "expiryDate", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CreditCardHelperInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void displayPaymentIcon(@NotNull CreditCardHelperInterface creditCardHelperInterface, @NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
            Intrinsics.checkNotNullParameter(str, "cardType");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            int i11 = WhenMappings.$EnumSwitchMapping$0[paymentMethod.ordinal()];
            if (i11 == 1) {
                imageView.setImageResource(R.drawable.ic_knet);
            } else if (i11 != 2) {
                creditCardHelperInterface.setCardTypeIcon(str, imageView);
            } else {
                imageView.setImageResource(R.drawable.ic_naps);
            }
        }

        public static /* synthetic */ void displayPaymentIcon$default(CreditCardHelperInterface creditCardHelperInterface, PaymentMethod paymentMethod, String str, ImageView imageView, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    paymentMethod = PaymentMethod.NONE;
                }
                creditCardHelperInterface.displayPaymentIcon(paymentMethod, str, imageView);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayPaymentIcon");
        }

        public static void displayPaymentName(@NotNull CreditCardHelperInterface creditCardHelperInterface, @NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
            String str3;
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
            Intrinsics.checkNotNullParameter(str, "cardType");
            Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(context, "context");
            int i11 = WhenMappings.$EnumSwitchMapping$0[paymentMethod.ordinal()];
            if (i11 == 1) {
                str3 = paymentMethod.name();
            } else if (i11 != 2) {
                str3 = context.getString(com.talabat.localization.R.string.card_name, new Object[]{str, str2});
            } else {
                str3 = context.getString(com.talabat.localization.R.string.naps);
            }
            textView.setText(str3);
        }

        public static /* synthetic */ void displayPaymentName$default(CreditCardHelperInterface creditCardHelperInterface, PaymentMethod paymentMethod, String str, String str2, TextView textView, Context context, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    paymentMethod = PaymentMethod.NONE;
                }
                creditCardHelperInterface.displayPaymentName(paymentMethod, str, str2, textView, context);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayPaymentName");
        }

        public static void setCardTypeIcon(@NotNull CreditCardHelperInterface creditCardHelperInterface, @Nullable String str, @NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            if (str != null) {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
                String lowerCase2 = companion.visaCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.visa_icon);
                    return;
                }
                String lowerCase3 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
                String lowerCase4 = companion.masterCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.master_card_icon);
                    return;
                }
                String lowerCase5 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase()");
                String lowerCase6 = companion.amexCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) lowerCase6, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.amex_card_icon);
                    return;
                }
                String lowerCase7 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase7, "this as java.lang.String).toLowerCase()");
                String lowerCase8 = companion.dinersClubCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase8, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) lowerCase8, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_dinersclub);
                    return;
                }
                String lowerCase9 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase9, "this as java.lang.String).toLowerCase()");
                String lowerCase10 = companion.jcbCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase10, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase9, (CharSequence) lowerCase10, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_jcb);
                    return;
                }
                String lowerCase11 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase11, "this as java.lang.String).toLowerCase()");
                String lowerCase12 = companion.discoverCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase12, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase11, (CharSequence) lowerCase12, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_discover);
                    return;
                }
                String lowerCase13 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase13, "this as java.lang.String).toLowerCase()");
                String lowerCase14 = companion.maestroCardPayfortTypeString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase14, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase13, (CharSequence) lowerCase14, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_maestro);
                    return;
                }
                String lowerCase15 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase15, "this as java.lang.String).toLowerCase()");
                String lowerCase16 = PaymentMethod.CASH.name().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase16, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase15, (CharSequence) lowerCase16, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.ic_m_cash);
                    return;
                }
                String lowerCase17 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase17, "this as java.lang.String).toLowerCase()");
                String lowerCase18 = PaymentMethod.KNET.name().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase18, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase17, (CharSequence) lowerCase18, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.ic_knet);
                    return;
                }
                String lowerCase19 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase19, "this as java.lang.String).toLowerCase()");
                String lowerCase20 = DefaultCardView.ADD_CARD.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase20, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase19, (CharSequence) lowerCase20, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.ic_m_plus);
                    return;
                }
                String lowerCase21 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase21, "this as java.lang.String).toLowerCase()");
                String lowerCase22 = WalletCardType.MEEZA.getCardName().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase22, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase21, (CharSequence) lowerCase22, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.ic_meeza_card_icon);
                } else {
                    imageView.setImageResource(R.drawable.bt_ic_unknown);
                }
            }
        }

        public static void setExpiryInformation(@NotNull CreditCardHelperInterface creditCardHelperInterface, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
            Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            Intrinsics.checkNotNullParameter(textView, "expiryDate");
            if (context == null) {
                return;
            }
            if (WalletCardListMapper.Companion.hasCardExpired(str, str2)) {
                textView.setText(context.getResources().getString(com.talabat.localization.R.string.card_expired));
                textView.setTextColor(ContextCompat.getColor(context, R.color.talabat_red));
                return;
            }
            textView.setText(context.getResources().getString(com.talabat.localization.R.string.credit_card_expiry_date, new Object[]{str, str2}));
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethod.values().length];
            iArr[PaymentMethod.KNET.ordinal()] = 1;
            iArr[PaymentMethod.NAPS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView);

    void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context);

    void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView);

    void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context);
}
