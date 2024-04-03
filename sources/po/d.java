package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62798b;

    public /* synthetic */ d(Ref.ObjectRef objectRef, TproBenefitsFragment tproBenefitsFragment) {
        this.f62797a = objectRef;
        this.f62798b = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10357observeDataUpdates$lambda14$lambda6(this.f62797a, this.f62798b, (TProMultiPlanDisplayModel) obj);
    }
}
