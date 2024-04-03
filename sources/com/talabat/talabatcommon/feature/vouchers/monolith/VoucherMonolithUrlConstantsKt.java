package com.talabat.talabatcommon.feature.vouchers.monolith;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"GROCERY_PROD_BASE_URL", "", "GROCERY_QA_BASE_URL", "INSTRUMENTATION_TESTING_BASE_URL", "MONOLITH_API_VERSION", "", "MONOLITH_VOUCHER_ITEMS", "PATH_ID", "PATH_VERSION", "QUERY_BRANCH_ID", "RELEASE", "URL_MAIN_BASE_PRODUCTION", "URL_MAIN_BASE_QA", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VoucherMonolithUrlConstantsKt {
    @NotNull
    public static final String GROCERY_PROD_BASE_URL = "https://api.talabat.com/grocery/";
    @NotNull
    public static final String GROCERY_QA_BASE_URL = "https://api-qa.dhhmena.com/grocery/";
    @NotNull
    public static final String INSTRUMENTATION_TESTING_BASE_URL = "http://localhost:8000/";
    public static final int MONOLITH_API_VERSION = 2;
    @NotNull
    public static final String MONOLITH_VOUCHER_ITEMS = "/menuapi/v{version}/items/{branchId}";
    @NotNull
    public static final String PATH_ID = "branchId";
    @NotNull
    public static final String PATH_VERSION = "version";
    @NotNull
    public static final String QUERY_BRANCH_ID = "branchId";
    @NotNull
    private static final String RELEASE = "release";
    @NotNull
    private static final String URL_MAIN_BASE_PRODUCTION = "https://api.talabat.com/";
    @NotNull
    private static final String URL_MAIN_BASE_QA = "https://qa.talabat.com/";
}
