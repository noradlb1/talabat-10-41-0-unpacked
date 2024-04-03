package mj;

import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.talabat.darkstores.feature.search.SearchFragment;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f57032b;

    public /* synthetic */ d(SearchView searchView) {
        this.f57032b = searchView;
    }

    public final void onFocusChange(View view, boolean z11) {
        SearchFragment.m10067setupSearchView$lambda10$lambda9(this.f57032b, view, z11);
    }
}
