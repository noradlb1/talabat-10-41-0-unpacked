package com.talabat.feature.pharmacy.remote;

import com.talabat.feature.pharmacy.model.PrescriptionBannerDetails;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/feature/pharmacy/remote/PrescriptionApi;", "", "getPrescriptionBannerDetails", "Lio/reactivex/Single;", "Lcom/talabat/feature/pharmacy/model/PrescriptionBannerDetails;", "cityId", "", "countryId", "areaId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PrescriptionApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getPrescriptionBannerDetails$default(PrescriptionApi prescriptionApi, Integer num, Integer num2, Integer num3, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    num = null;
                }
                if ((i11 & 2) != 0) {
                    num2 = null;
                }
                if ((i11 & 4) != 0) {
                    num3 = null;
                }
                return prescriptionApi.getPrescriptionBannerDetails(num, num2, num3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrescriptionBannerDetails");
        }
    }

    @NotNull
    @GET("api/v1/prescription/order")
    Single<PrescriptionBannerDetails> getPrescriptionBannerDetails(@Nullable @Query("city_id") Integer num, @Nullable @Query("country_id") Integer num2, @Nullable @Query("area_id") Integer num3);
}
