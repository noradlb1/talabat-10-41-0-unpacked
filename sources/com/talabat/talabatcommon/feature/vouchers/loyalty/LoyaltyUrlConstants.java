package com.talabat.talabatcommon.feature.vouchers.loyalty;

import com.talabat.core.buildconfig.TalabatEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/LoyaltyUrlConstants;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyUrlConstants {
    @NotNull
    public static final String COUNTRY = "Country";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String INSTRUMENTATION_TESTING_BASE_URL = "http://localhost:8000/";
    public static final int LOYALTY_API_VERSION = 3;
    @NotNull
    public static final String PATH_BURN_OPTION_TYPE = "burnOptionType";
    @NotNull
    public static final String PATH_ID = "id";
    @NotNull
    public static final String PATH_VERSION = "version";
    @NotNull
    public static final String QUERY_SOURCE = "source";
    @NotNull
    private static final String RELEASE = "release";
    @NotNull
    public static final String URL_BURN_OPTION_REDEEM = "/api/v{version}/burn-option/redeem/{id}/{burnOptionType}/";
    @NotNull
    public static final String URL_LOYALTY_BASE_PRODUCTION = "https://loyalty.talabat.com";
    @NotNull
    public static final String URL_LOYALTY_BASE_QA = "https://loyalty-qa.dhhmena.com/";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/LoyaltyUrlConstants$Companion;", "", "()V", "COUNTRY", "", "INSTRUMENTATION_TESTING_BASE_URL", "LOYALTY_API_VERSION", "", "PATH_BURN_OPTION_TYPE", "PATH_ID", "PATH_VERSION", "QUERY_SOURCE", "RELEASE", "URL_BURN_OPTION_REDEEM", "URL_LOYALTY_BASE_PRODUCTION", "URL_LOYALTY_BASE_QA", "getBaseUrl", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getBaseUrl() {
            TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") || Intrinsics.areEqual((Object) "release", (Object) "release")) {
                return LoyaltyUrlConstants.URL_LOYALTY_BASE_PRODUCTION;
            }
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "mock")) {
                return "http://localhost:8000/";
            }
            return LoyaltyUrlConstants.URL_LOYALTY_BASE_QA;
        }
    }
}
