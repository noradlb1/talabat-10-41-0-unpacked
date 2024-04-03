package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.presentation.mapper.EntryPointItem;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63071a;

    public /* synthetic */ l(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63071a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10460observeViewModel$lambda9(this.f63071a, (EntryPointItem) obj);
    }
}
