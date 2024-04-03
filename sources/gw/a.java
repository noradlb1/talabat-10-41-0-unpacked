package gw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatlife.ui.onBoarding.TDineOnboardingFlutterActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TDineOnboardingFlutterActivity f14083a;

    public /* synthetic */ a(TDineOnboardingFlutterActivity tDineOnboardingFlutterActivity) {
        this.f14083a = tDineOnboardingFlutterActivity;
    }

    public final void onChanged(Object obj) {
        TDineOnboardingFlutterActivity.m5831onCreate$lambda0(this.f14083a, (Failure) obj);
    }
}
