package com.talabat.collectiondetails.data;

import JsonModels.Request.TermsRequest;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.TermsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J&\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nH'¨\u0006\u000b"}, d2 = {"Lcom/talabat/collectiondetails/data/TermsApi;", "", "getDarkStoresInfo", "Lio/reactivex/Single;", "LJsonModels/Response/Darkstores/DarkStoresEntryPointResponse;", "url", "", "getTerms", "LJsonModels/Response/TermsResponse;", "termsRequest", "LJsonModels/Request/TermsRequest;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TermsApi {
    @NotNull
    @GET
    Single<DarkStoresEntryPointResponse> getDarkStoresInfo(@NotNull @Url String str);

    @NotNull
    @POST
    Single<TermsResponse> getTerms(@NotNull @Url String str, @Body @Nullable TermsRequest termsRequest);
}
