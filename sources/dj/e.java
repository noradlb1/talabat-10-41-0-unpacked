package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.home.HomeFragment;
import com.talabat.feature.darkstorescart.data.model.Product;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56735a;

    public /* synthetic */ e(HomeFragment homeFragment) {
        this.f56735a = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m9948observeData$lambda17(this.f56735a, (Product) obj);
    }
}
