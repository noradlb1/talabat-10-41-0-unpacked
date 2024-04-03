package yp;

import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.OnCollectionScrollListener;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment$talabatFluidHost$2;
import java.util.List;

public final /* synthetic */ class n implements OnCollectionScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f63073a;

    public /* synthetic */ n(FluidHomeScreenFragment fluidHomeScreenFragment) {
        this.f63073a = fluidHomeScreenFragment;
    }

    public final void onScrollTo(int i11, List list, TemplateUiData templateUiData) {
        FluidHomeScreenFragment$talabatFluidHost$2.AnonymousClass1.m10462collectionScroll$lambda1(this.f63073a, i11, list, templateUiData);
    }
}
