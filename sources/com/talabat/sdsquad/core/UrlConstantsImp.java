package com.talabat.sdsquad.core;

import com.talabat.restaurants.v2.data.vendors.VendorsBaseUrl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/core/UrlConstantsImp;", "Lcom/talabat/sdsquad/core/UrlConstants;", "()V", "getDarkStoreUrl", "", "getGlobalSearchBaseUrl", "getInlineAdsBaseUrl", "getSwimlanesBaseUrl", "getVendorInfoBaseUrl", "getVendorsBaseUrl", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UrlConstantsImp implements UrlConstants {
    @NotNull
    public String getDarkStoreUrl() {
        return VendorsBaseUrl.BASE_URL_PROD;
    }

    @NotNull
    public String getGlobalSearchBaseUrl() {
        return "https://gs.talabat.com";
    }

    @NotNull
    public String getInlineAdsBaseUrl() {
        return "https://api.talabat.com";
    }

    @NotNull
    public String getSwimlanesBaseUrl() {
        return "https://api.talabat.com";
    }

    @NotNull
    public String getVendorInfoBaseUrl() {
        return "https://talabat.com";
    }

    @NotNull
    public String getVendorsBaseUrl() {
        return VendorsBaseUrl.BASE_URL_PROD;
    }
}
