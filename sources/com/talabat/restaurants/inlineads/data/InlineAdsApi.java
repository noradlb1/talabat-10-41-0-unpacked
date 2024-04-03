package com.talabat.restaurants.inlineads.data;

import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/InlineAdsApi;", "", "getInlineAds", "Lio/reactivex/Single;", "Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "countryId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface InlineAdsApi {
    @NotNull
    @GET("/apiAndroid/v1/countries/inlineAds/{version}")
    Single<InLineAdsResponse> getInlineAds(@Path("version") int i11);
}
