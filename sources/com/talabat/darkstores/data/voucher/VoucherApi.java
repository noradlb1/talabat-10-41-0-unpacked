package com.talabat.darkstores.data.voucher;

import com.talabat.darkstores.data.voucher.model.VoucherResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/voucher/VoucherApi;", "", "getVoucherData", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/voucher/model/VoucherResponse;", "countryCode", "", "areaId", "", "chainId", "screenType", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VoucherApi {
    @NotNull
    @GET("v1/{country_code}/reminder-widget")
    Single<VoucherResponse> getVoucherData(@NotNull @Path("country_code") String str, @Query("area_id") int i11, @Query("chain_id") int i12, @NotNull @Query("screen") String str2);
}
