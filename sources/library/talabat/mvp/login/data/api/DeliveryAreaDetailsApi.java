package library.talabat.mvp.login.data.api;

import io.reactivex.Single;
import kotlin.Metadata;
import library.talabat.mvp.login.data.api.response.DeliveryAreaDetailsResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Llibrary/talabat/mvp/login/data/api/DeliveryAreaDetailsApi;", "", "getDeliveryAreaDetails", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetailsResponse;", "vendorId", "", "latitude", "", "longitude", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DeliveryAreaDetailsApi {
    @NotNull
    @GET("deliveryareadetails")
    Single<DeliveryAreaDetailsResponse> getDeliveryAreaDetails(@Query("vendorid") long j11, @Query("lat") double d11, @Query("lon") double d12);
}
