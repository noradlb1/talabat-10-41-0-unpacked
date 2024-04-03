package com.talabat.darkstores.data.partialFulfillment.remote;

import com.talabat.darkstores.data.partialFulfillment.model.PartialFulfillmentSaveRequest;
import com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'J&\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentApi;", "", "getPreferences", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "tag", "", "code", "language", "savePreference", "Lio/reactivex/Completable;", "partialFulfillmentSaveRequest", "Lcom/talabat/darkstores/data/partialFulfillment/model/PartialFulfillmentSaveRequest;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PartialFulfillmentApi {
    @NotNull
    @GET("/api/v1/preferences/{tag}/{code}")
    Single<PreferencesResponse> getPreferences(@NotNull @Path("tag") String str, @NotNull @Path("code") String str2, @NotNull @Query("language_code") String str3);

    @NotNull
    @PUT("/api/v1/preferences/{tag}/{code}")
    Completable savePreference(@NotNull @Path("tag") String str, @NotNull @Path("code") String str2, @NotNull @Body PartialFulfillmentSaveRequest partialFulfillmentSaveRequest);
}
