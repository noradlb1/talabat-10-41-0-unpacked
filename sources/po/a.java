package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62793a;

    public /* synthetic */ a(TproBenefitsFragment tproBenefitsFragment) {
        this.f62793a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10355observeDataUpdates$lambda14$lambda3(this.f62793a, (Throwable) obj);
    }
}
