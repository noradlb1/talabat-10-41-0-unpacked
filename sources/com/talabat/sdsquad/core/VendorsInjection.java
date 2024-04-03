package com.talabat.sdsquad.core;

import com.talabat.sdsquad.data.darkstors.DarkStoreRepository;
import com.talabat.sdsquad.data.darkstors.DarkStoreRepositoryImp;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.filters.SortRepository;
import com.talabat.sdsquad.data.filters.SortRepositoryImp;
import com.talabat.sdsquad.data.inlineads.InLineAdsRepository;
import com.talabat.sdsquad.data.inlineads.InLineAdsRepositoryImp;
import com.talabat.sdsquad.data.restaurantsearch.RestaurantSearchRepository;
import com.talabat.sdsquad.data.restaurantsearch.RestaurantSearchRepositoryImp;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.data.swimlanes.SwimlanesRepository;
import com.talabat.sdsquad.data.swimlanes.SwimlanesRepositoryImp;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.vendorslist.VendorRepository;
import com.talabat.sdsquad.data.vendorslist.VendorRepositoryImp;
import com.talabat.sdsquad.data.vendorslist.VendorsApi;
import com.talabat.sdsquad.data.vendorslist.VendorsApiImp;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepository;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepositoryImp;
import com.talabat.sdsquad.data.vendorslist.response.ActiveEvent;
import com.talabat.sdsquad.data.vendorslist.response.Collections;
import com.talabat.sdsquad.data.vendorslist.response.Cuisine;
import com.talabat.sdsquad.data.vendorslist.response.Filter;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import com.talabat.sdsquad.domain.cuisines.GetCuisinesUseCase;
import com.talabat.sdsquad.domain.darkstores.AddDarkStoreUseCase;
import com.talabat.sdsquad.domain.darkstores.GetDarkStoreUseCase;
import com.talabat.sdsquad.domain.filters.GetFiltersUseCase;
import com.talabat.sdsquad.domain.filters.GetSortUseCase;
import com.talabat.sdsquad.domain.globalsearch.BuildSearchWrapperUseCase;
import com.talabat.sdsquad.domain.globalsearch.GetBranchesIdUseCase;
import com.talabat.sdsquad.domain.globalsearch.GlobalSearchUseCase;
import com.talabat.sdsquad.domain.globalsearch.ItemsSuggestionsUseCase;
import com.talabat.sdsquad.domain.inlineds.GetInlineAdsUseCase;
import com.talabat.sdsquad.domain.inlineds.InsertInlineAdUseCase;
import com.talabat.sdsquad.domain.swimlanes.AddSwimlanesUseCase;
import com.talabat.sdsquad.domain.swimlanes.GetSwimlanesUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyCuisineUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyFiltersUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplySortUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetActiveEventUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorJsonByIdUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import com.talabat.sdsquad.ui.cuisines.CuisinesViewModel;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import com.talabat.sdsquad.ui.cuisines.mapppers.CuisinesDisplayMapper;
import com.talabat.sdsquad.ui.filters.FiltersViewModel;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import com.talabat.sdsquad.ui.filters.mappers.FilterDisplayMapper;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import com.talabat.sdsquad.ui.vendorslist.mappers.CollectionsDisplayMapper;
import com.talabat.sdsquad.ui.vendorslist.mappers.EventActionDisplayMapper;
import com.talabat.sdsquad.ui.vendorslist.mappers.SwimlaneDisplayMapper;
import com.talabat.sdsquad.ui.vendorslist.mappers.VendorDisplayMapper;
import com.talabat.sdsquad.ui.vendorslist.mappers.VendorInfoDisplayMapper;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0002J\u001a\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0004H\u0002J \u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00060\u0004H\u0002J\u001a\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0004H\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0004H\u0002J\u001a\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0004H\u0002J\u001a\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u0004H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\nH\u0002J \u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004H\u0002J\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\nH\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00060\u0004H\u0002J \u0010,\u001a\u001a\u0012\u0004\u0012\u00020-\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00070\u00060\u0004H\u0002J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010\nH\u0002J\b\u00102\u001a\u000203H\u0002J \u00104\u001a\u001a\u0012\u0004\u0012\u000205\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00070\u00060\u0004H\u0002J\u0006\u00107\u001a\u000208J\b\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u001a\u0012\u0004\u0012\u00020<\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00070\u00060\u0004H\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u001a\u0012\u0004\u0012\u00020C\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00070\u00060\u0004H\u0002J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020HH\u0002J\u0006\u0010I\u001a\u00020JJ\u0014\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020M0\nH\u0002J\b\u0010N\u001a\u00020OH\u0002J \u0010P\u001a\u001a\u0012\u0004\u0012\u00020Q\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00070\u00060\u0004H\u0002J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020WH\u0002J\u0014\u0010X\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Z0\nH\u0002J\u001a\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\\\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u00060\u0004H\u0002J\u0014\u0010]\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u001a0\u0004H\u0002J\b\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020bH\u0002J \u0010c\u001a\u001a\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00060\u0004H\u0002J \u0010e\u001a\u001a\u0012\u0004\u0012\u00020f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004H\u0002J\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020jJ\u0014\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020l0\nH\u0002J\u0006\u0010m\u001a\u00020n¨\u0006o"}, d2 = {"Lcom/talabat/sdsquad/core/VendorsInjection;", "", "()V", "addSwimlaneUseCase", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/swimlanes/AddSwimlanesUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "getActiveEventMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/ActiveEventDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "getActiveEventUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetActiveEventUseCase$RequestValues;", "getAddDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "getApplyCuisineUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyCuisineUseCase$RequestValues;", "getApplyFilterUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase$RequestValues;", "getApplySortUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplySortUseCase$RequestValues;", "getBranchIdUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase$RequestValues;", "", "getCollectionsDisplayMapper", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "getCollectionsUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetCollectionUseCase$RequestValues;", "getCollectionsViewModel", "Lcom/talabat/sdsquad/ui/collections/CollectionsViewModel;", "getCuisineDisplayMapper", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "getCuisineUseCase", "Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase;", "getDarkStoreRepository", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "getDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "getDishesSuggestionUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/ItemsSuggestionsUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "getFilterDisplayMapper", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "getFilterUseCase", "Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase;", "getGlobalSearchUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "getGlobalSearchViewModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchViewModel;", "getInlineAdsRepository", "Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepository;", "getInlineAdsUseCase", "Lcom/talabat/sdsquad/domain/inlineds/GetInlineAdsUseCase$RequestValues;", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "getSchedulersProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "getSearchRepository", "Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;", "getSearchWrapperBuilder", "Lcom/talabat/sdsquad/domain/globalsearch/BuildSearchWrapperUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchDisplayModel;", "getSortRepository", "Lcom/talabat/sdsquad/data/filters/SortRepository;", "getSortUseCase", "Lcom/talabat/sdsquad/domain/filters/GetSortUseCase;", "getSuggestionsSearchViewModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsViewModel;", "getSwimlaneMapper", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "getSwimlaneRepository", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "getSwimlaneUseCase", "Lcom/talabat/sdsquad/domain/swimlanes/GetSwimlanesUseCase$RequestValues;", "getUrlConstants", "Lcom/talabat/sdsquad/core/UrlConstants;", "getUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "getVendorApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "getVendorInfoDisplayMapper", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "getVendorInfoUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "getVendorJsonByIdUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "getVendorsInfoRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "getVendorsListRepositories", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "getVendorsUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "insertInlineAdsUseCase", "Lcom/talabat/sdsquad/domain/inlineds/InsertInlineAdUseCase$RequestValues;", "provideCuisineViewModel", "Lcom/talabat/sdsquad/ui/cuisines/CuisinesViewModel;", "provideFilterViewModel", "Lcom/talabat/sdsquad/ui/filters/FiltersViewModel;", "provideVendorsDisplayMapper", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "provideVendorsViewModel", "Lcom/talabat/sdsquad/ui/vendorslist/VendorsListViewModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsInjection {
    @NotNull
    public static final VendorsInjection INSTANCE = new VendorsInjection();

    private VendorsInjection() {
    }

    private final UseCase<AddSwimlanesUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> addSwimlaneUseCase() {
        return new AddSwimlanesUseCase(getSwimlaneRepository(), getSwimlaneMapper());
    }

    private final DisplayModelMapper<ActiveEventDisplayModel, ActiveEvent> getActiveEventMapper() {
        return new EventActionDisplayMapper();
    }

    private final UseCase<GetActiveEventUseCase.RequestValues, Flowable<ActiveEventDisplayModel>> getActiveEventUseCase() {
        return new GetActiveEventUseCase(getVendorsListRepositories(), getActiveEventMapper());
    }

    private final UseCase<AddDarkStoreUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> getAddDarkStoreUseCase() {
        return new AddDarkStoreUseCase(getDarkStoreRepository(), provideVendorsDisplayMapper());
    }

    private final UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> getApplyCuisineUseCase() {
        return new ApplyCuisineUseCase();
    }

    private final UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> getApplyFilterUseCase() {
        return new ApplyFiltersUseCase();
    }

    private final UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> getApplySortUseCase() {
        return new ApplySortUseCase();
    }

    private final UseCase<GetBranchesIdUseCase.RequestValues, Flowable<String>> getBranchIdUseCase() {
        return new GetBranchesIdUseCase();
    }

    private final DisplayModelMapper<CollectionDisplayModel, Collections> getCollectionsDisplayMapper() {
        return new CollectionsDisplayMapper();
    }

    private final UseCase<GetCollectionUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> getCollectionsUseCase() {
        return new GetCollectionUseCase(getVendorsInfoRepository(), getCollectionsDisplayMapper());
    }

    private final DisplayModelMapper<CuisineDisplayModel, Cuisine> getCuisineDisplayMapper() {
        return new CuisinesDisplayMapper();
    }

    private final GetCuisinesUseCase getCuisineUseCase() {
        return new GetCuisinesUseCase(getVendorsInfoRepository(), getCuisineDisplayMapper());
    }

    private final DarkStoreRepository getDarkStoreRepository() {
        return DarkStoreRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> getDarkStoreUseCase() {
        return new GetDarkStoreUseCase(getDarkStoreRepository());
    }

    private final UseCase<ItemsSuggestionsUseCase.RequestValues, Flowable<List<DishDisplayModel>>> getDishesSuggestionUseCase() {
        return new ItemsSuggestionsUseCase();
    }

    private final DisplayModelMapper<FilterDisplayModel, Filter> getFilterDisplayMapper() {
        return new FilterDisplayMapper();
    }

    private final GetFiltersUseCase getFilterUseCase() {
        return new GetFiltersUseCase(getVendorsInfoRepository(), getFilterDisplayMapper());
    }

    private final UseCase<GlobalSearchUseCase.RequestValues, Flowable<List<RestaurantsSearchResponse>>> getGlobalSearchUseCase() {
        return new GlobalSearchUseCase(getSearchRepository());
    }

    private final InLineAdsRepository getInlineAdsRepository() {
        return InLineAdsRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final UseCase<GetInlineAdsUseCase.RequestValues, Flowable<List<Ad>>> getInlineAdsUseCase() {
        return new GetInlineAdsUseCase(getInlineAdsRepository());
    }

    private final BaseSchedulerProvider getSchedulersProvider() {
        return new SchedulerProvider();
    }

    private final RestaurantSearchRepository getSearchRepository() {
        return RestaurantSearchRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final UseCase<BuildSearchWrapperUseCase.RequestValues, Flowable<List<GlobalSearchDisplayModel>>> getSearchWrapperBuilder() {
        return new BuildSearchWrapperUseCase();
    }

    private final SortRepository getSortRepository() {
        return SortRepositoryImp.Companion.getInstance();
    }

    private final GetSortUseCase getSortUseCase() {
        return new GetSortUseCase(getSortRepository());
    }

    private final DisplayModelMapper<SwimlaneDisplayModel, SwimLane> getSwimlaneMapper() {
        return new SwimlaneDisplayMapper(provideVendorsDisplayMapper());
    }

    private final SwimlanesRepository getSwimlaneRepository() {
        return SwimlanesRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final UseCase<GetSwimlanesUseCase.RequestValues, Flowable<List<SwimLane>>> getSwimlaneUseCase() {
        return new GetSwimlanesUseCase(getSwimlaneRepository());
    }

    private final UrlConstants getUrlConstants() {
        return new UrlConstantsImp();
    }

    private final UseCaseHandler getUseCaseHandler() {
        return new UseCaseHandler();
    }

    private final VendorsApi getVendorApi() {
        return new VendorsApiImp(getUrlConstants());
    }

    private final DisplayModelMapper<VendorInfo, VendorsInfoResponse> getVendorInfoDisplayMapper() {
        return new VendorInfoDisplayMapper();
    }

    private final UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> getVendorInfoUseCase() {
        return new GetVendorsInfoUseCase(getVendorsInfoRepository(), getVendorInfoDisplayMapper());
    }

    private final UseCase<GetVendorJsonByIdUseCase.RequestValues, String> getVendorJsonByIdUseCase() {
        return new GetVendorJsonByIdUseCase(getVendorsListRepositories());
    }

    private final VendorsInfoRepository getVendorsInfoRepository() {
        return VendorsInfoRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final VendorRepository getVendorsListRepositories() {
        return VendorRepositoryImp.Companion.getInstance(getVendorApi());
    }

    private final UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> getVendorsUseCase() {
        return new GetVendorsUseCase(getVendorsListRepositories(), provideVendorsDisplayMapper());
    }

    private final UseCase<InsertInlineAdUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> insertInlineAdsUseCase() {
        return new InsertInlineAdUseCase();
    }

    private final DisplayModelMapper<VendorDisplayModel, Vendor> provideVendorsDisplayMapper() {
        return new VendorDisplayMapper();
    }

    @NotNull
    public final CollectionsViewModel getCollectionsViewModel() {
        return new CollectionsViewModel(getSchedulersProvider(), getUseCaseHandler(), getVendorsUseCase(), getVendorInfoUseCase(), getApplyFilterUseCase(), getApplySortUseCase(), getApplyCuisineUseCase(), getDarkStoreUseCase(), getAddDarkStoreUseCase(), getVendorJsonByIdUseCase());
    }

    @NotNull
    public final GlobalSearchViewModel getGlobalSearchViewModel() {
        return new GlobalSearchViewModel(getSchedulersProvider(), getUseCaseHandler(), getVendorsUseCase(), getVendorInfoUseCase(), getGlobalSearchUseCase(), getBranchIdUseCase(), getSearchWrapperBuilder(), getVendorJsonByIdUseCase());
    }

    @NotNull
    public final SuggestionsViewModel getSuggestionsSearchViewModel() {
        return new SuggestionsViewModel(getSchedulersProvider(), getUseCaseHandler(), getVendorsUseCase(), getVendorInfoUseCase(), getGlobalSearchUseCase(), getBranchIdUseCase(), getDishesSuggestionUseCase(), getVendorJsonByIdUseCase());
    }

    @NotNull
    public final CuisinesViewModel provideCuisineViewModel() {
        return new CuisinesViewModel(getSchedulersProvider(), getUseCaseHandler(), getCuisineUseCase());
    }

    @NotNull
    public final FiltersViewModel provideFilterViewModel() {
        return new FiltersViewModel(getSchedulersProvider(), getUseCaseHandler(), getFilterUseCase(), getSortUseCase());
    }

    @NotNull
    public final VendorsListViewModel provideVendorsViewModel() {
        return new VendorsListViewModel(getSchedulersProvider(), getUseCaseHandler(), getVendorsUseCase(), getVendorInfoUseCase(), getApplyFilterUseCase(), getApplySortUseCase(), getApplyCuisineUseCase(), getCollectionsUseCase(), getSwimlaneUseCase(), addSwimlaneUseCase(), getInlineAdsUseCase(), insertInlineAdsUseCase(), getActiveEventUseCase(), getDarkStoreUseCase(), getAddDarkStoreUseCase(), getVendorJsonByIdUseCase());
    }
}
