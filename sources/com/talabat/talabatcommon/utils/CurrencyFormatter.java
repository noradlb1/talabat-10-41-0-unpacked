package com.talabat.talabatcommon.utils;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/utils/CurrencyFormatter;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrencyFormatter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static String decimalPattern = LocationExtensionsKt.decimalPatterByNumberOfDecimalPlaces$default(0, 1, (Object) null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/utils/CurrencyFormatter$Companion;", "", "()V", "decimalPattern", "", "formatAmount", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "amount", "", "showCurrency", "", "formatAmountWithSign", "formatAmountWithoutDecimalsIfPossible", "getFormattedCurrency", "value", "", "currency", "numberOfDecimalPlaces", "", "decimalCharacter", "isDouble", "str", "priceFormatPattern", "Ljava/text/DecimalFormat;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String formatAmount$default(Companion companion, LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            return companion.formatAmount(locationConfigurationRepository, f11, z11);
        }

        public static /* synthetic */ String formatAmountWithSign$default(Companion companion, LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            return companion.formatAmountWithSign(locationConfigurationRepository, f11, z11);
        }

        public static /* synthetic */ String formatAmountWithoutDecimalsIfPossible$default(Companion companion, LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            return companion.formatAmountWithoutDecimalsIfPossible(locationConfigurationRepository, f11, z11);
        }

        public static /* synthetic */ String getFormattedCurrency$default(Companion companion, String str, boolean z11, String str2, int i11, String str3, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                z11 = false;
            }
            boolean z12 = z11;
            if ((i12 & 16) != 0) {
                str3 = CurrencyFormatter.decimalPattern;
            }
            return companion.getFormattedCurrency(str, z12, str2, i11, str3);
        }

        @NotNull
        public final String formatAmount(@NotNull LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11) {
            float f12 = f11;
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            Country selectedCountry = locationConfigurationRepository.selectedCountry();
            if (selectedCountry != null) {
                return getFormattedCurrency((double) f12, z11, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(selectedCountry));
            }
            return getFormattedCurrency((double) f12, z11, "", 2, CurrencyFormatter.decimalPattern);
        }

        @NotNull
        public final String formatAmountWithSign(@NotNull LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11) {
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            if (f11 >= 0.0f) {
                String formatAmount = formatAmount(locationConfigurationRepository, f11, z11);
                return "+" + formatAmount;
            }
            String formatAmount2 = formatAmount(locationConfigurationRepository, f11 * ((float) -1), z11);
            return SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + formatAmount2;
        }

        @NotNull
        public final String formatAmountWithoutDecimalsIfPossible(@NotNull LocationConfigurationRepository locationConfigurationRepository, float f11, boolean z11) {
            boolean z12;
            String str;
            int i11;
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            Country selectedCountry = locationConfigurationRepository.selectedCountry();
            Intrinsics.checkNotNull(selectedCountry);
            String decimalPattern = LocationExtensionsKt.decimalPattern(selectedCountry);
            int numberOfDecimalPlaces = selectedCountry.getNumberOfDecimalPlaces();
            double d11 = (double) f11;
            if (((float) Math.ceil(d11)) == ((float) Math.floor(d11))) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                str = "";
                i11 = 0;
            } else {
                str = decimalPattern;
                i11 = numberOfDecimalPlaces;
            }
            return getFormattedCurrency(d11, z11, selectedCountry.getCurrencyCode(), i11, str);
        }

        @NotNull
        public final String getFormattedCurrency(@NotNull String str, boolean z11, @NotNull String str2, int i11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(str2, "currency");
            Intrinsics.checkNotNullParameter(str3, "decimalCharacter");
            CurrencyFormatter.decimalPattern = str3;
            try {
                return getFormattedCurrency(Double.parseDouble(str), z11, str2, i11, str3);
            } catch (Exception unused) {
                return str;
            }
        }

        public final boolean isDouble(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }

        @NotNull
        public final DecimalFormat priceFormatPattern(int i11) {
            NumberFormat instance = NumberFormat.getInstance(Locale.US);
            if (instance != null) {
                DecimalFormat decimalFormat = (DecimalFormat) instance;
                String access$getDecimalPattern$cp = CurrencyFormatter.decimalPattern;
                Iterator it = RangesKt___RangesKt.until(0, i11).iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    access$getDecimalPattern$cp = access$getDecimalPattern$cp + "0";
                }
                decimalFormat.applyPattern(access$getDecimalPattern$cp);
                return decimalFormat;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
        }

        public static /* synthetic */ String getFormattedCurrency$default(Companion companion, double d11, boolean z11, String str, int i11, String str2, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                z11 = false;
            }
            boolean z12 = z11;
            if ((i12 & 16) != 0) {
                str2 = CurrencyFormatter.decimalPattern;
            }
            return companion.getFormattedCurrency(d11, z12, str, i11, str2);
        }

        @NotNull
        public final String getFormattedCurrency(double d11, boolean z11, @NotNull String str, int i11, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str2, "decimalCharacter");
            CurrencyFormatter.decimalPattern = str2;
            DecimalFormat priceFormatPattern = priceFormatPattern(i11);
            if (z11) {
                if (str.length() > 0) {
                    String format = priceFormatPattern.format(d11);
                    return str + " " + format;
                }
            }
            String format2 = priceFormatPattern.format(d11);
            Intrinsics.checkNotNullExpressionValue(format2, "decimalFormat.format(value)");
            return format2;
        }
    }
}
