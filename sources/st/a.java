package st;

import androidx.lifecycle.Observer;
import com.talabat.restaurants.v2.ui.fragments.VendorsListFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62905a;

    public /* synthetic */ a(VendorsListFragment vendorsListFragment) {
        this.f62905a = vendorsListFragment;
    }

    public final void onChanged(Object obj) {
        VendorsListFragment.m10757observatory$lambda1(this.f62905a, (EventWrapper) obj);
    }
}
