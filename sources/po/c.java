package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62796a;

    public /* synthetic */ c(TproBenefitsFragment tproBenefitsFragment) {
        this.f62796a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10356observeDataUpdates$lambda14$lambda5(this.f62796a, (SubscriptionsErrorDisplayModel) obj);
    }
}
