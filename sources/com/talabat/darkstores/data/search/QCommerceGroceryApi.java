package com.talabat.darkstores.data.search;

import com.talabat.darkstores.data.search.model.SearchCategoryRequest;
import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/search/QCommerceGroceryApi;", "", "searchCategory", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/search/model/SearchCategoryResponse;", "searchRequest", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QCommerceGroceryApi {
    @NotNull
    @POST("v1/products/categories/search")
    Single<SearchCategoryResponse> searchCategory(@NotNull @Body SearchCategoryRequest searchCategoryRequest);
}
