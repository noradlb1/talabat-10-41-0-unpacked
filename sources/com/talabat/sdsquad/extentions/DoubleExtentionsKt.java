package com.talabat.sdsquad.extentions;

import com.talabat.configuration.location.LocationExtensionsKt;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"priceFormatPattern", "Ljava/text/DecimalFormat;", "numberOfDecimalPlaces", "", "setPriceWithCurrencyFormat", "", "", "showCurrency", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DoubleExtentionsKt {
    private static final DecimalFormat priceFormatPattern(int i11) {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        if (instance != null) {
            DecimalFormat decimalFormat = (DecimalFormat) instance;
            Iterator it = RangesKt___RangesKt.until(0, i11).iterator();
            String str = LocationExtensionsKt.DECIMAL_PATTERN_DEFAULT;
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                str = str + "0";
            }
            decimalFormat.applyPattern(str);
            return decimalFormat;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
    }

    @NotNull
    public static final String setPriceWithCurrencyFormat(double d11, boolean z11) {
        DecimalFormat priceFormatPattern = priceFormatPattern(3);
        if (z11) {
            String format = priceFormatPattern.format(d11);
            return "kd " + format;
        }
        String format2 = priceFormatPattern.format(d11);
        return " " + format2;
    }

    public static /* synthetic */ String setPriceWithCurrencyFormat$default(double d11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return setPriceWithCurrencyFormat(d11, z11);
    }
}
