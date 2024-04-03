package yp;

import androidx.lifecycle.Observer;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63064a;

    public /* synthetic */ e(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63064a = fluidHomeScreenFragment;
    }

    public final void onChanged(Object obj) {
        FluidHomeScreenFragment.m10452observeViewModel$lambda13(this.f63064a, (ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo) obj);
    }
}
