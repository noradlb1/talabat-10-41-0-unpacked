package oj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f57084a;

    public /* synthetic */ e(SearchResultsFragment searchResultsFragment) {
        this.f57084a = searchResultsFragment;
    }

    public final void onChanged(Object obj) {
        SearchResultsFragment.m10081observeNavigationCommands$lambda9(this.f57084a, (EventWrapper) obj);
    }
}
