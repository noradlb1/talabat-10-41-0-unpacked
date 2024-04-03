package com.adyen.checkout.ui.internal.common.util;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.SurchargeConfiguration;
import com.adyen.checkout.util.AmountFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class SurchargeFormat {
    private static final double BASIS_POINTS_DIVIDER = 10000.0d;
    private static final float SPAN_SIZE_PROPORTION = 0.875f;

    private SurchargeFormat() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static CharSequence format(@NonNull Context context, @NonNull SurchargeConfiguration surchargeConfiguration) {
        CharSequence charSequence;
        long surchargeFixedCost = surchargeConfiguration.getSurchargeFixedCost();
        int surchargeVariableCost = surchargeConfiguration.getSurchargeVariableCost();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = null;
        if (surchargeFixedCost > 0) {
            charSequence = AmountFormat.format(context, surchargeFixedCost, surchargeConfiguration.getSurchargeCurrencyCode());
        } else {
            charSequence = null;
        }
        if (surchargeVariableCost > 0) {
            NumberFormat percentInstance = NumberFormat.getPercentInstance(getLocale(context));
            percentInstance.setMinimumFractionDigits(0);
            percentInstance.setMaximumFractionDigits(2);
            str = percentInstance.format(((double) surchargeVariableCost) / BASIS_POINTS_DIVIDER);
        }
        if (charSequence != null) {
            spannableStringBuilder.append("(+").append(charSequence);
            if (str == null) {
                spannableStringBuilder.append(")");
            } else {
                spannableStringBuilder.append(" ");
            }
        }
        if (str != null) {
            if (charSequence == null) {
                spannableStringBuilder.append("(");
            }
            spannableStringBuilder.append("+").append(str).append(")");
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new RelativeSizeSpan(SPAN_SIZE_PROPORTION), 0, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ThemeUtil.getAttributeColor(context, 16842808)), 0, length, 33);
        return spannableStringBuilder;
    }

    @NonNull
    private static Locale getLocale(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context.getResources().getConfiguration().locale;
        }
        return context.getResources().getConfiguration().getLocales().get(0);
    }
}
