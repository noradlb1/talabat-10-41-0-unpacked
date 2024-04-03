package oj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f57081a;

    public /* synthetic */ b(SearchResultsFragment searchResultsFragment) {
        this.f57081a = searchResultsFragment;
    }

    public final void onChanged(Object obj) {
        SearchResultsFragment.m10082setupRecyclerView$lambda6(this.f57081a, (Integer) obj);
    }
}
