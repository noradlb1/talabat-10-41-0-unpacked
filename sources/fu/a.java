package fu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.cuisines.CuisinesFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesFragment f62071a;

    public /* synthetic */ a(CuisinesFragment cuisinesFragment) {
        this.f62071a = cuisinesFragment;
    }

    public final void onChanged(Object obj) {
        CuisinesFragment.m10812onActivityCreated$lambda0(this.f62071a, (List) obj);
    }
}
