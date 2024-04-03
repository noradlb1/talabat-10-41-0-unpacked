package xm;

import androidx.lifecycle.Observer;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyDisplayModel;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationPolicyView f63017a;

    public /* synthetic */ b(CancellationPolicyView cancellationPolicyView) {
        this.f63017a = cancellationPolicyView;
    }

    public final void onChanged(Object obj) {
        CancellationPolicyView.m10219init$lambda3$lambda2$lambda1(this.f63017a, (CancellationPolicyDisplayModel) obj);
    }
}
