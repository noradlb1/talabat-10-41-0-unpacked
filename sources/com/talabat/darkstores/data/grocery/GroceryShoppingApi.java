package com.talabat.darkstores.data.grocery;

import com.talabat.darkstores.data.grocery.model.CampaignProgressResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b`\u0018\u00002\u00020\u0001J{\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH'¢\u0006\u0002\u0010\u0011J\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/grocery/GroceryShoppingApi;", "", "campaignProgress", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "countryCode", "", "total", "", "vendorId", "minOrderValue", "deliveryFee", "currencyCode", "sessionId", "cartDiscount", "deliveryFeeDiscount", "subTotal", "(Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;FFF)Lio/reactivex/Single;", "campaignProgressV3", "subTotalAfterDiscount", "vendorCode", "(Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;FFFFLjava/lang/String;)Lio/reactivex/Single;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryShoppingApi {
    @NotNull
    @GET("v2/{country_code}/campaign-message")
    Single<CampaignProgressResponse> campaignProgress(@NotNull @Path("country_code") String str, @Query("amount") float f11, @NotNull @Query("vendor_id") String str2, @Nullable @Query("minimum_order_value") Float f12, @Nullable @Query("delivery_fee") Float f13, @NotNull @Query("currency") String str3, @NotNull @Query("session_id") String str4, @Query("cart_discount") float f14, @Query("delivery_fee_discount") float f15, @Query("sub_total") float f16);

    @NotNull
    @GET("v3/{country_code}/campaign-message")
    Single<CampaignProgressResponse> campaignProgressV3(@NotNull @Path("country_code") String str, @Query("amount") float f11, @NotNull @Query("vendor_id") String str2, @Nullable @Query("minimum_order_value") Float f12, @Nullable @Query("delivery_fee") Float f13, @NotNull @Query("currency") String str3, @NotNull @Query("session_id") String str4, @Query("cart_discount") float f14, @Query("delivery_fee_discount") float f15, @Query("sub_total") float f16, @Query("subtotal_after_discount") float f17, @NotNull @Query("vendor-id") String str5);
}
