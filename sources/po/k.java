package po;

import androidx.lifecycle.Observer;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62808a;

    public /* synthetic */ k(TproBenefitsFragment tproBenefitsFragment) {
        this.f62808a = tproBenefitsFragment;
    }

    public final void onChanged(Object obj) {
        TproBenefitsFragment.m10354observeDataUpdates$lambda14$lambda13(this.f62808a, (Screen) obj);
    }
}
