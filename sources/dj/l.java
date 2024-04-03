package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import com.talabat.darkstores.feature.home.HomeFragment;
import java.util.Map;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartMapProductListAdapter f56747a;

    public /* synthetic */ l(CartMapProductListAdapter cartMapProductListAdapter) {
        this.f56747a = cartMapProductListAdapter;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m9946addSwimlaneView$lambda45(this.f56747a, (Map) obj);
    }
}
