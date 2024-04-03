package to;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f62919a;

    public /* synthetic */ d(TproBenefitsViewModel tproBenefitsViewModel) {
        this.f62919a = tproBenefitsViewModel;
    }

    public final void onChanged(Object obj) {
        TproBenefitsViewModel.m10371setupMediator$lambda3$lambda2(this.f62919a, (TProMultiPlanDisplayModel) obj);
    }
}
