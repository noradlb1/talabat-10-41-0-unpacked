package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemItemRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\tH'¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemVoucherApi;", "", "redeemItem", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemItemRootResponse;", "countryId", "", "apiVersion", "itemId", "", "burnOptionType", "source", "voucherOptionType", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MarketPlaceRedeemVoucherApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call redeemItem$default(MarketPlaceRedeemVoucherApi marketPlaceRedeemVoucherApi, int i11, int i12, String str, String str2, String str3, String str4, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                int i14 = i12;
                if ((i13 & 32) != 0) {
                    str4 = null;
                }
                return marketPlaceRedeemVoucherApi.redeemItem(i11, i14, str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redeemItem");
        }
    }

    @NotNull
    @POST("/api/v{version}/burn-option/redeem/{id}/{burnOptionType}/")
    Call<RedeemItemRootResponse> redeemItem(@Header("Country") int i11, @Path("version") int i12, @NotNull @Path("id") String str, @NotNull @Path("burnOptionType") String str2, @NotNull @Query("source") String str3, @Nullable @Query("voucherOptionType") String str4);
}
