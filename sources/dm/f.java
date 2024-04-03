package dm;

import androidx.lifecycle.Observer;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCarrierBagManager f61941a;

    public /* synthetic */ f(DarkstoresCarrierBagManager darkstoresCarrierBagManager) {
        this.f61941a = darkstoresCarrierBagManager;
    }

    public final void onChanged(Object obj) {
        DarkstoresCarrierBagManager.m10164show$lambda0(this.f61941a, (EventWrapper) obj);
    }
}
