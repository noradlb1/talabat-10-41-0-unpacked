package com.talabat.sdsquad.data.vendorslist;

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
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\bH'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH'J6\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\bH'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H'J(\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u001cH'¨\u0006\u001d"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "", "getDarkStoresInfo", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "areaId", "", "latitude", "", "longitude", "getInlineAds", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "countryId", "getPolygonVendors", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "lat", "long", "getSwimlane", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimlanesResponse;", "countryCode", "getVendorsInfo", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "vendorInfoRequest", "Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "restaurantsSearch", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "requestModel", "Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsApi {
    @NotNull
    @GET("/api/v1/darkstore/{areaId}/{latitude}/{longitude}")
    Flowable<DarkStoreResponse> getDarkStoresInfo(@Path("areaId") int i11, @NotNull @Path("latitude") String str, @NotNull @Path("longitude") String str2);

    @NotNull
    @GET("/apiAndroid/v1/countries/inlineAds/{countryid}")
    Flowable<InlineAdsResponse> getInlineAds(@NotNull @Path("countryid") String str);

    @NotNull
    @GET("/api/v2/vendors/{lat}/{long}")
    Flowable<VendorsListResponse> getPolygonVendors(@NotNull @Path("lat") String str, @NotNull @Path("long") String str2);

    @NotNull
    @GET("/restaurantapi/v3/swimlanes")
    Flowable<SwimlanesResponse> getSwimlane(@NotNull @Query("latitude") String str, @NotNull @Query("longitude") String str2, @NotNull @Query("areaid") String str3, @NotNull @Query("countrycode") String str4);

    @NotNull
    @POST("/restaurantapi/v1/vendorslistinginfo")
    Flowable<VendorsInfoResponse> getVendorsInfo(@NotNull @Body VendorInfoRequest vendorInfoRequest);

    @NotNull
    @POST("/api/v2/country/{countryID}/global-search")
    Flowable<List<RestaurantsSearchResponse>> restaurantsSearch(@Path("countryID") int i11, @NotNull @Body ResturantSearchRequest resturantSearchRequest);
}
