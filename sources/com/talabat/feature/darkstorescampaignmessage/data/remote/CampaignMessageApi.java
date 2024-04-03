package com.talabat.feature.darkstorescampaignmessage.data.remote;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J[\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/remote/CampaignMessageApi;", "", "getCampaignMessage", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "vendorCode", "", "globalEntityId", "subTotal", "", "subTotalAfterDiscount", "latitude", "", "longitude", "chainId", "", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/Float;DDI)Lio/reactivex/Single;", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CampaignMessageApi {
    @NotNull
    @GET("api/v1/campaign-message/{vendor-code}")
    Single<NetworkCampaignProgressResponse> getCampaignMessage(@NotNull @Path("vendor-code") String str, @NotNull @Query("ge_id") String str2, @Query("subtotal") float f11, @Nullable @Query("subtotal_after_discount") Float f12, @Query("lat") double d11, @Query("lon") double d12, @Query("chain_id") int i11);
}
