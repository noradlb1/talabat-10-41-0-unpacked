package com.talabat.feature.tpro.presentation.util;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/DisplayAmountUtil;", "", "()V", "getDisplayAmount", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "value", "", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisplayAmountUtil {
    @NotNull
    public static final DisplayAmountUtil INSTANCE = new DisplayAmountUtil();

    private DisplayAmountUtil() {
    }

    @NotNull
    public final String getDisplayAmount(@NotNull LocationConfigurationRepository locationConfigurationRepository, double d11) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Country selectedCountry = locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null) {
            return "";
        }
        return StringsKt__StringsKt.trim((CharSequence) CurrencyFormatter.Companion.getFormattedCurrency(d11, true, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(selectedCountry))).toString();
    }

    @NotNull
    public final String getDisplayAmount(@NotNull LocationConfigurationRepository locationConfigurationRepository, float f11) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        return getDisplayAmount(locationConfigurationRepository, (double) f11);
    }
}
