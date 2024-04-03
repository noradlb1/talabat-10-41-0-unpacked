package nu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62374a;

    public /* synthetic */ d(VendorsListFragment vendorsListFragment) {
        this.f62374a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10864onActivityCreated$lambda1(this.f62374a, (Boolean) obj);
    }
}
