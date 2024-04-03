package com.talabat.darkstores.feature.searchResults.paging;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;
import com.facebook.internal.NativeProtocol;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.domain.model.ProductsHolderWithPagination;
import com.talabat.darkstores.feature.mission.control.GetPrimaryMissionControlProductsUseCase;
import com.talabat.darkstores.feature.product.usecase.GetSwimlaneProductUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pj.a;
import pj.b;
import pj.c;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J8\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\rH\u0002J#\u0010 \u001a\u0004\u0018\u00010\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0016¢\u0006\u0002\u0010#J(\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030&0%2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0%*\u00020\u00102\u0006\u0010)\u001a\u00020\u0002H\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/PageNumberPagingSource;", "Landroidx/paging/rxjava2/RxPagingSource;", "", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "getPrimaryMissionControlProduct", "Lcom/talabat/darkstores/feature/mission/control/GetPrimaryMissionControlProductsUseCase;", "getSwimlaneProducts", "Lcom/talabat/darkstores/feature/product/usecase/GetSwimlaneProductUseCase;", "categoryId", "", "canShowCategories", "", "cachedCategories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/feature/mission/control/GetPrimaryMissionControlProductsUseCase;Lcom/talabat/darkstores/feature/product/usecase/GetSwimlaneProductUseCase;Ljava/lang/String;ZLjava/util/List;Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Lio/reactivex/Scheduler;)V", "getCachedCategories$com_talabat_NewArchi_darkstores_darkstores", "()Ljava/util/List;", "getCanShowCategories$com_talabat_NewArchi_darkstores_darkstores", "()Z", "getCategoryId$com_talabat_NewArchi_darkstores_darkstores", "()Ljava/lang/String;", "buildResultList", "params", "Landroidx/paging/PagingSource$LoadParams;", "categories", "products", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "loadSingle", "Lio/reactivex/Single;", "Landroidx/paging/PagingSource$LoadResult;", "prepareRequest", "Lcom/talabat/darkstores/domain/model/ProductsHolderWithPagination;", "pageNumber", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageNumberPagingSource extends RxPagingSource<Integer, SearchPagingItem> {
    @NotNull
    private final List<SearchCategory> cachedCategories;
    private final boolean canShowCategories;
    @Nullable
    private final String categoryId;
    @NotNull
    private final GetPrimaryMissionControlProductsUseCase getPrimaryMissionControlProduct;
    @NotNull
    private final GetSwimlaneProductUseCase getSwimlaneProducts;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final SearchResultsType resultType;

    public PageNumberPagingSource(@NotNull GetPrimaryMissionControlProductsUseCase getPrimaryMissionControlProductsUseCase, @NotNull GetSwimlaneProductUseCase getSwimlaneProductUseCase, @Nullable String str, boolean z11, @NotNull List<SearchCategory> list, @NotNull SearchResultsType searchResultsType, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(getPrimaryMissionControlProductsUseCase, "getPrimaryMissionControlProduct");
        Intrinsics.checkNotNullParameter(getSwimlaneProductUseCase, "getSwimlaneProducts");
        Intrinsics.checkNotNullParameter(list, "cachedCategories");
        Intrinsics.checkNotNullParameter(searchResultsType, "resultType");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.getPrimaryMissionControlProduct = getPrimaryMissionControlProductsUseCase;
        this.getSwimlaneProducts = getSwimlaneProductUseCase;
        this.categoryId = str;
        this.canShowCategories = z11;
        this.cachedCategories = list;
        this.resultType = searchResultsType;
        this.ioScheduler = scheduler;
    }

    private final List<SearchPagingItem> buildResultList(PagingSource.LoadParams<Integer> loadParams, List<SearchCategory> list, List<Product> list2) {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        if (loadParams.getKey() == null) {
            if (this.canShowCategories) {
                if (!list.isEmpty()) {
                    createListBuilder.add(new SearchPagingItem.Categories(list));
                } else if (!this.cachedCategories.isEmpty()) {
                    createListBuilder.add(new SearchPagingItem.Categories(this.cachedCategories));
                }
            }
            createListBuilder.add(new SearchPagingItem.TotalCount(list2.size()));
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
    public static final PagingSource.LoadResult m10092loadSingle$lambda1(PageNumberPagingSource pageNumberPagingSource, PagingSource.LoadParams loadParams, int i11, ProductsHolderWithPagination productsHolderWithPagination) {
        Integer num;
        Intrinsics.checkNotNullParameter(pageNumberPagingSource, "this$0");
        Intrinsics.checkNotNullParameter(loadParams, "$params");
        Intrinsics.checkNotNullParameter(productsHolderWithPagination, "result");
        List<SearchCategory> categories = productsHolderWithPagination.getCategories();
        if (categories == null) {
            categories = CollectionsKt__CollectionsKt.emptyList();
        }
        List<SearchPagingItem> buildResultList = pageNumberPagingSource.buildResultList(loadParams, categories, productsHolderWithPagination.getProducts());
        Integer num2 = null;
        if (i11 <= 0) {
            num = null;
        } else {
            num = Integer.valueOf(i11 - 1);
        }
        if (!productsHolderWithPagination.isLast()) {
            num2 = Integer.valueOf(i11 + 1);
        }
        return new PagingSource.LoadResult.Page(buildResultList, num, num2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-2  reason: not valid java name */
    public static final PagingSource.LoadResult m10093loadSingle$lambda2(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new PagingSource.LoadResult.Error(th2);
    }

    private final Single<ProductsHolderWithPagination<?>> prepareRequest(SearchResultsType searchResultsType, int i11) {
        Single<ProductsHolderWithPagination<?>> defer = Single.defer(new c(searchResultsType, this, i11));
        Intrinsics.checkNotNullExpressionValue(defer, "defer {\n            when…)\n            }\n        }");
        return defer;
    }

    /* access modifiers changed from: private */
    /* renamed from: prepareRequest$lambda-4  reason: not valid java name */
    public static final SingleSource m10094prepareRequest$lambda4(SearchResultsType searchResultsType, PageNumberPagingSource pageNumberPagingSource, int i11) {
        Intrinsics.checkNotNullParameter(searchResultsType, "$this_prepareRequest");
        Intrinsics.checkNotNullParameter(pageNumberPagingSource, "this$0");
        if (searchResultsType instanceof SearchResultsType.PrimaryMissionControl) {
            return pageNumberPagingSource.getPrimaryMissionControlProduct.invoke(((SearchResultsType.PrimaryMissionControl) searchResultsType).getCode(), i11, pageNumberPagingSource.categoryId);
        }
        if (searchResultsType instanceof SearchResultsType.LifestyleMissionControlV2) {
            return pageNumberPagingSource.getSwimlaneProducts.invoke(((SearchResultsType.LifestyleMissionControlV2) searchResultsType).getSwimlaneId(), "", "", i11, pageNumberPagingSource.categoryId);
        } else if (searchResultsType instanceof SearchResultsType.SwimlaneProducts) {
            SearchResultsType.SwimlaneProducts swimlaneProducts = (SearchResultsType.SwimlaneProducts) searchResultsType;
            return pageNumberPagingSource.getSwimlaneProducts.invoke(swimlaneProducts.getSwimlaneId(), swimlaneProducts.getProductId(), swimlaneProducts.getProductSku(), i11, pageNumberPagingSource.categoryId);
        } else {
            SearchResultsType searchResultsType2 = pageNumberPagingSource.resultType;
            Single error = Single.error((Throwable) new IllegalArgumentException("Unsupported result type: " + searchResultsType2));
            Intrinsics.checkNotNullExpressionValue(error, "error(\n                 …tType\")\n                )");
            return error;
        }
    }

    @NotNull
    public final List<SearchCategory> getCachedCategories$com_talabat_NewArchi_darkstores_darkstores() {
        return this.cachedCategories;
    }

    public final boolean getCanShowCategories$com_talabat_NewArchi_darkstores_darkstores() {
        return this.canShowCategories;
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
        Single<R> subscribeOn = prepareRequest(this.resultType, i11).map(new a(this, loadParams, i11)).onErrorReturn(new b()).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "resultType.prepareReques….subscribeOn(ioScheduler)");
        return subscribeOn;
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
