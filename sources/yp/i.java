package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63068a;

    public /* synthetic */ i(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63068a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10457observeViewModel$lambda6(this.f63068a, (Boolean) obj);
    }
}
