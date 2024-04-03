package mj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.search.SearchFragment;
import java.util.Map;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f57039a;

    public /* synthetic */ k(SearchFragment searchFragment) {
        this.f57039a = searchFragment;
    }

    public final void onChanged(Object obj) {
        SearchFragment.m10061observeCartMap$lambda3(this.f57039a, (Map) obj);
    }
}
