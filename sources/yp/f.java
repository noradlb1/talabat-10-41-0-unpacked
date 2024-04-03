package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.presentation.displaymodel.HeaderColour;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63065a;

    public /* synthetic */ f(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63065a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10454observeViewModel$lambda3(this.f63065a, (HeaderColour) obj);
    }
}
