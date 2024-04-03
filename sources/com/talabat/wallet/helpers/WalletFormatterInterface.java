package com.talabat.wallet.helpers;

import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\"\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J'\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "", "EMPTY_STRING", "", "getEMPTY_STRING", "()Ljava/lang/String;", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "dateFormatter", "date", "inputFormat", "outputFormat", "formatAmountWithSign", "amount", "", "shouldSignChange", "", "isCurrencyFirst", "(Ljava/lang/Float;ZZ)Ljava/lang/String;", "getAmountSign", "(Ljava/lang/Float;)Ljava/lang/String;", "getAmountWithoutCurrency", "getAmountWithoutCurrencyWithSign", "getCurrencyLocale", "getMonthAndYearForMapingAndGrouping", "getSubstringUntilFirstNumber", "source", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletFormatterInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String dateFormatter(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str2, "inputFormat");
            Intrinsics.checkNotNullParameter(str3, "outputFormat");
            try {
                Date parse = new SimpleDateFormat(str2, Locale.ENGLISH).parse(str);
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                if (GlobalDataModel.SelectedLanguage == GlobalConstants.ARABIC) {
                    String format = new SimpleDateFormat(str3, new Locale(ArchiveStreamFactory.AR)).format(instance.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(outputF…e(\"ar\")).format(cal.time)");
                    return format;
                }
                String format2 = new SimpleDateFormat(str3, new Locale("en")).format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format2, "SimpleDateFormat(outputF…e(\"en\")).format(cal.time)");
                return format2;
            } catch (Exception unused) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
        }

        @NotNull
        public static String formatAmountWithSign(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable Float f11, boolean z11, boolean z12) {
            if (f11 == null) {
                return "";
            }
            f11.floatValue();
            String currencyLocale = walletFormatterInterface.getCurrencyLocale();
            String amountWithoutCurrency = walletFormatterInterface.getAmountWithoutCurrency(f11);
            String str = "+";
            if (((double) f11.floatValue()) < 0.0d) {
                if (!z11) {
                    str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
                }
                amountWithoutCurrency = walletFormatterInterface.getAmountWithoutCurrency(Float.valueOf(f11.floatValue() * ((float) -1)));
            } else if (z11) {
                str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            }
            if (TalabatUtils.isArabic()) {
                String amountWithoutCurrencyWithSign = walletFormatterInterface.getAmountWithoutCurrencyWithSign(f11);
                return amountWithoutCurrencyWithSign + " " + currencyLocale;
            } else if (z12) {
                return str + currencyLocale + " " + amountWithoutCurrency;
            } else {
                return str + amountWithoutCurrency + " " + currencyLocale;
            }
        }

        @NotNull
        public static String getAmountSign(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable Float f11) {
            if (f11 == null) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
            if (f11.floatValue() > 0.0f) {
                return "+";
            }
            return "";
        }

        @NotNull
        public static String getAmountWithoutCurrency(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable Float f11) {
            if (f11 == null || TalabatFormatter.getInstance() == null || TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false) == null) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
            String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false);
            Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…(amount.toFloat(), false)");
            return formattedCurrency;
        }

        @NotNull
        public static String getAmountWithoutCurrencyWithSign(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable Float f11) {
            if (f11 == null) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
            try {
                if (f11.floatValue() > 0.0f) {
                    String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue(), false);
                    return "+" + formattedCurrency;
                }
                String formattedCurrency2 = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue() * ((float) -1), false);
                return SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + formattedCurrency2;
            } catch (Exception unused) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
        }

        @NotNull
        public static String getCurrencyLocale(@NotNull WalletFormatterInterface walletFormatterInterface) {
            if (TalabatFormatter.getInstance() == null || TalabatFormatter.getInstance().getCurrencySymbol() == null) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
            String currencySymbol = TalabatFormatter.getInstance().getCurrencySymbol();
            Intrinsics.checkNotNullExpressionValue(currencySymbol, "getInstance().currencySymbol");
            return currencySymbol;
        }

        @NotNull
        public static String getMonthAndYearForMapingAndGrouping(@NotNull WalletFormatterInterface walletFormatterInterface, @Nullable String str) {
            try {
                String input_date_format = walletFormatterInterface.getINPUT_DATE_FORMAT();
                Locale locale = Locale.ENGLISH;
                Date parse = new SimpleDateFormat(input_date_format, locale).parse(str);
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                String format = new SimpleDateFormat(walletFormatterInterface.getOUT_DATE_FORMAT(), locale).format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(OUT_DAT…ENGLISH).format(cal.time)");
                return format;
            } catch (Exception unused) {
                return walletFormatterInterface.getEMPTY_STRING();
            }
        }

        private static String getSubstringUntilFirstNumber(WalletFormatterInterface walletFormatterInterface, String str) {
            List list;
            boolean z11;
            List<String> split = new Regex("[-0-9]").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (!z11) {
                        list = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            list = CollectionsKt__CollectionsKt.emptyList();
            Object[] array = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return ((String[]) array)[0];
        }
    }

    @NotNull
    String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    String formatAmountWithSign(@Nullable Float f11, boolean z11, boolean z12);

    @NotNull
    String getAmountSign(@Nullable Float f11);

    @NotNull
    String getAmountWithoutCurrency(@Nullable Float f11);

    @NotNull
    String getAmountWithoutCurrencyWithSign(@Nullable Float f11);

    @NotNull
    String getCurrencyLocale();

    @NotNull
    String getEMPTY_STRING();

    @NotNull
    String getINPUT_DATE_FORMAT();

    @NotNull
    String getMonthAndYearForMapingAndGrouping(@Nullable String str);

    @NotNull
    String getOUT_DATE_FORMAT();
}
