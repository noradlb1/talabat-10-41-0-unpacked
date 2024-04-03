package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63060a;

    public /* synthetic */ a(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63060a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10453observeViewModel$lambda2(this.f63060a, (List) obj);
    }
}
