package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.home.HomeFragment;
import java.util.List;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56733a;

    public /* synthetic */ d(HomeFragment homeFragment) {
        this.f56733a = homeFragment;
    }

    public final void onChanged(Object obj) {
        this.f56733a.setVouchersSwimLane((List) obj);
    }
}
