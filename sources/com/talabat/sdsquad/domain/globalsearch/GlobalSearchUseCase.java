package com.talabat.sdsquad.domain.globalsearch;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.restaurantsearch.RestaurantSearchRepository;
import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "requestValues", "a", "Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;", "searchRepository", "Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;", "<init>", "(Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GlobalSearchUseCase extends UseCase<RequestValues, Flowable<List<? extends RestaurantsSearchResponse>>> {
    @NotNull
    private final RestaurantSearchRepository searchRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "countryId", "", "requestModel", "Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "(ILcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;)V", "getCountryId", "()I", "getRequestModel", "()Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final int countryId;
        @NotNull
        private final ResturantSearchRequest requestModel;

        public RequestValues(int i11, @NotNull ResturantSearchRequest resturantSearchRequest) {
            Intrinsics.checkNotNullParameter(resturantSearchRequest, "requestModel");
            this.countryId = i11;
            this.requestModel = resturantSearchRequest;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        @NotNull
        public final ResturantSearchRequest getRequestModel() {
            return this.requestModel;
        }
    }

    public GlobalSearchUseCase(@NotNull RestaurantSearchRepository restaurantSearchRepository) {
        Intrinsics.checkNotNullParameter(restaurantSearchRepository, "searchRepository");
        this.searchRepository = restaurantSearchRepository;
    }

    @NotNull
    /* renamed from: a */
    public Flowable<List<RestaurantsSearchResponse>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            return this.searchRepository.getVendorsResults(requestValues.getCountryId(), requestValues.getRequestModel());
        }
        throw new RuntimeException("requests values is empty");
    }
}
