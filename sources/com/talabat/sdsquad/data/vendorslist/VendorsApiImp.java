package com.talabat.sdsquad.data.vendorslist;

import com.adjust.sdk.Constants;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.sdsquad.core.UrlConstants;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.data.swimlanes.responses.SwimlanesResponse;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.InlineAdsResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorsApiImp;", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "mUrlConstants", "Lcom/talabat/sdsquad/core/UrlConstants;", "(Lcom/talabat/sdsquad/core/UrlConstants;)V", "getDarkStoresInfo", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "areaId", "", "latitude", "", "longitude", "getInlineAds", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "countryId", "getPolygonVendors", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "lat", "long", "getSwimlane", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimlanesResponse;", "countryCode", "getVendorsInfo", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "vendorInfoRequest", "Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "restaurantsSearch", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "requestModel", "Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsApiImp implements VendorsApi {
    @NotNull
    private final UrlConstants mUrlConstants;

    public VendorsApiImp(@NotNull UrlConstants urlConstants) {
        Intrinsics.checkNotNullParameter(urlConstants, "mUrlConstants");
        this.mUrlConstants = urlConstants;
    }

    @NotNull
    public Flowable<DarkStoreResponse> getDarkStoresInfo(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getDarkStoreUrl(), VendorsApi.class)).getDarkStoresInfo(i11, str, str2);
    }

    @NotNull
    public Flowable<InlineAdsResponse> getInlineAds(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getInlineAdsBaseUrl(), VendorsApi.class)).getInlineAds(str);
    }

    @NotNull
    public Flowable<VendorsListResponse> getPolygonVendors(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, Constants.LONG);
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getVendorsBaseUrl(), VendorsApi.class)).getPolygonVendors(str, str2);
    }

    @NotNull
    public Flowable<SwimlanesResponse> getSwimlane(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, "areaId");
        Intrinsics.checkNotNullParameter(str4, "countryCode");
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getSwimlanesBaseUrl(), VendorsApi.class)).getSwimlane(str, str2, str3, str4);
    }

    @NotNull
    public Flowable<VendorsInfoResponse> getVendorsInfo(@NotNull VendorInfoRequest vendorInfoRequest) {
        Intrinsics.checkNotNullParameter(vendorInfoRequest, "vendorInfoRequest");
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getVendorInfoBaseUrl(), VendorsApi.class)).getVendorsInfo(vendorInfoRequest);
    }

    @NotNull
    public Flowable<List<RestaurantsSearchResponse>> restaurantsSearch(int i11, @NotNull ResturantSearchRequest resturantSearchRequest) {
        Intrinsics.checkNotNullParameter(resturantSearchRequest, "requestModel");
        return ((VendorsApi) NetworkBuilder.Companion.getService(this.mUrlConstants.getGlobalSearchBaseUrl(), VendorsApi.class)).restaurantsSearch(i11, resturantSearchRequest);
    }
}
