package mj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.search.SearchFragment;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f57038a;

    public /* synthetic */ j(SearchFragment searchFragment) {
        this.f57038a = searchFragment;
    }

    public final void onChanged(Object obj) {
        SearchFragment.m10064observeViewAllVisibility$lambda6(this.f57038a, (Boolean) obj);
    }
}
