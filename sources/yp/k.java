package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63070a;

    public /* synthetic */ k(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63070a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10459observeViewModel$lambda8(this.f63070a, (String) obj);
    }
}
