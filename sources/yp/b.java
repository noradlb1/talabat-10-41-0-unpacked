package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import com.talabat.homescreen.adapter.model.banner.BannerAdItem;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63061a;

    public /* synthetic */ b(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63061a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10449observeViewModel$lambda10(this.f63061a, (BannerAdItem) obj);
    }
}
