package com.talabat.darkstores.feature.searchResults;

import androidx.recyclerview.widget.GridLayoutManager;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsProductsListAdapter$onAttachedToRecyclerView$1 extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsProductsListAdapter f56619a;

    public SearchResultsProductsListAdapter$onAttachedToRecyclerView$1(SearchResultsProductsListAdapter searchResultsProductsListAdapter) {
        this.f56619a = searchResultsProductsListAdapter;
    }

    public int getSpanSize(int i11) {
        boolean z11;
        SearchPagingItem access$getItem = SearchResultsProductsListAdapter.access$getItem(this.f56619a, i11);
        if (access$getItem instanceof SearchPagingItem.Categories) {
            z11 = true;
        } else {
            z11 = access$getItem instanceof SearchPagingItem.TotalCount;
        }
        if (z11) {
            return 2;
        }
        if ((access$getItem instanceof SearchPagingItem.Product) || access$getItem == null) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
