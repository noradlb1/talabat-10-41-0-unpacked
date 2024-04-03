package com.talabat.talabatcommon.feature.ridersTip;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"API_VERSION", "", "BASE_QA_URL", "", "BASE_RELEASE_URL", "INSTRUMENTATION_TESTING_BASE_URL", "PATH_COUNTRY", "PATH_COUNTRY_ID", "PATH_VERSION", "RIDER_TIP_SUGGESTED_AMOUNT_URL", "WALLET_QA_BASE_URL", "WALLET_RELEASE_BASE_URL", "WALLET_RIDER_TIP_PAYMENT_URL", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UrlConstantsKt {
    public static final int API_VERSION = 1;
    @NotNull
    public static final String BASE_QA_URL = "https://qa.talabat.com/trackapi/";
    @NotNull
    public static final String BASE_RELEASE_URL = "https://api.talabat.com/trackapi/";
    @NotNull
    public static final String INSTRUMENTATION_TESTING_BASE_URL = "http://localhost:8000";
    @NotNull
    public static final String PATH_COUNTRY = "country";
    @NotNull
    public static final String PATH_COUNTRY_ID = "countryId";
    @NotNull
    public static final String PATH_VERSION = "version";
    @NotNull
    public static final String RIDER_TIP_SUGGESTED_AMOUNT_URL = "/trackapi/v{version}/rider/tipSuggestions/{countryId}";
    @NotNull
    public static final String WALLET_QA_BASE_URL = "https://walletapi-qa.dhhmena.com";
    @NotNull
    public static final String WALLET_RELEASE_BASE_URL = "https://walletapi.talabat.com";
    @NotNull
    public static final String WALLET_RIDER_TIP_PAYMENT_URL = "/trackapi/api/v1/wallet/payment";
}
