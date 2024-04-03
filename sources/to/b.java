package to;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f62917a;

    public /* synthetic */ b(TproBenefitsViewModel tproBenefitsViewModel) {
        this.f62917a = tproBenefitsViewModel;
    }

    public final void onChanged(Object obj) {
        TproBenefitsViewModel.m10369setupMediator$lambda3$lambda0(this.f62917a, (Boolean) obj);
    }
}
