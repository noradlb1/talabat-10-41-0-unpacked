package to;

import androidx.arch.core.util.Function;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f62920a;

    public /* synthetic */ e(TproBenefitsViewModel tproBenefitsViewModel) {
        this.f62920a = tproBenefitsViewModel;
    }

    public final Object apply(Object obj) {
        return TproBenefitsViewModel.m10367mapAmountForMultiPlan$lambda5(this.f62920a, (TProMultiPlanDisplayModel) obj);
    }
}
