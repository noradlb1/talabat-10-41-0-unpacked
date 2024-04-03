package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62801a;

    public /* synthetic */ f(TproBenefitsFragment tproBenefitsFragment) {
        this.f62801a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10359observeDataUpdates$lambda14$lambda8(this.f62801a, (Boolean) obj);
    }
}
