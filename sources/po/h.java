package po;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62805b;

    public /* synthetic */ h(TproBenefitsFragment tproBenefitsFragment, Ref.ObjectRef objectRef) {
        this.f62804a = tproBenefitsFragment;
        this.f62805b = objectRef;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10352observeDataUpdates$lambda14$lambda10(this.f62804a, this.f62805b, (String) obj);
    }
}
