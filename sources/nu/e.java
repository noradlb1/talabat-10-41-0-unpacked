package nu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;
import java.util.List;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62375a;

    public /* synthetic */ e(VendorsListFragment vendorsListFragment) {
        this.f62375a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10865onActivityCreated$lambda2(this.f62375a, (List) obj);
    }
}
