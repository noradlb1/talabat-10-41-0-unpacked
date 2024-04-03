package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62803b;

    public /* synthetic */ g(TproBenefitsFragment tproBenefitsFragment, Ref.ObjectRef objectRef) {
        this.f62802a = tproBenefitsFragment;
        this.f62803b = objectRef;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10360observeDataUpdates$lambda14$lambda9(this.f62802a, this.f62803b, (String) obj);
    }
}
