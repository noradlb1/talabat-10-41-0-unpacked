package com.talabat.darkstores.data.darkstores;

import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'JF\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/DarkstoresApi;", "", "getBanners", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "vendorId", "", "locale", "globalEntityId", "getCampaigns", "", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "productId", "benefitId", "getDiscounts", "Lcom/talabat/darkstores/model/ProductDiscount;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresApi {
    @NotNull
    @GET("v1/banners")
    Single<BannersResponse> getBanners(@Nullable @Query("vendor_id") String str, @NotNull @Query("locale") String str2, @NotNull @Query("ge_id") String str3);

    @NotNull
    @GET("v1/campaigns")
    Single<List<Campaign>> getCampaigns(@NotNull @Query("trigger_id") String str, @NotNull @Query("benefit_id") String str2, @NotNull @Query("vendor_id") String str3, @NotNull @Query("locale") String str4, @NotNull @Query("ge_id") String str5);

    @NotNull
    @GET("v1/discounts")
    Single<List<ProductDiscount>> getDiscounts(@NotNull @Query("vendor_id") String str, @NotNull @Query("ge_id") String str2);
}
