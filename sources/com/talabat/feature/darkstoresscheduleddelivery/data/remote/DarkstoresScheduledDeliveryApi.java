package com.talabat.feature.darkstoresscheduleddelivery.data.remote;

import com.talabat.feature.darkstoresscheduleddelivery.data.model.DeliveryDateResponse;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/remote/DarkstoresScheduledDeliveryApi;", "", "getDeliverySlots", "Lio/reactivex/Single;", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/model/DeliveryDateResponse;", "vendorId", "", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresScheduledDeliveryApi {
    @NotNull
    @GET("v1/delivery-slots/{vendorId}")
    Single<List<DeliveryDateResponse>> getDeliverySlots(@Path("vendorId") int i11);
}
