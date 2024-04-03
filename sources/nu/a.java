package nu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62367a;

    public /* synthetic */ a(VendorsListFragment vendorsListFragment) {
        this.f62367a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10860observeInLineAds$lambda11(this.f62367a, (List) obj);
    }
}
