package ip;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProPlanSelectionFragment f62158a;

    public /* synthetic */ a(TProPlanSelectionFragment tProPlanSelectionFragment) {
        this.f62158a = tProPlanSelectionFragment;
    }

    public final void onChanged(Object obj) {
        TProPlanSelectionFragment.m10413observeDataUpdates$lambda7(this.f62158a, (Integer) obj);
    }
}
