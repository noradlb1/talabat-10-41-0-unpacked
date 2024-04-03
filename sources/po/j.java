package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62807a;

    public /* synthetic */ j(TproBenefitsFragment tproBenefitsFragment) {
        this.f62807a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        this.f62807a.subscribedWithB2BVoucher(((Boolean) obj).booleanValue());
    }
}
