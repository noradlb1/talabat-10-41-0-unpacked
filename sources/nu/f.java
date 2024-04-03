package nu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62376a;

    public /* synthetic */ f(VendorsListFragment vendorsListFragment) {
        this.f62376a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10866onActivityCreated$lambda3(this.f62376a, (Boolean) obj);
    }
}
