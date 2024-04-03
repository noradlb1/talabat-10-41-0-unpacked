package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.presentation.displaymodel.SwimLaneEvent;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63063a;

    public /* synthetic */ d(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63063a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10451observeViewModel$lambda12(this.f63063a, (SwimLaneEvent) obj);
    }
}
