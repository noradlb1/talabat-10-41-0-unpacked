package com.talabat.talabatcommon.feature.promotionWidget.network;

import com.talabat.talabatcommon.feature.promotionWidget.model.response.PromotionsWidgetResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\tH'¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetApi;", "", "getPromotionData", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/PromotionsWidgetResponse;", "countryId", "", "areaId", "promotionTag", "", "module", "lat", "lng", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PromotionsWidgetApi {
    @NotNull
    @GET("v1/promotionwidget")
    Call<PromotionsWidgetResponse> getPromotionData(@Query("country_id") int i11, @Query("area_id") int i12, @NotNull @Query("promotion_tag") String str, @NotNull @Query("module") String str2, @NotNull @Query("latitude") String str3, @NotNull @Query("longitude") String str4);
}
