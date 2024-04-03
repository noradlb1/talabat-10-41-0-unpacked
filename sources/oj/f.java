package oj;

import android.view.View;
import com.talabat.darkstores.feature.searchResults.SearchResultsProductsListAdapter;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResultsProductsListAdapter f57085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SearchPagingItem f57086c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57087d;

    public /* synthetic */ f(SearchResultsProductsListAdapter searchResultsProductsListAdapter, SearchPagingItem searchPagingItem, int i11) {
        this.f57085b = searchResultsProductsListAdapter;
        this.f57086c = searchPagingItem;
        this.f57087d = i11;
    }

    public final void onClick(View view) {
        SearchResultsProductsListAdapter.m10084onBindViewHolder$lambda0(this.f57085b, this.f57086c, this.f57087d, view);
    }
}
