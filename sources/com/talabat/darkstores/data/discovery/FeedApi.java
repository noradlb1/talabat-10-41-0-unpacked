package com.talabat.darkstores.data.discovery;

import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.VendorFeedResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/data/discovery/FeedApi;", "", "feedGetMultiList", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "request", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "feedGetProducts", "Lcom/talabat/darkstores/data/discovery/model/VendorFeedResponse;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FeedApi {
    @NotNull
    @POST("v1/products/feed/legacy")
    Single<MultiListFeedEndpointResponse> feedGetMultiList(@NotNull @Body FeedEndpointRequest feedEndpointRequest);

    @NotNull
    @POST("v1/products/feed/legacy")
    Single<VendorFeedResponse> feedGetProducts(@NotNull @Body FeedEndpointRequest feedEndpointRequest);
}
