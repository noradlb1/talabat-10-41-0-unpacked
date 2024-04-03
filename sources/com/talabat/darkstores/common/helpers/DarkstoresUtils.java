package com.talabat.darkstores.common.helpers;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.country.Country;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.visa.checkout.Profile;
import com.visa.checkout.PurchaseInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004J\u001a\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0004J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/common/helpers/DarkstoresUtils;", "", "()V", "DEFAULT_CUSTOMER_ID", "", "DJINI_ENTITY_EGYPT", "DJINI_ENTITY_PREFIX", "KURDISH_LANGUAGE_CODE", "TB_COUNTRY_CODE_EGYPT", "", "VALUE_NOT_AVAILABLE", "countriesByCode", "", "currenciesByCode", "getCountryCurrencyCode", "selectedCountryCode", "getCountryDjiniEntityId", "getCountryForDarkstores", "getCustomerId", "customerId", "getEnvironment", "Lcom/talabat/darkstores/data/Environment;", "instrumentationServer", "buildType", "getLanguage", "Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;", "selectedLanguage", "getLocale", "countryCode", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresUtils {
    @NotNull
    private static final String DEFAULT_CUSTOMER_ID = "0";
    @NotNull
    private static final String DJINI_ENTITY_EGYPT = "HF_EG";
    @NotNull
    private static final String DJINI_ENTITY_PREFIX = "TB_";
    @NotNull
    public static final DarkstoresUtils INSTANCE = new DarkstoresUtils();
    @NotNull
    private static final String KURDISH_LANGUAGE_CODE = "ku-SO";
    private static final int TB_COUNTRY_CODE_EGYPT = 9;
    @NotNull
    public static final String VALUE_NOT_AVAILABLE = "N/A";
    @NotNull
    private static final Map<Integer, String> countriesByCode = MapsKt__MapsKt.mapOf(TuplesKt.to(1, Country.KUWAIT.twoLetterCodeUpperCase()), TuplesKt.to(2, Country.KSA.twoLetterCodeUpperCase()), TuplesKt.to(3, Country.BAHRAIN.twoLetterCodeUpperCase()), TuplesKt.to(4, Country.UAE.twoLetterCodeUpperCase()), TuplesKt.to(5, Country.OMAN.twoLetterCodeUpperCase()), TuplesKt.to(6, Country.QATAR.twoLetterCodeUpperCase()), TuplesKt.to(7, Country.LEBANON.twoLetterCodeUpperCase()), TuplesKt.to(8, Country.JORDAN.twoLetterCodeUpperCase()), TuplesKt.to(9, Country.EGYPT.twoLetterCodeUpperCase()), TuplesKt.to(10, Country.IRAQ.twoLetterCodeUpperCase()));
    @NotNull
    private static final Map<Integer, String> currenciesByCode = MapsKt__MapsKt.mapOf(TuplesKt.to(1, PurchaseInfo.Currency.KWD), TuplesKt.to(2, PurchaseInfo.Currency.SAR), TuplesKt.to(3, "BHD"), TuplesKt.to(4, PurchaseInfo.Currency.AED), TuplesKt.to(5, "OMR"), TuplesKt.to(6, PurchaseInfo.Currency.QAR), TuplesKt.to(7, "LBP"), TuplesKt.to(8, "JOD"), TuplesKt.to(9, "EGP"), TuplesKt.to(10, "IQD"));

    private DarkstoresUtils() {
    }

    public static /* synthetic */ String getCustomerId$default(DarkstoresUtils darkstoresUtils, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = IntegrationGlobalDataModel.Companion.customerID();
        }
        return darkstoresUtils.getCustomerId(str);
    }

    public static /* synthetic */ Environment getEnvironment$default(DarkstoresUtils darkstoresUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = TalabatEnvironment.INSTANCE.getEnvironment();
        }
        if ((i11 & 2) != 0) {
            str2 = "release";
        }
        return darkstoresUtils.getEnvironment(str, str2);
    }

    public static /* synthetic */ DarkstoresMainActivity.Language getLanguage$default(DarkstoresUtils darkstoresUtils, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = IntegrationGlobalDataModel.Companion.selectedLanguage();
        }
        return darkstoresUtils.getLanguage(str);
    }

    public static /* synthetic */ String getLocale$default(DarkstoresUtils darkstoresUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = IntegrationGlobalDataModel.Companion.selectedLanguage();
        }
        return darkstoresUtils.getLocale(str, str2);
    }

    @NotNull
    public final String getCountryCurrencyCode(int i11) {
        String str = currenciesByCode.get(Integer.valueOf(i11));
        return str == null ? PurchaseInfo.Currency.KWD : str;
    }

    @NotNull
    public final String getCountryDjiniEntityId(int i11) {
        if (i11 == 9) {
            return DJINI_ENTITY_EGYPT;
        }
        String countryForDarkstores = getCountryForDarkstores(i11);
        return DJINI_ENTITY_PREFIX + countryForDarkstores;
    }

    @NotNull
    public final String getCountryForDarkstores(int i11) {
        String str = countriesByCode.get(Integer.valueOf(i11));
        return str == null ? Country.KUWAIT.twoLetterCodeUpperCase() : str;
    }

    @NotNull
    public final String getCustomerId(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "customerId");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = null;
        }
        if (str == null) {
            return "0";
        }
        return str;
    }

    @NotNull
    public final Environment getEnvironment(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "instrumentationServer");
        Intrinsics.checkNotNullParameter(str2, "buildType");
        if (Intrinsics.areEqual((Object) str, (Object) "prod") || Intrinsics.areEqual((Object) str2, (Object) "release")) {
            return Environment.PRODUCTION;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "mock")) {
            return Environment.MOCKING;
        }
        return Environment.STAGING;
    }

    @NotNull
    public final DarkstoresMainActivity.Language getLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedLanguage");
        if (Intrinsics.areEqual((Object) str, (Object) "en-US")) {
            return DarkstoresMainActivity.Language.EN;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "ku-SO")) {
            return DarkstoresMainActivity.Language.CKB;
        }
        return DarkstoresMainActivity.Language.AR;
    }

    @NotNull
    public final String getLocale(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, "selectedLanguage");
        if (Intrinsics.areEqual((Object) str2, (Object) "en-US")) {
            if (Intrinsics.areEqual((Object) str, (Object) Profile.Country.KW) || Intrinsics.areEqual((Object) str, (Object) Profile.Country.SA)) {
                return "en_GB";
            }
            return "en_" + str;
        } else if (Intrinsics.areEqual((Object) str2, (Object) "ku-SO")) {
            return "ku_" + str;
        } else {
            return "ar_" + str;
        }
    }
}
