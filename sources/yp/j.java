package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63069a;

    public /* synthetic */ j(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63069a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10458observeViewModel$lambda7(this.f63069a, (Boolean) obj);
    }
}
