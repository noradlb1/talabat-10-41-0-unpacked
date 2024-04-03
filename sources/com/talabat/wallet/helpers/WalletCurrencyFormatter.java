package com.talabat.wallet.helpers;

import buisnessmodels.TalabatFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/helpers/WalletCurrencyFormatter;", "", "EMPTY_STRING", "", "getEMPTY_STRING", "()Ljava/lang/String;", "getAmountWithoutCurrency", "amount", "", "(Ljava/lang/Float;)Ljava/lang/String;", "getAmountWithoutCurrencyWithSign", "getLocaleCurrency", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCurrencyFormatter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String getAmountWithoutCurrency(@NotNull WalletCurrencyFormatter walletCurrencyFormatter, @Nullable Float f11) {
            if (f11 == null || TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false) == null) {
                return walletCurrencyFormatter.getEMPTY_STRING();
            }
            String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false);
            Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…(amount.toFloat(), false)");
            return formattedCurrency;
        }

        @NotNull
        public static String getAmountWithoutCurrencyWithSign(@NotNull WalletCurrencyFormatter walletCurrencyFormatter, @Nullable Float f11) {
            if (f11 == null) {
                return walletCurrencyFormatter.getEMPTY_STRING();
            }
            if (f11.floatValue() > 0.0f) {
                String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false);
                return "+" + formattedCurrency;
            }
            String formattedCurrency2 = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false);
            Intrinsics.checkNotNullExpressionValue(formattedCurrency2, "getInstance().getFormatt…(amount.toFloat(), false)");
            return formattedCurrency2;
        }

        @NotNull
        public static String getLocaleCurrency(@NotNull WalletCurrencyFormatter walletCurrencyFormatter) {
            if (TalabatFormatter.getInstance() == null || TalabatFormatter.getInstance().getCurrencySymbol() == null) {
                return walletCurrencyFormatter.getEMPTY_STRING();
            }
            String currencySymbol = TalabatFormatter.getInstance().getCurrencySymbol();
            Intrinsics.checkNotNullExpressionValue(currencySymbol, "getInstance().currencySymbol");
            return currencySymbol;
        }
    }

    @NotNull
    String getAmountWithoutCurrency(@Nullable Float f11);

    @NotNull
    String getAmountWithoutCurrencyWithSign(@Nullable Float f11);

    @NotNull
    String getEMPTY_STRING();

    @NotNull
    String getLocaleCurrency();
}
