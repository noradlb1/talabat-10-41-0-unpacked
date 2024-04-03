package com.talabat.talabatlife.features.tLifeWidget.network;

import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetApi;", "", "getUserSubscriptionStatus", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRootResponse;", "country", "", "version", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TLifeWidgetApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getUserSubscriptionStatus$default(TLifeWidgetApi tLifeWidgetApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return tLifeWidgetApi.getUserSubscriptionStatus(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserSubscriptionStatus");
        }
    }

    @NotNull
    @GET("/api/v{version}/subscriptions/country/{countryId}/is-subscribed")
    Call<TLifeSubscriptionStatusRootResponse> getUserSubscriptionStatus(@Path("countryId") int i11, @Path("version") int i12);
}
