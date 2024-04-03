package com.talabat.feature.pharmacy.remote;

import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pharmacy/remote/MobileVerificationApi;", "", "checkIfMobileIsVerified", "Lio/reactivex/Completable;", "countryId", "", "countryCode", "phoneNumber", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MobileVerificationApi {
    @NotNull
    @GET("api/v1/{countryId}/account/verified-mobile")
    Completable checkIfMobileIsVerified(@NotNull @Path("countryId") String str, @NotNull @Query("countryCode") String str2, @NotNull @Query("number") String str3);
}
