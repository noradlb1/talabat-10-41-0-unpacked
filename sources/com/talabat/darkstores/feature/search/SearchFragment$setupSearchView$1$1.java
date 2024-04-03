package com.talabat.darkstores.feature.search;

import androidx.appcompat.widget.SearchView;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/talabat/darkstores/feature/search/SearchFragment$setupSearchView$1$1", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", "query", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchFragment$setupSearchView$1$1 implements SearchView.OnQueryTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f56576a;

    public SearchFragment$setupSearchView$1$1(SearchFragment searchFragment) {
        this.f56576a = searchFragment;
    }

    public boolean onQueryTextChange(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "newText");
        this.f56576a.getViewModel().onSearch(str);
        return true;
    }

    public boolean onQueryTextSubmit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        SearchFragmentViewModel.onSearchQuerySubmitted$default(this.f56576a.getViewModel(), str, (ScreenTrackingProvider.EventOrigin) null, 2, (Object) null);
        return true;
    }
}
