package com.talabat.darkstores.feature.searchResults;

import androidx.paging.PagingSource;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsFragmentViewModel$createPagerForCategory$1 extends Lambda implements Function0<PagingSource<Integer, SearchPagingItem>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragmentViewModel f56611g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f56612h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragmentViewModel$createPagerForCategory$1(SearchResultsFragmentViewModel searchResultsFragmentViewModel, String str) {
        super(0);
        this.f56611g = searchResultsFragmentViewModel;
        this.f56612h = str;
    }

    @NotNull
    public final PagingSource<Integer, SearchPagingItem> invoke() {
        PagingSourceFactory access$getPagingSourceFactory$p = this.f56611g.pagingSourceFactory;
        String str = this.f56612h;
        List<SearchCategory> cachedCategories$com_talabat_NewArchi_darkstores_darkstores = this.f56611g.getCachedCategories$com_talabat_NewArchi_darkstores_darkstores();
        if (cachedCategories$com_talabat_NewArchi_darkstores_darkstores == null) {
            cachedCategories$com_talabat_NewArchi_darkstores_darkstores = CollectionsKt__CollectionsKt.emptyList();
        }
        return access$getPagingSourceFactory$p.create(str, cachedCategories$com_talabat_NewArchi_darkstores_darkstores, this.f56611g.resultType, this.f56611g.canShowCategoriesFilter());
    }
}
