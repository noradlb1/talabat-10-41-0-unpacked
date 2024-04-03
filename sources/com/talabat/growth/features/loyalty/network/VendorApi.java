package com.talabat.growth.features.loyalty.network;

import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJF\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH'¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/features/loyalty/network/VendorApi;", "", "getVendors", "Lretrofit2/Call;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "latitude", "", "longitude", "pageNumber", "", "pageSize", "vendorIds", "", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorApi {
    public static final /* synthetic */ Companion Companion = Companion.f60565a;
    @NotNull
    @Deprecated
    public static final String QUERY_LAT = "lat";
    @NotNull
    @Deprecated
    public static final String QUERY_LON = "lon";
    @NotNull
    @Deprecated
    public static final String QUERY_VENDOR_ID = "vendor_id";
    @NotNull
    @Deprecated
    public static final String URL_API_V3_VENDORS = "/vendor-list/v1/vendors";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/growth/features/loyalty/network/VendorApi$Companion;", "", "()V", "QUERY_LAT", "", "QUERY_LON", "QUERY_VENDOR_ID", "URL_API_V3_VENDORS", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String QUERY_LAT = "lat";
        @NotNull
        public static final String QUERY_LON = "lon";
        @NotNull
        public static final String QUERY_VENDOR_ID = "vendor_id";
        @NotNull
        public static final String URL_API_V3_VENDORS = "/vendor-list/v1/vendors";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f60565a = new Companion();

        private Companion() {
        }
    }

    @NotNull
    @GET("/vendor-list/v1/vendors")
    Call<RestaurantListResponsePaginated> getVendors(@Query("lat") double d11, @Query("lon") double d12, @Query("Page") int i11, @Query("Size") int i12, @NotNull @Query("vendor_id") List<Integer> list);
}
