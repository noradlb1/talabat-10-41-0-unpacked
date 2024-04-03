package to;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f62918a;

    public /* synthetic */ c(TproBenefitsViewModel tproBenefitsViewModel) {
        this.f62918a = tproBenefitsViewModel;
    }

    public final void onChanged(Object obj) {
        TproBenefitsViewModel.m10370setupMediator$lambda3$lambda1(this.f62918a, (TProOnBoardingDisplayModel) obj);
    }
}
