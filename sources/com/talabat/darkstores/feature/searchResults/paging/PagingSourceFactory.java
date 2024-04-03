package com.talabat.darkstores.feature.searchResults.paging;

import androidx.paging.PagingSource;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactory;", "", "create", "Landroidx/paging/PagingSource;", "", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "categoryId", "", "cachedCategories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "canShowCategories", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PagingSourceFactory {
    @NotNull
    PagingSource<Integer, SearchPagingItem> create(@Nullable String str, @NotNull List<SearchCategory> list, @NotNull SearchResultsType searchResultsType, boolean z11);
}
