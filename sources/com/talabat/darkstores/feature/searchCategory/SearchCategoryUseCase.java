package com.talabat.darkstores.feature.searchCategory;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.model.Category;
import io.reactivex.Single;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nj.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\r*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/feature/searchCategory/SearchCategoryUseCase;", "", "searchRepository", "Lcom/talabat/darkstores/data/search/SearchRepository;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "(Lcom/talabat/darkstores/data/search/SearchRepository;Lcom/talabat/darkstores/data/tracking/SearchTracker;)V", "searchCategory", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/search/model/SearchCategoryResponse;", "query", "", "trackEvent", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoryUseCase {
    @NotNull
    private final SearchRepository searchRepository;
    @NotNull
    private final SearchTracker searchTracker;

    @Inject
    public SearchCategoryUseCase(@NotNull SearchRepository searchRepository2, @NotNull SearchTracker searchTracker2) {
        Intrinsics.checkNotNullParameter(searchRepository2, "searchRepository");
        Intrinsics.checkNotNullParameter(searchTracker2, "searchTracker");
        this.searchRepository = searchRepository2;
        this.searchTracker = searchTracker2;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchCategory$lambda-0  reason: not valid java name */
    public static final void m10078searchCategory$lambda0(SearchCategoryUseCase searchCategoryUseCase, String str, SearchCategoryResponse searchCategoryResponse) {
        Intrinsics.checkNotNullParameter(searchCategoryUseCase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullExpressionValue(searchCategoryResponse, "it");
        searchCategoryUseCase.trackEvent(searchCategoryResponse, str);
    }

    private final void trackEvent(SearchCategoryResponse searchCategoryResponse, String str) {
        if (!searchCategoryResponse.getCategories().isEmpty()) {
            SearchTracker searchTracker2 = this.searchTracker;
            int size = searchCategoryResponse.getCategories().size();
            Iterable<Category> categories = searchCategoryResponse.getCategories();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(categories, 10));
            for (Category id2 : categories) {
                arrayList.add(id2.getId());
            }
            Iterable<Category> categories2 = searchCategoryResponse.getCategories();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(categories2, 10));
            for (Category name2 : categories2) {
                arrayList2.add(name2.getName());
            }
            searchTracker2.searchCategoryLoaded(size, str, arrayList, arrayList2);
        }
    }

    @NotNull
    public final Single<SearchCategoryResponse> searchCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<SearchCategoryResponse> doOnSuccess = this.searchRepository.searchCategory(str).doOnSuccess(new a(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "searchRepository.searchC…ackEvent(query)\n        }");
        return doOnSuccess;
    }
}
