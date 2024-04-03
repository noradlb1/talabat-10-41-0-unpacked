package nu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62377a;

    public /* synthetic */ g(VendorsListFragment vendorsListFragment) {
        this.f62377a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10867onActivityCreated$lambda4(this.f62377a, (Boolean) obj);
    }
}
