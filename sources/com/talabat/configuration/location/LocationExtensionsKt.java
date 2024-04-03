package com.talabat.configuration.location;

import com.talabat.configuration.country.Country;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DECIMAL_PATTERN_COMMA", "", "DECIMAL_PATTERN_DEFAULT", "decimalPatterByNumberOfDecimalPlaces", "numberOfDecimalPlaces", "", "decimalPattern", "Lcom/talabat/configuration/location/Country;", "com_talabat_core_configuration_remote_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LocationExtensionsKt {
    @NotNull
    public static final String DECIMAL_PATTERN_COMMA = "#,###,###.###";
    @NotNull
    public static final String DECIMAL_PATTERN_DEFAULT = "0.";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.IRAQ.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final String decimalPatterByNumberOfDecimalPlaces(int i11) {
        return i11 == 0 ? DECIMAL_PATTERN_COMMA : DECIMAL_PATTERN_DEFAULT;
    }

    public static /* synthetic */ String decimalPatterByNumberOfDecimalPlaces$default(int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 2;
        }
        return decimalPatterByNumberOfDecimalPlaces(i11);
    }

    @NotNull
    public static final String decimalPattern(@Nullable Country country) {
        Country country2;
        String str;
        if (!(country == null || (country2 = country.getCountry()) == null)) {
            if (WhenMappings.$EnumSwitchMapping$0[country2.ordinal()] == 1) {
                str = decimalPatterByNumberOfDecimalPlaces(country.getNumberOfDecimalPlaces());
            } else {
                str = DECIMAL_PATTERN_DEFAULT;
            }
            if (str != null) {
                return str;
            }
        }
        return decimalPatterByNumberOfDecimalPlaces(0);
    }
}
