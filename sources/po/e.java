package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62799a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62800b;

    public /* synthetic */ e(Ref.ObjectRef objectRef, TproBenefitsFragment tproBenefitsFragment) {
        this.f62799a = objectRef;
        this.f62800b = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10358observeDataUpdates$lambda14$lambda7(this.f62799a, this.f62800b, (TProOnBoardingDisplayModel) obj);
    }
}
