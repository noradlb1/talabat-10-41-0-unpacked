package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63067a;

    public /* synthetic */ h(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63067a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10456observeViewModel$lambda5(this.f63067a, (String) obj);
    }
}
