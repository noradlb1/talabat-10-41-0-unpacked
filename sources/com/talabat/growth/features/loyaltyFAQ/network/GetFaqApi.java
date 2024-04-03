package com.talabat.growth.features.loyaltyFAQ.network;

import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/growth/features/loyaltyFAQ/network/GetFaqApi;", "", "getHowItWorksTips", "Lretrofit2/Call;", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksRootResponse;", "apiVersion", "", "languageCode", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetFaqApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getHowItWorksTips$default(GetFaqApi getFaqApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return getFaqApi.getHowItWorksTips(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHowItWorksTips");
        }
    }

    @NotNull
    @GET("/api/v{version}/how-it-works")
    Call<HowItWorksRootResponse> getHowItWorksTips(@Path("version") int i11, @NotNull @Query("culture") String str);
}
