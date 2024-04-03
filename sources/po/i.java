package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62806a;

    public /* synthetic */ i(TproBenefitsFragment tproBenefitsFragment) {
        this.f62806a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10353observeDataUpdates$lambda14$lambda11(this.f62806a, (String) obj);
    }
}
