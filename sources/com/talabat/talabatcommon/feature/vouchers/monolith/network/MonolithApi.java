package com.talabat.talabatcommon.feature.vouchers.monolith.network;

import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithApi;", "", "getMenuItems", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsRootResponse;", "apiVersion", "", "id", "", "branchId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MonolithApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getMenuItems$default(MonolithApi monolithApi, int i11, String str, String str2, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 2;
                }
                return monolithApi.getMenuItems(i11, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMenuItems");
        }
    }

    @NotNull
    @GET("/menuapi/v{version}/items/{branchId}")
    Call<VoucherItemsRootResponse> getMenuItems(@Path("version") int i11, @NotNull @Path("branchId") String str, @NotNull @Query("branchId") String str2);
}
