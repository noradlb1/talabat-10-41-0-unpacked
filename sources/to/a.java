package to;

import androidx.arch.core.util.Function;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f62916a;

    public /* synthetic */ a(TproBenefitsViewModel tproBenefitsViewModel) {
        this.f62916a = tproBenefitsViewModel;
    }

    public final Object apply(Object obj) {
        return TproBenefitsViewModel.m10368mapAmountForNewHeroMultiPlan$lambda4(this.f62916a, (TProOnBoardingDisplayModel) obj);
    }
}
