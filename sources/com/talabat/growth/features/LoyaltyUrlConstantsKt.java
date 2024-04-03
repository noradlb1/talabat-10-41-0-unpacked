package com.talabat.growth.features;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"AREA_ID", "", "BURN_OPTION_TYPE", "BURN_TYPES", "COUNTRY", "PATH_COUNTRY", "PATH_ID", "PATH_POINTS_LIST", "PATH_TYPE", "PATH_VERSION", "QUERY_LANGUAGE_CODE_CULTURE", "QUERY_PAGE", "QUERY_SIZE", "URL_GET_LOYALTY_HOW_IT_WORKS", "URL_IS_USER_ENABLED", "URL_MARKETPLACE_CATEGORY_DETAILS", "URL_MARKETPLACE_ITEMS", "URL_MARKETPLACE_ITEM_DETAILS", "URL_POINTS_LIST", "URL_POINTS_SUMMARY", "URL_REWARDS_POINTS_BANNER", "VOUCHER_OPTION_TYPES", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyUrlConstantsKt {
    @NotNull
    public static final String AREA_ID = "areaId";
    @NotNull
    public static final String BURN_OPTION_TYPE = "burnOptionType";
    @NotNull
    public static final String BURN_TYPES = "burnTypes";
    @NotNull
    public static final String COUNTRY = "Country";
    @NotNull
    public static final String PATH_COUNTRY = "country";
    @NotNull
    public static final String PATH_ID = "id";
    @NotNull
    public static final String PATH_POINTS_LIST = "transactionType";
    @NotNull
    public static final String PATH_TYPE = "type";
    @NotNull
    public static final String PATH_VERSION = "version";
    @NotNull
    public static final String QUERY_LANGUAGE_CODE_CULTURE = "culture";
    @NotNull
    public static final String QUERY_PAGE = "Page";
    @NotNull
    public static final String QUERY_SIZE = "Size";
    @NotNull
    public static final String URL_GET_LOYALTY_HOW_IT_WORKS = "/api/v{version}/how-it-works";
    @NotNull
    public static final String URL_IS_USER_ENABLED = "/api/v{version}/me/enabled";
    @NotNull
    public static final String URL_MARKETPLACE_CATEGORY_DETAILS = "/api/v{version}/marketplace/categories/{id}";
    @NotNull
    public static final String URL_MARKETPLACE_ITEMS = "/api/v{version}/marketplace/country/{country}";
    @NotNull
    public static final String URL_MARKETPLACE_ITEM_DETAILS = "/api/v{version}/marketplace/{id}";
    @NotNull
    public static final String URL_POINTS_LIST = "/api/v{version}/points/customer/me/{transactionType}";
    @NotNull
    public static final String URL_POINTS_SUMMARY = "/api/v{version}/points/customer/me/summary";
    @NotNull
    public static final String URL_REWARDS_POINTS_BANNER = "/api/v{version}/me/rewards-points-banner";
    @NotNull
    public static final String VOUCHER_OPTION_TYPES = "voucherOptionTypes";
}
