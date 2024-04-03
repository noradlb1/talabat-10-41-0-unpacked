package com.talabat.talabatcommon.feature.vouchers.loyalty;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"ACTIVE_VOUCHERS", "", "GUEST_VOUCHER", "GUEST_WELCOME_VOUCHER", "PATH_COUNTRY_ID", "PATH_VERSION", "PATH_VOUCHER_ID", "POSSIBLE_VOUCHERS", "QUERY_AREA_ID", "QUERY_BRAND_ID", "QUERY_COUNTRY", "QUERY_CUSTOMER_VOUCHER_ID", "QUERY_ORDER_DELIVERY_MODE", "QUERY_PAGE", "QUERY_SIZE", "QUERY_SOURCE", "QUERY_VOUCHER_STATUS", "REDEEM_PROMO_CODE", "REDEEM_VOUCHER_CODE", "REFERRALS_CAMPAIGN_SENDER", "USER_ACTIVE_VOUCHERS_COUNT", "VERTICAL_ID", "VOUCHERS_API_VERSION", "", "VOUCHERS_API_VERSION_MIGRATED", "VOUCHERS_API_VERSION_REFERRAL", "VOUCHERS_APPLIED", "VOUCHERS_ENTRY_SOURCE_WALLET", "VOUCHERS_LIST", "VOUCHERS_UN_APPLY_ALL", "VOUCHER_BIN_RESTRICTION", "VOUCHER_CODE", "VOUCHER_DETAILS", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VoucherUrlConstantsKt {
    @NotNull
    public static final String ACTIVE_VOUCHERS = "/api/v{version}/me/active-vouchers";
    @NotNull
    public static final String GUEST_VOUCHER = "/api/v{version}/guest/voucher-code-details";
    @NotNull
    public static final String GUEST_WELCOME_VOUCHER = "/api/v{version}/guest/welcome-voucher";
    @NotNull
    public static final String PATH_COUNTRY_ID = "countryId";
    @NotNull
    public static final String PATH_VERSION = "version";
    @NotNull
    public static final String PATH_VOUCHER_ID = "voucherId";
    @NotNull
    public static final String POSSIBLE_VOUCHERS = "/api/v{version}/me/possible-vouchers";
    @NotNull
    public static final String QUERY_AREA_ID = "areaId";
    @NotNull
    public static final String QUERY_BRAND_ID = "brandId";
    @NotNull
    public static final String QUERY_COUNTRY = "country";
    @NotNull
    public static final String QUERY_CUSTOMER_VOUCHER_ID = "customerVoucherId";
    @NotNull
    public static final String QUERY_ORDER_DELIVERY_MODE = "orderDeliveryMode";
    @NotNull
    public static final String QUERY_PAGE = "Page";
    @NotNull
    public static final String QUERY_SIZE = "Size";
    @NotNull
    public static final String QUERY_SOURCE = "source";
    @NotNull
    public static final String QUERY_VOUCHER_STATUS = "voucherStatus";
    @NotNull
    public static final String REDEEM_PROMO_CODE = "/api/v{version}/me/promo-codes/redeem";
    @NotNull
    public static final String REDEEM_VOUCHER_CODE = "/api/v{version}/me/voucher-codes/{voucher-code}/redeem";
    @NotNull
    public static final String REFERRALS_CAMPAIGN_SENDER = "/api/v{version}/referrals/campaign/{countryId}/sender";
    @NotNull
    public static final String USER_ACTIVE_VOUCHERS_COUNT = "/api/v{version}/me/vouchers-stats";
    @NotNull
    public static final String VERTICAL_ID = "verticalId";
    public static final int VOUCHERS_API_VERSION = 1;
    public static final int VOUCHERS_API_VERSION_MIGRATED = 2;
    public static final int VOUCHERS_API_VERSION_REFERRAL = 3;
    @NotNull
    public static final String VOUCHERS_APPLIED = "/api/v{version}/me/vouchers/{voucherId}/applied";
    @NotNull
    public static final String VOUCHERS_ENTRY_SOURCE_WALLET = "wallet";
    @NotNull
    public static final String VOUCHERS_LIST = "/api/v{version}/me/vouchers";
    @NotNull
    public static final String VOUCHERS_UN_APPLY_ALL = "/api/v{version}/me/vouchers/unapply-all";
    @NotNull
    public static final String VOUCHER_BIN_RESTRICTION = "/api/v{version}/me/vouchers/apply";
    @NotNull
    public static final String VOUCHER_CODE = "voucher-code";
    @NotNull
    public static final String VOUCHER_DETAILS = "/api/v{version}/me/vouchers/{voucherId}";
}
