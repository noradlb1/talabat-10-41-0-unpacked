package mj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.search.SearchFragment;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f57036a;

    public /* synthetic */ h(SearchFragment searchFragment) {
        this.f57036a = searchFragment;
    }

    public final void onChanged(Object obj) {
        SearchFragment.m10063observeSearchQuery$lambda7(this.f57036a, (String) obj);
    }
}
