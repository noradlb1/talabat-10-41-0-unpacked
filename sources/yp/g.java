package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.presentation.displaymodel.Configuration;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63066a;

    public /* synthetic */ g(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63066a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10455observeViewModel$lambda4(this.f63066a, (Configuration) obj);
    }
}
