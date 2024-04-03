package com.talabat.talabatlife.features.vendors.network;

import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRootResponse;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferRootResponse;
import com.talabat.talabatlife.features.vendors.vendorAreas.models.VendorAreasRootResponse;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorListRootResponse;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH'J\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\t2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u00062\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u0006H'¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;", "", "getVendorBranchList", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRootResponse;", "restaurantID", "", "apiVersion", "lat", "", "long", "getVendorInfo", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorRootResponse;", "getVendorOfferList", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferRootResponse;", "country", "getVendorsAreas", "Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/VendorAreasRootResponse;", "getVendorsList", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorListRootResponse;", "featured", "page", "size", "searchString", "areaID", "offerType", "cuisineId", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getVendorBranchList$default(VendorsApi vendorsApi, int i11, int i12, String str, String str2, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return vendorsApi.getVendorBranchList(i11, i12, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorBranchList");
        }

        public static /* synthetic */ Call getVendorInfo$default(VendorsApi vendorsApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return vendorsApi.getVendorInfo(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorInfo");
        }

        public static /* synthetic */ Call getVendorOfferList$default(VendorsApi vendorsApi, int i11, int i12, int i13, int i14, Object obj) {
            if (obj == null) {
                if ((i14 & 2) != 0) {
                    i12 = 3;
                }
                return vendorsApi.getVendorOfferList(i11, i12, i13);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorOfferList");
        }

        public static /* synthetic */ Call getVendorsAreas$default(VendorsApi vendorsApi, int i11, int i12, String str, String str2, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return vendorsApi.getVendorsAreas(i11, i12, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsAreas");
        }

        public static /* synthetic */ Call getVendorsList$default(VendorsApi vendorsApi, int i11, int i12, String str, String str2, String str3, int i13, int i14, String str4, String str5, int i15, int i16, int i17, Object obj) {
            if (obj == null) {
                return vendorsApi.getVendorsList(i11, (i17 & 2) != 0 ? 3 : i12, str, str2, str3, i13, i14, str4, str5, i15, i16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsList");
        }
    }

    @NotNull
    @GET("/api/v{version}/brands/{id}/vendors")
    Call<VendorBranchListRootResponse> getVendorBranchList(@Path("id") int i11, @Path("version") int i12, @NotNull @Query("latitude") String str, @NotNull @Query("longitude") String str2);

    @NotNull
    @GET("/api/v{version}/brands/{id}")
    Call<VendorRootResponse> getVendorInfo(@Path("id") int i11, @Path("version") int i12);

    @NotNull
    @GET("/api/v{version}/brands/{id}/country/{country}/offers/customer/me")
    Call<VendorOfferRootResponse> getVendorOfferList(@Path("id") int i11, @Path("version") int i12, @Path("country") int i13);

    @NotNull
    @GET("/api/v{version}/brands/country/{country}/areas")
    Call<VendorAreasRootResponse> getVendorsAreas(@Path("country") int i11, @Path("version") int i12, @Nullable @Query("latitude") String str, @Nullable @Query("longitude") String str2);

    @NotNull
    @GET("/api/v{version}/brands/country/{country}/{featured} ")
    Call<VendorListRootResponse> getVendorsList(@Path("country") int i11, @Path("version") int i12, @NotNull @Path("featured") String str, @Nullable @Query("latitude") String str2, @Nullable @Query("longitude") String str3, @Query("Page") int i13, @Query("Size") int i14, @Nullable @Query("search") String str4, @Nullable @Query("areaId") String str5, @Query("offerType") int i15, @Query("cuisine") int i16);
}
