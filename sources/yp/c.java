package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.presentation.displaymodel.CollectionItem;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63062a;

    public /* synthetic */ c(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63062a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10450observeViewModel$lambda11(this.f63062a, (CollectionItem) obj);
    }
}
