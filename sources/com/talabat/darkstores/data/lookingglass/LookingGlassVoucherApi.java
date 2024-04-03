package com.talabat.darkstores.data.lookingglass;

import com.talabat.darkstores.data.lookingglass.model.GenerateVoucherResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/data/lookingglass/LookingGlassVoucherApi;", "", "generateVoucher", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/lookingglass/model/GenerateVoucherResponse;", "countryCode", "", "chainId", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LookingGlassVoucherApi {
    @NotNull
    @GET("v1/voucher")
    Single<GenerateVoucherResponse> generateVoucher(@NotNull @Query("country_code") String str, @Query("chain_id") int i11);
}
