package gw;

import androidx.lifecycle.Observer;
import com.talabat.talabatlife.ui.onBoarding.TDineOnboardingFlutterActivity;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TDineOnboardingFlutterActivity f14084a;

    public /* synthetic */ b(TDineOnboardingFlutterActivity tDineOnboardingFlutterActivity) {
        this.f14084a = tDineOnboardingFlutterActivity;
    }

    public final void onChanged(Object obj) {
        TDineOnboardingFlutterActivity.m5832onCreate$lambda1(this.f14084a, (SubscriptionPaymentDisplayModel) obj);
    }
}
