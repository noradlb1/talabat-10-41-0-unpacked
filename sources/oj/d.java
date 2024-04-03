package oj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragment;
import java.util.Map;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f57083a;

    public /* synthetic */ d(SearchResultsFragment searchResultsFragment) {
        this.f57083a = searchResultsFragment;
    }

    public final void onChanged(Object obj) {
        SearchResultsFragment.m10080observeData$lambda7(this.f57083a, (Map) obj);
    }
}
