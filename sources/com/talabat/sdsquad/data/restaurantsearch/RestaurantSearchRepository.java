package com.talabat.sdsquad.data.restaurantsearch;

import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;", "", "getVendorsResults", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "countryId", "", "requestModel", "Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RestaurantSearchRepository {
    @NotNull
    Flowable<List<RestaurantsSearchResponse>> getVendorsResults(int i11, @NotNull ResturantSearchRequest resturantSearchRequest);
}
