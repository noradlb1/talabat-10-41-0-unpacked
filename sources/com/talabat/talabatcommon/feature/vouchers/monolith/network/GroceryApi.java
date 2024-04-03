package com.talabat.talabatcommon.feature.vouchers.monolith.network;

import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetailsResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryApi;", "", "getProductDetailsBySku", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/GroceryItemDetailsResponse;", "vendorId", "", "sku", "brand", "countryCode", "language", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getProductDetailsBySku$default(GroceryApi groceryApi, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str3 = "talabat";
                }
                return groceryApi.getProductDetailsBySku(str, str2, str3, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProductDetailsBySku");
        }
    }

    @NotNull
    @GET("v1/vendors/{vendor_id}/products")
    Call<GroceryItemDetailsResponse> getProductDetailsBySku(@NotNull @Path("vendor_id") String str, @NotNull @Query("sku") String str2, @NotNull @Query("brand") String str3, @NotNull @Query("country_code") String str4, @NotNull @Query("language_code") String str5);
}
