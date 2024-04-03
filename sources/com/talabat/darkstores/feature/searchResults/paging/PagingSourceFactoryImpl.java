package com.talabat.darkstores.feature.searchResults.paging;

import androidx.paging.PagingSource;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import com.talabat.darkstores.feature.mission.control.GetPrimaryMissionControlProductsUseCase;
import com.talabat.darkstores.feature.product.usecase.GetSwimlaneProductUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ<\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J0\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactoryImpl;", "Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactory;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "searchUseCase", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsUseCase;", "getLifestyleMissionControlProductsUseCase", "Lcom/talabat/darkstores/feature/mission/control/GetLifestyleMissionControlProductsUseCase;", "getPrimaryMissionControlProducts", "Lcom/talabat/darkstores/feature/mission/control/GetPrimaryMissionControlProductsUseCase;", "getSwimlaneProducts", "Lcom/talabat/darkstores/feature/product/usecase/GetSwimlaneProductUseCase;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/feature/searchResults/SearchResultsUseCase;Lcom/talabat/darkstores/feature/mission/control/GetLifestyleMissionControlProductsUseCase;Lcom/talabat/darkstores/feature/mission/control/GetPrimaryMissionControlProductsUseCase;Lcom/talabat/darkstores/feature/product/usecase/GetSwimlaneProductUseCase;Lio/reactivex/Scheduler;)V", "create", "Landroidx/paging/PagingSource;", "", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "categoryId", "", "cachedCategories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "canShowCategories", "", "createPageNumberPageSource", "Lcom/talabat/darkstores/feature/searchResults/paging/PageNumberPagingSource;", "createSearchPagingSource", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingSource;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagingSourceFactoryImpl implements PagingSourceFactory {
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase;
    @NotNull
    private final GetPrimaryMissionControlProductsUseCase getPrimaryMissionControlProducts;
    @NotNull
    private final GetSwimlaneProductUseCase getSwimlaneProducts;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final SearchResultsUseCase searchUseCase;

    @Inject
    public PagingSourceFactoryImpl(@NotNull DiscoveryRepo discoveryRepo2, @NotNull SearchResultsUseCase searchResultsUseCase, @NotNull GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase2, @NotNull GetPrimaryMissionControlProductsUseCase getPrimaryMissionControlProductsUseCase, @NotNull GetSwimlaneProductUseCase getSwimlaneProductUseCase, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(searchResultsUseCase, "searchUseCase");
        Intrinsics.checkNotNullParameter(getLifestyleMissionControlProductsUseCase2, "getLifestyleMissionControlProductsUseCase");
        Intrinsics.checkNotNullParameter(getPrimaryMissionControlProductsUseCase, "getPrimaryMissionControlProducts");
        Intrinsics.checkNotNullParameter(getSwimlaneProductUseCase, "getSwimlaneProducts");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.discoveryRepo = discoveryRepo2;
        this.searchUseCase = searchResultsUseCase;
        this.getLifestyleMissionControlProductsUseCase = getLifestyleMissionControlProductsUseCase2;
        this.getPrimaryMissionControlProducts = getPrimaryMissionControlProductsUseCase;
        this.getSwimlaneProducts = getSwimlaneProductUseCase;
        this.ioScheduler = scheduler;
    }

    private final PageNumberPagingSource createPageNumberPageSource(String str, List<SearchCategory> list, SearchResultsType searchResultsType, boolean z11) {
        return new PageNumberPagingSource(this.getPrimaryMissionControlProducts, this.getSwimlaneProducts, str, z11, list, searchResultsType, this.ioScheduler);
    }

    private final SearchPagingSource createSearchPagingSource(String str, SearchResultsType searchResultsType) {
        return new SearchPagingSource(this.discoveryRepo, this.searchUseCase, this.getLifestyleMissionControlProductsUseCase, str, searchResultsType, this.ioScheduler);
    }

    @NotNull
    public PagingSource<Integer, SearchPagingItem> create(@Nullable String str, @NotNull List<SearchCategory> list, @NotNull SearchResultsType searchResultsType, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "cachedCategories");
        Intrinsics.checkNotNullParameter(searchResultsType, "resultType");
        if (searchResultsType instanceof SearchResultsType.PrimaryMissionControl) {
            return createPageNumberPageSource(str, list, searchResultsType, z11);
        }
        if (searchResultsType instanceof SearchResultsType.LifestyleMissionControlV2) {
            return createPageNumberPageSource(str, list, searchResultsType, z11);
        }
        if (searchResultsType instanceof SearchResultsType.SwimlaneProducts) {
            return createPageNumberPageSource(str, list, searchResultsType, z11);
        }
        return createSearchPagingSource(str, searchResultsType);
    }
}
