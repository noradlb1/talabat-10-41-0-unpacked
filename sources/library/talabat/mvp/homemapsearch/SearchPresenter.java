package library.talabat.mvp.homemapsearch;

import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/SearchPresenter;", "Llibrary/talabat/mvp/homemapsearch/ISearchPresenter;", "homeMapSearchView", "Llibrary/talabat/mvp/homemapsearch/SearchView;", "(Llibrary/talabat/mvp/homemapsearch/SearchView;)V", "getHomeMapSearchView", "()Llibrary/talabat/mvp/homemapsearch/SearchView;", "setHomeMapSearchView", "loadSuggestions", "", "keyword", "", "onDestroy", "searchViewTypeHandler", "searchQuery", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchPresenter implements ISearchPresenter {
    @Nullable
    private SearchView homeMapSearchView;

    public SearchPresenter(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "homeMapSearchView");
        this.homeMapSearchView = searchView;
    }

    @Nullable
    public final SearchView getHomeMapSearchView() {
        return this.homeMapSearchView;
    }

    public void loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "keyword");
    }

    public void onDestroy() {
        this.homeMapSearchView = null;
    }

    public void searchViewTypeHandler(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        if (TalabatUtils.isNullOrEmpty(str)) {
            SearchView searchView = this.homeMapSearchView;
            if (searchView != null) {
                searchView.loadDeliveryAreas();
                return;
            }
            return;
        }
        SearchView searchView2 = this.homeMapSearchView;
        if (searchView2 != null) {
            searchView2.loadGooglePlaceSearch();
        }
    }

    public final void setHomeMapSearchView(@Nullable SearchView searchView) {
        this.homeMapSearchView = searchView;
    }
}
