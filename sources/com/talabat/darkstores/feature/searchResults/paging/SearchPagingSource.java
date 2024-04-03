package com.talabat.darkstores.feature.searchResults.paging;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;
import com.facebook.internal.NativeProtocol;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pj.d;
import pj.e;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J@\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J#\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"0!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!*\u00020\r2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002H\u0002R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingSource;", "Landroidx/paging/rxjava2/RxPagingSource;", "", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "searchUseCase", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsUseCase;", "getLifestyleMissionControlProductsUseCase", "Lcom/talabat/darkstores/feature/mission/control/GetLifestyleMissionControlProductsUseCase;", "categoryId", "", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/feature/searchResults/SearchResultsUseCase;Lcom/talabat/darkstores/feature/mission/control/GetLifestyleMissionControlProductsUseCase;Ljava/lang/String;Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Lio/reactivex/Scheduler;)V", "getCategoryId$com_talabat_NewArchi_darkstores_darkstores", "()Ljava/lang/String;", "buildResultList", "", "params", "Landroidx/paging/PagingSource$LoadParams;", "categories", "Lcom/talabat/darkstores/data/SearchCategory;", "products", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "totalCount", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "loadSingle", "Lio/reactivex/Single;", "Landroidx/paging/PagingSource$LoadResult;", "prepareRequest", "Lcom/talabat/darkstores/data/SearchResultData;", "loadSize", "offset", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchPagingSource extends RxPagingSource<Integer, SearchPagingItem> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INIT_OFFSET = 0;
    @Nullable
    private final String categoryId;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final SearchResultsType resultType;
    @NotNull
    private final SearchResultsUseCase searchUseCase;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingSource$Companion;", "", "()V", "INIT_OFFSET", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SearchPagingSource(@NotNull DiscoveryRepo discoveryRepo2, @NotNull SearchResultsUseCase searchResultsUseCase, @NotNull GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase2, @Nullable String str, @NotNull SearchResultsType searchResultsType, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(searchResultsUseCase, "searchUseCase");
        Intrinsics.checkNotNullParameter(getLifestyleMissionControlProductsUseCase2, "getLifestyleMissionControlProductsUseCase");
        Intrinsics.checkNotNullParameter(searchResultsType, "resultType");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.discoveryRepo = discoveryRepo2;
        this.searchUseCase = searchResultsUseCase;
        this.getLifestyleMissionControlProductsUseCase = getLifestyleMissionControlProductsUseCase2;
        this.categoryId = str;
        this.resultType = searchResultsType;
        this.ioScheduler = scheduler;
    }

    private final List<SearchPagingItem> buildResultList(PagingSource.LoadParams<Integer> loadParams, List<SearchCategory> list, List<Product> list2, int i11) {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        if (loadParams.getKey() == null) {
            if (!list.isEmpty()) {
                createListBuilder.add(new SearchPagingItem.Categories(list));
            } else {
                createListBuilder.add(new SearchPagingItem.TotalCount(i11));
            }
        }
        Iterable<Product> iterable = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Product product : iterable) {
            arrayList.add(new SearchPagingItem.Product(product));
        }
        createListBuilder.addAll(arrayList);
        return CollectionsKt__CollectionsJVMKt.build(createListBuilder);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-1  reason: not valid java name */
    public static final PagingSource.LoadResult m10095loadSingle$lambda1(int i11, SearchPagingSource searchPagingSource, PagingSource.LoadParams loadParams, SearchResultData searchResultData) {
        Integer num;
        Intrinsics.checkNotNullParameter(searchPagingSource, "this$0");
        Intrinsics.checkNotNullParameter(loadParams, "$params");
        Intrinsics.checkNotNullParameter(searchResultData, "<name for destructuring parameter 0>");
        List<Product> component1 = searchResultData.component1();
        int component4 = searchResultData.component4();
        List<SearchCategory> component5 = searchResultData.component5();
        int size = component1.size();
        int i12 = i11 + size;
        if (component5 == null) {
            component5 = CollectionsKt__CollectionsKt.emptyList();
        }
        List<SearchPagingItem> buildResultList = searchPagingSource.buildResultList(loadParams, component5, component1, component4);
        Integer num2 = null;
        if (i11 == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i11 - size);
        }
        if (i12 < component4) {
            num2 = Integer.valueOf(i12);
        }
        return new PagingSource.LoadResult.Page(buildResultList, num, num2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-2  reason: not valid java name */
    public static final PagingSource.LoadResult m10096loadSingle$lambda2(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new PagingSource.LoadResult.Error(th2);
    }

    private final Single<SearchResultData> prepareRequest(SearchResultsType searchResultsType, int i11, int i12) {
        if (searchResultsType instanceof SearchResultsType.Banner) {
            return this.discoveryRepo.getProductsForTag(((SearchResultsType.Banner) searchResultsType).getTag(), i11, i12);
        }
        if (searchResultsType instanceof SearchResultsType.Category) {
            return this.discoveryRepo.getProductsForCategory(((SearchResultsType.Category) searchResultsType).getCategoryId(), i11, i12);
        }
        if (searchResultsType instanceof SearchResultsType.Query) {
            return this.searchUseCase.search(((SearchResultsType.Query) searchResultsType).getQuery(), i11, i12, this.categoryId);
        }
        if (searchResultsType instanceof SearchResultsType.Tag) {
            return this.discoveryRepo.getProductsForTag(((SearchResultsType.Tag) searchResultsType).getTag(), i11, i12);
        }
        if (searchResultsType instanceof SearchResultsType.LifestyleMissionControl) {
            return this.getLifestyleMissionControlProductsUseCase.getMissionControlProducts(((SearchResultsType.LifestyleMissionControl) searchResultsType).getCode(), i11, i12, this.categoryId);
        }
        SearchResultsType searchResultsType2 = this.resultType;
        Single<SearchResultData> error = Single.error((Throwable) new IllegalArgumentException("Unsupported result type: " + searchResultsType2));
        Intrinsics.checkNotNullExpressionValue(error, "error(\n                I…esultType\")\n            )");
        return error;
    }

    @Nullable
    public final String getCategoryId$com_talabat_NewArchi_darkstores_darkstores() {
        return this.categoryId;
    }

    @NotNull
    public Single<PagingSource.LoadResult<Integer, SearchPagingItem>> loadSingle(@NotNull PagingSource.LoadParams<Integer> loadParams) {
        int i11;
        Intrinsics.checkNotNullParameter(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Integer key = loadParams.getKey();
        if (key != null) {
            i11 = key.intValue();
        } else {
            i11 = 0;
        }
        Single<R> onErrorReturn = prepareRequest(this.resultType, loadParams.getLoadSize(), i11).subscribeOn(this.ioScheduler).map(new d(i11, this, loadParams)).onErrorReturn(new e());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "resultType.prepareReques… { LoadResult.Error(it) }");
        return onErrorReturn;
    }

    @Nullable
    public Integer getRefreshKey(@NotNull PagingState<Integer, SearchPagingItem> pagingState) {
        Integer nextKey;
        int intValue;
        Integer prevKey;
        Intrinsics.checkNotNullParameter(pagingState, "state");
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }
        PagingSource.LoadResult.Page<Integer, SearchPagingItem> closestPageToPosition = pagingState.closestPageToPosition(anchorPosition.intValue());
        if (closestPageToPosition != null && (prevKey = closestPageToPosition.getPrevKey()) != null) {
            intValue = prevKey.intValue() + 1;
        } else if (closestPageToPosition == null || (nextKey = closestPageToPosition.getNextKey()) == null) {
            return null;
        } else {
            intValue = nextKey.intValue() - 1;
        }
        return Integer.valueOf(intValue);
    }
}
