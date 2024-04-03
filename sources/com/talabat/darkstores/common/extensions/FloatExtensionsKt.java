package com.talabat.darkstores.common.extensions;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.di.ApplicationComponent;
import com.talabat.darkstores.di.Injector;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\b\u001a.\u0010\u0011\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0003\u0010\u0016\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f\u001a\u0016\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0019*\u00020\b¨\u0006\u001a"}, d2 = {"getCurrencySymbol", "", "currency", "Ljava/util/Currency;", "isNegative", "", "getFormattedAmount", "amount", "", "applyForegroundColorSpan", "Landroid/text/SpannableStringBuilder;", "promotionColor", "", "applyTextAppearanceSpan", "textAppearanceSpan", "Landroid/text/style/TextAppearanceSpan;", "formatCurrency", "getFormattedPriceAndCurrency", "", "context", "Landroid/content/Context;", "hasPrevPrice", "amountFontStyle", "currencyTextStyle", "getPriceAndCurrency", "Lkotlin/Pair;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FloatExtensionsKt {
    private static final SpannableStringBuilder applyForegroundColorSpan(SpannableStringBuilder spannableStringBuilder, int i11) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i11), 0, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    private static final SpannableStringBuilder applyTextAppearanceSpan(SpannableStringBuilder spannableStringBuilder, TextAppearanceSpan textAppearanceSpan) {
        spannableStringBuilder.setSpan(textAppearanceSpan, 0, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    @NotNull
    public static final String formatCurrency(float f11) {
        ApplicationComponent appComponent = Injector.INSTANCE.getAppComponent();
        if (appComponent == null) {
            return String.valueOf(f11);
        }
        Currency instance = Currency.getInstance(appComponent.getConfigurationParameters().getCurrencyCode());
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
        boolean z11 = true;
        numberInstance.setMinimumFractionDigits(1);
        numberInstance.setMinimumFractionDigits(instance.getDefaultFractionDigits());
        numberInstance.setMaximumFractionDigits(instance.getDefaultFractionDigits());
        if (f11 >= 0.0f) {
            z11 = false;
        }
        if (z11) {
            f11 = -f11;
        }
        String format = numberInstance.format(Float.valueOf(f11));
        if (TalabatUtils.isRTL()) {
            if (z11) {
                String symbol = instance.getSymbol();
                return format + " " + symbol + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            }
            String symbol2 = instance.getSymbol();
            return format + " " + symbol2;
        } else if (z11) {
            String symbol3 = instance.getSymbol();
            return SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + symbol3 + " " + format;
        } else {
            String symbol4 = instance.getSymbol();
            return symbol4 + " " + format;
        }
    }

    private static final String getCurrencySymbol(Currency currency, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        if (TalabatUtils.isRTL()) {
            sb2.append(" ");
            sb2.append(currency.getSymbol());
            if (z11) {
                sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            }
        } else {
            if (z11) {
                sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            }
            sb2.append(currency.getSymbol());
            sb2.append(" ");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    private static final String getFormattedAmount(Currency currency, float f11) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
        numberInstance.setMinimumFractionDigits(currency.getDefaultFractionDigits());
        numberInstance.setMaximumFractionDigits(currency.getDefaultFractionDigits());
        String format = numberInstance.format(Float.valueOf(Math.abs(f11)));
        Intrinsics.checkNotNullExpressionValue(format, "amountFormat.format(abs(amount))");
        return format;
    }

    @NotNull
    public static final CharSequence getFormattedPriceAndCurrency(float f11, @NotNull Context context, boolean z11, @StyleRes int i11, @StyleRes int i12) {
        boolean z12;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(context, "context");
        ApplicationComponent appComponent = Injector.INSTANCE.getAppComponent();
        if (appComponent == null) {
            return "";
        }
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(context, i12);
        TextAppearanceSpan textAppearanceSpan2 = new TextAppearanceSpan(context, i11);
        Currency instance = Currency.getInstance(appComponent.getConfigurationParameters().getCurrencyCode());
        Intrinsics.checkNotNullExpressionValue(instance, "currency");
        String formattedAmount = getFormattedAmount(instance, f11);
        if (f11 < 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        SpannableStringBuilder applyTextAppearanceSpan = applyTextAppearanceSpan(new SpannableStringBuilder(getCurrencySymbol(instance, z12)), textAppearanceSpan);
        SpannableStringBuilder applyTextAppearanceSpan2 = applyTextAppearanceSpan(new SpannableStringBuilder(formattedAmount), textAppearanceSpan2);
        if (z11) {
            int color = ContextCompat.getColor(context, R.color.ds_promo_100);
            applyForegroundColorSpan(applyTextAppearanceSpan2, color);
            applyForegroundColorSpan(applyTextAppearanceSpan, color);
        } else {
            int color2 = ContextCompat.getColor(context, R.color.ds_neutral_100);
            applyForegroundColorSpan(applyTextAppearanceSpan2, color2);
            applyForegroundColorSpan(applyTextAppearanceSpan, color2);
        }
        if (TalabatUtils.isRTL()) {
            charSequence = TextUtils.concat(new CharSequence[]{applyTextAppearanceSpan2, applyTextAppearanceSpan});
        } else {
            charSequence = TextUtils.concat(new CharSequence[]{applyTextAppearanceSpan, applyTextAppearanceSpan2});
        }
        Intrinsics.checkNotNullExpressionValue(charSequence, "result");
        return charSequence;
    }

    public static /* synthetic */ CharSequence getFormattedPriceAndCurrency$default(float f11, Context context, boolean z11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = R.style.DSTextAppearance_Heading2;
        }
        if ((i13 & 8) != 0) {
            i12 = R.style.DSTextAppearance_Caption;
        }
        return getFormattedPriceAndCurrency(f11, context, z11, i11, i12);
    }

    @NotNull
    public static final Pair<String, String> getPriceAndCurrency(float f11) {
        ApplicationComponent appComponent = Injector.INSTANCE.getAppComponent();
        if (appComponent == null) {
            return TuplesKt.to(String.valueOf(f11), "");
        }
        try {
            Currency instance = Currency.getInstance(appComponent.getConfigurationParameters().getCurrencyCode());
            String format = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f11)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return TuplesKt.to(format, instance.getSymbol());
        } catch (Exception unused) {
            return TuplesKt.to(String.valueOf(f11), "");
        }
    }
}
