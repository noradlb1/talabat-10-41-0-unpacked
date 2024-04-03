package com.talabat.darkstores.data.discovery;

import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.TagResponse;
import com.talabat.darkstores.model.SearchSuggestionsResponse;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/data/discovery/DiscoveryApi;", "", "getTags", "Lio/reactivex/Single;", "", "Lcom/talabat/darkstores/data/discovery/model/TagResponse;", "categoryId", "", "locale", "search", "Lcom/talabat/darkstores/model/SearchSuggestionsResponse;", "request", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DiscoveryApi {
    @NotNull
    @GET("v1/tags")
    Single<List<TagResponse>> getTags(@NotNull @Query("category_id") String str, @NotNull @Query("locale") String str2);

    @NotNull
    @POST("v1/search/autocomplete")
    Single<SearchSuggestionsResponse> search(@NotNull @Body FeedEndpointRequest feedEndpointRequest);
}
