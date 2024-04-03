package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.ui.SplashActivity;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f63047a;

    public /* synthetic */ f(SplashActivity splashActivity) {
        this.f63047a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity.m10917getAppLaunchWithGpsLocationStatus$lambda11(this.f63047a, (GpsStatus) obj);
    }
}
